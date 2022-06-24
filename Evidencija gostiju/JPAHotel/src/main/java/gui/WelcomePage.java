package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomePage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage window = new WelcomePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 485, 307);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnInsertGost = new JButton("Unesi novog Gosta");
		btnInsertGost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DUnosGosta unosGosta = new DUnosGosta();
				unosGosta.setVisible(true);
			}
		});
		btnInsertGost.setBounds(163, 38, 143, 19);
		frame.getContentPane().add(btnInsertGost);
		
		JButton btnInsertBoravak = new JButton("Unesite Boravak");
		btnInsertBoravak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DUnosBoravka unosBoravka = new DUnosBoravka();
				unosBoravka.setVisible(true);
			}
		});
		btnInsertBoravak.setBounds(163, 95, 143, 19);
		frame.getContentPane().add(btnInsertBoravak);
		
		JButton btnIzbrisiGosta = new JButton("Izbrisi Gosta");
		btnIzbrisiGosta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DBrisanjeGostiju brisanjeGostiju = new DBrisanjeGostiju();
				brisanjeGostiju.setVisible(true);
			}
		});
		btnIzbrisiGosta.setBounds(163, 152, 143, 19);
		frame.getContentPane().add(btnIzbrisiGosta);
		
		JButton btnBoravciGosta = new JButton("Prikazi Boravke Gosta");
		btnBoravciGosta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DPrikazBoravka prikazBoravka = new DPrikazBoravka();
				prikazBoravka.setVisible(true);
			}
		});
		btnBoravciGosta.setBounds(163, 209, 143, 19);
		frame.getContentPane().add(btnBoravciGosta);
	}
}
