package se.lexicon.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.lexicon.Model.Email;
import se.lexicon.exception.DataNotFoundException;

import java.util.zip.DataFormatException;


public class EmailDaoImpTest {

    private EmailDaoImpl testObject;
    private Email savedEmail;
    //private Email foundEmail;

    @BeforeEach
    public void setup() {
        testObject = EmailDaoImpl.getInstance();
        Email email = new Email("recipient@example.se", "Test Subject", "Test Messenger");

        this.savedEmail = testObject.save(email);

        Email foundEmail = testObject.find(savedEmail.getId());

        assertNotNull(savedEmail);
        assertEquals(savedEmail, foundEmail);
    }

    @Test
    @DisplayName("Test Save Email")
    public void testSave() {
        Email email = new Email("recipient@example.se", "Test Subject", "Test Messeger");

        Email savedEmail = testObject.save(email);

        Email foundEmail = testObject.find(savedEmail.getId());

        assertNotNull(savedEmail);
        assertEquals(savedEmail, foundEmail);

    }

    @Test
    public void testFind(){
        Email foundEmail = testObject.find(savedEmail.getId());
        assertNotNull(foundEmail);
        assertEquals(savedEmail,foundEmail);
    }

    @Test
    public void testNonExistingId(){
        assertThrows(DataNotFoundException.class,()->testObject.find("123"));
    }

    @Test
    @DisplayName("Update Email with Null Email")
    public void givenNullEmail_whenUpdate_thenThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> testObject.update(null));
    }

    @Test
    @DisplayName("Update Email with Null Id")
    public void givenEmailWithNullId_whenUpdate_thenThrowsIllegalArgumentException() {
        Email emailWithNullId = new Email("recipient@example.se", "Test Subject", "Test Messenger");
        assertThrows(IllegalArgumentException.class, () -> testObject.update(emailWithNullId));
    }

    @Test
    @DisplayName("Update Email with Non-Existing Id")
    public void givenEmailWithNonExistingId_whenUpdate_thenThrowsDataNotFoundException() {
        Email emailWithNonExistingId = new Email("recipient@example.se", "Test Subject", "Test Messenger");
        emailWithNonExistingId.setId("non-existing-id");
        assertThrows(DataNotFoundException.class, () -> testObject.update(emailWithNonExistingId));
    }
}
