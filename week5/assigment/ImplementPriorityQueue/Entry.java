package week5.assigment.ImplementPriorityQueue;

/**
 * Entry
 */
public interface Entry<K, E> {
    K getKey(); // K là khóa của phần tử 
    E getValue(); // E là giá trị phần tử
    
}
