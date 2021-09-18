/** Implementasi custom exception untuk kasus BoredException. */
public class BoredException extends Exception{
    


    /** Konstruktor dari kelas custom exception, BoredException.*/
    public BoredException(){


        // Pemanggilan super konstruktor Exception.
        super("[FAILED: Dogenya bosan nih, gak mau melakukan hal lain saja?]");
    }
}
