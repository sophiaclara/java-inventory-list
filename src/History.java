public class History {
    private String kodeBarang;
    private int jumlahStok;
    private String aksi;

    public History(String kodeBarang, int jumlahStok, String aksi) {
        this.kodeBarang = kodeBarang;
        this.jumlahStok = jumlahStok;
        this.aksi = aksi;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public String getAksi() {
        return aksi;
    }

    public int getJumlahStok() {
        return jumlahStok;
    }

    @Override
    public String toString() {
        return String.format("%-15s | %-10d | %-15s%n", kodeBarang, jumlahStok, aksi);
    }

    public static String getHeader() {
        return String.format("%-15s | %-10s | %-15s%n",
                "Kode Barang", "Jumlah Stok", "Aksi");
    }
}
