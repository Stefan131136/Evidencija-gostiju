package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.BoravakCrud;
import crud.GostCrud;
import crud.UslugaCrud;
import crud.VrstaSobeCrud;
import model.Gost;
import model.Usluga;
import model.Vrstasobe;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DUnosBoravka extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfDatum;
	private JTextField tfTrajanje;
	
	JComboBox<Gost> cbGosti;
	JComboBox<Vrstasobe> cbVrsteSoba;
	JComboBox<Usluga> cbUsluge;
	
	GostCrud gc = new GostCrud();
	UslugaCrud uc = new UslugaCrud();
	VrstaSobeCrud vsc = new VrstaSobeCrud();
	BoravakCrud bc = new BoravakCrud();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DUnosBoravka dialog = new DUnosBoravka();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DUnosBoravka() {
		setTitle("Unesite Boravak");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblGost = new JLabel("Gost");
			lblGost.setBounds(40, 29, 87, 11);
			contentPanel.add(lblGost);
		}
		{
			JLabel lblVrstaSobe = new JLabel("Vrsta sobe");
			lblVrstaSobe.setBounds(40, 69, 87, 11);
			contentPanel.add(lblVrstaSobe);
		}
		{
			JLabel lblUsluga = new JLabel("Usluga");
			lblUsluga.setBounds(40, 109, 87, 11);
			contentPanel.add(lblUsluga);
		}
		{
			JLabel lblDatum = new JLabel("Datum");
			lblDatum.setBounds(40, 149, 87, 11);
			contentPanel.add(lblDatum);
		}
		{
			JLabel lblTrajanje = new JLabel("Trajanje");
			lblTrajanje.setBounds(40, 189, 87, 11);
			contentPanel.add(lblTrajanje);
		}
		
		cbGosti = new JComboBox<>();
		cbGosti.setBounds(170, 23, 191, 19);
		List<Gost> gosti = gc.listaGostiju();
		for (Gost gost : gosti) {
			cbGosti.addItem(gost);
		}
		contentPanel.add(cbGosti);
		
		cbVrsteSoba = new JComboBox<>();
		cbVrsteSoba.setBounds(170, 65, 191, 19);
		List<Vrstasobe> vrstesoba = vsc.listaVrstaSoba();
		for (Vrstasobe vrstasobe : vrstesoba) {
			cbVrsteSoba.addItem(vrstasobe);
		}
		contentPanel.add(cbVrsteSoba);
		
		cbUsluge = new JComboBox<>();
		cbUsluge.setBounds(170, 107, 191, 19);
		List<Usluga> usluge = uc.listaUsluga();
		for (Usluga usluga : usluge) {
			cbUsluge.addItem(usluga);
		}
		contentPanel.add(cbUsluge);
		
		tfDatum = new JTextField();
		tfDatum.setBounds(170, 149, 191, 17);
		contentPanel.add(tfDatum);
		tfDatum.setColumns(10);
		
		tfTrajanje = new JTextField();
		tfTrajanje.setBounds(170, 189, 191, 17);
		contentPanel.add(tfTrajanje);
		tfTrajanje.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnUnesi = new JButton("Unesi");
				btnUnesi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Gost gost = (Gost) cbGosti.getSelectedItem();
						Usluga usluga = (Usluga) cbUsluge.getSelectedItem();
						Vrstasobe vrstasobe = (Vrstasobe) cbVrsteSoba.getSelectedItem();
						String datum = tfDatum.getText();
						String trajanje = tfTrajanje.getText();
						bc.insertBoravak(gost, vrstasobe, usluga, datum, trajanje);
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
