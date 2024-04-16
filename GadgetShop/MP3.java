import java.util.ArrayList;

public class MP3 extends Gadget{
    public int memory; // An MP3 specific attribute of type int called "memory"
    public static ArrayList <Music> musicList = new ArrayList<>(); //An array list to improve the functionality of the deleteMusic() method

    //The MP3 Contructor
    public MP3(double gadgetPrice,int gadgetWeight, String gadgetmodel, String gadgetSize_HeightmmxWidthmmxDepthmm, int availableMemory){
        super(gadgetPrice, gadgetWeight, gadgetmodel, gadgetSize_HeightmmxWidthmmxDepthmm); //calling the attributes from the gadget superclass
        memory = availableMemory; //Assigning a parameter name to the attribute of memory.
    }

    /* This method prints the information about the gadget using the method in the superclass
     * as well as the remaining memory from this class.
     */
    public void getGadgetInfo(){
        super.getGadgetInfo();
        System.out.println("Remaining Memory: " + memory + " MB");
    }

    //This method returns the remaining free memory of the CopyOfMP3.
    public int getAvailableMemory(){
        return memory;
    }

    //This method allows the user to download an album by entrering the title and the memory it takes up, the 'download' is then added to the array list and the available memory is reduced.
    public void downloadMusic(String albumTitle, int downloadSize){
        if(memory < downloadSize){
            System.out.println("Insufficient memory, the clear space or download a smaller file.");
        }
        else{
            memory = memory -= downloadSize;
            Music newMusic = new Music(albumTitle, downloadSize);
            musicList.add(newMusic);
            System.out.println("Revised remaining available memory: " + memory + "MB");
            System.out.println(" ");
            for (int i = 0; i < musicList.size(); i++) {
                System.out.println("Album Number " + i + ": " + musicList.get(i).album + " " + musicList.get(i).download + " MB");
            }
        }
    }

    /*This method deletes music by accepting the album number, this references it's position in the
     * ArrayList. It then removes the both the album title and the corresponding memory value.
     * The memory value of index is then added back onto the amount of memory left.
     */
    public void deleteMusic(int albumNumber) {
        if (albumNumber <= musicList.size() && albumNumber >= 0) {
            memory += musicList.get(albumNumber).download;
            musicList.remove(albumNumber);
            System.out.println("Album deleted");
            System.out.println(" ");
            System.out.println("Updated remaining memory: " + memory + "MB");
            System.out.println(" ");
            int i = 0;
            while (i < musicList.size()) {
                System.out.println("Album Number " + i + ": " + musicList.get(i).album + " " + musicList.get(i).download + " MB");
                i++;
            }
        } else {
            System.out.println("Please select a valid album number to delete.");
        }
    }

    //This method returns the value of the available memory
    public int getMemory(){
        return memory;
    }
}
