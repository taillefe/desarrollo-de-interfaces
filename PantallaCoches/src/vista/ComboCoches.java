package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;

import modelo.Coche;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class ComboCoches {

	private JFrame ventana3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComboCoches window = new ComboCoches();
					window.ventana3.setVisible(true);
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
		ventana3 = new JFrame();
		ventana3.setIconImage(Toolkit.getDefaultToolkit().getImage(ComboCoches.class.getResource("/img2/avatarlaura.jpg")));
		ventana3.setBounds(100, 100, 450, 300);
		ventana3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JComboBox cbCoches = new JComboBox();
		
		DialogoNuevoCoche dCoches = new DialogoNuevoCoche();
		cbCoches.setEditable(true);
		//cbCoches.setModel(new DefaultComboBoxModel<Coche>(dCoches.obtenerCoches().toArray(new Coche[0])));
		ventana3.getContentPane().add(cbCoches, BorderLayout.NORTH);
		
		JList lstCoches = new JList();
		lstCoches.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//lstCoches.setModel(new CocheListModel(dCoches.obtenerCoches()));
		lstCoches.setCellRenderer(new RenderizadorListaCoches());
		ventana3.getContentPane().add(lstCoches, BorderLayout.CENTER);
	}

}
