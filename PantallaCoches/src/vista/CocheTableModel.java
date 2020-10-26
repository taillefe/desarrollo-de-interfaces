package vista;
import modelo.Coche;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CocheTableModel extends AbstractTableModel {
	
	private ArrayList<Coche> listaCoches;
	private String[] columnas = { "Marca", "Modelo", "Color", "Matrícula", "Año Fabricación"};
	
	public CocheTableModel (ArrayList<Coche> coches) {
		super();
		listaCoches = coches;
	}

	public boolean isCellEditable(int row, int col) {
		return false;
	}

	public String getColumName (int col) {
		return columnas[col];
	}
	
	@Override
	public int getRowCount() {
	 
		return listaCoches.size();
	}

	@Override
	public int getColumnCount() {
		
		return columnas.length;
	}

	@Override
	public Object getValueAt (int row, int col) {
		if (row != -1 && listaCoches.size() > row) {
			Coche car = listaCoches.get(row);
			switch (col) {
			case 0:
				return car.getMarca();
			case 1:
				return car.getModelo();
			case 2:
				return car.getColor();
			case 3:
				return car.getMatrícula();
			case 4:
				return car.getAnoFabricacion();
			default:
				return null;
			}
		}else
		return null;
	}
	
	

	

}
