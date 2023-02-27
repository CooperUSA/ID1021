package Uppgift7;

//Modified to work with BinaryTreeQ and Iterator
public class Queue {
    
    Node head;
    Node last;

    public class Node {
        public Integer item;
        public Node tail;
        //Had to add extra object so that each node in Queue had a reference to the tree
        BinaryTreeQ.Node treeNode;

        public Node(Integer item, Node list, BinaryTreeQ.Node treeNode){
            this.item = item;
            this.tail = list;
            this.treeNode = treeNode;
        }

    
        // Not funtional since BinaryTree modification
        /*To be able to printList through nodes (printList();)
        public void print() { 
            if(tail != null){
                System.out.println("Item: " + item + "\tnext node: " + tail.item);
                tail.print();
            }
            else{
                System.out.println("Item: " + item + "\tnext node: " + tail);
            }
            
        }
        */
    }

    public Queue(){
        head = null;
        last = null;
    }

    //Added a tree node so that it was easier compatible with the tree
    public void add(Integer item, BinaryTreeQ.Node tree) {
        if(head == null){
            head = new Node(item, last, tree);
            last = head;

        }
        else{
            last.tail = new Node(item, null, tree);
            last = last.tail;
        }
    }

    //Returns BinaryTreeQ Node because it was easier to move the iterator over the tree
    public BinaryTreeQ.Node remove() {
        Node temp = head;
        
        head = head.tail;
        temp.tail = null;

        return temp.treeNode;
    }

    //Useless after BinaryTree modifications
    /*Quickly make a list with nodes
    public void makeList(int n)
    {
        //add n amount of nodes to a queue.(Preferably at start)
        for(int i = 0; i < n; i++){
            add(i, null);
        }
    }
    */

    // Not funtional since BinaryTree modification
    /* Printlist through nodes
    public void printList(){
        head.print();
        System.out.println();        
    }
    */

    /* Printlist by temp pointer
    // public void printList(){
    //     Node p = head;
    //     while(p.tail != null){
    //         System.out.println("Item: " + p.item);
    //         p = p.tail;
    //     }
    //     System.out.println(p.item);
    // }
    */

    
}
