/** Implementasi class Goblin yang merupakan kelas turunan dari class Monster. **/
public class Goblin extends Monster {

	

    /* Konstruktor dari class Goblin */
    public Goblin(int lifePoint, int attackPoint) {


        // Pemanggilan super konstuktor.
        super(lifePoint, attackPoint);
    }



    /* Implementasi method attack yang dioverride. */
    @Override
    public void attack(GameCharacter player) {


        // Inisialisasi sebuah random point sesuai spesifikasi soal.
        // 0 hingga 4 inklusif.
        int randomPoint = (int) (Math.random() * 5); 


        // Implementasi nilai lifePoint yang telah dikurangkan dengan jumlah attack point dan randomPoint.
        // Penggunaan setLifePoint untuk mengurangi life point player yang bersangkutan.
        int newLifePoint = player.getLifePoint() - (this.getAttackPoint() + randomPoint);
        player.setLifePoint(newLifePoint);
        
        
        // Explicit casting GameCharacter object menjdai sebuah objek Player.
        // Explicit casting dimaksudkan agar method getName bisa diimplementasikan.
        Player converted = (Player) player;


        // Mencetak expected output saat program berjalan.
        System.out.printf("%s received %d point(s) damage from Goblin.\n", converted.getName(), randomPoint + this.getAttackPoint());
    }

    

    /* Implementasi method dropItem yang di override. */
    @Override
    public void dropItem(Player player){


        // Inisialisasi sebuah random point sesuai spesifikasi soal.
        // -10 hingga 10 inklusif.
        int randomPoint = -10 + (int) (Math.random() * 21);


        // Implementasi penambahan attackPoint dari player yang bersangkutan
        player.setAttackPoint(player.getAttackPoint() + randomPoint); 


        // Mencetak expected output saat program berjalan.
        System.out.println("Goblin has been defeated. It dropped an attack potion.");
        System.out.printf("The potion added %d point(s) to your attackPoint.\n", randomPoint);
    }



    /* Implementasi method toString yang dioverride dari class Object. 
       Menampilkan informasi-informasi yang diharapkan. */
    @Override
    public String toString(){
        return String.format("Goblin | lifePoint: %d, attackPoint: %d", this.getLifePoint(), this.getAttackPoint());
    }
}