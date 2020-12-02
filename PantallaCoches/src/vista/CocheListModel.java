package vista;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

import modelo.Coche;

@SuppressWarnings("serial")
public class CocheListModel extends AbstractListModel<Coche>{
	private ArrayList<Coche> listaCoches;
	
	//constructor
	public CocheListModel(ArrayList<Coche> coches) {
		super();
		listaCoches = coches;
	}
	
//	public CocheListModel(Coche obtenerCocheEnEdicion) {
//		// TODO Auto-generated constructor stub
//	}

	@Override
	public Coche getElementAt(int index) {
		Coche coch = listaCoches.get(index);
		return coch;
	}
	
	@Override
	public int getSize() {
		return listaCoches.size();
	}

}
