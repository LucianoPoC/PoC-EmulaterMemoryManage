package br.edu.ifc.blumenau.list;

public class Node {
    private long value;
    private char state;
    private int ponteiro;
    private Node next;
    private Node previous;

    public Node(long value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public long getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public char isState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPonteiro() {
        return ponteiro;
    }

    public void setPonteiro(int processNumber) {
        this.ponteiro = processNumber;
    }

    public char getState() {
        return state;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
