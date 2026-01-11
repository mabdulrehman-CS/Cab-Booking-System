import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class RegisterCustomer implements ActionListener {
    Scanner sc=new Scanner(System.in);
    private String Cus_Name;
    private int Cus_age;
    private String Cus_gender;
    private long Cus_PhNo;
    private long Cus_cnic;
    private String userName;
    private String password;
    private BookingCab bc;
    JFrame[] framee;
    JPanel[] panel;
    JButton[] button;
    JTextField[] jtf;
    JComboBox[] jComboBox;
    JCheckBox[] jCheckBox;
    JLabel[] jl;

    public RegisterCustomer(){
        framee=new JFrame[100];
        jtf=new JTextField[100];
        jCheckBox=new JCheckBox[100];
        button=new JButton[100];
        jl=new JLabel[100];
        panel=new JPanel[100];
        bc=new BookingCab();
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public String getCus_Name() {
        return Cus_Name;
    }

    public int getCus_age() {
        return Cus_age;
    }

    public long getCus_cnic() {
        return Cus_cnic;
    }

    public String getCus_gender() {
        return Cus_gender;
    }

    public String getPassword() {
        return password;
    }

    public long getCus_PhNo() {
        return Cus_PhNo;
    }

    public void setCus_age(int cus_age) {
        Cus_age = cus_age;
    }

    public void setCus_cnic(long cus_cnic) {
        Cus_cnic = cus_cnic;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCus_gender(String cus_gender) {
        Cus_gender = cus_gender;
    }

    public void setCus_Name(String cus_Name) {
        Cus_Name = cus_Name;
    }

    public void setCus_PhNo(long cus_PhNo) {
        Cus_PhNo = cus_PhNo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Register")){
            Cus_info();
        }
        if(e.getActionCommand().equals("B-Cab")){
            //Booking Cab.
            bc.login();
        }
        if(e.getActionCommand().equals("BACK")){
            framee[0].setVisible(false);
        }
        if(e.getActionCommand().equals("Submit")){
            this.Cus_Name=jtf[0].getText();
            try {
                this.Cus_age = Integer.parseInt(jtf[1].getText());
            }catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null,"Please Enter Valid Age","Invalid Input",JOptionPane.ERROR_MESSAGE);
                jtf[1].setText("");
                return;
            }
            try {
                this.Cus_PhNo = Long.parseLong(jtf[2].getText());
            }catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null,"Please Enter Valid Phone Number","Invalid Input",JOptionPane.ERROR_MESSAGE);
                jtf[2].setText("");
                return;
            }try {
                this.Cus_cnic = Long.parseLong(jtf[3].getText());
            }catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null,"Please Enter Valid CNIC","Invalid Input",JOptionPane.ERROR_MESSAGE);
                jtf[3].setText("");
                return;
            }
            this.userName=jtf[4].getText();
            this.password=jtf[5].getText();
            boolean c=Check_Register();
            if(c==true){
                writeInfo();
                writeAuthentication();
                JOptionPane.showMessageDialog(null,"Registered Successfully","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
                framee[1].setVisible(false);
            }
            else {
                JOptionPane.showMessageDialog(null,"Already Registered","Registered",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        if(e.getActionCommand().equals("Male")){
            this.Cus_gender="Male";
        } else if (e.getActionCommand().equals("Female")) {
            this.Cus_gender="Female";
        }
    }

    public void Choose(){
        framee[0]=new JFrame("CHOOSE");
        framee[0].setSize(300,400);
        panel[0]=new JPanel(null);
        framee[0].add(panel[0]);
        button[1]=new JButton("Register");
        button[1].setActionCommand("Register");
        button[1].addActionListener(this);

        button[2]=new JButton("Booked Cab");
        button[2].setActionCommand("B-Cab");
        button[2].addActionListener(this);

        button[3]=new JButton("BACK");
        button[3].addActionListener(this);
        button[3].setActionCommand("BACK");
        button[1].setBounds(70,30,150,40);
        button[2].setBounds(70,90,150,40);
        button[3].setBounds(70,150,150,40);

        panel[0].add(button[1]);
        panel[0].add(button[2]);
        panel[0].add(button[3]);

        framee[0].setVisible(true);
    }
    public void Cus_info(){
        framee[1]= new JFrame("Registered Customer");
        panel[1]=new JPanel(null);
        framee[1].setSize(500,600);
        framee[1].setLocation(300,20);

        jl[0]=new JLabel("Name");
        jl[0].setBounds(20,20,100,30);
        jl[1]=new JLabel("Age");
        jl[1].setBounds(20,70,100,30);
        jl[2]=new JLabel("Gender");
        jl[2].setBounds(20,120,100,30);
        jl[3]=new JLabel("Phone Number");
        jl[3].setBounds(20,170,150,30);

        jl[4]=new JLabel("CNIC");
        jl[4].setBounds(20,220,100,30);

        jl[5]=new JLabel("...Please Enter UserName and Password...");
        jl[5].setBounds(50,270,270,30);

        jl[6]=new JLabel("Set UserName");
        jl[6].setBounds(20,320,100,30);

        jl[7]=new JLabel("Set Password");
        jl[7].setBounds(20,370,100,30);

        jtf[0]=new JTextField();
        jtf[0].setBounds(180,20,120,30);
        jtf[0].addActionListener(this);
        jtf[0].setActionCommand("Name");
        //action
        jtf[1]=new JTextField();
        jtf[1].setBounds(180,70,120,30);
        jtf[1].setActionCommand("Age");
        jtf[1].addActionListener(this);
        //action
        jCheckBox[0]=new JCheckBox("Male");
        jCheckBox[1]=new JCheckBox("Female");
        ButtonGroup bg=new ButtonGroup();
        bg.add(jCheckBox[0]);
        bg.add(jCheckBox[1]);
        jCheckBox[0].setBounds(180,120,60,30);
        jCheckBox[1].setBounds(240,120,70,30);

        jCheckBox[0].setActionCommand("Male");
        jCheckBox[1].setActionCommand("Female");
        jCheckBox[0].addActionListener(this);
        jCheckBox[1].addActionListener(this);

        jtf[2]=new JTextField();
        jtf[2].setBounds(180,170,120,30);
        jtf[2].addActionListener(this);
        jtf[2].setActionCommand("P-No");
        //action
        jtf[3]=new JTextField();
        jtf[3].setBounds(180,220,120,30);
        jtf[3].addActionListener(this);
        jtf[3].setActionCommand("CNIC");
        //action
        jtf[4]=new JTextField();
        jtf[4].setBounds(180,320,120,30);
        jtf[4].addActionListener(this);
        jtf[4].setActionCommand("UserName");
        //action
        jtf[5]=new JTextField();
        jtf[5].setBounds(180,370,120,30);
        jtf[5].setActionCommand("Pass");
        jtf[5].addActionListener(this);
        //action

        button[0]=new JButton("OK!");
        button[0].setBounds(200,430,80,40);
        button[0].addActionListener(this);
        button[0].setActionCommand("Submit");

        panel[1].add(button[0]);
        panel[1].add(jl[0]);
        panel[1].add(jl[1]);
        panel[1].add(jl[2]);
        panel[1].add(jl[3]);
        panel[1].add(jl[4]);
        panel[1].add(jl[5]);
        panel[1].add(jl[6]);
        panel[1].add(jl[7]);

        panel[1].add(jtf[0]);
        panel[1].add(jtf[1]);
        panel[1].add(jtf[2]);
        panel[1].add(jtf[3]);
        panel[1].add(jtf[4]);
        panel[1].add(jtf[5]);

        panel[1].add(jCheckBox[0]);
        panel[1].add(jCheckBox[1]);

        framee[1].add(panel[1]);
        framee[1].setVisible(true);
        /*System.out.print("Enter Name: ");
        this.Cus_Name=sc.nextLine();
        while(true){
            System.out.print("Enter Age: ");
            try{
                this.Cus_age=sc.nextInt();
                break;
            }catch (InputMismatchException e){
                System.out.println("Invalid Input.");
                sc.nextLine();
            }
        }
        sc.nextLine();
        System.out.print("Enter Gender: ");
        while(true) {
            System.out.println("Press 1 For Male.");
            System.out.println("Press 2 For Female");
            char cc = sc.next().charAt(0);
            if(cc=='1'){
                this.Cus_gender="Male";
                break;
            } else if (cc=='2') {
                this.Cus_gender="Female";
                break;
            }
            else {
                System.out.println("Invalid Input");
            }
        }
        while(true) {
            try {
                System.out.print("Enter Phone Number: ");
                this.Cus_PhNo = sc.nextLong();
                if (this.Cus_PhNo>0) {
                    break;
                }
            }catch (InputMismatchException ime){
                System.out.println("Invalid Input.Enter Again");
                sc.nextLine();
            }
        }
        sc.nextLine();
        while(true) {
            try {
                System.out.print("Enter CNIC: ");
                long x = sc.nextInt();
                this.Cus_cnic=String.valueOf(x);
                if (x>0){
                break;
                }
            } catch (InputMismatchException ime) {
                System.out.println("Invalid Input Please Enter Right Cnic.");
                sc.nextLine();
            }
        }
        sc.nextLine();

*/
    }
    public boolean Check_Register(){
        BufferedReader br=null;
        int p=0;
        try{
            br=new BufferedReader(new FileReader("C:\\Users\\PMYLS\\IdeaProjects\\GUI Cab continue\\src\\Password.txt"));
            String line;
            while((line=br.readLine())!=null){
                String[] parts=line.split(",");
                long cnic= Long.parseLong(parts[0].trim());
                String userName=parts[1].trim();
                String password=parts[2].trim();
                if(cnic==this.Cus_cnic){
                    p=1;
                    break;
                }
            }
        }catch (IOException ie){ie.printStackTrace();}
        catch (Exception e){e.printStackTrace();}
        finally {
            if(br!=null){
                try {
                    br.close();
                }catch (IOException ie){ie.printStackTrace();}
                catch (Exception e){e.printStackTrace();}
            }
        }
        if(p==1){
            System.out.println("Already Registered.");
            return false;
        }
        else {
            System.out.println("Please Enter UserName And Password.");
            return true;
        }
    }
    /*public void Cus_Register(){
        System.out.print("Enter UserName: ");
        this.userName=sc.nextLine();
        System.out.print("Enter Password: ");
        this.password=sc.nextLine();
    }*/
    public void writeInfo(){
        BufferedWriter writer=null;
        try{
            writer=new BufferedWriter(new FileWriter("C:\\Users\\PMYLS\\IdeaProjects\\GUI Cab continue\\src\\CustomerData.txt",true));
            writer.write(this.Cus_Name);
            writer.write(",");
            writer.write(String.valueOf(this.Cus_cnic));
            writer.write(",");
            writer.write(String.valueOf(this.Cus_age));
            writer.write(",");
            writer.write(this.Cus_gender);
            writer.write(",");
            writer.write(String.valueOf(this.Cus_PhNo));
            writer.newLine();
        }catch (IOException ie){ie.printStackTrace();}
        catch (Exception e){e.printStackTrace();}
        finally {
            if(writer!=null){
                try{
                    writer.close();
                }catch (IOException ie){
                    ie.printStackTrace();
                }
            }
        }
    }
    public void writeAuthentication(){
        BufferedWriter writer=null;
        try{
            writer=new BufferedWriter(new FileWriter("C:\\Users\\PMYLS\\IdeaProjects\\GUI Cab continue\\src\\Password.txt",true));
            writer.write(String.valueOf(this.Cus_cnic));
            writer.write(",");
            writer.write(this.userName);
            writer.write(",");
            writer.write(this.password);
            writer.newLine();
        }catch (IOException ie){ie.printStackTrace();}
        catch (Exception e){e.printStackTrace();}
        finally {
            if(writer!=null){
                try{
                    writer.close();
                }catch (IOException ie){
                    ie.printStackTrace();
                }
            }
        }
    }
}