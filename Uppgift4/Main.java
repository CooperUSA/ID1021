package Uppgift4;
import java.util.*;


public class Main {
    public static void main(String[] args) { 
        int size = 10;
        int[] array = new int[size];
        int[] dummyArray = new int[size];
        Random rnd = new Random();

        int loop = 1;
        long time = 0;
        
        /*
        //Selection sort
        for(int j = 0; j < loop; j++){
            for(int i = 0; i < array.length; i++){
                array[i] = rnd.nextInt(size);
            }

            long t0 = System.nanoTime();
            Algorithm.selectionSort(array);
            time += (System.nanoTime() - t0);
        }  
        */

        /*
        //Insertion sort
        for(int j = 0; j < loop; j++){
            for(int i = 0; i < array.length; i++){
                array[i] = rnd.nextInt(size);
            }

            long t0 = System.nanoTime();
            Algorithm.insertionSort(array);
            time += (System.nanoTime() - t0);
        } 
        */

        //Merge sort
        for(int j = 0; j < loop; j++){
            for(int i = 0; i < array.length; i++){
                array[i] = 10-i;
                dummyArray[i] = rnd.nextInt(size);
            }
            
            Algorithm.mergeSort(dummyArray);

            long t0 = System.nanoTime();
            Algorithm.mergeSort(array);
            time += (System.nanoTime() - t0);
        }  

        System.out.println("Average time: " + time/loop + " ns");
    }      
}
