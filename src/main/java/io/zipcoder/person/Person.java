package io.zipcoder.person;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

    private String firstName;
    private String lastName;

    @Id
    private Long id;

    public Person(String firstName, String lastName) {
        this(null, firstName, lastName);

    }

    public Person(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
