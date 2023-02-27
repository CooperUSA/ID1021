package Uppgift2;
public class StaticStack {
    private int[] arr;
    private int pointer;
    private int capacity;
 
    // Constructor to initialize the fixed stack
    public StaticStack()
    {
        capacity = 4;
        arr = new int[capacity];
        pointer = 0;
    }

    // Utility function to add an element `x` to the stack
    public void push(int x)
    {
        if (pointer >= capacity-1)
        {
            System.out.println("Overflow\nProgram Terminated\n");
            System.exit(-1);
        }
 
        System.out.println("Inserting " + x);
        arr[++pointer] = x;
    }
 
    // Utility function to pop a top element from the stack
    public int pop()
    {
        // check for stack underflow
        if (pointer == 0)
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
 
        System.out.println("Removing ");
    
 
        // decrease stack size by 1 and (optionally) return the popped element
        return arr[pointer--];
    }

}
