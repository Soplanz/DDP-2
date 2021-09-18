// Implementasi suatu class turunan dari class Barang yaitu Elektronik.
public class Elektronik extends Barang {


    // Inisialisasi attribut untuk class Elektronik.
    private String kondisi;


    // Konstruktor class Elektronik.
	public Elektronik(int bobot, String nama, String kondisi) {

        // Pemanggilan super konstruktor.
		super(bobot, nama);

        // Instansiasi attribut.
        this.kondisi = kondisi;
	}

    // Pendefinisian method getRekap yang bersifat abstrak di class Barang.
    // Implementasi method getRekap untuk class Elektronik.
    public String getRekap() {
        return String.format(
            "Barang Elektronik %s\n" + 
            "Bobot: %d\n" + 
            "Kondisi: %s", 
            super.getNama(), super.getBobot(), this.kondisi);
    }

}