package Uppgift8;

public class HeapArray {
    Integer[] arr;
    int k;

    public HeapArray(int size){
        arr = new Integer[size];
        k = 0;
    }

    public void add(Integer value){
        if(arr[0] == null){
            arr[0] = value;
            k++;
            return;
        }
        //Adds the new element, then calls method to sort the array
        arr[k] = value;
        addArray(k);
        k = k + 1;
    }

    public void addArray(int tK){
        Integer temp;
        while(tK > 0){
            if(tK%2 == 0){
                if(arr[tK] < arr[(tK-2)/2]){
                    temp = arr[(tK-2)/2];
                    arr[(tK-2)/2] = arr[tK];
                    arr[tK] = temp;
                }
                else{
                    break;
                }
                tK = (tK-2)/2;
            }   
            else{
                if(arr[tK] < arr[(tK-1)/2]){
                    temp = arr[(tK-1)/2];
                    arr[(tK-1)/2] = arr[tK];
                    arr[tK] = temp;
                }
                else{
                    break;
                }
                tK = (tK-1)/2;
            }
        }
    }

    public int remove(){
        //Save the first value, remove the last value and put it at the top
        int leaf = arr[0];
        k = k-1;
        arr[0] = arr[k];
        arr[k] = null;
        
    
        removeArray();

        return leaf;
    }

    public void removeArray(){
        int temp;
        int i = 0;
        //When we arrive at a leaf
        while(arr[(i*2)+2] != null && arr[(i*2)+2] != null){
            //If one of the children are null, check the other one
            if(arr[(i*2)+1] == null){
                if(arr[i] > arr[(i*2)+2]){
                    temp = arr[(i*2)+2];
                    arr[(i*2)+2] = arr[i];
                    arr[i] = temp;
                }
                i = (i*2)+2;
            }
            else if(arr[(i*2)+2] == null){
                if(arr[i] > arr[(i*2)+1]){
                    temp = arr[(i*2)+1];
                    arr[(i*2)+1] = arr[i];
                    arr[i] = temp;
                }
                i = (i*2)+1;
            }
            //Else compare the values of the children
            else{
                if(arr[(i*2)+1] <= arr[(i*2)+2]){
                    if(arr[i] > arr[(i*2)+1]){
                        temp = arr[(i*2)+1];
                        arr[(i*2)+1] = arr[i];
                        arr[i] = temp;
                    }
                    i = (i*2)+1;
                }
                else{
                    if(arr[i] > arr[(i*2)+2]){
                        temp = arr[(i*2)+2];
                        arr[(i*2)+2] = arr[i];
                        arr[i] = temp;
                    }
                    i = (i*2)+2;
                }
            }
        }

    }

    public void print(){
       for(int i = 0; i < arr.length; i++){
        System.out.println("arr[" + i + "]: " + arr[i]);
       }
    }

}
