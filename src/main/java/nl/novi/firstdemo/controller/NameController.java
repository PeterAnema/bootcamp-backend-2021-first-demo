package nl.novi.firstdemo.controller;

import org.springframework.web.bind.annotation.*;

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
    public List<String> getNames() {
        return names;
    }

    @GetMapping(value = "/names/{id}")
    public String getName(@PathVariable int id) {
        return names.get(id);
    }

    @PostMapping(value = "/names")
    public String addName(@RequestBody String name) {
        names.add(name);
        return "Added name " + name;
    }

    @DeleteMapping(value = "/names/{id}")
    public String deleteName(@PathVariable int id) {
        String name = names.get(id);
        names.remove(id);
        return "Removed name " + name;
    }

    @PutMapping(value = "/names/{id}")
    public String updateName(@PathVariable int id, @RequestBody String name) {
        names.set(id, name);
        return "Update name " + name;
    }


}
