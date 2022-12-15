import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    static ArrayList<Cashier> cashiers = new ArrayList<>();
    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        ConcurrentLinkedQueue<Customer> shoppingQueue = new ConcurrentLinkedQueue<>();

        cashiers.add(new Cashier(shoppingQueue));

        CustomerFactory customerFactory = new CustomerFactory(5000, 50, customers, shoppingQueue);

        customerFactory.start();


    }







}
