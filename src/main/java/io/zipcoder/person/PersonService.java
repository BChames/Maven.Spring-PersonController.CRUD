package io.zipcoder.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository){
        this.repository = repository;
    }

    public Iterable<Person> getPersonList(){
        return repository.findAll();
    }

    public Person getPerson(Long id){
        return repository.findOne(id);
    }

    public Person createPerson(Person p){

        return repository.save(p);
    }

    public Person updatePerson(Long id, Person newPersonData){
        Person originalPerson = repository.findOne(id);
        originalPerson.setFirstName(newPersonData.getFirstName());
        originalPerson.setFirstName(newPersonData.getLastName());
        return repository.save(originalPerson);
    }

    public Boolean deletePerson(Long id) {
        try {
            repository.delete(id);
            return true;
        }
        catch(Exception e){
            if(repository.findOne(id) == null){
                new Exception("This person does not exist!!");
            }
        }
       return false;
    }
}
