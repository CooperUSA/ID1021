package Uppgift5;


public class Main {
    public static void main(String[] args) {
        int loop = 100000;
        int a = 1000;
        int b = 8000;          
        long minList = Integer.MAX_VALUE;
        long averageList = 0;
        long minArray = Integer.MAX_VALUE;
        long averageArray = 0;
        
        //Appending lists
        LinkedList dummyList = LinkedList.makeList(a);

        for(int i = 0; i < loop; i++){
            LinkedList bigList = LinkedList.makeList(b);
            long t0 = System.nanoTime();
            bigList.append(dummyList);
            long time = (System.nanoTime() - t0);
            if(time < minList){
                minList = time;
            }
            averageList += time;
        }
        

        
        //Appending arrays
        int[] dummyArray1 = new int[a];
        int[] dummyArray2 = new int[b];
        for(int i = 0; i < a; i++){
            dummyArray1[i] = i;
        }
        for(int i = 0; i < b; i++){
            dummyArray2[i] = i;
        }

        for(int i = 0; i < loop; i++){
            long t0 = System.nanoTime();
            int[] bigArray = AppendArray.append(dummyArray1,dummyArray2);
            long time = (System.nanoTime() - t0);
            if(time < minArray){
                minArray = time;
            }
            averageArray += time;
        }
        

        System.out.println();
        System.out.println("Time to append list/array (a) of size "+ a + " to a list/array (b) of size " + b +":");
        System.out.println("List: " + (averageList/loop) + " ns. " + "Min: " + minList + " ns.");
        System.out.println("Array: " + (averageArray/loop) + " ns. " + "Min: " + minArray+ " ns.");
        


        /*
        //Create list
        LinkedList createList;

        long tCList = 0;
        for(int i = 0; i < loop; i++){
            long t0 = System.nanoTime();
            createList = LinkedList.makeList(a);
            tCList += (System.nanoTime() - t0);
        }
        System.out.println("List: " + (tCList/loop) + " ns.");
        */

        /*
        //Push and Pop
        StackList stack = new StackList();
        int test;
        System.out.println();
        System.out.println("Trying Pop and Push:");

        stack.push(2);
        stack.push(6);
        stack.push(1);
        test = stack.pop();
        test = stack.pop();
        test = stack.pop();
        test = stack.pop();
        System.out.println("Popped variable: " + test);
        */
    }
}
