import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;
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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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
import java.sql.Date;
import java.awt.Component;

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
	private JButton tabel150;
	private JButton table100;
	private JButton table50;
	public static int table=0;
	public String cardnum;
	private JTextField txtmonth;
	private JTextField txtyear;
	private double amount;
	private String cardDate;
	private JLabel lblPurchesSucssfuly;
	private JLabel lblWinsInfo;
	private JLabel lblLossInfo;
	private JLabel lblBalanceInfo;
	
	

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
		
		JButton btnPlayerInfo = new JButton("Player Info");
		btnPlayerInfo.setEnabled(false);
		btnPlayerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c =(CardLayout)(pnlCard.getLayout());
				c.show(pnlCard, "pnlPlayerInfo");
				
				String bal = null;
				try {
					bal = Double.toString(getBalance());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lblBalanceInfo.setText(bal);
				
				String vic=null;
				try {
					vic=Integer.toString(GetVictories());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lblWinsInfo.setText(vic);
				
				String los=null;
				try {
					los=Integer.toString(GetLoss());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lblLossInfo.setText(los);
				
				
			}
		});
		btnPlayerInfo.setForeground(Color.WHITE);
		btnPlayerInfo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnPlayerInfo.setBorder(null);
		btnPlayerInfo.setBackground(new Color(0, 51, 51));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnRegister, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
						.addComponent(btnLogin, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
						.addComponent(btnEnterTable, GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
						.addComponent(btnChipBuy, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnPlayerInfo, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
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
					.addGap(29)
					.addComponent(btnPlayerInfo, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(131, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
	
		splitPane.setRightComponent(pnlCard);
		pnlCard.setLayout(new CardLayout(0, 0));
		
		JPanel pnlWelcome = new JPanel();
		pnlWelcome.setBackground(new Color(0, 51, 51));
		pnlCard.add(pnlWelcome, "pnlWelcom");
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
						btnEnterTable.setEnabled(true);
						btnPlayerInfo.setEnabled(true);
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
					btnPlayerInfo.setEnabled(true);
					txtLoginEmail.setText(null);
					txtLoginPass.setText(null);
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
				table50.setIcon(new ImageIcon("C:\\Users\\רעות אוחיון\\Desktop\\Black Jack\\שולחן.jpg"));
			}
		});
		table50.setIcon(new ImageIcon("C:\\Users\\רעות אוחיון\\Desktop\\Black Jack\\שולחן.jpg"));
		table50.setBounds(34, 205, 134, 106);
		pnlTabels.add(table50);
		
		table100 = new JButton("");
		table100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Display d =new Display();
					d.setVisible(true);
					table=100;
			
				}
				catch (IOException | SQLException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
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
				table100.setIcon(new ImageIcon("C:\\Users\\רעות אוחיון\\Desktop\\Black Jack\\שולחן.jpg"));
			}
		});
		table100.setIcon(new ImageIcon("C:\\Users\\רעות אוחיון\\Desktop\\Black Jack\\שולחן.jpg"));
		table100.setBounds(204, 205, 134, 106);
		pnlTabels.add(table100);
		
		tabel150 = new JButton("");
		tabel150.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Display d =new Display();
					d.setVisible(true);
					table=150;
			
				}
				catch (IOException | SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
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
				tabel150.setIcon(new ImageIcon("C:\\Users\\רעות אוחיון\\Desktop\\Black Jack\\שולחן.jpg"));
			}
		});
		tabel150.setIcon(new ImageIcon("C:\\Users\\רעות אוחיון\\Desktop\\Black Jack\\שולחן.jpg"));
		tabel150.setBounds(371, 205, 134, 106);
		pnlTabels.add(tabel150);
		
		lblHello = new JLabel("");
		lblHello.setForeground(Color.WHITE);
		lblHello.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblHello.setBounds(34, 62, 324, 27);
		pnlTabels.add(lblHello);
		
		JButton btnLogOff = new JButton("Log Off");
		btnLogOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout c =(CardLayout)(pnlCard.getLayout());
				c.show(pnlCard, "pnlWelcom");
				txtLoginEmail.setText(null);
				txtLoginPass.setText(null);
				btnEnterTable.setEnabled(false);
				btnChipBuy.setEnabled(false);
				btnPlayerInfo.setEnabled(false);
				
			}
		});
		btnLogOff.setBorder(null);
		btnLogOff.setBackground(new Color(0, 51, 51));
		btnLogOff.setForeground(new Color(255, 255, 255));
		btnLogOff.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnLogOff.setBounds(34, 396, 115, 29);
		pnlTabels.add(btnLogOff);
		
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
		
		txtCreditNumber = new JTextField();
		txtCreditNumber.setColumns(10);
		
		txtCreditName = new JTextField();
		txtCreditName.setColumns(10);

		
		txtCVV = new JTextField();
		txtCVV.setColumns(10);
		
		txtAmount = new JTextField();
		txtAmount.setColumns(10);
		
		JLabel lblCradNum = new JLabel("crad number is not valid");
		lblCradNum.setVisible(false);
		lblCradNum.setForeground(Color.RED);
		lblCradNum.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtmonth = new JTextField();
		txtmonth.setColumns(10);
		
		txtyear = new JTextField();
		txtyear.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("/");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		
		JLabel lblValDate = new JLabel("Date is not valid");
		lblValDate.setVisible(false);
		lblValDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblValDate.setForeground(new Color(255, 0, 0));
		
		JButton btnBuy = new JButton("Buy ");
		btnBuy.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cardDate=txtmonth.getText()+'/'+txtyear.getText();
				cardnum=txtCreditNumber.getText();
				if(validitCard(cardnum)==false) {
					lblCradNum.setVisible(true);
				} else
					try {
						if(valDate(cardDate)==false) {
							lblValDate.setVisible(true);
						}
						else {
							amount=Double.parseDouble(txtAmount.getText());
							try {
								double tempbal=getBalance();
								setBalance(tempbal+amount);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							lblValDate.setVisible(false);
							lblCradNum.setVisible(false);
							txtCreditName.setText(null);
							txtCVV.setText(null);
							txtmonth.setText(null);
							txtyear.setText(null);
							txtCreditNumber.setText(null);
							txtAmount.setText(null);
							lblPurchesSucssfuly.setVisible(true);
	
						}
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		btnBuy.setBorder(null);
		btnBuy.setBackground(new Color(0, 51, 51));
		btnBuy.setForeground(Color.WHITE);
		btnBuy.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		lblPurchesSucssfuly = new JLabel("purchase succeeded");
		lblPurchesSucssfuly.setVisible(false);
		lblPurchesSucssfuly.setForeground(Color.WHITE);
		lblPurchesSucssfuly.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		
		
		GroupLayout gl_pnlBuyChip = new GroupLayout(pnlBuyChip);
		gl_pnlBuyChip.setHorizontalGroup(
			gl_pnlBuyChip.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlBuyChip.createSequentialGroup()
					.addGap(45)
					.addGroup(gl_pnlBuyChip.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCreditNumber)
						.addComponent(lblCreditDate)
						.addComponent(lblCreditName)
						.addComponent(lblAmount)
						.addComponent(lblCredit3Num)
						.addComponent(btnBuy, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addGap(73)
					.addGroup(gl_pnlBuyChip.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlBuyChip.createSequentialGroup()
							.addGroup(gl_pnlBuyChip.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCVV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_pnlBuyChip.createSequentialGroup()
									.addComponent(txtmonth, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
									.addGap(16)
									.addComponent(lblNewLabel_2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtyear, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtCreditName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCreditNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_pnlBuyChip.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlBuyChip.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
									.addComponent(lblCradNum, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
									.addGap(24))
								.addGroup(gl_pnlBuyChip.createSequentialGroup()
									.addGap(37)
									.addComponent(lblValDate)
									.addContainerGap())))
						.addGroup(gl_pnlBuyChip.createSequentialGroup()
							.addComponent(lblPurchesSucssfuly, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
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
						.addComponent(txtCreditNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCradNum, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(52)
					.addGroup(gl_pnlBuyChip.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCreditName)
						.addComponent(txtmonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtyear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblValDate))
					.addGap(45)
					.addGroup(gl_pnlBuyChip.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCVV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCredit3Num))
					.addGap(48)
					.addGroup(gl_pnlBuyChip.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAmount))
					.addGap(38)
					.addGroup(gl_pnlBuyChip.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBuy, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPurchesSucssfuly, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		pnlBuyChip.setLayout(gl_pnlBuyChip);
		
		JPanel pnlPlayerInfo = new JPanel();
		pnlPlayerInfo.setBackground(new Color(0, 51, 51));
		pnlCard.add(pnlPlayerInfo, "pnlPlayerInfo");
		
		JLabel lblBalance = new JLabel("Balance :");
		lblBalance.setForeground(Color.WHITE);
		lblBalance.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblVictories = new JLabel("Wins :");
		lblVictories.setForeground(Color.WHITE);
		lblVictories.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JLabel lblLoss = new JLabel("Losses :");
		lblLoss.setForeground(Color.WHITE);
		lblLoss.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		 lblBalanceInfo = new JLabel("");
		 lblBalanceInfo.setForeground(Color.WHITE);
		lblBalanceInfo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		 lblWinsInfo = new JLabel("");
		lblWinsInfo.setForeground(Color.WHITE);
		lblWinsInfo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		lblLossInfo = new JLabel("");
		lblLossInfo.setForeground(Color.WHITE);
		lblLossInfo.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GroupLayout gl_pnlPlayerInfo = new GroupLayout(pnlPlayerInfo);
		gl_pnlPlayerInfo.setHorizontalGroup(
			gl_pnlPlayerInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPlayerInfo.createSequentialGroup()
					.addGap(64)
					.addGroup(gl_pnlPlayerInfo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlPlayerInfo.createSequentialGroup()
							.addComponent(lblBalance, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
							.addGap(53)
							.addComponent(lblBalanceInfo))
						.addGroup(gl_pnlPlayerInfo.createSequentialGroup()
							.addComponent(lblLoss, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(lblLossInfo))
						.addGroup(gl_pnlPlayerInfo.createSequentialGroup()
							.addComponent(lblVictories, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addGap(51)
							.addComponent(lblWinsInfo)))
					.addContainerGap(552, Short.MAX_VALUE))
		);
		gl_pnlPlayerInfo.setVerticalGroup(
			gl_pnlPlayerInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlPlayerInfo.createSequentialGroup()
					.addGap(89)
					.addGroup(gl_pnlPlayerInfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBalance, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBalanceInfo))
					.addGap(38)
					.addGroup(gl_pnlPlayerInfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblVictories, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblWinsInfo))
					.addGap(31)
					.addGroup(gl_pnlPlayerInfo.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLoss, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLossInfo))
					.addContainerGap(166, Short.MAX_VALUE))
		);
		pnlPlayerInfo.setLayout(gl_pnlPlayerInfo);
		
		
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
	
	public static boolean validitCard(String card) {
		int[] cardint=new int[card.length()];
		
		for(int i=0;i<card.length();i++) {
			cardint[i]=Integer.parseInt(card.substring(i,i+1));
		}
		
		for(int i=cardint.length-2;i>=0;i=i-2) {
			int temp=cardint[i];
			temp=temp*2;
			if(temp>9) {
				temp=(temp % 10)+1;
			}
			cardint[i]=temp;
		}
		int sum=0;
		for(int i=0;i<cardint.length;i++) {
			sum+=cardint[i];
		}
		if(sum%10==0) {
			return true;
		}
		return false;
	}
	
	public boolean valDate(String date) throws ParseException {
		SimpleDateFormat simpleDate = new SimpleDateFormat("MM/yy");
	    simpleDate.setLenient(false);
		java.util.Date expiry = simpleDate.parse(date);
		boolean expired = expiry.before(new java.util.Date());
		if(expired==true) {
			return false;
		}
			
		return true;
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
		PreparedStatement psemail=conn.prepareStatement("UPDATE playesrdb.players SET balance='"+balance+"' WHERE Email=?;");
		psemail.setString(1,this.email);
		psemail.execute();
	}
	
	@SuppressWarnings("static-access")
	public int whichTable() {
		return this.table;
	}
	
	@SuppressWarnings("static-access")
	public int GetVictories() throws SQLException
	{
		int wins;
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/playesrdb?serverTimezone=UTC","root","Reut8091746");
		PreparedStatement psemail=conn.prepareStatement("SELECT Victories FROM playesrdb.players WHERE Email=?;");
		psemail.setString(1,this.email);
		ResultSet res=psemail.executeQuery();
		if(res.next()) {
			wins=res.getInt("Victories");
		}
		else {
			wins=0;
		}
		
		return wins;	
	}
	
	@SuppressWarnings("static-access")
	public void setVictories (int win) throws SQLException {
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/playesrdb?serverTimezone=UTC","root","Reut8091746");
		PreparedStatement psemail=conn.prepareStatement("UPDATE playesrdb.players SET Victories='"+win+"' WHERE Email=?;");
		psemail.setString(1,this.email);
		psemail.execute();
	}
	
	@SuppressWarnings("static-access")
	public int GetLoss() throws SQLException
	{
		int loss;
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/playesrdb?serverTimezone=UTC","root","Reut8091746");
		PreparedStatement psemail=conn.prepareStatement("SELECT Losses FROM playesrdb.players WHERE Email=?;");
		psemail.setString(1,this.email);
		ResultSet res=psemail.executeQuery();
		if(res.next()) {
			loss=res.getInt("Losses");
		}
		else {
			loss=0;
		}
		return loss;	
	}
	
	@SuppressWarnings("static-access")
	public void setLosses (int loss) throws SQLException {
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/playesrdb?serverTimezone=UTC","root","Reut8091746");
		PreparedStatement psemail=conn.prepareStatement("UPDATE playesrdb.players SET Losses='"+loss+"' WHERE Email=?;");
		psemail.setString(1,this.email);
		psemail.execute();
	}
	
	
}
