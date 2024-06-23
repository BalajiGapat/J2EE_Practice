package com.journal.controller;

import com.journal.entity.JournalEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/journal") // http://localhost:8080/journal
public class JournalController
{
    private static List<JournalEntity> list=new ArrayList<>();
    static
    {
        list.add(new JournalEntity(11, "java", "core java"));
        list.add(new JournalEntity(12, "J2EE", "advance java"));
        list.add(new JournalEntity(13, "Python", "Data science"));
        list.add(new JournalEntity(14, "Python ", "DJango"));
    }

    @GetMapping("/get-all") // http://localhost:8008/journal/get-all
    public ResponseEntity<?> getALl()
    {

        System.out.println(list);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping // http://localhost:8080/journal
    public ResponseEntity<?> createJournal(@RequestBody JournalEntity entity)
    {
        list.add(entity);
        System.out.println("added"+entity);
        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }

    @GetMapping("/get-by/id/{id}") // http://localhost:8080/journal/get-by/id/11
    public ResponseEntity<?> getById(@PathVariable int id)
    {
        // JournalEntity object=list.get(id);
        List<JournalEntity> journal= list.stream().filter(obj->obj.getId()==id).collect(Collectors.toList());
        return new ResponseEntity<>(journal, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete") // http://localhost:8080/journal/delete?id=11
    public ResponseEntity<?> deleteById(@RequestParam int id)
    {
        // JournalEntity object=list.get(id);
        List<JournalEntity> toRemove = list.stream().filter(obj -> obj.getId() == id).collect(Collectors.toList());
        boolean result = list.removeAll(toRemove);
        return new ResponseEntity<>(result ? "Deleted successfully" : "No item found", HttpStatus.OK);
    }

    @PutMapping("/update-by-id/{id}") // http://localhost:8080/journal/update-by-id/11
    public ResponseEntity<?> updateById(@PathVariable int id, @RequestBody JournalEntity entity)
    {
        // Find the index of the entity with the given ID
        int index = -1;
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getId() == id)
            {
                index = i;
                break;
            }
        }

        // If the entity with the given ID is not found, return an error response
        if (index == -1)
        {
            return ResponseEntity.notFound().build();
        }

        // Update the entity at the found index
        list.set(index, entity);

        return ResponseEntity.ok().body("updated...!!!");
    }

}
