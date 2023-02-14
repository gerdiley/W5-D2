package it.epicode.week5WeekProject.gestionePrenotazioni.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.epicode.week5WeekProject.gestionePrenotazioni.model.Edificio;

@Service
public class EdificioService {

	@Autowired
	private EdificioRepository edificioRepo;
	
//	METHOD 
	public void put(Edificio p) {
		try {
			edificioRepo.save(p);
			System.out.println(p.toString());
			System.out.println("Inserimento Edificio effettuato con Successo!");
			} catch (Exception e) {
				System.out.println("Errore di Salvataggio!");
			}
	}
}
