package view;

import javax.swing.table.AbstractTableModel;

import model.SoftwareToolDatabase;

public class AbstractTableModelSoftwareTool extends AbstractTableModel { 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AbstractTableModelSoftwareTool() {
		
		
	}

	@Override
	public int getRowCount() {
		return SoftwareToolDatabase.getInstance().getTools().size();
				
	}

	@Override
	public int getColumnCount() {
		return SoftwareToolDatabase.getInstance().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return SoftwareToolDatabase.getInstance().getValueAt(rowIndex, columnIndex);
	}
	@Override
	public String getColumnName(int index) {
		return SoftwareToolDatabase.getInstance().getColumnName(index);
	}
}
