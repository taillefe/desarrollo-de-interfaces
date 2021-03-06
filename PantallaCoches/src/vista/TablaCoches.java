package vista;
import modelo.Coche;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

import com.sun.prism.paint.Color;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TablaCoches {

	private JFrame ventana1;
	private JTable tbCoches;
	
	ArrayList<Coche> lista= new ArrayList<>();
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TablaCoches window = new TablaCoches();
					window.ventana1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TablaCoches() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ventana1 = new JFrame();
		ventana1.setMinimumSize(new Dimension(500, 250));
		ventana1.setIconImage(Toolkit.getDefaultToolkit().getImage(TablaCoches.class.getResource("/img2/avatarlaura.jpg")));
		ventana1.setBounds(100, 100, 450, 300);
		ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Asignaci�n del modelo a la tabla
		
		crearListaCoches();
		
		JScrollPane spCoches = new JScrollPane();
		spCoches.setBounds(0, 0,594,299);
		ventana1.getContentPane().add(spCoches, BorderLayout.CENTER);
		
		tbCoches = new JTable();
	//	tbCoches.setFillsViewportHeight(true);
		
		tbCoches.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 2));
		tbCoches.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbCoches.setBounds(60,23,506,209);
		//aqui se asigna la listaTableModel a la tabla
		tbCoches.setModel(new CocheTableModel(lista));
			
		tbCoches.setFillsViewportHeight(true);
		spCoches.setColumnHeaderView(tbCoches);
		spCoches.setViewportView(tbCoches);
		tbCoches.setAutoCreateRowSorter(true);
		
		btnNewButton = new JButton("Nuevo Coche");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// aqui se hace la llamada a DialogoNuevoCoche
				// pasandole la lista de los coches donde hay que a�adir uno nuevo
				DialogoNuevoCoche dialogoNuevoCoche = new DialogoNuevoCoche();
				dialogoNuevoCoche.setVisible(true);
				lista.add(dialogoNuevoCoche.obtenerCocheEnEdicion());
			}
		});
		ventana1.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
	//	ventana1.getContentPane().add(tbCoches, BorderLayout.CENTER);
	}
	
	
	//aqu� defino metodos propios
	// metodo para llenar la lista de coches
	 public  ArrayList<Coche> crearListaCoches() {
		 
	//	 ArrayList<Coche> lista= new ArrayList<>();
	
		 Coche car = new Coche("Renault","Cinco","verde","1234",1980);
		 lista.add( car);
		 car = new Coche("Citroen","C2","rojo","5678",2000);
		 lista.add(car);
		 car = new Coche("Audi","A1","amarillo","4321",1999);
		 lista.add(car);
		 car = new Coche("Nissan","Cascai","azul","8765",2010);
		 lista.add(car);
		 car = new Coche("Renault","Cinco","verde","1234",1980);
		 lista.add( car);
		 car = new Coche("Citroen","C2","rojo","5678",2000);
		 lista.add(car);
		 car = new Coche("Audi","A1","amarillo","4321",1999);
		 lista.add(car);
		 car = new Coche("Nissan","Cascai","azul","8765",2010);
		 lista.add(car);
		 car = new Coche("Renault","Cinco","verde","1234",1980);
		 lista.add( car);
		 car = new Coche("Citroen","C2","rojo","5678",2000);
		 lista.add(car);
		 car = new Coche("Audi","A1","amarillo","4321",1999);
		 lista.add(car);
		 car = new Coche("Nissan","Cascai","azul","8765",2010);
		 lista.add(car);
		 car = new Coche("Renault","Cinco","verde","1234",1980);
		 lista.add( car);
		 car = new Coche("Citroen","C2","rojo","5678",2000);
		 lista.add(car);
		 car = new Coche("Audi","A1","amarillo","4321",1999);
		 lista.add(car);
		 car = new Coche("Nissan","Cascai","azul","8765",2010);
		 lista.add(car);
		
		 
		 System.out.println ("Lista de coches" + lista);
		 
		 return lista;
	 }
	
	

}
