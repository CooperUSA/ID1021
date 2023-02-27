package Uppgift2;
public class Main {
    //StaticStack stack;
    DynamicStack stack;
    public static void main(String[] args) { 
        
        Item[] itemArray = new Item[30];

        itemArray[0] = new Item(10,'v');
        itemArray[1] = new Item(0,'v');
        itemArray[2] = new Item(2,'v');
        itemArray[3] = new Item(9,',');
        itemArray[4] = new Item(0,'v');
        itemArray[5] = new Item(9,'+');
        itemArray[6] = new Item(0,'v');
        itemArray[7] = new Item(2,'v');
        itemArray[8] = new Item(9,',');
        itemArray[9] = new Item(9,'+');
        itemArray[10] = new Item(4,'v');
        itemArray[11] = new Item(9,'+');
        itemArray[12] = new Item(2,'v');
        itemArray[13] = new Item(2,'v');
        itemArray[14] = new Item(9,',');
        itemArray[15] = new Item(9,'+');
        itemArray[16] = new Item(4,'v');
        itemArray[17] = new Item(9,'+');
        itemArray[18] = new Item(0,'v');
        itemArray[19] = new Item(2,'v');
        itemArray[20] = new Item(9,',');
        itemArray[21] = new Item(9,'+');
        itemArray[22] = new Item(4,'v');
        itemArray[23] = new Item(9,'+');
        itemArray[24] = new Item(3,'v');
        itemArray[25] = new Item(2,'v');
        itemArray[26] = new Item(9,',');
        itemArray[27] = new Item(9,'+');
        itemArray[28] = new Item(9,'%');
        itemArray[29] = new Item(9,'-');


        Calculator HP35 = new Calculator(itemArray);
        HP35.run();
    }
}
