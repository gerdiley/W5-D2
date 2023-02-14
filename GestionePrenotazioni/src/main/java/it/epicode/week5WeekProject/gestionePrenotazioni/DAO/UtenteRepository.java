package it.epicode.week5WeekProject.gestionePrenotazioni.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import it.epicode.week5WeekProject.gestionePrenotazioni.model.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Long>{

}
