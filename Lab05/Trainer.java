import java.util.*;

/*
 * TO DO: 
 * Provide Constructor
 * Complete all TO DOs
 * Write setter and getter if needed
 */

public class Trainer {
    // Inisiasi instance attribut dari class Trainer.
    private static Pokemon[] allPokemon = new Pokemon[30];
    private static int numOfAllPokemon;
    private Pokemon[] trainersPokemon;
    private int numOfTrainersPokemon;
    private String name;

    public Trainer(String name) {
        // Konstruktor dari class Trainer.
        this.name = name;

        // Pembuatan salah satu attribut untuk menyimpan pokemon trainer.
        // Pembatasan array untuk menyimpan karena maksimal pokemon setiap trainer 5.
        this.trainersPokemon = new Pokemon[5];
    }

    public void addPokemon(Pokemon pokemon) {
        // Pemanfaatan attribut static dan instance yang digunakan sebagai indexing.
        numOfTrainersPokemon = 0; numOfAllPokemon = 0;
        
        // Iterasi untuk menghitung jumlah pokemon pada trainers pokemon.
        for(Pokemon member : trainersPokemon){
            if(member != null)
                numOfTrainersPokemon++;
        }
        // Pokemon yang ada di parameter kemudian di tambah ke sebuah slot trainers pokemon.
        trainersPokemon[numOfTrainersPokemon] = pokemon;

        // Iterasi untuk menghitung jumlah pokemon pada all pokemon.
        for(Pokemon member : allPokemon){
            if(member != null)
                numOfAllPokemon++;
        }
        // Pokemon yang ada di parameter kemudian juga di tambah ke sebuah slot all pokemon.
        allPokemon[numOfAllPokemon] = pokemon;
    }

    public static Pokemon getSpesificPokemon(String name) {
        // Implementasi method untuk mencari pokemon yang sesuai.
        // Pembuatan sebuah Pokemon objek untuk menyimpan hasil pencarian. 
        Pokemon result = null;
        for(Pokemon member : allPokemon){
            if(member != null){
                if(member.getName().equals(name))
                    result = member;
            }
        } return result;
    }

    public static Pokemon getStrongestPokemon() {
        // Implementasi method untuk mencari pokemon dengan kekuatan terkuat.
        /* Membuat sebuah integer untuk menyimpan nilai maksimum power.  
           Selain itu juga membuat objek Pokemon untuk menyimpan Pokemon dengan kekuatan terbesar. */
        int maxPower = -1;
        Pokemon result = null;
        for(Pokemon member : allPokemon){
            if(member != null){
                if(member.getBattlePower() > maxPower){
                    maxPower = member.getBattlePower();
                    result = member;
                }
            }
        } return result;
    }

    public static int getTotalBattlePower() {
        // Implementasi method untuk mendapatkan total battle power.
        // Melakukan iterasi untuk akumulasi battle power tiap pokemon.
        int totalBattlePower = 0;
        for(Pokemon member : allPokemon){
            if(member != null)
                totalBattlePower += member.getBattlePower();
        } return totalBattlePower;
    }

    public static double getAverageBattlePower() {
        /* Implementasi method mengembalikan rata-rata battle power dengan melakukan
           pembagian dari total battle power dengan jumlah pokemon. */
        return (double) (getTotalBattlePower() / countTotalPokemon());
    }

    public static int countTotalPokemon(){
        // Implementasi method untuk menghitung total jumlah pokemon.
        int counter = 0;
        for(Pokemon member : allPokemon){
            if(member != null)
                counter++;
        } return counter;
    }

    public String getName(){
        // Implementasi method untuk mengembalikan attribut nama.
        return this.name;
    }

    /**
     * @return string representation of the Trainer
     */
    public String toString(){
        /* Implementasi untuk mencetak seluruh informasi pokemon yang dimiliki trainer. */
        StringBuilder builder = new StringBuilder();
        builder.append("Daftar pokemon milik " + this.name + ": \n");
        for (Pokemon pokemon: trainersPokemon) {
            if (pokemon == null) break;
            builder.append(pokemon.toString());
            builder.append("\n");
        }
        return builder.toString();
    }
}
