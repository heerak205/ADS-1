import java.util.Scanner;
//import java.util.Arrays;
class Stack {
    Node first = null;
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public void push(int value) {
        Node obj = new Node(value);
        obj.next = first;
        first = obj;
    }

    public int pop() {
        int item = first.data;
        first = first.next;
        return item;
    }
    public void printLt() {
        Node node = first;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
class LinkedList {
    Node first = null;
    Node last = null;
    int size = 0;
    class Node {
        String data;
        Node next;
        Node(String data) {
            this.data = data;
        }
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void push(String element) {
        Node obj = new Node(element);
        if (isEmpty()) {
            first = obj;
            last = first;
            last.next = null;
            size++;
            return;
        }
        Node oldlast = last;
        last = obj;
        oldlast.next = last;
        last.next = null;
        size++;

    }
    public String pop() {
        if (isEmpty()) {
            return null;
        }
        String item = first.data;
        first = first.next;
        size--;
        return item;

    }
    public void printLt() {
        Node node = first;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

    }
}
class AddLargeNumbers {

    public static LinkedList numberToDigits(String number) {
        LinkedList link = new LinkedList();
        String[] data = number.split("");
        for (int i = 0; i < data.length; i++) {
            link.push(data[i]);
        }
        //System.out.println(Arrays.toString(numbers));
        return link;
    }

    public static String digitsToNumber(LinkedList list) {
        String num = "";
        while (!list.isEmpty()) {
            num += list.pop();
        }
        return num;
    }

    // public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
    // return LinkedList l;
    // }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            //LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            //System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        }
    }

}
