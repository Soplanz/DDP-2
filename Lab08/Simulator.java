/** Import scanner untuk kebutuhan user input. */
import java.util.Scanner;


/** Implementasi class simulator yang diperuntukkan menjalankan program. */
public class Simulator {



    /** Main method.
     * Tempat operasi program dilaksanakan.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{


        // Pembuatan beberapa variable yang dibutuhkan untuk menjalankan program.
        Scanner input = new Scanner(System.in);
        Dogegochi dogegochi = new Dogegochi();
        boolean looper = true;
        String commandString;


        // User prompt.
        System.out.println("Selamat Datang di Dogegochi!");
        System.out.println("Perintah yang dapat dijalankan Dogegochi :");
        System.out.println("1. Main");
        System.out.println("2. Makan");
        System.out.println("3. Selesai Bermain");


        // While loop untuk menerima input dari user.
        // Dijalankan berulangkan hingga user memilih opsi 3 yaitu "Selesai Bermain".
        while(looper) {


            // Pencetakkan output status setiap kali jalan beserta penerimaan perintah.
            System.out.println();
            dogegochi.getStatus();
            System.out.print("Masukkan Perintah: ");
            commandString = input.nextLine();
            int command = Integer.parseInt(commandString);
          

            // Suatu try-catch block untuk menangkap error yang ada.
            try{


                // Block try.
                // Pemeriksaan statement dari kondisi yang terpenuhi.
                // Pelaksanaan kondisional sesuai dengan nomor opsi.
                if (command == 1) {
                    dogegochi.play();
                } else if (command == 2) {
                    System.out.print("Masukkan Makanan dan jumlahnya: ");
                    String food = input.nextLine();
                    String[] foodCommand = food.split(" ");
                    int quantity = Integer.parseInt(foodCommand[1]);
                    dogegochi.eat(foodCommand[0], quantity);
                } else if (command == 3) {
                    looper = false;
                } else {
                    System.out.println("[FAILED: Doge tidak mengerti perintah ini]");
                }
            } 
            
            
            // Handling error untuk arrayindexoutofbounds dengan error message yang diharapkan.
            catch(ArrayIndexOutOfBoundsException ar){
                System.out.println("[FAILED: Kamu tidak memberikan jumlah makanan yang ingin diberikan]");
            } 
            
            
            // Handling error untuk NumberFormatExceptions dengan error message yang diharapkan.
            catch(NumberFormatException ne){
                System.out.println("[FAILED: Jumlah makanan harus berupa angka]");
            } 
            
            
            // Handling error untuk BoredException dengan error message yang diharapkan.
            catch(BoredException bor){
                System.out.println(bor.getMessage());
            } 
            
            
            // Handling error untuk FullException dengan error message yang diharapkan.
            catch(FullException fe){
                System.out.println(fe.getMessage());
            } 
            
            
            // Handling error untuk HungerException dengan error message yang diharapkan.
            catch(HungerException he){
                System.out.println(he.getMessage());
            }
        }


        // Ketika sistem sudah selesai dijalankan.
        System.out.println("[Bye-bye doge!!]");
        input.close();
    }
}
