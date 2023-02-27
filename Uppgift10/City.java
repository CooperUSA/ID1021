package Uppgift10;

public class City {
    String name;
    Connection[] neighbors;

    public class Connection {
        City city;
        Integer distance;

        public Connection(City city, Integer distance){
            this.city = city;
            this.distance = distance;
        }
    }

    public City(String name){
        this.name = name;
        this.neighbors = null;
    }

    public void connect(City next, int dist){
        if(neighbors == null){
            neighbors = new Connection[1];
            neighbors[0] = new Connection(next, dist);
        }
        else{
            Connection[] temp = new Connection[neighbors.length + 1];
            for(int i = 0; i < neighbors.length; i++){
                temp[i] = neighbors[i];
            }
            temp[neighbors.length] = new Connection(next, dist);
            neighbors = temp;

        }
        
    }
}