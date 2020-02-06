package main;

public class MyListImpl<T extends Comparable<T>> implements MyList {

    private Elem start;
    private Elem current;
    private int size;

    public MyListImpl() {
        super();
        start = null;
        current = start;
        size = -1;
    }

    @Override
    public void add(Comparable e) {
        Elem newElem = new Elem(e, null);
        if (start == null) {
            start = newElem;
            current = start;
        } else {
            current.setNext(newElem);
            current = newElem;
        }
        size++;
    }

    @Override
    public Comparable removeAt(int pos) {
        if (pos > size) {
            throw new ArrayIndexOutOfBoundsException("La taille est " + size + " l'élément " + pos + " n'existe pas");
        }
        Elem previous = start;
        Elem toRemove = previous;
        if (pos == 0) {
            start = start.getNext();
            //start.setNext(toRemove.getNext());
        } else {
            while (pos-- > 1) {
                previous = previous.getNext();
            }
            toRemove = previous.getNext();
            previous.setNext(toRemove.getNext());
        }
        size--;
        return toRemove.getContent();

    }

    @Override
    public Comparable removeItem(Comparable item) {
        Elem previous = null;
        Elem toRemove = start;
        boolean found = false;
        if(start != null && start.getContent().equals(item)) {
            found = true;
            toRemove = start;
            start = start.getNext();
            //start.setNext(start.getNext());
            size--;
        }
        else {
            while(!found && toRemove != null) {
                previous = toRemove;
                toRemove = toRemove.getNext();
                if(toRemove.getContent().equals(item)) {
                    found = true;
                }
            }
            previous.setNext(toRemove.getNext());
            size--;
        }
        return (toRemove == null) ? null :toRemove.getContent();
    }

    @Override
    public void setAt(Comparable item, int pos) {
        if(pos > size) {
            throw new ArrayIndexOutOfBoundsException("La taille est " + size + "l'element " + pos + "n'existe donc pas");
        }
        Elem current = start;
        while(pos-- > 0) current = current.getNext();
        current.setContent(item);

    }

    @Override
    public Comparable getAt(int pos) {
        if(pos > size) {
            throw new ArrayIndexOutOfBoundsException("La taille est " + size + "l'element " + pos + "n'existe donc pas");
        }
        Elem current = start;
        while(pos-- > 0) current = current.getNext();
        return current.getContent();
    }

    @Override
    public int getSize() {
        return size+1;
    }

    @Override
    public void reset() {
        size = -1;
        start = null;
        current = start;
    }
}
