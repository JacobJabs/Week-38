/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tester;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import entities.Customer; 
import entities.Adress; 

/**
 *
 * @author jacob
 */
public class Tester2 {
    
    public static void main(String[] args) {
        
        Customer cust = new Customer("jabs", "jabr");
        Adress add = new Adress("tranebærvej", "Greve"); 
        cust.setAdress(add);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager(); 
        try {
            em.getTransaction().begin();
            em.persist(cust); 
            em.persist(add);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
    }
            
}
