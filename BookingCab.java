import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BookingCab implements Booking, ActionListener {
    Scanner sc=new Scanner(System.in);
    private String user;
    private String pass;
    private String location;
    private String quality;
    private int seats;
    private String cab;
    private String type;
    private final String Cab_Status="NON-Available";
    private String Cus_Cab_Name;
    private String availability;
    private String check_Booked;
    private String Customer_Name;
    private int Customer_age;
    private String Customer_gender;
    private String Customer_Cnic;
    private String Customer_PhNo;
    private String BookID;
    private String car;
    JFrame[] frame;
    JPanel[] panel;
    JButton[] button;
    JTextField[] jtf;
    JComboBox[] jComboBox;
    JCheckBox[] jCheckBox;
    JLabel[] label;
    public BookingCab(){
        this.Customer_Name="";
        this.Customer_Cnic="";
        this.Customer_gender="";
        this.Customer_PhNo="";
        this.Customer_age=0;
        frame=new JFrame[100];
        jtf=new JTextField[100];
        jCheckBox=new JCheckBox[100];
        button=new JButton[100];
        label=new JLabel[100];
        panel=new JPanel[100];
    }
    public String isCar() {
        return car;
    }
    public void setCar(String car) {
        this.car = car;
    }
    public String getBookID() {
        return BookID;
    }
    public void setBookID(String bookID) {
        BookID = bookID;
    }
    public String getQuality() {
        return quality;
    }
    public String getCar() {
        return car;
    }
    public String getCheck_Booked() {
        return check_Booked;
    }
    public void setCheck_Booked(String check_Booked) {
        this.check_Booked = check_Booked;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setSeats(int seats) {
        this.seats = seats;
    }
    public String getLocation() {
        return location;
    }
    public void setQuality(String quality) {
        this.quality = quality;
    }
    public int getSeats() {
        return seats;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Sub")){
            this.user=jtf[0].getText();
            this.pass=jtf[1].getText();
            boolean b=verify();
            if(b==true){
                frame[0].setVisible(false);
                Book();
            }
            else {
                JOptionPane.showMessageDialog(null,"Not Verified","ERROR!!",JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getActionCommand().equals("Car")){
            this.type="Car";
            label[4].setVisible(true);
            jCheckBox[4].setVisible(true);
            jCheckBox[3].setVisible(true);
        } else if (e.getActionCommand().equals("Bike")) {
            this.type="Bike";
            label[4].setVisible(false);
            jCheckBox[4].setVisible(false);
            jCheckBox[3].setVisible(false);
            this.quality="Non-AC";
        } else if (e.getActionCommand().equals("Rickshaw")) {
            this.type="Rickshaw";
            label[4].setVisible(false);
            jCheckBox[4].setVisible(false);
            jCheckBox[3].setVisible(false);
            this.quality="Non-AC";
        }
        if(e.getActionCommand().equals("AC")){
            this.quality="AC";
        } else if (e.getActionCommand().equals("Non-AC")) {
            this.quality="Non-AC";
        }
        if(e.getActionCommand().equals("Search")){
            this.location=jtf[2].getText();
            int n=display();
            if(n==1){
                done_Book();
                frame[1].setVisible(false);
            }
        }
        if(e.getActionCommand().equals("OK")){
            this.BookID=jtf[3].getText();
            changeStatus(Integer.parseInt(this.BookID));
            frame[3].setVisible(false);
        }

    }

    @Override
    public void login() {
        /*System.out.print("Enter userName: ");
        setUserName(sc.nextLine());
        System.out.print("Enter Password: ");
        setPassword(sc.nextLine());*/
        frame[0]=new JFrame("Registered");
        frame[0].setSize(320,300);
        frame[0].setVisible(true);
        panel[0]=new JPanel(null);
        label[0]=new JLabel("UserName");
        label[0].setBounds(20,30,100,30);
        label[1]=new JLabel("Password");
        label[1].setBounds(20,80,100,30);
        jtf[0]=new JTextField();
        jtf[0].setBounds(150,30,120,30);
        jtf[0].setActionCommand("User");
        jtf[0].addActionListener(this);


        jtf[1]=new JTextField();
        jtf[1].setBounds(150,80,120,30);
        jtf[1].setActionCommand("Pass");
        jtf[1].addActionListener(this);


        button[0]=new JButton("Submit");
        button[0].setBounds(180,150,90,40);
        button[0].setActionCommand("Sub");
        button[0].addActionListener(this);

        panel[0].add(label[0]);
        panel[0].add(label[1]);
        panel[0].add(jtf[0]);
        panel[0].add(jtf[1]);
        panel[0].add(button[0]);
        frame[0].add(panel[0]);
    }
    @Override
    public boolean verify() {
        BufferedReader br=null;
        int p=0;
        try{
            br=new BufferedReader(new FileReader("C:\\Users\\PMYLS\\IdeaProjects\\GUI Cab continue\\src\\Password.txt"));
            String line;
            while((line= br.readLine())!=null){
                String[] parts=line.split(",");
                String cnic=parts[0].trim();
                String userName=parts[1].trim();
                String password=parts[2].trim();
                if(userName.equals(this.user) && password.equals(this.pass)){
                    p=1;
                    break;
                }
            }
        }catch (IOException ie){ie.printStackTrace();}
        catch (Exception e){e.printStackTrace();}
        finally {
            if(br!=null){
                try{
                    br.close();
                }catch (IOException ie){ie.printStackTrace();}
                catch (Exception e){e.printStackTrace();}
            }
        }
        if(p==1){
            JOptionPane.showMessageDialog(null,"Successfully Login","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        else {

            return false;
        }
    }
    @Override
    public void Book(){
        frame[1]=new JFrame("Book Cab");
        panel[1]=new JPanel(null);
        frame[1].setVisible(true);
        frame[1].setSize(500,350);
        label[2]=new JLabel("Location");
        label[2].setBounds(20,20,120,30);
        jtf[2]=new JTextField();
        jtf[2].setBounds(160,20,130,30);
        jtf[2].addActionListener(this);
        jtf[2].setActionCommand("Location");
        //action

        label[3]=new JLabel("Type");
        label[3].setBounds(20,70,120,30);
        jCheckBox[0]=new JCheckBox("Car");
        jCheckBox[1]=new JCheckBox("Bike");
        jCheckBox[2]=new JCheckBox("Rickshaw");
        ButtonGroup bg=new ButtonGroup();
        bg.add(jCheckBox[0]);
        bg.add(jCheckBox[1]);
        bg.add(jCheckBox[2]);
        jCheckBox[0].setBounds(160,70,60,30);
        jCheckBox[1].setBounds(220,70,60,30);
        jCheckBox[2].setBounds(280,70,100,30);
        jCheckBox[0].setActionCommand("Car");
        jCheckBox[1].setActionCommand("Bike");
        jCheckBox[2].setActionCommand("Rickshaw");
        jCheckBox[0].addActionListener(this);
        jCheckBox[1].addActionListener(this);
        jCheckBox[2].addActionListener(this);
        //action

        label[4]=new JLabel("Quality");
        jCheckBox[3]=new JCheckBox("AC");
        jCheckBox[4]=new JCheckBox("Non-AC");
        label[4].setBounds(20,120,120,30);
        jCheckBox[3].setBounds(160,120,60,30);
        jCheckBox[4].setBounds(220,120,60,30);
        ButtonGroup bg1=new ButtonGroup();
        bg1.add(jCheckBox[3]);
        bg1.add(jCheckBox[4]);
        jCheckBox[3].setActionCommand("AC");
        jCheckBox[3].addActionListener(this);
        jCheckBox[4].setActionCommand("Non-AC");
        jCheckBox[4].addActionListener(this);
        //action

        button[1]=new JButton("Search");
        button[1].setBounds(100,200,80,40);
        button[1].setActionCommand("Search");
        button[1].addActionListener(this);
        //action

        panel[1].add(label[2]);
        panel[1].add(label[3]);
        panel[1].add(label[4]);


        panel[1].add(jtf[2]);


        panel[1].add(jCheckBox[0]);
        panel[1].add(jCheckBox[1]);
        panel[1].add(jCheckBox[2]);
        panel[1].add(jCheckBox[3]);
        panel[1].add(jCheckBox[4]);

        panel[1].add(button[1]);
        frame[1].add(panel[1]);
        /*System.out.print("Enter Pick-Up Location: ");
        this.location=sc.nextLine();
        System.out.println("->Press 1 If you want Car.");
        System.out.println("->Press 2 If You Bike.");
        System.out.println("->Press 3 If You Want Rickshaw.");
        char c=sc.next().charAt(0);
        switch(c){
            case '1':{
                this.type="Car";
                System.out.println("For AC Press........1");
                System.out.println("For Non-AC Press....2");
                int n=sc.nextInt();
                sc.nextLine();
                if(n==1){
                    this.quality="AC";
                }
                else {
                    this.quality="NON-AC";
                }

                break;
            }
            case '2':{
                this.type="Bike";
                this.quality="Non-AC";
                break;
            }
            case '3':{
                this.type="Rickshaw";
                this.quality="Non-AC";
                break;
            }
            default:{
                System.out.println("Wrong Input!!!");
                break;
            }
        }*/
    }
    @Override
    public int display() {
        int p=0;
        int pp=0;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\PMYLS\\IdeaProjects\\GUI Cab continue\\src\\CabDetails.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String cabID = parts[0].trim();
                String cabName = parts[1].trim();
                String cabModel = parts[2].trim();
                String cabType = parts[3].trim();
                String cabSeats = parts[4].trim();
                String cabQuality = parts[5].trim();
                String cabLocation = parts[6].trim();
                String cabPrice = parts[7].trim();
                String driverName = parts[8].trim();
                String driverPhoneNo = parts[9].trim();
                String driverExp = parts[10].trim();
                String status = parts[12].trim();
                this.availability=status;


                /*if (status.equals("Available") &&
                        location.equalsIgnoreCase(cabLocation) &&
                        type.equalsIgnoreCase(cabType) &&
                        quality.equalsIgnoreCase(cabQuality)) {
                    System.out.println("Hello");
                    if (type.equals("Car")) {
                            printCabDetails(cabID, cabName, cabModel, cabType, cabSeats, cabQuality, cabLocation, cabPrice, driverName, driverPhoneNo, driverExp);
                    } else {
                        printCabDetails(cabID, cabName, cabModel, cabType, cabSeats, cabQuality, cabLocation, cabPrice, driverName, driverPhoneNo, driverExp);
                    }
                }*/
                if(this.availability.equals("Available") && cabLocation.equals(this.location) && cabType.equals(this.type) && cabQuality.equals(this.quality)){
                    printCabDetails(cabID,cabName,cabModel,cabType,cabSeats,cabQuality,cabLocation,cabPrice,driverName,driverPhoneNo,driverExp);
                    pp=1;
                }
                else {
                    //JOptionPane.showMessageDialog(null,"This Type Of Cab Not Available.","NOT FOUND",JOptionPane.ERROR_MESSAGE);
                    p=0;
                }
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(pp==0){
            if(p==0){
                JOptionPane.showMessageDialog(null,"This Type Of Cab Not Available.","NOT FOUND",JOptionPane.ERROR_MESSAGE);
                return 0;
            }
        }
        else{
            return 1;
        }
        return 10;
    }

    private void printCabDetails(String cabID, String cabName, String cabModel, String cabType, String cabSeats, String cabQuality,
                                 String cabLocation, String cabPrice, String driverName, String driverPhoneNo, String driverExp) {
        System.out.println("Cab ID: " + cabID);
        System.out.println("Cab Name: " + cabName);
        System.out.println("Cab Model: " + cabModel);
        System.out.println("Cab Type: " + cabType);
        System.out.println("Cab Seats: " + cabSeats);
        System.out.println("Cab Quality(AC/Non-AC): " + cabQuality);
        System.out.println("Cab Pick-Up Location: " + cabLocation);
        System.out.println("Cab Price Per Km: " + cabPrice);
        System.out.println("Cab Driver Name: " + driverName);
        System.out.println("Cab Driver Phone No: " + driverPhoneNo);
        System.out.println("Cab Driver Experience: " + driverExp);
    }

    /*public int checkBooked(){  //Check Already Booked or Not.
        int p=0;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\PMYLS\\IdeaProjects\\Cab Booking System\\src\\Booked Cabs.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String id = parts[0].trim();
                this.Cus_Cab_Name = parts[1].trim();
                String status = parts[2].trim();
                if (id.equals(this.BookID) && status.equals("Booked")) {
                    p=1;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(p==1){
            return 1;
        }
        else {
            return 0;
        }
    }*/
    public void ReadCustomerData(){
        BufferedReader br=null;
        try{
            br=new BufferedReader(new FileReader("C:\\Users\\abdul\\IdeaProjects\\GUI Cab Booking System\\src\\CustomerData.txt"));
            String line;
            while((line=br.readLine())!=null){
                String[] parts=line.split(",");
                String name=parts[0].trim();
                String cnic=parts[1].trim();
                String age=parts[2].trim();
                String gender=parts[3].trim();
                String PhNo=parts[4].trim();
                if(cnic.equals(this.Customer_Cnic)){
                    this.Customer_Name=name;
                    this.Customer_Cnic=cnic;
                    this.Customer_age= Integer.parseInt(age);
                    this.Customer_gender=gender;
                    this.Customer_PhNo=PhNo;
                }
            }
        }catch (IOException ie){ie.printStackTrace();}
        catch (Exception e){e.printStackTrace();}
    }
    /*public boolean ReadCabFile(){
        int p=0;
        BufferedReader br=null;
        try{
            br=new BufferedReader(new FileReader("C:\\Users\\PMYLS\\IdeaProjects\\Cab Booking System\\src\\CabDetails.txt"));
            String line;
            while((line=br.readLine())!=null){
                String[] parts=line.split(",");
                String id= parts[0].trim();
                String name=parts[1].trim();
                int model= Integer.parseInt(parts[2].trim());
                String type=parts[3].trim();
                String seats=parts[4].trim();
                String quality=parts[5].trim();
                String location=parts[6].trim();
                double price= Double.parseDouble(parts[7].trim());
                String driverName=parts[8].trim();
                String driverPhNo=parts[9].trim();
                String driverExperience=parts[10].trim();
                if(id.equals(this.BookID)){
                    this.cab=name;
                    BufferedWriter writer=null;
                    try{
                        writer=new BufferedWriter(new FileWriter("C:\\Users\\PMYLS\\IdeaProjects\\Cab Booking System\\src\\Booked Cabs.txt",true));
                        writer.write(id);
                        writer.write(",");
                        writer.write(this.cab);
                        writer.write(",");
                        writer.write("Booked");
                        writer.newLine();
                    }catch (IOException iee){iee.printStackTrace();}
                    catch (Exception e){e.printStackTrace();}
                    finally {
                        if(writer!=null){
                            try{
                                writer.close();
                            }catch (IOException ie){ie.printStackTrace();}
                            catch (Exception e){e.printStackTrace();}
                        }
                    }
                    p=1;
                    break;
                }
            }
        }catch(IOException ie){ie.printStackTrace();}
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(br!=null){
                try{
                    br.close();
                }catch (IOException ie){ie.printStackTrace();}
                catch (Exception e){e.printStackTrace();}
            }
        }
        if (p==1) {
            return true;
        }else{
            System.out.println("This Type Of ID Not Exist.");
            return false;
        }
    }*/
    public void CheckAlreadyBooked() {
        //int x=checkBooked();
        //if(x==1){
          //  System.out.println("Already Booked");
        //}

            //ReadCustomerData();
            //boolean e=ReadCabFile();
                System.out.println("Cab Booked Successfully.");
                changeStatus(Integer.parseInt((this.BookID)));

    }
    public void done_Book(){
        frame[2]=new JFrame("ID");
        label[2]=new JLabel("ID");
        jtf[3]=new JTextField();
        jtf[3].setActionCommand("ID");
        jtf[3].addActionListener(this);
        button[5]=new JButton("OK!");
        button[5].setActionCommand("OK");
        button[5].addActionListener(this);
        panel[2]=new JPanel(null);
        frame[2].setSize(300,250);
        frame[2].setVisible(true);
        label[2].setBounds(20,20,80,30);
        jtf[3].setBounds(100,20,100,30);
        button[5].setBounds(80,80,70,40);

        panel[2].add(label[2]);
        panel[2].add(jtf[3]);
        panel[2].add(button[5]);
        frame[2].add(panel[2]);
    }
    public void changeStatus(int ID){
        int p=0;
        int pp=0;
        BufferedReader reader=null;
        BufferedWriter writer=null;
        try{
            reader=new BufferedReader(new FileReader("C:\\Users\\PMYLS\\IdeaProjects\\GUI Cab continue\\src\\CabDetails.txt"));
            String line;
            StringBuilder update=new StringBuilder();
            while((line=reader.readLine())!=null){
                String[] parts=line.split(",");
                int currentID= Integer.parseInt(parts[0].trim());
                if(currentID==ID){
                    parts[12]=this.Cab_Status;
                    pp=1;
                }
                else {
                    p=0;
                }
                update.append(String.join(",",parts)).append(System.lineSeparator());
            }
            writer=new BufferedWriter(new FileWriter("C:\\Users\\PMYLS\\IdeaProjects\\GUI Cab continue\\src\\CabDetails.txt"));
            writer.write(update.toString());
            if(pp==1) {
                JOptionPane.showMessageDialog(null, "Status Updated Successfully","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            }
            if(pp==0){
                if(p==0){
                    JOptionPane.showMessageDialog(null,"ID Not Exit","WRONG!!!",JOptionPane.ERROR_MESSAGE);
                }
            }

        }catch (IOException ie){
            ie.printStackTrace();
        }
        finally {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
