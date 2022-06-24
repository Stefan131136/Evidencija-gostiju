package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the gost database table.
 * 
 */
@Entity
@NamedQuery(name="Gost.findAll", query="SELECT g FROM Gost g")
public class Gost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idg;

	private String adresa;

	private String ime;

	private String prezime;

	//bi-directional many-to-one association to Boravak
	@OneToMany(mappedBy="gost", cascade={CascadeType.ALL})
	private List<Boravak> boravaks;

	public Gost() {
	}

	public int getIdg() {
		return this.idg;
	}

	public void setIdg(int idg) {
		this.idg = idg;
	}

	public String getAdresa() {
		return this.adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Boravak> getBoravaks() {
		return this.boravaks;
	}

	public void setBoravaks(List<Boravak> boravaks) {
		this.boravaks = boravaks;
	}

	public Boravak addBoravak(Boravak boravak) {
		getBoravaks().add(boravak);
		boravak.setGost(this);

		return boravak;
	}

	public Boravak removeBoravak(Boravak boravak) {
		getBoravaks().remove(boravak);
		boravak.setGost(null);

		return boravak;
	}

	@Override
	public String toString() {
		return "Gost: Ime=" + ime + ", prezime=" + prezime;
	}
	
	

}