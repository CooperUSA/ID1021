package Uppgift4;
import java.util.*;

public class Algorithm {

    public static void selectionSort(int[] array){
        for (int i = 0; i < array.length -1; i++) {
            // let's set the first candidate to the index itself
            int cand = i;
            for (int j = i; j < array.length ; j++) {
            // If the element at position j is smaller than the value
            // at the candidate position - then you have a new candidate
            // posistion.
                if(array[j] < array[i]){
                    cand = j;
                }
            }
            // Swap the item at position i with the item at the candidate position.
            array[i] = cand;
        }
    }

    public static void insertionSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int cand = array[i];
            // for each element from i towards 1, swap the item found with the
            // item before it if it is smaller
            for (int j = i; j > 0 && array[j-1] > cand; j--) {
                array[j] = array[j-1];
                array[j-1] = cand;
            }
        }
    }

    public static void mergeSort(int[] org) {
        if (org.length == 0)
        return;
        int[] aux = new int[org.length];
        mergeSort(org, aux, 0, org.length-1);
    } 

    private static void mergeSort(int[] org, int[] aux, int lo, int hi) {
        if (lo != hi) {
            int mid = (hi+lo)/2;
            System.out.println("Low: "+lo);
            System.out.println("Mid: "+mid);
            System.out.println("High: "+hi);
            System.out.println();

        // sort the items from lo to mid
            mergeSort(org, aux, lo, mid);
        // sort the items from mid+1 to hi
            mergeSort(org, aux, mid+1, hi);
        // merge the two sections using the additional array
            mergeMerge(org, aux, lo, mid, hi);
        }
    }

    private static void mergeMerge(int[] org, int[] aux, int lo, int mid, int hi) {
        // copy all items from lo to hi from org to aux
        for(int i = lo; i <= hi; i++) {
            aux[i] = org[i];
        }
        // let's do the merging
        int i = lo; // the index in the first part
        int j = mid+1; // the index in the second part
        
        // for all indeces from lo to hi
        for (int k = lo; k <= hi; k++) {
        // if i is greater than mid, move the j item to the org array, update j
            if(i > mid){
                org[k] = aux[j++];
            }
        // else if j is greate than hi, move the i item to the org array, update i
            else if(j > hi){
                org[k] = aux[i++];
            }
        // else if the i item is smaller than the j item,
        // move it to the org array, update i
            else if(aux[i] < aux[j]){
                org[k] = aux[i++]; 
            }
        // else you can move the j item to the org array, update j
            else {
                org[k] = aux[j++];
            }
        }
        System.out.println(Arrays.toString(org));
    }      
}

