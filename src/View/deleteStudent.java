package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DBConnect.Card;
import manage.studentManage;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class deleteStudent extends JFrame {

	private JPanel contentPane;
	private JTextField textField_pwd;
	private JTextField textField_dpt;
	private JTextField textField_no;
	private JTextField textField_name;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteStudent frame = new deleteStudent();
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
	public deleteStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_pwd = new JTextField();
		textField_pwd.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textField_pwd.setColumns(10);
		textField_pwd.setBounds(239, 306, 220, 24);
		contentPane.add(textField_pwd);
		
		textField_dpt = new JTextField();
		textField_dpt.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textField_dpt.setColumns(10);
		textField_dpt.setBounds(239, 261, 220, 24);
		contentPane.add(textField_dpt);
		
		JLabel lblNewLabel = new JLabel("CardID");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel.setBounds(127, 126, 50, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(127, 171, 44, 18);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Department");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(127, 262, 88, 23);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Password");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_1_2.setBounds(127, 307, 88, 18);
		contentPane.add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("Delete Card");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblNewLabel_2.setBounds(246, 47, 155, 50);
		contentPane.add(lblNewLabel_2);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Monospaced", Font.PLAIN, 16));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Undergraduate", "Graduate", "Teacher", "Other"}));
		comboBox.setBounds(239, 211, 220, 23);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String no = textField_no.getText();
				Card card = null;
				card = studentManage.select_stu(no);
				if(card!=null) {
				textField_name.setText(card.get_cname());
				textField_dpt.setText(card.get_dpt());
				textField_pwd.setText(card.get_pwd());
				comboBox.setSelectedIndex(card.get_type());}
				else {
					textField_no.setText(null);
					textField_name.setText(null);
					textField_dpt.setText(null);
					textField_pwd.setText(null);
					comboBox.setSelectedIndex(0);
				}
					
				
				//deleteStudent.this.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton.setBounds(469, 122, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_no.setText(null);
				textField_name.setText(null);
				textField_dpt.setText(null);
				textField_pwd.setText(null);
				comboBox.setSelectedIndex(0);

			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_1.setBounds(277, 384, 113, 27);
		contentPane.add(btnNewButton_1);
		
		textField_no = new JTextField();
		textField_no.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textField_no.setColumns(10);
		textField_no.setBounds(239, 122, 220, 24);
		contentPane.add(textField_no);
		
		textField_name = new JTextField();
		textField_name.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textField_name.setColumns(10);
		textField_name.setBounds(239, 164, 220, 24);
		contentPane.add(textField_name);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Type");
		lblNewLabel_1_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblNewLabel_1_1_3.setBounds(127, 216, 44, 18);
		contentPane.add(lblNewLabel_1_1_3);
		
		JButton btnNewButton_1_1 = new JButton("Delete");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String no = textField_no.getText();
				studentManage.delete_stu(no);
				textField_no.setText(null);
				textField_name.setText(null);
				textField_dpt.setText(null);
				textField_pwd.setText(null);
				comboBox.setSelectedIndex(0);
			}
		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(127, 384, 113, 27);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("Exist");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteStudent.this.setVisible(false);
			}
		});
		btnNewButton_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnNewButton_1_2.setBounds(419, 384, 113, 27);
		contentPane.add(btnNewButton_1_2);
	}
}
