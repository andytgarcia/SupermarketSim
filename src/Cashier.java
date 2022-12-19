
public class Cashier extends Thread{
    private Customer currentCustomer;
    private long enterTime;
    private long checkoutTime;

    private long minCheckoutTime = 3000;
    private long maxCheckoutTime = 20000;



    private boolean isOccupied;

    public Cashier(){
        this.currentCustomer = Main.shoppingQueue.poll();
        enterTime = System.currentTimeMillis();
        checkoutTime = (long)(minCheckoutTime + Math.random() * (maxCheckoutTime - minCheckoutTime));
        this.isOccupied = false;

    }

    @Override
    public void run() {

        if (currentCustomer == null) {

        }
        else {

            while (enterTime + checkoutTime > System.currentTimeMillis()) {
                System.out.println("Checking out...");
            }
            System.out.println(currentCustomer.toString() + " checked out and has left the store ");


        }

    }


    public void setOccupied(boolean occupied) {
        this.isOccupied = occupied;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
}
