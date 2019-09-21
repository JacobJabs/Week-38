package entities;

import entities.Adress;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-17T10:21:56")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> lastName;
    public static volatile ListAttribute<Customer, String> hobbies;
    public static volatile SingularAttribute<Customer, String> name;
    public static volatile SingularAttribute<Customer, Adress> adress;
    public static volatile SingularAttribute<Customer, Integer> id;

}