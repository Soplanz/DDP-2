import java.util.*;

/*
 * Simulator of Pacilmon GO
 */

public class Simulator {
    public static void main(String[] args) {
        // INITIALIZATION SECTION

        // Inisialisasi dari beberapa trainer dengan masing-masing pokemonnya.
        // Dilakukan sebuah print yang akan menampilkan informasi pokemon setiap kali selesai menambahkan pokemon pada trainer.
        
        // Konstruksi objek Trainer bernama ash.
        Trainer ash = new Trainer("Ash");

        // Penggunaan instance method yang dibarengi dengan konstruksi class pokemon.
        ash.addPokemon(new Pokemon("Sceptile", ash, 1, 100));
        ash.addPokemon(new Pokemon("Pikachu", ash, 2, 200));
        ash.addPokemon(new Pokemon("Charizard", ash, 3, 150));

        // Pencetakkan informasi dari semua pokemon yang dimiliki trainer. 
        System.out.println(ash.toString());

        // Konstruksi objek Trainer bernama may.
        Trainer may = new Trainer("May");

        // Penggunaan instance method yang dibarengi dengan konstruksi class pokemon.
        may.addPokemon(new Pokemon("Eeve", may, 1, 75));
        may.addPokemon(new Pokemon("Squirtle", may, 1, 90));
        may.addPokemon(new Pokemon("Skitty", may, 1, 85));
        may.addPokemon(new Pokemon("Venusaur", may, 3, 80));

        // Pencetakkan informasi dari semua pokemon yang dimiliki trainer.
        System.out.println(may.toString());

        // Konstruksi objek Trainer bernama may.
        Trainer james = new Trainer("James");

        // Penggunaan instance method yang dibarengi dengan konstruksi class pokemon.
        james.addPokemon(new Pokemon("Numel", james, 1, 90));
        james.addPokemon(new Pokemon("Victreebell", james, 2, 90));

        // Pencetakkan informasi dari semua pokemon yang dimiliki trainer.
        System.out.println(james.toString());
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");

        // INPUT SECTION

        /* Pada bagian ini merupakan tampilan dari user prompt ketika
           sudah menyelesaikan proses penambahan pokemon. */
        Scanner in = new Scanner(System.in);
        boolean hasChosenExit = false;
        System.out.println("Selamat datang di database Pacilmon ");
        while (!hasChosenExit) {
            System.out.println();
            System.out.println("1. Cari Pokemon berdasarkan nama");
            System.out.println("2. Cari Pokemon terkuat");
            System.out.println("3. Lihat rata-rata kekuatan Pokemon");
            System.out.println("4. Exit");
            System.out.print("Silahkan masukkan perintah yang ingin dijalankan: ");

            // Menerima input user berupa angka yang menandakan bagian menu yang dipilih user.
            int menu = in.nextInt();
            if (menu == 4) {
                hasChosenExit = true;
            } else {
                Pokemon pokemon;
                switch (menu) {
                    case 1:
                        System.out.print("Masukkan nama pokemon yang ingin dicari: ");
                        String namaPokemon = in.next();
                        pokemon = Trainer.getSpesificPokemon(namaPokemon);
                        // Jika user memilih menu nomor 1.
                        // Melakukan sebuah kondisionalisasi dimana akan ditentukan apakah pokemon yang dicari ada atau null.
                        // Jika hasil pencarian null akan di print "Pokemon tidak ditemukan."
                        if(pokemon != null)
                            System.out.println(pokemon.toString());
                        else{
                            System.out.println("Pokemon tidak ditemukan");
                        }

                        break;
                    case 2:
                        // Jika user memilih nomor 2.
                        // System akan menunjukkan informasi dari pokemon terkuat.
                        System.out.println(Trainer.getStrongestPokemon().toString());
                        break;
                    case 3:
                        // Jika user memilih nomor 3.
                        // System akan menunjukkan rata-rata kekuatan pokemon dengan menggunakan method get average battle power dari class trainer.
                        System.out.println("Rata-rata battle power para pokemon adalah " + Trainer.getAverageBattlePower());
                        break;
                    default:
                        // Jika user memilih nomor diluar pilihan menu.
                        System.out.println("Pastikan menu yang dipilih benar");
                        break;
                }
            }
        }
        
        // Pesan akhir jika user sudah memilih untuk keluar.
        System.out.println("Terima kasih sudah menggunakan database Pacilmon");
        System.out.println("---------------------------------------");
        System.out.println("---------------------------------------");
        in.close();
    }
}
