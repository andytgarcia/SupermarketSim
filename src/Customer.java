import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Customer extends Thread {


    private static int nextID = 0;
    private int id;
    private long shopTime; //how long in milliseconds the customer will shop
    private long checkoutTime; //how long in milliseconds it takes for them to check out
    private long enterTime; //the time in milliseconds it takes to enter the store
    private long leaveTime; //the time in milliseconds leaves the store
    private long minShopTime = 3000;
    private long maxShopTime = 20000;

    private ConcurrentLinkedQueue<Customer> queue;

    private ArrayList<Cashier> cashiers;

    private boolean hasLeft;







    public Customer(ConcurrentLinkedQueue<Customer> queue) {
        id = nextID;
        nextID++;
        enterTime = System.currentTimeMillis();
        shopTime = (long)(minShopTime + Math.random() * (maxShopTime - minShopTime));

        this.queue = queue;
        checkoutTime = 2000;
        cashiers = Main.cashiers;
        hasLeft = false;

    }

    @Override
    public String toString() {
        return "Customer " + id;
    }


    @Override
    public void run() {
        while (enterTime + shopTime > System.currentTimeMillis()) {
            continue;
        }
        System.out.println(this.toString() + " is done shopping with shop time " + shopTime);
        queue.add(this);
        System.out.println(this.toString() + " has entered the queue");
        while (!hasLeft) {
            for (Cashier cashier : cashiers) {
                if (!cashier.isOccupied()) {
                    cashier.setOccupied(true);
                    System.out.println(this + " has begun checking out");
                    cashier.start();
                    cashier.setOccupied(false);
                    this.hasLeft = true;
                } else
                    continue;
            }
        }


        /*while (enterTime + checkoutTime > System.currentTimeMillis()) {
            continue;
        }
        System.out.println(this.toString() + " has checked out and left the store");
        queue.poll();

         */
    }
}
