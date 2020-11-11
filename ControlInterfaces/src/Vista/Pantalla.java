package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class Pantalla {

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	
	//variable que controla que se hayan dado cambios en los campos
			// de texto
	Boolean cambios = false;
	JTextArea txtDireccion;
	JComboBox cbTipo;
	String ficheroImagen ="";
	JButton btnImagen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla window = new Pantalla();
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
	public Pantalla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 495, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		btnImagen = new JButton("");
		btnImagen.setForeground(Color.WHITE);
		btnImagen.setIcon(new ImageIcon(Pantalla.class.getResource("/img/usuario_120.png")));
		
	//	btnImagen.setIcon(new ImageIcon("C:\\Users\\PC33\\Desktop\\ControlInterfaces\\nadal.jpg"));
		btnImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// mostrar dialogo de seleccionar imagen a mostrar
				seleccionarImagen();
				
			}
		});
	
		btnImagen.setBounds(10, 1, 132, 114);
		panel_1.add(btnImagen);
		
		JButton btnSeleccionar = new JButton("Seleccionar imagen");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//mostrar dialogo de seleccionar imagen a mostrar
				seleccionarImagen();
				
			}
		});
		btnSeleccionar.setBounds(155, 47, 157, 23);
		panel_1.add(btnSeleccionar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 127, 46, 14);
		panel_1.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(77, 127, 235, 20);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 152, 46, 14);
		panel_1.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(77, 149, 235, 20);
		panel_1.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(10, 177, 46, 14);
		panel_1.add(lblTipo);
		
		cbTipo = new JComboBox();
		cbTipo.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "SuperAdministrador", "Usuario"}));
		cbTipo.setName("");
		cbTipo.setBounds(77, 173, 235, 22);
		panel_1.add(cbTipo);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 211, 63, 14);
		panel_1.add(lblDireccion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 224, 459, 56);
		panel_1.add(scrollPane);
		
		txtDireccion = new JTextArea();
		scrollPane.setViewportView(txtDireccion);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//comprobar que los campos estén con datos
				if (comprobarDatos()) {  // todos los campos tienen datos
					// llamar al dialogo usuario guardado
					String datos = "Se han guardado los siguientes datos: \n"+
					"\nImagen : " +  ficheroImagen +
					"\nNombre : " +	txtNombre.getText() +
					"\nApellidos : " + txtApellidos.getText() +
					"\nTipo : " + cbTipo.getSelectedItem().toString() +
					"\nDireccion : " + txtDireccion.getText();
					
					JOptionPane.showMessageDialog(null, datos,"Usuario guardado",JOptionPane.INFORMATION_MESSAGE);
					
				}else
				{
					// llamar al dialogo de error en guardado
					JOptionPane.showMessageDialog(null, "Comprueba que has introducido los datos y la imagen"
							,"Error en guardado",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnGuardar.setBounds(294, 291, 90, 23);
		panel_1.add(btnGuardar);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			 //saldrá de la aplicación
		//	 int res = JOptionPane.showConfirmDialog(null, "Cerrar?");
		//	 if (res==JFileChooser.APPROVE_OPTION) {
					frame.dispose();
		//	 }
		
				
			}
		});
		btnCerrar.setBounds(394, 291, 75, 23);
		panel_1.add(btnCerrar);
	}
	
	// devuelve verdadero si todos los campos tienen datos
	public boolean comprobarDatos() {
	
		 // caso de que algun campo no tenga datos
		if( (ficheroImagen.equals(""))
			||	(txtNombre.getText().equals(""))
			|| (txtApellidos.getText().equals(""))
			|| (txtDireccion.getText().equals(""))
			|| (cbTipo.getSelectedItem().toString().equals("")))
		{
			return false;
		}else {
			// se ha escrito algo en todos los campos
			return true;
		}
	}
	
	
	//abre una ventana para escoger la imagen y hace que esa imagen aparezca en el botón
	public void seleccionarImagen() {
	 String fichero ;
	// abrir ventana en un filechooser
		JFileChooser ficheroEscogido = new JFileChooser("C:\\Users\\PC33\\Desktop\\ControlInterfaces");
		ficheroEscogido.setBounds(0, 0, 497, 333);
				
		int valorDevuelto = ficheroEscogido.showOpenDialog(null);
					
		// si presionamos el boton aceptar, el contenido del fichero elegido pasa a ser ficheroImagen
		if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
			fichero = (ficheroEscogido.getSelectedFile().getAbsolutePath());
			ficheroImagen = fichero;
		}else   // ficheroImagen debe tener el valor que tenía antes de entrar en esta pantalla
		{
			
		}
		if (ficheroImagen.equals("")) {  // 
			btnImagen.setIcon(new ImageIcon(Pantalla.class.getResource("/img/usuario_120.png")));
		}else {
			btnImagen.setIcon(new ImageIcon(ficheroImagen));
		}	
	}
}
