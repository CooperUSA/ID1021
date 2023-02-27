package UppgiftC;

public class SortArray {
    static void sort(int[] array, int low, int high){
        if (low < high){
                // printArray(array);
            //The current pivot for the next partitions
            int pivot = partition(array, low, high);

                // System.out.println("Low: " + low);
                // System.out.println("Pivot: " + pivot);
                // System.out.println("High: " + high);
                // System.out.println();
                // System.out.println();

            // Separately sort elements before partition and after partition
                // System.out.println("Array " + low + "-" + (pivot-1));
            sort(array, low, pivot - 1);
                // System.out.println("Array " + (pivot+1) + "-" + high);
            sort(array, pivot + 1, high);
        }
    }

    static int partition(int[] array, int low, int high)
    {
        int pivot = array[low];     //Pivot to move partition around
        int i = low;
        int j = high;

        while(i < j){
            while(array[i] <= pivot){
                i++;
                //Extra condition to prevent index out of bounds
                if(i == array.length){
                    i--;
                    break;
                }
            }

            while(array[j] > pivot) {
                j--;
            }

            //If i and j are stuck.
            //"<=" instad of "<". Incase if "i" got decremented since it was out of bounds and j = high
            if(i <= j){ 
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        //Place pivot at appropriate index and return it.
        array[low] = array[j];
        array[j] = pivot;
        return j;
    }

    static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.println("Index " + i + ": " + arr[i]);
        }
        System.out.println();
    }
}
