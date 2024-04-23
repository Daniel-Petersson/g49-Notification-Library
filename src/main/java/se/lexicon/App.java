package se.lexicon;

import se.lexicon.Model.Email;
import se.lexicon.dao.EmailDao;
import se.lexicon.dao.EmailDaoImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EmailDao dao = EmailDaoImpl.getInstance();
        Email email1 = dao.save(new Email("test","TestSub","testcontent"));
        System.out.println(email1);
        Email foundEmail = dao.find(email1.getId());
        System.out.println(foundEmail.summary());
    }
}
