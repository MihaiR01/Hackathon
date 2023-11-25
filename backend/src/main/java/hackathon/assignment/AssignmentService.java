package edu.tucn.scd.hackathon.assignment;

import edu.tucn.scd.hackathon.anunturi.Anunturi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;

    @Transactional(rollbackFor = Exception.class)
    public Assignment create(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public List<Assignment> getAssignments(){
        return assignmentRepository.getAssignments();
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteAssignment(String profesor) {
        Assignment assignment = assignmentRepository.findAssignment(profesor);
        assignmentRepository.delete(assignment);
    }

    @Transactional(rollbackFor = Exception.class)
    public Assignment updateAssignment(String profesor, Assignment assignment){
        Assignment assignment1 = assignmentRepository.findAssignment(profesor);

        assignment1.setDescriere(assignment.getDescriere());
        assignment1.setDeadline(assignment.getDeadline());
        assignment1.setSteps(assignment.getSteps());
        assignment1.setMaterie(assignment.getMaterie());
        assignment1.setProfesor(assignment.getProfesor());

        return assignmentRepository.save(assignment1);
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public List<Assignment> getAssignmentFromProf(String profesor){
        return assignmentRepository.getAssignmentsFromProfesor(profesor);
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public List<Assignment> getAssignmentWithMaterie(String materie){
        return assignmentRepository.getAssignmentWithMaterie(materie);
    }

    @Transactional(rollbackFor = Exception.class)
    public Assignment updateAssignmentSteps(String profesor, String steps){
        Assignment assignment1 = assignmentRepository.findAssignment(profesor);

        assignment1.setSteps(steps);

        return assignmentRepository.save(assignment1);
    }
}
