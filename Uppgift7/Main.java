package Uppgift7;

public class Main {
    public static void main(String[] args) {
        /* Queue test (Won't fully work after modifications of Queue)
        Queue queue = new Queue();

        queue.makeList(6);

        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);

        queue.printList();

        queue.remove();
        queue.remove();
        queue.add(11);

        queue.printList();
        */
        /* BinaryTreeQ test*/
        BinaryTreeQ tree = new BinaryTreeQ();
        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.add(1);
        tree.add(8);
        tree.add(6);
        tree.add(3);
        tree.add(4);
        
        for(int i : tree){
            System.out.println("next value " + i);
        }
        

        // ArrayQueue array = new ArrayQueue(6);

        // array.add(0);
        // array.add(1);
        // array.add(2);
        // array.add(3);
        // array.add(4);
        // array.add(5);

        // array.remove();

        // array.add(6);

        // array.printArray();

        // array.remove();
        // array.remove();
        // array.remove();
        // array.remove();
        // array.remove();
        // array.remove();
        // array.remove();
        // array.remove();

        // array.add(70);

        // array.printArray();

        // array.add(71);
        // array.add(72);
        // array.add(73);
        // array.add(74);
        // array.add(75);

        // array.printArray();

        // array.add(76);

        // array.printArray();

        // array.remove();
        
        

         

    }
}
