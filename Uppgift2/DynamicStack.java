package Uppgift2;
public class DynamicStack {
    private int[] arr;
    private int pointer;
    private int capacity;
 
    // Constructor to initialize the fixed stack
    public DynamicStack()
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
            int[] newArr = new int[capacity + 8];
            for(int i = 1; i < capacity; i++){
                newArr[i] = arr[i];
            }

            arr = newArr;
            capacity += 8;
            System.out.println("Increase array size");
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
        // Last index of the smaller array - 2 
        if (pointer <= (capacity - 8 - 1 - 2))
        {
            int[] newArr = new int[capacity - 8];
            for(int i = 1; i < capacity - 8; i++){
                newArr[i] = arr[i];
            }

            arr = newArr;
            capacity -= 8;
            System.out.println("Deacreased array size");
        }
 
        System.out.println("Removing ");
    
 
        // decrease stack size by 1 and (optionally) return the popped element
        return arr[pointer--];
    }
}
