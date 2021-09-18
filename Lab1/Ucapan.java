package com.DDP2;
import java.util.*;

public class Ucapan {
    public static void main(String[] args) {
        // Inisialisasi scanner
        Scanner input = new Scanner(System.in);
        
        // Meminta input data yang diperlukan dengan user prompt
        System.out.print("Masukkan tanggal: ");
        int day = Integer.parseInt(input.nextLine());
        System.out.print("Masukkan bulan: ");
        String month = input.nextLine();
        System.out.print("Masukkan pesan: ");
        String message = input.nextLine();
        input.close();

        // Pernyataan yang akan digunakan untuk memeriksa kebenaran input 
        boolean correctMessage = false;
        boolean correctDate = false;

        // Conditionals untuk menentukan kebenaran tanggal
        if(day == 10 && month.equals("Juli")){
            correctDate = true;
        }

        // Conditionals untuk menentukan kebenaran isi pesan
        if(message.equals("happy birthday")){
            correctMessage = true;
        }

        // Uji kondisi untuk menentukan output
        if(correctDate && correctMessage){
            System.out.println("Terima kasih");
        } else if(month.equals("Juli") && correctMessage){
            System.out.println("Bulannya benar, tanggalnya salah");
        } else if(day == 10 && correctMessage){
            System.out.println("Tanggalnya benar, bulannya salah");
        } else if(correctMessage){
            System.out.println("Terima kasih tapi ini bukan ulang tahun aku :D");
        } else{
            System.out.println("Biasalah :v");
        }
    }
}
