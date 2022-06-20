package pop.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import model.Brush;
import model.BrushDatabase;
import view.AbstractTableModelBrush;
import view.BrushJTable;

public class EditBrushDialog  extends JDialog implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	private ArrayList<Brush> brushes = new ArrayList<Brush>();
	static BrushJTable brushesTable;
	private ShowColorsDialog colorsDialog;
	
	public EditBrushDialog(List<Brush> b) {
		
		setName("Editovanje cetkica");
		Window parent = SwingUtilities.getWindowAncestor(this);
		brushes = (ArrayList<Brush>) b;
		
		JButton deleteButton = new JButton("Obrisi");
		JButton cancelButton = new JButton("Odustani");
		JButton colorsButton = new JButton("Vidi boje cetkice");
		
		colorsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
			Brush brush = selectedBrush();
				if(brush== null) {
					JOptionPane.showMessageDialog(null, "Morate selektovati cetkicu.");
				}else {
					System.out.println("edit brush dialog 66:" + brush.getColors().size() + " : " +brush.getColors());
					ShowColorsDialog dialog = new ShowColorsDialog(brush.getColors());
				}
				
			}
		});
		
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("zatvaraj prozor bre");
				dispose();
			}
		});
		
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Brush brush = selectedBrush();
				if (brush == null) {
					JOptionPane.showMessageDialog(null, "Morate selektovati cetkicu.");
				}else {
					Object[] options = { "Da", "Ne" };
					
					int option = JOptionPane.showOptionDialog(null,"Da li ste sigurni da zelite da \n "
						    + "obrisete cetkicu?", "Brisanje cetkice",
					    JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
					    null, options, options[1]);
					
					if(option == JOptionPane.YES_OPTION) {
						for(Brush b: brushes) {
							if(b.equals(brush)) {
								System.out.println("NASAO TU CETKICU");
								brushes.remove(b);
								updateBrushesTable(null, -1);
								break;
							}
						}
					}
				}
				
			}
		});
		
		setLayout(deleteButton, cancelButton, colorsButton);
		
		
		setLocationRelativeTo(null);
		setSize(new Dimension(500,500));
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(getParent());
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		getRootPane().setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		setVisible(true);
	}
	
	private void setLayout(JButton deleteButton, JButton cancelButton, JButton colorsButton) {
		JScrollPane paneBrushes  = showBrushesTable();
		FlowLayout buttonsLayout = new FlowLayout();
		final JPanel buttons = new JPanel();
		buttons.setLayout(buttonsLayout);
		buttons.add(deleteButton);
		buttons.add(cancelButton);
		buttons.add(colorsButton);
		buttons.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);
		
		FlowLayout paneLayout = new FlowLayout();
		final JPanel table = new JPanel();
		table.setLayout(paneLayout);
		table.add(paneBrushes);
		table.setComponentOrientation(
                ComponentOrientation.LEFT_TO_RIGHT);
		
		Container contentPane = getContentPane();
		contentPane.add(table, BorderLayout.CENTER);
		contentPane.add(buttons, BorderLayout.PAGE_END);

		}


	
	private JScrollPane showBrushesTable() {
		BrushDatabase.getInstance().setBrushes(brushes);
		brushesTable = new BrushJTable();
		JScrollPane scrollPane = new JScrollPane(brushesTable);
		this.updateBrushesTable(null	, -1);
		System.out.println("Duzina nisa cetkica u bazi:" + BrushDatabase.getInstance().getBrushes().size());	
		return scrollPane;
	}
	
	public void updateBrushesTable(String akcija,int vrednost) {
		AbstractTableModelBrush model = (AbstractTableModelBrush) brushesTable.getModel();
		model.fireTableDataChanged();
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public List<Brush> getBrushes(){
		return brushes;
	}
	
	public Brush selectedBrush() {
		Brush p= null;
		if(brushesTable.getSelectedRow() < 0) {
			return null;
		}
		p = BrushDatabase.getInstance().getRow(brushesTable.getSelectedRow());
		return p;
	}
	


}
