package edu.tucn.scd.hackathon.notite;

import edu.tucn.scd.hackathon.anunturi.Anunturi;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notite")
public class NotiteController {
    @Autowired
    private NotiteService notiteService;

    @Operation
    @PostMapping
    public Notite create(@RequestBody Notite notite) {
        return notiteService.create(notite);
    }

    @Operation
    @GetMapping
    public List<Notite> getNotite() {
        return notiteService.getNotite();
    }

    @Operation
    @DeleteMapping
    public void deleteNotita(@RequestParam String titlu){
        notiteService.deleteNotite(titlu);
    }

    @Operation
    @PutMapping
    public Notite updateNotita(@RequestParam String titlu, @RequestBody Notite notite) {
        return notiteService.updateNotita(titlu,notite);
    }
}
