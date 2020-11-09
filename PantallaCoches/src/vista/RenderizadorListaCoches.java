package vista;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class RenderizadorListaCoches extends JCheckBox implements ListCellRenderer{

	@Override
	public Component getListCellRendererComponent(JList list, Object valor, int index, 
			boolean isSelected, boolean cellHasFocus) {
		setText(valor.toString());
		setSelected(isSelected);
		Color background;
		Color foreground;
		
		if (isSelected) {
			background = Color.LIGHT_GRAY;
			foreground = Color.BLACK;
			// unselected, and not the DnD drop location
		}else {
			background =Color.WHITE;
			foreground = Color.BLACK;
		};
		setBackground(background);
		setForeground(foreground);
		
		return this;
	}
	
	

}
