package view;

import javax.swing.table.AbstractTableModel;

import model.BrushDatabase;

public class AbstractTableModelBrush extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AbstractTableModelBrush() {
		
		
	}

	@Override
	public int getRowCount() {
		return BrushDatabase.getInstance().getBrushes().size();
				
	}

	@Override
	public int getColumnCount() {
		return BrushDatabase.getInstance().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BrushDatabase.getInstance().getValueAt(rowIndex, columnIndex);
	}
	@Override
	public String getColumnName(int index) {
		return BrushDatabase.getInstance().getColumnName(index).toString();
	}
}
