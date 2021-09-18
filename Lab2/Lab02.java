package com.DDP2;

// Melakukan import scanner
import java.util.Scanner;


public class Lab02 {
    public static void main(String[] args) {
        // Inisialisasi sebuah scanner
        Scanner input = new Scanner(System.in);
        
        // Proses meminta input dari user
        // (Dipastikan user memasukkan data sesuai format [word, command])
        String[] userPrompt = input.nextLine().split(" ");
        String word = userPrompt[0]; 
        String command = userPrompt[1];

        // Melakukan pemanggilan method
        System.out.println(process(word, command));
        input.close();
    } 

    // Implementasi method untuk memproses word dan command.
    // Dari fungsi ini permasalahan akan dipecah lagi menjadi decrypt dan encrypt.
    static String process(String word, String command){
        // Menyimpan actual parameter agar lebih mudah di proses
        String processed = word;

        // Iterasi sesuai dengan command yang ada
        for(int num = 0; num < command.length(); num++){
            if(command.substring(num, num + 1).equals("D")){
                processed = decrypt(processed);
            } else{
                processed = encrypt(processed);
            }
        } return processed;
    }

    // Implementasi method enkripsi
    static String encrypt(String word){
        // Inisiasi variabel penyimpan value
        String result = "";
        char ch;
        int charIndex;
    
        // Iterasi string dengan memanfaatkan charAt
        // Kemudian melakukan operasi penggeseran ASCII Index sebesar 3 satuan ke kanan
        // Juga menangani charIndex yang berada di luar batas uppercase ASCII Index
        // Batas ASCII uppercase (65 - 90)
        for(int num = 0; num < word.length(); num++){
            ch = word.charAt(num);
            charIndex = ch + 3;
            if(charIndex > 90){
                charIndex = (charIndex - 90) + 64;
            }
            result += (char) charIndex;
        } return result;
    }

    // Implementasi method dekripsi
    static String decrypt(String word){
        // Inisiasi variabel penyimpan value
        String result = "";
        char ch;
        int charIndex;

        // Melakukan iterasi yang konsepnya sesuai dengan method sebelumnya.
        // Operasi penggeseran ASCII Index sebesar 3 satuan kekiri
        // Juga menangani charIndex yang berada di luar batas uppercase ASCII index
        for(int num = 0; num < word.length(); num++){
            ch = word.charAt(num);
            charIndex = ch - 3;
            if(charIndex < 65){
                charIndex = 90 - (65 - charIndex - 1);
            }
            result += (char) charIndex;
        } return result;
    }
}
