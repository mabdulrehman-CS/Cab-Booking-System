import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class Driver implements ActionListener {
    Scanner sc=new Scanner(System.in);
    private String D_Name;
    private long D_PhNo;
    private int D_exp;
    private long D_Cnic;
    private String UserName;
    private String Pass;
    private final String status="Available";
    JFrame[] frame;
    JPanel[] panel;
    JLabel[] label;
    JButton[] button;
    JTextField[] jtf;
    JPasswordField jPasswordField;
    private String u;
    private String p;
    public Driver(){
        frame=new JFrame[100];
        panel=new JPanel[100];
        label=new JLabel[100];
        button=new JButton[100];
        jtf=new JTextField[100];
    }
    public void setD_Name(String d_Name) {
        D_Name = d_Name;
    }
    public void setD_PhNo(long d_PhNo) {
        D_PhNo = d_PhNo;
    }
    public long getD_PhNo() {
        return D_PhNo;
    }
    public String getD_Name() {
        return D_Name;
    }
    public void setD_exp(int d_exp) {
        D_exp = d_exp;
    }
    public int getD_exp() {
        return D_exp;
    }

    public long getD_Cnic() {
        return D_Cnic;
    }

    public void setD_Cnic(long d_Cnic) {
        D_Cnic = d_Cnic;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Register")){
            register();
        }
        if(e.getActionCommand().equals("Change")){
            System.out.println("Change Called");
            Driver_Login();
        }
        if(e.getActionCommand().equals("BACK")){
            frame[0].setVisible(false);
        }
        if(e.getActionCommand().equals("cnic")){
            this.D_Cnic=Long.parseLong(jtf[0].getText());
        }
        if(e.getActionCommand().equals("User")){
            this.UserName=jtf[1].getText();
        }
        if(e.getActionCommand().equals("Pass")){
            this.Pass= jtf[2].getText();
            System.out.println(this.Pass);
        }
        if(e.getActionCommand().equals("Sub")){
            boolean b=readCNIC();
            if(b==true){
                frame[1].setVisible(false);
                System.out.println("Found");
                set();
            }
            else {
                JOptionPane.showMessageDialog(null,"This CNIC Not Registered Yet","ERROR!!!",JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getActionCommand().equals("OK")){
            this.u=jtf[3].getText();
            this.p=jtf[4].getText();
            verify(this.u,this.p);
            frame[3].setVisible(false);
            EnterID();
        }
        if(e.getActionCommand().equals("Registered")){
            setDriver();
            JOptionPane.showMessageDialog(null,"Successfully SignIn","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
        }
        if(e.getActionCommand().equals("ID")){
            int Id= Integer.parseInt(jtf[5].getText());
            changeStatus(Id);
            frame[4].setVisible(false);
        }

    }
    public void set(){
        frame[2] = new JFrame("Driver Registration");
        frame[2].setSize(400, 400);
        frame[2].setLocationRelativeTo(null);
        frame[2].setResizable(false);
        
        panel[2] = UIStyle.createGradientPanel();
        
        // Header
        JPanel headerPanel = UIStyle.createHeaderPanel("📝 SET CREDENTIALS", 400);
        headerPanel.setBounds(0, 0, 400, 70);
        panel[2].add(headerPanel);
        
        label[1] = UIStyle.createLabel("Username", UIStyle.LIGHT);
        label[1].setBounds(50, 100, 100, 30);
        label[2] = UIStyle.createLabel("Password", UIStyle.LIGHT);
        label[2].setBounds(50, 170, 100, 30);
        
        jtf[1] = UIStyle.createTextField();
        jtf[1].setBounds(50, 130, 300, 35);
        jtf[1].setActionCommand("User");
        jtf[1].addActionListener(this);

        jtf[2] = UIStyle.createTextField();
        jtf[2].setBounds(50, 200, 300, 35);
        jtf[2].setActionCommand("Pass");
        jtf[2].addActionListener(this);

        button[4] = UIStyle.createSuccessButton("✅  REGISTER");
        button[4].setBounds(100, 280, 200, 45);
        button[4].setActionCommand("Registered");
        button[4].addActionListener(this);

        panel[2].add(label[1]);
        panel[2].add(label[2]);
        panel[2].add(jtf[1]);
        panel[2].add(jtf[2]);
        panel[2].add(button[4]);
        frame[2].add(panel[2]);
        frame[2].setVisible(true);
    }
    public void button(){
        frame[0] = new JFrame("Driver Portal");
        frame[0].setSize(400, 500);
        frame[0].setLocationRelativeTo(null);
        frame[0].setResizable(false);
        
        panel[0] = UIStyle.createGradientPanel();
        
        // Header
        JPanel headerPanel = UIStyle.createHeaderPanel("🚗 DRIVER PORTAL", 400);
        headerPanel.setBounds(0, 0, 400, 80);
        panel[0].add(headerPanel);
        
        // Driver Icon
        JLabel iconLabel = UIStyle.createIconLabel("👨‍✈️", 50);
        iconLabel.setBounds(0, 90, 400, 60);
        panel[0].add(iconLabel);
        
        button[0] = UIStyle.createPrimaryButton("📝  REGISTER");
        button[0].setBounds(100, 180, 200, 50);
        button[0].setActionCommand("Register");
        button[0].addActionListener(this);
        
        button[1] = UIStyle.createWarningButton("🔄  CHANGE STATUS");
        button[1].setBounds(100, 250, 200, 50);
        button[1].setActionCommand("Change");
        button[1].addActionListener(this);
        
        button[2] = UIStyle.createDangerButton("⬅  BACK");
        button[2].setBounds(100, 320, 200, 50);
        button[2].addActionListener(this);
        button[2].setActionCommand("BACK");

        panel[0].add(button[0]);
        panel[0].add(button[1]);
        panel[0].add(button[2]);
        
        frame[0].add(panel[0]);
        frame[0].setVisible(true);
    }

    public void register() {
        frame[1] = new JFrame("Driver Registration");
        frame[1].setSize(400, 350);
        frame[1].setLocationRelativeTo(null);
        frame[1].setResizable(false);
        
        panel[1] = UIStyle.createGradientPanel();
        
        // Header
        JPanel headerPanel = UIStyle.createHeaderPanel("🔍 VERIFY CNIC", 400);
        headerPanel.setBounds(0, 0, 400, 70);
        panel[1].add(headerPanel);
        
        label[0] = UIStyle.createLabel("Enter CNIC Number:", UIStyle.LIGHT);
        label[0].setBounds(50, 100, 150, 30);
        
        jtf[0] = UIStyle.createTextField();
        jtf[0].setBounds(50, 135, 300, 40);
        jtf[0].addActionListener(this);
        jtf[0].setActionCommand("cnic");

        panel[1].add(label[0]);
        panel[1].add(jtf[0]);

        button[3] = UIStyle.createPrimaryButton("🔎  VERIFY");
        button[3].setBounds(100, 210, 200, 45);
        button[3].setActionCommand("Sub");
        button[3].addActionListener(this);

        panel[1].add(button[3]);
        frame[1].add(panel[1]);
        frame[1].setVisible(true);
    }
    public boolean readCNIC(){
        int p = 0;
        BufferedReader reader=null;
        try{
            reader=new BufferedReader(new FileReader("C:\\Users\\PMYLS\\IdeaProjects\\GUI Cab continue\\src\\CabDetails.txt"));
            String line;
            while((line=reader.readLine())!=null){
                String[] parts=line.split(",");
                int id= Integer.parseInt(parts[0].trim());
                String C_Name=parts[1].trim();
                int C_model= Integer.parseInt(parts[2].trim());
                String type=parts[3].trim();
                String seats=parts[4].trim();
                String C_Quality=parts[5].trim();
                String place=parts[6].trim();
                double price= Double.parseDouble(parts[7].trim());
                String DriverName=parts[8].trim();
                long D_CNIC= Long.parseLong(parts[9].trim());
                long D_PHNO=Long.parseLong(parts[10].trim());
                int D_EXP= Integer.parseInt(parts[11].trim());
                String status=parts[12].trim();
                if(this.D_Cnic==D_CNIC){
                    p=1;
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if(p==1){
            return true;
        }
        else {
            return false;
        }
    }
    public void setDriver() {
        BufferedWriter writer = null;
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("C:\\Users\\PMYLS\\IdeaProjects\\GUI Cab continue\\src\\DriverAuthantication.txt"));
            String line;
            int p=0;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String user = parts[0].trim();

                if (user.equals(this.UserName)) {
                    //System.out.println("This UserName Already Exists.");
                    JOptionPane.showMessageDialog(null,"UserName Already Exist","Reuse",JOptionPane.ERROR_MESSAGE);
                    p=1;
                    break;
                }
            }

            if (p==0) {
                try {
                    writer = new BufferedWriter(new FileWriter("C:\\Users\\PMYLS\\IdeaProjects\\GUI Cab continue\\src\\DriverAuthantication.txt", true));
                    writer.write(this.UserName);
                    writer.write(",");
                    writer.write(this.Pass);
                    writer.newLine();
                    System.out.println("UserName and Password Set successfully.");
                } catch (Exception ie) {
                    ie.printStackTrace();
                } finally {
                    if (writer != null) {
                        try {
                            writer.close();
                        } catch (Exception iee) {
                            iee.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }
        }
    }
    public void Driver_Login() {
        frame[3]=new JFrame("Registered");
        frame[3].setSize(320,300);
        frame[3].setVisible(true);
        panel[3]=new JPanel(null);
        label[3]=new JLabel("UserName");
        label[3].setBounds(20,30,100,30);
        label[4]=new JLabel("Password");
        label[4].setBounds(20,80,100,30);
        jtf[3]=new JTextField();
        jtf[3].setBounds(150,30,120,30);
        jtf[3].setActionCommand("User");
        jtf[3].addActionListener(this);


        jtf[4]=new JTextField();
        jtf[4].setBounds(150,80,120,30);
        jtf[4].setActionCommand("Pass");
        jtf[4].addActionListener(this);


        button[5]=new JButton("OK!!");
        button[5].setBounds(180,150,90,40);
        button[5].setActionCommand("OK");
        button[5].addActionListener(this);

        panel[3].add(label[3]);
        panel[3].add(label[4]);
        panel[3].add(jtf[3]);
        panel[3].add(jtf[4]);
        panel[3].add(button[5]);
        frame[3].add(panel[3]);
    }
    public boolean verify(String user,String passs){
        int p = 0;
        BufferedReader reader=null;
        try{
            reader=new BufferedReader(new FileReader("C:\\Users\\PMYLS\\IdeaProjects\\GUI Cab continue\\src\\DriverAuthantication.txt"));
            String line;
            while((line=reader.readLine())!=null){
                String[] parts=line.split(",");
                String username=parts[0].trim();
                String password=parts[1].trim();
                if(user.equals(username) && passs.equals(password)){
                    p=1;
                    break;
                }
            }
        }catch (Exception ee){
            ee.printStackTrace();
        }
        if(p==0){
            JOptionPane.showMessageDialog(null,"ERROR","ERROR!!!",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else {
            JOptionPane.showMessageDialog(null,"Login Successful","SUCCESS",JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
    }
    public void EnterID(){
        frame[4]=new JFrame("Enter-ID");
        panel[4]=new JPanel(null);
        frame[4].setVisible(true);
        frame[4].setSize(300,250);
        label[5]=new JLabel("Enter ID");
        label[5].setBounds(30,30,100,30);
        jtf[5]=new JTextField();
        jtf[5].setBounds(150,30,120,30);
        button[6]=new JButton("CHANGE");
        button[6].setBounds(100,120,80,40);
        button[6].addActionListener(this);
        button[6].setActionCommand("ID");

        panel[4].add(label[5]);
        panel[4].add(jtf[5]);
        panel[4].add(button[6]);
        frame[4].add(panel[4]);
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
                    parts[12]=this.status;
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