import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.FlowLayout;
import java.util.ArrayList;

public class GadgetShop implements ActionListener
{
    //The fields for GadgetShop GUI class
    private JTextField modelTextField;
    private JTextField priceTextField;
    private JTextField weightTextField;
    private JTextField sizeTextField;
    private JTextField creditTextField;
    private JTextField memoryTextField;
    private JTextField phoneNumberTextField;
    private JTextField callDurationTextField;
    private JTextField albumTitleTextField;
    private JTextField downloadSizeTextField;
    private JTextField displayNumberTextField;
    private JButton addMobileButton;
    private JButton addMP3Button;
    private JButton displayAllButton;
    private JButton downloadMusicButton;
    private JButton makeCallButton;
    private JButton clearButton;
    private JFrame frame;
    private JPanel topPanel;
    private JPanel main;
    private JPanel bottom;
    ArrayList<Gadget> gadgetList = new ArrayList<Gadget>();

    /**
     * The GUI is created in the constructor
     */ 
    public GadgetShop()
    {
        frame = new JFrame("Gadget Shop");
        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());

        //panel list
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        JPanel middleLeft = new JPanel();
        JPanel middleMiddle = new JPanel();
        JPanel middleRight = new JPanel();
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        JPanel leftBorder = new JPanel();
        JPanel rightBorder = new JPanel();

        //Label List
        JLabel welcome = new JLabel("Welcome to Kieran's Gadget Shop");
        JLabel model = new JLabel("Model:");
        JLabel price = new JLabel("Price:");
        JLabel weight = new JLabel("Weight:");
        JLabel size = new JLabel("Size:");
        JLabel dimensions = new JLabel("H x W x D mm");
        JLabel credit = new JLabel("Credit:");
        JLabel memory = new JLabel("Memory:");
        JLabel phoneNumber = new JLabel("Phone Number:");
        JLabel callDuration = new JLabel("Duration:");
        JLabel albumTitle = new JLabel("Album Title:");
        JLabel downloadSize = new JLabel("Download Size:");
        JLabel displayNumber = new JLabel("Display Number:");
        JLabel mobile = new JLabel ("MOBILE");
        JLabel mP3 = new JLabel ("MP3");
        JLabel empty = new JLabel ("");

        //Text Fields
        modelTextField = new JTextField(15);
        priceTextField = new JTextField(15);
        weightTextField = new JTextField(15);
        sizeTextField = new JTextField(15);
        creditTextField = new JTextField(15);
        memoryTextField = new JTextField(15);
        phoneNumberTextField = new JTextField(15);
        callDurationTextField = new JTextField(15);
        albumTitleTextField = new JTextField(15);
        downloadSizeTextField = new JTextField(15);
        displayNumberTextField = new JTextField(15);

        //Buttons
        addMobileButton = new JButton ("Add Mobile");
        addMobileButton.addActionListener(this);
        addMP3Button = new JButton ("Add MP3");
        addMP3Button.addActionListener(this);
        displayAllButton = new JButton ("Display All");
        displayAllButton.addActionListener(this);
        downloadMusicButton = new JButton ("Download");
        downloadMusicButton.addActionListener(this);
        makeCallButton = new JButton ("Make Call");
        makeCallButton.addActionListener(this);
        clearButton = new JButton ("Clear");
        clearButton.addActionListener(this);

        //Adding a border to the content pane to surround content
        contentPane.add(leftBorder, BorderLayout.WEST);
        contentPane.add(rightBorder, BorderLayout.EAST);

        //Building Top Panel 
        contentPane.add(top, BorderLayout.NORTH);
        top.add(welcome);

