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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		tbCoches = new JTable();
		tbCoches.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 2));
		tbCoches.setFillsViewportHeight(true);
	
		
		tbCoches.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
		tbCoches.setBounds(60,23,506,209);
		
		//Asignación del modelo a la tabla
		
		ArrayList<Coche> lista =obtenerCoches();
		tbCoches.setModel(new CocheTableModel(lista));

		frame.getContentPane().add(tbCoches, BorderLayout.CENTER);
	}
	
	
	//aquí defino metodos propios
	 public ArrayList<Coche> obtenerCoches() {
		 ArrayList<Coche> lista= new ArrayList<>();
		 Coche car = new Coche("Renault","Cinco","verde","1234",1980);
	
		 
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
