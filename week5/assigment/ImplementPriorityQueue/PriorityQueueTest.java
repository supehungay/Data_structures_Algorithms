package week5.assigment.ImplementPriorityQueue;

public class PriorityQueueTest {

    public static class Product {
        private String name;
        private int price;

        public Product(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public int getKey() {
            return price;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }
    }

    public static void testIntegerPriorityQueue() {
        System.out.println("Testing Integer PriorityQueue:");

        PriorityQueueInterface<Integer, Integer> intQueue = new UnsortedArrayPriorityQueue<>();
        intQueue.insert(3, 300);
        intQueue.insert(1, 100);
        intQueue.insert(2, 200);

        while (!intQueue.isEmpty()) {
            Entry<Integer, Integer> entry = intQueue.removeMin();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }

    public static void testProductPriorityQueue() {
        System.out.println("Testing Product PriorityQueue:");

        PriorityQueueInterface<Integer, Product> productQueue = new SortedLinkedPriorityQueue<>();

        Product product1 = new Product("Laptop", 800);
        Product product2 = new Product("Smartphone", 500);
        Product product3 = new Product("Tablet", 300);

        productQueue.insert(product1.getKey(), product1);
        productQueue.insert(product2.getKey(), product2);
        productQueue.insert(product3.getKey(), product3);

        while (!productQueue.isEmpty()) {
            Entry<Integer, Product> entry = productQueue.removeMin();
            Product product = entry.getValue();
            System.out.println("Product: " + product.getName() + ", Price: $" + product.getPrice());
        }
    }
    
    public static void main(String[] args) {
        testIntegerPriorityQueue();
        testProductPriorityQueue();
    }
}
