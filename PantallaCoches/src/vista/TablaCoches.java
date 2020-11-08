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

public class TablaCoches {

	private JFrame frame;
	private JTable tbCoches;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TablaCoches window = new TablaCoches();
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
	public TablaCoches() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(500, 250));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(TablaCoches.class.getResource("/img2/avatarlaura.jpg")));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Asignación del modelo a la tabla
		
		ArrayList<Coche> lista =obtenerCoches();
		
		JScrollPane spCoches = new JScrollPane();
		spCoches.setBounds(0, 0,594,299);
		frame.getContentPane().add(spCoches, BorderLayout.EAST);
		
		tbCoches = new JTable();
		tbCoches.setAutoCreateRowSorter(true);
		tbCoches.setFillsViewportHeight(true);
		tbCoches.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 2));
		tbCoches.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbCoches.setBounds(60,23,506,209);
		//aqui se asigna la listaTableModel a la tabla
		tbCoches.setModel(new CocheTableModel(lista));
			
	//	tbCoches.setFillsViewportHeight(true);
	//	scrollPane.setColumnHeaderView(tbCoches);
		spCoches.setViewportView(tbCoches);
	//	frame.getContentPane().add(tbCoches, BorderLayout.CENTER);
	}
	
	
	//aquí defino metodos propios
	// metodo para llenar la lista de coches
	 public static ArrayList<Coche> obtenerCoches() {
		 
		 ArrayList<Coche> lista= new ArrayList<>();
	
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
