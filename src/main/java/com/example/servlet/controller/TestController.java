package com.example.servlet.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
    @GetMapping
    public String testHome(Model model){
        model.addAttribute("text", "hello");
        model.addAttribute("person", new Person("John", 30));
        List<Person> people = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            people.add(new Person("Person" + i, 20 + i));
        }
        model.addAttribute("people", people);
        return "test-home";
    }

//  get form data
//    <form th:action="@{/test}" method="post">
//        <input type="text" name="name"/>
//        <input type="text" name="age"/>
//        <button type="submit">전송</button>
//    </form>
    @PostMapping
    public String testPost(@RequestParam String name, @RequestParam int age, Model model){
        Person person = new Person(name, age);
        System.out.println(person);
        model.addAttribute("person", person);
        System.out.println(model);
        return "redirect:/test";
    }
}

class Person{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
