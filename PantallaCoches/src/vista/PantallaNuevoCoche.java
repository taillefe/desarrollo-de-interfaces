package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import modelo.Coche;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaNuevoCoche {

	private JFrame ventana2;
	private JTextField txtModelo;
	private JTextField txtColor;
	private JTextField txtMatricula;
	private JTextField txtAno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaNuevoCoche window = new PantallaNuevoCoche();
					window.ventana2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaNuevoCoche() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventana2 = new JFrame();
		ventana2.setBounds(100, 100, 450, 300);
		ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		ventana2.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(83, 22, 46, 14);
		panel.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(83, 53, 46, 14);
		panel.add(lblModelo);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(83, 84, 46, 14);
		panel.add(lblColor);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(161, 50, 86, 20);
		panel.add(txtModelo);
		txtModelo.setColumns(10);
		
		txtColor = new JTextField();
		txtColor.setBounds(161, 81, 86, 20);
		panel.add(txtColor);
		txtColor.setColumns(10);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(161, 115, 86, 20);
		panel.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		txtAno = new JTextField();
		txtAno.setBounds(161, 146, 86, 20);
		panel.add(txtAno);
		txtAno.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(83, 118, 46, 14);
		panel.add(lblMatricula);
		
		JLabel lblano = new JLabel("A\u00F1o");
		lblano.setBounds(83, 149, 46, 14);
		panel.add(lblano);
		
		JComboBox cbMarca = new JComboBox();
		cbMarca.setBounds(161, 19, 86, 20);
		
		TablaCoches tbCoches = new TablaCoches();
		cbMarca.setModel(new DefaultComboBoxModel<Coche>(tbCoches.obtenerCoches().toArray(new Coche[0])));
		
		panel.add(cbMarca);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// aqui se guardan los datos de pantalla en la lista de coches
				 Coche car = new Coche(cbMarca.toString(),txtModelo.getText(),txtColor.getText(),txtMatricula.getText(),(int)txtAno.getCared));
				 tbCoches.lista.add( car);
				
			}
		});
		btnGuardar.setBounds(67, 205, 89, 23);
		panel.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(202, 205, 89, 23);
		panel.add(btnCancelar);
	}
}
