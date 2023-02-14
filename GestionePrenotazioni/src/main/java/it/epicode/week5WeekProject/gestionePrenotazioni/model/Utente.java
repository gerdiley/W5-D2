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
@Table(name="utenti")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Utente {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String username;
	private String nome;
	private String email;
	@Override
	public String toString() {
		return "Utente [id=" + id + ", username=" + username + ", nome=" + nome + ", email=" + email + "]";
	}
	
	
}
