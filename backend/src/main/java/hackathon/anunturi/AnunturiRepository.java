package edu.tucn.scd.hackathon.anunturi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnunturiRepository extends JpaRepository<Anunturi, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM Anunturi")
    List<Anunturi> getAnunturi();

    @Query(nativeQuery = true, value = "SELECT * FROM Anunturi WHERE titlu = ?1")
    Anunturi findAnunt(String titlu);

    @Query(nativeQuery = true, value = "SELECT * FROM Anunturi WHERE profesor = ?1")
    List<Anunturi> getAnunturiFromProfesor(String profesor);

    @Query(nativeQuery = true, value = "SELECT * FROM Anunturi WHERE subiect = ?1")
    List<Anunturi> getAnunturiWithSubject(String subiect);
}
