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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How long should Supermarket Sim run? ()");
        long runTime = scanner.nextLong();

        long startTime = System.currentTimeMillis();

        CustomerFactory customerFactory = new CustomerFactory(5000, 50);
        customerFactory.start();
        cashiers.add(new Cashier());
        while(startTime + runTime > System.currentTimeMillis()) {

        }
        isRunning = false;
        System.out.println();
        System.out.println("Store is closing...");
        System.out.println();
        while(!shoppingQueue.isEmpty() && finishedCustomers.size() != totalCustomers){

        }
        if(finishedCustomers.size() == totalCustomers && store.isEmpty()) {
        System.out.println();
        System.out.println("Supermarket Sim finished with " + runTime + " total time, " + finishedCustomers.size() + " total customers, and " + cashiers.size() + " cashiers");
        }


        


    }

    public static int getAverageShopTime() {
        long sum = 0;
        int num = 0;
        if(finishedCustomers.size() == 0)
            return 0;
        for(int i = 0; i < finishedCustomers.size(); i++) {
            sum += finishedCustomers.get(i).getShopTime();
            num++;
        }

        return (int)(sum)/num;
    }





}
