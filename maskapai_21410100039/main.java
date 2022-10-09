package maskapai_21410100039;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class main {

    public static String[] kota = { "Bali", "Lombok", "Jakarta", "Yogyakarta", "Balikpapan", "Makassar", "Surabaya" };

    static SimpleDateFormat day = new SimpleDateFormat("dd");
    static SimpleDateFormat full = new SimpleDateFormat("dd/MM/yyyy");
    static Date date = new Date();

    static String currentDD = (day.format(date));
    static String currentDate = (full.format(date));

    public static int DD = Integer.parseInt(currentDD), YY = 2022;
    public static String MM = "Oktober", dateC = DD + "/" + MM + "/" + YY;

    static Vector v = new Vector<Integer>();

    public static void main(String[] args) {
        int temp = 0;
        for (int i = 0; i < 2; i++) {
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
        }

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
                    System.out.println("Date : " + currentDate);
                    System.out.println("Vector : " + v);
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
                        System.out.println();
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
                        lionair(99);
                        citilink(99);
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

    public static void lionair(int x) {
        style.cetakSpasi(1);
        System.out.println(style.GREEN_U + "LionAir" + style.RESET);

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
        System.out.println(style.GREEN_U + "Citilink" + style.RESET);

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

    public static void searchFilter() {

    }

}