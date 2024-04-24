package se.lexicon.service;

import se.lexicon.Model.Email;
import se.lexicon.exception.EmailException;

import java.util.List;

public interface EmailService {
    Email createAndSend(String recipient, String subject, String message) throws EmailException;

    List<Email> findAll();
}
