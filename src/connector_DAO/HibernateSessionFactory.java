package connector_DAO;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactory {

 private static final SessionFactory sessionFactory;

 static {
   try {
   // Cr�e la SessionFactory
	   Configuration configuration = new Configuration().configure();
	   configuration.addClass(model_ORM.Annonce.class);
	   configuration.addClass(model_ORM.Categorie.class);
	   configuration.addClass(model_ORM.Client.class);
	   configuration.addClass(model_ORM.Creneau.class);
	   configuration.addClass(model_ORM.Menu.class);
	   configuration.addClass(model_ORM.Plagefermeture.class);
	   configuration.addClass(model_ORM.Plat.class);
	   configuration.addClass(model_ORM.Reduction.class);
	   configuration.addClass(model_ORM.Reservation.class);
	   configuration.addClass(model_ORM.Restaurant.class);
	   configuration.addClass(model_ORM.Restaurateur.class);
	   configuration.addClass(model_ORM.Tpsmoyenrepas.class);
	   configuration.addClass(model_ORM.Utilisateur.class);
	   configuration.addClass(model_ORM.Ville.class);
	   
	   StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	   sessionFactory = configuration.buildSessionFactory(builder.build());
	   //sessionFactory = new Configuration().configure().buildSessionFactory();
   } 
   catch (HibernateException ex) {
	   throw new RuntimeException("Probl�me de configuration : "+ ex.getMessage(), ex);
   }
}

 public static final ThreadLocal session = new ThreadLocal();

 public static Session currentSession() throws HibernateException {
   Session s = (Session) session.get();
   // Ouvre une nouvelle Session, si ce Thread n'en a aucune
   if (s == null) {
	   s = sessionFactory.openSession();
	   session.set(s);
   }
   return s;
   }

 public static void closeSession() throws HibernateException {
   Session s = (Session) session.get();
   session.set(null);
   if (s != null)
	   s.close();
   }
 }
