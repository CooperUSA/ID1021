package Uppgift5;

public class AppendArray {

    public static int[] append(int[] a, int[] b){
        int sizeA = a.length;
        int sizeB = b.length;

        int[] bigArray = new int[sizeA + sizeB];        
        for(int i = 0; i < sizeB; i++){
            bigArray[i] = b[i];
        }
        for(int i = 0; i < sizeA; i++){
            bigArray[sizeB+i] = a[i];
        }    
        return bigArray;
    }
}

/* Mindre effektiv algoritm för att appenda ihop två arrays
        for(int i = 0; i < sizeA+sizeB; i++){
            if(i < sizeA){
                bigArray[i] = a[i];
            }
            else{
                bigArray[i] = b[i-sizeA];
            } 
        } 
 */
