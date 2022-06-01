package com.bridgelabz.greetingapp.controller;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
     private static final String template = "Hello , %s!";
     private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingService greetingService;
/**
//     * @Func :Returning JSON Object
// * @Param:Adding first name ,last name
// * {
// *     name=Krunali in "params"-POSTMAN
// *     lastname=Lole
// * }
//     * @URL: http://localhost:8080/home  -Postman-GET
//     * @return: hello
     */
    @GetMapping(value={" ", "/" , "/home"})
    public Greeting greeting(@RequestParam(value = "firstName", defaultValue = "World") String firstName,
                             @RequestParam(value = "lastName", defaultValue = "") String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.addGreeting(user);
    }
//    /**
//     * @Func :Ability To Find By id
//     * @URL: http://localhost:8080/path/2   for eg:"id=2"
//     * @Return: Value at id 2
//     */
    @GetMapping("/path/{id}")
    public Greeting getElementById(@PathVariable Long id){
        return greetingService.getGreetingById(id);
    }
//    /**
//     * @Func :Ability To List All messages
//     * @URL: http://localhost:8080/all
//     * @Return: All elements in repository
//     **/
    @GetMapping("/all")
    public List<Greeting> getAll(){
        return greetingService.getAll();
    }
//    /**
//     * @Func :Ability To Edit Messages in Repository
//     * @URL: http://localhost:8080/edit/2   for ed id:2
//     * @Return: Edits position Id 2
//     */
    @PutMapping("/edit/{id}")
    public Greeting editGreetingById(@PathVariable long id, @RequestParam String name){
        return greetingService.editGreetingById(id, name);
    }
//    /**
//     * @Func :Ability To Delete Messages in Repository
//     * @URL: http://localhost:8080/delete/2   for ed id:2
//     * @Return: Delete's position Id 2
//     */
    @DeleteMapping("/delete/{id}")
    public List<Greeting> deleteGreetingById(@PathVariable Long id){
        return greetingService.deleteGreetingById(id);
    }

}
