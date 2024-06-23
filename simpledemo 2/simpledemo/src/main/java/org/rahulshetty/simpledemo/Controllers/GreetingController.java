package org.rahulshetty.simpledemo.Controllers;

import org.rahulshetty.simpledemo.Model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    AtomicLong counter = new AtomicLong();
    @Autowired
    Greeting greeting;

    @GetMapping("/greeting")
    public Greeting getGreeting(@RequestParam(value="name") String name){
        greeting.setContext("Hey "+name+" Welcome again!");
        greeting.setId(counter.incrementAndGet());
        return greeting;
    }

    @GetMapping("/greeting/{guestno}")
    public Greeting getVisitNumber(@PathVariable int guestno){
        greeting.setGuestNum(guestno);
        return greeting;
    }

}
