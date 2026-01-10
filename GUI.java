import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    JFrame[] jFrames;
    JPanel[] panels;
    JLabel[] jLabels;
    JTextField[] jTextField;
    JPasswordField[] jPasswordFields;
    Cab c;
    Driver d;
    JButton[] jButtons;
    private String user;
    private String pass;
    RegisterCustomer rc;
    public GUI(){
        jFrames=new JFrame[100];
        panels=new JPanel[100];
        jLabels=new JLabel[100];
        jTextField=new JTextField[100];
        jPasswordFields=new JPasswordField[100];
        jButtons=new JButton[100];
        c=new Cab();
        d=new Driver();
        rc=new RegisterCustomer();
    }

    public String getPass() {
        return pass;
    }

    public String getUser() {
        return user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public JButton[] getjButtons() {
        return jButtons;
    }

    public JFrame[] getjFrames() {
        return jFrames;
    }

    public JLabel[] getjLabels() {
        return jLabels;
    }

    public JPanel[] getPanels() {
        return panels;
    }

    public JPasswordField[] getjPasswordFields() {
        return jPasswordFields;
    }

    public JTextField[] getjTextField() {
        return jTextField;
    }

    public void run(){
        jFrames[0]=new JFrame("Cab Booking System");
        jFrames[0].setSize(300,400);
        jFrames[0].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrames[0].setLocationRelativeTo(null);
        panels[0]=new JPanel(null);
        panels[0].setBackground(Color.YELLOW);
        jButtons[0]=new JButton("Admin");
        jButtons[0].setBounds(100,40,100,40);
        jButtons[0].setBackground(Color.getHSBColor(30,20,25));
        jButtons[0].addActionListener(this);
        jButtons[0].setActionCommand("Admin");
        jButtons[1]=new JButton("Driver");
        jButtons[1].setBackground(Color.getHSBColor(30,20,25));
        jButtons[1].setBounds(100,120,100,40);
        jButtons[1].addActionListener(this);
        jButtons[1].setActionCommand("Driver");
        jButtons[2]=new JButton("Customer");
        jButtons[2].setBackground(Color.getHSBColor(30,20,25));
        jButtons[2].setBounds(100,200,100,40);
        jButtons[2].addActionListener(this);
        jButtons[2].setActionCommand("Customer");
        jButtons[3]=new JButton("Exit");
        jButtons[3].setBackground(Color.getHSBColor(30,20,25));
        jButtons[3].setBounds(100,280,100,40);
        jButtons[3].setActionCommand("Exit");
        jButtons[3].addActionListener(this);
        panels[0].add(jButtons[0]);
        panels[0].add(jButtons[1]);
        panels[0].add(jButtons[2]);
        panels[0].add(jButtons[3]);
        jFrames[0].add(panels[0]);
        jFrames[0].setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userName="abc";
        String password="123";
        if(e.getActionCommand().equals("Admin")){
            System.out.println("Admin Called");
            Admin_Login();
        }
        if(e.getActionCommand().equals("Driver")){
            System.out.println("Driver Called");
            d.button();
        }
        if(e.getActionCommand().equals("Customer")){
            System.out.println("Customer Called");
            rc.Choose();
        }
        if(e.getActionCommand().equals("Exit")){
            jFrames[0].setVisible(false);
        }
        if(e.getActionCommand().equals("User")){
            this.user=jTextField[0].getText();
//            System.out.println(this.user);
        }
        if(e.getActionCommand().equals("Pass")){
            this.pass=new String(jPasswordFields[0].getPassword());
//            System.out.println(this.pass);
        }
        if(e.getActionCommand().equals("Submit")){
            // Read values directly from fields on submit
            this.user = jTextField[0].getText();
            this.pass = new String(jPasswordFields[0].getPassword());
            if(this.user.equals(userName) && this.pass.equals(password)){
                JOptionPane.showMessageDialog(null,"Login Successful","Success",JOptionPane.INFORMATION_MESSAGE);
                c.button();
                jFrames[1].setVisible(false);
            }
            else {
                JOptionPane.showMessageDialog(null,"Login Error!!!","ERROR!!!",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    public void Admin_Login(){
        jFrames[1]=new JFrame("Admin Login");
        jFrames[1].setSize(300,300);
        jFrames[1].setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrames[1].setLocationRelativeTo(null);
        jFrames[1].setVisible(true);
        panels[1]=new JPanel(null);
        jLabels[0]=new JLabel("UserName");
        jLabels[0].setBounds(20,30,100,30);
        jLabels[1]=new JLabel("Password");
        jLabels[1].setBounds(20,80,100,30);
        jTextField[0]=new JTextField();
        jTextField[0].setBounds(150,30,120,30);
        jTextField[0].setActionCommand("User");
        jTextField[0].addActionListener(this);


        jPasswordFields[0]=new JPasswordField();
        jPasswordFields[0].setBounds(150,80,120,30);
        jPasswordFields[0].setActionCommand("Pass");
        jPasswordFields[0].addActionListener(this);


        jButtons[4]=new JButton("Submit");
        jButtons[4].setBounds(180,150,80,40);
        jButtons[4].setActionCommand("Submit");
        jButtons[4].addActionListener(this);

        panels[1].add(jLabels[0]);
        panels[1].add(jLabels[1]);
        panels[1].add(jTextField[0]);
        panels[1].add(jPasswordFields[0]);
        panels[1].add(jButtons[4]);
        jFrames[1].add(panels[1]);
    }

    public static void main(String[] args) {
        GUI gui=new GUI();
        gui.run();
    }
}