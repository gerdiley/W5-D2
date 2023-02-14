package it.epicode.week5WeekProject.gestionePrenotazioni.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="edifici")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Edificio {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String nome;
	private String indirizzo;
	private String citta;
	@Override
	public String toString() {
		return "Edificio [id=" + id + ", nome=" + nome + ", indirizzo=" + indirizzo + ", citta=" + citta + "]";
	}
	
}
