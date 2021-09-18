// Import module yang dibutuhkan untuk menjalankan program.
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* Implementasi class Mahasiswa sebagai kelas utama dari projek lab ini. */
public class Mahasiswa {


    // Pembuatan beberapa konstanta diperuntukkan sebagai menu dari program.
    private static final int KUNJUNGI = 1;
    private static final int BERAKTIVITAS = 2;
    private static final int SELESAI = 3;
    private static final int KELUAR = 4;
    private static final int DEBUG = 0;


    // Pembuatan sebuah instance variable array of strings untuk menyimpan aktivitas. 
    private String[] listAktivitasDilakukan = new String[0];


    // Pembuatan sebuah instance variable berupa array of strings untuk menyimpan tempat yang sudah dikunjungi.
    private String[] listTempatDikunjungi = new String[0];


    // Pembuatan sebuah objek scanner global yang diperuntukkan untuk menerima user input.
    private Scanner input = new Scanner(System.in);


    // Implementasi method yang ditujukan untuk proses mengunjungi sebuah tempat.
    private void kunjungiTempat(String namaTempat){
        System.out.println("\n--------------------------- BERKUNJUNG ---------------------------\n");
        
        // Pembuatan objek tempat untuk memudahkan proses conditionals pemeriksaan keberadaan tempat.
        Tempat t = Tempat.getTempat(namaTempat);

        // Conditionals yang diperuntukkan untuk pemeriksaan keberadaan tempat.
        if ( t == null ){

            // Jika tidak ada program akan langsung kembali ke menu utama.
            System.out.println("Maaf, tempat tersebut tidak ada di Fasilkom UI.");
            return;
        } else {

            // Jika tempat ada maka list aktivitas akan bertambah begitu juga dengan list tempat dikunjungi.
            this.tambahArrayListAktivitas(t.kunjungi());
            this.tambahArrayTempatDikunjungi(t.getNama());

            // Mencetak penanda keberhasilan pengunjungan sebuah tempat.
            System.out.println(t.kunjungi() + "\n");
        }
        
        // Tampilan jika tempat yang dituju ternyata ada.
        System.out.println("Apakah kamu ingin melakukan sesuatu disini?");
        System.out.println("Jika kamu mengetik ya, maka program akan mencetak aktivitas yang bisa dilakukan di tempat tersebut,");
        System.out.println("dan kamu harus mengetik aktivitas tersebut untuk melakukannya.");
        System.out.println("Jika kamu mengetik yang lain, maka program akan kembali ke menu utama.\n");

        // Conditionals yang ditujukan untuk memeriksa apakah user akan melakukan sebuah aktivitas.
        if (input.nextLine().equalsIgnoreCase("ya")) {

            // Jika ya, kemudian akan diperiksa mengenai lokasi dimana user melakukan sebuah aktivitas.
            switch (t.getClass().getSimpleName()) {

                // Jika di gedung.
                case "Gedung":
                    Gedung g = (Gedung) t;
                    System.out.printf("Di Gedung, kamu bisa Belajar. List semua ruangan: \n%s\n", Arrays.toString(g.listSemuaRuangan()));
                    break;
            
                // Jika di Lab Komputer.
                case "LabKomputer":
                    System.out.println("Di LabKomputer, kamu bisa Gunakan Komputer.");
                    break;

                default:
                    break;
            }
            
            // Menanyakan user mengenai apa yang ingin dilakukan.
            System.out.print("Apa yang ingin kamu lakukan? ");
            String aktivitas = input.nextLine();

            // Input dari user akan dimanfaatkan nantinya untuk melakukan aktivitas.
            lakukanAktivitas(aktivitas, t.getNama());
        }
    }

    // Implementasi method untuk melakukan sebuah aktivitas.
    private void lakukanAktivitas(String aktivitas, String namaTempat){
        System.out.println("\n-------------------------- BERAKTIVITAS --------------------------\n");

        // Pembuatan objek tempat untuk memudahkan proses conditionals pemeriksaan keberadaan tempat.
        Tempat t = Tempat.getTempat(namaTempat);

        // Conditionals yang diperuntukkan untuk pemeriksaan keberadaan tempat.
        if ( t == null ){

            // Jika tidak ada program akan langsung kembali ke menu utama.
            System.out.printf("Tidak ada tempat bernama %s\n",namaTempat);
            return;
        } else {

            // Jika tempat ada maka list aktivitas akan bertambah begitu juga dengan list tempat dikunjungi.
            this.tambahArrayListAktivitas(t.beraktivitas(aktivitas, t.getNama()));
            this.tambahArrayTempatDikunjungi(t.getNama());
            System.out.println(t.beraktivitas(aktivitas, t.getNama()));
        }
    }

