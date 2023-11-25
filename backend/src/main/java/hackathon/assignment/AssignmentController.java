package edu.tucn.scd.hackathon.assignment;

import edu.tucn.scd.hackathon.anunturi.Anunturi;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {
    @Autowired
    private AssignmentService assignmentService;

    @Operation
    @PostMapping
    public Assignment create(@RequestBody Assignment assignment) {
        return assignmentService.create(assignment);
    }

    @Operation
    @GetMapping
    public List<Assignment> getAssignments(){
        return assignmentService.getAssignments();
    }

    @Operation
    @DeleteMapping
    public void deleteAnunt(@RequestParam String profesor){
        assignmentService.deleteAssignment(profesor);
    }

    @Operation
    @PutMapping
    public Assignment updateAnunt(@RequestParam String profesor, @RequestBody Assignment assignment) {
        return assignmentService.updateAssignment(profesor,assignment);
    }

    @Operation(summary = "Afiseaza toate assignmenturile de la un profesor")
    @GetMapping("/profesor/{profesor}")
    public List<Assignment> getAssignmentsFromProfesor(@RequestParam String profesor){
        return assignmentService.getAssignmentFromProf(profesor);
    }

    @Operation(summary = "Afiseaza toate assignmenturile legate de o materie")
    @GetMapping("/materie/{materie}")
    public List<Assignment> getAssignmentsWithMateria(@RequestParam String materie){
        return assignmentService.getAssignmentWithMaterie(materie);
    }

    @Operation
    @PutMapping("/{steps}")
    public Assignment updateAssignmentSteps(@RequestParam String profesor, @RequestParam String steps){
        return assignmentService.updateAssignmentSteps(profesor,steps);
    }
}
