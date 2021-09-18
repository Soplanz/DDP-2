package com.DDP2;
import java.util.*;

public class Pizza {
    public static void main(String[] args) {
        // Inisialisasi objek scanner
        Scanner input = new Scanner(System.in);

        // User prompt untuk mendapatkan attribut jumlah
        System.out.print("Masukkan jumlah pizza yang ingin dibeli: ");
        int jumlah = input.nextInt();
        input.close();

        // Inisiasi elemen yang dibutuhkan
        // Double disini karena nantinya akan dibagi 100
        double potonganDiskon, hargaSetelahDiskon;
        int hargaPizza = 30000;
        int jumlahDiskon = 0;

        // Iterasi menggunakan for loop untuk menghitung jumlah diskon
        for(int i = 0; i < jumlah + 1; i++){
            jumlahDiskon += i;
            if(jumlahDiskon >= 70){
                jumlahDiskon = 70;
                break;
            }
        }

        // Mendapatkan elemen yang dibutuhkan untuk menghitung harga
        potonganDiskon = (hargaPizza * jumlah) * jumlahDiskon / 100.0;
        hargaSetelahDiskon = (hargaPizza * jumlah) - potonganDiskon;

        // Menampilkan output
        System.out.println("Anda mendapatkan diskon " + jumlahDiskon + "%");
        System.out.println("Yang harus kamu bayar sebesar: Rp " + (int) hargaSetelahDiskon);

        // Switch case untuk implementasi conditionals agar lebih singkat
        // Statement atau ekspresi yang dievaluasi yaitu  hasil dari jumlahDiskon di mod 7
        switch (jumlahDiskon % 7) {
            case 0:
                System.out.println("Cola satu liter gratis untuk kamu!");
                break;
            case 2:
                System.out.println("Lemon tea dua gelas gratis untuk kamu!");
                break;
            case 4:
                System.out.println("Es teh manis gratis untuk kamu!");
                break;
            case 5:
                System.out.println("Teh tawar gratis untuk kamu!");
                break;
            case 6:
                System.out.println("Air matang gratis untuk kamu!");
                break;
            default:
                System.out.println("Maaf kamu terpaksa seret");
                break;
        }
    }
}
