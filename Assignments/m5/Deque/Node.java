/*
 * Java Program to Implement Queue using Linked List
 */
import java.util.*;
/*  Class Node  */
class Node {
    protected int data;
    protected Node link;

    /*  Constructor  */
    public Node() {
        link = null;
        data = 0;
    }
    /*  Constructor  */
    public Node(int d, Node n) {
        data = d;
        link = n;
    }
    /*  Function to set link to next Node  */
    public void setLink(Node n) {
        link = n;
    }
    /*  Function to set data to current Node  */
    public void setData(int d) {
        data = d;
    }
    /*  Function to get link to next node  */
    public Node getLink() {
        return link;
    }
    /*  Function to get data from current Node  */
    public int getData() {
        return data;
    }
}

/**
 * Class for deque.
 *
 * @param      <Item>  The item
 */
class Deque {
    protected Node front, rear;
    public int size;
    /* Constructor */
    public Deque() {
        front = null;
        rear = null;
        size = 0;
    }
    /*  Function to check if queue is empty */
    public boolean isEmpty() {
        return (front == null && rear == null);
    }
    /*  Function to get the size of the queue */
    public int size() {
        return size;
    }

    public void pushleft(int data) {
        Node nptr = new Node(data, null);
        size++ ;
        if (front == null) {
            front = nptr;
            rear = front;
        } else {
            nptr.setLink(front);
            front = nptr;
        }
    }
    public void pushright(int data) {
        Node nptr = new Node(data, null);
        size++ ;
        if (rear == null) {
            rear = nptr;
            front = rear;
        } else {
            rear.setLink(nptr);
            rear = nptr;
        }
    }
    public int popleft() {
        if (isEmpty() ) {
            //System.out.println("Deck is empty");
        } else {
            Node ptr = front;
            front = ptr.getLink();
            if (front == null) {
                rear = null;
            }
            size-- ;
            return ptr.getData();
        } return -1;
    }
    public int popright() {
        if (isEmpty()) {
            //System.out.println("No elements to pop");
        } else {
            int ele = rear.getData();
            Node s = front;
            Node t = front;
            while (s != rear) {
                t = s;
                s = s.getLink();
            }
            rear = t;
            rear.setLink(null);
            size --;
            return ele;
        }
        return -1;
    }
    public void print() {
        String s = "[";
        if (size == 0)
        {
            System.out.println("[]");
            return ;
        }
        Node ptr = front;
        while (ptr != rear.getLink() )
        {
            s += ptr.getData()+", ";
            ptr = ptr.getLink();
        }
        s = s.substring(0, s.length() - 2);
        s += "]";
        System.out.println(s);
    }
}