package gui;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ToolBar extends JToolBar {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TableRowSorter<TableModel> rowSorter =null;
	public ToolBar() {
		
		super(SwingConstants.HORIZONTAL);

		ActionNew an = new ActionNew();
		ActionEdit ae = new ActionEdit();
		ActionDelete ad = new ActionDelete();
		
		
		JPanel boxPan = new JPanel();
		boxPan.setLayout(new BoxLayout(boxPan, BoxLayout.X_AXIS));
		
		//NEW
		JButton btnNew = new JButton(an);
		boxPan.add(btnNew);
				
		//EDIT 	
		JButton btnEdit = new JButton(ae);
		boxPan.add(btnEdit);
		
		//DELETE
		JButton btnDelete = new JButton(ad);
		boxPan.add(btnDelete);
		
		boxPan.add(Box.createHorizontalStrut(500));
	
		boxPan.add(Box.createHorizontalGlue());		
		
		setFloatable(false);
		add(boxPan);
		
		
		
	}
	
}

