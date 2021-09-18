package com.DDP2;

// Import properties dari java util seperti scanner dan arrays
import java.util.*;

public class Lab03{
    public static void main(String[] args) {
        // Inisiasi scanner
        Scanner in = new Scanner(System.in);

        // User prompt untuk meminta data yang dibutuhkan
        // Tipe data yang dipakai: String
        System.out.print("Panjang: ");
        String capacity = in.nextLine();
        System.out.print("Barisan: ");
        String input = in.nextLine();
        System.out.print("Pergeseran: ");
        String command = in.nextLine();

        // Menutup scanner
        in.close();

        // Inisiasi array dengan memanfaatkan input panjang
        // Input panjang kemudian diubah ke tipe integer
        String[] array = new String[Integer.parseInt(capacity)];
        array = input.split(" ");

        // Void method untuk menjalankan program intinya 
        // Dibutuhkan 3 parameter
        process(array, command, input);
    }

    // Pembuatan method ini ditujukan untuk memeriksa input dan array
    // Pemeriksaan input berkaitan dengan apakah user mengosongkan kolom barisan ?
    // Pemeriksaan array berkaitan dengan apakah elemen pertama yang terkecil ?
    // Mengembalikan boolean kebenaran input.
    static boolean checkContent(String content, String[] array){
        return (!content.equals("") && lowest(array[0], array)) ? true : false;
    }
    
    // Implementasi "otak" dari program
    // Disini dilakukan proses dari pergeseran dibantu method lainnya.
    // Akan dilakukan pengecekkan tiap substring dari command 
    // Jika "R" akan di shiftRight sebaliknya ("L") di shiftLeft.
    static void process(String[] array, String command, String input){
        for(int a = 0; a < command.length(); a++){
            if(command.substring(a, a + 1).equals("R")){
                array = shiftRight(array);
            } else{
                array = shiftLeft(array);
            }
        } 
        // Melakukan pencetakkan array dengan Arrays.toString
        System.out.println("Output: " + Arrays.toString(array));

        // Pemanfaatan method sebelumnya.
        System.out.println(checkContent(input, array));
    }

    // Implementasi method untuk menggeser ke kanan
    // Mengembalikan array berisi string
    static String[] shiftRight(String[] target){
        String[] result = new String[target.length];
        
        // Pada 3 baris dibawah ini dilakukan shifting elemen terakhir
        // Melibatkan variabel String temp untuk pemindahannya
        String temp = target[target.length - 1];
        result[0] = temp;
        
        // Melakukan shifting dengan memanfaatkan indeks iterasi
        for(int a = 0; a < target.length - 1; a++){
            result[a + 1] = target[a];
        } return result;
    }

    // Implementasi method untuk menggeser ke kanan
    // Mengembalikan array berisi string
    static String[] shiftLeft(String[] target){
        String[] result = new String[target.length];

        // Pada 3 baris dibawah ini dilakukan shifting elemen awal
        // Melibatkan variabel String temp untuk pemindahannya
        String temp = target[0];
        result[result.length - 1] = temp;
        
        // Melakukan shifting dengan memanfaatkan indeks iterasi
        for(int a = 1; a < target.length; a++){
            result[a - 1] = target[a];
        } return result;
    }

    // Implementasi method untuk memeriksa apakah elemen pertama array sudah paling kecil
    // Mengembalikan sebuah nilai boolean hasil pemeriksaan 
    static boolean lowest(String firstElement, String[] target){
        for(int a = 1; a < target.length; a++){
            
            // Pemeriksaan tiap elemen dengan memanfaatkan indeksnya
            // tiap elemen terlebih dahulu diubah menjadi integer lalu dibandingkan
            if(Integer.parseInt(firstElement) > Integer.parseInt(target[a])){
                return false;
            }
        } return true;
    }
}



