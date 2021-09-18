import java.util.*;

/*
 * TO DO: 
 * Provide Constructor
 * Write setter and getter if needed
 * Complete all TO DOs
 */
public class Pokemon {
    // Penetapan beberapa attribut dari class Pokemon
    private String name;
    private Trainer trainer;
    private int level;
    private int defaultPower;

    public Pokemon (String name, Trainer trainer, int level, int battlePower) {
        // Konstruktor dari class Pokemon dengan attribut - attribut yang ada.
        this.name = name;
        this.trainer = trainer;
        this.level = level;
        this.defaultPower = battlePower;
    }

    public int getBattlePower() {
        // Getter untuk battle power yang berisi hasil perkalian level dengan default power. 
        return this.defaultPower * this.level;
    }

    public String getName(){
        // Getter untuk mengembalikan nama dari pokemon.
        return this.name;
    }
    
    /**
     * @return string representation of the Pokemon
     */
    public String toString() {
        // Pencetakkan informasi yang dibutuhkan dari sebuah pokemon.
        return String.format("%s saat ini berada di level %d memiliki battle power sebanyak %d dan dimiliki oleh %s", this.name, this.level, this.getBattlePower(), this.trainer.getName());
    }

}
