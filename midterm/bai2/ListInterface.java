package midterm.bai2;

/**
 * linkedlistinterface
 */
public interface ListInterface<T>  extends Iterable<T>{
    public void add (T data );
    public T get ( int i );
    public int size ();
    public boolean isEmpty ();
}