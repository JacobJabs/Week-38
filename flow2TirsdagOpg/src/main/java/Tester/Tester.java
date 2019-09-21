/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;
import entities.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 *
 * @author jacob
 */
public class Tester {
    
    public static void main(String[] args) {
        Customer c1 = new Customer( "Jabs"); 
        c1.addhobby("Football");
        c1.addhobby("tennis");
        c1.addhobby("Gaming");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); 
        
        EntityManager em = emf.createEntityManager(); 
        try {
            em.getTransaction().begin();
            em.persist(c1);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
}
