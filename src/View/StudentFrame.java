package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import DBConnect.Book;
import DBConnect.BorrowRecord;
import DBConnect.Card;
import manage.bookManage;
import manage.borrowManage;
import manage.studentManage;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SwingConstants;

public class StudentFrame extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JButton btnNewButton_1;
	private JPanel Panel, Panel_1,Panel_2, Panel_3, Panel_4;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JTextField txtName;
	private JLabel lblNewLabel_2;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	private JTextField txtType;
	private JLabel lblNewLabel_4;
	private JTextField txtPassword;
	private JLabel welcome;
	private JLabel lblUserType_2;
	private JTextField Year1;
	private JLabel lblNewLabel_14;
	private JTextField Year2;
	private JLabel lblNewLabel_15;
	private JTextField Title;
	private JLabel lblNewLabel_16;
	private JTextField Category;
	private JTextField Price1;
	private JTextField Price2;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JButton btnNewButton_12;
	private JLabel lblNewLabel_13;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JPanel panel;
	private JTextField textField_14;
	private JButton btnNewButton_6;
	private JButton btnNewButton_7;
	private JLabel lblNewLabel_2_1_1_1_1_8;
	private JTextField textField_26;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JButton btnNewButton_10;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnNewButton_11;
	private JButton btnNewButton_5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFrame frame = new StudentFrame("library-student-xiaozhou","1000001");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StudentFrame(String title,String id) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon=new ImageIcon(LoginFrame.class.getResource("/Images/logo2.jpg"));
		setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tabbedPane.setBounds(0, 0, 1200, 900);
		contentPane.add(tabbedPane);
		
		Panel = new JPanel();
		Panel_1 = new JPanel();
		Panel_2 = new JPanel();
		Panel_3 = new JPanel();
		Panel_4 = new JPanel();
		
		tabbedPane.addTab("Home", Panel);
		tabbedPane.addTab("Borrow Record", Panel_2);
		tabbedPane.addTab("Book Search", Panel_1);
		
		//btnNewButton_1 = new JButton("\u767B\u51FA");
		btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentFrame.this.setVisible(false);
				LoginFrame loginframe = new LoginFrame("Login");
				loginframe.setVisible(true);
			}
		});
		int x = 30;
		int y = 40;
		
		Panel.setLayout(null);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_1.setBounds(420+y, 450+x, 82, 27);
		Panel.add(btnNewButton_1);
		Panel.setLayout(null);
		
		Card card = studentManage.select_stu(id);
		
		welcome = new JLabel("Welcom Student "+card.get_cname()+" !");
		welcome.setFont(new Font("Times New Roman", Font.PLAIN, 38));
		welcome.setBounds(340, 70, 383, 33);
		Panel.add(welcome);
		
		lblUserType_2 = new JLabel("Made by Zhongyue Zhang, ZheJiang University\n");
		lblUserType_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUserType_2.setBounds(380, 562,313,93);
	    Panel.add(lblUserType_2);
		
		lblNewLabel = new JLabel("Student ID:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(350+y, 130+x, 111, 21);
		Panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setText(card.get_cno());
		textField.setColumns(10);
		textField.setBounds(470+y, 130+x, 109, 24);
		Panel.add(textField);
		
		lblNewLabel_1 = new JLabel("Student Name:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(350+y, 190+x, 111, 21);
		Panel.add(lblNewLabel_1);
		
		txtName = new JTextField();
		txtName.setText(card.get_cname());
		txtName.setColumns(10);
		txtName.setBounds(470+y, 190+x, 109, 24);
		Panel.add(txtName);
		
		lblNewLabel_2 = new JLabel("Department:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(350+y, 250+x, 111, 21);
		Panel.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setText(card.get_dpt());
		textField_2.setColumns(10);
		textField_2.setBounds(470+y, 250+x, 109, 24);
		Panel.add(textField_2);
		
		lblNewLabel_3 = new JLabel("Type:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(350+y, 310+x, 111, 21);
		Panel.add(lblNewLabel_3);
		
		String type = null;
		switch(card.get_type()) {
		case 1: type = "Undergraduate";break;
		case 2: type = "Graduate";break;
		case 3: type = "Teacher";break;
		case 4: type = "Other";break;
		}
		
		txtType = new JTextField();
		txtType.setText(type);
		txtType.setColumns(10);
		txtType.setBounds(470+y, 310+x, 109, 24);
		Panel.add(txtType);
		
		lblNewLabel_4 = new JLabel("Password:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(350+y, 370+x, 111, 21);
		Panel.add(lblNewLabel_4);
		
		txtPassword = new JTextField();
		txtPassword.setText(card.get_pwd());
		txtPassword.setColumns(10);
		txtPassword.setBounds(470+y, 370+x, 109, 24);
		Panel.add(txtPassword);
		Panel_1.setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 136, 1000, 464);
		Panel_1.add(panel_1);
		
		JButton btnNewButton_10 = new JButton("Show All");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.revalidate();
				panel_1.repaint(); 
				panel_1.removeAll();
				ArrayList<Book> books = bookManage.show_book();
				Object[][] rowDatas = bookManage.data(books);
				String[] columnNames = {"ID","Category","Title","Press","Year","Author","Price","Total","Stock"};
				DefaultTableModel tableModel = new DefaultTableModel(rowDatas, columnNames);
				JTable table = new JTable(tableModel);
				//tableModel.setDataVector(rowDatas, columnNames);
				RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
				table.setRowSorter(sorter);
	    		panel_1.add(table.getTableHeader());
    			panel_1.add(table);
    			table.setPreferredScrollableViewportSize(new Dimension(900, 420));
    			table.setFont(new Font("Monospaced", Font.PLAIN, 14));
    			//table.setBounds(10, 136, 1000, 264);
    			JScrollPane scrollPane = new JScrollPane(table);
    			panel_1.add(scrollPane);
 
			}
		});
		
		btnNewButton_10.setBounds(802, 99, 103, 27);
		btnNewButton_10.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		Panel_1.add(btnNewButton_10);
		

		
		
		JButton btnNewButton_11 = new JButton("Search");
		btnNewButton_11.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				panel_1.revalidate();
				panel_1.repaint(); 
				panel_1.removeAll();
				String year1 = Year1.getText();
				String year2 = Year2.getText();
				String price1 = Price1.getText();
				String price2 = Price2.getText();
				String title = Title.getText();
				String category = Category.getText();
				ArrayList<Book> books = bookManage.query_book(year1,year2,price1,price2,title,category);
				Object[][] rowDatas = bookManage.data(books);
				String[] columnNames = {"ID","Category","Title","Press","Year","Author","Price","Total","Stock"};
				DefaultTableModel tableModel = new DefaultTableModel(rowDatas, columnNames);
				JTable table = new JTable(tableModel);
				RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
				table.setRowSorter(sorter);
				//tableModel.setDataVector(rowDatas, columnNames);
	    		panel_1.add(table.getTableHeader());
    			panel_1.add(table);
    			table.setPreferredScrollableViewportSize(new Dimension(900, 420));
    			table.setFont(new Font("Monospaced", Font.PLAIN, 14));
    			//table.setBounds(10, 136, 1000, 264);
    			JScrollPane scrollPane = new JScrollPane(table);
    			panel_1.add(scrollPane);
			}
		});
		
		btnNewButton_11.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_11.setBounds(802, 25, 103, 27);
		Panel_1.add(btnNewButton_11);
		
		Price1 = new JTextField();
		Price1.setBounds(329, 82, 39, 24);
		Panel_1.add(Price1);
		Price1.setColumns(10);
		
		Price2 = new JTextField();
		Price2.setColumns(10);
		Price2.setBounds(432, 82, 39, 24);
		Panel_1.add(Price2);
		
		lblNewLabel_11 = new JLabel("Price between:");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_11.setBounds(220, 84, 103, 18);
		Panel_1.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("\u2014");
		lblNewLabel_12.setBounds(397, 84, 25, 18);
		Panel_1.add(lblNewLabel_12);
		
		btnNewButton_12 = new JButton("Cancel");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Price1.setText("");
				Price2.setText("");
				Year1.setText("");
				Year2.setText("");
				Title.setText("");
				Category.setText("");
			}
		});
		btnNewButton_12.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_12.setBounds(802, 62, 103, 27);
		Panel_1.add(btnNewButton_12);
		
		lblNewLabel_13 = new JLabel("Years between:");
		lblNewLabel_13.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_13.setBounds(220, 47, 114, 18);
		Panel_1.add(lblNewLabel_13);
		
		Year1 = new JTextField();
		Year1.setColumns(10);
		Year1.setBounds(329, 45, 39, 24);
		Panel_1.add(Year1);
		
		lblNewLabel_14 = new JLabel("\u2014");
		lblNewLabel_14.setBounds(397, 47, 25, 18);
		Panel_1.add(lblNewLabel_14);
		
		Year2 = new JTextField();
		Year2.setColumns(10);
		Year2.setBounds(432, 45, 39, 24);
		Panel_1.add(Year2);
		
		lblNewLabel_15 = new JLabel("Title:");
		lblNewLabel_15.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_15.setBounds(516, 47, 48, 18);
		Panel_1.add(lblNewLabel_15);
		
		Title = new JTextField();
		Title.setColumns(10);
		Title.setBounds(613, 46, 131, 24);
		Panel_1.add(Title);
		
		lblNewLabel_16 = new JLabel("Category:");
		lblNewLabel_16.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_16.setBounds(516, 84, 78, 18);
		Panel_1.add(lblNewLabel_16);
		
		Category = new JTextField();
		Category.setColumns(10);
		Category.setBounds(613, 82, 128, 24);
		Panel_1.add(Category);
		
		Panel_2.setLayout(null);
		
		btnNewButton_7 = new JButton("Show the Result of Borrowing Record");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.revalidate();
				panel_2.repaint(); 
				panel_2.removeAll();
				textField_26.setText(id);
				String cno = textField_26.getText();
				
				ArrayList<BorrowRecord> records=null;
				try {
					records = borrowManage.Record(cno);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Object[][] rowDatas = borrowManage.data(records);
				String[] columnNames = {"AdminID","CardID","BookID","Category",  
						"Title",  "Total", "Stock","BorrowTime","ReturnTime","ReturnDeadline"};
				DefaultTableModel tableModel = new DefaultTableModel(rowDatas, columnNames);
				JTable table = new JTable(tableModel);
				RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
				table.setRowSorter(sorter);
	    		panel_2.add(table.getTableHeader());
    			panel_2.add(table);
    			table.setPreferredScrollableViewportSize(new Dimension(900, 230));
    			table.setFont(new Font("Monospaced", Font.PLAIN, 14));
    			//table.setBounds(40, 280, 1000, 370);
    			JScrollPane scrollPane = new JScrollPane(table);
    			panel_2.add(scrollPane);
			}
		});
		btnNewButton_7.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_7.setBounds(419, 60, 353, 30);
		Panel_2.add(btnNewButton_7);
		
		lblNewLabel_2_1_1_1_1_8 = new JLabel(" CardID");
		lblNewLabel_2_1_1_1_1_8.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1_8.setBounds(202, 66, 62, 19);
		Panel_2.add(lblNewLabel_2_1_1_1_1_8);
		
		textField_26 = new JTextField();
		textField_26.setColumns(10);
		textField_26.setBounds(274, 65, 120, 24);
		Panel_2.add(textField_26);
		
		panel_2 = new JPanel();
		panel_2.setBounds(10, 142, 1000, 360);
		Panel_2.add(panel_2);
	    
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setIcon(icon);
		lblNewLabel_1.setBounds(0, -30, icon.getIconWidth(), icon.getIconHeight());
		Panel.add(lblNewLabel_1);
		

	}

}
