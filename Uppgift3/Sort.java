package Uppgift3;

public class Sort {

    public static boolean search_unsorted(int[] array, int key) {
        long t0 = System.nanoTime();
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                long t_find = (System.nanoTime() - t0);
                System.out.println("Time to find unsorted key: " + t_find + " ns.");
                
                return true;
            }
        }
        long t_find = (System.nanoTime() - t0);
        System.out.println("Time to find unsorted key: " + t_find + " ns.");
        return false;
    }

    public static long search_sorted(int[] array, int key) {
        long t0 = System.nanoTime();
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {   
                long t1 = (System.nanoTime() - t0);             
                return t1;
            }
            if (array[index] > key); {
                break;
            }
        }
        long t2 = (System.nanoTime() - t0);
        return t2;
    }

    public static double binary_search(int[] array, int key) {
        long t0 = System.nanoTime();
        int first = 0;
        int last = array.length-1;
        while (true) {
            // jump to the middle
            int index = (last+first)/2;
            if (array[index] == key) {
                // hmm what now?
                double t1 = (System.nanoTime() - t0);
                return t1;
            }
            if (array[index] < key && index < last) {
                // The index position holds something that is less than
                // what we're looking for, the first possible page is the next index
                first = index+1;
                continue;
            }
            if (array[index] > key && index > first) {
                // The index position holds something that is larger than
                // what we're looking for, the last possible page is the prior index?
                last =  index-1;
                continue;
            }
            // If index == (first && last), and the key is incorrect, we break.
            break;
        }
        double t2 = (System.nanoTime() - t0);
        return t2;
    }            

    public static double binary_duplicates(int[] array, int[] key) {
        double t0 = System.nanoTime();
        for(int i=0; i < key.length; i++){
            int rightKey = key[i];
            int first = 0;
            int last = array.length-1;
            while (true) {
                // jump to the middle
                int index = (last+first)/2;
                if (array[index] == rightKey) {  
                    break;
                }
                if (array[index] < rightKey && index < last) {
                    // The first possible page is at the next index
                    first = index+1;
                    continue;
                }
                if (array[index] > rightKey && index > first) {
                    // The last possible page is the prior index?
                    last = index-1;
                    continue;
                }
                // If index == (first && last), and the key is incorrect, we break.
                break;
            }
        }
        double t1 = (System.nanoTime() - t0);
        return t1;
    }      
    
    public static double better_duplicates(int[] array, int[] key) {
        double t0 = System.nanoTime();
        int index = 0;
        for(int i=0; i < key.length; i++){
            int nextKey = key[i];
            while (index < array.length) {
                if (array[index] == nextKey) { 
                    index++; 
                    break;
                }
                if (array[index] < nextKey) {
                    index++;
                    continue;
                }
                break;
            }
        }
        double t1 = (System.nanoTime() - t0);
        return t1;
    }
}
