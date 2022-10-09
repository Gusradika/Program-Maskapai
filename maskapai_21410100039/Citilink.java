package maskapai_21410100039;

public class Citilink extends Tiket {

    // auto harga
    int jumlahPenumpang, harga;
    String kotaTujuan, noPesawat, noKursi;

    public Citilink(String bookingID, String nik, String nama, String jenis_kelamin, String tglBerangkat,
            String tglKembali,
            String kotaAsal, int jumlahPenumpang, int harga, String kotaTujuan, String noPesawat, String noKursi) {
        super(bookingID, nik, nama, jenis_kelamin, tglBerangkat, tglKembali, kotaAsal);
        this.jumlahPenumpang = jumlahPenumpang;
        this.harga = harga;
        this.kotaTujuan = kotaTujuan;
        this.noPesawat = noPesawat;
        this.noKursi = noKursi;
    }

    // Getter
    public int getJumlahPenumpang() {
        return jumlahPenumpang;
    }

    public int getHarga() {
        return harga;
    }

    public String kotaTujuan() {
        return kotaTujuan;
    }

    public String noPesawat() {
        return noPesawat;
    }

    public String noKursi() {
        return noKursi;
    }

    // Override
    @Override
    public String getBookingID() {
        return super.getBookingID();
    }

    public void cetakSemuaData() {
        // Booking ID, NIK, Nama, Harga, noKursi
        System.out.println("Booking ID : " + super.getBookingID() + " NIK : " + super.getNik() + " Booking ID baru : "
                + getBookingID());
    }
}