public class Mobile extends Gadget{
    //subclass speficic variable
    protected int credit;

    //Mobile sublcass constructor
    public Mobile(double gadgetPrice,int gadgetWeight, String gadgetmodel, String gadgetSize_HeightmmxWidthmmxDepthmm, int callCredit){
        super(gadgetPrice, gadgetWeight, gadgetmodel, gadgetSize_HeightmmxWidthmmxDepthmm);
        credit = callCredit;
    }

    /* This method prints the information about the gadget using the method in the superclass
     * as well as the credit variable from this class.
     */
    public void getGadgetInfo(){
        super.getGadgetInfo();
        System.out.println("Remaining Credit: " + credit + " Minutes");
    }

    //This method returns the credit balance of the mobile.
    public int getCreditBalance(){
        return credit;
    }

    /*This method increases the credit balance on the mobile by taking
     * the credit balance and increasing by the input amount.
     * If the deposit amount is less than or equal to '0' an error message.
     */ 
    public void addCredit(int creditDeposit){
        if(creditDeposit <=0){
            System.out.println("Invalid deposit amount, please add a positive credit amount");
        }
        else{credit = credit + creditDeposit;
            System.out.println("Your information and updated credit balance is displayed below.");
            getGadgetInfo();
        }
    }

    //This method enables the user to make a call by entering the desired phone call as well as the duration in minutes.
    public void makeCall (String phoneNumber, int callDuration){
        if(callDuration > credit){
            System.out.println("Insufficient credit, please input more credit prior to call or request a shorter duration.");
        }
        else if(phoneNumber.length()!=11){
            System.out.println("Input phone number is invalid");
        }
        else{
            System.out.println("Phone call successful, updated gadget information below:");
            System.out.println(" ");
            System.out.println("Number: " + phoneNumber);
            System.out.println("Duration: " + callDuration + "Minutes");
            credit = credit-callDuration;
        }
    }
}