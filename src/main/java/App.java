import org.hibernate.Session;
import util.HibernateUtil;

public class App {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(null);
        session.getTransaction().commit();
        session.close();
    }
}
