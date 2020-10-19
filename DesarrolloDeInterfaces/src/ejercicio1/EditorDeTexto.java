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
import java.awt.Color;

public class EditorDeTexto {


	//definicion de variables
		String ficheroAbrir;
		private JTextArea areaDeTexto;
	
		
		
	
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
		frame.setBounds(100, 100, 757, 547);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 731, 22);
		frame.getContentPane().add(menuBar);
		
		JMenu mnFichero = new JMenu("Fichero");
		menuBar.add(mnFichero);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//aqui se abre un JTextArea nuevo 
				
				
			}
		});
		mnFichero.add(mntmNuevo);
		
		// limpiar JTextArea
		//crear un fichero nuevo en el que se graba lo que aparece en JTextArea
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//  ventana abierta en un filechooser
			
				
				JFileChooser ficheroEscogido = new JFileChooser("C:\\Users\\PC33\\Desktop\\Prueba");
				ficheroEscogido.setBounds(0, 0, 497, 333);
	
				int valorDevuelto = ficheroEscogido.showOpenDialog(null);
				
				if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
					ficheroAbrir = (ficheroEscogido.getSelectedFile().getAbsolutePath());
					System.out.println("fichero escogido : " + ficheroAbrir);
					
					areaDeTexto.setText(UtilidadesEdicion.obtenerTexto(ficheroAbrir));
					//leo el texto que hay en el fichero y lo escribo en la ventana en text area
			
				}

			}
		});
		mnFichero.add(mntmAbrir);
	
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Guardar el contenido de JTextArea en el fichero abierto ficheroAbrir
				String texto = areaDeTexto.getText();
				
				// texto lo guardamos en el fichero abierto
				
				UtilidadesEdicion.guardarFichero(ficheroAbrir, texto);
				
				
			}
		});
		mnFichero.add(mntmGuardar);
		
		
		
	
		
		JMenuItem mntmGuardarComo = new JMenuItem("GuardarComo");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Guardar el contenido de JTextArea en un fichero que elegimos con JFileChooser
				
				
				
			}
		});
		mnFichero.add(mntmGuardarComo);
		
		//Abrir una ventana JFileChooser donde escribir un nombre de archivo nuevo
		
		JMenu mnEditor = new JMenu("Editor");
		menuBar.add(mnEditor);
		
		JMenu mnSeleccionarFuente = new JMenu("SeleccionarFuente");
		mnEditor.add(mnSeleccionarFuente);
		
		//seleccionar una de las tres fuentes de las opciones
		
		JMenuItem mntmCalibri = new JMenuItem("Calibri");
		mntmCalibri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//elegimos funete Calibri
				
			}
		});
		mntmCalibri.setFont(new Font("Calibri", Font.PLAIN, 12));
		mnSeleccionarFuente.add(mntmCalibri);
		
		//cambiar la fuente por la Calibri
		
		JMenuItem mntmArial = new JMenuItem("Arial");
		mntmArial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// elegimos fuente Arial
				
			}
		});
		mntmArial.setFont(new Font("Arial", Font.PLAIN, 12));
		mnSeleccionarFuente.add(mntmArial);
		
		//cambiar la propiedad fuente por la fuente Arial
		
		JMenuItem mntmCentury = new JMenuItem("Century");
		mntmCentury.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//elegimos fuente Century
				
			}
		});
		mntmCentury.setFont(new Font("Century", Font.PLAIN, 12));
		mnSeleccionarFuente.add(mntmCentury);
		
		//cambiar la propiedad fuente por la fuente Century
		
		
		
		
		JMenuItem mntmCortar = new JMenuItem("Cortar");
		mntmCortar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//primero seleccionamos texto para, despues de pulsar este boton, cortarlo, pero dejarlo en memoria
				//cared.selectText para seleccionar el texto
			}
		});
		mnEditor.add(mntmCortar);
		
		
		
		JMenuItem mntmCopiar = new JMenuItem("Copiar");
		mntmCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//guardar el texto seleccionardo en memoria
				
			}
		});
		mnEditor.add(mntmCopiar);
		
		
		
		JMenuItem mntmPegar = new JMenuItem("Pegar");
		mntmPegar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// copiar en JTextArea el texto guardado en memoria
				
			}
		});
		mnEditor.add(mntmPegar);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(10, 33, 740, 34);
		frame.getContentPane().add(toolBar);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setLayout(null);
		toolBar.add(panel);
		
		JMenuItem mntmTbGuardar = new JMenuItem("");
		mntmTbGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// hacer lo mismo que con la opción guardar
				
			}
		});
		mntmTbGuardar.setIcon(new ImageIcon("C:\\Users\\PC33\\Desktop\\Prueba\\iconos\\guardar_18.png"));
		mntmTbGuardar.setBounds(100, 0, 41, 32);
		panel.add(mntmTbGuardar);
		
	
		
		JMenuItem mntmTbVCortar = new JMenuItem("");
		mntmTbVCortar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//hacer lo mismo que con la opción cortar
				
				
			}
		});
		mntmTbVCortar.setIcon(new ImageIcon("C:\\Users\\PC33\\Desktop\\Prueba\\iconos\\cortar_18.jpg"));
		mntmTbVCortar.setBounds(222, 0, 41, 32);
		panel.add(mntmTbVCortar);
		
	
		
		JMenuItem mntmTbCopiar = new JMenuItem("");
		mntmTbCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// hacer lo mismo que con la opción copiar
				
			}
		});
		mntmTbCopiar.setIcon(new ImageIcon("C:\\Users\\PC33\\Desktop\\Prueba\\iconos\\copiar_18.jpg"));
		mntmTbCopiar.setBounds(322, 0, 41, 32);
		panel.add(mntmTbCopiar);
		
		
		
		JMenuItem mntmTbNuevo = new JMenuItem("");
		mntmTbNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//hacer lo mismo que con la opción nuevo
				
				
				
			}
		});
		mntmTbNuevo.setIcon(new ImageIcon("C:\\Users\\PC33\\Desktop\\Prueba\\iconos\\nuevo_18.png"));
		mntmTbNuevo.setHorizontalAlignment(SwingConstants.LEFT);
		mntmTbNuevo.setBounds(10, 0, 41, 32);
		panel.add(mntmTbNuevo);
		
		// limpiar JTextArea
				//crear un fichero nuevo en el que se graba lo que aparece en JTextArea
		
		JMenuItem mntmTbPegar = new JMenuItem("");
		mntmTbPegar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// hacer lo mismo que con la opción pegar
				
			}
		});
		mntmTbPegar.setIcon(new ImageIcon("C:\\Users\\PC33\\Desktop\\Prueba\\iconos\\pegar_18.jpg"));
		mntmTbPegar.setBounds(434, 0, 41, 32);
		panel.add(mntmTbPegar);
		
		areaDeTexto = new JTextArea();
		areaDeTexto.setBounds(10, 78, 721, 419);
		frame.getContentPane().add(areaDeTexto);
		
		// copiar el texto guardado en memoria en la posicion del cursor
		
	}
}
