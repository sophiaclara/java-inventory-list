import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Stock {
    private List<ArrayList<ArrayList<String>>> dataBarang;
    private List<String> dataKategori;
    private List<History> historyEntries;

    public Stock() {
        dataBarang = new ArrayList<ArrayList<ArrayList<String>>>();
        dataKategori = new ArrayList<>();
        historyEntries = new ArrayList<>();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        int menu;
        System.out.println("\nSelamat Datang !");
        do {
            System.out.println("\n********** Menu **********");
            System.out.println("0. Keluar");
            System.out.println("1. Manajemen Kategori");
            System.out.println("2. Manajemen Barang");
            System.out.println("3. Manajemen Stok");
            System.out.println("4. History");
            System.out.print("\nPilih menu: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Pilihan tidak valid. Silakan pilih menu yang sesuai !");
                System.out.print("\nPilih menu: ");
                scanner.next();
            }
            menu = scanner.nextInt();
            scanner.nextLine();

            switch (menu) {
                case 1:
                    menuKategori(scanner);
                    break;
                case 2:
                    menuBarang(scanner);
                    break;
                case 3:
                    menuStok(scanner);
                    break;
                case 4:
                    lihatHistory();
                    break;
                case 0:
                    System.out.println("\nTerima kasih. Sampai jumpa!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang sesuai.");
                    break;
            }
        } while (menu != 0);
    }

    private void menuKategori(Scanner scanner) {
        int submenu;
        do {
            System.out.println("\n********** Menu Kategori **********");
            System.out.println("1. Tambah Kategori");
            System.out.println("2. Hapus Kategori");
            System.out.println("3. Update Kategori");
            System.out.println("0. Kembali");
            System.out.print("\nPilih submenu: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Pilihan tidak valid. Silakan pilih submenu yang sesuai !");
                System.out.print("\nPilih submenu: ");
                scanner.next();
            }
            submenu = scanner.nextInt();
            scanner.nextLine();

            switch (submenu) {
                case 1:
                    tambahKategori(scanner);
                    break;
                case 2:
                    hapusKategori(scanner);
                    break;
                case 3:
                    updateKategori(scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih submenu yang sesuai.");
                    break;
            }
        } while (submenu != 0);
    }

    private void menuBarang(Scanner scanner) {
        int submenu;
        do {
            System.out.println("\n********** Menu Barang **********");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Cari Barang");
            System.out.println("3. Update Nama Barang");
            System.out.println("0. Kembali");
            System.out.print("\nPilih submenu: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Pilihan tidak valid. Silakan pilih submenu yang sesuai !");
                System.out.print("\nPilih submenu: ");
                scanner.next();
            }
            submenu = scanner.nextInt();
            scanner.nextLine();

            switch (submenu) {
                case 1:
                    tambahBarang(scanner);
                    break;
                case 2:
                    cariBarang(scanner);
                    break;
                case 3:
                    updateBarang(scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih submenu yang sesuai.");
                    break;
            }
        } while (submenu != 0);
    }

    private void menuStok(Scanner scanner) {
        int submenu;
        do {
            System.out.println("\n********** Menu Stok **********");
            System.out.println("1. Tambah Stok");
            System.out.println("2. Kurangi Stok");
            System.out.println("3. Lihat Stok");
            System.out.println("0. Kembali");
            System.out.print("\nPilih submenu: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Pilihan tidak valid. Silakan pilih submenu yang sesuai !");
                System.out.print("\nPilih submenu: ");
                scanner.next();
            }
            submenu = scanner.nextInt();
            scanner.nextLine();

            switch (submenu) {
                case 1:
                    tambahStok(scanner);
                    break;
                case 2:
                    kurangiStok(scanner);
                    break;
                case 3:
                    lihatStok();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih submenu yang sesuai.");
                    break;
            }
        } while (submenu != 0);
    }

    private void tambahKategori(Scanner scanner) {
        System.out.println("\n********** Tambah Kategori **********");
        System.out.print("Nama Kategori: ");
        String namaKategori = scanner.next();
        if (!dataKategori.contains(namaKategori)) {
            dataKategori.add(namaKategori);
            dataBarang.add(new ArrayList<>()); // Tambah ArrayList kosong untuk kategori baru
            System.out.println("Kategori berhasil ditambahkan.");
        } else {
            System.out.println("Kategori sudah ada.");
        }
    }

    private void hapusKategori(Scanner scanner) {
        System.out.println("\n********** Hapus Kategori **********");
        System.out.print("Nama Kategori: ");
        String namaKategori = scanner.next();
        int kategoriIndex = dataKategori.indexOf(namaKategori);
        if (kategoriIndex != -1) {
            dataKategori.remove(kategoriIndex);
            dataBarang.remove(kategoriIndex);
            System.out.println("Kategori berhasil dihapus beserta barang-barangnya.");
        } else {
            System.out.println("Kategori tidak ditemukan.");
        }
    }

    private void updateKategori(Scanner scanner) {
        System.out.println("\n********** Update Kategori **********");
        System.out.print("Nama Kategori Lama: ");
        String kategoriLama = scanner.next();
        int kategoriIndex = dataKategori.indexOf(kategoriLama);
        if (kategoriIndex != -1) {
            System.out.print("Nama Kategori Baru: ");
            String kategoriBaru = scanner.next();
            dataKategori.set(kategoriIndex, kategoriBaru);
            System.out.println("Kategori berhasil diupdate.");
        } else {
            System.out.println("Kategori tidak ditemukan.");
        }
    }

    private void tambahBarang(Scanner scanner) {
        System.out.println("\n********** Tambah Data Barang **********");

        if (dataKategori.isEmpty()) {
            System.out.println("Belum ada kategori yang tersedia. Harap tambahkan kategori terlebih dahulu.");
            return;
        }

        System.out.println("Daftar Kategori:");
        for (String kategori : dataKategori) {
            System.out.println("- " + kategori);
        }

        System.out.print("Pilih Kategori: ");
        String kategori = scanner.next();
        scanner.nextLine();

        if (!dataKategori.contains(kategori)) {
            System.out.println("Kategori tidak ditemukan. Harap pilih kategori yang tersedia.");
            return;
        }

        System.out.print("Nama Barang: ");
        String namaBarang = scanner.nextLine();

        // Memeriksa apakah nama barang sudah ada di dalam kategori yang sama
        int kategoriIndex = dataKategori.indexOf(kategori);
        for (List<String> barang : dataBarang.get(kategoriIndex)) {
            if (barang.get(2).equalsIgnoreCase(namaBarang)) {
                System.out.println("Barang dengan nama " + namaBarang + " sudah ada di dalam kategori " + kategori + ".");
                return;
            }
        }

        int stok = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Stok: ");
            if (scanner.hasNextInt()) {
                stok = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Stok harus berupa angka !");
                scanner.next();
            }
        }

        if (stok >= 0) {
            if (kategoriIndex == -1) {
                dataKategori.add(kategori);
                dataBarang.add(new ArrayList<>());
                kategoriIndex = dataKategori.indexOf(kategori);
            }

            String kodeBarang = generateKodeBarang(namaBarang);
            ArrayList<String> barang = new ArrayList<>();
            barang.add(kodeBarang);
            barang.add(kategori);
            barang.add(namaBarang);
            barang.add(String.valueOf(stok));

            dataBarang.get(kategoriIndex).add(barang);

            // Tambahkan informasi ke history
            tambahHistory(kodeBarang, stok, "+");
            System.out.println("\nBarang berhasil ditambahkan.");
            lihatStok();
        } else {
            System.out.println("Stok barang tidak boleh kurang dari 0.");
        }
    }

    private void cariBarang(Scanner scanner) {
        System.out.println("\n********** Cari Barang **********");
        System.out.print("Masukkan Nama Barang: ");
        String namaBarang = scanner.nextLine();

        boolean foundBarang = false;
        System.out.println("==================================================================================");
        System.out.printf("| %-15s | %-20s | %-30s | %-10s |\n", "Kode Barang", "Kategori", "Nama Barang", "Stok");
        System.out.println("==================================================================================");

        for (List<ArrayList<String>> kategoriBarangList : dataBarang) {
            for (List<String> barang : kategoriBarangList) {
                if (barang.get(2).toLowerCase().contains(namaBarang.toLowerCase())) {
                    String kodeBarang = barang.get(0);
                    String kategori = barang.get(1);
                    String nama = barang.get(2);
                    String stok = barang.get(3);

                    System.out.printf("| %-15s | %-20s | %-30s | %-10s |\n", kodeBarang, kategori, nama, stok);
                    foundBarang = true;
                }
            }
        }

        if (!foundBarang) {
            System.out.println("Barang dengan nama " + namaBarang + " tidak ditemukan.");
        }

        System.out.println("==================================================================================");
    }

    private void updateBarang(Scanner scanner) {
        System.out.println("\n********** Update Nama Barang **********");
        System.out.print("Masukkan Kode Barang: ");
        String kodeBarang = scanner.next();
        kodeBarang = kodeBarang.toUpperCase(); // Mengubah menjadi uppercase untuk pencocokan case-insensitive
        scanner.nextLine(); // Membaca karakter newline yang tersisa

        boolean foundBarang = false;
        for (List<ArrayList<String>> kategoriBarangList : dataBarang) {
            for (List<String> barang : kategoriBarangList) {
                if (barang.get(0).equalsIgnoreCase(kodeBarang)) { // Menggunakan equalsIgnoreCase untuk pencocokan case-insensitive
                    System.out.print("Masukkan Nama Barang Baru: ");
                    String namaBarangBaru = scanner.nextLine();
                    barang.set(2, namaBarangBaru);
                    System.out.println("Nama barang berhasil diupdate.");
                    foundBarang = true;
                    break;
                }
            }
            if (foundBarang) {
                break;
            }
        }

        if (!foundBarang) {
            System.out.println("Barang dengan kode " + kodeBarang + " tidak ditemukan.");
        }
    }

    private void tambahStok(Scanner scanner) {
        System.out.println("\n===== Tambah Stok Barang =====");
        System.out.print("Masukkan Kode Barang: ");
        String kodeBarang = scanner.next();
        kodeBarang = kodeBarang.toUpperCase(); // Mengubah menjadi uppercase untuk pencocokan case-insensitive

        boolean foundBarang = false;
        for (List<ArrayList<String>> kategoriBarangList : dataBarang) {
            for (List<String> barang : kategoriBarangList) {
                if (barang.get(0).equalsIgnoreCase(kodeBarang)) { // Menggunakan equalsIgnoreCase untuk pencocokan case-insensitive
                    int jumlahTambah = 0;
                    boolean validInput = false;
                    while (!validInput) {
                        System.out.print("Jumlah Stok yang Ditambahkan: ");
                        if (scanner.hasNextInt()) {
                            jumlahTambah = scanner.nextInt();
                            if (jumlahTambah > 0) {
                                validInput = true;
                            } else {
                                System.out.println("Jumlah stok harus lebih dari 0 !");
                            }
                        } else {
                            System.out.println("Jumlah harus berupa angka !");
                            scanner.next();
                        }
                    }

                    int stokSekarang = Integer.parseInt(barang.get(3));
                    int stokBaru = stokSekarang + jumlahTambah;
                    barang.set(3, String.valueOf(stokBaru));
                    System.out.println("Stok barang berhasil ditambahkan.");
                    tambahHistory(barang.get(0), jumlahTambah, "+");

                    foundBarang = true;
                    break;
                }
            }
            if (foundBarang) {
                break;
            }
        }

        if (!foundBarang) {
            System.out.println("Kode barang tidak ditemukan.");
        }
    }

    private void kurangiStok(Scanner scanner) {
        System.out.println("\n********** Kurangi Stok Barang **********");
        System.out.print("Masukkan Kode Barang: ");
        String kodeBarang = scanner.next();
        kodeBarang = kodeBarang.toUpperCase(); // Mengubah menjadi uppercase untuk pencocokan case-insensitive

        boolean foundBarang = false;
        for (List<ArrayList<String>> kategoriBarangList : dataBarang) {
            for (List<String> barang : kategoriBarangList) {
                if (barang.get(0).equalsIgnoreCase(kodeBarang)) { // Menggunakan equalsIgnoreCase untuk pencocokan case-insensitive
                    int stokSekarang = Integer.parseInt(barang.get(3));
                    int jumlahKurang = 0;
                    boolean validInput = false;
                    while (!validInput) {
                        System.out.print("Jumlah Stok yang Dikurangi: ");
                        if (scanner.hasNextInt()) {
                            jumlahKurang = scanner.nextInt();
                            if (jumlahKurang > 0) {
                                validInput = true;
                            } else {
                                System.out.println("Jumlah stok harus lebih dari 0 !");
                            }
                        } else {
                            System.out.println("Stok harus berupa angka.");
                            scanner.next();
                        }
                    }

                    int stokBaru = stokSekarang - jumlahKurang;
                    while (stokBaru < 0) {
                        System.out.println("Stok barang tidak boleh kurang dari 0. Silakan masukkan kembali.");
                        System.out.print("Jumlah Stok yang Dikurangi: ");
                        jumlahKurang = scanner.nextInt();
                        stokBaru = stokSekarang - jumlahKurang;
                    }

                    barang.set(3, String.valueOf(stokBaru));
                    System.out.println("Stok barang berhasil dikurangi.");
                    tambahHistory(barang.get(0), jumlahKurang, "-");

                    foundBarang = true;
                    break;
                }
            }
            if (foundBarang) {
                break;
            }
        }

        if (!foundBarang) {
            System.out.println("Kode barang tidak ditemukan.");
        }
    }

    private void lihatStok() {
        System.out.println("\n********** Stok Barang Berdasarkan Riwayat **********");
        System.out.printf("%-15s | %-15s | %-25s | %-5s%n",
                "Kode Barang", "Kategori", "Nama Barang", "Stok");
        System.out.println("-----------------------------------------------------");


        HashMap<String, Integer> accumulatedChanges = new HashMap<>();


        for (History historyEntry : historyEntries) {
            String kodeBarang = historyEntry.getKodeBarang();
            int jumlahStok = historyEntry.getJumlahStok();
            String aksi = historyEntry.getAksi();

            int change = aksi.equals("+") ? jumlahStok : -jumlahStok;

            accumulatedChanges.put(kodeBarang, accumulatedChanges.getOrDefault(kodeBarang, 0) + change);
        }


        for (List<ArrayList<String>> kategoriBarangList : dataBarang) {
            for (List<String> barang : kategoriBarangList) {
                String kodeBarang = barang.get(0);
                String kategori = barang.get(1);
                String namaBarang = barang.get(2);

                int accumulatedChange = accumulatedChanges.getOrDefault(kodeBarang, 0);
                int stok = accumulatedChange;


                if (stok < 0) {
                    stok = 0;
                }

                System.out.printf("%-15s | %-15s | %-25s | %-5d%n",
                        kodeBarang, kategori, namaBarang, stok);
            }
        }
        System.out.println("-------------------------------------------------");
    }

    private int runningNumber = 1;

    private String generateKodeBarang(String namaBarang) {
        String kodeHuruf = namaBarang.substring(0, Math.min(3, namaBarang.length())).toUpperCase();
        String generatedKodeBarang = kodeHuruf + runningNumber;
        runningNumber++;

        return generatedKodeBarang;
    }

    private void tambahHistory(String kodeBarang, int jumlahStok, String aksi) {
        History historyEntry = new History(kodeBarang, jumlahStok, aksi); // Menghilangkan faktor penggandaan
        historyEntries.add(historyEntry);
    }
    private void lihatHistory() {
        System.out.println("\n********** Riwayat Perubahan Stok Barang **********");
        System.out.print(History.getHeader());
        for (History entry : historyEntries) {
            System.out.print(entry);
        }
    }
}