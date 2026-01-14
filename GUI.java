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
        // Main Frame Setup
        jFrames[0] = new JFrame("Cab Booking System");
        jFrames[0].setSize(400, 600);
        jFrames[0].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrames[0].setLocationRelativeTo(null);
        jFrames[0].setResizable(false);
        
        // Gradient Background Panel
        panels[0] = UIStyle.createGradientPanel();
        
        // Header with Title
        JPanel headerPanel = UIStyle.createHeaderPanel("🚖 CAB BOOKING", 400);
        headerPanel.setBounds(0, 0, 400, 80);
        panels[0].add(headerPanel);
        
        // Subtitle
        JLabel subtitleLabel = UIStyle.createSubtitleLabel("Your Ride, Your Way");
        subtitleLabel.setBounds(0, 90, 400, 30);
        panels[0].add(subtitleLabel);
        
        // Taxi Icon
        JLabel iconLabel = UIStyle.createIconLabel("🚕", 60);
        iconLabel.setBounds(0, 130, 400, 70);
        panels[0].add(iconLabel);
        
        // Admin Button
        jButtons[0] = UIStyle.createPrimaryButton("👤  ADMIN");
        jButtons[0].setBounds(100, 220, 200, 50);
        jButtons[0].addActionListener(this);
        jButtons[0].setActionCommand("Admin");
        panels[0].add(jButtons[0]);
        
        // Driver Button
        jButtons[1] = UIStyle.createSecondaryButton("🚗  DRIVER");
        jButtons[1].setBounds(100, 290, 200, 50);
        jButtons[1].addActionListener(this);
        jButtons[1].setActionCommand("Driver");
        panels[0].add(jButtons[1]);
        
        // Customer Button
        jButtons[2] = UIStyle.createSuccessButton("🧑  CUSTOMER");
        jButtons[2].setBounds(100, 360, 200, 50);
        jButtons[2].addActionListener(this);
        jButtons[2].setActionCommand("Customer");
        panels[0].add(jButtons[2]);
        
        // Exit Button
        jButtons[3] = UIStyle.createDangerButton("❌  EXIT");
        jButtons[3].setBounds(100, 430, 200, 50);
        jButtons[3].setActionCommand("Exit");
        jButtons[3].addActionListener(this);
        panels[0].add(jButtons[3]);
        
        // Footer
        JLabel footerLabel = UIStyle.createLabel("© 2026 Cab Booking System", UIStyle.GRAY);
        footerLabel.setBounds(0, 520, 400, 30);
        footerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panels[0].add(footerLabel);
        
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
            System.exit(0);
        }
        if(e.getActionCommand().equals("User")){
            this.user=jTextField[0].getText();
        }
        if(e.getActionCommand().equals("Pass")){
            this.pass=new String(jPasswordFields[0].getPassword());
        }
        if(e.getActionCommand().equals("Submit")){
            this.user = jTextField[0].getText();
            this.pass = new String(jPasswordFields[0].getPassword());
            if(this.user.equals(userName) && this.pass.equals(password)){
                UIStyle.showStyledMessage(null, "Login Successful! Welcome Admin.", "Success", JOptionPane.INFORMATION_MESSAGE);
                c.button();
                jFrames[1].setVisible(false);
            }
            else {
                UIStyle.showStyledMessage(null, "Invalid Username or Password!", "Login Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void Admin_Login(){
        jFrames[1] = new JFrame("Admin Login");
        jFrames[1].setSize(400, 450);
        jFrames[1].setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrames[1].setLocationRelativeTo(null);
        jFrames[1].setResizable(false);
        
        // Gradient Background Panel
        panels[1] = UIStyle.createGradientPanel();
        
        // Header
        JPanel headerPanel = UIStyle.createHeaderPanel("🔐 ADMIN LOGIN", 400);
        headerPanel.setBounds(0, 0, 400, 70);
        panels[1].add(headerPanel);
        
        // Lock Icon
        JLabel iconLabel = UIStyle.createIconLabel("🔒", 50);
        iconLabel.setBounds(0, 80, 400, 60);
        panels[1].add(iconLabel);
        
        // Username Label
        jLabels[0] = UIStyle.createLabel("Username", UIStyle.LIGHT);
        jLabels[0].setBounds(50, 160, 100, 30);
        panels[1].add(jLabels[0]);
        
        // Username Field
        jTextField[0] = UIStyle.createTextField();
        jTextField[0].setBounds(50, 190, 300, 40);
        jTextField[0].setActionCommand("User");
        jTextField[0].addActionListener(this);
        panels[1].add(jTextField[0]);
        
        // Password Label
        jLabels[1] = UIStyle.createLabel("Password", UIStyle.LIGHT);
        jLabels[1].setBounds(50, 250, 100, 30);
        panels[1].add(jLabels[1]);
        
        // Password Field
        jPasswordFields[0] = UIStyle.createPasswordField();
        jPasswordFields[0].setBounds(50, 280, 300, 40);
        jPasswordFields[0].setActionCommand("Pass");
        jPasswordFields[0].addActionListener(this);
        panels[1].add(jPasswordFields[0]);
        
        // Submit Button
        jButtons[4] = UIStyle.createSuccessButton("🚀  LOGIN");
        jButtons[4].setBounds(100, 350, 200, 45);
        jButtons[4].setActionCommand("Submit");
        jButtons[4].addActionListener(this);
        panels[1].add(jButtons[4]);
        
        jFrames[1].add(panels[1]);
        jFrames[1].setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI();
            gui.run();
        });
    }
}