package it.epicode.week5WeekProject.gestionePrenotazioni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import it.epicode.week5WeekProject.gestionePrenotazioni.DAO.PostazioneService;
import it.epicode.week5WeekProject.gestionePrenotazioni.DAO.UtenteService;
import it.epicode.week5WeekProject.gestionePrenotazioni.model.Postazione;
import it.epicode.week5WeekProject.gestionePrenotazioni.model.Utente;
import net.bytebuddy.implementation.bytecode.Throw;

@Controller
public class PrenotazioniController {
	@Autowired
	UtenteService us;
	PostazioneService ps;
	
	@GetMapping("prenotazioni/{lan}")
	@ResponseBody
	public String hello(@PathVariable String lan) {
		switch (lan) {
		case "en": {
			return "The content is in English";
		}
		case "it": {
			return "Il contenuto e` in italiano";
		}
		default:
			return "Inserisci un parametro corretto";
		}
	}
	
	@GetMapping("/users")
	@ResponseBody
	public List<Utente> getAll(){
		return us.getAll();
	}
	
	@GetMapping("/postazioni/{tipo}")
	@ResponseBody
	public List<Postazione> getAll(@PathVariable String tipo){
		switch (tipo) {
		case "openspace": {
			return ps.getByTipoOpen();
		}
		case "privato": {
			return ps.getByTipoPrivato();
		}
		case "riunioni": {
			return ps.getByTipoRiunioni();
		}
		
	}
		return null;
}
}
