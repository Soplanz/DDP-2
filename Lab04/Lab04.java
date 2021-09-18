package com.DDP2;

// Mengimport segala sesuatu yang dibutuhkan seperti scanner dan lain - lain
import java.util.*;

public class Lab4 {
    public static void main(String[] args) {
        // Inisiasi objek scanner untuk membaca input
        Scanner input = new Scanner(System.in);
        
        // Tampilan user prompt untuk kolom dan baris N x N
        // Menerima suatu integer N
        // Diasumsikan N > 1
        System.out.print("Ukuran kolom dan baris: ");
        int ukuran = Integer.parseInt(input.nextLine());

        // Pembuatan array 2d sebagai representasi matrix
        String[][] matrix = new String[ukuran][ukuran];
        
        // User prompt sekaligus input untuk isi dari matrix
        // Input kemudian akan disimpan dalam matrix
        System.out.println("Peta matrix: ");
        for(int a = 0; a < ukuran; a++){
            matrix[a] = input.nextLine().split(" ");
        }
        
        // Tampilan user prompt untuk aturan arah putar
        // Menerima string berisi "L" atau "R"
        System.out.print("Putaran: ");
        String putaran = input.nextLine();

        // Menutup scanner
        input.close();

        // Melaksanakan operasi matrix dengan aturan arah putar sebelumnya
        process(matrix, putaran);
    }

    // Implementasi method void untuk melaksanakan operasi matrix
    // Parameter : matrix dan perintah (aturan putaran)
    static void process(String[][] matrix, String perintah){
        // Iterasi character dari string perintah
        // Penyesuaian character dengan yang seharusnya
        // Asumsi perintah hanya berisi R atau L
        for(int a = 0; a < perintah.length(); a++){
            switch(perintah.charAt(a)){
                case 'L' : matrix = rotateLeft(matrix); break;
                default : matrix = rotateRight(matrix); break;
            }
        }
        
        System.out.println("Output: ");
        // Pencetakkan matrix hasil operasi
        printMatrix(matrix);
    }

    // Implementasi method untuk print matrix secara khusus
    // Parameter : matrix
    static void printMatrix(String[][] matrix){
        // Dilakukan iterasi per baris
        // Kemudian elemen baris akan di print secara sejajar dengan delimiter spasi
        // "System.out.println("")" dilakukan untuk pemindahan baris
        for(String[] baris : matrix){
            for(String elemen : baris){
                System.out.print(elemen + " ");
            }
            System.out.println("");
        }
    }

    // Algoritma rotasi ke kiri yang akan dilakukan yaitu mengambil per kolom matrix
    // Kemudian akan dilakukan reverse fill
    // Contoh : 1 2 3           1      2      3           1 4 7           3 6 9
    //          4 5 6   ====>   4 lalu 5 lalu 6   ====>   2 5 8   ====>   2 5 8
    //          7 8 9           7      8      9           3 6 9           1 4 7
    
    // Algoritma rotasi ke kanan yang akan dilakukan yaitu mengambil per kolom matrix
    // Kemudian akan dilakukan reverse baris yang di reverse
    // Contoh : 1 2 3           1      2      3           1 4 7           7 4 1
    //          4 5 6   ====>   4 lalu 5 lalu 6   ====>   2 5 8   ====>   8 5 2
    //          7 8 9           7      8      9           3 6 9           9 6 3
    
    // Implementasi method untuk rotasi ke kiri
    // Parameter : matrix
    // Tipe pengembalian : matrix
    static String[][] rotateLeft(String[][] matrix){
        // Inisiasi array 2d bernama result untuk menyimpan hasil
        // Ukuran array 2d ini disesuaikan dengan ukuran matrix
        String[][] result = new String[matrix.length][matrix.length];
        
        // Pada bagian ini dilakukan nested for loops
        // Loop pertama untuk mengakses baris
        // Loop kedua untuk mengakses elemen
        for(int a = 0; a < matrix.length; a++){
            // Pembuatan sebuah array string untuk menyimpan baris
            String[] saver = new String[matrix.length];
            for(int b = 0; b < matrix.length; b++){
                // Pengisian array penyimpan dengan elemen per kolom
                saver[b] = matrix[b][a];
            }

            // Implementasi reverse fill baris
            result[matrix.length - 1 - a] = saver; 
        } 
        return result;
    }

    static String[][] rotateRight(String[][] matrix){
        // Inisiasi array 2d bernama result untuk menyimpan hasil
        // Ukuran array 2d ini disesuaikan dengan ukuran matrix
        String[][] result = new String[matrix.length][matrix.length];

        // Pada bagian ini dilakukan nested for loops
        // Loop pertama untuk mengakses baris
        // Loop kedua untuk mengakses elemen
        for(int a = 0; a < matrix.length; a++){
            // Pembuatan sebuah array string untuk menyimpan baris
            String[] saver = new String[matrix.length];
            for(int b = 0; b < matrix.length; b++){
                // Implementasi reverse fill elemen per kolom
                saver[b] = matrix[matrix.length - 1 - b][a];
            }

            // Pengisian result
            result[a] = saver; 
        } 
        return result;
    }
}
