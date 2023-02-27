package Uppgift8;

import java.util.*;

public class PriorityList {

    Node first;
    Node last;

    public class Node {
        public int value;
        public Node next;

        public Node(int value, Node next){
            this.next = next;
            this.value = value;
        }
    }   

    public PriorityList(){
        first = null;
        last = null;
    }

    public void addO1(Integer item) {
        if(first == null){
            first = new Node(item, null);
            last = first;
        }
        else{
            Node p = first;
            first = new Node(item, p);
        }
    }

    public void addN(Integer item) {
        //If list empty
        if(first == null){
            first = new Node(item, null);
            last = first;
            return;
        }

        Node p = first;
        //special case for first node
        if(p.value >= item){
            first = new Node(item, p);

            return;
        }

        while(p.next != null){
            if(p.next.value >= item){
                Node temp = new Node(item, p.next);
                p.next = temp;
                return;
            }   
            p = p.next;
        }
        p.next = new Node(item, null);
        last = last.next;
    }

    public int removeN(){
        Node p = first;
        Node small = p;

        while(p.next != null){
            if(small.next.value > p.next.value){
                small = p;
            }
            p = p.next;
        }

        //Reuse p as temp pointer
        //Special case for the first node
        if(first.value < small.next.value){
            p = first;
            first = p.next;
            p.next = null;
        }
        else{
        p = small.next;
        small.next = p.next;
        p.next = null;
        }
        

        return small.value;
    }

    public int removeO1(){
        Node p = first;
        this.first = this.first.next;
        p.next = null;

        return p.value;
    }

    //If true create a list with O(n):Add and O(1):Remove,
    //else create a list with O(1):Add and O(n):Remove
    public void makeRndListAddN(int size, boolean AddN){
        Random rnd = new Random();

        if(AddN){
            for(int i = 0; i < size; i++){
                this.addN(rnd.nextInt(size*10));
            }
        }
        else{
            for(int i = 0; i < size; i++){
                this.addO1(rnd.nextInt(size*10));
            }
        }
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
