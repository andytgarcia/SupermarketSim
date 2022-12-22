import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Scanner;

public class Main extends Thread{
    static ArrayList<Cashier> cashiers = new ArrayList<>();
    static ConcurrentLinkedQueue<Customer> shoppingQueue = new ConcurrentLinkedQueue<>();
    static ArrayList<Customer> store = new ArrayList<>();
    static ArrayList<Customer> finishedCustomers = new ArrayList<>();
    static int totalCustomers = 0;

    static boolean isRunning = true;
    static boolean isFinishing = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How long should Supermarket Sim run? (milliseconds) ");
        long runTime = scanner.nextLong();
        System.out.print("How many cashiers would you like? ");
        int numOfcash = scanner.nextInt();
        long startTime = System.currentTimeMillis();

        CustomerFactory customerFactory = new CustomerFactory(5000, 50);
        customerFactory.start();
        for(int i = 0; i < numOfcash; i++) {
            cashiers.add(new Cashier());
        }
        while(startTime + runTime > System.currentTimeMillis()) {

        }
        isRunning = false;
        System.out.println();
        System.out.println("Store is closing...");
        System.out.println();
        isFinishing = true;
        while(!shoppingQueue.isEmpty() && finishedCustomers.size() != totalCustomers && !store.isEmpty()){

        }
        try {
            System.out.println("Finalizing...");
            Thread.sleep(9000L);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (isFinishing) {
            if ((store.isEmpty()) && totalCustomers == finishedCustomers.size()) {
                System.out.println();
                System.out.println("Supermarket Sim finished with " + runTime + " total time, " + finishedCustomers.size() + " total customers, and " + cashiers.size() + " cashiers");
                System.out.println("Average shopping time per customer: " + getAverageShopTime() + " ms");
                System.out.println("Average time in queue per customer: " + getAverageQueueTime() + " ms");
                System.out.println("Average process time per customer: " + getAverageProcessTime() + " ms");
                isFinishing = !isFinishing;

            }
        }

        


    }

    public static double getAverageShopTime() {
        long sum = 0;
        int num = 0;
        if(finishedCustomers.size() == 0)
            return 0;
        for(int i = 0; i < finishedCustomers.size(); i++) {
            sum += finishedCustomers.get(i).getShopTime();
            num++;
        }

        return (double)(sum)/num;
    }

    public static double getAverageQueueTime() {
        long sum = 0;
        int num = 0;
        if(finishedCustomers.size() == 0)
        return 0;
        for(int i = 0; i < finishedCustomers.size(); i++) {
            sum += finishedCustomers.get(i).getQueueTime();
            num++;
        }

        return (double)(sum)/num;
    }

    public static double getAverageProcessTime() {
        long sum = 0;
        int num = 0;
        if(finishedCustomers.size() == 0)
            return 0;
        for(int i = 0; i < finishedCustomers.size(); i++) {
            sum += finishedCustomers.get(i).getCheckoutTime();
            num++;
        }

        return (double)(sum)/num;
    
    }





}
