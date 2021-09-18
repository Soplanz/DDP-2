/** Implementasi kelas Dogegochi. */ 
public class Dogegochi {
  


    /** Pendeklarasian instance variable. */
    private int energy, activityRepeat;
    private String lastActivity;



    /** Konstruktor dari kelas Dogegochi. */ 
    public Dogegochi() {


        // Inisialisasi nilai awal instance variable.
        this.energy = 50;
        this.lastActivity = "";
    }



    /** Implementasi method reduceEnergy yang digunakan untuk mengurangkan energi dari Dogegochi.*/
    public void reduceEnergy(){
        

        // Method ini akan mengurangkan energy dari dogegochi sebesar 20 (untuk aktivitas play)..
        this.energy -= 20;


        // Menangani kasus ketika energy < 0 maka energy tetap dihitung 0.
        if(this.energy < 0)
            this.energy = 0;
        
    }



    /** Implementasi method addEnergy. 
     * Method ini digunakan untuk menambahkan energi dari Dogegochi.
     * @param quantity
    */
    public void addEnergy(int quantity){
        

        // Method ini akan menambahkan energy dari dogegochi sebanyak 2 kali quantity.
        this.energy += (2 * quantity);


        // Menangani kasus ketika energy > 100 maka energy tetap dihitung 100.
        if(this.energy > 100)
            this.energy = 100;   
        
    }



    /** Implementasi method checkActivity.
     * Method ini digunakan untuk memeriksa last activity.
     * @param activity
     * @return
     */
    public boolean checkActivity(String activity) {
        

        // Pembuatan objek boolean untuk memeriksa apakah present activity sama dengan past activity.
        // Kemudian mengembalikan objek boolean tersebut. 
        boolean check = (this.lastActivity == activity) ? true : false;
        return check;
    }



    /** Implementasi method eat.
     * Method ini dilakukan sebagai implementasi dari kegiatan makan yang dilakukan oleh dogegochi.
     * @param food
     * @param quantity
     * @throws BoredException
     * @throws FullException
     */
    public void eat(String food, int quantity) throws BoredException, FullException{


        /** Kondisi ketika energy sudah full: 
         * Kegiatan eat tidak akan dicatat dalam last activity.
         * Melakukan suatu throw yaitu FullException.
        */
        if(this.energy == 100)
            throw new FullException();

        
        /** Kondisi ketika aktivitas past sama dengan present. 
         * Activity repeat akan diincrement sebesar 1.
        */
        else if(this.checkActivity("eat")){
            this.activityRepeat += 1;


            /** Ketika activity repeat belum sama dengan 3.
             * 1. Melakukan penambahan energy.
             * 2. Mencatat eat dalam aktivitas terakhir yang dilakukan.
             * 3. Mencetak output.
            */
            if(this.activityRepeat != 3){
                this.addEnergy(quantity);  // 1.
                this.lastActivity = "eat";  // 2.
                System.out.printf("[SUCCESS : Dogenya makan %s sebanyak %d dengan gembira]\n", food, quantity);  // 3.
            }


            /** Kondisi ketika activity repeat sudah berulang 3 kali sejak present activity ingin dilakukan. */
            else{
                throw new BoredException();
            }
        }


        /** Kondisi ketika past dan present activity tidak sama dan energy != 100, maka tidak ada masalah 
         * 1. Reset nilai activity repeat.
         * 2. Melakukan penambahan energy.
         * 3. Mencatat eat dalam aktivitas terakhir yang dilakukan.
         * 4. Mencetak output.
        */
        else{
            this.activityRepeat = 1;                                                                         // 1.
            this.addEnergy(quantity);                                                                        // 2.
            this.lastActivity = "eat";                                                                       // 3.
            System.out.printf("[SUCCESS : Dogenya makan %s sebanyak %d dengan gembira]\n", food, quantity);  // 4.
        }
    }



    /** Implementasi method play.
     * Method ini digunakan sebagai implementasi kegiatan play yang dilakukan dogegochi.
     * @throws HungerException
     * @throws BoredException
     */
    public void play() throws HungerException, BoredException {


         /** Kondisi ketika energy sudah habis: 
         * Kegiatan play tidak akan dicatat dalam last activity.
         * Melakukan suatu throw yaitu HungerException.
        */
        if(this.energy == 0)
            throw new HungerException();
        

        /** Kondisi ketika aktivitas past sama dengan present. 
         * Activity repeat akan diincrement sebesar 1.
        */
        else if(this.checkActivity("play")){
            this.activityRepeat += 1;


            /** Ketika activity repeat belum sama dengan 3.
             * 1. Melakukan pengurangan energy.
             * 2. Mencatat play dalam aktivitas terakhir yang dilakukan.
             * 3. Mencetak output.
            */
            if(this.activityRepeat != 3){
                this.reduceEnergy();                                                    // 1.
                this.lastActivity = "play";                                             // 2.
                System.out.printf("[SUCCESS : Dogenya bermain dengan senang hati]\n");  // 3.
            } 


            /** Kondisi ketika activity repeat sudah berulang 3 kali sejak present activity ingin dilakukan. */
            else{
                throw new BoredException();
            }
        } 


        /** Kondisi ketika past dan present activity tidak sama dan energy != 100, maka tidak ada masalah 
         * 1. Reset nilai activity repeat.
         * 2. Melakukan pengurangan energy.
         * 3. Mencatat play dalam aktivitas terakhir yang dilakukan.
         * 4. Mencetak output.
        */
        else{
            this.activityRepeat = 1;                                                // 1.
            this.reduceEnergy();                                                    // 2.
            this.lastActivity = "play";                                             // 3.
            System.out.printf("[SUCCESS : Dogenya bermain dengan senang hati]\n");  // 4.
        }
    }



    /** Implementasi method getStatus.
     * Method ini digunakan untuk mencetak status dari dogegochi.
     */
    public void getStatus() {


        // Mencetak output yang diharapkan.
        System.out.println("Status Doge:");
        System.out.println("Energy = " + this.energy);
    }
}
