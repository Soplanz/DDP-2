// Implementasi class Barang yang masih bersifat abstrak.
public abstract class Barang {

	// Inisialisasi attribut dari suatu barang.
	int bobot;
	String nama;


	// Konstruktor dari class Barang.
	public Barang(int bobot, String nama) {

		// Instansiasi attribut dari class Barang.
		this.bobot = bobot;
		this.nama = nama;
	}


	// Getter attribut bobot.
	public int getBobot() {
		return this.bobot;
	}


	// Getter attribut nama.
	public String getNama() {
		return this.nama;
	}


	// Abstrak method getRekap
	// Abstrak karena jenis barang belum diketahui. 
	public abstract String getRekap();

}