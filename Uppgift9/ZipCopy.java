package Uppgift9;

import java.io.BufferedReader;
import java.io.FileReader;

public class ZipCopy {
    Node[] data;
    int mod;
    public class Node {
        Integer code;
        String name;
        Integer pop;

        public Node(Integer code, String name, Integer pop){
            this.code = code;
            this.name = name;
            this.pop = pop;
        }
    }

    public ZipCopy(int size, int modulo, String file) {
        data = new Node[size];
        mod = modulo;

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;

            while((line = br.readLine()) != null){
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                Node temp = new Node(code, row[1], Integer.valueOf(row[2]));
                
                int hashInd = code % modulo;

                if(data[hashInd] == null){
                    data[hashInd] = temp;
                }
                else{
                    while(data[hashInd] != null){
                        hashInd++;
                        if(hashInd == data.length){
                            hashInd = 0;
                        }
                    }
                    data[hashInd] = temp;
                }
            }
        } 
        catch(Exception e){
            System.out.println(" file " + file + " not found");
        }
    }

    public Integer lookup(int zipCode){
        int steps = 0;
        int hashInd = zipCode % mod;
        if(data[hashInd] == null){
            return null;
        }
        else{
            while(data[hashInd] != null){
                steps++;

                if(zipCode == data[hashInd].code){
                    return steps;
                }

                hashInd++;

                if(hashInd == data.length){
                    hashInd = 0;
                }

            }
        }
        throw new Error("Zip code doesn't exist");
    }

    public void print(){
        for(int i = 0; i < data.length; i++){
            if(data[i] == null){
                System.out.println("index " + i + ": " + data[i]);
            }
            else{
                System.out.println("index " + i + ": " + data[i].code);
            }
            
        }
    }
}