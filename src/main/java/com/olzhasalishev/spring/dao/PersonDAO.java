package com.olzhasalishev.spring.dao;

import com.olzhasalishev.spring.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<Person>();

        people.add(new Person(++PEOPLE_COUNT,"Olzhas"));
        people.add(new Person(++PEOPLE_COUNT,"Manas"));
        people.add(new Person(++PEOPLE_COUNT,"Ansar"));
        people.add(new Person(++PEOPLE_COUNT,"Sagyndyk"));
    }

    public List<Person> index(){
        return people;
    }

    public void save(Person person){
        person. setId(++PEOPLE_COUNT);
         people.add(person);
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void update(int id, Person updatedPerson){
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
    }

    public void delete(int id){
        people.removeIf(p -> p.getId() == id);

    }
}
