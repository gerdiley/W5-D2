package it.epicode.week5WeekProject.gestionePrenotazioni.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import it.epicode.week5WeekProject.gestionePrenotazioni.model.Postazione;
import it.epicode.week5WeekProject.gestionePrenotazioni.model.TipoPostazione;

public interface PostazioneRepository extends JpaRepository<Postazione, Long>{

	List<Postazione> findByTipo(TipoPostazione tipo);
	
}
