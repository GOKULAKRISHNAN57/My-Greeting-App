package GreetingApplication.Repository;

import GreetingApplication.Model.Greeting;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GreetingRepository {

    private final List<Greeting> greetings = new ArrayList<>();

    public void save(Greeting greeting) {
        greetings.add(greeting);
    }

    public List<Greeting> findAll() {
        return greetings;
    }
}