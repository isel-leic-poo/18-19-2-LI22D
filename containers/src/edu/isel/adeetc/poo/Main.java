package edu.isel.adeetc.poo;


public class Main {

    public static void main(String[] args) {
        // TODO:
        LinkedList llist = new LinkedList();
        llist.addFirst(5);
        llist.addFirst(12);
        llist.addFirst(4);

        for (int idx = 0; idx < llist.size(); idx++) {
            int elem = llist.get(idx);
            System.out.print(elem + " ");
        }
        System.out.println("SLB, O MAIOR!!");
    }
}
