package maskapai_21410100039;

public class Tiket {
    private String bookingID, nik, nama, jenis_kelamin, tglBerangkat, tglKembali, kotaAsal;

    public Tiket(String bookingID, String nik, String nama, String jenis_kelamin, String tglBerangkat,
            String tglKembali,
            String kotaAsal) {
        this.bookingID = bookingID;
        this.nik = nik;
        this.nama = nama;
        this.jenis_kelamin = jenis_kelamin;
        this.tglBerangkat = tglBerangkat;
        this.tglKembali = tglKembali;
        this.kotaAsal = kotaAsal;
    }

    // Getter
    public String getBookingID() {
        return bookingID;
    }

    public String getNik() {
        return nik;
    }

    public String getNama() {
        return nama;
    }

    public String jenis_kelamin() {
        return jenis_kelamin;
    }

    public String tglBerangkat() {
        return tglBerangkat;
    }

    public String tglKembali() {
        return tglKembali;
    }

    public String kotaAsal() {
        return kotaAsal;
    }

}
