package Uppgift9;

import java.io.BufferedReader;
import java.io.FileReader;

public class ZipBucket {
    Node[][] bucket;      //Double array
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

    public ZipBucket(int modulo, String file){
        mod = modulo;
        bucket = new Node[modulo][];

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            String[] row;
            Integer code;
            Node temp;

            //Read one line at a time, splitting the information such that we can put in two Strings and an Integer
            while((line = br.readLine()) != null){
                row = line.split(",");
                code = Integer.valueOf(row[0].replaceAll("\\s",""));
                //Save the zip code as a temp node
                temp = new Node(code, row[1], Integer.valueOf(row[2]));
                
                int hashInd = code % modulo;
                //Map the temp node to a index with hash function,
                //check if something is alrady mapped there.
                if(bucket[hashInd] == null){
                    bucket[hashInd] = new Node[]{temp};
                }
                else{
                    //Temp array to copy all values that have been mapped there
                    //and add the new node.
                    Node[] tmpArr = new Node[bucket[hashInd].length + 1];
                    for(int j = 0; j < bucket[hashInd].length; j++){
                        tmpArr[j] = bucket[hashInd][j];
                    }
                    tmpArr[tmpArr.length-1] = temp;
                    
                    //Make the array for this index the tmpArr, 
                    //(Its the same array as before but with the temp node added)
                    bucket[hashInd] = tmpArr;
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
        if(bucket[hashInd] == null){
            return null;
        }
        else{
            for(int i = 0; i < bucket[hashInd].length; i++){
                steps++;
                if(zipCode == bucket[hashInd][i].code){
                    return steps;
                }
            }
        }
        throw new Error("Zip code doesn't exist");
    }
}