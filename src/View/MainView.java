package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DBConnect.Administratoe;
import DBConnect.Book;
import DBConnect.BorrowRecord;
import DBConnect.Card;

import javax.swing.JTabbedPane;
import javax.swing.JTable;

import manage.bookManage;
import manage.borrowManage;
import manage.studentManage;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.TableRowSorter;
import java.awt.Color;
import javax.swing.SwingConstants;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel Panel, Panel_1, Panel_2, Panel_3, Panel_5;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
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
	private JLabel lblNewLabel_2_1_1_1_1_5;
	private JTextField textField_17;
	private JButton btnNewButton_8;
	private JLabel lblNewLabel_4;
	private JTextField textField_18;
	private JLabel lblNewLabel_2_5;
	private JTextField textField_19;
	private JLabel lblNewLabel_2_6;
	private JTextField textField_20;
	private JLabel lblNewLabel_2_1_3;
	private JTextField textField_21;
	private JLabel lblNewLabel_2_1_1_3;
	private JTextField textField_22;
	private JLabel lblNewLabel_2_1_1_1_4;
	private JTextField textField_23;
	private JLabel lblNewLabel_2_1_1_1_1_6;
	private JTextField textField_24;
	private JButton btnNewButton_7;
	private JLabel lblNewLabel_2_1_1_1_1_7;
	private JTextField textField_25;
	private JButton btnNewButton_9;
	private JLabel lblNewLabel_2_1_1_1_1_8;
	private JTextField textField_26;
	private JLabel lblNewLabel_5;
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
	private JTextField Price1;
	private JTextField Price2;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JButton btnNewButton_12;
	private JLabel lblNewLabel_13;
	private JTextField Year1;
	private JLabel lblNewLabel_14;
	private JTextField Year2;
	private JLabel lblNewLabel_15;
	private JTextField Title;
	private JLabel lblNewLabel_16;
	private JTextField Category;
	private JTextField textField_8;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_5;
	// private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administratoe admin = new Administratoe("0000001","admin","12345","87896666");
					MainView frame = new MainView(admin,"Library-administrator-admin");
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
	public MainView(Administratoe admin,String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon=new ImageIcon(LoginFrame.class.getResource("/Images/logo2.jpg"));
		setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setFont(new Font("Times New Roman", Font.BOLD, 18));
		tabbedPane.setBounds(0, 0, 1200, 900);
		contentPane.add(tabbedPane);
		// contentPane.setBackground(SystemColor.white);
		
		Panel = new JPanel();
		Panel_1 = new JPanel();
		Panel_2 = new JPanel();
		Panel_3 = new JPanel();
		Panel_5 = new JPanel();
		
	
		tabbedPane.addTab("Home", Panel_5);
		tabbedPane.addTab("WarehuseManger", Panel);
		tabbedPane.addTab("Search", Panel_1);
		
		
		Panel_5.setLayout(null);
		JLabel welcome = new JLabel("Welcom Administrator "+admin.getAname()+" !");
		welcome.setFont(new Font("Times New Roman", Font.PLAIN, 38));
		welcome.setBounds(277, 102, 600, 33);
		Panel_5.add(welcome);
		int x = 30;
		int y = 20;
		
		JLabel lblUserType_2 = new JLabel("Made by Zhongyue Zhang, ZheJiang University\n");
		lblUserType_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUserType_2.setBounds(380, 562,313,93);
	    Panel_5.add(lblUserType_2);
	    
		
		lblNewLabel_7 = new JLabel("Administrator ID:");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(372, 198, 211, 21);
		Panel_5.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Administrator Name:");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(372, 258, 211, 21);
		Panel_5.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Administrator Password:");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_9.setBounds(372, 318, 211, 21);
		Panel_5.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Administrator Contact:");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_10.setBounds(372, 378, 211, 21);
		Panel_5.add(lblNewLabel_10);
		
		textField_27 = new JTextField();
		textField_27.setBounds(562, 198, 109, 24);
		textField_27.setText(admin.getAno());
		Panel_5.add(textField_27);
		textField_27.setColumns(10);
		
		textField_28 = new JTextField();
		textField_28.setColumns(10);
		textField_28.setText(admin.getAname());
		textField_28.setBounds(562, 258, 109, 24);
		Panel_5.add(textField_28);
		
		textField_29 = new JTextField();
		textField_29.setColumns(10);
		textField_29.setText(admin.getPassword());
		textField_29.setBounds(562, 318, 109, 24);
		Panel_5.add(textField_29);
		
		textField_30 = new JTextField();
		textField_30.setColumns(10);
		textField_30.setText(admin.getContact());
		textField_30.setBounds(562, 378, 109, 24);
		Panel_5.add(textField_30);
		
		
		
		
		Panel_1.setLayout(null);
		panel_1 = new JPanel();
		panel_1.setBounds(10, 136, 1000, 464);
		Panel_1.add(panel_1);
		
		btnNewButton_10 = new JButton("Show All");
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
		

		
		
		btnNewButton_11 = new JButton("Search");
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
    			JScrollPane scrollPane = new JScrollPane(table);
    			//table.setBounds(10, 136, 1000, 264);
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
		tabbedPane.addTab("Borrowing/Returning", Panel_2);
		Panel_2.setLayout(null);
		
		lblNewLabel_2_1_1_1_1_5 = new JLabel("BookID");
		lblNewLabel_2_1_1_1_1_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1_5.setBounds(528, 67, 99, 19);
		Panel_2.add(lblNewLabel_2_1_1_1_1_5);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(612, 66, 120, 24);
		Panel_2.add(textField_17);
		
		btnNewButton_8 = new JButton("Borrow");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bno = textField_17.getText();
				String cno = textField_26.getText();
				String borrow_time = textField_8.getText();
					try {
						if(bookManage.exist_book(bno)) {//检查库存是否为空
							if(borrowManage.borrow_record(admin.getAno(),cno,bno,borrow_time))//检查是否可行并更新borrow表
						{
						borrowManage.borrow_book(bno);//更新book表}
						}}
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
			}
		});
		btnNewButton_8.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_8.setBounds(812, 583, 110, 30);
		Panel_2.add(btnNewButton_8);
		
		lblNewLabel_4 = new JLabel("Title");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(84, 183, 32, 19);
		Panel_2.add(lblNewLabel_4);
		
		textField_18 = new JTextField();
		textField_18.setHorizontalAlignment(SwingConstants.CENTER);
		textField_18.setColumns(10);
		textField_18.setBounds(137, 182, 132, 24);
		Panel_2.add(textField_18);
		
		lblNewLabel_2_5 = new JLabel("Category");
		lblNewLabel_2_5.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_5.setBounds(316, 185, 58, 19);
		Panel_2.add(lblNewLabel_2_5);
		
		textField_19 = new JTextField();
		textField_19.setHorizontalAlignment(SwingConstants.CENTER);
		textField_19.setColumns(10);
		textField_19.setBounds(396, 183, 132, 24);
		Panel_2.add(textField_19);
		
		lblNewLabel_2_6 = new JLabel("Press");
		lblNewLabel_2_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_6.setBounds(84, 217, 48, 19);
		Panel_2.add(lblNewLabel_2_6);
		
		textField_20 = new JTextField();
		textField_20.setHorizontalAlignment(SwingConstants.CENTER);
		textField_20.setColumns(10);
		textField_20.setBounds(137, 215, 132, 24);
		Panel_2.add(textField_20);
		
		lblNewLabel_2_1_3 = new JLabel("Year");
		lblNewLabel_2_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1_3.setBounds(584, 184, 32, 19);
		Panel_2.add(lblNewLabel_2_1_3);
		
		textField_21 = new JTextField();
		textField_21.setHorizontalAlignment(SwingConstants.CENTER);
		textField_21.setColumns(10);
		textField_21.setBounds(640, 183, 86, 24);
		Panel_2.add(textField_21);
		
		lblNewLabel_2_1_1_3 = new JLabel("Author");
		lblNewLabel_2_1_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1_1_3.setBounds(316, 217, 48, 19);
		Panel_2.add(lblNewLabel_2_1_1_3);
		
		textField_22 = new JTextField();
		textField_22.setHorizontalAlignment(SwingConstants.CENTER);
		textField_22.setColumns(10);
		textField_22.setBounds(396, 217, 132, 24);
		Panel_2.add(textField_22);
		
		lblNewLabel_2_1_1_1_4 = new JLabel("Price");
		lblNewLabel_2_1_1_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_4.setBounds(758, 184, 41, 19);
		Panel_2.add(lblNewLabel_2_1_1_1_4);
		
		textField_23 = new JTextField();
		textField_23.setHorizontalAlignment(SwingConstants.CENTER);
		textField_23.setColumns(10);
		textField_23.setBounds(809, 183, 86, 24);
		Panel_2.add(textField_23);
		
		lblNewLabel_2_1_1_1_1_6 = new JLabel("Total");
		lblNewLabel_2_1_1_1_1_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1_6.setBounds(584, 218, 41, 19);
		Panel_2.add(lblNewLabel_2_1_1_1_1_6);
		
		textField_24 = new JTextField();
		textField_24.setHorizontalAlignment(SwingConstants.CENTER);
		textField_24.setColumns(10);
		textField_24.setBounds(640, 217, 86, 24);
		Panel_2.add(textField_24);
		
		btnNewButton_7 = new JButton("Search Card Record");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.revalidate();
				panel_2.repaint(); 
				panel_2.removeAll();
				
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
		btnNewButton_7.setBounds(254, 61, 195, 30);
		Panel_2.add(btnNewButton_7);
		
		lblNewLabel_2_1_1_1_1_7 = new JLabel("Stock");
		lblNewLabel_2_1_1_1_1_7.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1_7.setBounds(758, 218, 48, 19);
		Panel_2.add(lblNewLabel_2_1_1_1_1_7);
		
		textField_25 = new JTextField();
		textField_25.setHorizontalAlignment(SwingConstants.CENTER);
		textField_25.setColumns(10);
		textField_25.setBounds(809, 213, 86, 24);
		Panel_2.add(textField_25);
		
		btnNewButton_9 = new JButton("Returning");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bno = textField_17.getText();
				String cno = textField_26.getText();
				String return_time = textField_8.getText();
				if(borrowManage.return_record(bno, cno,return_time))//更新borrow表
				borrowManage.return_book(bno);//更新书表
				
			}
		});
		btnNewButton_9.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_9.setBounds(67, 583, 110, 30);
		Panel_2.add(btnNewButton_9);
		
		lblNewLabel_2_1_1_1_1_8 = new JLabel(" CardID");
		lblNewLabel_2_1_1_1_1_8.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1_8.setBounds(37, 67, 62, 19);
		Panel_2.add(lblNewLabel_2_1_1_1_1_8);
		
		textField_26 = new JTextField();
		textField_26.setColumns(10);
		textField_26.setBounds(109, 66, 120, 24);
		Panel_2.add(textField_26);
		
		lblNewLabel_5 = new JLabel("BOOK INFORMATION");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_5.setBounds(418, 131, 197, 21);
		Panel_2.add(lblNewLabel_5);
		
		panel_2 = new JPanel();
		panel_2.setBounds(10, 282, 1000, 264);
		Panel_2.add(panel_2);
		tabbedPane.addTab("CardManger", Panel_3);
		Panel_3.setLayout(null);
	
		panel = new JPanel();
		//panel.setBackground(Color.WHITE);
		panel.setBounds(216, 10, 800, 597);
		Panel_3.add(panel);
		
		btnNewButton_2 = new JButton("Show All");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.revalidate();
				panel.repaint(); 
				panel.removeAll();
				ArrayList<Card> cards = studentManage.show_stu();
				Object[][] rowDatas = studentManage.data(cards);
				String[] columnNames = {"CardID","Name","Department","Type","Password"};
				DefaultTableModel tableModel = new DefaultTableModel(rowDatas, columnNames);
				JTable table = new JTable(tableModel);
				RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);
				table.setRowSorter(sorter);
				//tableModel.setDataVector(rowDatas, columnNames);
	    		panel.add(table.getTableHeader());
    			panel.add(table);
    			table.setPreferredScrollableViewportSize(new Dimension(750, 550));
    			table.setFont(new Font("Monospaced", Font.PLAIN, 14));
    			table.setBounds(40, 70, 500, 370);
    			JScrollPane scrollPane = new JScrollPane(table);
    			panel.add(scrollPane);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_2.setBounds(44, 24, 135, 27);
		Panel_3.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Add Card");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStudent addstu = new addStudent();
				addstu.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_3.setBounds(47, 258, 135, 27);
		Panel_3.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Delete Card");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deleteStudent deletestudent = new deleteStudent();
				deletestudent.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_4.setBounds(44, 140, 135, 27);
		Panel_3.add(btnNewButton_4);
		Panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Warehuse");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel.setBounds(396, 61, 209, 21);
		Panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Title");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(449, 230, 76, 21);
		Panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(493, 228, 290, 24);
		Panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(297, 175, 122, 24);
		Panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2_2 = new JLabel("Press");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(449, 286, 48, 19);
		Panel.add(lblNewLabel_2_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(493, 283, 290, 24);
		Panel.add(textField_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Year");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setBounds(449, 338, 32, 19);
		Panel.add(lblNewLabel_2_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(493, 335, 100, 24);
		Panel.add(textField_3);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Author");
		lblNewLabel_2_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1.setBounds(216, 286, 56, 19);
		Panel.add(lblNewLabel_2_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(297, 283, 122, 24);
		Panel.add(textField_4);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Price");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1.setBounds(216, 338, 42, 19);
		Panel.add(lblNewLabel_2_1_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(297, 335, 122, 24);
		Panel.add(textField_5);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Amount");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1_1.setBounds(625, 338, 66, 19);
		Panel.add(lblNewLabel_2_1_1_1_1_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(683, 335, 100, 24);
		Panel.add(textField_6);
		
		JLabel lblNewLabel_2_1_1_1_1_2 = new JLabel("BookID");
		lblNewLabel_2_1_1_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1_1_1_1_2.setBounds(211, 178, 76, 19);
		Panel.add(lblNewLabel_2_1_1_1_1_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Category");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(214, 231, 86, 19);
		Panel.add(lblNewLabel_2_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(297, 228, 122, 24);
		Panel.add(textField_7);
		
		JButton btnNewButton = new JButton("Warehuse");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String title = textField.getText();
				String category = textField_7.getText();
				String press = textField_2.getText();
				int year = Integer.parseInt(textField_3.getText());
				String author = textField_4.getText();
				float price = Float.parseFloat(textField_5.getText());
				int total = Integer.parseInt(textField_6.getText());//要入库的数量
				int stock = total;//库存就是入库数量
				String bno = textField_1.getText();
				Book book = new Book(bno,category,title,press,year,author,price,total,stock);
				
				if(textField_14.getText().equals("Books have been in library"))//已有图书
					bookManage.add_old_book(bno,total);
				else {
					System.out.println("new book");
					bookManage.add_book(book);}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setBounds(320, 433, 139, 30);
		Panel.add(btnNewButton);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(556, 175, 227, 24);
		Panel.add(textField_14);
		// 查询已有图书记录
		
		btnNewButton_6 = new JButton("Search");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bno = textField_1.getText();
				Book book = bookManage.select_book(bno);
				textField_14.setText("");
				textField_6.setText("");
				if(book !=null) {//原来有这本书
				textField.setText(book.get_title());
				textField_7.setText(book.get_category());
				textField_2.setText(book.get_press());
				textField_3.setText(String.valueOf(book.get_year()));
				textField_4.setText(book.get_author());
				textField_5.setText(String.valueOf(book.get_price()));
				textField_6.setText("");//要入库的数量
				textField_14.setText("Books have been in library");
				}
				else {
					textField.setText("");
					textField_7.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");	
				textField_14.setText("Books have not been in library.");}
				
			}
		});
		btnNewButton_6.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_6.setBounds(449, 172, 97, 30);
		Panel.add(btnNewButton_6);
		
		JLabel lblPleaseInputBookid = new JLabel("Please input BookID firstly and click 'Search'");
		lblPleaseInputBookid.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblPleaseInputBookid.setBounds(362, 92, 286, 46);
		Panel.add(lblPleaseInputBookid);
		
		JButton btnNewButton_7_1 = new JButton("Search Book Record");
		btnNewButton_7_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_2.revalidate();
				panel_2.repaint(); 
				panel_2.removeAll();
				String bno = textField_17.getText();
				ArrayList<BorrowRecord> records=null;
				Book book = bookManage.select_book2(bno);
				try {
					records = borrowManage.borrowRecord(bno);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				textField_18.setText(book.get_title());
				textField_19.setText(book.get_category());
				textField_20.setText(book.get_press());
				textField_21.setText(String.valueOf(book.get_year()));
				textField_22.setText(book.get_author());
				textField_23.setText(String.valueOf(book.get_price()));
				textField_24.setText(String.valueOf(book.get_total()));
				textField_25.setText(String.valueOf(book.get_stock()));
				Object[][] rowDatas = borrowManage.data2(records);
				String[] columnNames = {"AdminID","CardID","BorrowTime","ReturnTime","ReturnDeadline"};
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
		btnNewButton_7_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_7_1.setBounds(756, 61, 195, 30);
		Panel_2.add(btnNewButton_7_1);
		
		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textField_8.setColumns(10);
		//textField_8.setText("2021-06-25");
		textField_8.setBounds(447, 588, 132, 24);
		Panel_2.add(textField_8);
		
		lblNewLabel_1 = new JLabel("Date");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(377, 589, 32, 19);
		Panel_2.add(lblNewLabel_1);
		
		btnNewButton_5 = new JButton("Exit");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainView.this.setVisible(false);
				LoginFrame loginframe = new LoginFrame("Login");
				loginframe.setVisible(true);
				
				
			}
		});
		btnNewButton_5.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton_5.setBounds(476, 449, 80, 27);
		Panel_5.add(btnNewButton_5);
		
		JButton btnNewButton_1 = new JButton("From File");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_1.setBounds(591, 433, 139, 30);
		Panel.add(btnNewButton_1);
		
		JLabel background = new JLabel();
		background.setEnabled(false);
		background.setToolTipText("");
		background.setIcon(icon);
		background.setBounds(0, -30, icon.getIconWidth(), icon.getIconHeight());
		Panel_5.add(background);
		

		
		JLabel background2 = new JLabel();
		background2.setEnabled(false);
		background2.setToolTipText("");
		background2.setIcon(icon);
		background2.setBounds(0, -30, icon.getIconWidth(), icon.getIconHeight());
		Panel_1.add(background2);

		JLabel background3 = new JLabel();
		background3.setEnabled(false);
		background3.setToolTipText("");
		background3.setIcon(icon);
		background3.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		Panel_2.add(background3);
		

		
		JLabel background4 = new JLabel();
		background4.setEnabled(false);
		background4.setToolTipText("");
		background4.setIcon(icon);
		background4.setBounds(0, -30, icon.getIconWidth(), icon.getIconHeight());
		Panel_3.add(background4);

		JLabel background6 = new JLabel();
		background6.setEnabled(false);
		background6.setToolTipText("");
		background6.setIcon(icon);
		background6.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		Panel.add(background6);
		

		

		
		
	}
}
