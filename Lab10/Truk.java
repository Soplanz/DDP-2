import java.util.*;

// Implementasi dari kelas Truk yang bersifat generic.
// Tipe generic akan dibatasi dengan hanya subclass dari class Barang.
public class Truk <T extends Barang> {


	// Instansiasi attribut-attribut yang dibutuhkan pada class Truk.
	private ArrayList<T> daftarBarang;
	private String nama;


	// Konstruktor dari class Truk.
	public Truk(String nama) {

		// Instansiasi attribut.
		this.nama = nama;
		this.daftarBarang = new ArrayList<>();
	}


	// Implementasi method add barang.
	// Required Parameter : Generic Object (only Barang's subclasses) barang.
	public void addBarang(T barang) {
		
		// Implementasi penambahan barang ke atribut daftarBarang
		this.daftarBarang.add(barang);
	}


	// Implementasi method getTotalBobot.
	public int getTotalBobot() {
		
		// Implementasi penambahan barang.
		int totalBobot = 0;
		for(Barang barang : daftarBarang)
			totalBobot += barang.getBobot();
		return totalBobot;
	}


	// Implementasi method rekap.
	public void rekap() {
		
		// Kondisi ketika belum ada barang apapun di suatu truk.
		if(daftarBarang.size() == 0)

			// Kondisional bergantung dengan jenis truk dilihat dari variable nama.
			if(this.nama.equals("Truk Makanan"))
				System.out.println("Belum ada barang di Truk Makanan\n");
			else if(this.nama.equals("Truk Pakaian"))
				System.out.println("Belum ada barang di Truk Pakaian\n");
			else
				System.out.println("Belum ada barang di Truk Elektronik\n");


		// Saat dipastikan sudah pasti ada barang.
		else{

			// Iterasi untuk memunculkan rekap masing-masing barang.
			for(Barang barang : daftarBarang)
				System.out.println(barang.getRekap());

			// Menampilkan total bobot.
			System.out.printf("Total bobot barang di truk ini: %d gram\n\n", this.getTotalBobot());
		}
	}

}