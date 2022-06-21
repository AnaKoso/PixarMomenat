package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import model.Brush;

public class BrushTableCellRenderrer implements TableCellRenderer{
	@Override
	  public Component getTableCellRendererComponent(JTable table, Object value,
	        boolean isSelected, boolean hasFocus, int row, int column) {
	    Brush brush = (Brush)value;
	    
	    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
	    panel.add(new JLabel("" + brush.getName() + ",  Usage: " + brush.getUsage() + " "));
	    panel.add(getColorPanel(brush.getColors()));

	    if (isSelected) {
	      panel.setBackground(table.getSelectionBackground());
	    }else{
	      panel.setBackground(table.getBackground());
	    }
	    return panel;
	  }
	
	public JPanel getColorPanel(List<Color> colors) {
		FlowLayout colorsLayout = new FlowLayout();
		JPanel colorPanel = new JPanel();
		colorPanel.setLayout(colorsLayout);
		colorPanel.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);
		
		for (Color color : colors) {
			JPanel c = new JPanel();
			colorPanel.add(c);
			c.setBackground(color);
		}
		
		return colorPanel;
	}
	}
