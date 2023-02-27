package Uppgift8;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int loop = 500;     //loop < size
        int size = 1024;
        Random rnd = new Random();

        //Create a tree, with 64 nodes
        HeapTree tree1 = new HeapTree();
        HeapTree tree2 = new HeapTree();
        for(int i = 0; i < size; i++){
            tree1.add(rnd.nextInt(101));
            tree2.add(rnd.nextInt(101));
        }


        int[] pu = new int[loop];
        //push nodes for loop amounts
        for(int i = 0; i < loop; i++){
            int item = rnd.nextInt(11) + 10;

            pu[i] = tree1.push(item);
        }
        for(int i = 1; i <= 11; i++){
            int depth = 0;
            for(int j = 0; j < loop; j++){
                if(pu[j] == i){
                  depth++;  
                }
            }
            System.out.println("# of push with depth " + i + ": " + depth);
        }

        int[] remAdd = new int[loop];
        //loop amounts of remove then loop amounts of add (remember check tree size)
        for(int i = 0; i < loop; i++){
            remAdd[i] = tree2.remove() + rnd.nextInt(11) + 10;
            
        }
        for(int i = 0; i < loop; i++){
            remAdd[i] = tree2.add(remAdd[i]);
        }
        for(int i = 1; i <= 11; i++){
            int depth = 0;
            for(int j = 0; j < loop; j++){
                if(remAdd[j] == i){
                  depth++;  
                }
            }
            System.out.println("# of Remove/Add with depth " + i + ": " + depth);
        }


        // HeapArray arr = new HeapArray(size);

        // arr.add(2);
        // arr.add(3);
        // arr.add(4);
        // arr.add(5);
        // arr.add(6);
        // arr.add(7);
        
        // arr.print();
        // System.out.println();
        // arr.add(1);
        // arr.print();

        // System.out.println();
        // System.out.println(arr.remove());
        // arr.print();

        /* List benchmark
        // for(int incrSize = 0; incrSize < 5; incrSize++){
        //     System.out.println("---------------");

        //     long t0 = 0;
        //     long t1 = 0;
        //     long timeOn;
        //     long timeO1;
        //     Random rnd = new Random();

        //     //Create lists and fill with random numbers
        //     PriorityList listAddO1 = new PriorityList();
        //     PriorityList listAddN = new PriorityList();
        //     listAddO1.makeRndListAddN(size, false);
        //     listAddN.makeRndListAddN(size, true);

        //     t0 = System.nanoTime();
        //     for(int i = 0; i < loop; i++){
        //         int item = rnd.nextInt(size*10);

        //         listAddN.addN(item);
        //         listAddN.removeO1();
        //     }
        //     timeOn = (System.nanoTime() - t0)/loop;

        //     t1 = System.nanoTime();
        //     for(int i = 0; i < loop; i++){
        //         int item = rnd.nextInt(size*10);

        //         listAddO1.addO1(item);
        //         listAddO1.removeN();
        //     }
        //     timeO1 = (System.nanoTime() - t1)/loop;
            
        //     System.out.println("Runtime for " + size + " element list with O(n) add: " + timeOn + " ns. ");
        //     System.out.println("Runtime for " + size + " element list with O(1) add: " + timeO1 + " ns. ");

        //     //Double the size
        //     System.out.println();
        //     size = size*2;
        // }
        */
    }
}
