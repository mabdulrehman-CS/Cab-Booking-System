import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class Security{
    Scanner sc = new Scanner(System.in);
    private String User_Name;
    private String Password;
    private String user;
    private GUI gui;
    private String pass;
    public Security() {
    }
    public void setU(){
        if (gui != null) {
            gui.setUser("Hanzala");
        }
    }
    public void setP(){
        if (gui != null) {
            gui.setPass("Hanzala123");
        }
    }
    public String getUserName() {
        return User_Name;
    }
    public void setUserName(String userName) {
        User_Name = userName;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(String password) {
        Password = password;
    }
    public void setset(){
        this.User_Name="abc";
        this.Password="123";
    }
    public boolean Login() {
        System.out.println("...Enter Username and Password given to you...");
        System.out.println("Enter User Name");
        String us = sc.nextLine();
        System.out.println("Enter Password");
        String pa = sc.nextLine();
        if (us.equals(this.User_Name) & pa.equals(this.Password)) {
            System.out.println("Login Successfully");
            return true;
        } else {
            System.out.println("Wrong UserName or Password");
            return false;
        }
    }

    /*@Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("User")) {
            gui.setUser(gui.getjTextField()[0].getText())  ;
            System.out.println(this.user);
        }
        if (e.getActionCommand().equals("Pass")) {
            gui.setPass(gui.getjPasswordFields()[0].getText());
            System.out.println(this.pass);
        }

        if (e.getActionCommand().equals("Submit")) {
            System.out.println(gui.getUser());
            if (this.user != null && this.pass != null && this.user.equals(getUserName()) && this.pass.equals(getPassword())) {
                System.out.println("Successfully Login");
            } else {
                System.out.println("Wrong UserName or Password.");
            }
        }
    }*/
}