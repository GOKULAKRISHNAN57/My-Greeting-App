package GreetingApplication.Controller;

import GreetingApplication.Model.Greeting;
import GreetingApplication.Service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }


    @GetMapping("/greet")
    public Greeting greeting(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        String message =
                greetingService.getGreetingMessage(firstName,lastName);

        return greetingService.saveGreeting(message);
    }

    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }

    @PutMapping("/edit/{id}")
    public Greeting editGreeting(@PathVariable Long id, @RequestParam String message) {

        return greetingService.editGreeting(id,message);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        return greetingService.deleteGreeting(id);
    }
}