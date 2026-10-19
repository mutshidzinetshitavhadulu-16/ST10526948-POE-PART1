package Login;
import poemutshidzi.SendMessage;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mutsh
 */
public class SendMessageTest {
    

    // Test 1 - Success case from POE doc page 14
    @Test
    public void testCheckRecipientCellSuccess() {
        SendMessage.recipient = "+27718693002";
        String result = SendMessage.checkRecipientCell();
        assertEquals("Cell phone number successfully captured.", result);
    }

    // Test 2 - Failure case from POE doc page 14
    @Test
    public void testCheckRecipientCellFailure() {
        SendMessage.recipient = "08575975889";
        String result = SendMessage.checkRecipientCell();
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code.", result);
    }

    // Test 3 - MessageID not more than 10 characters
    @Test
    public void testCheckMessageID() {
        SendMessage.messageID = "1234567890"; 
        assertTrue(SendMessage.checkMessageID());
        
        SendMessage.messageID = "12345678901"; 
        assertFalse(SendMessage.checkMessageID());
    }

    // Test 4 - Message length <= 250
    @Test
    public void testCheckMessageLengthSuccess() {
        SendMessage.messageText = "Hi Mike, can you join us for dinner tonight";
        String result = SendMessage.checkMessageLength();
        assertEquals("Message ready to send.", result);
    }

    // Test 5 - Message length exceeds 250
    @Test
    public void testCheckMessageLengthFailure() {
        // Create a message with 260 characters
        SendMessage.messageText = "a".repeat(260);
        String result = SendMessage.checkMessageLength();
        assertTrue(result.contains("Message exceeds 250 characters by"));
    }
}
