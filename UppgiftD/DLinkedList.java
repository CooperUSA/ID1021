package UppgiftD;

public class DLinkedList {
    int head;
    DLinkedList next;
    DLinkedList prev;


    public DLinkedList(int item, DLinkedList tail, DLinkedList body) {
        head = item;
        next = tail;
        prev = body;
    }

    public int head() {
        return this.head;
    }
    
    public DLinkedList next() {
        return this.next;
    }

    public DLinkedList prev() {
        return this.prev;
    }

    public void append(DLinkedList b) {
        DLinkedList nxt = this;

        while (nxt.next != null) {
            nxt = nxt.next;
        }
        nxt.next = b;
        b.prev = nxt;
    }

    public static DLinkedList makeDoubleList(int n)
    {
        //Create a head node, and a representive copy of it
        DLinkedList head = new DLinkedList(0,null,null);
        DLinkedList nxt = head;

        //Connect a tail to nxt and define the tail as nxt
        for(int i = 0; i < n-1; i++){
            nxt.next = new DLinkedList(i+1, null, nxt);
            nxt = nxt.next;
        }

        return head;
    }

    public void printDoublyList(){
        DLinkedList p = this;
        while(p.next != null){
            System.out.println(p.head);
            p = p.next;
        }
        System.out.println();
        System.out.println(p.head);
        System.out.println();
        while(p.prev != null){
            p = p.prev;
            System.out.println(p.head);
        }
    }

    public DLinkedList dRemove(DLinkedList list){
        
        //If first node
        if(this.prev == null){
            list = list.next;
            this.next.prev = null;
        } 
        //If last node
        else if(this.next == null){
            this.prev.next = null; 
        }
        else{
            this.next.prev = this.prev;
            this.prev.next = this.next;
        }

        //Dereference node
        this.prev = null;
        this.next = null;
        return list;
    }

    public static DLinkedList dRemAdd(DLinkedList list, DLinkedList node){
        list = node.dRemove(list);
        node.append(list);
        list = node;
        return list;     
    }
}

    //Attempt 2
    /*
    public static DLinkedList dRemoveAdd(DLinkedList list, int[] x){
        for(int i = 0; i < x.length; i++){
            DLinkedList p = list;

            if(p.head == x[i]){
                list = list.next;
                p.next.prev = null;
                p.next = null;
                list.append(p);
                continue;
            }
    
            while(p.next != null){
                if(p.head == x[i]){
                    p.prev.next = p.next;
                    p.next.prev = p.prev;
                    p.prev = null;
                    p.next = null;
                    list.append(p);
                    continue;
                }
                p = p.next;
            }
        }

        return list;
    }
    */

    //Attempt 1
    /*
    public static DLinkedList dRemovedd(DLinkedList list, int x){
        DLinkedList p = list;
        DLinkedList temp = null;

        if(list.head == x){
            temp = p;
            list = list.next;
        }

        while(p.next != null){
            if(p.next.head == x && p.next.next != null){
                temp = p.next;
                p.next.next.prev = p;
                p.next = p.next.next;
                
            }
            p = p.next;
        }

        if(p.head != x){
            p.next = temp;
            temp.prev = p;
            temp.next = null;
        }

        return list;
    }
    */

