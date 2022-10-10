package maskapai_21410100039;

public class Lionair extends Tiket {

    // auto harga
    int jumlahPenumpang, harga;
    String kotaTujuan, noPesawat, noKursi;

    // BookingID, nik, nama, JenisKelamin, tgl berangkat, tgl Kembali, Kota asal,
    // kotaTujuan, noPesawat, noKursi
    // Jumlah Penumpang, harga, Kota tujuan,
    public Lionair(String bookingID, String nik, String nama, String jenis_kelamin, String tglBerangkat,
            String tglKembali,
            String kotaAsal, String kotaTujuan, String noPesawat, String noKursi) {
        super(bookingID, nik, nama, jenis_kelamin, tglBerangkat, tglKembali, kotaAsal);
        this.kotaTujuan = kotaTujuan;
        this.noPesawat = noPesawat;
        this.noKursi = noKursi;
        this.harga = getTicketCost(kotaAsal, kotaTujuan);
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

    @Override
    public String jenis_kelamin() {
        return super.jenis_kelamin();
    }

    // Override
    @Override
    public String getBookingID() {
        return super.getBookingID();
    }

    public void cetakSemuaData() {
        // Booking ID, NIK, Nama, jk, kota asal, kota tujuan, tgl berangkat, tgl
        // kembali, no pesawat, kursi, harga tiket
        style.cetakSpasi(2);
        System.out.println(style.GREEN_BG + "#### Detail Tiket ####" + style.RESET);
        System.out.println("Booking ID : " + getBookingID());
        System.out.println("NIK : " + getNik());
        System.out.println("Nama : " + getNama());
        System.out.println("Jenis Kelamin : " + jenis_kelamin());
        System.out.println("Kota Asal : " + kotaAsal());
        System.out.println("Kota Tujuan : " + kotaTujuan());
        System.out.println("Tgl Berangkat : " + tglBerangkat());
        System.out.println("Tgl Kembali : " + tglKembali());
        System.out.println("No Pesawat : " + noPesawat());
        System.out.println("No Kursi : " + noKursi());
        System.out.println("Harga : " + getHarga());
    }
}