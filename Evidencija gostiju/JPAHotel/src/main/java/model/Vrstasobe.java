package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the vrstasobe database table.
 * 
 */
@Entity
@NamedQuery(name="Vrstasobe.findAll", query="SELECT v FROM Vrstasobe v")
public class Vrstasobe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oznakaSobe;

	private String nazivSobe;

	//bi-directional many-to-one association to Boravak
	@OneToMany(mappedBy="vrstasobe")
	private List<Boravak> boravaks;

	public Vrstasobe() {
	}

	public int getOznakaSobe() {
		return this.oznakaSobe;
	}

	public void setOznakaSobe(int oznakaSobe) {
		this.oznakaSobe = oznakaSobe;
	}

	public String getNazivSobe() {
		return this.nazivSobe;
	}

	public void setNazivSobe(String nazivSobe) {
		this.nazivSobe = nazivSobe;
	}

	public List<Boravak> getBoravaks() {
		return this.boravaks;
	}

	public void setBoravaks(List<Boravak> boravaks) {
		this.boravaks = boravaks;
	}

	public Boravak addBoravak(Boravak boravak) {
		getBoravaks().add(boravak);
		boravak.setVrstasobe(this);

		return boravak;
	}

	public Boravak removeBoravak(Boravak boravak) {
		getBoravaks().remove(boravak);
		boravak.setVrstasobe(null);

		return boravak;
	}

	@Override
	public String toString() {
		return "Vrstasobe [oznakaSobe=" + oznakaSobe + ", nazivSobe=" + nazivSobe + "]";
	}

	
}