package week4.assigment.extraExercise.Ex5;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> requests;

    public RecentCounter() {
        requests = new LinkedList<>();
    }

    public int ping(int t) {
        requests.offer(t);
        
        while (requests.peek() < t - 3000) {
            requests.poll();
        }
        
        return requests.size();
    }

    public static void main(String[] args) {
        RecentCounter recent = new RecentCounter();
        System.out.println(recent.ping(1));   
        System.out.println(recent.ping(100)); 
        System.out.println(recent.ping(3001));
        System.out.println(recent.ping(3002));
    }
    
}
