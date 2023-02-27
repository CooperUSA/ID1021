package UppgiftC;

public class SortList {
    
    public class Node {
        public int value;
        public Node next;

        public Node(int value, Node next){
            this.next = next;
            this.value = value;
        }
    }

    Node first;
    Node last;

    public SortList(){
        first = null;
        last = null;
    }

    public void add(Integer item) {
        if(first == null){
            first = new Node(item, null);
            last = first;
        }
        else{
            last.next = new Node(item, null);
            last = last.next;
        }
    }
    
    void sort(Node start, Node end){
        if (start == null || start == end)
        {
            return;
        } 
        SortList small = new SortList();
        SortList big = new SortList(); 

            // System.out.println("----------------");
            // printList();

        //Splits list
        Node pivot = partitionFirst(start, end, small, big);

            // System.out.println();
            // System.out.println("Start: " + start.value);
            // System.out.println("Pivot: " + pivot.value );
            // System.out.println("End: " + end.value);
            // System.out.println();
            // System.out.println("Small:");
            // small.printList();
            // System.out.println();
            // System.out.println("Big:");
            // big.printList();
            // System.out.println();

        //Partition the smaller list
        small.sort(small.first, small.last);
        
        //Partition the bigger list
        big.sort(big.first, big.last);

        //Resets the current list then appends 
        //the big list, the pivot and the small list
        this.first = null;
        this.last = null;
        this.append(big.first, big.last);
        this.append(pivot, pivot);
        this.append(small.first, small.last);
            // System.out.println("Final list");
            // printList();
    }       

    private Node partitionFirst(Node start, Node end, SortList small, SortList big){

        Node pivot = start;
        //Start from the node after the pivot node
        start = start.next;
        Node nxt = start;

        while(start != null){
            nxt = nxt.next;
            //If new small node, put it at the top of the small list
            if(start.value < pivot.value){
                start.next = small.first;
                small.first = start;

                //First small node is last node
                if(small.last == null){
                    small.last = start;
                }
            }
            //If new big node, put it at the top of the big list
            else{
                start.next = big.first;
                big.first = start;

                //First big node is last node
                if(big.last == null){
                    big.last = start;
                }
            }
            //Move start to the next node to reiterate
            start = nxt;
        }
        //Dereference and return pivot
        pivot.next = null;
        return pivot;
    }

    public void append(Node head, Node tail){
        //If there isn't anything to append
        if(head == null){
            return;
        }

        //If our list is empty, the new list will just be the appendé
        if(this.first == null){
            this.first = head;
        }
        else{
            this.last.next = head;
        }
        this.last = tail;  
    }

    public void printList(){
        if(first == null){
            System.out.println("empty list");
            return;  
        }
        Node p = first;
        int i = 0;

        System.out.println();
        while(p.next != null){
            i++;
            System.out.println("Node " + i + ": " + p.value);
            p = p.next;
        }
        i++;
        System.out.println("Node " + i + ": " + p.value);
    }
}

/* partition attemp with recursively splitting list
    private Node partitionFirst(Node start, Node end, SortList small, SortList big){

        if (start == end || start == null || end == null){
            return start;
        }

        Node pivot = start;
        //start = start.next;

        Node prv = start;

        
        while(start != null){
            start = start.next;
            //if new small node, make it first node in small list
            if(prv.value < pivot.value){
                prv.next = small.first;
                small.first = prv;

                //first small node is last node
                if(small.last == null){
                    small.last = prv;
                }
            }
            //if new big node, make it first node in big list
            else{
                prv.next = big.first;
                big.first = prv;

                //first big node is last node
                if(big.last == null){
                    big.last = prv;
                }
            }
            //move prv after it moved node to small/big list
            prv = start;
        }
 
        //Return pivot
        return big.last;
    }
 */


/* Test
   void sort(Node start, Node end){
        if (start == null || start == end|| start == end.next)
        {
            return;
        }  

        System.out.println("----------------");
        printList();

        // Split list and partition recurse
        Node pivot_prev = paritionLast(start, end);

        System.out.println();
        System.out.println("Start: " + start.value);
        System.out.println("Pivot_prev: " + pivot_prev.value);
        System.out.println("End: " + end.value);
        System.out.println();
        printList();
        System.out.println();


        sort(start, pivot_prev);
 
        // If pivot is picked and moved to the start,
        // that means start and pivot is same
        // so pick from next of pivot
        if (pivot_prev != null && pivot_prev == start)
            sort(pivot_prev.next, end);
 
        // If pivot is in between of the list,
        // start from next of pivot,
        // since we have pivot_prev, so we move two nodes
        else if (pivot_prev != null
                 && pivot_prev.next != null)
            sort(pivot_prev.next.next, end);
    }

    private Node paritionLast(Node start, Node end){

        if (start == end || start == null || end == null){
            return start;
        }
 
        Node pivot_prev = start;
        Node curr = start;
        int pivot = end.value;
 
        // iterate till one before the end,
        // no need to iterate till the end
        // because end is pivot
        while (start != end) {
            if (start.value < pivot) {
 

                // Moves the smaller node(start) closer to start(current)
                int temp = curr.value;
                curr.value = start.value;
                start.value = temp;

                // keep tracks of last modified item
                pivot_prev = curr;
                // move curr
                curr = curr.next;
            }
            start = start.next;
        }
 
        // Swap the position of curr i.e.
        // next suitable index and pivot
        int temp = curr.value;
        curr.value = pivot;
        end.value = temp;
 
        // Return one previous to current
        // because current is now pointing to pivot
        return pivot_prev;
    }
 */