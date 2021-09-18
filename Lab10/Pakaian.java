// Implementasi suatu class turunan dari class Barang yaitu Pakaian.
public class Pakaian extends Barang {


	// Inisialisasi attribut dari class Pakaian.
	private char ukuran;
	private String warna;


	// Konstruktor dari kelas Pakaian.
	public Pakaian(int bobot, String nama, String warna, char ukuran) {

		// Pemanggilan super konstruktor.
		super(bobot, nama);

		// Instansiasi attribut sisa yang ada di parameter.
		this.warna = warna;
		this.ukuran = ukuran;
	}

	// Pendefinisian method getRekap yang bersifat abstrak di class Barang.
	// Implementasi method getRekap untuk class Pakaian.
	public String getRekap() {
        return String.format(
            "Pakaian %s\n" + 
            "Bobot: %d\n" + 
            "Ukuran: %c\n" +
			"Warna: %s", 
            super.getNama(), super.getBobot(), this.ukuran, this.warna);
    }

}