import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Launch GUI
        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI();
            gui.run();
        });
    }
    
    public static void consoleMain() {
        Scanner sc=new Scanner(System.in);
        System.out.println("--<-----WELCOME TO CAB BOOKING SYSTEM--->--");
        System.out.println();
        boolean loop=true;
        while(loop) {
            System.out.println("->Press 1 To Enter As Admin.");
            System.out.println("->Press 2 To Enter As Customer.");
            System.out.println("->Press 3 To Enter As Driver.");
            System.out.println("->Press 4 To Exit.");
            char cc = sc.next().charAt(0);
            switch (cc) {
                case '1': {
                    Security s=new Security();
                    s.setset();
                    boolean x=s.Login();
                    if(x==true) {
                        boolean lop = true;
                        while (lop) {
                            System.out.println("->Press 1 To Add Cab.");
                            System.out.println("->Press 2 To Continue.");
                            char ccc = sc.next().charAt(0);
                            switch (ccc) {
                                case '1': {
                                    int total = 0;

                                    if (total == 0) {
                                        for (int i = 0; i < 1; i++) {
                                            Cab c = new Cab();
                                            c.add();
                                            c.writeCab();
                                        }
                                        total += 1;
                                    } else {
                                        for (int i = total; i < 1 + total; i++) {
                                            Cab c = new Cab();
                                            c.add();
                                            c.writeCab();
                                        }
                                        total += 1;
                                    }
                                    break;
                                }

                                case '2': {
                                    lop = false;
                                    break;
                                }
                                default: {
                                    System.out.println("Wrong Input");
                                }
                            }
                        }
                    }
                    break;
                }
                case '2': {
                    System.out.println("->Press 1 For Registration.");
                    System.out.println("->Press 2 For Booking Cab.");
                    System.out.println("Press 3 For Exit");
                    char ccc=sc.next().charAt(0);
                    switch (ccc){
                        case '1':{
                            RegisterCustomer rc=new RegisterCustomer();
                            rc.Cus_info();
                            boolean b=rc.Check_Register();
                            if(b==true) {
                                //rc.Cus_Register();
                                rc.writeInfo();
                                rc.writeAuthentication();
                            }
                            break;
                        }
                        case '2':{
                            BookingCab bc=new BookingCab();
                            bc.login();
                            boolean b=bc.verify();
                            if(b==true) {
                                bc.Book();
                                //bc.display();
                                bc.done_Book();
                                bc.CheckAlreadyBooked();
                            }
                            break;
                        }
                        case '3':{
                            System.exit(0);
                            break;
                        }
                        default:{
                            System.out.println("Wrong Input.");
                        }
                    }
                    break;
                }
                case '3':{
                    System.out.println("->Press 1 For Registration.");
                    System.out.println("->Press 2 For ChangeStatus Of Cab.");
                    char ccc=sc.next().charAt(0);
                    Driver d=new Driver();
                    switch(ccc){
                        case '1':{
                            /*boolean x=d.register();
                            if(x==true){
                                System.out.println("Set Your UserName And Password For Registration.");
                                d.setDriver();
                            } else if (x==false) {
                                System.out.println("You are not Driver of Cab Booking System");
                            }*/
                            break;
                        }
                        case '2':{
                            /*boolean b=d.Driver_Login();
                            if(b==true){
                                System.out.print("Enter ID Of Cab Which You Want To Change Status: ");
                                int ID=sc.nextInt();
                                d.changeStatus(ID);
                            }*/
                            break;
                        } default:{
                            System.out.println("Invalid Input.");
                        }
                    }
                    break;
                }
                case '4':{
                    System.out.println("GOODBYE");
                    loop=false;
                    break;
                }
                default: {
                    System.out.println("Wrong Input.");
                }
            }
        }
    }
}