        //Building Center
        JPanel centerPanel = new JPanel();
        contentPane.add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new GridLayout(1,3));
        centerPanel.add(middleLeft);
        centerPanel.add(middleMiddle);
        centerPanel.add(middleRight);

        middleLeft.setLayout(new GridLayout(5, 2)); 
        middleMiddle.setLayout(new BoxLayout(middleMiddle, BoxLayout.Y_AXIS));
        middleRight.setLayout(new BoxLayout(middleRight, BoxLayout.Y_AXIS));

        //Middle Left Panel
        middleLeft.add(model);
        middleLeft.add(modelTextField);
        middleLeft.add(weight);
        middleLeft.add(weightTextField);
        middleLeft.add(size);
        middleLeft.add(sizeTextField);
        middleLeft.add(dimensions);
        middleLeft.add(empty);
        middleLeft.add(price);
        middleLeft.add(priceTextField);

        //Middle Middle Panel
        middleMiddle.add(mobile);
        middleMiddle.add(Box.createVerticalGlue());
        middleMiddle.add(credit);
        middleMiddle.add(creditTextField);
        middleMiddle.add(addMobileButton);
        middleMiddle.add(Box.createVerticalGlue());
        middleMiddle.add(phoneNumber);
        middleMiddle.add(phoneNumberTextField);
        middleMiddle.add(callDuration);
        middleMiddle.add(callDurationTextField);
        middleMiddle.add(makeCallButton);
        middleMiddle.add(Box.createVerticalGlue());

        //Building Middle Right
        middleRight.add(mP3);
        middleRight.add(Box.createVerticalGlue());
        middleRight.add(memory);
        middleRight.add(memoryTextField);
        middleRight.add(addMP3Button);
        middleRight.add(Box.createVerticalGlue());
        middleRight.add(albumTitle);
        middleRight.add(albumTitleTextField);
        middleRight.add(downloadSize);
        middleRight.add(downloadSizeTextField);
        middleRight.add(downloadMusicButton);
        middleRight.add(Box.createVerticalGlue());

        //Bottom Panel
        contentPane.add(bottom, BorderLayout.SOUTH);
        bottom.setLayout(new FlowLayout());
        bottom.add(Box.createHorizontalGlue()); 
        bottom.add(clearButton);
        bottom.add(Box.createHorizontalGlue());
        bottom.add(displayAllButton);
        bottom.add(Box.createHorizontalGlue()); 
        bottom.add(displayNumber);
        bottom.add(displayNumberTextField);
        bottom.add(Box.createHorizontalGlue());

        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);

        //create file menu
        JMenu fileMenu = new JMenu("File");
        menubar.add(fileMenu);

        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(this);
        fileMenu.add(quitItem);

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);

    }

    /**
     * The main method creates the instance of the GadgetShop
     */ 
    public static void main(String[] args)
    {
        GadgetShop shop = new GadgetShop();
    }

    /**
     * This method enables the interaction with the buttons linking to the action listener
     */
    public void actionPerformed(ActionEvent event)
    {
        String command = event.getActionCommand();
        switch(command){
            case "Clear": clear();
                break;
            case "Add MP3": addMP3();
                break;
            case "Display All": displayAll();
                break;
            case "Add Mobile": addMobile();
                break;
            case "Download": downloadMusic();
                break;
            case "Make Call": makeCall();
                break;
            case "Quit": quit();
                break;

        }

    }

    //This method opens an information window and once "OK" has been pressed, it quits the GUI and closes the window
    public void quit(){
        JOptionPane.showMessageDialog(frame,"Window will be closed.", "Window Quit" ,JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    /*This method converts theretrieves the text from the priceTextField, converts it into an integer using Integer.parseInt(),
     *and stores it in the variable price and then returns the value of the price of the gadget
     */
    public double getPrice(){
        double price = Double.parseDouble(priceTextField.getText());
        return price;
    }

    //This method retreives the text from modelTextField and stores it in the model variable and then returns the model of the gadget.
    public String getModel(){
        String model = modelTextField.getText();
        return model;
    }

    /*This method converts theretrieves the text from the weightTextField, converts it into an integer using Integer.parseInt(),
     * and stores it in the variable weight and then returns the value of the weight of the gadget
     */
    public int getWeight(){
        int weight = Integer.parseInt(weightTextField.getText());
        return weight;
    }

    //This method retreives the text from sizeTextField and stores it in the size variable and then returns the size of the gadget.
    public String getSize(){
        String size = sizeTextField.getText();
        return size;
    }

    /*This method converts theretrieves the text from the memoryTextField, converts it into an integer using Integer.parseInt(),
     * and stores it in the variable memory and then returns the value of the memory of the gadget
     */
    public int getMemory(){
        int memory = Integer.parseInt(memoryTextField.getText());
        return memory;
    }

    /*This method converts theretrieves the text from the creditTextField, converts it into an integer using Integer.parseInt(),
     * and stores it in the variable credit and then returns the value of the credit of the gadget
     */
    public int getCredit(){
        int credit = Integer.parseInt(creditTextField.getText());
        return credit;
    }

    /*This method converts theretrieves the text from the callDurationTextField, converts it into an integer using Integer.parseInt(),
     *and stores it in the variable callDuration and then returns the value of the callDuration of the gadget
     */
    public int getCallDuration(){
        int callDuration = Integer.parseInt(callDurationTextField.getText());
        return callDuration;
    }

    /*This method converts theretrieves the text from the phoneNumberTextField, converts it into an integer using Integer.parseInt(),
     * and stores it in the variable phoneNumber and then returns the value of the phoneNumber of the gadget
     */
    public int getPhoneNumber(){
        int phoneNumber = Integer.parseInt(phoneNumberTextField.getText());
        return phoneNumber;
    }

    /*This method converts theretrieves the text from the downloadSizeTextField, converts it into an integer using Integer.parseInt(), 
     * and stores it in the variable downloadSize and then returns the value of the downloadSize of the gadget
     */
    public int getDownloadSize(){
        int downloadSize = Integer.parseInt(downloadSizeTextField.getText());
        return downloadSize;
    }

    /*This method converts theretrieves the text from the displauNumberTextField, converts it into an integer using Integer.parseInt(), 
     * and stores it in the variable displayNumber and then returns the value of the displayNumber of the gadget
     */
    public int getDisplayNumber() {
        try {
            int displayNumber = Integer.parseInt(displayNumberTextField.getText());
            if(displayNumber > gadgetList.size()){
                JOptionPane.showMessageDialog(frame,"There is no gadget with this display number", "Input Error" ,JOptionPane.ERROR_MESSAGE);
            }
            return displayNumber;
        } catch (NumberFormatException dn) {
            JOptionPane.showMessageDialog(frame,"Invalid display number", "Input Error" ,JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }

    /*This method uses the variables listed below to create an instance of an mp3 in the gadgetList ArrayList.
     *It then displays an information message informing of the addition of the MP3 being added.
     */
    public void addMP3(){
        MP3 mp3 = new MP3(getPrice(), getWeight(), getModel(), getSize(), getMemory());
        gadgetList.add(mp3);
        JOptionPane.showMessageDialog(frame,"MP3 sucessfully added", "System Update" ,JOptionPane.INFORMATION_MESSAGE);
        clear();
    }

    /*This method uses the variables listed below to create an instance of an mobile in the gadgetList ArrayList. 
     * It then displays an information message informing of the addition of the Mobile being added.
     */
    public void addMobile(){
        Mobile mobile = new Mobile(getPrice(), getWeight(), getModel(), getSize(), getCredit());
        gadgetList.add(mobile);
        JOptionPane.showMessageDialog(frame,"Mobile sucessfully added", "System Update" ,JOptionPane.INFORMATION_MESSAGE);
        clear();
    }

    /*
     * This method clears the console screen, retrieves information such as album title, download size, and display number from text fields, 
     * checks if the display number is valid within the gadget list, and if so, proceeds to 'download music' if the gadget is an MP3 player. 
     * It then clears the text fields. If the display number is invalid or the selected gadget is not an MP3 player, appropriate error messages are printed.
     */
    public void downloadMusic() {
        System. out. print('\u000C');
        String albumTitle = albumTitleTextField.getText();
        int downloadSize = getDownloadSize();
        int i = getDisplayNumber();

        if (i >= 0 && i < gadgetList.size()) {
            Gadget gadget = gadgetList.get(i);
            if (gadget instanceof MP3) {
                MP3 mp3 = (MP3) gadget;
                JOptionPane.showMessageDialog(frame,"Download Successful", "System Update" ,JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Download successful, updated gadget information below:");
                System.out.println(" ");
                mp3.downloadMusic(albumTitle, downloadSize);
                System.out.println(" ");
                gadget.getGadgetInfo();
            } else {
                System.out.println("The selected gadget is not an MP3");
            }
        } else {
            System.out.println("Invalid display number");
        }
        clear();
    }

    /*
     * This method clears the console screen, retrieves information such as phoneNumber, callDuration, and display number from text fields, 
     * checks if the display number is valid within the gadget list, and if so, proceeds to 'make a call' if the gadget is a Mobile. 
     * It then clears the text fields. If the display number is invalid or the selected gadget is not a Mobile, appropriate error messages are printed.
     */
    public void makeCall() {
        System. out. print('\u000C');
        String phoneNumber = phoneNumberTextField.getText();
        int callDuration = getCallDuration();
        int i = getDisplayNumber();

        if (i >= 0 && i < gadgetList.size() && (phoneNumber.length()==11)) {
            Gadget gadget = gadgetList.get(i);
            if (gadget instanceof Mobile) {
                Mobile mobile = (Mobile) gadget;
                mobile.makeCall(phoneNumber, callDuration);
                JOptionPane.showMessageDialog(frame,"Phone call Successful", "System Update" ,JOptionPane.INFORMATION_MESSAGE);
                System.out.println(" ");
                gadget.getGadgetInfo();
            } else {
                System.out.println("The selected gadget is not a mobile");
            }
        } else {
            System.out.println("Invalid display number.");
        }
        clear();
    }

    //This method clears the console screen then prints a list of all the stored gadgets and their information from the gadgetList ArrayList
    public void displayAll(){
        System. out. print('\u000C');
        if (gadgetList.size() == 0){
            JOptionPane.showMessageDialog(frame,"There are currently no gadgets in the database", "System Update" ,JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            System.out.println("All gadgets added to date are displayed below:");
            int i = 0;
            for (Gadget gadget: gadgetList) {
                if(gadget instanceof Mobile){
                    System.out.println("Gadget " + i + ": Mobile ");
                }
                if(gadget instanceof MP3){
                    System.out.println("Gadget " + i + ": MP3 ");
                }
                gadget.getGadgetInfo();
                i++;
                System.out.println(" ");
            }
        }

    }

    // This method clears the textfields on the GUI, this is accessed by multiple methods within the GUI.   
    public void clear()
    {
        modelTextField.setText("");
        priceTextField.setText("");
        weightTextField.setText("");
        sizeTextField.setText("");
        creditTextField.setText("");
        memoryTextField.setText("");
        phoneNumberTextField.setText("");
        callDurationTextField.setText("");
        albumTitleTextField.setText("");
        downloadSizeTextField.setText("");
        displayNumberTextField.setText("");
    }
}