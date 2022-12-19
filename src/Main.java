import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    static ArrayList<Cashier> cashiers = new ArrayList<>();
    static ConcurrentLinkedQueue<Customer> shoppingQueue = new ConcurrentLinkedQueue<>();

    static ArrayList<Customer> customers = new ArrayList<>();
    public static void main(String[] args) {


        cashiers.add(new Cashier());

        CustomerFactory customerFactory = new CustomerFactory(5000, 50);

        customerFactory.start();


    }







}
