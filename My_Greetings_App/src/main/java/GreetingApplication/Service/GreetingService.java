package GreetingApplication.Service;

import GreetingApplication.Model.Greeting;
import GreetingApplication.Repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {


    private GreetingRepository greetingRepository;
    private long id = 1;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public String getGreetingMessage(String firstName, String lastName) {

        if(firstName != null && lastName != null) {
            return "Hello " + firstName + " " + lastName;
        }

        if(firstName != null) {
            return "Hello " + firstName;
        }

        if(lastName != null) {
            return "Hello " + lastName;
        }

        return "Hello User";
    }

    public Greeting saveGreeting(String message) {
        Greeting greeting = new Greeting(id++, message);

        return greetingRepository.save(greeting);
    }

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Greeting editGreeting(Long id,String message) {

        Greeting greeting = greetingRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Greeting Not Found"));

        greeting.setMessage(message);

        return greeting;
    }

    public String deleteGreeting(Long id) {
        Greeting greeting = greetingRepository.findById(id).orElseThrow(() -> new RuntimeException("Greeting Not Found"));

        greetingRepository.delete(greeting);

        return "Greeting Deleted";
    }
}