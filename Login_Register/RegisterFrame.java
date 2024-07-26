package Login_Register;

import java.awt.EventQueue;  

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class RegisterFrame {
	private int xMouse, yMouse;
	public JFrame Regframe;
	private JTextField TxtFname;
	private JTextField TxtSname;
	private JTextField TxtAge;
	private JTextField TxtEmail;
	private JTextField TxtPnum;
	private JTextField TxtUname;
	private JPasswordField passwordField;
	private JButton btnRegister;
	private JButton btnClear;
	private JComboBox cbCourse;
	private JComboBox cbYLevel;
	public static String IDnum = "";
	private JTextField TxtIDnum;
	private JComboBox cbSem;
	static String Fname=" ", Sname=" ", Email = " " , Age = " ", YrLevel = " ", 
				  Course = " ", Uname = " ", Pword =" ", Pnumber=" ", Semester = " ";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		IDgenerator();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame window = new RegisterFrame();
					window.Regframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterFrame() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		IDgenerator();
		Regframe = new JFrame();
		Regframe.getContentPane().setForeground(SystemColor.text);
		Regframe.getContentPane().setBackground(SystemColor.textHighlight);
		Regframe.setBounds(300, 100, 680, 396);
		Regframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Regframe.getContentPane().setLayout(null);
		Regframe.setTitle("Registration Form");
		
		JLabel lblRegistration = new JLabel("Registration Form");
		lblRegistration.setForeground(SystemColor.text);
		lblRegistration.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration.setBounds(220, 86, 301, 28);
		Regframe.getContentPane().add(lblRegistration);
		
		JLabel lblName = new JLabel("First Name");
		lblName.setForeground(SystemColor.text);
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblName.setBounds(24, 172, 92, 20);
		Regframe.getContentPane().add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setForeground(SystemColor.text);
		lblSurname.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblSurname.setBounds(24, 207, 75, 20);
		Regframe.getContentPane().add(lblSurname);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(SystemColor.text);
		lblAge.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblAge.setBounds(24, 242, 46, 20);
		Regframe.getContentPane().add(lblAge);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(SystemColor.text);
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblEmail.setBounds(24, 277, 46, 20);
		Regframe.getContentPane().add(lblEmail);
		
		JLabel lblPhoneNum = new JLabel("Phone Number");
		lblPhoneNum.setForeground(SystemColor.text);
		lblPhoneNum.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblPhoneNum.setBounds(24, 312, 123, 20);
		Regframe.getContentPane().add(lblPhoneNum);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setForeground(SystemColor.text);
		lblCourse.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblCourse.setBounds(327, 136, 54, 20);
		Regframe.getContentPane().add(lblCourse);
		
		JLabel lblYrLevel = new JLabel("Year Level");
		lblYrLevel.setForeground(SystemColor.text);
		lblYrLevel.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblYrLevel.setBounds(327, 171, 90, 20);
		Regframe.getContentPane().add(lblYrLevel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(SystemColor.text);
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblUsername.setBounds(327, 239, 80, 20);
		Regframe.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(SystemColor.text);
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblPassword.setBounds(327, 273, 80, 20);
		Regframe.getContentPane().add(lblPassword);
		
		TxtFname = new JTextField();
		TxtFname.setBounds(161, 164, 146, 28);
		Regframe.getContentPane().add(TxtFname);
		TxtFname.setColumns(10);
		
		TxtSname = new JTextField();
		TxtSname.setColumns(10);
		TxtSname.setBounds(161, 199, 146, 28);
		Regframe.getContentPane().add(TxtSname);
		
		TxtAge = new JTextField();
		TxtAge.setColumns(10);
		TxtAge.setBounds(161, 234, 146, 28);
		Regframe.getContentPane().add(TxtAge);
		
		TxtEmail = new JTextField();
		TxtEmail.setColumns(10);
		TxtEmail.setBounds(161, 269, 146, 28);
		Regframe.getContentPane().add(TxtEmail);
		
		TxtPnum = new JTextField();
		TxtPnum.setColumns(10);
		TxtPnum.setBounds(161, 304, 146, 28);
		Regframe.getContentPane().add(TxtPnum);
		
		TxtUname = new JTextField();
		TxtUname.setColumns(10);
		TxtUname.setBounds(427, 232, 196, 28);
		Regframe.getContentPane().add(TxtUname);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(427, 266, 196, 28);
		Regframe.getContentPane().add(passwordField);
		
		btnRegister = new JButton("Register");
		btnRegister.setBorder(null);
		btnRegister.setBackground(SystemColor.text);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Fname = TxtFname.getText();
				 Sname = TxtSname.getText();
				 Email = TxtEmail.getText();
				 Age = TxtAge.getText();
				 YrLevel = cbYLevel.getSelectedItem().toString();
				 Course = cbCourse.getSelectedItem().toString();
				 Uname = TxtUname.getText();
				 Pword =  passwordField.getText();
				 Pnumber = TxtPnum.getText();
				 IDnum = TxtIDnum.getText();	
				 Semester = cbSem.getSelectedItem().toString();
				 pushData();
				 JOptionPane.showMessageDialog(null, "Successful Registration");
					Login_Register lr = new Login_Register();
					lr.frame.setVisible(true);
					Regframe.dispose();
			}
		});
		btnRegister.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnRegister.setBounds(422, 311, 97, 36);
		Regframe.getContentPane().add(btnRegister);
		
		btnClear = new JButton("Refresh");
		btnClear.setBorder(null);
		btnClear.setBackground(SystemColor.text);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText(null);
				TxtUname.setText(null);
				TxtPnum.setText(null);
				TxtEmail.setText(null);
				TxtAge.setText(null);
				TxtSname.setText(null);
				TxtFname.setText(null);
				cbCourse.setSelectedItem("Select Course");
				cbYLevel.setSelectedItem("Select Year Level ");
			}
		});
		btnClear.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnClear.setBounds(529, 311, 94, 36);
		Regframe.getContentPane().add(btnClear);
		
		cbCourse = new JComboBox();
		cbCourse.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cbCourse.setModel(new DefaultComboBoxModel(new String[] {"Select Course", "BS in Computer Science", "BS in Information techology", "BS in Information System", "BS in Business Administration", "BS in Business Accountancy"}));
		cbCourse.setBounds(427, 129, 196, 28);
		Regframe.getContentPane().add(cbCourse);
		
		cbYLevel = new JComboBox();
		cbYLevel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cbYLevel.setModel(new DefaultComboBoxModel(new String[] {"Select Year Level ", "1st Year", "2nd Year", "3rd Year", "4th Year"}));
		cbYLevel.setBounds(427, 164, 196, 28);
		Regframe.getContentPane().add(cbYLevel);	
		
		JLabel lblIDnum = new JLabel("ID Number");
		lblIDnum.setForeground(SystemColor.text);
		lblIDnum.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblIDnum.setBounds(24, 137, 127, 20);
		Regframe.getContentPane().add(lblIDnum);
		
		TxtIDnum = new JTextField();
		TxtIDnum.setEditable(false);
		TxtIDnum.setBackground(new Color(255, 255, 255));
		TxtIDnum.setColumns(10);
		TxtIDnum.setBounds(161, 129, 146, 28);
		TxtIDnum.setText(IDnum);
		Regframe.getContentPane().add(TxtIDnum);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 704, 72);
		Regframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("src\\logoReg.jpg"));
		lblNewLabel.setBounds(148, 0, 72, 72);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New Era University");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblNewLabel_1.setBounds(249, 11, 269, 50);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				Regframe.setLocation(x-xMouse, y-yMouse);
			}	
		});
		panel_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		panel_1.setBackground(SystemColor.text);
		panel_1.setBounds(0, 0, 680, 32);
		panel.add(panel_1);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setForeground(Color.WHITE);
		lblSemester.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblSemester.setBounds(327, 206, 80, 20);
		Regframe.getContentPane().add(lblSemester);
		
		cbSem = new JComboBox();
		cbSem.setModel(new DefaultComboBoxModel(new String[] {"Select Semester", "1st Semester", "2nd Semester", "Summer"}));
		cbSem.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		cbSem.setBounds(427, 199, 196, 28);
		Regframe.getContentPane().add(cbSem);
	}
	public static void IDgenerator(){
		Random random = new Random();
		StringBuilder studentID = new StringBuilder();
		for (int i = 0; i < 2; i++) {
			studentID.append(random.nextInt(10));
		}
		studentID.append("-");
		for (int i = 0; i < 5; i++) {
			studentID.append(random.nextInt(10));
		}
		studentID.append("-");
		for (int i = 0; i < 3; i++) {
			studentID.append(random.nextInt(10));
		}
		IDnum = studentID.toString();
}
	public static void pushData() {
		String databaseUrl = "jdbc:ucanaccess://RegDatabase.accdb";
		try {
			Connection connection = DriverManager.getConnection(databaseUrl);
			Statement stm = connection.createStatement();
			String StudInfo = "INSERT INTO StudentInfo (IDnum, Lname, Fname, Age, Email, Pnum, Status) VALUES"+
			"('"+IDnum+"', '"+Sname+"', '"+Fname+"', '"+Age+"', '"+Email+"', '"+Pnumber+"', 'Enrolled' )";
			stm.executeUpdate(StudInfo);
			
			String AccData = "INSERT INTO AccountData (IDnum, Username, Password) VALUES"+
			"('"+IDnum+"', '"+Uname+"', '"+Pword+"')";
			stm.executeUpdate(AccData);
			
			String CourseData = "INSERT INTO CourseData (IDnum, Course, YLevel, Sem) VALUES"+
			"('"+IDnum+"', '"+Course+"', '"+YrLevel+"', '"+Semester+"' )";
			stm.executeUpdate(CourseData);
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
