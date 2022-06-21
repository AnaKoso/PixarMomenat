package view;

import javax.swing.table.AbstractTableModel;

import model.StaffDatabase;

public class AbstractTableModelStaff extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AbstractTableModelStaff() {
		
		
	}

	@Override
	public int getRowCount() {
		return StaffDatabase.getInstance().getStaff().size();
				
	}

	@Override
	public int getColumnCount() {
		return StaffDatabase.getInstance().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return StaffDatabase.getInstance().getValueAt(rowIndex, columnIndex);
	}
	@Override
	public String getColumnName(int index) {
		return StaffDatabase.getInstance().getColumnName(index);
	}

}