    // Implementasi fungsi untuk menampilkan kunjungan kemana saja yang telah dilakukan.
    private void rekapKunjungan(){

        // Pencetakkan output yang seharusnya.
        System.out.print("Melakukan Rekap Kunjungan...");
        System.out.println("Selama Virtual tour, kamu telah mengunjungi tempat berikut:");

        // Iterasi untuk menampilkan semua kunjungan yang telah dilakukan.
        for(String tempatDikunjungi : this.listTempatDikunjungi){
            System.out.println(tempatDikunjungi);
        }
    }

    // Implementasi fungsi untuk menampilkan aktivitas apa saja yang telah dilakukan.
    private void rekapAktivitas(){

        // Pencetakkan output yang seharusnya.
        System.out.print("Melakukan Rekap Aktivitas...");
        System.out.println("Selama Virtual tour, aktivitas yang telah kamu lakukan adalah:");

        // Iterasi untuk menampilkan semua aktivitas yang telah dilakukan.
        for(String aktivitas : listAktivitasDilakukan){
            System.out.println(aktivitas);
        }
    }

    // Implementasi method untuk menampilkan menu setiap kali program berjalan.
    private void daftarMenu(){
        int pilihan = 0;
        String namaTempat = "";
        String aktivitas = "";
        boolean exit = false;

        // Implementasi while agar program berjalan terus hingga user memasukkan no 4 yang berarti exit.
        while (!exit) {

            // Pencetakkan menu.
            System.out.println("\n----------------------------- MENU -------------------------------\n");
            System.out.println("Silakan pilih menu:");
            System.out.println("1. Kunjungi suatu Tempat");
            System.out.println("2. Lakukan sebuah aktivitas di Tempat tertentu");
            System.out.println("3. Selesaikan tur");
            System.out.println("4. Keluar");
            System.out.print("\nPilih: ");

            // Exceptionals yang ditujukkan agar ketika user memasukkan input yang tidak valid tidak terjadi error.
            try {
                pilihan = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }
            System.out.println();


            // Penerapan conditionals sesuai dengan yang seharusnya sudah ada pada menu yang tersedia.
            // Conditionals tersebut diantaranya, kunjungi, beraktivitas, dan lainnya.
            if (pilihan == KUNJUNGI) {
                System.out.println("Mau berkunjung kemana? Jika ingin melihat semua tempat yang ada,");
                System.out.println("Ketik \"List Tempat\"");
                namaTempat = input.nextLine();
                if(namaTempat.equalsIgnoreCase("List Tempat")){
                    for (Tempat t : Tempat.semuaTempat) {
                        System.out.println(t.toString()+"\n");
                    }
                } else {
                    kunjungiTempat(namaTempat);
                }
                namaTempat = "";
            } else if (pilihan == BERAKTIVITAS) {
                System.out.println("Mau beraktivitas apa, dan dimana? Format: Aktivitas;Nama Tempat");
                System.out.println("Jika ingin melihat apa saja yang bisa dilakukan di suatu tempat, ketik:");
                System.out.println("\"List Aktivitas\".");
                System.out.println("Ketik \"List Tempat\" untuk melihat semua tempat yang ada.");
                String perintah = input.nextLine();
                if(perintah.equals("List Tempat")){
                    for (Tempat t : Tempat.semuaTempat) {
                        System.out.println(t.toString()+"\n");
                    }
                } else if(perintah.contains("List Aktivitas")){
                    System.out.println("Di Gedung, kamu bisa Belajar <nama ruangan>.");
                    System.out.println("Di Perpustakaan, kamu bisa Baca Buku <nama buku>.");
                    System.out.println("Di LabKomputer, kamu bisa Gunakan Komputer.");
                    System.out.println("Di Kantin, kamu bisa Beli <nama makanan atau minuman>.");
                } else {
                    aktivitas = perintah.split(";")[0];
                    namaTempat = perintah.split(";")[1];
                    lakukanAktivitas(aktivitas, namaTempat);
                }
                aktivitas = "";
                namaTempat = "";
            } else if (pilihan == SELESAI) {
                rekapKunjungan();
                System.out.println();
                rekapAktivitas();
                System.out.println("\nVirtual Tournya selesai!");
                System.out.println("Sampai jumpa!");
                exit = true;
            } else if (pilihan == KELUAR) {
                System.out.println("\nVirtual Tournya selesai!");
                System.out.println("Sampai jumpa!");
                exit = true;
            } else if (pilihan == DEBUG) {
                System.out.println("=================DEBUGGING=================");
                System.out.println("Tempat yang berhasil didaftarkan:");
                for (Tempat t : Tempat.semuaTempat) {
                    System.out.println(t.toString());
                    System.out.println("");
                }
                System.out.println("=================DEBUGGING=================");
            }
        }

    }


