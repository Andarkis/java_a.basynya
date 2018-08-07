package ru.ql.basynya.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.ql.basynya.mantis.model.UserData;
import ru.ql.basynya.mantis.model.Users;

import java.util.List;

public class DbHelper {

  private final SessionFactory sessionFactory;
  private final ApplicationManager app;


  public DbHelper(ApplicationManager app) {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    this.app = app;
  }

  public Users nonAdminUsers() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<UserData> result = session.createQuery("FROM UserData WHERE access_level != 90").list();
    session.getTransaction().commit();
    session.close();
    return new Users(result);
  }

}
