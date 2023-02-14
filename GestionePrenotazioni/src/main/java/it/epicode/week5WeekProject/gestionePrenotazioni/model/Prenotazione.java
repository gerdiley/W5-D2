package it.epicode.week5WeekProject.gestionePrenotazioni.model;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="prenotazioni")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Prenotazione {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
	
	private LocalDate data;
	@ManyToOne
	private Postazione postazione;
	@OneToOne
	private Utente utente;
	
	
	@Override
	public String toString() {
		return "Prenotazione [id=" + id + ", data=" + data + ", postazione=" + postazione.toString() + ", utente=" + utente.toString() + "]";
	}
}