    // Implementasi method untuk menjalankan apa yang dibutuhkan untuk menjalankan program utuhnya.
    // Proses menjalankan program ini akan memanfaatkan file txt yang disediakan nantinya.
    private void run() {
        System.out.println("====================== Virtual Tour Fasilkom UI =======================\n");
        System.out.println("Selamat datang di Aplikasi Virtual Tour Fasilkom UI!");
        System.out.println("Sedang mengisi Database dengan data dari file denah-fasilkom.txt");
        parseData();
        System.out.println("Selesai mengisi Database. Selamat menikmati Virtual Tournya!");

        daftarMenu();
        input.close();
    }


    // Method main untuk menjalankan program.
    public static void main(String[] args) {
        Mahasiswa mhs = new Mahasiswa();
        mhs.run();
    }


    // Implementasi method yang ditujukan untuk melakukan penambahan histori aktivitas.
    private void tambahArrayListAktivitas(String value) {
        String[] temp = Arrays.copyOf(this.listAktivitasDilakukan, this.listAktivitasDilakukan.length+1);
        temp[this.listAktivitasDilakukan.length] = value;
        this.listAktivitasDilakukan = temp;
    }


    // Implementasi method yang ditujukan untuk melakukan penambahan histori junjungan.
    private void tambahArrayTempatDikunjungi(String value) {
        String[] temp = Arrays.copyOf(this.listTempatDikunjungi, this.listTempatDikunjungi.length+1);
        temp[this.listTempatDikunjungi.length] = value;
        this.listTempatDikunjungi = temp;
    }


    // Secara umum:
    // Implementasi method untuk membaca data dari file txt.
    // Data ini kemudian juga yang menjadi sebuah deskripsi dari suatu tempat.
    private void parseData(){
        try {
            Scanner reader = new Scanner(new File("denah-fasilkom.txt"));
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                String[] temp = null;
                if (data.contains("number")) {
                    int jumlah = Integer.parseInt(data.split(" ")[2]);
                    if (data.contains("gedung")) {
                        for (int i = 0; i < jumlah; i++) {
                            temp = reader.nextLine().split(";");
                            // Urutan: Nama, Lokasi, deskripsi
                            Gedung gedung = new Gedung(temp[0], temp[1], temp[2]);
                            Tempat.tambahArrayTempat(gedung);
                        }
                    } else if (data.contains("labkom")) {
                        for (int i = 0; i < jumlah; i++) {
                            temp = reader.nextLine().split(";");
                            // Urutan: Nama, Lokasi persis, jumlah komputer, deskripsi
                            LabKomputer labkom = new LabKomputer(temp[0], temp[2], temp[4], Integer.parseInt(temp[3]));
                            Tempat.tambahArrayTempat(labkom);
                        }
                    }
                } else if (data.contains("activitynum")) {
                    String namaTempat = data.split(";")[1];
                    int jumlah = Integer.parseInt(data.split(";")[2]);
                    Tempat tempat = Tempat.getTempat(namaTempat);
                    for (int i = 0; i < jumlah; i++) {
                        String aktivitas = reader.nextLine();
                        Gedung g = (Gedung) tempat;
                        g.tambahRuangan(aktivitas);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File denah-fasilkom.txt tidak ditemukan, harap cek keberadaan filenya lalu jalankan ulang.");
        }
        
    }
}
