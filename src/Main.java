public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(); // Menggunakan Bank (ArrayList)

        // Menambahkan nasabah
        bank.addCustomer("Andi", "Pratama");
        bank.addCustomer("Dewi", "Lestari");

        // Mengambil nasabah pertama
        Customer c1 = bank.getCustomer(0);
        
        // Menambahkan akun menggunakan Customer (Array Biasa)
        c1.addAccount(new Account(7500.0));
        c1.getAccount(0).deposit(2500.0);

        // Menampilkan hasil
        System.out.println("==========================================");
        System.out.println("  SISTEM PERBANKAN (Array & ArrayList)    ");
        System.out.println("==========================================");
        System.out.println("Total Nasabah (ArrayList): " + bank.getNumOfCustomers());
        System.out.println("Nasabah Pertama          : " + c1.getFirstName() + " " + c1.getLastName());
        System.out.println("Jumlah Akun (Array Biasa): " + c1.getNumOfAccounts());
        System.out.println("Saldo Rekening Akun ke-1 : Rp " + c1.getAccount(0).getBalance());
        System.out.println("==========================================");
    }
}