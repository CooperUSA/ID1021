package Uppgift10;

public class Paths {

    City[] path;
    int sp;

    public Paths(){
        path = new City[54];
        sp = 0;
    }

    private Integer shortest(City from, City to, Integer max){ 
        if((max != null) && (max < 0)){
            return null;
        }

        if (from == to){
            //System.out.println("+++++++++++++++   ++++++ Found path");
            return 0;
        }

        for (int i = 0; i < sp; i++) {
            if (path[i] == from)
                return null;
        }

        path[sp++] = from;
        Integer shrt = null;
        for(int i = 0; i < from.neighbors.length; i++){
            if(from.neighbors[i] != null){
                City.Connection conn = from.neighbors[i];
                Integer temp;

                if(max != null){
                    temp = shortest(conn.city, to, max-conn.distance); 
                }
                else{
                    temp = shortest(conn.city, to, null); 
                }

                if(temp != null && (shrt == null || shrt > temp + conn.distance)){
                    shrt = temp + conn.distance;
                    if(max == null){
                        max = temp - conn.distance;
                    }
                    else{
                        max -= temp - conn.distance;
                    }
                }
            }
        }
        path[sp--] = null;
        return shrt;
    }
    
    public static void main(String[] args){
        Map map = new Map("C:/Users/Samuel Sendek/Desktop/Skola/År2Per1/ID1021 Algoritmer och datastruktur/Uppgifter/Uppgift10/trains.csv");
        Paths path = new Paths();

        String from = "Malmö";
        String to = "Kiruna";
        Integer max = null;

        long t0 = System.nanoTime();
        Integer dist = path.shortest(map.lookup(from), map.lookup(to), max);
        long time = (System.nanoTime() - t0)/1_000;

        System.out.println("Shortest: " + dist + " min (" + time + " mikrosekunder)");
        System.out.println("Max: " + max);
    }
}
    
