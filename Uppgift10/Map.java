package Uppgift10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class Map {
    private City[] cities;
    private final int mod = 541;

    public Map(String file){

        cities = new City[mod];

        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"))){
            String line;
            while((line = br.readLine()) != null){
                //Returns a string array
                String[] row = line.split(",");
                //Add both cities to the city array through lookup
                City from = lookup(row[0]);
                City to = lookup(row[1]);
                int dist = Integer.valueOf(row[2]);
                //Connect the two cities to each other
                from.connect(to, dist);
                to.connect(from, dist);
            }
        }
        catch (Exception e){
            System.out.println(" file " + file + " not found or corrupt");
        }
    }

    //Uses the city name to get a hash number where the city will be stored
    private Integer hash(String name){
        int hash = 7;
        for (int i = 0; i < name.length(); i++){
            hash = (hash*31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }

    //Looks at the hashed index for the city
    public City lookup(String name){
        int i = hash(name);
        //Check if the city exist in the array
        while(cities[i] != null){
            if(cities[i].name.equals(name)){
                return cities[i];
            }
            //Incase is we're at the last index
            i = (i + 1) % mod;
        }

        //Else create the city for it
        cities[i] = new City(name);
        return cities[i];
    }

    public void printGraph(){
        int number = 1;
        for(int i = 0; i < mod; i++){
            if(cities[i] != null){
                System.out.println("City #" + (number++) + ": " + cities[i].name + " (index: " + i + ")");
                for(int j = 0; j < cities[i].neighbors.length; j++){
                    System.out.println("--" + cities[i].neighbors[j].city.name + ". " + cities[i].neighbors[j].distance + " min");
                }
                System.out.println();
            }
        }
    }
}
