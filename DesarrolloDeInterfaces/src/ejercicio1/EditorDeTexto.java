package ejercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditorDeTexto {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorDeTexto window = new EditorDeTexto();
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
	public EditorDeTexto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			//evento que se ejecuta cuando cerramos la ventana
			public void windowClosing(WindowEvent e) {
				int res = JOptionPane.showConfirmDialog(null, "Cerrar?");
				if (res==JFileChooser.APPROVE_OPTION) {
					frame.dispose();
				}
			}
		});
		frame.setBounds(100, 100, 595, 485);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 811, 22);
		frame.getContentPane().add(menuBar);
		
		JMenu mnFichero = new JMenu("Fichero");
		menuBar.add(mnFichero);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mnFichero.add(mntmNuevo);
		
		// limpiar JTextArea
		//crear un fichero nuevo en el que se graba lo que aparece en JTextArea
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//  ventana abierta en un filechooser
				JFileChooser ficheroEscogido = new JFileChooser();
				ficheroEscogido.setBounds(0, 0, 497, 333);
				frame.getContentPane().add(ficheroEscogido);
				
				int valorDevuelto = ficheroEscogido.showOpenDialog(null);
				
				if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
					fichero = (ficheroEscogido.getSelectedFile().getAbsolutePath());
					
				}
				
				
				//Abrir la ventana JFileChooser y escoger el archivo
				 VentanaEscogerFichero v =new VentanaEscogerFichero();
				 frame.dispose();
			}
		});
		mnFichero.add(mntmAbrir);
		
		
		 
		
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mnFichero.add(mntmGuardar);
		
		//Guardar el contenido de JTextArea en el fichero abierto
		//cared.selectText para seleccionar el texto
		
		JMenuItem mntmGuardarComo = new JMenuItem("GuardarComo");
		mnFichero.add(mntmGuardarComo);
		
		//Abrir una ventana JFileChooser donde escribir un nombre de archivo nuevo
		
		JMenu mnEditor = new JMenu("Editor");
		menuBar.add(mnEditor);
		
		JMenu mnSeleccionarFuente = new JMenu("SeleccionarFuente");
		mnEditor.add(mnSeleccionarFuente);
		
		//seleccionar una de las tres fuentes de las opciones
		
		JMenuItem mntmCalibri = new JMenuItem("Calibri");
		mntmCalibri.setFont(new Font("Calibri", Font.PLAIN, 12));
		mnSeleccionarFuente.add(mntmCalibri);
		
		//cambiar la fuente por la Calibri
		
		JMenuItem mntmArial = new JMenuItem("Arial");
		mntmArial.setFont(new Font("Arial", Font.PLAIN, 12));
		mnSeleccionarFuente.add(mntmArial);
		
		//cambiar la propiedad fuente por la fuente Arial
		
		JMenuItem mntmCentury = new JMenuItem("Century");
		mntmCentury.setFont(new Font("Century", Font.PLAIN, 12));
		mnSeleccionarFuente.add(mntmCentury);
		
		//cambiar la propiedad fuente por la fuente Century
		
		
		
		
		JMenuItem mntmCortar = new JMenuItem("Cortar");
		mnEditor.add(mntmCortar);
		
		// con el texto seleccionado -- borrarlo de JTextArea y guardarlo en memoria
		
		JMenuItem mntmCopiar = new JMenuItem("Copiar");
		mnEditor.add(mntmCopiar);
		
		//  con el texto seleccionado --  guardarlo en memoria
		
		JMenuItem mntmPegar = new JMenuItem("Pegar");
		mnEditor.add(mntmPegar);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(10, 33, 740, 34);
		frame.getContentPane().add(toolBar);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		toolBar.add(panel);
		
		JMenuItem mntmTbGuardar = new JMenuItem("Guardar");
		mntmTbGuardar.setBounds(100, 0, 79, 32);
		panel.add(mntmTbGuardar);
		
		//Guardar el contenido de JTextArea en el fichero abierto
		
		JMenuItem mntmTbVCortar = new JMenuItem("Cortar");
		mntmTbVCortar.setBounds(222, 0, 79, 32);
		panel.add(mntmTbVCortar);
		
		// con el texto seleccionado -- borrarlo de JTextArea y guardarlo en memoria
		
		JMenuItem mntmTbCopiar = new JMenuItem("Copiar");
		mntmTbCopiar.setBounds(322, 0, 79, 32);
		panel.add(mntmTbCopiar);
		
		//  con el texto seleccionado --  guardarlo en memoria
		
		JMenuItem mntmTbNuevo = new JMenuItem("Nuevo");
		mntmTbNuevo.setHorizontalAlignment(SwingConstants.LEFT);
		mntmTbNuevo.setBounds(10, 0, 86, 32);
		panel.add(mntmTbNuevo);
		
		// limpiar JTextArea
				//crear un fichero nuevo en el que se graba lo que aparece en JTextArea
		
		JMenuItem mntmTbPegar = new JMenuItem("Pegar");
		mntmTbPegar.setBounds(434, 0, 79, 32);
		panel.add(mntmTbPegar);
		
		// copiar el texto guardado en memoria en la posicion del cursor
		
	}
}
