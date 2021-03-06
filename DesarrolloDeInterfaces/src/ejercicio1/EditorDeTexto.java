package ejercicio1;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.DefaultEditorKit;

import java.awt.Toolkit;
import java.awt.Window;
import java.awt.Image;


import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.HashMap;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.Dimension;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
/**
 * 
 * @author Laura Garc�a Taillefert
 *
 */

// Interface del editor de texto
public class EditorDeTexto {


		//definicion de variables
		String ficheroAbierto = ""; // la primera vez ficheroAbierto est� vac�o
		Boolean cambios = false;  // para controlar que ha habido cambios en el JTextArea

	private JFrame frame;
	private JTextArea areaDeTexto;
	
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
		frame.setMinimumSize(new Dimension(500, 500));
		frame.addWindowListener(new WindowAdapter() {
			@Override
			//evento que se ejecuta cuando cerramos la ventana
			//confirmar que queremos cerrarla
			public void windowClosing(WindowEvent e) {
				int res = JOptionPane.showConfirmDialog(null, "Cerrar?");
				if (res==JFileChooser.APPROVE_OPTION) {
					frame.dispose();
				}
			}
		});
		frame.setBounds(100, 100, 683, 635);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(5, 5));
		
		JPanel pnMenus = new JPanel();
		frame.getContentPane().add(pnMenus, BorderLayout.NORTH);
		pnMenus.setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		pnMenus.add(menuBar, BorderLayout.NORTH);
		
		JMenu mnFichero = new JMenu("Fichero");
		menuBar.add(mnFichero);
		
		//crear un fichero nuevo en el que se va a grabar lo que aparece en JTextArea
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				//comprobar antes que no ha habido un cambio que queramos guardar, con la variable cambios
				if (cambios) {
					// si ha habido cambios preguntar si se quieren guardar
					guardarCambios();
					
				}
				//aqui se abre un JTextArea nueva vac�a y se usa ficheroAbierto para  guardar lo que tenemos por pantalla 
				nuevoFichero();
				
			}
		});
		mnFichero.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//la comprobacion de los cambios se hace tambien antes de abrir un fichero nuevo
				if (cambios) {
					
					guardarCambios();
					
				}
				// aqu� se abre un fichero y se vuelca su contenido en la pantalla
				abrirFichero();
					
			}
		});
		mnFichero.add(mntmAbrir);
	
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// guarda el contenido de la pantalla en un fichero
				guardarFichero();
				
			}
		});
		mnFichero.add(mntmGuardar);
		

		
		JMenuItem mntmGuardarComo = new JMenuItem("GuardarComo");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// guarda el contenido de la pantalla en un fichero que se escoge
				guardarFicheroComo();
				
			}
		});
		mnFichero.add(mntmGuardarComo);
		
	
		
		JMenu mnEditor = new JMenu("Editor");
		menuBar.add(mnEditor);
		
		JMenu mnSeleccionarFuente = new JMenu("SeleccionarFuente");
		mnEditor.add(mnSeleccionarFuente);
		
		//seleccionar una de las tres fuentes de las opciones
		
		JMenuItem mntmCalibri = new JMenuItem("Calibri");
		mntmCalibri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//elegimos funete Calibri
				Font fuente = new Font("Calibri", 3, 20);
		       areaDeTexto.setFont(fuente); 
		       // areaDeTexto.setForeground(Color.BLUE);
				
			}
		});
		mntmCalibri.setFont(new Font("Calibri", Font.PLAIN, 12));
		mnSeleccionarFuente.add(mntmCalibri);
		
			
		JMenuItem mntmArial = new JMenuItem("Arial");
		mntmArial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// elegimos fuente Arial
				Font fuente = new Font("Arial", 3, 20);
			       areaDeTexto.setFont(fuente); 
			     // areaDeTexto.setForeground(Color.RED);
			}
		});
		mntmArial.setFont(new Font("Arial", Font.PLAIN, 12));
		mnSeleccionarFuente.add(mntmArial);
		
		JMenuItem mntmCentury = new JMenuItem("Century");
		mntmCentury.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//elegimos fuente Century
				Font fuente = new Font("Century", 3, 20);
			       areaDeTexto.setFont(fuente); 
			     //   areaDeTexto.setForeground(Color.GREEN);
				
			}
		});
		mntmCentury.setFont(new Font("Century", Font.PLAIN, 12));
		mnSeleccionarFuente.add(mntmCentury);
		
		JMenuItem mntmCortar = new JMenuItem("Cortar");
		mntmCortar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// usa el portapapeles de windows para hace la accion cortar
				areaDeTexto.cut();
				mntmCortar.setToolTipText("Cortar");
			}
		});
		mnEditor.add(mntmCortar);
		
		JMenuItem mntmCopiar = new JMenuItem("Copiar");
		mntmCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//guarda el texto seleccionardo en memoria
				areaDeTexto.copy();
			}
		});
		mnEditor.add(mntmCopiar);
		
		JMenuItem mntmPegar = new JMenuItem("Pegar");
		mntmPegar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// copia en JTextArea el texto guardado en memoria
				areaDeTexto.paste();
				
			}
		});
		mnEditor.add(mntmPegar);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		pnMenus.add(toolBar, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 196, 222));
		toolBar.add(panel);
		
		JMenuItem mntmTbGuardar = new JMenuItem("");
		mntmTbGuardar.setToolTipText("Guardar");
		mntmTbGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// opcion guardar
				guardarFichero();
		
			}
		});
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		
		
		JMenuItem mntmTbNuevo = new JMenuItem("");
		mntmTbNuevo.setToolTipText("Nuevo");
		mntmTbNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//opcion nuevo
				if (cambios) {
					
					guardarCambios();
					
				}
				nuevoFichero();
				
			}
		});
		mntmTbNuevo.setIcon(new ImageIcon(EditorDeTexto.class.getResource("/img/nuevo2_30.png")));
		mntmTbNuevo.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(mntmTbNuevo);
		mntmTbGuardar.setIcon(new ImageIcon(EditorDeTexto.class.getResource("/img/guardar2_30.png")));
		panel.add(mntmTbGuardar);
		
	
		
		JMenuItem mntmTbVCortar = new JMenuItem("");
		
		mntmTbVCortar.setToolTipText("Cortar");
		mntmTbVCortar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// usa el portapapeles de windows para hace la accion cortar
				areaDeTexto.cut();
				
			}
		});
		mntmTbVCortar.setIcon(new ImageIcon(EditorDeTexto.class.getResource("/img/cortar2_30.jpg")));
		panel.add(mntmTbVCortar);
		
	
		
		JMenuItem mntmTbCopiar = new JMenuItem("");
		mntmTbCopiar.setToolTipText("Copiar");
		mntmTbCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//guarda el texto seleccionardo en memoria
				areaDeTexto.copy();
				
			}
		});
		mntmTbCopiar.setIcon(new ImageIcon(EditorDeTexto.class.getResource("/img/copiar2_30.png")));
		panel.add(mntmTbCopiar);
		
		
		
		JMenuItem mntmTbPegar = new JMenuItem("");
		mntmTbPegar.setToolTipText("Pegar");
		mntmTbPegar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// copia en JTextArea el texto guardado en memoria
				areaDeTexto.paste();
				
			}
		});
		mntmTbPegar.setIcon(new ImageIcon(EditorDeTexto.class.getResource("/img/pegar2_30.png")));
		panel.add(mntmTbPegar);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		areaDeTexto = new JTextArea();
		areaDeTexto.setFont(new Font("Monospaced", Font.PLAIN, 16));
		scrollPane.setViewportView(areaDeTexto);
		//frame.getContentPane().add(areaDeTexto, BorderLayout.CENTER);
		
	}
	
	
	//Metodos para nuevoFichero, abrirFichero, guardarFichero, guardarFicheroComo
	
	// nuevoFichero inicializa la variable ficheroAbierto 
	public void nuevoFichero() {
			areaDeTexto.setText("");
			ficheroAbierto = "";
			cambios = false;

	}
	
	//abrirFichero permite escoger un fichero del disco desde un directorio predeterminado
	public void abrirFichero() {
	
			//  ventana abierta en un filechooser
				JFileChooser ficheroEscogido = new JFileChooser("C:\\Users\\PC33\\Desktop\\Prueba");
				ficheroEscogido.setBounds(0, 0, 497, 333);
			
				int valorDevuelto = ficheroEscogido.showOpenDialog(null);
				
				// si presionamos el boton aceptar, el contenido del fichero elegido pasa a ser ficheroAbierto
				if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
					ficheroAbierto = (ficheroEscogido.getSelectedFile().getAbsolutePath());
	
					//leo el texto que hay en el fichero y lo escribo en la ventana en text area
					areaDeTexto.setText(UtilidadesEdicion.obtenerTexto(ficheroAbierto));
					
					 //con solo abrir el fichero no deber�a actualizarse la variable cambios a true
					cambios = false; 
				}
	}
	
	//guardarFichero 
	public void guardarFichero() {
		
		//Guardar el contenido de JTextArea en el ficheroAbiero, 
		// en caso de no existir debemos llamar a guardarFicheroComo
		if (ficheroAbierto.equals("")) {
				guardarFicheroComo();
			
		}else {
			String texto = areaDeTexto.getText();
		
			// texto lo guardamos en el fichero abierto
			UtilidadesEdicion.guardarTexto(ficheroAbierto, texto);
			
			// actualizar a false los cambios despues de hacer un guardado
			cambios = false;  
		}
					
	}
	
	//guardarFicheroComo
	public void guardarFicheroComo() {
		
		// Guardar el contenido de JTextArea en un fichero que elegimos con JFileChooser
		JFileChooser ficheroEscogido = new JFileChooser("C:\\Users\\PC33\\Desktop\\Prueba");
		ficheroEscogido.setBounds(0, 0, 497, 333);

		int valorDevuelto = ficheroEscogido.showSaveDialog(null);
		
		if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
			ficheroAbierto = (ficheroEscogido.getSelectedFile().getAbsolutePath());
				
			String texto = areaDeTexto.getText();
			UtilidadesEdicion.guardarTexto(ficheroAbierto, texto);
			// actualizar a false los cambios despues de hacer un guardado
			cambios = false;  
		}
		
	}
	
	//guardarCambios
	public void guardarCambios() {
	
			// preguntar si queremos guardar los cambios con un guardar
			int res = JOptionPane.showConfirmDialog(null, "Guardar cambios?");
			if (res==JFileChooser.APPROVE_OPTION) {
				
				guardarFichero();
			}
	}
}
