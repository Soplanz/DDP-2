// Implementasi suatu class turunan dari class Barang yaitu Makanan.
public class Makanan extends Barang {

    // Inisialisasi attribut class Makanan.
    String expiredDate;


    // Konstruktor dari class Makanan.
    public Makanan(int bobot, String nama, String expiredDate) {

        // Pemanggilan super konstruktor.
		super(bobot, nama);

        // Instansiasi attribut dari class Makanan.
        this.expiredDate = expiredDate;
	}


    // Pendefinisian method getRekap yang bersifat abstrak di class Barang.
    // Implementasi method getRekap untuk class Makanan.
    public String getRekap() {
        return String.format(
            "Makanan %s\n" + 
            "Bobot: %d\n" + 
            "Kedaluwarsa: %s", 
            super.getNama(), super.getBobot(), this.expiredDate);
    }

}