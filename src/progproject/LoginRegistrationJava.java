/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progproject;

/**
 *
 * @author tyres
 */


import java.util.Scanner;
import java.util.regex.*;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class LoginRegistrationJava{
    String user;
    String password;
    String firstName;
    String lastName;

    boolean checkUserName(String user){
        if(user.length()>5 || user.indexOf('_')==-1){
            return false;
        }
        else{
            return true;
        }
    }

    boolean checkPasswordComplexity(String password){
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=])"
                       + "(?=\\S+$).{8,20}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(password);
        return m.matches();
    }

    boolean loginUser(String user,String password){
        if(user.equals(this.user) && password.equals(this.password)){
            return true;
        }
        else{
            return false;
        }
    }

    String returnLoginStatus(String user,String password){
        if(loginUser(user, password)){
            return "Welcome "+firstName+lastName+" it is greater to see you again.";
        }
        else{
            return "Username or passoword incorrect, please try again.";
        }
    }

     void registerUser(String firstName, String lastName, String user, String password) {
        if (checkUserName(user)) {
            this.user = user;
            JOptionPane.showMessageDialog(null, "Username successfully captured");
        } else {
            JOptionPane.showMessageDialog(null, "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters long.");
        }
        if (checkPasswordComplexity(password)) {
            this.password = password;
            JOptionPane.showMessageDialog(null, "Password successfully captured");
        } else {
            JOptionPane.showMessageDialog(null, "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number, and a special character.");
        }
        if (checkUserName(user) && checkPasswordComplexity(password)) {
            this.firstName = firstName;
            this.lastName = lastName;
            JOptionPane.showMessageDialog(null, returnLoginStatus(user, password));
        }
    }
}

class Registration {
    public static void main(String[] args) {
        String user = JOptionPane.showInputDialog(null, "Enter the username:");
        String password = JOptionPane.showInputDialog(null, "Enter the password:");
        String firstName = JOptionPane.showInputDialog(null, "Enter your First Name:");
        String lastName = JOptionPane.showInputDialog(null, "Enter Your Last Name:");

        LoginRegistrationJava user1 = new LoginRegistrationJava();
        user1.registerUser(firstName, lastName, user, password);
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////end of file////////////////////////////////////////////////////////////////////////////////