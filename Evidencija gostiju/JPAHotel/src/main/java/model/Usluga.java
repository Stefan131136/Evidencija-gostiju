package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usluga database table.
 * 
 */
@Entity
@NamedQuery(name="Usluga.findAll", query="SELECT u FROM Usluga u")
public class Usluga implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oznakaUsluge;

	private String nazivUsluge;

	//bi-directional many-to-one association to Boravak
	@OneToMany(mappedBy="usluga")
	private List<Boravak> boravaks;

	public Usluga() {
	}

	public int getOznakaUsluge() {
		return this.oznakaUsluge;
	}

	public void setOznakaUsluge(int oznakaUsluge) {
		this.oznakaUsluge = oznakaUsluge;
	}

	public String getNazivUsluge() {
		return this.nazivUsluge;
	}

	public void setNazivUsluge(String nazivUsluge) {
		this.nazivUsluge = nazivUsluge;
	}

	public List<Boravak> getBoravaks() {
		return this.boravaks;
	}

	public void setBoravaks(List<Boravak> boravaks) {
		this.boravaks = boravaks;
	}

	public Boravak addBoravak(Boravak boravak) {
		getBoravaks().add(boravak);
		boravak.setUsluga(this);

		return boravak;
	}

	public Boravak removeBoravak(Boravak boravak) {
		getBoravaks().remove(boravak);
		boravak.setUsluga(null);

		return boravak;
	}

	@Override
	public String toString() {
		return "Usluga [oznakaUsluge=" + oznakaUsluge + ", nazivUsluge=" + nazivUsluge + "]";
	}
	
	

}