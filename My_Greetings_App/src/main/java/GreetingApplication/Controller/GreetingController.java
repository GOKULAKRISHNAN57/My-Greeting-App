package GreetingApplication.Controller;

import GreetingApplication.Model.Greeting;
import GreetingApplication.Service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}