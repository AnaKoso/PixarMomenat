package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import model.SoftwareTool;
import model.SoftwareToolDatabase;
import model.Staff;
import model.StaffDatabase;
import view.AbstractTableModelSoftwareTool;
import view.AbstractTableModelStaff;
import view.SoftwareToolJTable;
import view.StaffJTable;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;



public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	
	private JTable tabelaPredmeti; 
	private JTable tabelaProfesori;
	private JTable tabelaStudenti;
	private JTable tableStaff;
	private JTable tableTools;
	private JTabbedPane tabbedPane;
	
	private static MainFrame instance = null;
	
	public static MainFrame getInstance() {
		if(instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	
	
	

	public MainFrame() {
		super();
	
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth =screenSize.width;
		setSize(screenWidth*3/4,screenHeight*3/4);
		setTitle("Studentska sluzba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setLayout(new BorderLayout());
		//
		JPanel panBars=new JPanel();
		panBars.setBackground(Color.LIGHT_GRAY);
		panBars.setPreferredSize(new Dimension(60,60));
		add(panBars,BorderLayout.NORTH);		
		panBars.setLayout(new BorderLayout());
		
		
		ToolBar toolbar =  new ToolBar();
		toolbar.setPreferredSize(new Dimension(this.getWidth(),35));
		panBars.add(toolbar,BorderLayout.SOUTH);
		
		
		MenuBar menuBar =  new MenuBar();
		menuBar.setPreferredSize(new Dimension(25,25));
		panBars.add(menuBar,BorderLayout.NORTH);
		
		StatusBar statusLine =  new StatusBar();
		statusLine.setPreferredSize(new Dimension(this.getWidth(),20));
        add(statusLine,BorderLayout.SOUTH);
        
    
        createTabbedPane();
       
     

		setVisible(true);	
		
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				System.out.println("public void windowOpened(WindowEvent e)");
				StaffDatabase.getInstance().deserializeStaff();
				SoftwareToolDatabase.getInstance().deserializeTools();
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("public void windowClosing(WindowEvent e)");
				StaffDatabase.getInstance().serializeStaff();
				SoftwareToolDatabase.getInstance().serializeSpftwareTools();
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
				
	}
	
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}	
	public int selectedTab() {
		return tabbedPane.getSelectedIndex();
	}
	
	
	
	
	
	
	public JTable getTabelaStudenti(){
		 return tabelaStudenti;
	 }
	 public JTable getTabelaPredmeti() {
		return tabelaPredmeti;
	}
	 public JTable getTabelaProfesori() {
		return tabelaProfesori;
	}

	private JScrollPane showStaffTable() {
		tableStaff = new StaffJTable();
		JScrollPane scrollPane4 = new JScrollPane(tableStaff);
		this.updateStaffTable(null	, -1);		
		return scrollPane4;
	}
	
	private JScrollPane showToolTable() {
		tableTools = new SoftwareToolJTable();
		JScrollPane scrollPane5 = new JScrollPane(tableTools);
		this.updateToolTable(null	, -1);		
		return scrollPane5;
	}

	public void updateToolTable(Object object, int i) {
		AbstractTableModelSoftwareTool model = (AbstractTableModelSoftwareTool) tableTools.getModel();
		model.fireTableDataChanged();
		validate();
		
	}


	public void updateStaffTable(Object object, int i) {
		AbstractTableModelStaff model = (AbstractTableModelStaff) tableStaff.getModel();
		model.fireTableDataChanged();
		validate();
		
	}


	private void createTabbedPane() {
		tabbedPane = new JTabbedPane();
		JScrollPane staffTab = showStaffTable();
		JScrollPane toolsTab = showToolTable();
		
		
		tabbedPane.addTab("Zaposleni", staffTab);
		tabbedPane.addTab("Softverski alati", toolsTab);
		
		add(tabbedPane,BorderLayout.CENTER);
		
	}

	public Staff selectedStaff() {
		Staff p= null;
		if(tableStaff.getSelectedRow() < 0) {
			return null;
		}
		p = StaffDatabase.getInstance().getRow(tableStaff.getSelectedRow());
		return p;
	}

	public int selectedStaffRow() {
		if(tableStaff.getSelectedRow() < 0) {
			return 0;
			
		}
		return tableStaff.getSelectedRow();
	}



	public SoftwareTool selectedTool() {
		SoftwareTool p= null;
		if(tableTools.getSelectedRow() < 0) {
			return null;
		}
		p = SoftwareToolDatabase.getInstance().getRow(tableTools.getSelectedRow());
		return p;
	}

	public int selectedToolRow() {
		if(tableTools.getSelectedRow() < 0) {
			return 0;
			
		}
		return tableTools.getSelectedRow();
	}
	
	
	
}
