package it.epicode.week5WeekProject.gestionePrenotazioni.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="postazioni")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Postazione {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String descrizione;
	@Enumerated(EnumType.STRING)
	private TipoPostazione tipo;
	private int maxPartecipanti;
	@Builder.Default
	private boolean disponibilita = true;
	
	@ManyToOne
	private Edificio edificio;

	@Override
	public String toString() {
		return "Postazione [id=" + id + ", descrizione=" + descrizione + ", tipo=" + tipo + ", maxPartecipanti="
				+ maxPartecipanti + ", disponibilita=" + disponibilita + ", edificio=" + edificio.toString() + "]";
	}
	
	
}
