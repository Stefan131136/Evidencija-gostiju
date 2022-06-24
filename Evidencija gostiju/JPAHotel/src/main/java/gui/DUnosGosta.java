package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.GostCrud;
import model.Gost;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DUnosGosta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfIme;
	private JTextField tfPrezime;
	private JTextField tfAdresa;
	
	GostCrud gc = new GostCrud();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DUnosGosta dialog = new DUnosGosta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DUnosGosta() {
		setTitle("Unos Gosta");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		tfIme = new JTextField();
		tfIme.setBounds(132, 57, 214, 17);
		contentPanel.add(tfIme);
		tfIme.setColumns(10);
		
		tfPrezime = new JTextField();
		tfPrezime.setBounds(132, 97, 214, 17);
		contentPanel.add(tfPrezime);
		tfPrezime.setColumns(10);
		
		tfAdresa = new JTextField();
		tfAdresa.setBounds(132, 144, 214, 17);
		contentPanel.add(tfAdresa);
		tfAdresa.setColumns(10);
		
		JLabel lblIme = new JLabel("Ime");
		lblIme.setBounds(40, 60, 84, 11);
		contentPanel.add(lblIme);
		
		JLabel lblPrezime = new JLabel("Prezime");
		lblPrezime.setBounds(40, 100, 84, 11);
		contentPanel.add(lblPrezime);
		
		JLabel lblAdresa = new JLabel("Adresa");
		lblAdresa.setBounds(40, 147, 84, 11);
		contentPanel.add(lblAdresa);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnUnesi = new JButton("Unesi");
				btnUnesi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Gost gost = new Gost();
						gost.setIme(tfIme.getText());
						gost.setPrezime(tfPrezime.getText());
						gost.setAdresa(tfAdresa.getText());
						gc.insertGost(gost);
					}
				});
				btnUnesi.setActionCommand("OK");
				buttonPane.add(btnUnesi);
				getRootPane().setDefaultButton(btnUnesi);
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
