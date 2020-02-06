package main;

public class Elem<T extends Comparable> {

    private T content;
    private Elem next;

    public Elem(T content, Elem next) {
        super();
        this.content = content;
        this.next = next;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Elem getNext() {
        return next;
    }

    public void setNext(Elem next) {
        this.next = next;
    }
}
