package it.epicode.week5WeekProject.gestionePrenotazioni.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.epicode.week5WeekProject.gestionePrenotazioni.model.Utente;

@Service
public class UtenteService {

	@Autowired
	private UtenteRepository utenteRepo;
	
//	METHOD 
	public void put(Utente u) {
		try {
		utenteRepo.save(u);
		System.out.println(u.toString());
		System.out.println("Inserimento Utente effettuato con Successo!");
		} catch (Exception e) {
			System.out.println("Errore di Salvataggio!");
		}
		
	}
	
	public List<Utente> getAll(){
		List<Utente> users;
		
		users = utenteRepo.findAll();
		System.out.println(users);
		return users;
	}
	
}
