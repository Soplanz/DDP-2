/** Implementasi class GameCharacter yang bisa dibilang juga sebagai class induk. **/
public abstract class GameCharacter {
    


    /* Inisialisasi instance variable. */
    private int lifePoint, attackPoint;
    private boolean isAlive;

	

    /* Konstruktor dari class GameCharacter. */
    public GameCharacter(int lifePoint, int attackPoint) {
        this.lifePoint = lifePoint;
        this.attackPoint = attackPoint;
        this.isAlive = true;
    }



    /* Getter untuk attribut lifePoint. */
    public int getLifePoint(){
        return this.lifePoint;
    }



    /* Getter untuk attribut attackPoint. */
    public int getAttackPoint(){
        return this.attackPoint;
    }



    /* Getter untuk attribut isAlive */
    public boolean getIsAlive(){
        this.isAlive = this.getLifePoint() >= 1 ? true : false;
        return this.isAlive;
    }



    /* Setter untuk attribut lifePoint. */
    public void setLifePoint(int lifePoint){


        // Mengubah nilai attribut dari lifePoint.
        this.lifePoint = lifePoint;
    }



    /* Setter untuk attribut attackPoint. */
    public void setAttackPoint(int attackPoint){


        // Mengubah nilai attribut dari attackPoint.
        this.attackPoint = attackPoint;
    }



    /* Implementasi suatu method abstract yang akan dioverride pada class turunannnya. */
    public abstract void attack(GameCharacter gameCharacter);
}