import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Cab implements ActionListener {
    Scanner sc = new Scanner(System.in);
    private String C_Name;
    private int model;
    private int id;
    private static int lastid=0;
    private String location;
    private String type;
    private String Quality;
    private int seats;
    private double price;
    private String act;
    JFrame frame;
    private Driver d;
    JTextField[] jtf;
    JComboBox[] jComboBox;
    JCheckBox[] jcb;
    JButton[] jb;
    JLabel[] jl;
    public Cab() {
        this.id=++lastid;
        d = new Driver();
        jtf=new JTextField[100];
        jComboBox=new JComboBox[100];
        jcb=new JCheckBox[100];
        jb=new JButton[100];
        jl=new JLabel[100];
    }
    public void setAct(String act) {
        this.act = act;
    }
    public String getAct() {
        return act;
    }
    JFrame framee;
    public int getId() {
        return id;
    }
    public int getModel() {
        return model;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setModel(int model) {
        this.model = model;
    }
    public String getType() {
        return type;
    }
    public int getSeats() {
        return seats;
    }
    public void setC_Name(String c_Name) {
        C_Name = c_Name;
    }
    public void setQuality(String quality) {
        Quality = quality;
    }
    public String getLocation() {
        return location;
    }
    public void setSeats(int seats) {
        this.seats = seats;
    }
    public String getC_Name() {
        return C_Name;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getQuality() {
        return Quality;
    }
    public void setD(Driver d) {
        this.d = d;
    }
    public Driver getD() {
        return d;
    }
    public double getPrice() {
        return price;
    }

   // @Override
    public void button(){
        framee = new JFrame("Admin Panel");
        framee.setSize(400, 350);
        framee.setLocationRelativeTo(null);
        framee.setResizable(false);
        
        JPanel panel = UIStyle.createGradientPanel();
        
        // Header
        JPanel headerPanel = UIStyle.createHeaderPanel("⚙️ ADMIN PANEL", 400);
        headerPanel.setBounds(0, 0, 400, 70);
        panel.add(headerPanel);
        
        // Icon
        JLabel iconLabel = UIStyle.createIconLabel("🚖", 50);
        iconLabel.setBounds(0, 80, 400, 60);
        panel.add(iconLabel);
        
        JButton jb1 = UIStyle.createSuccessButton("➕  ADD CAB");
        jb1.setBounds(100, 160, 200, 50);
        jb1.addActionListener(this);
        jb1.setActionCommand("Add");
        
        JButton jb2 = UIStyle.createDangerButton("⬅  BACK");
        jb2.setBounds(100, 230, 200, 50);
        jb2.addActionListener(this);
        jb2.setActionCommand("Back");
        
        panel.add(jb1);
        panel.add(jb2);
        framee.add(panel);
        framee.setVisible(true);
    }
    public void add(){
        frame = new JFrame("Add New Cab");
        frame.setSize(500, 750);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        JPanel panel = UIStyle.createGradientPanel();
        
        // Header
        JPanel headerPanel = UIStyle.createHeaderPanel("🚕 ADD NEW CAB", 500);
        headerPanel.setBounds(0, 0, 500, 60);
        panel.add(headerPanel);
        
        jl[0] = UIStyle.createLabel("Company Name", UIStyle.LIGHT);
        jl[0].setBounds(30, 75, 120, 30);
        jl[1] = UIStyle.createLabel("Model Year", UIStyle.LIGHT);
        jl[1].setBounds(30, 120, 120, 30);
        jl[2] = UIStyle.createLabel("Vehicle Type", UIStyle.LIGHT);
        jl[2].setBounds(30, 165, 120, 30);
        jl[3] = UIStyle.createLabel("Quality", UIStyle.LIGHT);
        jl[3].setBounds(30, 210, 120, 30);
        jl[4] = UIStyle.createLabel("Seats", UIStyle.LIGHT);
        jl[4].setBounds(30, 255, 120, 30);
        jl[5] = UIStyle.createLabel("Location", UIStyle.LIGHT);
        jl[5].setBounds(30, 300, 120, 30);
        jl[6] = UIStyle.createLabel("Price (Per KM)", UIStyle.LIGHT);
        jl[6].setBounds(30, 345, 120, 30);
        
        // Driver Section Divider
        JLabel driverDivider = UIStyle.createLabel("━━━━━━━ Driver Details ━━━━━━━", UIStyle.ACCENT);
        driverDivider.setBounds(30, 390, 440, 25);
        panel.add(driverDivider);
        
        jl[7] = UIStyle.createLabel("Driver Name", UIStyle.LIGHT);
        jl[7].setBounds(30, 425, 120, 30);
        jl[8] = UIStyle.createLabel("CNIC", UIStyle.LIGHT);
        jl[8].setBounds(30, 470, 120, 30);
        jl[9] = UIStyle.createLabel("Phone No", UIStyle.LIGHT);
        jl[9].setBounds(30, 515, 120, 30);
        jl[10] = UIStyle.createLabel("Experience (Years)", UIStyle.LIGHT);
        jl[10].setBounds(30, 560, 130, 30);

        jtf[0] = UIStyle.createTextField();
        jtf[0].setBounds(170, 75, 280, 35);
        jtf[0].addActionListener(this);
        jtf[0].setActionCommand("C_Name");
        
        jtf[1] = UIStyle.createTextField();
        jtf[1].setBounds(170, 120, 280, 35);
        jtf[1].setActionCommand("Model");
        jtf[1].addActionListener(this);
        
        jcb[0] = UIStyle.createCheckBox("🚗 Car");
        jcb[1] = UIStyle.createCheckBox("🏍️ Bike");
        jcb[2] = UIStyle.createCheckBox("🛺 Rickshaw");
        ButtonGroup bg = new ButtonGroup();
        bg.add(jcb[0]);
        bg.add(jcb[1]);
        bg.add(jcb[2]);
        jcb[0].setBounds(170, 165, 90, 30);
        jcb[1].setBounds(265, 165, 90, 30);
        jcb[2].setBounds(360, 165, 110, 30);
        jcb[0].setActionCommand("Car");
        jcb[1].setActionCommand("Bike");
        jcb[2].setActionCommand("Rickshaw");
        jcb[0].addActionListener(this);
        jcb[1].addActionListener(this);
        jcb[2].addActionListener(this);
        
        jcb[3] = UIStyle.createCheckBox("❄️ AC");
        jcb[4] = UIStyle.createCheckBox("🌀 Non-AC");
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(jcb[3]);
        bg1.add(jcb[4]);
        jcb[3].setBounds(170, 210, 80, 30);
        jcb[4].setBounds(260, 210, 100, 30);
        jcb[3].setActionCommand("AC");
        jcb[4].setActionCommand("Non-AC");
        jcb[3].addActionListener(this);
        jcb[4].addActionListener(this);
        
        String[] seats = {"1", "2", "3", "4", "5", "6", "7"};
        jComboBox[0] = new JComboBox(seats);
        UIStyle.styleComboBox(jComboBox[0]);
        jComboBox[0].setBounds(170, 255, 80, 35);
        jComboBox[0].setActionCommand("seats");
        jComboBox[0].addActionListener(this);
        
        jtf[2] = UIStyle.createTextField();
        jtf[2].setBounds(170, 300, 280, 35);
        jtf[2].addActionListener(this);
        jtf[2].setActionCommand("Location");
        
        jtf[3] = UIStyle.createTextField();
        jtf[3].setBounds(170, 345, 280, 35);
        jtf[3].addActionListener(this);
        jtf[3].setActionCommand("Prize");
        
        jtf[4] = UIStyle.createTextField();
        jtf[4].setBounds(170, 425, 280, 35);
        jtf[4].addActionListener(this);
        jtf[4].setActionCommand("D_Name");
        
        jtf[5] = UIStyle.createTextField();
        jtf[5].setBounds(170, 470, 280, 35);
        jtf[5].setActionCommand("Cnic");
        jtf[5].addActionListener(this);
        
        jtf[6] = UIStyle.createTextField();
        jtf[6].setBounds(170, 515, 280, 35);
        jtf[6].addActionListener(this);
        jtf[6].setActionCommand("D_Ph");
        
        String[] Exp = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        jComboBox[1] = new JComboBox(Exp);
        UIStyle.styleComboBox(jComboBox[1]);
        jComboBox[1].setBounds(170, 560, 80, 35);
        jComboBox[1].setActionCommand("Exp");
        jComboBox[1].addActionListener(this);

        jb[0] = UIStyle.createSuccessButton("✅  ADD CAB");
        jb[0].setBounds(150, 620, 200, 50);
        jb[0].addActionListener(this);
        jb[0].setActionCommand("Submit");

        panel.add(jb[0]);
        panel.add(jl[0]);
        panel.add(jl[1]);
        panel.add(jl[2]);
        panel.add(jl[3]);
        panel.add(jl[4]);
        panel.add(jl[5]);
        panel.add(jl[6]);
        panel.add(jl[7]);
        panel.add(jl[8]);
        panel.add(jl[9]);
        panel.add(jl[10]);

        panel.add(jtf[0]);
        panel.add(jtf[1]);
        panel.add(jtf[2]);
        panel.add(jtf[3]);
        panel.add(jtf[4]);
        panel.add(jtf[5]);
        panel.add(jtf[6]);

        panel.add(jcb[0]);
        panel.add(jcb[1]);
        panel.add(jcb[2]);
        panel.add(jcb[3]);
        panel.add(jcb[4]);

        panel.add(jComboBox[0]);
        panel.add(jComboBox[1]);
        frame.add(panel);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("AC")){
            this.Quality="AC";
        } else if (e.getActionCommand().equals("Non-AC")) {
            this.Quality="Non-AC";
        }
        if (e.getActionCommand().equals("Car")) {
            this.type = "Car";
            jComboBox[0].setVisible(true);
            jcb[3].setVisible(true);
            jcb[4].setVisible(true);
            jl[3].setVisible(true);
            jl[4].setVisible(true);
        } else if (e.getActionCommand().equals("Bike")) {
            this.type = "Bike";
            jComboBox[0].setVisible(false);
            jcb[3].setVisible(false);
            jcb[4].setVisible(false);
            jl[3].setVisible(false);
            jl[4].setVisible(false);
            this.Quality = "Non-AC";
            this.seats = 1;
        } else if (e.getActionCommand().equals("Rickshaw")) {
            this.type = "Rickshaw";
            jComboBox[0].setVisible(false);
            jcb[3].setVisible(false);
            jcb[4].setVisible(false);
            jl[3].setVisible(false);
            jl[4].setVisible(false);

            this.seats = 3;
            this.Quality = "Non-AC";
        }
        if(e.getActionCommand().equals("Submit")){
                this.C_Name = jtf[0].getText();
                try {
                    this.model = Integer.parseInt(jtf[1].getText());
                } catch (NumberFormatException ex) {
                    // Handle the case when the input is not a valid integer
                    JOptionPane.showMessageDialog(frame, "Please enter a valid integer for Model.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    // You may choose to clear the text field or take other appropriate actions
                    jtf[1].setText("");
                    return;
                }

                this.seats = Integer.parseInt(jComboBox[0].getSelectedItem().toString());
                this.location = jtf[2].getText();
                try {
                    this.price = Double.parseDouble(jtf[3].getText());
                }catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null,"Please Enter Valid Price","Input Error",JOptionPane.ERROR_MESSAGE);
                    jtf[3].setText("");
                    return;
                }
                d.setD_Name(jtf[4].getText());
                try {
                    d.setD_Cnic(Long.parseLong(jtf[5].getText()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid integer for CNIC.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    jtf[5].setText("");
                    return;
                }
                try {
                    d.setD_PhNo(Long.parseLong(jtf[6].getText()));
                }catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid integer for Phone Number.", "Input Error", JOptionPane.ERROR_MESSAGE);
                    jtf[6].setText("");
                    return;
                }
                d.setD_exp(Integer.parseInt(jComboBox[1].getSelectedItem().toString()));
                frame.setVisible(false);
                writeCab();


        }






        if(e.getActionCommand().equals("Add")){
            add();
        }
        if(e.getActionCommand().equals("Back")){
            framee.setVisible(false);
        }
    }

    public void writeCab() {
        BufferedReader reader=null;
        try{
            reader=new BufferedReader(new FileReader("C:\\Users\\PMYLS\\IdeaProjects\\GUI Cab continue\\src\\CabDetails.txt"));
            String line;
            while((line= reader.readLine())!=null){
                String[] parts=line.split(",");
                String id=parts[0].trim();
                this.id= Integer.parseInt(id);
                this.id++;
            }
        }catch (IOException ie){ie.printStackTrace();}
        catch (Exception e){e.printStackTrace();}
        finally {
            if(reader!=null){
                try{
                    reader.close();
                }catch (IOException ie){ie.printStackTrace();}
                catch (Exception e){e.printStackTrace();}
            }
        }

        BufferedWriter writer=null;
        try{
            writer=new BufferedWriter(new FileWriter("C:\\Users\\PMYLS\\IdeaProjects\\GUI Cab continue\\src\\CabDetails.txt",true));
            writer.write(String.valueOf(this.id));
            writer.write(",");
            writer.write(this.C_Name);
            writer.write(",");
            writer.write(String.valueOf(this.model));
            writer.write(",");
            writer.write(this.type);
            writer.write(",");
            writer.write(String.valueOf(this.seats));
            writer.write(",");
            writer.write(this.Quality);
            writer.write(",");
            writer.write(this.location);
            writer.write(",");
            writer.write(String.valueOf(this.price));
            writer.write(",");
            writer.write(d.getD_Name());
            writer.write(",");
            writer.write(String.valueOf(d.getD_Cnic()));
            writer.write(",");
            writer.write(String.valueOf(d.getD_PhNo()));
            writer.write(",");
            writer.write(String.valueOf(d.getD_exp()));
            writer.write(",");
            writer.write("Available");
            writer.newLine();


        }catch (IOException ie){ie.printStackTrace();}
        catch (Exception e){e.printStackTrace();}
        finally {
            if(writer!=null){
                try {
                    writer.close();
                }catch (IOException e){e.printStackTrace();}
                catch (Exception e){e.printStackTrace();}
            }
        }
    }

}
