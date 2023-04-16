package dataBaseServletTask;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class FactoryManager {

    private static SessionFactory sessionFactory;
    private static volatile FactoryManager instance;

    private FactoryManager(){
    }

    public static FactoryManager getManager() {
        if (instance != null) {
            return instance;
        }
        synchronized (FactoryManager.class){
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Student.class);
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(registryBuilder.build());
            instance = new FactoryManager();
        }
        return instance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}