
public class Cashier extends Thread{
    private Customer currentCustomer;
    private long enterTime;
    private long exitTime;
    

    private long minCheckoutTime = 1000;
    private long maxCheckoutTime = 10000;
    
    private long checkoutTime = (long)(minCheckoutTime + Math.random() * (maxCheckoutTime - minCheckoutTime));


    private boolean isOccupied = false;

    

    public Cashier(){
        this.start();
    }

    @Override
    public void run() {
        while(true) {
            if(isOccupied == false) {   
        if (Main.shoppingQueue.isEmpty() == false) {
            currentCustomer = Main.shoppingQueue.poll();
            isOccupied = true;
            enterTime = System.currentTimeMillis();
            currentCustomer.setEnterQueueTime(enterTime);
            }   
        }

        if(currentCustomer != null) {
            while (enterTime + checkoutTime > System.currentTimeMillis()) {
                
            }
            isOccupied = false;
            System.out.println(currentCustomer.toString() + " checked out with checkout time " + checkoutTime + " and has left the store ");
            exitTime = System.currentTimeMillis();
            currentCustomer.setLeaveQueueTime(exitTime);
            currentCustomer.setCheckoutTime(checkoutTime);
            Main.finishedCustomers.add(currentCustomer);
            currentCustomer = null;

        }

    }

    }

    public long getCheckoutTime() {
        return checkoutTime;
    }


    public void setOccupied(boolean occupied) {
        this.isOccupied = occupied;
    }

    public boolean isOccupied() {
        return isOccupied;
    }
}
