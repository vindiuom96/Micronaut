package my.task.micronaut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import javax.inject.Singleton;
 
@Singleton
public class PersonService {
    private Map<String, Person> database = new HashMap<>();
    
    public void addPerson(Person p) {
    database.put(p.getId(), p);
    }
    
    public Person getPerson(String id) {
    Person p = database.get(id);
    return p;
    }
    
    public List<Person> getAllPersons() {
    List<Person> allPersons = new ArrayList<>();
    database.forEach((k,v) -> allPersons.add(v));
    return allPersons;
    }
    
    public void updatePerson(Person p) {
    database.replace(p.getId(), p);
    }
    
    public void deletePerson(String id) {
    Person p = database.get(id);
    if (null != p) {
    database.remove(id);
    }
    }
}
