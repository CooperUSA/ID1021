package Uppgift10;

public class Naive {
    private static Integer shortest(City from, City to, Integer max){
        if (max < 0)
            return null;

        if (from == to){
            //System.out.println("+++++++++++++++   ++++++ Found path");
            return 0;
        }
            //System.out.println("Max from " + from.name + " initial " + max);

        Integer shrt = null;
        for(int i = 0; i < from.neighbors.length; i++){
            if(from.neighbors[i] != null){
                City.Connection conn = from.neighbors[i];

                Integer temp = shortest(conn.city, to, max-conn.distance); 

                // When we find the "to" destination
                // Incase an other path is found, compare them. (Adds the distance from the prior city to this one,
                // since the current shrt already has it added).
                if(temp != null && (shrt == null || shrt > temp + conn.distance)){
                    shrt = temp + conn.distance;
                }
            }
        }
        return shrt;
    }

    public static void main(String[] args){

        Map map = new Map("C:/Users/Samuel Sendek/Desktop/Skola/År2Per1/ID1021 Algoritmer och datastruktur/Uppgifter/Uppgift10/trains.csv");

        String from = "Göteborg";
        String to = "Umeå";
        Integer max = 705;

        long t0 = System.nanoTime();
        Integer dist = shortest(map.lookup(from), map.lookup(to), max);
        long time = (System.nanoTime() - t0)/1_000_000;

        System.out.println("Shortest: " + dist + " min (" + time + " ms)");
        System.out.println("Max: " + max);
    }
}
