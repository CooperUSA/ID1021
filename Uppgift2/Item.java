package Uppgift2;
public class Item {
    private ItemType type;
    private int value = 0;

    public enum ItemType {
        ADD,
        SUB,
        MUL,
        DIV,
        VALUE,
        MOD,
        WEIRD
    }

    public Item(int value, char type)
    {
        this.value = value;
        switch(type){
            case '+':
            this.type = ItemType.ADD;
            break;
            case '-':
            this.type = ItemType.SUB;
            break;
            case '*':
            this.type = ItemType.MUL;
            break;
            case '/':
            this.type = ItemType.DIV;
            break;
            case '%':
            this.type = ItemType.MOD;
            break;
            case ',':
            this.type = ItemType.WEIRD;
            break;
            case 'v':
            this.type = ItemType.VALUE;
            break;
        }
    }

    public ItemType type(){
        return this.type;
    }

    public int value(){
        return this.value;
    }
}
