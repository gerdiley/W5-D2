package it.epicode.week5WeekProject.gestionePrenotazioni.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.epicode.week5WeekProject.gestionePrenotazioni.model.Postazione;
import it.epicode.week5WeekProject.gestionePrenotazioni.model.TipoPostazione;

@Service
public class PostazioneService {

	@Autowired
	private PostazioneRepository postazioneRepo;
	
//	METHOD 
	public void put(Postazione p) {
		try {
			postazioneRepo.save(p);
			System.out.println(p.toString());
			System.out.println("Inserimento Postazione effettuato con Successo!");
			} catch (Exception e) {
				System.out.println("Errore di Salvataggio!");
			}
	}
	
	public void getByTipo(TipoPostazione tipo) {
		postazioneRepo.findByTipo(tipo).forEach(e->System.out.println(e.toString()));;
		
	}
	public void getByCitta(String Citta) {
		List <Postazione> result = postazioneRepo.findAll().stream().filter(e->e.getEdificio().getCitta().contains(Citta)).toList();
		result.forEach(e->System.out.println(e.toString()));
	}
	
	
	public List<Postazione> getByTipoOpen() {
		List<Postazione> postazioni;
		postazioni = postazioneRepo.findAll();
		return postazioni.stream().filter(p->p.getTipo().equals(TipoPostazione.OPENSPACE)).toList();
		
	}
	public List<Postazione> getByTipoPrivato() {
		List<Postazione> postazioni;
		postazioni = postazioneRepo.findAll();
		return postazioni.stream().filter(p->p.getTipo().equals(TipoPostazione.PRIVATO)).toList();
		
	}
	public List<Postazione> getByTipoRiunioni() {
		List<Postazione> postazioni;
		postazioni = postazioneRepo.findAll();
		return postazioni.stream().filter(p->p.getTipo().equals(TipoPostazione.SALARIUNIONI)).toList();
		
	}
}
