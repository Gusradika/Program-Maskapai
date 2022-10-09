package maskapai_21410100039;

import java.io.*;
import java.sql.Date;

public class main {

    public static String[] kota = { "Bali", "Lombok", "Jakarta", "Yogyakarta", "Balikpapan", "Makassar", "Surabaya" };

    public static int DD = 15, YY = 2022;
    public static String MM = "Oktober", date = DD + "/" + MM + "/" + YY;

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {

        int input = 0;
        // Bali = 0, lmbk = 1, jkrt = 2, Yogyakarta = 3, balikpapan = 4, makassar = 5,
        // surabaya = 6

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            do {
                do {
                    style.cetakSpasi(2);
                    System.out.println("#################################");
                    System.out.println(style.CYAN_BG + "#### Program Pemesanan Tiket ####" + style.RESET);
                    System.out.println("#################################");
                    System.out.println(style.GREEN_U + "I Gusti Ngurah Aditya Kesuma - 21410100039" + style.RESET);
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

                        style.cetakSpasi(2);
                        System.out.println("########################");
                        System.out.println(style.CYAN_BG + "#### 1. Pesan Tiket ####" + style.RESET);
                        System.out.println("########################");

                        break;

                    // Rute
                    case 2:
                        style.cetakSpasi(2);
                        System.out.println("##########################################");
                        System.out.println(style.CYAN_BG + "#### 2. Ketersediaan Rute Penerbangan ####" + style.RESET);
                        System.out.println("##########################################");

                        style.cetakSpasi(1);
                        System.out.println(style.YELLOW_BRIGHT
                                + "Kota Asal\t|\tKota Tujuan\t|\tHarga\t|\tClass\t|\tTanggal Tersedia\t|\tStatus"
                                + style.RESET);
                        lionair();
                        break;

                    case 3:

                        break;

                    case 4:
                        style.cetakSpasi(2);
                        System.out.println(style.RED_BG + "System Exiting..." + style.RESET);
                        break;
                }
            } while (true);

        } catch (

        Exception e) {
            System.out.println(e);
        }
    }

    public static void lionair() {
        style.cetakSpasi(1);
        System.out.println(style.GREEN_U + "LionAir" + style.RESET);
        for (int i = 0; i < 1; i++) {
            // Surabaya
            for (int j = 0; j < kota.length; j++) {
                // harga dll belum
                if (j == 6) {
                } else if (j < 3) {
                    System.out.println(
                            "  " + kota[6] + "\t \t" + kota[j] + "\t \t\t"
                                    + Lionair.getTicketCost(kota[6], kota[j])
                                    + "\t \tBusiness\t " + date + "\t \t" + style.GREEN + "[AVAILABLE]"
                                    + style.RESET);
                } else {
                    System.out.println("  " + kota[6] + "\t \t" + kota[j] + " \t\t" + Lionair
                            .getTicketCost(kota[6], kota[j])
                            + "\t \tBusiness\t " + date + "\t \t" + style.GREEN + "[AVAILABLE]"
                            + style.RESET);
                }

            }

            style.cetakSpasi(1);

            for (int j = 0; j < kota.length; j++) {
                // harga dll belum
                if (j == 2) {
                } else if (j < 2) {
                    System.out.println("  " + kota[2] + "\t \t" + kota[j] + "\t \t\t" + Lionair
                            .getTicketCost(kota[2], kota[j])
                            + "\t \tBusiness\t " + date + "\t \t" + style.GREEN + "[AVAILABLE]"
                            + style.RESET);
                } else {
                    System.out.println("  " + kota[2] + "\t \t" + kota[j] + " \t\t" + Lionair
                            .getTicketCost(kota[2], kota[j])
                            + "\t \tBusiness\t " + date + "\t \t" + style.GREEN + "[AVAILABLE]"
                            + style.RESET);
                }
            }

            style.cetakSpasi(1);

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
        }
    }

    public static void citilink() {
        style.cetakSpasi(1);
        System.out.println(style.GREEN_U + "Citilink" + style.RESET);
        for (int i = 0; i < 1; i++) {
            // Surabaya
            for (int j = 0; j < kota.length; j++) {
                // harga dll belum
                if (j == 6) {
                } else if (j < 3) {
                    System.out.println(
                            "  " + kota[6] + "\t \t" + kota[j] + "\t \t\t"
                                    + Lionair.getTicketCost(kota[6], kota[j])
                                    + "\t \tBusiness\t " + date + "\t \t" + style.GREEN + "[AVAILABLE]"
                                    + style.RESET);
                } else {
                    System.out.println("  " + kota[6] + "\t \t" + kota[j] + " \t\t" + Lionair
                            .getTicketCost(kota[6], kota[j])
                            + "\t \tBusiness\t " + date + "\t \t" + style.GREEN + "[AVAILABLE]"
                            + style.RESET);
                }

            }

            style.cetakSpasi(1);

            for (int j = 0; j < kota.length; j++) {
                // harga dll belum
                if (j == 2) {
                } else if (j < 2) {
                    System.out.println("  " + kota[2] + "\t \t" + kota[j] + "\t \t\t" + Lionair
                            .getTicketCost(kota[2], kota[j])
                            + "\t \tBusiness\t " + date + "\t \t" + style.GREEN + "[AVAILABLE]"
                            + style.RESET);
                } else {
                    System.out.println("  " + kota[2] + "\t \t" + kota[j] + " \t\t" + Lionair
                            .getTicketCost(kota[2], kota[j])
                            + "\t \tBusiness\t " + date + "\t \t" + style.GREEN + "[AVAILABLE]"
                            + style.RESET);
                }
            }

            style.cetakSpasi(1);

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
        }
    }

}