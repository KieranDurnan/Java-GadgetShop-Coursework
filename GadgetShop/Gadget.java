public class Gadget{
    // Variables of the Gadget superclass

    protected double price; //in pounds
    protected int weight;
    protected String model;
    protected String size; // Height x Width x Depth

    //Gadget constructor
    public Gadget(double gadgetPrice,int gadgetWeight, String gadgetmodel, String gadgetSizeHeightmmxWidthmmxDepthmm){
        price = gadgetPrice;
        weight = gadgetWeight;
        model = gadgetmodel;
        size = gadgetSizeHeightmmxWidthmmxDepthmm; // Height x Width x Depth

    }

    //This method returns the gadget price
    public double getPrice(){
        return price;
    }

    //This method returns the gadget weight
    public int getWeight(){
        return weight;
    }

    //This method returns the model of the gadget
    public String getModel(){
        return model;
    }

    //This method returns size of the gadget (Height mm X Width mm X Depth mm)
    public String getSize(){
        return size;
    }

    //This method prints out the information for the relevant instance of gadget
    public void getGadgetInfo(){
        System.out.println("Your selected device is shown below");
        System.out.println("Model: "+ model);
        System.out.println("Price: £"+ price); 
        System.out.println("Weight: "+ weight+ " Grams");
        System.out.println("Size (HxWxD mm): "+ size);
    }

}