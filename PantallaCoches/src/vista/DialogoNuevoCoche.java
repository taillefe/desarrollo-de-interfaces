package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import modelo.Coche;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DialogoNuevoCoche extends JDialog {

	private final JPanel panel = new JPanel();
	private JTextField txtModelo;
	private JTextField txtColor;
	private JTextField txtMatricula;
	private JTextField txtAno;
	int datosAno;
	
	 static Coche cocheEdi=null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoNuevoCoche dialog = new DialogoNuevoCoche();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoNuevoCoche() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		panel.setBounds(0, 0, 434, 228);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(84, 41, 46, 14);
		panel.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(84, 66, 46, 14);
		panel.add(lblModelo);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(84, 91, 46, 14);
		panel.add(lblColor);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(84, 116, 46, 14);
		panel.add(lblMatricula);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(156, 63, 86, 20);
		panel.add(txtModelo);
		txtModelo.setColumns(10);
		
		txtColor = new JTextField();
		txtColor.setBounds(156, 88, 86, 20);
		panel.add(txtColor);
		txtColor.setColumns(10);
		
		txtMatricula = new JTextField();
		txtMatricula.setBounds(156, 113, 86, 20);
		panel.add(txtMatricula);
		txtMatricula.setColumns(10);
		
		JComboBox cbMarca = new JComboBox();
		cbMarca.setBounds(156, 37, 90, 22);
		
		
		TablaCoches tbCoches = new TablaCoches();
		cbMarca.setModel(new DefaultComboBoxModel(new String[] {"Renault", "Citroen", "Audi"}));
		
		panel.add(cbMarca);
		
		JLabel lblAno = new JLabel("A\u00F1o");
		lblAno.setBounds(84, 141, 46, 14);
		panel.add(lblAno);
		
		txtAno = new JTextField();
		txtAno.setBounds(156, 138, 86, 20);
		panel.add(txtAno);
		txtAno.setColumns(10);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 228, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						System.out.println("año : "+ txtAno.getText());
						// si el año no es un numero poner un 0
						
						try {
							
							datosAno = Integer.valueOf(txtAno.getText());
						} catch (NumberFormatException ex){
							datosAno = 0;
							//	ex.printStackTrace();
						}
					//	if (Comunes.isNumeric(txtAno.getText())) {
					//		datosAno = Integer.valueOf(txtAno.getText());
					//	}else {
					//		datosAno = 0;
					//	}
							
					// aqui se guardan los datos de pantalla en la lista de coches
					  Coche car = new Coche (cbMarca.getSelectedItem().toString(),txtModelo.getText(),
							  txtColor.getText(),txtMatricula.getText(),datosAno);
					  cocheEdi=car;
					  //System.out.println ("Lista de coches2" + listaCoches);
					  // esta lista es la que hay en la ventana principal
					  Component component = (Component) e.getSource();
				        JDialog dialog = (JDialog) SwingUtilities.getRoot(component);
				        dialog.dispose();
			//		  TablaCoches tbCoches = new TablaCoches();
			//		  tbCoches.setVisible(true);
					  	
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//cuando le de a cancelar no hace nada
						 Component component = (Component) e.getSource();
					     JDialog dialog = (JDialog) SwingUtilities.getRoot(component);
					     dialog.dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	//aquí defino metodos propios
		// metodo para llenar la lista de coches
		 public   Coche obtenerCocheEnEdicion() {
			 
		//	 ArrayList<Coche> lista= new ArrayList<>();
		
			
			 
			 return cocheEdi;
		 }
}
