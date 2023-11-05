package midterm.linkedlist;

/**
 * Interface
 */
public interface InterfaceLinkedList<T> {

    public void add(T data);
    public void addBot(T data);
    public T get(int i) throws Exception;
    public void set(int i, T data) throws Exception;
    public boolean isContain(T data);
    public int size();
    public boolean isEmpty();
    public T removeTop() throws Exception;
    public T removeBot();
    public void remove(T data) throws Exception;
}