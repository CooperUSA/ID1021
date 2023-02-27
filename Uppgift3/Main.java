package Uppgift3;
import java.util.*;

public class Main {
    public static void main(String[] args) { 
        //increment this
        int size = 40000;
        int[] array = new int[size];
        Random rnd = new Random();

        double time = 0;
        int loop = 100;

        //Unsorted search
        for(int j = 0; j < loop; j++){
            for(int i = 0; i < array.length; i++){
                array[i] = i;
            }
            int key = rnd.nextInt(array.length);
    
            //Sort.search_unsorted(array, key);  
        }  

        //Sorted search
        for(int j = 0; j < loop; j++){
            int[] sortArray= sorted(size);
            int key = rnd.nextInt(size);


            //time += Sort.search_sorted(sortArray, key);
        }

        //Sorted binary search
        for(int j = 0; j < loop; j++){
            int[] binaryArray= sorted(size);
            int key = rnd.nextInt(size);


            //time += Sort.binary_search(binaryArray, key);
        }

        //Sorted binary search with two arrays
        for(int j = 0; j < loop; j++){
            int[] binaryArray= sorted(size);
            int[] binaryKey= sorted(size);


            //time += Sort.binary_duplicates(binaryArray, binaryKey);
        }

        //Sorted step by step search with two arrays
        for(int j = 0; j < loop; j++){
            int[] binaryArray= sorted(size);
            int[] binaryKey= sorted(size);


            time += Sort.better_duplicates(binaryArray, binaryKey);
        }


        // Average time for searches
        System.out.println("Average time: " + (time/(loop)) + " ns");
    }

    
    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;

        for (int i = 0; i < n ; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
    }
}
