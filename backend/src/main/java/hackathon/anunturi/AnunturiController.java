package edu.tucn.scd.hackathon.anunturi;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anunturi")
public class AnunturiController {
    @Autowired
    private AnunturiService anunturiService;

    @Operation
    @PostMapping
    public Anunturi create(@RequestBody Anunturi anunturi) {
        return anunturiService.create(anunturi);
    }

    @Operation
    @GetMapping
    public List<Anunturi> getAnunturi(){
        return anunturiService.getAnunturi();
    }

    @Operation
    @DeleteMapping
    public void deleteAnunt(@RequestParam String titlu){
        anunturiService.deleteAnunt(titlu);
    }

    @Operation
    @PutMapping
    public Anunturi updateAnunt(@RequestParam String titlu, @RequestBody Anunturi anunturi) {
        return anunturiService.updateAnunt(titlu,anunturi);
    }

    @Operation(summary = "Afiseaza toate anunturile unui profesor")
    @GetMapping("/{profesor}")
    public List<Anunturi> getAnunturiFromProfesor(@RequestParam String profesor){
        return anunturiService.getAnunturiFromProf(profesor);
    }

    @Operation(summary = "Afiseaza toate anunturile legate de un subiect")
    @GetMapping("/subiect/{subiect}")
    public List<Anunturi> getAnunturiWithSubject(@RequestParam String subiect){
        return anunturiService.getAnunturiWithSubject(subiect);
    }
}
