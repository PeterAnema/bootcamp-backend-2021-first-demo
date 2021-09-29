package nl.novi.firstdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NameController {

    private static List<String> names = new ArrayList<>();

    public NameController() {
        names.add("Peter");
        names.add("Zuzanne");
    }

    @GetMapping(value = "/names")
    public String[] getNames() {
        return (String[]) names.toArray();
    }

    @GetMapping(value = "/names/{id}")
    public String getName(@PathVariable int id) {
        return names.get(id);
    }

}
