package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.BoravakCrud;
import crud.GostCrud;
import model.Boravak;
import model.Gost;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class DPrikazBoravka extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	JComboBox<Gost> cbGosti;
	GostCrud gc = new GostCrud();
	BoravakCrud bc = new BoravakCrud();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DPrikazBoravka dialog = new DPrikazBoravka();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DPrikazBoravka() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblGost = new JLabel("Izaberite Gosta");
				panel.add(lblGost);
			}
			{
				cbGosti = new JComboBox<>();
				List<Gost> gosti = gc.listaGostiju();
				for (Gost gost : gosti) {
					cbGosti.addItem(gost);
				}
				panel.add(cbGosti);
			}
			{
				JButton btnPrikazi = new JButton("Prikazi");
				btnPrikazi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Gost gost = (Gost) cbGosti.getSelectedItem();
						List<Boravak> boravci = bc.listaBoravka();
						List<Boravak> gb = new ArrayList<>();
						for (Boravak boravak : boravci) {
							if (boravak.getGost().getIdg() == gost.getIdg()) {
								gb.add(boravak);
							}
						}
						
						TableModelBoravak tableModelBoravak = new TableModelBoravak(gb);
						table.setModel(tableModelBoravak);
					}
				});
				panel.add(btnPrikazi);
			}
		}
		{
			table = new JTable();
			contentPanel.add(table, BorderLayout.CENTER);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnZatvori = new JButton("Zatvori");
				btnZatvori.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				btnZatvori.setActionCommand("Cancel");
				buttonPane.add(btnZatvori);
			}
		}
	}

}
