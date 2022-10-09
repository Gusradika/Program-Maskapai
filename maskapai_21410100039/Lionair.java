package maskapai_21410100039;

public class Lionair extends Tiket {

    // auto harga
    int jumlahPenumpang, harga;
    String kotaTujuan, noPesawat, noKursi;

    public Lionair(String bookingID, String nik, String nama, String jenis_kelamin, String tglBerangkat,
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

    public static int getTicketCost(String x, String y) {
        int z = 0;
        if (x.equalsIgnoreCase(main.kota[6])) {
            if (y.equalsIgnoreCase(main.kota[0]) || y.equalsIgnoreCase(main.kota[1])) {
                z = 500000;
            }
            if (y.equalsIgnoreCase(main.kota[2]) || y.equalsIgnoreCase(main.kota[3])) {
                z = 600000;
            }
            if (y.equalsIgnoreCase(main.kota[4]) || y.equalsIgnoreCase(main.kota[5])) {
                z = 700000;
            }
        }
        if (x.equalsIgnoreCase(main.kota[2])) {
            if (y.equalsIgnoreCase(main.kota[0]) || y.equalsIgnoreCase(main.kota[1])) {
                z = 700000;
            }
            if (y.equalsIgnoreCase(main.kota[6]) || y.equalsIgnoreCase(main.kota[3])) {
                z = 750000;
            }
            if (y.equalsIgnoreCase(main.kota[4]) || y.equalsIgnoreCase(main.kota[5])) {
                z = 800000;
            }
        }
        return z;
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