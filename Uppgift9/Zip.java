package Uppgift9;

import java.io.BufferedReader;
import java.io.FileReader;

public class Zip {
    Node[] data;
    int max;
    int[] keys;     //Fill in order all zip codes, for hash function
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

    public Zip(String file) {
        data = new Node[100000];

        //FileReader, makes a file readable for java, BufferedReader usies different lethods to read the file
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            int i = 0;

            //Read one line at a time, splitting the information such that we can put in two Strings and an Integer
            while((line = br.readLine()) != null){
                //Returns a string array
                String[] row = line.split(",");
                //Makes the zip code string to a int
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
                i++;
            }
            max = i-1;

            //Fill keys[] with all zip codes in order
            keys = new int[max+1];
            i = 0;
            for(int j = 0; j < data.length; j++){
                if(data[j] != null){
                    keys[i++] = data[j].code;
                }
            }
        } 
        catch(Exception e){
            System.out.println(" file " + file + " not found");
        }
    }

    public boolean lookup(Integer zipCode){
        if(data[zipCode] == null){
            return false;
        }

        return true;
    }

    public void collisions(int mod){
        int[] data = new int[mod];
        int[] cols = new int[10];

        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
        }

        System.out.print(mod);
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + cols[i]);
        }
        System.out.println();
    }
    
    public Integer binarySearch(Integer zipCode){
        int first = 0;
        int last = max;
        while (true) {        
            Integer i = (last+first)/2;
            if(data[i].code == zipCode){
                return data[i].code;
            }
            if(data[i].code < zipCode && i < last){
                first = i+1;
                continue;
            }
            if(data[i].code > zipCode && i > first) {
                last =  i-1;
                continue;
            }
            // If index == (first && last), and the key is incorrect, we break.
            break;
        }
        return null;
    }
}