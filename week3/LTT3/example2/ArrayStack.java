package week3.LTT3.example2;

public class ArrayStack<T> implements stack<T> {
    private T[] stackArray;
    private int defaultSize = 100;
    private int n = 0;

    // Khởi tạo stack với kích thước cho trước

    public ArrayStack() {
        stackArray = (T[]) new Object[defaultSize]; 
    }

    public ArrayStack(int capacity) throws Exception{
        // Hàm dựng với kích thước mảng là capacity
        if (capacity < 0) {
            throw new Exception("Capacity must be non-negative");
        }
        stackArray = (T[]) new Object[capacity];
    }

    // đẩy một phần tử vào stack
    @Override
    public void push(T data) {
        if (n >= stackArray.length) {
            T[] newArray = (T[]) new Object[stackArray.length * 2];
            for (int i = 0; i < stackArray.length; i++) {
                newArray[i] = stackArray[i];
            }
            stackArray = newArray;
        }

        stackArray[n] = data;
        n++;
    }

    // lấy ra phần tử từ stack
    @Override
    public T pop() {
        if (n < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return stackArray[n--];
    }

    // lấy ra kích thước stack
    @Override
    public int size() {
        return n;
    }

    // kiểm tra xem stack có rỗng hay không
    @Override
    public boolean isEmpty() {
        return n == -1;
    }


    @Override
    public void show() {
        for (T element : stackArray) {
            if (element != null) 
                System.out.println(element + " ");
        }
    }

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();

        arrayStack.push(10);
        arrayStack.push(20);
        arrayStack.push(30);

        arrayStack.show();

        System.out.println("Phần tử lấy ra: " + arrayStack.pop());
        System.out.println("Phần tử lấy ra: " + arrayStack.pop());

        System.out.println("Stack trống: " + (arrayStack.isEmpty() ? "Có" : "Không"));
    }


}
