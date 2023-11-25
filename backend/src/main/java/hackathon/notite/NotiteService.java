package edu.tucn.scd.hackathon.notite;

import edu.tucn.scd.hackathon.anunturi.Anunturi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NotiteService {
    @Autowired
    private NotiteRepository notiteRepository;

    @Transactional(rollbackFor = Exception.class)
    public Notite create(Notite notite) {
        return notiteRepository.save(notite);
    }

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public List<Notite> getNotite() {
        List<Notite> notite = notiteRepository.getNotite();

        return notite;
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteNotite(String titlu) {
        Notite notite = notiteRepository.findNotita(titlu);
        notiteRepository.delete(notite);
    }

    @Transactional(rollbackFor = Exception.class)
    public Notite updateNotita(String titlu, Notite notite){
        Notite notita = notiteRepository.findNotita(titlu);

        notita.setTitlu(notite.getTitlu());
        notita.setText(notite.getText());

        return notiteRepository.save(notita);
    }
}
