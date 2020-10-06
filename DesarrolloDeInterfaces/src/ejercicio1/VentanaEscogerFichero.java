package ejercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JFileChooser;

public class VentanaEscogerFichero {

	String fichero ;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEscogerFichero window = new VentanaEscogerFichero();
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
	public VentanaEscogerFichero() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 513, 372);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JFileChooser ficheroEscogido = new JFileChooser();
		ficheroEscogido.setBounds(0, 0, 497, 333);
		frame.getContentPane().add(ficheroEscogido);
		
		int valorDevuelto = ficheroEscogido.showOpenDialog(null);
		
		if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
			fichero = (ficheroEscogido.getSelectedFile().getAbsolutePath());
			
		}
		
		
	}

	
	
}
