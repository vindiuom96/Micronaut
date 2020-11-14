package my.task.micronaut;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import my.task.micronaut.Person;
import my.task.micronaut.PersonService;

import javax.inject.Inject;

import org.json.simple.JSONObject;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;

@Controller("/pearson")
public class PersonController {
    @Inject
    PersonService personService;
    
    @Get("/")
    public HttpStatus index() {
    return HttpStatus.OK;
    }
    
    @Post("/add")
    public HttpStatus addPerson(@Body Person person) {
    personService.addPerson(person);
    return HttpStatus.CREATED;
    }
    
    @SuppressWarnings("unchecked")
    @Produces(MediaType.APPLICATION_JSON)
    @Get("/get")
    public JSONObject getPersons() {
        JSONObject responseObj = new JSONObject();
        responseObj.put("data",personService.getAllPersons());
        return responseObj;
    }
}