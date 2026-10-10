public class Customer {
    private String firstName;
    private String lastName;
    private Account[] accounts;       // Menggunakan Array Biasa
    private int numOfAccounts;

    public Customer(String f, String l) {
        firstName = f;
        lastName = l;
        accounts = new Account[5];    // Kapasitas tetap
        numOfAccounts = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void addAccount(Account acct) {
        if (numOfAccounts < accounts.length) {
            accounts[numOfAccounts++] = acct;
        }
    }

    public Account getAccount(int account_index) {
        if (account_index >= 0 && account_index < numOfAccounts) {
            return accounts[account_index];
        }
        return null;
    }

    public int getNumOfAccounts() {
        return numOfAccounts;
    }
}
