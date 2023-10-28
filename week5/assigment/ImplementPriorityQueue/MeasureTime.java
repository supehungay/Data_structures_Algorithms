package week5.assigment.ImplementPriorityQueue;

import java.util.Random;

public class MeasureTime {
    public static void testPriorityQueue(PriorityQueueInterface<Integer, Integer> priorityQueue, int[] values) {
        long startTime = System.currentTimeMillis();

        // Thêm phần tử vào PriorityQueue
        for (int value : values) {
            priorityQueue.insert(value, value);
        }

        long insertTime = System.currentTimeMillis() - startTime;

        // Lấy ra phần tử nhỏ nhất
        while (!priorityQueue.isEmpty()) {
            priorityQueue.removeMin();
        }

        long removeMinTime = System.currentTimeMillis() - (startTime + insertTime);

        System.out.println(priorityQueue.getClass().getSimpleName());
        System.out.println("Insert Time: " + insertTime + " ms");
        System.out.println("RemoveMin Time: " + removeMinTime + " ms");
        System.out.println();
    }

     public static void main(String[] args) {
        int n = (int) Math.pow(10, 6); // Độ dài danh sách n

        // Tạo danh sách ngẫu nhiên
        int[] values = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            values[i] = random.nextInt(n);
        }

        // Sử dụng UnsortedArrayPriorityQueue
        testPriorityQueue(new UnsortedArrayPriorityQueue<>(), values);

        // Sử dụng SortedArrayPriorityQueue
        testPriorityQueue(new SortedArrayPriorityQueue<>(), values);

        // Sử dụng UnsortedLinkedPriorityQueue
        testPriorityQueue(new UnsortedLinkedPriorityQueue<>(), values);

        // Sử dụng SortedLinkedPriorityQueue
        testPriorityQueue(new SortedLinkedPriorityQueue<>(), values);
    }
}
