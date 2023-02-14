package it.epicode.week5WeekProject.gestionePrenotazioni;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import it.epicode.week5WeekProject.gestionePrenotazioni.DAO.EdificioService;
import it.epicode.week5WeekProject.gestionePrenotazioni.DAO.PostazioneService;
import it.epicode.week5WeekProject.gestionePrenotazioni.DAO.PrenotazioneService;
import it.epicode.week5WeekProject.gestionePrenotazioni.DAO.UtenteService;
import it.epicode.week5WeekProject.gestionePrenotazioni.config.GestionePrenotazioniConfiguration;
import it.epicode.week5WeekProject.gestionePrenotazioni.model.Edificio;
import it.epicode.week5WeekProject.gestionePrenotazioni.model.Postazione;
import it.epicode.week5WeekProject.gestionePrenotazioni.model.Prenotazione;
import it.epicode.week5WeekProject.gestionePrenotazioni.model.TipoPostazione;
import it.epicode.week5WeekProject.gestionePrenotazioni.model.Utente;

@Component
public class GestionePrenotazioniRunner implements CommandLineRunner {

	@Autowired
	EdificioService es;
	@Autowired
	PostazioneService pos;
	@Autowired
	PrenotazioneService prs;
	@Autowired
	UtenteService us;

	Logger logger = LoggerFactory.getLogger(GestionePrenotazioniRunner.class);

	ApplicationContext ctx = new AnnotationConfigApplicationContext(GestionePrenotazioniConfiguration.class);

	public static String space = System.lineSeparator();
	public static String divisor = "*********************************************************************"
;	@Override
	public void run(String... args) throws Exception {

//		CREAZIONE ENTITA -------------------------
//		EDIFICIO
		System.out.println(space);
		System.out.println(" ------------------------- * GESTIONE PRENOTAZIONI * -------------------------");
		System.out.println(space);
		System.out.println(" ------------------------- * CREAZIONI ENTITA * -------------------------");
		System.out.println(space);
		System.out.println("----- Creazione Edificio -----");
		Edificio e1 = (Edificio) ctx.getBean("edificioMP");
		es.put(e1);
		System.out.println(space);

//		POSTAZIONI
		System.out.println("----- Creazione Postazione -----");
		Postazione po1 = (Postazione) ctx.getBean("postazione1", e1);
		pos.put(po1);
		System.out.println(space);
		System.out.println("----- Creazione Postazione -----");
		Postazione po2 = (Postazione) ctx.getBean("postazione5", e1);
		pos.put(po2);
		System.out.println(space);
		System.out.println("----- Creazione Postazione -----");
		Postazione po3 = (Postazione) ctx.getBean("postazione10", e1);
		pos.put(po3);
		System.out.println(space);

//		UTENTI
		System.out.println("----- Creazione Utente -----");
		Utente u1 = new Utente().builder().username("Cosimo21").nome("Cosimo").email("Cosimo@email.it").build();
		us.put(u1);
		System.out.println(space);
		System.out.println("----- Creazione Utente -----");
		Utente u2 = new Utente().builder().username("Laura20").nome("Laura").email("laura@email.it").build();
		us.put(u2);
		System.out.println(space);

		System.out.println(space);
		System.out.println(" ------------------------- * PRENOTAZIONI * -------------------------");
		System.out.println(space);
		
//		PRENOTAZIONI
		System.out.println("----- Inserimento di una prenotazione -----");
		prenota(u1, po1, LocalDate.now());
		System.out.println(space);
		
		System.out.println("----- Tentativo di inserimento di una prenotazione con utente che ha gia prenotato nella data indicata -----");
		prenota(u1, po2, LocalDate.now());
		System.out.println(space);
		
		System.out.println("----- Inserimento di una prenotazione con utente che ha gia prenotato nella data diversa da quella indicata -----");
		prenota(u1, po2, LocalDate.now().plusDays(3));
		System.out.println(space);

		System.out.println("----- Tentativo di inserimento di una prenotazione con postazione gia piena -----");
		prenota(u2, po1, LocalDate.now());
		System.out.println(space);
		
		
		System.out.println(space);
		System.out.println(" ------------------------- * RICERCA * -------------------------");
		System.out.println(space);
		
		System.out.println("----- Ricerca Postazioni per Tipo: -----");
		pos.getByTipo(TipoPostazione.PRIVATO);
		System.out.println(space);
		
		System.out.println("----- Ricerca Postazioni per Citta: -----");
		pos.getByCitta("Roma");
		System.out.println(space);
		
		
		((AnnotationConfigApplicationContext) ctx).close();

	}

	public void prenota(Utente utente, Postazione p, LocalDate data) {
		if (prs.verificaPrenota(utente, p, data)) {
			Prenotazione pr = new Prenotazione().builder().data(data).postazione(p).utente(utente).build();
			prs.put(pr);
		} else {
			System.out.println("impossibile effettuare la prenotazione");
		}
	}
	
//	public void ricercaPostazione(TipoPostazione tipo, String citta) {
//		if () {
//			
//		} else {
//			System.out.println("impossibile effettuare la prenotazione");
//		}
//	}
	
}
