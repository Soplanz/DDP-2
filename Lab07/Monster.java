/** Implementasi class Monster (kelas abstrak) yang merupakan 
 * kelas turunan dari class GameCharacter yang merupakan kelas abstrak**/
public abstract class Monster extends GameCharacter {



    /* Konstruktor dari class Monster. */
    public Monster(int lifePoint, int attackPoint) {
        super(lifePoint, attackPoint);
    }



    /* Implementasi suatu method abstract yang akan dioverride pada class turunannnya. */
    public abstract void dropItem(Player player);
}