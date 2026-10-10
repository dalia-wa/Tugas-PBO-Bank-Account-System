# 🏦 Tugas PBO – Sistem Perbankan (Array & ArrayList)

Repository ini berisi tugas mata kuliah **Pemrograman Berorientasi Objek (PBO)** berupa program Java yang memodelkan sistem perbankan sederhana menggunakan kombinasi **Array Statis (Fixed-size Array)** dan **ArrayList Dinamis**.

Studi kasus ini menggunakan hierarki kelas `Bank`, `Customer`, dan `Account`. Program ini mendemonstrasikan bagaimana pengelolaan data nasabah dapat ditangani secara dinamis menggunakan `ArrayList`, sementara data rekening nasabah dibatasi menggunakan array berukuran tetap sesuai dengan spesifikasi modul praktikum.

Dokumen ini memuat struktur proyek, penjelasan kode setiap kelas, cara menjalankan program, serta tangkapan layar hasil eksekusinya.

## 👤 Identitas

| Data | Keterangan |
|---|---|
| 👤 **Nama** | [Nama Lengkap Kamu] |
| 🆔 **NIM** | [NIM Kamu] |
| 🏫 **Kelas** | 3A |
| 📘 **Mata Kuliah** | Pemrograman Berorientasi Objek (PBO) |
| 👨‍🏫 **Dosen Pengampu** | Royana Afwani, S.T., M.T. |

---

## 📑 Daftar Isi

1. [📖 Deskripsi Program](#-1-deskripsi-program)
2. [📁 Struktur Proyek](#-2-struktur-proyek)
3. [💻 Penjelasan Kode](#-3-penjelasan-kode)
4. [▶️ Cara Menjalankan](#️-4-cara-menjalankan)
5. [📸 Hasil Program (Screenshot)](#-5-hasil-program-screenshot)
6. [✅ Kesimpulan](#-6-kesimpulan)

---

## 📖 1. Deskripsi Program

Program ini dibuat untuk mempraktikkan penggabungan berbagai struktur data koleksi dalam Pemrograman Berorientasi Objek, khususnya:
- **Array Statis (`Account[]`)**: Digunakan di dalam kelas `Customer` untuk membatasi jumlah maksimum rekening yang dapat dimiliki oleh seorang nasabah (kapasitas tetap).
- **ArrayList (`ArrayList<Customer>`)**: Digunakan di dalam kelas `Bank` agar daftar nasabah yang terdaftar dapat bertambah secara fleksibel dan dinamis tanpa batasan ukuran awal.

**🧩 Rancangan Kelas**
- **`Account`**: Menyimpan atribut saldo (`balance`) beserta method dasar seperti `deposit()` untuk menyetor uang dan `withdraw()` untuk menarik uang.
- **`Customer`**: Menyimpan informasi data diri nasabah (`firstName`, `lastName`) serta mengelola daftar rekening menggunakan **Array Statis** dengan kapasitas tetap.
- **`Bank`**: Mengelola sekumpulan data nasabah menggunakan **`ArrayList`** agar daftar nasabah bank bersifat dinamis.
- **`Main`**: Kelas utama yang menguji alur kerja program mulai dari inisialisasi bank, penambahan nasabah, pembuatan rekening, hingga transaksi saldo.

---

## 📁 2. Struktur Proyek
.
├── src/
│   ├── Account.java
│   ├── Customer.java
│   ├── Bank.java
│   └── Main.java
├── .gitignore
└── README.md

### 🔗 Hubungan Keterkaitan Kelas (Class Relationship)
Bank (Menggunakan ArrayList<Customer>)
└── Customer (Menggunakan Array Account[])
    └── Account (Menyimpan Saldo & Transaksi)

---

## 💻 3. Penjelasan Kode

### 💳 3.1 `Account.java` (Kelas Rekening)
```java
public class Account {
    private double balance;

    public Account(double init_balance) {
        balance = init_balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amt) {
        if (amt > 0) {
            balance += amt;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amt) {
        if (balance >= amt && amt > 0) {
            balance -= amt;
            return true;
        }
        return false;
    }
}

👤 3.2 Customer.java (Menggunakan Array Statis)
public class Customer {
    private String firstName;
    private String lastName;
    private Account[] accounts;       // Menggunakan Array Biasa
    private int numOfAccounts;

    public Customer(String f, String l) {
        firstName = f;
        lastName = l;
        accounts = new Account[5];    // Kapasitas tetap maksimal 5 akun
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

🏦 3.3 Bank.java (Menggunakan ArrayList Dinamis)
import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customers; // Menggunakan ArrayList

    public Bank() {
        customers = new ArrayList<Customer>();
    }

    public void addCustomer(String f, String l) {
        customers.add(new Customer(f, l));
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

🚀 3.4 Main.java (Kelas Pengujian Utama)
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

▶️ 4. Cara Menjalankan
⚙️ Prasyarat: Pastikan JDK (Java Development Kit) sudah terpasang di perangkatmu.

# 1. Clone repository
git clone [https://github.com/USERNAME_KAMU/Tugas-PBO-Bank-Account-System.git](https://github.com/USERNAME_KAMU/Tugas-PBO-Bank-Account-System.git)
cd Tugas-PBO-Bank-Account-System

# 2. Compile semua file di dalam folder src
javac src/*.java

# 3. Jalankan program utama
java -cp src Main

📸 5. Hasil Program (Screenshot)
🖥️ Output Eksekusi Program
(Lampirkan atau unggah screenshot terminal hasil run program kamu ke bagian ini)

✅ 6. Kesimpulan
Array Statis (Account[]) sangat efektif digunakan pada kelas Customer untuk membatasi kapasitas maksimal kepemilikan rekening nasabah secara spesifik dan terstruktur.

ArrayList (ArrayList<Customer>) memberikan fleksibilitas tinggi pada kelas Bank sehingga penambahan jumlah nasabah dapat dilakukan secara dinamis tanpa batasan kapasitas awal.

Kombinasi struktur data array dan ArrayList dalam pemodelan objek perbankan menunjukkan penerapan prinsip enkapsulasi dan manajemen data yang efisien dalam Pemrograman Berorientasi Objek.
