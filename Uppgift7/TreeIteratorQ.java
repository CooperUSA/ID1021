package Uppgift7;
import java.util.*;

public class TreeIteratorQ implements Iterator<Integer>{
    //Two objects, Queue and Node from BinaryTree
    //To be able to navigate through the tree
    private BinaryTreeQ.Node next;
    //To be able too add to the queue
    private Queue queue;

    public TreeIteratorQ(BinaryTreeQ.Node root){
        queue = new Queue();
        
        //Start at the root if it exists
        next = root;
        if(next == null){
            return;
        }
    }

    //Return true if there is no next node
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
        BinaryTreeQ.Node r = next;


        if(next.left != null){
            queue.add(next.left.key, next.left);
        }
        if(next.right != null){
            queue.add(next.right.key, next.right);
        }
        if(queue.head == null){
            next = null;
            return r.key;
        }
        next = queue.remove();
        return r.key;
    }

    @Override
    public void remove() {
    throw new UnsupportedOperationException();
    }
}
