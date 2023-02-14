package it.epicode.week5WeekProject.gestionePrenotazioni.DAO;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import it.epicode.week5WeekProject.gestionePrenotazioni.model.Prenotazione;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long>{
	
	long countByData(LocalDate data);

	List<Prenotazione> findByData(LocalDate data);
}
