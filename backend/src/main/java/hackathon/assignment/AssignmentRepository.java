package edu.tucn.scd.hackathon.assignment;

import edu.tucn.scd.hackathon.anunturi.Anunturi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM Assignment")
    List<Assignment> getAssignments();

    @Query(nativeQuery = true, value = "SELECT * FROM Assignment WHERE profesor = ?1")
    Assignment findAssignment(String profesor);

    @Query(nativeQuery = true, value = "SELECT * FROM Assignment WHERE profesor = ?1")
    List<Assignment> getAssignmentsFromProfesor(String profesor);

    @Query(nativeQuery = true, value = "SELECT * FROM Assignment WHERE materie = ?1")
    List<Assignment> getAssignmentWithMaterie(String materie);
}
