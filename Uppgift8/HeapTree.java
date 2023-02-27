package Uppgift8;
import java.util.*;

public class HeapTree {
    public class Node {
        public int value;
        public Node left, right;
        public int h;
        public int d;

        public Node(int value){
            this.value = value;
            this.left = this.right = null;
            this.h = 0;
            this.d = 0;
        }

        public void print() {
            System.out.println(" depth: " + d + ". height: " + h + ". key: " + value);
            if(left != null)
            left.print();
            if(right != null)
            right.print();
        }
    }

    Node root;

    public HeapTree(){
        root = null;
    }

    public int add(int key){
        if(root == null){
            root = new Node(key);
            root.d = 1;
            return 1;
        }

        return addTree(root, key, 1);
    }

    private int addTree(Node curr, int key, int depth){
        int tempKey;
        //If the key is smaller then then current nodes, swap values 
        if(key < curr.value){
            tempKey = curr.value;
            curr.value = key;
            key = tempKey;
        }
        else{
            depth++;
        }
         
        //Increment height
        curr.h++;

        //If there's no node to the left, and make a new node left 
        if(curr.left == null){
            curr.left = new Node(key);
            curr.left.d = curr.d + 1;
            return depth;
        }
        //If there's no node to the right, make a new node right
        else if(curr.right == null){
            curr.right = new Node(key);
            curr.right.d = curr.d + 1;
            return depth;
        }
        //If the next nodes aren't empty, compare height size
        else{
            //Go left if it's height is lower or equal to the rights height
            if(curr.left.h <= curr.right.h){
                depth = addTree(curr.left, key, depth);
            }
            else{
                depth = addTree(curr.right, key, depth);
            }
        }
        return depth;
    }

    public int remove(){
        //Throw case if empty tree
        if(root == null){
            throw new Error("Tree empty");
        }

        int tempRoot = root.value;

        //If only root node is in the tree
        if(root.h == 0){
            root = null;
            return tempRoot;
        }
 
        removeTree(root);
        return tempRoot;
    }

    private void removeTree(Node curr){
        //To end recursion
        if(curr == null){
            return;
        }
        //Decrement the height
        curr.h--;

        //If there's no node to the left,
        //copy over the right nodes value and move to it.
        if(curr.left == null){
            curr.value = curr.right.value;

            //Was the last node in the subtree
            if(curr.right.h == 0){
                curr.right = null;
            }
            removeTree(curr.right);
        }
        //If there's no node to the right, 
        //copy over the left nodes value and move to it.
        else if(curr.right == null){
            curr.value = curr.left.value;

            //Was the last node in the subtree
            if(curr.left.h == 0){
                curr.left = null;
            }
            removeTree(curr.left);
        }
        //If the next nodes aren't empty, compare node values
        else{
            //If the right nodes value is lower then the left, 
            //copy over the right nodes value and move to it.
            if(curr.right.value <= curr.left.value){
                curr.value = curr.right.value;

                //Was the last node in the subtree
                if(curr.right.h == 0){
                    curr.right = null;
                }
                removeTree(curr.right);
            }
            else{
                curr.value = curr.left.value;

                //Was the last node in the subtree
                if(curr.left.h == 0){
                    curr.left = null;
                }
                removeTree(curr.left);
            }
        }        
    }

    public int push(Integer incr){
        root.value = root.value + incr;
        int depth = 0;
        depth = pushTree(root, root.value, depth);

        return depth;
    }

    private int pushTree(Node curr, int rValue, int depth){

        //Edge case to prevent nullpointer
        if(curr.h == 0){
            curr.value = rValue;
            return ++depth;
        }
        
        //To prevent nullpointer when comparing values
        //If there's only a right node,
        if(curr.left == null){
            if(rValue > curr.right.value){
                curr.value = curr.right.value;
                depth = pushTree(curr.right, rValue, depth);
                //Update rValue when backtracking
                rValue = curr.value;
            }
        }
        ///If there's only a left node,
        else if(curr.right == null){
            if(rValue > curr.left.value){
                curr.value = curr.left.value;
                depth = pushTree(curr.left, rValue, depth);
                //Update rValue when backtracking
                rValue = curr.value;
            }
        }
        else{
            //Switches with the lowest value
            if(curr.left.value <= curr.right.value){
                if(rValue > curr.left.value){
                    curr.value = curr.left.value;
                    depth = pushTree(curr.left, rValue, depth);
                    //Update rValue when backtracking
                    rValue = curr.value;
                }
            }
            else{
                if(rValue > curr.right.value){
                    curr.value = curr.right.value;
                    depth = pushTree(curr.right, rValue, depth);
                    //Update rValue when backtracking
                    rValue = curr.value;
                }
            }
        }
        curr.value = rValue;
        return ++depth;
    }

    public void printNodes(){
        if(root == null){
            throw new Error("No Tree to print");
        }
        root.print();        
    }

    public void buildTree(int size){
        Random rnd = new Random();

        for(int i = 0; i < size; i++){
            int value = rnd.nextInt(10*size);
            add(value);
        }
    }
}
