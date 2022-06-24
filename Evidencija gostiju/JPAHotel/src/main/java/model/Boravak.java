package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the boravak database table.
 * 
 */
@Entity
@NamedQuery(name="Boravak.findAll", query="SELECT b FROM Boravak b")
public class Boravak implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idBoravka;

	private String datum;

	private String trajanje;

	//bi-directional many-to-one association to Gost
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="idg")
	private Gost gost;

	//bi-directional many-to-one association to Usluga
	@ManyToOne
	@JoinColumn(name="oznakaUsluge")
	private Usluga usluga;

	//bi-directional many-to-one association to Vrstasobe
	@ManyToOne
	@JoinColumn(name="oznakaSobe")
	private Vrstasobe vrstasobe;

	public Boravak() {
	}

	public int getIdBoravka() {
		return this.idBoravka;
	}

	public void setIdBoravka(int idBoravka) {
		this.idBoravka = idBoravka;
	}

	public String getDatum() {
		return this.datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getTrajanje() {
		return this.trajanje;
	}

	public void setTrajanje(String trajanje) {
		this.trajanje = trajanje;
	}

	public Gost getGost() {
		return this.gost;
	}

	public void setGost(Gost gost) {
		this.gost = gost;
	}

	public Usluga getUsluga() {
		return this.usluga;
	}

	public void setUsluga(Usluga usluga) {
		this.usluga = usluga;
	}

	public Vrstasobe getVrstasobe() {
		return this.vrstasobe;
	}

	public void setVrstasobe(Vrstasobe vrstasobe) {
		this.vrstasobe = vrstasobe;
	}

	@Override
	public String toString() {
		return "Boravak [idBoravka=" + idBoravka + ", datum=" + datum + ", trajanje=" + trajanje + "]";
	}
	
	

}