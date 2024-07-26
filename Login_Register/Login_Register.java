package Login_Register;
import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
import java.awt.EventQueue;  
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.JCheckBox;
import java.awt.event.MouseMotionAdapter;
public class Login_Register {

	public JFrame frame;
	private JPasswordField txtPassword;
	private JTextField txtUsername;
	static String IDnum = " ";
	static String status = " ", course = " ",  yr = " ", Name=" ", Lname=" ", Sem = " ", CS = "BS in Computer Science", Uname =" ";
	private int xMouse, yMouse;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Register window = new Login_Register();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login_Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.setBounds(200, 200, 650, 363);
		frame.getContentPane().setLayout(null);
		frame.setTitle("New Era University Login");
		
		txtPassword = new JPasswordField("Password");
		txtPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPassword.setText(null);
			}
		});
		txtPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		txtPassword.setBorder(null);
		txtPassword.setForeground(SystemColor.window);
		txtPassword.setBackground(SystemColor.textHighlight);
		txtPassword.setBounds(384, 153, 205, 30);
		frame.getContentPane().add(txtPassword);
		
		txtUsername = new JTextField();
		txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Uname = txtUsername.getText();
				if(Uname.equals("Username")) {
					txtUsername.setText(null);
				}
				else {
					
				}
			}
		});
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 16));
		txtUsername.setBorder(null);
		txtUsername.setForeground(SystemColor.window);
		txtUsername.setBackground(SystemColor.textHighlight);
		txtUsername.setText("Username");
		txtUsername.setBounds(384, 116, 205, 30);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		
		JButton btnLogin = new JButton("Sign In");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String databaseUrl = "jdbc:ucanaccess://RegDatabase.accdb";
				String user =" ",  pw = " ", ID = " ";
				try {
					Connection con = DriverManager.getConnection(databaseUrl);
					String Uname = txtUsername.getText();
					String passw = txtPassword.getText();
					
					
					Statement stm = con.createStatement();
					String sql ="SELECT s.IDnum, s.Fname, s.Lname, s.Status, a.Username, a.Password, c.Course, c.YLevel, c.Sem FROM (StudentInfo s  LEFT JOIN AccountData a ON s.IDnum = a.IDnum) LEFT JOIN CourseData c ON s.IDnum = c.IDnum WHERE Username='"+Uname+"' and Password = '"+passw+"'";
					ResultSet rs = stm.executeQuery(sql);
					
					while (rs.next()) {
						user = rs.getString("Username");
						pw = rs.getString("Password");
						IDnum = rs.getString("IDnum");
						yr = rs.getString("YLevel");
						course = rs.getString("Course");
						status = rs.getString("Status");
						Name = rs.getString("Fname");
						Lname = rs.getString("Lname");
						Sem = rs.getString("Sem");
					}
					
					
					/*String sql2 = "SELECT s.IDnum, s.Fname, s.Lname, s.Status, c.Sem, c.YLevel, c.Course FROM StudentInfo s LEFT JOIN CourseData c ON s.IDnum = c.IDnum WHERE s.IDnum =" + "('" +IDnum+ "')";
					ResultSet rss = stm.executeQuery(sql2);
					while (rss.next()) {
						yr = rss.getString("YLevel");
						course = rss.getString("Course");
						status = rss.getString("Status");
						Name = rss.getString("Fname");
						Lname = rss.getString("Lname");
						Sem = rss.getString("Sem");
					}*/
					
					if(Uname.equals(user) && passw.equals(pw)) {
						if(course.equals(CS)) {
							CSForm cs = new CSForm();
							cs.CSframe.setVisible(true);
							
							frame.dispose();
					}
						else {
							JOptionPane.showMessageDialog(null, "Course not available");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Username or Password wrong...");
						txtUsername.setText("");
						txtPassword.setText("");
					}
					
					
					
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
					e1.printStackTrace();
				}
				
			}
		});
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 14));
		btnLogin.setBackground(SystemColor.window);
		btnLogin.setBorder(null);
		btnLogin.setBounds(397, 223, 178, 23);
		frame.getContentPane().add(btnLogin);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.window);
		separator.setBounds(383, 147, 206, 2);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(384, 183, 205, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel lblUser = new JLabel("");
		lblUser.setAutoscrolls(true);
		lblUser.setIcon(new ImageIcon("src\\icons8-user-30.png"));
		lblUser.setBounds(350, 115, 30, 40);
		frame.getContentPane().add(lblUser);
		
		JLabel lblPass = new JLabel("");
		lblPass.setIcon(new ImageIcon("src\\icons8-password-30.png"));
		lblPass.setAutoscrolls(true);
		lblPass.setBounds(350, 153, 30, 40);
		frame.getContentPane().add(lblPass);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setBounds(0, 0, 321, 331);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(41, 11, 244, 240);
		lblLogo.setIcon(new ImageIcon("src\\New_Era_University.svg"));
		panel.add(lblLogo);
		
		JLabel lblUlogo = new JLabel("New Era University");
		lblUlogo.setBorder(null);
		lblUlogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblUlogo.setFont(new Font("Times New Roman", Font.PLAIN, 37));
		lblUlogo.setBounds(10, 262, 301, 42);
		panel.add(lblUlogo);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				frame.setLocation(x-xMouse, y-yMouse);
			}
		});
		panel_1.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(null);
		panel_1.setBounds(0, 0, 321, 42);
		panel.add(panel_1);
		
		JLabel lblTitle = new JLabel("WELCOME TO STUDENT PORTAL");
		lblTitle.setForeground(SystemColor.window);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblTitle.setBounds(331, 53, 293, 40);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblNewLabel = new JLabel("New User? Click here to Register");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegisterFrame rf = new RegisterFrame();
				rf.Regframe.setVisible(true);
				rf.IDgenerator();
				frame.dispose();		
			}
		});
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(390, 257, 199, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(SystemColor.window);
		separator_2.setBounds(390, 285, 191, 2);
		frame.getContentPane().add(separator_2);
		
		JCheckBox chckbxShowPw = new JCheckBox("Show Password");
		chckbxShowPw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxShowPw.isSelected()) {
					txtPassword.setEchoChar((char)0);
				}
				else {
					txtPassword.setEchoChar('*');
				}
			}
		});
		chckbxShowPw.setFont(new Font("Arial", Font.PLAIN, 14));
		chckbxShowPw.setBorder(null);
		chckbxShowPw.setBackground(SystemColor.textHighlight);
		chckbxShowPw.setBounds(397, 193, 178, 23);
		frame.getContentPane().add(chckbxShowPw);
		
	}

	public void Goto () {
		if(course.equals(CS)) {
			CSForm cs = new CSForm();
			cs.CSframe.setVisible(true);
			frame.dispose();
		}
	}
}
