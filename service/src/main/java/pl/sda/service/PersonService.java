package pl.sda.service;

import pl.sda.domain.model.Person;
import pl.sda.persistance.repository.PersonRepository;

public class PersonService {

    private final PersonRepository personRepository;

    public PersonService() {
        this.personRepository = new PersonRepository();
    }

    public Integer addPerson(String firstName, String lastName, String phone, String email){
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setPhone(phone);
        person.setEmail(email);

        PersonRepository personRepository = new PersonRepository();

        Integer save = personRepository.save(person);

        return save;
    }
}
