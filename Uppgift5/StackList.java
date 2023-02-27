package Uppgift5;

public class StackList {
    private LinkedList top;


    // Constructor to initialize the stack
    public StackList()
    {
        this.top = null; 
    }

    // Utility function to add an element `x` to the stack
    public void push(int x)
    { 
        System.out.println("Inserting " + x);
        LinkedList temp = new LinkedList(x,top);
        top = temp;
    }
 
    // Utility function to pop a top element from the stack
    public int pop()
    { 
        // check for stack underflow
        if (top == null)
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
        int x = top.head(); 
        // decrease stack size by 1 and (optionally) return the popped element
        top = top.tail;
        System.out.println("Removing ");
        
        return x;
    }
}
