import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customers; // Menggunakan ArrayList

    public Bank() {
        customers = new ArrayList<Customer>();
    }

    public void addCustomer(String f, String l) {
        customers.add(new Customer(f, l)); // Menambah nasabah secara dinamis
    }

    public int getNumOfCustomers() {
        return customers.size();
    }

    public Customer getCustomer(int index) {
        if (index >= 0 && index < customers.size()) {
            return customers.get(index);
        }
        return null;
    }
}