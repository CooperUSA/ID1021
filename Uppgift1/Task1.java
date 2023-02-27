import java.util.*;

class Task1{
    public static void main(String[] args) { 
        int n = 10000; 
        int loops = 5; 
        double average = 0;

        for(int i=0; i < loops; i++){
            average += access(n);
        }
        average = average/loops;

        System.out.println("Average iteration time: " + average + " ns.");
    }

    private static double access(int n) {
        
        int k = 1_000_000;
        int l = n;

        Random rnd = new Random();
        
        int[] indx = new int[l];
        for (int i = 0; i < l ; i++) {
            // fill the array with dummy values (why not 1)
            indx[i] = rnd.nextInt(n);
        }

        int[] array = new int[n];
        for (int i = 0; i < n ; i++) {
            // fill the array with dummy values (why not 1)
            array[i] = i;
        }   

        int sum = 0;
        long t0 = System.nanoTime();
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < l; i++){
                // access the array with the index given by indx[i]
                // sum up the result
                sum += array[indx[i]];
            }
        }
        long t_access = (System.nanoTime() - t0);

        t0 = System.nanoTime();
        // do the same loop iteration but only do a dummy add operation
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < l; i++) {
                sum += 1;
            }
        }
        long t_dummy = (System.nanoTime() - t0);
        return ((double)(t_access - t_dummy))/((double)k*(double)l);
    }
}

    