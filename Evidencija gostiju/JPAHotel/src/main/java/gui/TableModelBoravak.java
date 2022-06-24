package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Boravak;

public class TableModelBoravak extends AbstractTableModel {
	
	List<Boravak> boravci;

	
	public TableModelBoravak(List<Boravak> boravci) {
		super();
		this.boravci = boravci;
	}

	@Override
	public int getRowCount() {
		return boravci.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Boravak b = boravci.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return b.getDatum();
		case 1:
			return b.getTrajanje();
		case 2:
			return b.getVrstasobe().getNazivSobe();
		case 3:
			return b.getUsluga().getNazivUsluge();
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Datum";
		case 1:
			return "Trajanje";
		case 2:
			return "Vrsta sobe";
		case 3:
			return "Usluga";
		}
		return null;
	}

}
