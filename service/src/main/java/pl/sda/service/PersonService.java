package pl.sda.service;

import pl.sda.domain.model.Person;
import pl.sda.domain.model.dto.UserAddDto;
import pl.sda.persistance.repository.PersonRepository;

import java.util.List;

public class PersonService {

    private final PersonRepository personRepository;

    public PersonService() {
        this.personRepository = new PersonRepository();
    }

    public Integer addPerson(String firstName, String lastName, String phone, String email){
        List<Person> personsWithSameEmail = personRepository.findByEmail(email);
        if(personsWithSameEmail.size() == 0) {
            Person person = new Person();
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setPhone(phone);
            person.setEmail(email);

            Integer personId = personRepository.save(person);
            return personId;
        }
        return personsWithSameEmail.get(0).getId();
    }

    public Integer addPerson(UserAddDto userAddDto) {
        return addPerson(userAddDto.firstName,userAddDto.lastName,userAddDto.phone,userAddDto.email);
    }

    public Person findByID(Integer personId) {
        return personRepository.findById(personId);
    }
}
