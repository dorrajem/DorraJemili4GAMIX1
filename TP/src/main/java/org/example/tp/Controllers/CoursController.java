package org.example.tp.Controllers;


import lombok.AllArgsConstructor;
import org.example.tp.Entities.Cours;
import org.example.tp.Enum.Support;
import org.example.tp.Services.ICoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CoursController
{

    public CoursController(ICoursService coursService) {
        CoursService = coursService;
    }
    @Autowired
    private final ICoursService CoursService;


    @PostMapping("/addCours" )
    public Cours addCours(@RequestBody Cours Cours) {
        return CoursService.addCours(Cours);
    }
    @PutMapping("/updateCours" )
    public Cours updateCours(@RequestBody Cours Cours) {
        return CoursService.updateCours(Cours);
    }

    @GetMapping("/getCours/{numCours}" )
    public Cours getCoursBy(@PathVariable Long numCours) {
        return CoursService.retrieveCours(numCours);
    }

    @GetMapping("/getAllCourss" )
    public java.util.List<Cours> getAllCourss() {
        return CoursService.retrieveAllCourses();
    }
    @PutMapping("/deleteCours" )
    public void deleteCours(@RequestBody Long numCours) {
        CoursService.removeCours(numCours);
    }
    @GetMapping("/moniteurs/{numInstructor}/weeks")
    public List<Integer> numWeeksCourseOfInstructorBySupport(
            @PathVariable Long numInstructor,
            @RequestParam Support support) {
        return CoursService.numWeeksCourseOfInstructorBySupport(numInstructor, support);
    }

}
