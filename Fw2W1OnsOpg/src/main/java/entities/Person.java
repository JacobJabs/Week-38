package entities;

import dto.PersonDTO;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.util.Date; 


@Entity
@NamedQuery(name = "Person.deleteAllRows", query = "DELETE from Person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName; 
    private String lastName; 
    private String created; 
    private String lastEdited; 
    private String phone; 
    
    
    public Person() {
    }

    public Person(String phone, String firstName, String lastName) {
        this.phone = phone; 
        this.firstName = firstName;
        this.lastName = lastName;
        
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLastEdited() {
        return lastEdited;
    }

    public void setLastEdited(String lastEdited) {
        this.lastEdited = lastEdited;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void editPerson(PersonDTO p) {
        int counter = 0;
        if (!p.getfName().equals(this.firstName)) {
            this.firstName = p.getfName();
            counter++;
        }
        if (!p.getlName().equals(this.lastName)) {
            this.lastName = p.getlName();
            counter++;
        }
        if (!p.getPhone().equals(this.phone)) {
            this.phone = p.getPhone();
        }
        if (counter > 0) {
            this.lastEdited = new String();
        }
    }
    
   
}
