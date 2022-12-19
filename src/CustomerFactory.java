import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CustomerFactory extends Thread{
    private long timeSlice;
    private long chance;
    private long nextAttempt;
    private ArrayList<Customer> customers;

    private ConcurrentLinkedQueue<Customer> queue;

    public CustomerFactory(long timeSlice, long chance) {
        this.timeSlice = timeSlice;
        this.chance = chance;
        this.customers = Main.customers;
        nextAttempt = System.currentTimeMillis() + this.timeSlice;
        this.queue = Main.shoppingQueue;
    }


    @Override
    public void run() {
        while (true) {
            if (nextAttempt < System.currentTimeMillis()) {
                long randKey = (long)(1 + Math.random() * 100);
                if (randKey <= chance) {
                    System.out.println("Factory made customer");
                    Customer c = new Customer();
                    Main.customers.add(c);
                    c.start();
                }
                else
                    System.out.println("Did not make a customer");
                nextAttempt = System.currentTimeMillis() + timeSlice;
            }

        }
    }

}
