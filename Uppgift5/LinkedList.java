package Uppgift5;

public class LinkedList {
    int head;
    LinkedList tail;

    public LinkedList(int item, LinkedList list) {
        head = item;
        tail = list;
    }

    public int head() {
        return this.head;
    }
    
    public LinkedList tail() {
        return this.tail;
    }

    public void append(LinkedList b) {
        LinkedList nxt = this;

        while (nxt.tail != null) {
            nxt = nxt.tail;
        }
        nxt.tail = b;
    }

    public static LinkedList makeList(int n)
    {
        //Create a head node, and a representive copy of it
        LinkedList head = new LinkedList(1,null);
        LinkedList nxt = head;

        //Connect a tail to nxt and define the tail as nxt
        for(int i = 1; i < n; i++){
            nxt.tail = new LinkedList(i+1, null);
            nxt = nxt.tail;
        }

        return head;
    }
}
