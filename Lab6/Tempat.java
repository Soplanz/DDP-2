// Import module untuk manipulasi array.
import java.util.Arrays;


/* Implementasi class Tempat yang menjadi sebuah superclass bagi class Gedung dan LabKomputer. */
public class Tempat {

    
    // Inisialisasi beberapa instance variable pada class Tempat.
    private String nama;
    private String lokasi;
    private String deskripsi;
    private String tipeTempat;
    private boolean dikunjungi = false;

    
    // Pembuatan sebuah array of Tempat untuk menyimpan nama tempat.
    static Tempat[] semuaTempat = new Tempat[0];
    
    
    // Construtor dari class Tempat.
    public Tempat(String nama, String lokasi, String deskripsi, String tipeTempat) {

        // Pengisian semua instance variable dengan parameter konstruktor.
        this.nama = nama;
        this.lokasi = lokasi;
        this.deskripsi = deskripsi;
        this.tipeTempat = tipeTempat;
    }

    
    // Getter untuk nama dari objek Tempat.
    public String getNama(){
        return this.nama;
    }

    
    // Getter untuk tipeTempat dari objek Tempat.
    public String getTipeTempat(){
        return this.tipeTempat;
    }

    
    // Getter untuk lokasi dari objek Tempat.
    public String getLokasi(){
        return this.lokasi;
    }

    
    // Getter untuk deskripsi dari objek Tempat.
    public String getDeskripsi(){
        return this.deskripsi;
    }

    
    // Getter untuk attribut dikunjungi dari objek Tempat.
    public boolean getDikunjungi(){
        return this.dikunjungi;
    }

    
    // Implementasi method untuk menandakan sebuah aktivitas kunjungan.
    public String kunjungi() {

        // Pengubahan attribut dikunjungi dari suatu tempat.
        this.dikunjungi = true;
        return "Saya mengunjungi " + this.nama + ".";
    }
    
    
    // Implementasi method beraktivitas untuk menandakan sebuah kegiatan.
    public String beraktivitas(String aktivitas, String namaTempat){

        // Untuk kemudahan, akan dibuat sebuah objek tempat untuk kemudian diproses.
        Tempat tempat = getTempat(namaTempat);

        // Conditionals untuk memeriksa apakah kegiatan dilakukan pada tempat yang tepat.
        if (tempat.getTipeTempat().equals("gedung") && aktivitas.toLowerCase().startsWith("belajar")) {
            return tempat.beraktivitas(aktivitas.substring(8));
        } else if (tempat.getTipeTempat().equals("labkom") && aktivitas.toLowerCase().equalsIgnoreCase("gunakan komputer")) {
            return tempat.beraktivitas(aktivitas);
        }

        // Jika conditionals tidak terpenuhi maka akan dicetak pesan dibawah ini.
        return String.format("Di %s, aktivitas %s tidak dapat dilakukan.",namaTempat, aktivitas);
    }

    
    // Implementasi method yang overload method sebelumnya dengan parameter yang hanya berupa String aktivitas.
    public String beraktivitas(String aktivitas) {
        return String.format("Saya melakukan %s di %s.", aktivitas, this.nama);
    }

    
    // Implementasi method toString yang digunakan untuk mencetak deskripsi umum suatu tempat.
    public String toString() {
        return String.format("Nama: %s\nLokasi: %s\nDeskripsi: %s\nSudah dikunjungi: %b", nama, lokasi, deskripsi, dikunjungi);
    }

    
    // Implementasi method untuk mencari apakah nama tempat yang dituju ada atau tidak.
    public static Tempat getTempat(String namaTempat) {

        // Digunakan sebuah for loop untuk memeriksa keberadaan nama tempat tersebut.
        for (Tempat tempat : Tempat.semuaTempat){
            if (tempat.getNama().equals(namaTempat)){
                return tempat;
            }
        }

        // Jika nama tempat tidak ditemukan.
        return null;
    }

    
    // Implementasi method untuk menambahkan objek tempat pada array of tempat.
    public static void tambahArrayTempat(Tempat value) {
        Tempat[] temp = Arrays.copyOf(semuaTempat, semuaTempat.length+1);
        temp[semuaTempat.length] = value;
        semuaTempat = temp;
    }
}
