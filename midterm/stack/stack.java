package midterm.stack;

interface stack<T> {
    void push(T data);
    T pop();
    int size();
    boolean isEmpty();
    void show();
}