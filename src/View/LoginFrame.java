package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DBConnect.Administratoe;
import DBConnect.bookDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JFormattedTextField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField_UserName;
	private JPasswordField passwordField;

	public LoginFrame(String title) {
		super(title);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon=new ImageIcon(LoginFrame.class.getResource("/Images/logo2.jpg"));
		setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserType_1 = new JLabel("Library Management System\r\n");
		lblUserType_1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblUserType_1.setBounds(340, 170, 383, 33);
		contentPane.add(lblUserType_1);
		
		JLabel lblUserType_2 = new JLabel("Made by Zhongyue Zhang, ZheJiang University\n");
		lblUserType_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUserType_2.setBounds(380, 582,313,93);
		contentPane.add(lblUserType_2);

		JLabel lblUserType = new JLabel("User Type:");
		lblUserType.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblUserType.setBounds(309, 290+60, 106, 33);
		contentPane.add(lblUserType);
		
		JLabel lblNewLabel = new JLabel("User ID:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(309, 170+60, 106, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblPasswords = new JLabel("Password:");
		lblPasswords.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPasswords.setBounds(309, 230+60, 106, 33);
		contentPane.add(lblPasswords);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("STUDENT");
		rdbtnNewRadioButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnNewRadioButton.setBackground(SystemColor.controlHighlight);
		rdbtnNewRadioButton.setBounds(432, 290+60, 99, 27);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("ADMIN");
		rdbtnNewRadioButton_1.setBackground(SystemColor.controlHighlight);
		rdbtnNewRadioButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnNewRadioButton_1.setBounds(550, 290+60, 79, 27);
		contentPane.add(rdbtnNewRadioButton_1);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		
		textField_UserName = new JTextField();
		textField_UserName.setBounds(432, 176+60, 230, 24);
		contentPane.add(textField_UserName);
		textField_UserName.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(432, 234+60, 230, 24);
		contentPane.add(passwordField);
		
		JButton btn_SIGNIN = new JButton("SIGN IN\r\n");
		btn_SIGNIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userid = textField_UserName.getText();
				String password = passwordField.getText();        		
            	if(rdbtnNewRadioButton.isSelected()) {
            		// Student Login
            		String cname = bookDAO.loginJudge(userid, password);
            		if(cname!=null) {
                		System.out.println("Student Login");
                		JOptionPane.showMessageDialog(LoginFrame.this, "You have successfully signed in.\n"+"Welcome "+cname,"",JOptionPane.INFORMATION_MESSAGE);
                		StudentFrame studentFrame = new StudentFrame("Library-Student-"+cname,userid);
                		studentFrame.setVisible(true);
                		LoginFrame.this.setVisible(false);
            		}else {
    					JOptionPane.showMessageDialog(LoginFrame.this, "The login request you submitted is invalid.Please try again.","",JOptionPane.ERROR_MESSAGE);
    				}
            	}else {
            	Administratoe aname = bookDAO.loginJudge_admin(userid, password);
            		if(aname!=null) {
            			// Administrator Login
                		System.out.println("Administrator Login");
                		JOptionPane.showMessageDialog(LoginFrame.this, "You have successfully signed in.\n"+"Welcome "+aname.getAname(),"",JOptionPane.INFORMATION_MESSAGE);
                		MainView mainView = new MainView(aname,"Library-administrator-"+aname.getAname());
                		mainView.setVisible(true);
                		LoginFrame.this.setVisible(false);
            		}else {
    					JOptionPane.showMessageDialog(LoginFrame.this, "The login request you submitted is invalid.Please try again.","",JOptionPane.ERROR_MESSAGE);
    				}	
            	}
			}
		});
		btn_SIGNIN.setBackground(new Color(240, 240, 240));
		btn_SIGNIN.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btn_SIGNIN.setBounds(390, 350+60, 106, 33);
		contentPane.add(btn_SIGNIN);
		
		JButton btn_CANCEL = new JButton("CANCEL");
		btn_CANCEL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_UserName.setText("");
				passwordField.setText("");	
			}
		});
		btn_CANCEL.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btn_CANCEL.setBackground(SystemColor.menu);
		btn_CANCEL.setBounds(530, 350+60, 120, 33);
		contentPane.add(btn_CANCEL);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setEnabled(false);
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setIcon(icon);
		lblNewLabel_1.setBounds(0, -30, icon.getIconWidth(), icon.getIconHeight());
		contentPane.add(lblNewLabel_1);
		
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame("Login");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}
