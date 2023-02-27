package Uppgift7;

public class ArrayQueue {
    Integer[] arrayQueue;
    int size;       //Size
    int index = 0;  //Index for start of queue
    int k = 0;      //Index for first free slot

    
    public ArrayQueue(int size){
        this.size = size;
        arrayQueue = new Integer[size]; 
    }

    public void add(int item){
        //Check to see if the first free slot isn't on the same index as the start of the queue
        if(arrayQueue[k] == null){
            arrayQueue[k] = item;
            System.out.println("Added: " + item);
        }
        //Otherwise makes a twice as big array and transfer over all the values
        else{
            System.out.println("Array full, allocating a bigger array.");
            Integer[] temp = new Integer[size*2];

            for(int i = 0; i < size; i++){
                temp[i] = arrayQueue[index++];
                
                if(index == size){
                    index = 0;
                }
            }
            arrayQueue = temp;
            size = size*2;
            index = 0;
            k = size/2;
            System.out.println("Finished.");

            arrayQueue[k] = item;
            System.out.println("Added: " + item);        
        }

        //Check if the first free slot isn't on the last index of the array
        if(k < size-1){
            k++;
        }
        else{
            k = 0;
        }

        //Extra warning
        if(k == index){
            System.out.println("Warning, full array\n");
        }
    }
    
    public Integer remove(){
        Integer temp;

        //If the start of the queue is null, return null. 
        if(arrayQueue[index] == null){
            System.out.println("Array already empty\n");
            return null;
        }
        //Otherwise remove and return the element from the start of the queue
        else{
            temp = arrayQueue[index];

            System.out.println("Removing " + temp + " from array.");
            arrayQueue[index] = null;
        }

        //Check if the first spot of the queue isn't on the last index of the array
        if(index < size-1){
            index++;
            if(index == k){
                System.out.println("Warning, array now empty\n");
            }
        }
        else{
            index = 0;
        }

        return temp;
    }

    public void printArray(){
        System.out.println("-----Array-----");
        for(int i = 0; i < size; i++){
            System.out.println("Value at array[" + i + "]:" + arrayQueue[i]);
        }
        System.out.println("---------------");
    }
}
