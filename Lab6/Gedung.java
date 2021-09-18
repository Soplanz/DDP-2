// Import module yang dibutuhkan untuk manipulasi array.
import java.util.Arrays;


/* Implementasi dari class Gedung yang mewariskan sifat dari super classnya yaitu, Tempat */
public class Gedung extends Tempat {

    
    // Inisialisasi array of string sebagai instance dari class Gedung.
    private String[] listRuangan = new String[0];

    
    // Constructor class Gedung.
    public Gedung(String nama, String lokasi, String deskripsi) {
        
        // NOTE: Tipe tempat: gedung
        // Constructor yang memanfaatkan super class constructor dengan beberapa parameter.
        super(nama, lokasi, deskripsi, "gedung");
    }
    
    
    // Getter untuk mendapatkan array of string yang berisi nama ruangan sebuah gedung.
    public String[] listSemuaRuangan() {
        return this.listRuangan;
    }

    
    // Implementasi void method yang digunakan untuk menambah ruangan sebuah gedung.
    public void tambahRuangan(String namaRuangan) {
        String[] temp = Arrays.copyOf(this.listRuangan, this.listRuangan.length+1);
        temp[this.listRuangan.length] = namaRuangan;
        this.listRuangan = temp;
    }

    
    // Override method beraktivitas dari super class. 
    // Method kemudian akan melakukan pencetakkan yang diharapkan pada output.
    @Override
    public String beraktivitas(String aktivitas) {

        // Penggunaan iterasi yang digunakan untuk memeriksa keberadaan ruangan.
        for(String ruangan : this.listRuangan){
            if(aktivitas.equals(ruangan))
                return "Saya belajar di ruang " + aktivitas.split(" ")[0] + ".";
        }
        
        // Jika ruangan tidak ada.
        return "Tidak ada ruangan bernama " + aktivitas + ".";
    }

    
    // Implementasi method toString yang meng-override method pada class Object
    // Override method untuk mencetak class Gedung dengan tambahan informasi "Jumlah Ruangan".
    @Override
    public String toString() {
        return String.format("Nama: %s\nLokasi: %s\nDeskripsi: %s\nJumlah Ruangan: %d\nSudah dikunjungi: %b", this.getNama(), this.getLokasi(), this.getDeskripsi(), this.listRuangan.length, this.getDikunjungi());
    }
}
