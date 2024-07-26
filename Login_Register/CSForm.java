package Login_Register;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.JViewport;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CSForm {

	public JFrame CSframe;
	private JPanel panel;
	private int xMouse, yMouse;
	Point mousePosition = new Point();
	public static String ID = " ";
	public static String status = " ", course = " ",  yr = " ", Name=" ", Lname=" ", Sem = " ";
	static JLabel lbIDnum, lblLname, lblCours, lblStat, lblYr, lblSemes;
	static Login_Register lr = new Login_Register();
 public	JScrollBar scrollBar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		ID = lr.IDnum;	
		//getInfo();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CSForm window = new CSForm();
					window.CSframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void getInfo() {
		String databaseUrl = "jdbc:ucanaccess://RegDatabase.accdb";
		try {
			Connection con = DriverManager.getConnection(databaseUrl);
			Statement stm = con.createStatement();
			String sql2 = "SELECT s.IDnum, s.Fname, s.Lname, s.Status, c.Sem, c.YLevel, c.Course FROM StudentInfo s LEFT JOIN CourseData c ON s.IDnum = c.IDnum WHERE s.IDnum =" + "('" +lr.IDnum+ "')";
			ResultSet rss = stm.executeQuery(sql2);
			while (rss.next()) {
				yr = rss.getString("YLevel");
				course = rss.getString("Course");
				status = rss.getString("Status");
				Name = rss.getString("Fname");
				Lname = rss.getString("Lname");
				Sem = rss.getString("Sem");
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public CSForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		CSframe = new JFrame();
		CSframe.setBounds(100, 100, 850, 789);
		CSframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CSframe.setTitle("Course List");
		
		panel = new JPanel();
		panel.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				scrollBar.setValue(scrollBar.getValue()+e.getWheelRotation());
			}
		});
		panel.addMouseMotionListener(new MouseMotionAdapter() {

			public void mouseDragged(MouseEvent e) {
				int diffX = e.getX() - mousePosition.x;
				int diffY = e.getY() - mousePosition.y;
				mousePosition = e.getPoint();
				scrollBar.setValue(scrollBar.getValue()-diffY);
				
			}
			public void mouseMoved(MouseEvent e) {}
		});
		panel.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				mousePosition = new Point();
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				mousePosition = new Point();
			}
			public void mouseClicked(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		CSframe.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(30, 73, 46, 28);
		lblName.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblName);
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setBounds(30, 130, 59, 28);
		lblCourse.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblCourse);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(370, 73, 48, 28);
		lblStatus.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblStatus);
		
		JLabel lblYLevel = new JLabel("Year: ");
		lblYLevel.setBounds(370, 103, 40, 28);
		lblYLevel.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblYLevel);
		
		JLabel lblSem = new JLabel("Semester:");
		lblSem.setBounds(370, 130, 70, 28);
		lblSem.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblSem);
		
		JLabel lblNewLabel = new JLabel("SUBJECT LIST");
		lblNewLabel.setBounds(339, 169, 99, 14);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SUBJECT CODE");
		lblNewLabel_1.setBounds(21, 219, 120, 14);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblNewLabel_1);
		
		JLabel lblIdNumber = new JLabel("ID Number:");
		lblIdNumber.setBounds(30, 103, 81, 28);
		lblIdNumber.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblIdNumber);
		
		JLabel lblNewLabel_1_1 = new JLabel("SUBJECT TITLE");
		lblNewLabel_1_1.setBounds(159, 219, 120, 14);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("1ST YEAR, 1ST SEM");
		lblNewLabel_1_2.setBounds(21, 194, 151, 14);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("CCC111-18             Introduction to Computing 1 Lec");
		lblNewLabel_1_3.setBounds(23, 243, 354, 14);
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("CCL111-18");
		lblNewLabel_1_4.setBounds(23, 280, 120, 14);
		lblNewLabel_1_4.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Introduction to Computing 1 (Lab)");
		lblNewLabel_1_4_1.setBounds(159, 280, 235, 14);
		lblNewLabel_1_4_1.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("CCL112-18");
		lblNewLabel_1_4_2.setBounds(23, 298, 120, 14);
		lblNewLabel_1_4_2.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_4_2);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Fundamentals of Programming (Lab)");
		lblNewLabel_1_4_1_1.setBounds(159, 298, 242, 14);
		lblNewLabel_1_4_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_4_1_1);
		
		JLabel lblNewLabel_1_4_2_1 = new JLabel("CCS113-18");
		lblNewLabel_1_4_2_1.setBounds(23, 317, 120, 14);
		lblNewLabel_1_4_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_4_2_1);
		
		JLabel lblNewLabel_1_4_1_1_1 = new JLabel("Calculus for non-STEM");
		lblNewLabel_1_4_1_1_1.setBounds(159, 317, 242, 14);
		lblNewLabel_1_4_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_4_1_1_1);
		
		JLabel lblNewLabel_1_4_2_1_1 = new JLabel("GECETH-18");
		lblNewLabel_1_4_2_1_1.setBounds(23, 336, 120, 14);
		lblNewLabel_1_4_2_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_4_2_1_1);
		
		JLabel lblNewLabel_1_4_1_1_1_1 = new JLabel("Ethics");
		lblNewLabel_1_4_1_1_1_1.setBounds(159, 336, 242, 14);
		lblNewLabel_1_4_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_4_1_1_1_1);
		
		JLabel lblNewLabel_1_4_2_1_1_1 = new JLabel("GECMMW-18");
		lblNewLabel_1_4_2_1_1_1.setBounds(23, 355, 120, 14);
		lblNewLabel_1_4_2_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_4_2_1_1_1);
		
		JLabel lblNewLabel_1_4_1_1_1_1_1 = new JLabel("Mathematics in the Modern World");
		lblNewLabel_1_4_1_1_1_1_1.setBounds(159, 355, 242, 14);
		lblNewLabel_1_4_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_4_1_1_1_1_1);
		
		JLabel lblNewLabel_1_4_2_1_1_1_1 = new JLabel("GECUTS-18");
		lblNewLabel_1_4_2_1_1_1_1.setBounds(23, 375, 120, 14);
		lblNewLabel_1_4_2_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_4_2_1_1_1_1);
		
		JLabel lblNewLabel_1_4_1_1_1_1_1_1 = new JLabel("Understanding the Self");
		lblNewLabel_1_4_1_1_1_1_1_1.setBounds(159, 375, 242, 14);
		lblNewLabel_1_4_1_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_4_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_4_2_1_1_1_1_1 = new JLabel("NSTP 1");
		lblNewLabel_1_4_2_1_1_1_1_1.setBounds(23, 394, 120, 14);
		lblNewLabel_1_4_2_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_4_2_1_1_1_1_1);
		
		JLabel lblNewLabel_1_4_1_1_1_1_1_1_1 = new JLabel("National Service Training Program 1");
		lblNewLabel_1_4_1_1_1_1_1_1_1.setBounds(159, 394, 242, 14);
		lblNewLabel_1_4_1_1_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_4_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_4_2_1_1_1_1_1_1 = new JLabel("PE1 PF-18");
		lblNewLabel_1_4_2_1_1_1_1_1_1.setBounds(23, 413, 120, 14);
		lblNewLabel_1_4_2_1_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_4_2_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_4_1_1_1_1_1_1_1_1 = new JLabel("Physical Fitness");
		lblNewLabel_1_4_1_1_1_1_1_1_1_1.setBounds(159, 413, 242, 14);
		lblNewLabel_1_4_1_1_1_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_4_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_4_3 = new JLabel("CCL111-18");
		lblNewLabel_1_4_3.setBounds(23, 262, 120, 14);
		lblNewLabel_1_4_3.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_4_3);
		
		JLabel lblNewLabel_1_4_1_2 = new JLabel("Introduction to Computing 1 (Lab)");
		lblNewLabel_1_4_1_2.setBounds(159, 262, 222, 14);
		lblNewLabel_1_4_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		panel.add(lblNewLabel_1_4_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setBounds(221, 0, 68, 73);
		lblNewLabel_2.setIcon(new ImageIcon("src\\RegLogo.jpg"));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New Era University");
		lblNewLabel_3.setBounds(310, 11, 303, 49);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 34));
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("1ST YEAR, 2ND SEM");
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_2_1.setBounds(444, 194, 151, 14);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_5 = new JLabel("SUBJECT CODE");
		lblNewLabel_1_5.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_5.setBounds(444, 219, 120, 14);
		panel.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("SUBJECT TITLE");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(582, 219, 120, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("CCC121-18 ");
		lblNewLabel_1_3_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_3_1.setBounds(446, 243, 92, 14);
		panel.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_4_3_1 = new JLabel("CCC122-18");
		lblNewLabel_1_4_3_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_3_1.setBounds(446, 262, 120, 14);
		panel.add(lblNewLabel_1_4_3_1);
		
		JLabel lblNewLabel_1_4_1_2_1 = new JLabel("Data Structures and Algorithm");
		lblNewLabel_1_4_1_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_2_1.setBounds(582, 262, 222, 14);
		panel.add(lblNewLabel_1_4_1_2_1);
		
		JLabel lblNewLabel_1_4_4 = new JLabel("CCL121-18");
		lblNewLabel_1_4_4.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_4.setBounds(446, 280, 120, 14);
		panel.add(lblNewLabel_1_4_4);
		
		JLabel lblNewLabel_1_4_1_3 = new JLabel("Intermediate Programming (Lab)");
		lblNewLabel_1_4_1_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_3.setBounds(582, 280, 222, 14);
		panel.add(lblNewLabel_1_4_1_3);
		
		JLabel lblNewLabel_1_4_2_2 = new JLabel("CCL122-18\r\n");
		lblNewLabel_1_4_2_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_2_2.setBounds(446, 298, 120, 14);
		panel.add(lblNewLabel_1_4_2_2);
		
		JLabel lblNewLabel_1_4_1_1_2 = new JLabel("Data Structures and Algorithm (Lab)");
		lblNewLabel_1_4_1_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1_2.setBounds(582, 298, 242, 14);
		panel.add(lblNewLabel_1_4_1_1_2);
		
		JLabel lblNewLabel_1_4_2_1_2 = new JLabel("CCS123-18");
		lblNewLabel_1_4_2_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_2_1_2.setBounds(446, 317, 120, 14);
		panel.add(lblNewLabel_1_4_2_1_2);
		
		JLabel lblNewLabel_1_4_1_1_1_2 = new JLabel("Numerical Methods");
		lblNewLabel_1_4_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1_1_2.setBounds(582, 317, 242, 14);
		panel.add(lblNewLabel_1_4_1_1_1_2);
		
		JLabel lblNewLabel_1_4_2_1_1_2 = new JLabel("GECAAP-18");
		lblNewLabel_1_4_2_1_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_2_1_1_2.setBounds(446, 336, 120, 14);
		panel.add(lblNewLabel_1_4_2_1_1_2);
		
		JLabel lblNewLabel_1_4_1_1_1_1_2 = new JLabel("Art Appreciation");
		lblNewLabel_1_4_1_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1_1_1_2.setBounds(582, 336, 242, 14);
		panel.add(lblNewLabel_1_4_1_1_1_1_2);
		
		JLabel lblNewLabel_1_4_2_1_1_1_2 = new JLabel("GECPCO-18");
		lblNewLabel_1_4_2_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_2_1_1_1_2.setBounds(446, 355, 120, 14);
		panel.add(lblNewLabel_1_4_2_1_1_1_2);
		
		JLabel lblNewLabel_1_4_1_1_1_1_1_2 = new JLabel("Purposive Communication");
		lblNewLabel_1_4_1_1_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1_1_1_1_2.setBounds(582, 355, 242, 14);
		panel.add(lblNewLabel_1_4_1_1_1_1_1_2);
		
		JLabel lblNewLabel_1_4_2_1_1_1_1_2 = new JLabel("GECRPH-18");
		lblNewLabel_1_4_2_1_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_2_1_1_1_1_2.setBounds(446, 375, 120, 14);
		panel.add(lblNewLabel_1_4_2_1_1_1_1_2);
		
		JLabel lblNewLabel_1_4_1_1_1_1_1_1_2 = new JLabel("Readings in Philippine History");
		lblNewLabel_1_4_1_1_1_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1_1_1_1_1_2.setBounds(582, 375, 242, 14);
		panel.add(lblNewLabel_1_4_1_1_1_1_1_1_2);
		
		JLabel lblNewLabel_1_4_2_1_1_1_1_1_2 = new JLabel("KONFIL-18");
		lblNewLabel_1_4_2_1_1_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_2_1_1_1_1_1_2.setBounds(446, 394, 120, 14);
		panel.add(lblNewLabel_1_4_2_1_1_1_1_1_2);
		
		JLabel lblNewLabel_1_4_1_1_1_1_1_1_1_2 = new JLabel("Kontekstwalisadong Komunikasyon sa Filipino");
		lblNewLabel_1_4_1_1_1_1_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1_1_1_1_1_1_2.setBounds(582, 394, 242, 14);
		panel.add(lblNewLabel_1_4_1_1_1_1_1_1_1_2);
		
		JLabel lblNewLabel_1_4_2_1_1_1_1_1_1_1 = new JLabel("PE2 RA-18");
		lblNewLabel_1_4_2_1_1_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_2_1_1_1_1_1_1_1.setBounds(446, 413, 120, 14);
		panel.add(lblNewLabel_1_4_2_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_4_1_1_1_1_1_1_1_1_1 = new JLabel("Rhythmic Activities");
		lblNewLabel_1_4_1_1_1_1_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1_1_1_1_1_1_1_1.setBounds(582, 413, 242, 14);
		panel.add(lblNewLabel_1_4_1_1_1_1_1_1_1_1_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(0, 71, 850, 2);
		panel.add(separator);
		
		JLabel lblNewLabel_1_4_1_2_1_1 = new JLabel("Intermediate Programming");
		lblNewLabel_1_4_1_2_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_2_1_1.setBounds(582, 243, 222, 14);
		panel.add(lblNewLabel_1_4_1_2_1_1);
		
		JLabel lblNewLabel_1_4_2_1_1_1_1_1_1_1_1 = new JLabel("NSTP 2");
		lblNewLabel_1_4_2_1_1_1_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_2_1_1_1_1_1_1_1_1.setBounds(446, 431, 120, 14);
		panel.add(lblNewLabel_1_4_2_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_4_1_1_1_1_1_1_1_1_1_1 = new JLabel("National Service Training Program 2");
		lblNewLabel_1_4_1_1_1_1_1_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1_1_1_1_1_1_1_1_1.setBounds(582, 431, 242, 14);
		panel.add(lblNewLabel_1_4_1_1_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("2ND YEAR, 1ST  SEM");
		lblNewLabel_1_2_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_2_1_1.setBounds(21, 472, 151, 14);
		panel.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("SUBJECT CODE");
		lblNewLabel_1_5_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_5_1.setBounds(21, 497, 120, 14);
		panel.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("SUBJECT TITLE");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(159, 497, 120, 14);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("CCC211-18");
		lblNewLabel_1_3_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_3_1_1.setBounds(23, 521, 92, 14);
		panel.add(lblNewLabel_1_3_1_1);
		
		JLabel lblNewLabel_1_4_1_2_1_1_1 = new JLabel("Information Management 1");
		lblNewLabel_1_4_1_2_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_2_1_1_1.setBounds(159, 521, 222, 14);
		panel.add(lblNewLabel_1_4_1_2_1_1_1);
		
		JLabel lblNewLabel_1_4_3_1_1 = new JLabel("CCL211-18");
		lblNewLabel_1_4_3_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_3_1_1.setBounds(23, 540, 120, 14);
		panel.add(lblNewLabel_1_4_3_1_1);
		
		JLabel lblNewLabel_1_4_1_2_1_2 = new JLabel("Information Management 1 (Lab)");
		lblNewLabel_1_4_1_2_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_2_1_2.setBounds(159, 540, 222, 14);
		panel.add(lblNewLabel_1_4_1_2_1_2);
		
		JLabel lblNewLabel_1_4_4_1 = new JLabel("CCS212-18");
		lblNewLabel_1_4_4_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_4_1.setBounds(23, 558, 120, 14);
		panel.add(lblNewLabel_1_4_4_1);
		
		JLabel lblNewLabel_1_4_1_3_1 = new JLabel("Advanced Calculus");
		lblNewLabel_1_4_1_3_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_3_1.setBounds(159, 558, 222, 14);
		panel.add(lblNewLabel_1_4_1_3_1);
		
		JLabel lblNewLabel_1_4_2_2_1 = new JLabel("CCS213-18");
		lblNewLabel_1_4_2_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_2_2_1.setBounds(23, 576, 120, 14);
		panel.add(lblNewLabel_1_4_2_2_1);
		
		JLabel lblNewLabel_1_4_1_1_2_1 = new JLabel("Discrete Structures");
		lblNewLabel_1_4_1_1_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1_2_1.setBounds(159, 576, 242, 14);
		panel.add(lblNewLabel_1_4_1_1_2_1);
		
		JLabel lblNewLabel_1_4_2_1_2_1 = new JLabel("FILDIS-18");
		lblNewLabel_1_4_2_1_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_2_1_2_1.setBounds(23, 595, 120, 14);
		panel.add(lblNewLabel_1_4_2_1_2_1);
		
		JLabel lblNewLabel_1_4_1_1_1_2_1 = new JLabel("Filipino sa Iba't Ibang Disiplina");
		lblNewLabel_1_4_1_1_1_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1_1_2_1.setBounds(159, 595, 242, 14);
		panel.add(lblNewLabel_1_4_1_1_1_2_1);
		
		JLabel lblNewLabel_1_4_2_1_1_2_1 = new JLabel("GECLWR-18");
		lblNewLabel_1_4_2_1_1_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_2_1_1_2_1.setBounds(23, 614, 120, 14);
		panel.add(lblNewLabel_1_4_2_1_1_2_1);
		
		JLabel lblNewLabel_1_4_1_1_1_1_2_1 = new JLabel("The Life and Works of Rizal");
		lblNewLabel_1_4_1_1_1_1_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1_1_1_2_1.setBounds(159, 614, 242, 14);
		panel.add(lblNewLabel_1_4_1_1_1_1_2_1);
		
		JLabel lblNewLabel_1_4_2_1_1_1_2_1 = new JLabel("GECSTS-18\r\n");
		lblNewLabel_1_4_2_1_1_1_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_2_1_1_1_2_1.setBounds(23, 633, 120, 14);
		panel.add(lblNewLabel_1_4_2_1_1_1_2_1);
		
		JLabel lblNewLabel_1_4_1_1_1_1_1_2_1 = new JLabel("Science, Technology and Society");
		lblNewLabel_1_4_1_1_1_1_1_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1_1_1_1_2_1.setBounds(159, 633, 242, 14);
		panel.add(lblNewLabel_1_4_1_1_1_1_1_2_1);
		
		JLabel lblNewLabel_1_4_2_1_1_1_1_2_1 = new JLabel("GECTCW-18");
		lblNewLabel_1_4_2_1_1_1_1_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_2_1_1_1_1_2_1.setBounds(23, 653, 120, 14);
		panel.add(lblNewLabel_1_4_2_1_1_1_1_2_1);
		
		JLabel lblNewLabel_1_4_1_1_1_1_1_1_2_1 = new JLabel("The Contemporary World");
		lblNewLabel_1_4_1_1_1_1_1_1_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1_1_1_1_1_2_1.setBounds(159, 653, 242, 14);
		panel.add(lblNewLabel_1_4_1_1_1_1_1_1_2_1);
		
		JLabel lblNewLabel_1_4_2_1_1_1_1_1_2_1 = new JLabel("PE3 ID-18");
		lblNewLabel_1_4_2_1_1_1_1_1_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_2_1_1_1_1_1_2_1.setBounds(23, 672, 120, 14);
		panel.add(lblNewLabel_1_4_2_1_1_1_1_1_2_1);
		
		JLabel lblNewLabel_1_4_1_1_1_1_1_1_1_2_1 = new JLabel("Individual/Dual Sports/Games");
		lblNewLabel_1_4_1_1_1_1_1_1_1_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1_1_1_1_1_1_2_1.setBounds(159, 672, 242, 14);
		panel.add(lblNewLabel_1_4_1_1_1_1_1_1_1_2_1);
		
		JLabel lblNewLabel_1_4_2_1_2_2 = new JLabel("CCS225-18");
		lblNewLabel_1_4_2_1_2_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_2_1_2_2.setBounds(446, 595, 120, 14);
		panel.add(lblNewLabel_1_4_2_1_2_2);
		
		JLabel lblNewLabel_1_4_1_1_1_2_2 = new JLabel("Modeling and Simulation");
		lblNewLabel_1_4_1_1_1_2_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1_1_2_2.setBounds(582, 595, 242, 14);
		panel.add(lblNewLabel_1_4_1_1_1_2_2);
		
		JLabel lblNewLabel_1_3_1_2 = new JLabel("CCS221-18");
		lblNewLabel_1_3_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_3_1_2.setBounds(446, 521, 92, 14);
		panel.add(lblNewLabel_1_3_1_2);
		
		JLabel lblNewLabel_1_4_1_2_1_1_2 = new JLabel("Networking and Communication");
		lblNewLabel_1_4_1_2_1_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_2_1_1_2.setBounds(582, 521, 222, 14);
		panel.add(lblNewLabel_1_4_1_2_1_1_2);
		
		JLabel lblNewLabel_1_2_1_2 = new JLabel("2ND YEAR, 2ND SEM");
		lblNewLabel_1_2_1_2.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_2_1_2.setBounds(444, 472, 151, 14);
		panel.add(lblNewLabel_1_2_1_2);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("SUBJECT CODE");
		lblNewLabel_1_5_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_5_2.setBounds(444, 497, 120, 14);
		panel.add(lblNewLabel_1_5_2);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("SUBJECT TITLE");
		lblNewLabel_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_1_1_2.setBounds(582, 497, 120, 14);
		panel.add(lblNewLabel_1_1_1_2);
		
		JLabel lblNewLabel_1_4_3_1_2 = new JLabel("CCS222-18");
		lblNewLabel_1_4_3_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_3_1_2.setBounds(446, 540, 120, 14);
		panel.add(lblNewLabel_1_4_3_1_2);
		
		JLabel lblNewLabel_1_4_1_2_1_3 = new JLabel("Object Oriented Programming-Programming NC IV");
		lblNewLabel_1_4_1_2_1_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_2_1_3.setBounds(582, 540, 199, 14);
		panel.add(lblNewLabel_1_4_1_2_1_3);
		
		JLabel lblNewLabel_1_4_4_2 = new JLabel("CCS223-18");
		lblNewLabel_1_4_4_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_4_2.setBounds(446, 558, 120, 14);
		panel.add(lblNewLabel_1_4_4_2);
		
		JLabel lblNewLabel_1_4_1_3_2 = new JLabel("Design and Analysis of Algorithms");
		lblNewLabel_1_4_1_3_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_3_2.setBounds(582, 558, 222, 14);
		panel.add(lblNewLabel_1_4_1_3_2);
		
		JLabel lblNewLabel_1_4_2_2_2 = new JLabel("CCS224-18");
		lblNewLabel_1_4_2_2_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_2_2_2.setBounds(446, 576, 120, 14);
		panel.add(lblNewLabel_1_4_2_2_2);
		
		JLabel lblNewLabel_1_4_1_1_2_2 = new JLabel("Automata Theory and Formal Languages");
		lblNewLabel_1_4_1_1_2_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1_2_2.setBounds(582, 576, 242, 14);
		panel.add(lblNewLabel_1_4_1_1_2_2);
		
		JLabel lblNewLabel_1_4_2_1_1_2_2 = new JLabel("CCS226-18");
		lblNewLabel_1_4_2_1_1_2_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_2_1_1_2_2.setBounds(446, 614, 120, 14);
		panel.add(lblNewLabel_1_4_2_1_1_2_2);
		
		JLabel lblNewLabel_1_4_1_1_1_1_2_2 = new JLabel("Advanced Statistics");
		lblNewLabel_1_4_1_1_1_1_2_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1_1_1_2_2.setBounds(582, 614, 242, 14);
		panel.add(lblNewLabel_1_4_1_1_1_1_2_2);
		
		JLabel lblNewLabel_1_4_2_1_1_1_2_2 = new JLabel("CSL221-18");
		lblNewLabel_1_4_2_1_1_1_2_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_2_1_1_1_2_2.setBounds(446, 633, 120, 14);
		panel.add(lblNewLabel_1_4_2_1_1_1_2_2);
		
		JLabel lblNewLabel_1_4_1_1_1_1_1_2_2 = new JLabel("Networking and Communication (Lab)");
		lblNewLabel_1_4_1_1_1_1_1_2_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1_1_1_1_2_2.setBounds(582, 633, 242, 14);
		panel.add(lblNewLabel_1_4_1_1_1_1_1_2_2);
		
		JLabel lblNewLabel_1_4_2_1_1_1_1_2_2 = new JLabel("CSL222-18");
		lblNewLabel_1_4_2_1_1_1_1_2_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_2_1_1_1_1_2_2.setBounds(446, 653, 120, 14);
		panel.add(lblNewLabel_1_4_2_1_1_1_1_2_2);
		
		JLabel lblNewLabel_1_4_1_1_1_1_1_1_2_2 = new JLabel("Object Oriented Programming-Programming NC IV (Lab)");
		lblNewLabel_1_4_1_1_1_1_1_1_2_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1_1_1_1_1_2_2.setBounds(582, 653, 242, 14);
		panel.add(lblNewLabel_1_4_1_1_1_1_1_1_2_2);
		
		JLabel lblNewLabel_1_4_2_1_1_1_1_1_2_2 = new JLabel("CSL225-18");
		lblNewLabel_1_4_2_1_1_1_1_1_2_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_2_1_1_1_1_1_2_2.setBounds(446, 672, 120, 14);
		panel.add(lblNewLabel_1_4_2_1_1_1_1_1_2_2);
		
		JLabel lblNewLabel_1_4_1_1_1_1_1_1_1_2_2 = new JLabel("Modeling and Simulation (Lab)");
		lblNewLabel_1_4_1_1_1_1_1_1_1_2_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1_1_1_1_1_1_2_2.setBounds(582, 672, 242, 14);
		panel.add(lblNewLabel_1_4_1_1_1_1_1_1_1_2_2);
		
		JLabel lblNewLabel_1_4_2_1_1_1_1_1_1_1_2 = new JLabel("PE4 TS-18");
		lblNewLabel_1_4_2_1_1_1_1_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_2_1_1_1_1_1_1_1_2.setBounds(446, 691, 120, 14);
		panel.add(lblNewLabel_1_4_2_1_1_1_1_1_1_1_2);
		
		JLabel lblNewLabel_1_4_1_1_1_1_1_1_1_1_1_2 = new JLabel("Team Sports/Games");
		lblNewLabel_1_4_1_1_1_1_1_1_1_1_1_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1_1_1_1_1_1_1_1_2.setBounds(582, 691, 242, 14);
		panel.add(lblNewLabel_1_4_1_1_1_1_1_1_1_1_1_2);
		
		JLabel lblNewLabel_1_4_2_1_1_1_1_1_1_1_1_1 = new JLabel("SOSLIT-18");
		lblNewLabel_1_4_2_1_1_1_1_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_2_1_1_1_1_1_1_1_1_1.setBounds(446, 709, 120, 14);
		panel.add(lblNewLabel_1_4_2_1_1_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_4_1_1_1_1_1_1_1_1_1_1_1 = new JLabel("Sosyedad at Literatura/Panitikang Panlipunan");
		lblNewLabel_1_4_1_1_1_1_1_1_1_1_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_1_4_1_1_1_1_1_1_1_1_1_1_1.setBounds(582, 709, 242, 14);
		panel.add(lblNewLabel_1_4_1_1_1_1_1_1_1_1_1_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				CSframe.setLocation(x-xMouse, y-yMouse);
			}
		});
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		panel_1.setBackground(SystemColor.text);
		panel_1.setBounds(0, 0, 850, 28);
		panel.add(panel_1);
		
		scrollBar = new JScrollBar();
		scrollBar.setBounds(833, 73, 17, 677);
		panel.add(scrollBar);
		
		lblLname = new JLabel(" " +lr.Lname+", "+lr.Name);
		lblLname.setFont(new Font("Arial", Font.PLAIN, 15));
		lblLname.setBounds(79, 73, 162, 28);
		panel.add(lblLname);
		
	    lbIDnum = new JLabel(" " +lr.IDnum);
		lbIDnum.setFont(new Font("Arial", Font.PLAIN, 15));
		lbIDnum.setBounds(107, 103, 172, 28);
		panel.add(lbIDnum);
		
		lblCours = new JLabel(" " +lr.course);
		lblCours.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCours.setBounds(85, 130, 222, 28);
		panel.add(lblCours);
		
		lblStat = new JLabel(" "+lr.status);
		lblStat.setFont(new Font("Arial", Font.PLAIN, 15));
		lblStat.setBounds(417, 73, 109, 28);
		panel.add(lblStat);
		
		lblYr = new JLabel(" " +lr.yr);
		lblYr.setFont(new Font("Arial", Font.PLAIN, 15));
		lblYr.setBounds(405, 103, 109, 28);
		panel.add(lblYr);
		
	    lblSemes = new JLabel(" " +lr.Sem);
		lblSemes.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSemes.setBounds(439, 130, 109, 28);
		panel.add(lblSemes);
	}
}
