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
        framee[0] = new JFrame("Customer Portal");
        framee[0].setSize(400, 500);
        framee[0].setLocationRelativeTo(null);
        framee[0].setResizable(false);
        
        panel[0] = UIStyle.createGradientPanel();
        
        // Header
        JPanel headerPanel = UIStyle.createHeaderPanel("🧑 CUSTOMER PORTAL", 400);
        headerPanel.setBounds(0, 0, 400, 80);
        panel[0].add(headerPanel);
        
        // Customer Icon
        JLabel iconLabel = UIStyle.createIconLabel("👤", 50);
        iconLabel.setBounds(0, 90, 400, 60);
        panel[0].add(iconLabel);
        
        button[1] = UIStyle.createPrimaryButton("📝  REGISTER");
        button[1].setBounds(100, 180, 200, 50);
        button[1].setActionCommand("Register");
        button[1].addActionListener(this);

        button[2] = UIStyle.createSuccessButton("🚕  BOOK CAB");
        button[2].setBounds(100, 250, 200, 50);
        button[2].setActionCommand("B-Cab");
        button[2].addActionListener(this);

        button[3] = UIStyle.createDangerButton("⬅  BACK");
        button[3].setBounds(100, 320, 200, 50);
        button[3].addActionListener(this);
        button[3].setActionCommand("BACK");

        panel[0].add(button[1]);
        panel[0].add(button[2]);
        panel[0].add(button[3]);

        framee[0].add(panel[0]);
        framee[0].setVisible(true);
    }
    public void Cus_info(){
        framee[1] = new JFrame("Customer Registration");
        framee[1].setSize(450, 650);
        framee[1].setLocationRelativeTo(null);
        framee[1].setResizable(false);
        
        panel[1] = UIStyle.createGradientPanel();
        
        // Header
        JPanel headerPanel = UIStyle.createHeaderPanel("📋 REGISTRATION", 450);
        headerPanel.setBounds(0, 0, 450, 70);
        panel[1].add(headerPanel);

        jl[0] = UIStyle.createLabel("Name", UIStyle.LIGHT);
        jl[0].setBounds(30, 85, 100, 30);
        jl[1] = UIStyle.createLabel("Age", UIStyle.LIGHT);
        jl[1].setBounds(30, 135, 100, 30);
        jl[2] = UIStyle.createLabel("Gender", UIStyle.LIGHT);
        jl[2].setBounds(30, 185, 100, 30);
        jl[3] = UIStyle.createLabel("Phone Number", UIStyle.LIGHT);
        jl[3].setBounds(30, 235, 120, 30);
        jl[4] = UIStyle.createLabel("CNIC", UIStyle.LIGHT);
        jl[4].setBounds(30, 285, 100, 30);
        
        JLabel divider = UIStyle.createLabel("━━━━━━ Set Login Credentials ━━━━━━", UIStyle.ACCENT);
        divider.setBounds(30, 335, 400, 25);
        panel[1].add(divider);
        
        jl[6] = UIStyle.createLabel("Username", UIStyle.LIGHT);
        jl[6].setBounds(30, 370, 100, 30);
        jl[7] = UIStyle.createLabel("Password", UIStyle.LIGHT);
        jl[7].setBounds(30, 420, 100, 30);

        jtf[0] = UIStyle.createTextField();
        jtf[0].setBounds(150, 85, 250, 35);
        jtf[0].addActionListener(this);
        jtf[0].setActionCommand("Name");
        
        jtf[1] = UIStyle.createTextField();
        jtf[1].setBounds(150, 135, 250, 35);
        jtf[1].setActionCommand("Age");
        jtf[1].addActionListener(this);
        
        jCheckBox[0] = UIStyle.createCheckBox("Male");
        jCheckBox[1] = UIStyle.createCheckBox("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(jCheckBox[0]);
        bg.add(jCheckBox[1]);
        jCheckBox[0].setBounds(150, 185, 80, 30);
        jCheckBox[1].setBounds(240, 185, 90, 30);
        jCheckBox[0].setActionCommand("Male");
        jCheckBox[1].setActionCommand("Female");
        jCheckBox[0].addActionListener(this);
        jCheckBox[1].addActionListener(this);

        jtf[2] = UIStyle.createTextField();
        jtf[2].setBounds(150, 235, 250, 35);
        jtf[2].addActionListener(this);
        jtf[2].setActionCommand("P-No");
        
        jtf[3] = UIStyle.createTextField();
        jtf[3].setBounds(150, 285, 250, 35);
        jtf[3].addActionListener(this);
        jtf[3].setActionCommand("CNIC");
        
        jtf[4] = UIStyle.createTextField();
        jtf[4].setBounds(150, 370, 250, 35);
        jtf[4].addActionListener(this);
        jtf[4].setActionCommand("UserName");
        
        jtf[5] = UIStyle.createTextField();
        jtf[5].setBounds(150, 420, 250, 35);
        jtf[5].setActionCommand("Pass");
        jtf[5].addActionListener(this);

        button[0] = UIStyle.createSuccessButton("✅  REGISTER");
        button[0].setBounds(125, 480, 200, 45);
        button[0].addActionListener(this);
        button[0].setActionCommand("Submit");

        panel[1].add(button[0]);
        panel[1].add(jl[0]);
        panel[1].add(jl[1]);
        panel[1].add(jl[2]);
        panel[1].add(jl[3]);
        panel[1].add(jl[4]);
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