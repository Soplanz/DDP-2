/** Implementasi custom exception untuk kasus HungerException. */
public class HungerException extends Exception {



    /** Konstruktor dari kelas custom exception, HungerException.*/
    public HungerException(){


        // Pemanggilan super konstruktor Exception.
        super("[FAILED: Dogenya lemes butuh makan :(]");
    }
}
