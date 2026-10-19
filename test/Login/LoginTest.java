/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Login;
import poemutshidzi.Login;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author mutsh
 */
public class LoginTest {
   private Login login;

    public LoginTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        login = new Login("Kyle" , "Smith"); // test user
    }

    @After
    public void tearDown() {
    }
    
     //Test of checkUserName method, of class Login.
     
    @Test
    public void testCheckUserName() {
        assertTrue("Valid username should return true",Login.checkUserName("kyl_1"));
        assertFalse("Invalid username should return false", Login.checkUserName("kyle!!!!!!!"));
    }

    
     //Test of checkPasswordComplexity method, of class Login.
     
    @Test
    public void testCheckPasswordComplexity() {
        assertTrue("Valid password should return true", login.checkPasswordComplexity("Ch&&sec@ke99!"));
        assertFalse("Invalid password should return false", login.checkPasswordComplexity("password"));
    }

    
     // Test of checkCellPhoneNumber method, of class Login.
     
    @Test
    public void testCheckCellPhoneNumber() {
        assertTrue("Valid phone should return true", Login.checkCellPhoneNumber("+27838968976"));
        assertFalse("Invalid phone should return false", Login.checkCellPhoneNumber("08966553"));
    }

    
     // Test of registerUser method, of class Login.
     
    @Test
    public void testRegisterUser() {
        // Successful registration
        String success = login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertEquals("Registration successful.", success);

        // Invalid username
        String invalidUser = login.registerUser("kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.", invalidUser);

        // Invalid password
        String invalidPass = login.registerUser("kyl_1", "password", "+27838968976", "Kyle", "Smith");
        assertEquals("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.", invalidPass);

        // Invalid cell number
        String invalidCell = login.registerUser("kyl_1", "Ch&&sec@ke99!", "08966553", "Kyle", "Smith");
        assertEquals("Cell phone number incorrectly formatted or does not contain international code.", invalidCell);
    }

     // Test of loginUser method, of class Login.
     
    @Test
    public void testLoginUser() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");

        assertTrue("Correct credentials should return true", login.loginUser("kyl_1", "Ch&&sec@ke99!"));
        assertFalse("Incorrect credentials should return false", login.loginUser("wrong", "wrongpass"));
    }

     // Test of returnLoginStatus method, of class Login.
     
    @Test
    public void testReturnLoginStatus() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");

        String success = login.returnLoginStatus("kyl_1", "Ch&&sec@ke99!");
        assertEquals("Welcome Kyle Smith it is great to see you again.", success);

        String fail = login.returnLoginStatus("wrong", "wrongpass");
        assertEquals("Username or password incorrect, please try again.", fail);
    } 
}
