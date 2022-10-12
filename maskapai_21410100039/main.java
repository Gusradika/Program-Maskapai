package maskapai_21410100039;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class main {

    public static String[] kota = { "Bali", "Lombok", "Jakarta", "Yogyakarta", "Balikpapan", "Makassar", "Surabaya" };
    public static String[] maskapai = { "Lionair", "Citilink" };

    public static String BookingID, nik, nama, JenisKelamin, tglBerangkat, tglKembali, KotaAsal, kotaTujuan,
            noPesawat, noKursi;

    static SimpleDateFormat day = new SimpleDateFormat("dd");
    static SimpleDateFormat full = new SimpleDateFormat("dd/MM/yyyy");
    static Date date = new Date();

    static String currentDD = (day.format(date)), inputan;
    static String currentDate = (full.format(date));
    static int jumlah = 0, total = 0;

    public static int DD = Integer.parseInt(currentDD), YY = 2022, temp2 = 0, temp3 = 0, temp4 = 0;
    public static String MM = "Oktober", dateC = DD + "/" + MM + "/" + YY;

    static Vector v = new Vector<Integer>();
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        style.cetakSpasi(4);
        int temp = 0;
        for (int i = 0; i < maskapai.length; i++) {
            System.out.println("Generating Date for maskapai : " + style.YELLOW + maskapai[i] + style.RESET);
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < kota.length; k++) {
                    temp = (int) (Math.random() * 10) + 1;
                    if ((((j == 0 && i == 0) || (j == 1 && i == 0)) && k != 6)
                            || (((j == 0 && i == 1) || (j == 1 && i == 1)) && k != 2)) {
                        if (temp > 30) {
                            temp = DD;
                        } else {
                            temp += DD;
                        }
                        v.add(temp);
                    }
                }
            }
            System.out.println("Progress => |" + style.GREEN_BG + "___________________" + style.RESET + "| 100%");
            style.cetakSpasi(2);
        }
        System.out.print("Masukan Jumlah Penumpang : ");
        jumlah = Integer.parseInt(br.readLine());

        menu();
    }

    public static void menu() {

        Citilink cl[] = new Citilink[jumlah];
        Lionair la[] = new Lionair[jumlah];

        int input = 0;
        // Bali = 0, lmbk = 1, jkrt = 2, Yogyakarta = 3, balikpapan = 4, makassar = 5,
        // surabaya = 6

        try {
            do {
                do {
                    style.cetakSpasi(2);
                    total = 0;
                    System.out.println("#################################");
                    System.out.println(style.CYAN_BG + "#### Program Pemesanan Tiket ####" + style.RESET);
                    System.out.println("#################################");
                    System.out.println(style.GREEN_U + "I Gusti Ngurah Aditya Kesuma - 21410100039" + style.RESET);
                    System.out.println("Date : " + currentDate);
                    // System.out.println("Vector : " + v);
                    style.cetakSpasi(1);
                    System.out.println("[1]. Pesan Tiket");
                    System.out.println("[2]. Cek Ketersediaan Rute");
                    System.out.println("[3]. Cek Invoices");
                    System.out.println("[4]. Exit");
                    style.cetakSpasi(1);
                    System.out.print("Pilih Inputan " + style.RED + " [4 = Exit] : " + style.RESET);
                    input = Integer.parseInt(br.readLine());
                    if (input < 1 || input > 4) {
                        style.cetakSpasi(1);
                        System.err.println(style.RED_BG + "<ERROR> INPUTAN SALAH! <ERROR>" + style.RESET);
                    }
                } while (input < 1 || input > 4);

                switch (input) {

                    // Pesan Tiket
                    case 1:
                        boolean ulang = true;
                        do {
                            style.cetakSpasi(2);
                            System.out.println("########################");
                            System.out.println(style.CYAN_BG + "#### 1. Pesan Tiket ####" + style.RESET);
                            System.out.println("########################");
                            style.cetakSpasi(1);
                            System.out.println("Pilih Kota keberangkatan : ");
                            System.out.println("[1]. Surabaya");
                            System.out.println("[2]. Jakarta");
                            System.out.println("[3]. Semarang");
                            System.out.println("[4]. Pekanbaru");
                            style.cetakSpasi(1);
                            System.out.print("Masukan inputan " + style.RED + " [0 = Back] : " + style.RESET);
                            inputan = br.readLine();
                            if (inputan.equalsIgnoreCase("0")) {
                                style.cetakSpasi(2);
                                System.out.println(style.CYAN_BG + "Back" + style.RESET);
                                style.cetakSpasi(1);
                                menu();
                            }
                            if (inputan.equalsIgnoreCase("1") || inputan.equalsIgnoreCase("Surabaya")) {
                                String kotaAsal = "Surabaya";
                                temp2 = 1;
                                ulang = false;
                            } else if (inputan.equalsIgnoreCase("2") || inputan.equalsIgnoreCase("Jakarta")) {
                                String kotaAsal = "Jakarta";
                                temp2 = 2;
                                ulang = false;
                            } else if (inputan.equalsIgnoreCase("3") || inputan.equalsIgnoreCase("Semarang")) {
                                temp2 = 3;
                                ulang = true;
                            } else if (inputan.equalsIgnoreCase("4") || inputan.equalsIgnoreCase("Pekanbaru")) {
                                temp2 = 4;
                                ulang = true;
                            } else {
                                style.cetakSpasi(1);
                                System.out.println(style.RED_BG + "<ERROR> Inputan SALAH! <ERROR>" + style.RESET);

                            }
                            if (temp2 > 0) {
                                cekKetersediaan(temp2);
                            }
                            if (temp2 == 3 || temp2 == 4) {
                                System.out.println(
                                        style.RED_BG + "<ERROR> Penerbangan Tidak Tersedia <ERROR>" + style.RESET);
                            }
                        } while (ulang);

                        do {
                            System.out.print("Pilih Maskpai [Lionair / Citilink] " + style.RED + "[0 = Back] : "
                                    + style.RESET);
                            inputan = br.readLine();
                            if (inputan.equalsIgnoreCase("0")) {
                                menu();
                            }
                            if (inputan.equalsIgnoreCase("Lionair")) {
                                temp3 = 1;
                            } else if (inputan.equalsIgnoreCase("Citilink")) {
                                temp3 = 2;
                            } else {
                                temp3 = 0;
                                System.out.println(style.RED_BG + "<ERROR> Inputan SALAH! <ERROR>" + style.RESET);
                            }
                        } while (temp3 == 0);

                        do {
                            System.out.print("Pilih Kota Tujuan  " + style.RED + "[0 = Back] : "
                                    + style.RESET);
                            inputan = br.readLine();
                            if (inputan.equalsIgnoreCase("0")) {
                                menu();
                            }
                            if (inputan.equalsIgnoreCase("Bali")) {
                                temp4 = 1;
                            } else if (inputan.equalsIgnoreCase("Lombok")) {
                                temp4 = 2;
                            } else if (inputan.equalsIgnoreCase("Jakarta") && temp2 != 2) {
                                temp4 = 3;
                            } else if (inputan.equalsIgnoreCase("Yogyakarta")) {
                                temp4 = 4;
                            } else if (inputan.equalsIgnoreCase("Balikpapan")) {
                                temp4 = 5;
                            } else if (inputan.equalsIgnoreCase("Makassar")) {
                                temp4 = 6;
                            } else if (inputan.equalsIgnoreCase("Surabaya") && temp2 != 1) {
                                temp4 = 7;
                            } else {
                                temp4 = 0;
                                System.out.println(style.RED_BG + "<ERROR> Inputan SALAH! <ERROR>" + style.RESET);
                            }
                        } while (temp4 == 0);
                        if (temp3 == 1) {

                            System.out.println("####################################");
                            System.out.println(style.CYAN_BG + "#### SELAMAT DATANG DI LION AIR ####" + style.RESET);
                            System.out.println("####################################");

                            System.out
                                    .println("Tanggal Berangkat : " + decryptDate() + "/" + MM + "/" + YY);
                            tglBerangkat = decryptDate() + "/" + MM + "/" + YY;
                            style.cetakSpasi(2);
                            System.out.println("Silahkan isi data penumpang ");
                            for (int i = 0; i < jumlah; i++) {
                                System.out.print("Entry Booking ID : ");
                                BookingID = br.readLine();
                                System.out.print("Entry NIK : ");
                                nik = br.readLine();
                                System.out.print("Entry Nama : ");
                                nama = br.readLine();
                                System.out.print("Entry Jenis kelamin (P/L) : ");
                                JenisKelamin = br.readLine();
                                System.out.print("Entry No Pesawat : ");
                                noPesawat = br.readLine();
                                System.out.print("Entry Tgl Kembali : ");
                                tglKembali = br.readLine();
                                System.out.print("Entry Kota Asal : ");
                                KotaAsal = br.readLine();
                                System.out.print("Entry Kota Tujuan : ");
                                kotaTujuan = br.readLine();
                                System.out.print("Entry No Kursi : ");
                                noKursi = br.readLine();
                                style.cetakSpasi(1);
                                // BookingID, nik, nama, JenisKelamin, tgl berangkat, tgl Kembali, Kota asal,
                                // kotaTujuan, noPesawat, noKursi
                                // Jumlah Penumpang, harga, Kota tujuan,
                                la[i] = new Lionair(BookingID, nik, nama, JenisKelamin, tglBerangkat, tglKembali,
                                        KotaAsal, kotaTujuan, noPesawat, noKursi);
                            }
                            for (int i = 0; i < jumlah; i++) {
                                la[i].cetakSemuaData();
                            }
                            style.cetakSpasi(2);
                            for (int i = 0; i < jumlah; i++) {
                                total = total + la[i].getHarga();
                            }
                            System.out.print("Total : " + total);
                        } else if (temp3 == 2) {

                            System.out.println("####################################");
                            System.out
                                    .println(style.CYAN_BG + "#### SELAMAT DATANG DI CITILINK ####" + style.RESET);
                            System.out.println("####################################");

                            System.out
                                    .println("Tanggal Berangkat : " + decryptDate() + "/" + MM + "/" + YY);
                            tglBerangkat = decryptDate() + "/" + MM + "/" + YY;
                            style.cetakSpasi(2);
                            System.out.println("Silahkan isi data penumpang ");
                            for (int i = 0; i < jumlah; i++) {
                                System.out.print("Entry Booking ID : ");
                                BookingID = br.readLine();
                                System.out.print("Entry NIK : ");
                                nik = br.readLine();
                                System.out.print("Entry Nama : ");
                                nama = br.readLine();
                                System.out.print("Entry Jenis kelamin (P/L) : ");
                                JenisKelamin = br.readLine();
                                System.out.print("Entry No Pesawat : ");
                                noPesawat = br.readLine();
                                System.out.print("Entry Tgl Kembali : ");
                                tglKembali = br.readLine();
                                System.out.print("Entry Kota Asal : ");
                                KotaAsal = br.readLine();
                                System.out.print("Entry Kota Tujuan : ");
                                kotaTujuan = br.readLine();
                                System.out.print("Entry No Kursi : ");
                                noKursi = br.readLine();
                                style.cetakSpasi(1);
                                // BookingID, nik, nama, JenisKelamin, tgl berangkat, tgl Kembali, Kota asal,
                                // kotaTujuan, noPesawat, noKursi
                                // Jumlah Penumpang, harga, Kota tujuan,
                                cl[i] = new Citilink(BookingID, nik, nama, JenisKelamin, tglBerangkat, tglKembali,
                                        KotaAsal, kotaTujuan, noPesawat, noKursi);
                            }
                            for (int i = 0; i < jumlah; i++) {
                                cl[i].cetakSemuaData();
                            }
                            style.cetakSpasi(2);
                            for (int i = 0; i < jumlah; i++) {
                                total = total + cl[i].getHarga();
                            }
                            System.out.print("Total : " + total);

                        }
                        break;

                    // Rute
                    case 2:
                        cekKetersediaan(99);
                        break;

                    case 3:

                        break;

                    case 4:
                        style.cetakSpasi(2);
                        System.out.println(style.RED_BG + "System Exiting..." + style.RESET);
                        System.exit(0);
                        break;
                }
            } while (true);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void lionair(int x) {
        style.cetakSpasi(1);
        System.out.println(style.GREEN_U + maskapai[0] + style.RESET);

        if (x == 99 || x == 1) {
            // Surabaya
            for (int j = 0; j < kota.length; j++) {
                // harga dll belum
                if (j == 6) {
                } else if (j < 3) {
                    System.out.println(
                            "  " + kota[6] + "\t \t" + kota[j] + "\t \t\t"
                                    + Lionair.getTicketCost(kota[6], kota[j])
                                    + "\t \tBusiness\t " + v.elementAt(j) + "/" + MM + "/" + YY + "\t \t" + style.GREEN
                                    + "[AVAILABLE]"
                                    + style.RESET);
                } else {
                    System.out.println("  " + kota[6] + "\t \t" + kota[j] + " \t\t" + Lionair
                            .getTicketCost(kota[6], kota[j])
                            + "\t \tBusiness\t " + v.elementAt(j) + "/" + MM + "/" + YY + "\t \t" + style.GREEN
                            + "[AVAILABLE]"
                            + style.RESET);
                }
            }
            style.cetakSpasi(1);
        }

        if (x == 99 || x == 2) {
            for (int j = 0; j < kota.length; j++) {
                // harga dll belum
                if (j == 2) {
                } else if (j < 2) {
                    System.out.println("  " + kota[2] + "\t \t" + kota[j] + "\t \t\t" + Lionair
                            .getTicketCost(kota[2], kota[j])
                            + "\t \tBusiness\t " + v.elementAt(j + 5) + "/" + MM + "/" + YY + "\t \t" + style.GREEN
                            + "[AVAILABLE]"
                            + style.RESET);
                } else {
                    System.out.println("  " + kota[2] + "\t \t" + kota[j] + " \t\t" + Lionair
                            .getTicketCost(kota[2], kota[j])
                            + "\t \tBusiness\t " + v.elementAt(j + 5) + "/" + MM + "/" + YY + "\t \t" + style.GREEN
                            + "[AVAILABLE]"
                            + style.RESET);
                }
            }
            style.cetakSpasi(1);
        }

        if (x == 99 || x == 3) {
            for (int j = 0; j < kota.length; j++) {
                // harga dll belum
                if (j == 2) {
                } else if (j < 2) {
                    System.out.println("  Semarang" + "\t \t" + kota[j] + "\t \t\t" + Lionair
                            .getTicketCost(kota[2], kota[j])
                            + "\t \tBusiness\t -\t \t\t\t" + style.RED + "[NOT AVAILABLE]"
                            + style.RESET);
                } else {
                    System.out.println("  Semarang" + "\t \t" + kota[j] + " \t\t" + Lionair
                            .getTicketCost(kota[2], kota[j])
                            + "\t \tBusiness\t -\t \t\t\t" + style.RED + "[NOT AVAILABLE]"
                            + style.RESET);
                }
            }
            style.cetakSpasi(1);
        }

        if (x == 99 || x == 4) {
            for (int j = 0; j < kota.length; j++) {
                // harga dll belum
                if (j == 2) {
                } else if (j < 2) {
                    System.out.println("  Pekanbaru" + "\t \t" + kota[j] + "\t \t\t" + Lionair
                            .getTicketCost(kota[2], kota[j])
                            + "\t \tBusiness\t - \t \t\t\t" + style.RED + "[NOT AVAILABLE]"
                            + style.RESET);
                } else {
                    System.out.println("  Pekanbaru" + "\t \t" + kota[j] + " \t\t" + Lionair
                            .getTicketCost(kota[2], kota[j])
                            + "\t \tBusiness\t - \t \t\t\t" + style.RED + "[NOT AVAILABLE]"
                            + style.RESET);
                }
            }
            style.cetakSpasi(1);
        }
    }

    public static void citilink(int x) {
        style.cetakSpasi(1);
        System.out.println(style.GREEN_U + maskapai[1] + style.RESET);

        if (x == 99 || x == 1) {
            // Surabaya
            for (int j = 0; j < kota.length; j++) {
                // harga dll belum
                if (j == 6) {
                } else if (j < 3) {
                    System.out.println(
                            "  " + kota[6] + "\t \t" + kota[j] + "\t \t\t"
                                    + Citilink.getTicketCost(kota[6], kota[j])
                                    + "\t \tBusiness\t " + v.elementAt(j + 11) + "/" + MM + "/" + YY + "\t \t"
                                    + style.GREEN + "[AVAILABLE]"
                                    + style.RESET);
                } else {
                    System.out.println("  " + kota[6] + "\t \t" + kota[j] + " \t\t" + Citilink
                            .getTicketCost(kota[6], kota[j])
                            + "\t \tBusiness\t " + v.elementAt(j + 11) + "/" + MM + "/" + YY + "\t \t" + style.GREEN
                            + "[AVAILABLE]"
                            + style.RESET);
                }

            }
            style.cetakSpasi(1);
        }

        if (x == 99 || x == 2) {
            for (int j = 0; j < kota.length; j++) {
                // harga dll belum
                if (j == 2) {
                } else if (j < 2) {
                    System.out.println("  " + kota[2] + "\t \t" + kota[j] + "\t \t\t" + Citilink
                            .getTicketCost(kota[2], kota[j])
                            + "\t \tBusiness\t " + v.elementAt(j + 17) + "/" + MM + "/" + YY + "\t \t" + style.GREEN
                            + "[AVAILABLE]"
                            + style.RESET);
                } else {
                    System.out.println("  " + kota[2] + "\t \t" + kota[j] + " \t\t" + Citilink
                            .getTicketCost(kota[2], kota[j])
                            + "\t \tBusiness\t " + v.elementAt(j + 17) + "/" + MM + "/" + YY + "\t \t" + style.GREEN
                            + "[AVAILABLE]"
                            + style.RESET);
                }
            }
            style.cetakSpasi(1);
        }

        if (x == 99 || x == 3) {
            for (int j = 0; j < kota.length; j++) {
                // harga dll belum
                if (j == 2) {
                } else if (j < 2) {
                    System.out.println("  Semarang" + "\t \t" + kota[j] + "\t \t\t" + Citilink
                            .getTicketCost(kota[2], kota[j])
                            + "\t \tBusiness\t -\t \t\t\t" + style.RED + "[NOT AVAILABLE]"
                            + style.RESET);
                } else {
                    System.out.println("  Semarang" + "\t \t" + kota[j] + " \t\t" + Citilink
                            .getTicketCost(kota[2], kota[j])
                            + "\t \tBusiness\t -\t \t\t\t" + style.RED + "[NOT AVAILABLE]"
                            + style.RESET);
                }
            }
            style.cetakSpasi(1);
        }

        if (x == 99 || x == 4) {
            for (int j = 0; j < kota.length; j++) {
                // harga dll belum
                if (j == 2) {
                } else if (j < 2) {
                    System.out.println("  Pekanbaru" + "\t \t" + kota[j] + "\t \t\t" + Citilink
                            .getTicketCost(kota[2], kota[j])
                            + "\t \tBusiness\t - \t \t\t\t" + style.RED + "[NOT AVAILABLE]"
                            + style.RESET);
                } else {
                    System.out.println("  Pekanbaru" + "\t \t" + kota[j] + " \t\t" + Citilink
                            .getTicketCost(kota[2], kota[j])
                            + "\t \tBusiness\t - \t \t\t\t" + style.RED + "[NOT AVAILABLE]"
                            + style.RESET);
                }
            }
            style.cetakSpasi(1);
        }
    }

    public static void cekKetersediaan(int z) {
        style.cetakSpasi(2);
        System.out.println("##########################################");
        System.out.println(style.CYAN_BG + "#### 2. Ketersediaan Rute Penerbangan ####" + style.RESET);
        System.out.println("##########################################");

        style.cetakSpasi(1);
        System.out.println(style.YELLOW_BRIGHT
                + "Kota Asal\t|\tKota Tujuan\t|\tHarga\t|\tClass\t|\tTanggal Tersedia\t|\tStatus"
                + style.RESET);
        lionair(z);
        citilink(z);
    }

    public static int decryptDate() {
        // Temp2 = Kota awal
        // Temp3 = Maskapai
        // Temp4 = Kota tujuan
        // Bali, Lombok, jakarta, jogja, balikpapan, makassar, surabaya
        int a = 0;
        // System.out.println("vector 1 : " + v.elementAt(0));
        // System.out.println("Temp2 3 4 = " + temp2 + temp3 + temp4);
        if (temp3 == 1) {
            if (temp2 == 1) {
                if (temp4 == 1) {
                    a = (int) v.elementAt(0);
                } else if (temp4 == 2) {
                    a = (int) v.elementAt(1);
                } else if (temp4 == 3) {
                    a = (int) v.elementAt(2);
                } else if (temp4 == 4) {
                    a = (int) v.elementAt(3);
                } else if (temp4 == 5) {
                    a = (int) v.elementAt(4);
                } else if (temp4 == 6) {
                    a = (int) v.elementAt(5);
                }
            } else if (temp2 == 2) {
                if (temp4 == 1) {
                    a = (int) v.elementAt(0 + 6);
                } else if (temp4 == 2) {
                    a = (int) v.elementAt(1 + 6);
                } else if (temp4 == 4) {
                    a = (int) v.elementAt(2 + 6);
                } else if (temp4 == 5) {
                    a = (int) v.elementAt(3 + 6);
                } else if (temp4 == 6) {
                    a = (int) v.elementAt(4 + 6);
                } else if (temp4 == 7) {
                    a = (int) v.elementAt(5 + 6);
                }
            }
        } else if (temp3 == 2) {
            if (temp2 == 1) {
                if (temp4 == 1) {
                    a = (int) v.elementAt(0 + 12);
                } else if (temp4 == 2) {
                    a = (int) v.elementAt(1 + 12);
                } else if (temp4 == 3) {
                    a = (int) v.elementAt(2 + 12);
                } else if (temp4 == 4) {
                    a = (int) v.elementAt(3 + 12);
                } else if (temp4 == 5) {
                    a = (int) v.elementAt(4 + 12);
                } else if (temp4 == 6) {
                    a = (int) v.elementAt(5 + 12);
                }
            } else if (temp2 == 2) {
                if (temp4 == 1) {
                    a = (int) v.elementAt(0 + 18);
                } else if (temp4 == 2) {
                    a = (int) v.elementAt(1 + 18);
                } else if (temp4 == 4) {
                    a = (int) v.elementAt(2 + 18);
                } else if (temp4 == 5) {
                    a = (int) v.elementAt(3 + 18);
                } else if (temp4 == 6) {
                    a = (int) v.elementAt(4 + 18);
                } else if (temp4 == 7) {
                    a = (int) v.elementAt(5 + 18);
                }
            }
        }
        return a;
    }

}