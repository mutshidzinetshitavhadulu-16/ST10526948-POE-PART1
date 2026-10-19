/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poemutshidzi;

/**
 *
 * @author mutsh
 */
public class Login {
    private String userName;
    private String password;
    private String numberPhone;
    private String name;
    private String surname;
    
    public Login(){}
    public Login(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
    
    public static boolean checkUserName(String userName){
            if (userName.length() >5){
                return false;
            }
             boolean hasUnderscore = false;
                        
            for(int i= 0; i < userName.length(); i++){
                char ch = userName.charAt(i);
                
                if(ch == '_'){
                    hasUnderscore = true;
                }
                  }
            return hasUnderscore;
        }
    public static boolean checkEmailAddress(String email){
            
         return email.endsWith("@gmail.com");   
        }
        public static boolean checkPassword(String password){
            if (password.length() <10){
                return false;
            }
            boolean hasCapitalLetter=false;
            boolean hasSpecialCharacter=false;
            boolean hasNumber=false;
            
            for(int i= 0; i < password.length(); i++){
                char ch = password.charAt(i);
                
                if(Character.isUpperCase(ch)){
                    hasCapitalLetter = true;
                }
                if(Character.isDigit(ch)){
                    hasNumber = true;
                }
                if(Character.isLetterOrDigit(ch)){
                    hasSpecialCharacter = true;
                }
                   }
            return hasCapitalLetter && hasSpecialCharacter && hasNumber;
        }
        
        public static boolean checkCellPhoneNumber(String numberPhone){
            return numberPhone.startsWith("+27") && numberPhone.length() == 12;
        }
        
        
        public boolean checkPasswordComplexity(String password){
        return checkPassword(password);
    }
        public String getUserName(){
            return userName;
        }
        
        public String getNumberPhone(){
            return numberPhone;
        }
        
        public String getPassword(){
            return password;
        }
        
        public String getSurname(){
            return surname;
        }
        
        public String getName(){
            return name;
        }
        
    
        public String registerUser(String userName, String password, String numberPhone, String name, String surname){
               if(!checkUserName(userName)){
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
                if(!checkPasswordComplexity(password)){
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
                if(!checkCellPhoneNumber(numberPhone)){
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }
                this.userName = userName;
                this.password = password;
                this.numberPhone = numberPhone;
                this.name = name;
                this.surname = surname;
            return "Registration successful.";
    }

        public boolean loginUser(String user, String pass){
            return user.equals(this.userName) && pass.equals(this.password);
    }

        public String returnLoginStatus(String user, String pass){
               if(loginUser(user, pass)){
            return "Welcome " + this.name + " " + this.surname + " " + "it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
        }
}
        
       

