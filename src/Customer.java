public class Customer extends Thread {


    private static int nextID = 0;
    private int id;
    private long shopTime; //how long in milliseconds the customer will shop
    private long enterTime; //the time in milliseconds it takes to enter the store
    private long leaveTime; //the time in milliseconds leaves the store
    private long minShopTime = 3000;
    private long maxShopTime = 20000;




    public Customer() {
        id = nextID;
        nextID++;
        enterTime = System.currentTimeMillis();
        shopTime = (long)(minShopTime + Math.random() * (maxShopTime - minShopTime));

    

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
        Main.shoppingQueue.add(this);
        System.out.println(this.toString() + " has entered the queue");
        Main.store.remove(this);
        
       


        /*while (enterTime + checkoutTime > System.currentTimeMillis()) {
            continue;
        }
        System.out.println(this.toString() + " has checked out and left the store");
        queue.poll();

         */
    }

    public long getShopTime() {
        return shopTime;
    }
}
