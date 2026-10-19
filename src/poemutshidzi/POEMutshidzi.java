/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poemutshidzi;

import java.util.Scanner;

/**
 *
 * @author mutsh
 */
public class POEMutshidzi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
         
        
        String name;
        String surname;
        String userName;
        String emailAddress;
        String password;
        String numberPhone;
        
        //prompt the user for their name
        System.out.print("Enter your Name: ");
        name = input.nextLine();
        
        //prompt the user for their surname
        System.out.print("Enter your Surname: ");
        surname = input.nextLine();
        
        //a while loop to prompt the user for their username
        while(true){
             System.out.print("Please enter your username: ");
             userName = input.nextLine();
        
        if(Login.checkUserName(userName)){
            System.out.print("Username succesfully captured.");
            break;
        
        } else {
            System.out.print("Username is not correctly formated,");
            System.out.print("Username must contain an underscore,");
            System.out.print("Username must atleast contain atleast 5 characters,");
        }
        }
                
        // a while loop to propt the user for their email
        while(true){
             System.out.print("Please enter your email address: ");
             emailAddress = input.nextLine();
        
        if(Login.checkEmailAddress(emailAddress)){
            System.out.print("Email address succesfully captured");
            break;
        
        } else {
            System.out.print("Email address is not correctly formated: ");
            System.out.print("Email address must contain @gmail.com");
        }
        }
        
         while(true){
             System.out.print("Please enter your password: ");
             password = input.nextLine();
        
        if(Login.checkPassword(password)){
            System.out.print("password succesfully captured");
            break;
        
        } else {
            System.out.print("Password is not correctly formatted,");
            System.out.print("Password must contain atleast 8 characters,");
            System.out.print("Password must contain a capital letter,");
            System.out.print("Password must contain a number,");
            System.out.print("Password must contain a special character,");
        }
        }
         while(true){
             System.out.print("Please enter your number phone: ");
             numberPhone = input.nextLine();
        
        if(Login.checkCellPhoneNumber(numberPhone)){
            System.out.print("number phone succesfully captured");
            break;
        
        } else {
            System.out.print("number phone is not correctly formatted,");
            System.out.print("Number phone must contain international code,");
            System.out.print("Number phone must atleast contain 10 digits");      
        }
            
        }
         System.out.println("you have registerd succesfully");
         System.out.println("Welcome" + name + " " + surname);
         
         input.close();

    }
    
}
