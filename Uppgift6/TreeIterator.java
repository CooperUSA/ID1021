package Uppgift6;
import java.util.*;
import Uppgift6.BinaryTree.Node;

public class TreeIterator implements Iterator<Integer>{
    private Node next;
    private Stack<Node> stack;

    public TreeIterator(Node root){
        stack = new Stack<Node>();
        
        //Start at the root if it exists, and push it to the stack
        next = root;
        if(next == null){
            return;
        }

        //We walk as far left as possible and push every node unto the stack
        while(next.left != null){
            stack.push(next);
            next = next.left;
        }
    }

    //Return true if there is no next node to the left
    @Override
    public boolean hasNext(){
        boolean flag = true;
        if(next == null){
            flag = false;
        }
        
    return flag;
    }

    @Override
    public Integer next() {
        if(!hasNext()) {
            throw new NoSuchElementException();
        }
        Node r = next;

        // If you can walk right, walk right, then fully left.
        // otherwise, walk up until you come from left.
        if(next.right != null){
            stack.push(next);
            next = next.right;
            while (next.left != null){
                stack.push(next);
                next = next.left;
            }    
            return r.value;
        }

        while(true){
            if(stack.empty()){
                next = null;
                return r.value;
            }
            if(stack.peek().left == next){
                next = stack.pop();
                return r.value;
            }
            next = stack.pop();
        }
    }

    @Override
    public void remove() {
    throw new UnsupportedOperationException();
    }
}
