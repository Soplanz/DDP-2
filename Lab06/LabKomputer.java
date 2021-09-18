/* Implementasi dari class LabKomputer yang mewariskan sifat dari super classnya yaitu, Tempat */
public class LabKomputer extends Tempat {

    
    // Inisialisasi instance variable jumlahKomputer.
    private int jumlahKomputer;

    
    // Constructor dari class LabKomputer.
    public LabKomputer(String nama, String lokasi, String deskripsi, int jumlahKomputer) {
        
        // NOTE: Tipe tempat: labkom
        // Pemanggilan koonstruktor dari super class dengan parameter seharusnya.
        super(nama, lokasi, deskripsi, "labkom");

        // Assign instance variable dengan nilai pada parameter konstruktor.
        this.jumlahKomputer = jumlahKomputer;
    }

    
    // Implementasi method beraktivitas yang meng-override method beraktivitas pada super class.
    // Method kemudian akan melakukan pencetakkan yang diharapkan pada output.
    @Override
    public String beraktivitas(String aktivitas) {
        return "Saya menggunakan Komputer di " + this.getNama() + ".";
    }

    
    // Implementasi method toString yang meng-override method pada class Object
    // Mencetak aspek-aspek pada class LabKomputer.
    @Override
    public String toString() {
        return String.format("Nama: %s\nLokasi: %s\nDeskripsi: %s\nJumlah Komputer tersedia: %d\nSudah dikunjungi: %b", this.getNama(), this.getLokasi(), this.getDeskripsi(), this.jumlahKomputer, this.getDikunjungi());
    }
}
