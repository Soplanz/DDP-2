import java.util.Scanner;


// Implementasi class inti dari program, class SIMudik.
public class SIMudik {

	// Inisialisasi konstanta pemilihan instruksi program.
	private static final int TAMBAH_BARANG = 1;
	private static final int REKAP = 2;
	private static final int KELUAR = 3; 

	// Inisialisasi objek truk yang memiliki ke khusus an  masing-masing.
	private Truk<Makanan> trukMakanan;
	private Truk<Pakaian> trukPakaian;
	private Truk<Elektronik> trukElektronik;

	// Inisialisasi objek scanner.
	private Scanner in;


	// Konstruktor dari class SIMudik.
	public SIMudik() {

		// Instansiasi objek Truk yang telah di inisialisasi.
		trukMakanan = new Truk<Makanan>("Truk Makanan");
		trukPakaian = new Truk<Pakaian>("Truk Pakaian");
		trukElektronik = new Truk<Elektronik>("Truk Elektronik");

		// Instansiasi objek scanner untuk user input.
		in = new Scanner(System.in);
	}


	// Implementasi method add elektronik yang dimaksudkan untuk penambahan barang elektronik.
	public void addMakanan() {

		// User input untuk attribut pembuatan suatu objek Makanan.
		System.out.print("Masukkan nama makanan: ");
		String nama = in.nextLine();
		System.out.print("Masukkan bobot (dalam gram): ");
		int bobot = Integer.parseInt(in.nextLine());
		System.out.print("Masukkan tanggal kedaluwarsa: ");
		String expiredDate = in.nextLine();

		// Pembuatan object Makanan dan penambahan ke truk yang sesuai.
		Makanan food = new Makanan(bobot, nama, expiredDate);
		trukMakanan.addBarang(food);

		// Mencetak keluaran setelah berhasil menambahkan.
		System.out.println("Makanan " + nama + " ditambahkan ke truk makanan!\n");
	}


	// Implementasi method add elektronik yang dimaksudkan untuk penambahan barang pakaian.
	public void addPakaian() {

		// User input untuk attribut pembuatan suatu objek Pakaian.
		System.out.print("Masukkan nama pakaian: ");
		String nama = in.nextLine();
		System.out.print("Masukkan bobot (dalam gram): ");
		int bobot = Integer.parseInt(in.nextLine());
		System.out.print("Masukkan warna: ");
		String warna = in.nextLine();
		System.out.print("Masukkan ukuran (S/M/L): ");
		char ukuran = in.nextLine().charAt(0);

		// Pembuatan object Pakaian dan penambahan ke truk yang sesuai.
		Pakaian clothes = new Pakaian(bobot, nama, warna, ukuran);
		trukPakaian.addBarang(clothes);

		// Mencetak keluaran setelah berhasil menambahkan.
		System.out.println("Pakaian " + nama + " ditambahkan ke truk pakaian!\n");
	}


	// Implementasi method add elektronik yang dimaksudkan untuk penambahan barang elektronik.
	public void addElektronik() {

		// User input untuk attribut pembuatan suatu objek Elektronik.
		System.out.print("Masukkan nama barang elektronik: ");
		String nama = in.nextLine();
		System.out.print("Masukkan bobot (dalam gram): ");
		int bobot = Integer.parseInt(in.nextLine());
		System.out.print("Deskripsikan kondisi saat ini: ");
		String kondisi = in.nextLine();

		// Pembuatan object Elektronik dan penambahan ke truk yang sesuai.
		Elektronik elektronik = new Elektronik(bobot, nama, kondisi);
		trukElektronik.addBarang(elektronik);

		// Mencetak keluaran setelah berhasil menambahkan.
		System.out.println("Barang elektronik " + nama + " ditambahkan ke truk elektronik!\n");
	}


	// Implementasi jalannya program.
	public void run() {
		System.out.println("----- Selamat Datang di Sistem Informasi Mudik -----");
		System.out.println("Masukkan perintah 1 untuk menambah barang");
		System.out.println("Masukkan perintah 2 untuk melihat rekap dari sebuah truk");
		System.out.println("Masukkan perintah 3 untuk keluar dari sistem");
		System.out.println("");

		while (true) {
			System.out.print("Masukkan perintah: ");
			int perintah = Integer.parseInt(in.nextLine());
			
			if (perintah == TAMBAH_BARANG) {

				System.out.print("Masukkan jenis barang (Makanan / Pakaian / Elektronik): ");
				String jenis = in.nextLine();

				if (jenis.equalsIgnoreCase("Makanan")) {
					addMakanan();
				} else if (jenis.equalsIgnoreCase("Pakaian")) {
					addPakaian();
				} else if (jenis.equalsIgnoreCase("Elektronik")) {
					addElektronik();
				} else {
					System.out.println("Tidak boleh membawa barang selain makanan, pakaian, atau elektronik");
				}

			} else if (perintah == REKAP) {

				System.out.print("Masukkan jenis truk (Makanan / Pakaian / Elektronik): ");
				String jenis = in.nextLine();

				if (jenis.equalsIgnoreCase("Makanan")) {
					trukMakanan.rekap();
				} else if (jenis.equalsIgnoreCase("Pakaian")) {
					trukPakaian.rekap();
				} else if (jenis.equalsIgnoreCase("Elektronik")) {
					trukElektronik.rekap();
				} else {
					System.out.println("Truk tidak ditemukan");
				}

			} else if (perintah == KELUAR) {
				System.out.println("Terima kasih telah menggunakan Sistem Informasi Mudik!");
				return ;
			}
		}
	}

	// Method main.
	public static void main(String[] args) {
		SIMudik sistem = new SIMudik();
		sistem.run();
	}

}