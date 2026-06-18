package GreetingApplication.Repository;

import GreetingApplication.Model.Greeting;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class GreetingRepository {

    private final List<Greeting> greetings = new ArrayList<>();

    public Greeting save(Greeting greeting) {
        greetings.add(greeting);
        return greeting;
    }

    public List<Greeting> findAll() {
        return greetings;
    }

    public Optional<Greeting> findById(Long id) {

        return greetings.stream()
                .filter(g -> g.getId() == id)
                .findFirst();
    }

    public void delete(Greeting greeting) {
        greetings.remove(greeting);
    }
}