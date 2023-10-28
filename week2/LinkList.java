package week2;

public class LinkList {

    static class Node{
        private int data;
        private Node next;

        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        // public Node(int data, Node node) {
        //     this.data = data;
        //     this.next = node;
        // }


        public int getData() {
            return data;
        } 

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node node) {
            next = node;
        }

        public void insertData(int data){
            Node newNode = new Node(data);
            this.next = newNode;
        }

        public void printInfo() {
            
            while (true) {
                
            }
        }
    }

    public static void main(String[] args) {
        Node node =  new Node(0);
        node.insertData(1);
        node.insertData(2);
        node.insertData(3);
        node.insertData(4);
        node.insertData(5);
    }
}
