package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.GostCrud;
import model.Gost;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DBrisanjeGostiju extends JDialog {

	private final JPanel contentPanel = new JPanel();

	JComboBox<Gost> cbGosti;
	GostCrud gc = new GostCrud();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DBrisanjeGostiju dialog = new DBrisanjeGostiju();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DBrisanjeGostiju() {
		setTitle("Izbrisite Gosta");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblIzaberi = new JLabel("Izaberite Gosta");
			lblIzaberi.setBounds(58, 52, 114, 11);
			contentPanel.add(lblIzaberi);
		}
		{
			cbGosti = new JComboBox<>();
			cbGosti.setBounds(58, 106, 278, 19);
			List<Gost> gosti = gc.listaGostiju();
			for (Gost gost : gosti) {
				cbGosti.addItem(gost);
			}
			contentPanel.add(cbGosti);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnObrisi = new JButton("Obrisi");
				btnObrisi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Gost gost = (Gost) cbGosti.getSelectedItem();
						gc.deleteGost(gost);
					}
				});
				btnObrisi.setActionCommand("OK");
				buttonPane.add(btnObrisi);
				getRootPane().setDefaultButton(btnObrisi);
			}
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
