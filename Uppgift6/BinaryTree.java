package Uppgift6;
import java.util.*;

public class BinaryTree implements Iterable<Integer>{
    
    public class Node {
        public Integer key;
        public Integer value;
        public Node left, right;

        public Node(Integer key, Integer value){
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }
        
        public void print() {
            if(left != null)
            left.print();
            System.out.println(" key: " + key + "\tvalue: " + value);
            if(right != null)
            right.print();
        }
    }

    public Iterator<Integer> iterator() {
        return new TreeIterator(this.root);
    }

    Node root;
    Random rnd = new Random();

    public BinaryTree(){
    root = null;
    }

    public void add(Integer key, Integer value){
        root = addTree(root, key, value);
    }

    private Node addTree(Node current, Integer key, Integer value){
        //If we have no key here
        if(current == null){
            current = new Node(key, value);
            return current;
        }
        //If the key is the same as the current node, change the value
        if(key == current.key){
            current.value = value;
        }
        //If the key is smaller then then current nodes, go to the left node
        else if(key < current.key){
            current.left = addTree(current.left, key, value);
        }
        //If the key is bigger then then current nodes, go to the right node
        else if(key > current.key){
            current.right= addTree(current.right, key, value);
        }
        
        return current;
    }
    
    public Integer lookup(Integer key){
        return findKey(root, key);
    }

    private Integer findKey(Node current, Integer key){

        //If the this node has our key, return the nodes value.
        if(key == current.key){
            return current.value;
        }
        //If the searched key is smaller then this nodes key and there is a node to the left, search the node to the left.
        else if(key < current.key && current.left != null){
            return findKey(current.left, key);
        }
        //If the searched key is bigger then this nodes key and there is a node to the right, search the node to the right.
        else if(key > current.key && current.right != null){
            return findKey(current.right, key);
        }
        return null;
    }

    //Print tree
    public void printNodes(){
        root.print();        
    }

    //Build up a random tree
    public void buildTree(int n){
        add(n/2, rnd.nextInt(10*n));

        for(int i = 0; i < n; i++){
            int key = rnd.nextInt(10*n);
            int value = rnd.nextInt(10*n);
            
            add(key, value);
        }
    }
}
