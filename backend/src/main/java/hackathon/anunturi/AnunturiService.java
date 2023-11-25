package edu.tucn.scd.hackathon.anunturi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnunturiService {
    @Autowired
    private AnunturiRepository anunturiRepository;

    @Transactional(rollbackFor = Exception.class)
    public Anunturi create(Anunturi anunturi) {
        return anunturiRepository.save(anunturi);
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public List<Anunturi> getAnunturi(){
        return anunturiRepository.getAnunturi();
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteAnunt(String titlu) {
        Anunturi anunt = anunturiRepository.findAnunt(titlu);
        anunturiRepository.delete(anunt);
    }

    @Transactional(rollbackFor = Exception.class)
    public Anunturi updateAnunt(String titlu, Anunturi anunturi){
        Anunturi anunt = anunturiRepository.findAnunt(titlu);

        anunt.setDescriere(anunturi.getDescriere());
        anunt.setTitlu(anunturi.getTitlu());
        anunt.setSubiect(anunturi.getSubiect());
        anunt.setProfesor(anunturi.getProfesor());

        return anunturiRepository.save(anunt);
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public List<Anunturi> getAnunturiFromProf(String profesor){
        return anunturiRepository.getAnunturiFromProfesor(profesor);
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public List<Anunturi> getAnunturiWithSubject(String profesor){
        return anunturiRepository.getAnunturiWithSubject(profesor);
    }
}
