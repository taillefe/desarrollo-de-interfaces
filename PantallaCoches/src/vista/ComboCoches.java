package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;

import modelo.Coche;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.Toolkit;

public class ComboCoches {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboCoches window = new ComboCoches();
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
	public ComboCoches() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ComboCoches.class.getResource("/img2/avatarlaura.jpg")));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JComboBox cbCoches = new JComboBox();
		cbCoches.setEditable(true);
		cbCoches.setModel(new DefaultComboBoxModel<Coche>(TablaCoches.obtenerCoches().toArray(new Coche[0])));
		frame.getContentPane().add(cbCoches, BorderLayout.NORTH);
	}

}
