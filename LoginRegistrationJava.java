/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package progpoe;

import java.util.Scanner;
import java.util.regex.*;



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

    void registerUser(String firstName,String lastName,String user,String password){

        if(checkUserName(user)){
            this.user = user;
            System.out.println("Username successfully Captured");
        }
        else{
            System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters long.");
        }
       if(checkPasswordComplexity(password)){
           this.password = password;
            System.out.println("Password successfully captured");
        }
        else{
            System.out.println("Password is not correctly formatted, please ensure that the passoword contains atleast 8 characters, a capital letter, a number and a special character.");
        }
        if(checkUserName(user) && checkPasswordComplexity(password)){
            this.firstName = firstName;
            this.lastName = lastName;
            System.out.println(returnLoginStatus(user, password));
        }
    }
}

 class Registration{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the username:");
        String user = sc.nextLine();
        System.out.print("Enter the password:");
        String password = sc.nextLine();
        System.out.print("Enter your First Name:");
        String firstName = sc.nextLine();
        System.out.print("Enter Your Last Name:");
        String lastName = sc.nextLine();
        sc.close();
        LoginRegistrationJava user1 = new LoginRegistrationJava();
        user1.registerUser(firstName,lastName,user,password);
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////end of file////////////////////////////////////////////////////////////////////////////////