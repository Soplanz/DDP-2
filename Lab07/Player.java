/** Implementasi class Player (kelas abstrak) yang merupakan 
 * kelas turunan dari class GameCharacter yang merupakan kelas abstrak**/
public class Player extends GameCharacter {



    // Inisialisasi sebuah instance variable "name".
    private String name;



    /* Konstruktor dari class Player */
    public Player(String name) {


        // Pemanggilan super konstruktor.
        super(100, 15);


        // Inisialisasi instance attribute.
        this.name = name;
    }



    /* Implementasi method attack yang dioverride. */
    @Override
    public void attack(GameCharacter monster){


        // Implementasi nilai lifePoint yang telah dikurangkan dengan jumlah attack point.
        // Penggunaan setLifePoint untuk mengurangi life point monster yang bersangkutan.
        int newLifePoint = monster.getLifePoint() - this.getAttackPoint();
        monster.setLifePoint(newLifePoint);


        // Mencetak expected output saat program berjalan.
        System.out.printf("Monster received %d point(s) damage from Dekdepe.\n", this.getAttackPoint());
    }

    

    /* Implementasi method toString yang dioverride dari class Object. 
       Menampilkan informasi-informasi yang diharapkan. */
    @Override
    public String toString(){
        return String.format("Player | name: %s, lifePoint: %d, attackPoint: %d", 
                              this.name, this.getLifePoint(), this.getAttackPoint());
    }



    /* Implementasi getter untuk mendapatkan nama dari player. */
    public String getName(){
        return this.name;
    }
}