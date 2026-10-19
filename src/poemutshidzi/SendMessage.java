/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poemutshidzi;
import java.util.*;
import java.io.FileWriter;
/**
 *
 * @author mutsh
 */
public class SendMessage {
    static int totalMessagesSent = 0;
    static int messageCount = 0;
    static String messageID;
    static String messageHash;
    static String recipient;
    static String messageText;
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        
        // User must login first
        System.out.println("=== LOGIN ===");
        System.out.print("Enter username: ");
        String username = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();

        if (username.isEmpty() || password.isEmpty()) {
            System.out.println("Login failed. Cannot send messages.");
            return;
        }

        //  Welcome message
        System.out.println("\nWelcome to QuickChat.");

        // How many messages user wants to enter
        System.out.print("\nHow many messages do you wish to enter? ");
        int numMessages = Integer.parseInt(input.nextLine());

        
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1) Send Messages");
            System.out.println("2) Show recently sent messages");
            System.out.println("3) Quit");
            System.out.print("Choose option: ");
            int option = Integer.parseInt(input.nextLine());
           
       switch (option) {
    case 1:  {
        if (messageCount >= numMessages) {
            System.out.println("You have reached the limit of " + numMessages + " messages.");
            break;
        }

        // Ask for the recipient number
        System.out.print("Enter recipient number (e.g +27718693002): ");
        recipient = input.nextLine();

        // Check recipient number
        String checkRec = checkRecipientCell();
        System.out.println(checkRec);
        if (!checkRec.equals("Cell phone number successfully captured.")) {
            break; // do not count invalid
        }

        // Ask for the message they want to send
        System.out.print("Enter your message (max 250 chars): ");
        messageText = input.nextLine();

        // Check the length of the message 
        String checkLength = checkMessageLength();
        System.out.println(checkLength);
        if (checkLength.contains("exceeds")) {
            System.out.println("Please enter a message of less than 250 characters.");
            break;
        }

        messageID = createMessageID();
        System.out.println("Message ID generated: " + messageID);
        
        messageCount++;
        messageHash = createMessageHash();

        System.out.println("\nWhat do you want to do?");
        System.out.println("1) Send Message");
        System.out.println("2) Disregard Message");
        System.out.println("3) Store Message");
        System.out.print("Choose: ");
        int sendOption = Integer.parseInt(input.nextLine());

        String result = SentMessage(sendOption);
        System.out.println(result);

        if (result.equals("Message successfully sent.")) {
            System.out.println("\n--- MESSAGE DETAILS ---");
            System.out.println(printMessages());
        }

        if (messageCount == numMessages) {
            System.out.println("\nTotal messages sent: " + returnTotalMessagess());
        }       }

    case 2: System.out.println("Coming Soon.");

    case 3:   {
        System.out.println("\nTotal messages sent: " + returnTotalMessagess());
        System.out.println("Goodbye!");
        return; }
       }
        }
    }

       //checkMessageID must not be more than 10 characters
    public static boolean checkMessageID() {
        return messageID.length() <= 10;
    }

    //checkRecipientCell() must have international code and <=12 chars
    public static String checkRecipientCell() {
        if (recipient != null && recipient.startsWith("+") && recipient.length() <= 12) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    //  check the message length 
    public static String checkMessageLength() {
        if (messageText.length() > 250) {
            int extra = messageText.length() - 250;
            return "Message exceeds 250 characters by " + extra + ", please reduce the size.";
        } else {
            return "Message ready to send.";
        }
    }

    public static String createMessageHash() {
        String firstTwo = messageID.substring(0, 2);
        String[] words = messageText.trim().split(" ");
        String firstWord = words[0].replaceAll("[^a-zA-Z]", "");
        String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z]", "");
        return firstTwo + ":" + messageCount + ":" + firstWord.toUpperCase() + lastWord.toUpperCase();
    }

    public static String SentMessage(int choice) {
        switch (choice) {
            case 1: {
                totalMessagesSent++;
                return "Message successfully sent.";
            }
            case 2: {
                return "Press 0 to delete the message.";
            }
            case 3: {
                storeMessage();
                return "Message successfully stored.";
            }
            default: {
                return "Invalid choice.";
            }
        }
    }

    public static String printMessages() {
        return "MessageID: " + messageID + "\nMessage Hash: " + messageHash + "\nRecipient: " + recipient + "\nMessage: " + messageText;
    }

    public static int returnTotalMessagess() {
        return totalMessagesSent;
    }

public static void storeMessage() {
    try (FileWriter writer = new FileWriter("storedMessages.json", true)) {
        writer.write("{\n");
        writer.write("  \"MessageID\": \"" + messageID + "\",\n");
        writer.write("  \"MessageHash\": \"" + messageHash + "\",\n");
        writer.write("  \"Recipient\": \"" + recipient + "\",\n");
        writer.write("  \"Message\": \"" + messageText + "\"\n");
        writer.write("},\n");
        System.out.println("Message saved to storedMessages.json");
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}
    
    public static String createMessageID() {
        long number = 1000000000L + (long)(rand.nextDouble() * 9000000000L);
        return String.valueOf(number);
    }
}

