package facades;

import entities.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersonFacade implements IPersonFacade{

    private static PersonFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private PersonFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static PersonFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public Person addPerson(String firstName, String lastName, String phone) {
        Person p1 = new Person("1234", "jabs", "jabr"); 
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p1);
            em.getTransaction().commit();
            return p1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return p1;
    }

    @Override
    public Person deletePerson(int id) {
        EntityManager em = emf.createEntityManager(); 
        Person p = null; 
        try {
            p = em.createQuery("delete FROM person id WHERE id.id = :id", Person.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return p; 
    }

    @Override
    public Person getPerson(int id) {
        EntityManager em = emf.createEntityManager(); 
        Person p = null; 
        try {
            p = em.createQuery("SELECT FROM person id WHERE id.id = :id", Person.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
           
        }
        return p;
    }

    @Override
    public List<Person> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        return em.createNamedQuery("person.getAll").getResultList();
    }

    @Override
    public Person editPerson(Person p) {
        EntityManager em = getEntityManager();
        if (p.getFirstName() != null && !p.getFirstName().isEmpty() && p.getLastName() != null && !p.getLastName().isEmpty()) {
            try {
                em.getTransaction().begin();
                em.merge(p);
                em.getTransaction().commit();
                return p;
            } catch (Exception e) {
                em.getTransaction().rollback();
                
            } finally {
                em.close();
            }
        } else {
            
        }
        return null; 
    }
    }

