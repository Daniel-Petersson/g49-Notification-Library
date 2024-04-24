package se.lexicon.service;

import se.lexicon.Model.Email;
import se.lexicon.dao.EmailDao;
import se.lexicon.dao.EmailDaoImpl;
import se.lexicon.exception.EmailException;

import java.util.List;

public class EmailServiceImpl implements EmailService {
    private EmailDao emailDao;

    public EmailServiceImpl() {
        emailDao = EmailDaoImpl.getInstance();
    }

    @Override
    public Email createAndSend(String recipient, String subject, String message) throws EmailException {
        if (recipient == null) throw new IllegalArgumentException("recipient cant be null");
        Email savedEmail = emailDao.save(new Email(recipient, subject, message));
        savedEmail.setStatus(true);
        emailDao.update(savedEmail);
        return savedEmail;
    }

    @Override
    public List<Email> findAll() {
        return emailDao.findAll();
    }
}
