import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.JSplitPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JComboBox;

public class Menu extends JFrame {

	private JPanel contentPane;
	JPanel pnlCard = new JPanel();
	JLabel lblNotExisted;
	JLabel lblHello;
	JLabel lblexistemail ;
	JLabel lblsuccsess;
	CardLayout cardLayout;
	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPass;
	private JTextField txtLoginEmail;
	private JPasswordField txtLoginPass;
	private JTextField txtCreditName;
	private JTextField txtCreditNumber;
	private JTextField txtCVV;
	private JTextField txtAmount;
	public static String email;
	private JComboBox comboBoxMonth;
	private JComboBox comboBoxYear;
	private JButton tabel150;
	private JButton table100;
	private JButton table50;
	public static int table=0;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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

	
	@SuppressWarnings("unchecked")
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1006, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JSplitPane splitPane = new JSplitPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(splitPane, Alignment.TRAILING)
		);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 51, 51));
		splitPane.setLeftComponent(panel);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBorder(null);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c =(CardLayout)(pnlCard.getLayout());
				c.show(pnlCard, "register");
			}
		});
		
		btnRegister.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setBackground(new Color(0, 51, 51));
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBorder(null);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c =(CardLayout)(pnlCard.getLayout());
				c.show(pnlCard, "login");
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(0, 51, 51));
		
		JButton btnEnterTable = new JButton("Enter Table");
		btnEnterTable.setEnabled(false);
		btnEnterTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c =(CardLayout)(pnlCard.getLayout());
				c.show(pnlCard, "pnlTabel");

			}
		});
		btnEnterTable.setBorder(null);
		btnEnterTable.setBackground(new Color(0, 51, 51));
		btnEnterTable.setForeground(Color.WHITE);
		btnEnterTable.setFont(new Font("Times New Roman", Font.BOLD, 18));
		
		JButton btnChipBuy = new JButton("Buying chips");
		btnChipBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c =(CardLayout)(pnlCard.getLayout());
				c.show(pnlCard, "pnlBuingChip");
			}
		});
		btnChipBuy.setEnabled(false);
		btnChipBuy.setForeground(Color.WHITE);
		btnChipBuy.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnChipBuy.setBorder(null);
		btnChipBuy.setBackground(new Color(0, 51, 51));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRegister, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
						.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
						.addComponent(btnEnterTable, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
						.addComponent(btnChipBuy, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(110)
					.addComponent(btnRegister)
					.addGap(38)
					.addComponent(btnLogin)
					.addGap(37)
					.addComponent(btnEnterTable)
					.addGap(35)
					.addComponent(btnChipBuy, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(183, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
	
		splitPane.setRightComponent(pnlCard);
		pnlCard.setLayout(new CardLayout(0, 0));
		
		JPanel pnlWelcome = new JPanel();
		pnlWelcome.setBackground(new Color(0, 51, 51));
		pnlCard.add(pnlWelcome, "name_861196290986800");
		pnlWelcome.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Weclom to Black Jack");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(83, 49, 432, 108);
		pnlWelcome.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Please register or login to start playing");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(136, 192, 346, 46);
		pnlWelcome.add(lblNewLabel_1);
		contentPane.setLayout(gl_contentPane);
		
		Panel RegisterPanl = new Panel();
		RegisterPanl.setBackground(new Color(0, 51, 51));
		pnlCard.add(RegisterPanl, "register");
		RegisterPanl.setLayout(null);
		
		JLabel lblID = new JLabel("ID :");
		lblID.setForeground(Color.WHITE);
		lblID.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblID.setBounds(32, 41, 69, 20);
		RegisterPanl.add(lblID);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(32, 109, 69, 20);
		RegisterPanl.add(lblName);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(32, 182, 69, 20);
		RegisterPanl.add(lblEmail);
		
		JLabel lblPass = new JLabel("Password :");
		lblPass.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPass.setForeground(Color.WHITE);
		lblPass.setBounds(32, 249, 87, 20);
		RegisterPanl.add(lblPass);
		
		JButton btnReg = new JButton("Register");
		btnReg.setBackground(new Color(0, 51, 51));
		btnReg.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnReg.setForeground(Color.WHITE);
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					email=txtEmail.getText();
					if(validitEmail(email)==false) {
						lblexistemail.setText("email not valid, please try again");
					}
					
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/playesrdb?serverTimezone=UTC","root","Reut8091746");
					PreparedStatement psemail=conn.prepareStatement("SELECT * FROM playesrdb.players WHERE Email=?");
					psemail.setString(1, email);
					ResultSet res=psemail.executeQuery();
					if(res.next()) {
						lblexistemail.setText("email already exist, please enter another email or login");
					}
					
					else{
					PreparedStatement ps=conn.prepareStatement("INSERT INTO playesrdb.players (idPlayer,Name,Email,Password) VALUES(?,?,?,?);");
					ps.setString(1, txtID.getText());
					ps.setString(2, txtName.getText());
					ps.setString(3, txtEmail.getText());
					ps.setString(4, txtPass.getText());
					
					int x=ps.executeUpdate();
					if(x>0) {
						txtEmail.setText(null);
						txtID.setText(null);
						txtName.setText(null);
						txtPass.setText(null);
						lblsuccsess.setVisible(true);
						btnChipBuy.setEnabled(true);
					}
					conn.close();
					}
				}
				catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnReg.setBounds(32, 401, 115, 29);
		RegisterPanl.add(btnReg);
		
		txtID = new JTextField();
		txtID.setBounds(149, 38, 146, 26);
		RegisterPanl.add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.setBounds(149, 106, 146, 26);
		RegisterPanl.add(txtName);
		txtName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(149, 179, 146, 26);
		RegisterPanl.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setBounds(149, 246, 146, 26);
		RegisterPanl.add(txtPass);
		txtPass.setColumns(10);
		
		lblexistemail = new JLabel("");
		lblexistemail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblexistemail.setForeground(Color.RED);
		lblexistemail.setBounds(344, 182, 483, 29);
		RegisterPanl.add(lblexistemail);
		
		lblsuccsess = new JLabel("Register Succeeded");
		lblsuccsess.setVisible(false);
		lblsuccsess.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblsuccsess.setForeground(Color.WHITE);
		lblsuccsess.setBounds(32, 342, 187, 20);
		RegisterPanl.add(lblsuccsess);
		
		JPanel LoginPanl = new JPanel();
		LoginPanl.setBackground(new Color(0, 51, 51));
		pnlCard.add(LoginPanl, "login");
		LoginPanl.setLayout(null);
		
		JLabel lblemail = new JLabel("Email :");
		lblemail.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblemail.setForeground(Color.WHITE);
		lblemail.setBounds(39, 103, 69, 20);
		LoginPanl.add(lblemail);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(39, 180, 96, 20);
		LoginPanl.add(lblPassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				email=txtLoginEmail.getText();
				@SuppressWarnings("deprecation")
				String pass=txtLoginPass.getText();
				
				if(isExisted(email, pass)) {
					CardLayout c =(CardLayout)(pnlCard.getLayout());
					c.show(pnlCard, "pnlTabel");
					btnEnterTable.setEnabled(true);
					btnChipBuy.setEnabled(true);
					try {
						lblHello.setText("Hello " +getName(email));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else {
					lblNotExisted.setText("Wrong email or password, please try again or register");
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(0, 51, 51));
		btnNewButton.setBounds(39, 337, 115, 29);
		LoginPanl.add(btnNewButton);
		
		txtLoginEmail = new JTextField();
		txtLoginEmail.setBounds(150, 100, 146, 26);
		LoginPanl.add(txtLoginEmail);
		txtLoginEmail.setColumns(10);
		
		txtLoginPass = new JPasswordField();
		txtLoginPass.setBounds(150, 177, 146, 26);
		LoginPanl.add(txtLoginPass);
		
		lblNotExisted = new JLabel("");
		lblNotExisted.setForeground(Color.RED);
		lblNotExisted.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNotExisted.setBounds(39, 269, 495, 34);
		LoginPanl.add(lblNotExisted);
		
		JPanel pnlTabels = new JPanel();
		pnlTabels.setBackground(new Color(0, 51, 51));
		pnlCard.add(pnlTabels, "pnlTabel");
		pnlTabels.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("please select amount to gamble");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_3.setBounds(34, 122, 324, 27);
		pnlTabels.add(lblNewLabel_3);
		
		table50 = new JButton("");
		table50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Display d =new Display();
					d.setVisible(true);
					table=50;
			
				}
				catch (IOException | SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		table50.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				BufferedImage img = null;
				try {
					img = ImageIO.read(new File("שולחן50.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				table50.setIcon(new ImageIcon(img));
				
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				table50.setIcon(new ImageIcon("C:\\Users\\\u05E8\u05E2\u05D5\u05EA \u05D0\u05D5\u05D7\u05D9\u05D5\u05DF\\eclipse-workspace\\BlackJackNew\\\u05E9\u05D5\u05DC\u05D7\u05DF.jpg"));
			}
		});
		table50.setIcon(new ImageIcon("C:\\Users\\\u05E8\u05E2\u05D5\u05EA \u05D0\u05D5\u05D7\u05D9\u05D5\u05DF\\eclipse-workspace\\BlackJackNew\\\u05E9\u05D5\u05DC\u05D7\u05DF.jpg"));
		table50.setBounds(34, 205, 134, 106);
		pnlTabels.add(table50);
		
		table100 = new JButton("");
		table100.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				BufferedImage img = null;
				try {
					img = ImageIO.read(new File("שולחן100.jpg"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table100.setIcon(new ImageIcon(img));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				table100.setIcon(new ImageIcon("C:\\Users\\\u05E8\u05E2\u05D5\u05EA \u05D0\u05D5\u05D7\u05D9\u05D5\u05DF\\eclipse-workspace\\BlackJackNew\\\u05E9\u05D5\u05DC\u05D7\u05DF.jpg"));
			}
		});
		table100.setIcon(new ImageIcon("C:\\Users\\\u05E8\u05E2\u05D5\u05EA \u05D0\u05D5\u05D7\u05D9\u05D5\u05DF\\eclipse-workspace\\BlackJackNew\\\u05E9\u05D5\u05DC\u05D7\u05DF.jpg"));
		table100.setBounds(204, 205, 134, 106);
		pnlTabels.add(table100);
		
		tabel150 = new JButton("");
		tabel150.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {

				BufferedImage img = null;
				try {
					img = ImageIO.read(new File("שולחן150.jpg"));
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				tabel150.setIcon(new ImageIcon(img));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				tabel150.setIcon(new ImageIcon("C:\\Users\\\u05E8\u05E2\u05D5\u05EA \u05D0\u05D5\u05D7\u05D9\u05D5\u05DF\\eclipse-workspace\\BlackJackNew\\\u05E9\u05D5\u05DC\u05D7\u05DF.jpg"));
			}
		});
		tabel150.setIcon(new ImageIcon("C:\\Users\\\u05E8\u05E2\u05D5\u05EA \u05D0\u05D5\u05D7\u05D9\u05D5\u05DF\\eclipse-workspace\\BlackJackNew\\\u05E9\u05D5\u05DC\u05D7\u05DF.jpg"));
		tabel150.setBounds(371, 205, 134, 106);
		pnlTabels.add(tabel150);
		
		lblHello = new JLabel("");
		lblHello.setForeground(Color.WHITE);
		lblHello.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblHello.setBounds(34, 62, 324, 27);
		pnlTabels.add(lblHello);
		
		Panel pnlBuyChip = new Panel();
		pnlBuyChip.setBackground(new Color(0, 51, 51));
		pnlCard.add(pnlBuyChip, "pnlBuingChip");
		
		JLabel lblCreditName = new JLabel("Expiration Date :");
		lblCreditName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCreditName.setForeground(Color.WHITE);
		
		JLabel lblCreditNumber = new JLabel("Cardholder Name :");
		lblCreditNumber.setForeground(Color.WHITE);
		lblCreditNumber.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblCreditDate = new JLabel("Card Number :");
		lblCreditDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCreditDate.setForeground(Color.WHITE);
		
		JLabel lblCredit3Num = new JLabel("CVV :");
		lblCredit3Num.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCredit3Num.setForeground(Color.WHITE);
		
		JLabel lblAmount = new JLabel("Charge Amount :");
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton btnBuy = new JButton("Buy ");
		btnBuy.setBorder(null);
		btnBuy.setBackground(new Color(0, 51, 51));
		btnBuy.setForeground(Color.WHITE);
		btnBuy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtCreditName = new JTextField();
		txtCreditName.setColumns(10);
		
		txtCreditNumber = new JTextField();
		txtCreditNumber.setColumns(10);
		
		txtCVV = new JTextField();
		txtCVV.setColumns(10);
		
		txtAmount = new JTextField();
		txtAmount.setColumns(10);
		
		
		comboBoxMonth = new JComboBox();
		comboBoxMonth.setName("");
		for(int i=1;i<13;i++) {
			comboBoxMonth.addItem(Integer.toString(i));
		}
		comboBoxMonth.setSelectedItem(null);
		
		comboBoxYear = new JComboBox();
		for(int i=2021;i<2035;i++) {
			
			comboBoxYear.addItem(Integer.toString(i));
		}
		
		
		GroupLayout gl_pnlBuyChip = new GroupLayout(pnlBuyChip);
		gl_pnlBuyChip.setHorizontalGroup(
			gl_pnlBuyChip.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBuyChip.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_pnlBuyChip.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBuy, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlBuyChip.createSequentialGroup()
							.addGroup(gl_pnlBuyChip.createParallelGroup(Alignment.LEADING)
								.addComponent(lblCreditNumber)
								.addComponent(lblCreditDate)
								.addComponent(lblCreditName)
								.addComponent(lblAmount)
								.addComponent(lblCredit3Num))
							.addGap(73)
							.addGroup(gl_pnlBuyChip.createParallelGroup(Alignment.LEADING, false)
								.addGroup(Alignment.TRAILING, gl_pnlBuyChip.createSequentialGroup()
									.addComponent(comboBoxMonth, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(comboBoxYear, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCVV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCreditNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCreditName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(411, Short.MAX_VALUE))
		);
		gl_pnlBuyChip.setVerticalGroup(
			gl_pnlBuyChip.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBuyChip.createSequentialGroup()
					.addGap(73)
					.addGroup(gl_pnlBuyChip.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCreditNumber)
						.addComponent(txtCreditName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(gl_pnlBuyChip.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCreditDate)
						.addComponent(txtCreditNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(gl_pnlBuyChip.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCreditName)
						.addComponent(comboBoxMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBoxYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addGroup(gl_pnlBuyChip.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCVV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCredit3Num))
					.addGroup(gl_pnlBuyChip.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlBuyChip.createSequentialGroup()
							.addGap(112)
							.addComponent(btnBuy, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnlBuyChip.createSequentialGroup()
							.addGap(48)
							.addGroup(gl_pnlBuyChip.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAmount))))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		pnlBuyChip.setLayout(gl_pnlBuyChip);
		
		
	}
	
	public boolean isExisted(String email,String pass) {
		try {
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/playesrdb?serverTimezone=UTC","root","Reut8091746");
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM playesrdb.players WHERE Email=? AND Password=?;");
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			return(rs.next()); 
			} 
		catch (Exception e) {

		}
		return false;
	}
	
	public String getName(String email) throws SQLException {
		String name = null;
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/playesrdb?serverTimezone=UTC","root","Reut8091746");
		PreparedStatement s= conn.prepareStatement("SELECT * FROM playesrdb.players WHERE Email=?;");
		s.setString(1, email);
		ResultSet res=s.executeQuery();
		if(res.next()) {
			name=res.getString("Name");
		}
		else {name=null;}
		return name;
	}
	
	public static boolean validitEmail(String mail) {
		String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern emailPat=Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
		Matcher match=emailPat.matcher(mail);
		return match.find();
	}
	
	@SuppressWarnings("static-access")
	public double getBalance () throws SQLException {
		double balance;
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/playesrdb?serverTimezone=UTC","root","Reut8091746");
		PreparedStatement psemail=conn.prepareStatement("SELECT balance FROM playesrdb.players WHERE Email=?;");
		psemail.setString(1,this.email);
		ResultSet res=psemail.executeQuery();
		if(res.next()) {
			balance=res.getFloat("balance");
		}
		else {
			balance=0;
		}
		
		return balance;	
	}
	
	@SuppressWarnings("static-access")
	public void setBalance (double balance) throws SQLException {
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/playesrdb?serverTimezone=UTC","root","Reut8091746");
		PreparedStatement psemail=conn.prepareStatement("UPDATE playesrdb.players SET balance=? WHERE Email=?;");
		psemail.setDouble(1,balance);
		psemail.setString(2,this.email);
		psemail.executeQuery();
	}
	
	@SuppressWarnings("static-access")
	public int witchTable() {
		return this.table;
	}
}
