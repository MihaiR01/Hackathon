package edu.tucn.scd.hackathon.notite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface NotiteRepository extends JpaRepository<Notite, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM Notite")
    List<Notite> getNotite();

    @Query(nativeQuery = true, value = "SELECT * FROM Notite WHERE titlu = ?1")
    Notite findNotita(String titlu);
}
