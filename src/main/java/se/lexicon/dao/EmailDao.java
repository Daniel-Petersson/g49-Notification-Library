package se.lexicon.dao;


import se.lexicon.Model.Email;

import java.util.List;

public interface EmailDao extends NotificationDao<Email> {
    List<Email> findBySubject(String subject);
}