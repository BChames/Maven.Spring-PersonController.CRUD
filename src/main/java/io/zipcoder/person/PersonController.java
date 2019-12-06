package io.zipcoder.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private PersonService service;

    @Autowired
    public PersonController(PersonService service){
        this.service = service;

    }

    @RequestMapping("/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person p){

        return new ResponseEntity<>(service.createPerson(p), HttpStatus.CREATED);
    }
    @GetMapping("/people/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id){

        return new ResponseEntity<>(service.getPerson(id), HttpStatus.OK);
    }
    @GetMapping("/people")
    public ResponseEntity<Iterable<Person>> getPersonList(){

        return new ResponseEntity<>(service.getPersonList(), HttpStatus.OK);
    }
    @PutMapping("/people/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person p){

        return new ResponseEntity<>(service.updatePerson(id, p), HttpStatus.OK);
    }
    @DeleteMapping("/people/{id}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable Long id){
       return new ResponseEntity<>(service.deletePerson(id), HttpStatus.OK);
    }
}
