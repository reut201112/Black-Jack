import java.awt.EventQueue;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import java.awt.image.*;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Display extends JFrame {

	private JPanel contentPane;
	private JButton bPlay = new JButton("Play");
	private JButton bHit = new JButton("Hit");
	private JButton bStay = new JButton("Stay");
	private JPanel PlayerPanel = new JPanel();
	private JTextPane totaltxtPane = new JTextPane();
	private JPanel DilerPanel = new JPanel();
	private JLabel cardlbl1;
	private JLabel cardlbl2;
	private JLabel cardlbl3;
	private JLabel cardlbl4;
	private JLabel cardlbl5;
	private JLabel cardlbl6;
	private JLabel cardlbl7;
	private JLabel cardlbl8;
	private JLabel cardlbl9;
	private JLabel cardlbl10;
	private JLabel cardlbl11;
	private JLabel cardlbl12;
	private JTextPane txtOutcomePlayer;
	private JTextPane txtOutcomeDealer;
	private JLabel label;
	private JTextPane totalDealer;
	
	public Hand player;
	public Hand dealer;
	public Deck deck =new Deck();
	private int sumP=0;
	private int sumD=0;
	private int count=2;
	
	public Menu menu=new Menu();
	private JTextField txtBalance;
	private JLabel lblbalance;
	private double balance;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Display frame = new Display();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	
	public Display() throws IOException, SQLException, ClassNotFoundException {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\\u05E8\u05E2\u05D5\u05EA \u05D0\u05D5\u05D7\u05D9\u05D5\u05DF\\Desktop\\Black Jack\\\u05D0\u05D9\u05D9\u05E7\u05D5\u05DF.jpg"));
		setTitle("Black Jack");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1086, 598);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 139, 87));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		
		
		PlayerPanel.setToolTipText("");
		PlayerPanel.setBackground(new Color(46, 139, 87));
		PlayerPanel.setBorder(new TitledBorder(null, "Player", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		PlayerPanel.setSize(500, 600);
		
		
		cardlbl1 = new JLabel();
		cardlbl1.setBorder(new LineBorder(new Color(0, 0, 0)));
		cardlbl2 = new JLabel();
		cardlbl2.setBorder(new LineBorder(new Color(0, 0, 0)));
		cardlbl2.setText("");
		cardlbl1.setText("");
		cardlbl1.setSize(49, 70);
		cardlbl2.setSize(49, 70);
		cardlbl2.setVisible(true);
		
		cardlbl3 = new JLabel();
		cardlbl3.setBorder(new LineBorder(new Color(0, 0, 0)));
		
	
		cardlbl4 = new JLabel();
		cardlbl4.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		cardlbl5 = new JLabel();
		cardlbl5.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		cardlbl7 = new JLabel();
		cardlbl7.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		cardlbl8 = new JLabel();
		cardlbl8.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		bPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 restor();
				 try {
					balance=menu.getBalance();
					balance=balance-menu.witchTable();
					menu.setBalance(balance);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				 txtBalance.setText(Double.toString(balance));
				 
				 count=2;
				 deck.shuffle();
			
					try {
						player = new Hand();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				 try {
					dealer = new Hand();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 player.add(deck.nextCard());
				 dealer.add(deck.nextCard());
				 sumD=dealer.valueOf();
				 player.add(deck.nextCard());
				 dealer.add(deck.nextCard());
				 sumP=player.valueOf();
				 String sp=Integer.toString(sumP);
				 displayPlayer(player);
				 displayTotal(sp);
				 sp=Integer.toString(sumD);
				 displayDealer(dealer);
				 displayTotalDealer(sp);
				 if(!player.hasBlackJack()){
					 enableHitAndStandButtons();
				}
				 if(player.hasBlackJack() || player.isBusted()){
					 try {
						finishGame();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 }
			}
		});
		bHit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 //if(!player.isBusted() && player.valueOf() !=21){
					 player.add(deck.nextCard());
					 displayPlayaerCards(player,count);
					 count++;
					 sumP=player.valueOf();
					 String sp=Integer.toString(sumP);
					 displayTotal(sp);
				// }
				 if(player.isBusted() || player.valueOf()==21){
				 try {
					finishGame();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 }
			}
		});
		bStay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					finishGame();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
	
		totaltxtPane.setFont(new Font("Times New Roman", Font.BOLD, 20));
		totaltxtPane.setEditable(false);
		totaltxtPane.setBackground(new Color(46, 139, 87));
		
		DilerPanel.setBackground(new Color(46, 139, 87));
		DilerPanel.setBorder(new TitledBorder(null, "Dealer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		txtBalance = new JTextField();
		txtBalance.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtBalance.setEditable(false);
		txtBalance.setBackground(new Color(46, 139, 87));
		txtBalance.setColumns(10);
		txtBalance.setText(Double.toString(menu.getBalance()));
		
		lblbalance = new JLabel("Balance :");
		lblbalance.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblbalance.setForeground(Color.BLACK);
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(PlayerPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(DilerPanel, GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(bHit)
							.addGap(18)
							.addComponent(bStay)
							.addGap(342)
							.addComponent(bPlay))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblbalance)
							.addGap(18)
							.addComponent(txtBalance, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(PlayerPanel, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
						.addComponent(DilerPanel, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(bHit)
						.addComponent(bStay)
						.addComponent(bPlay))
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtBalance, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblbalance))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		bHit.setEnabled(false);
		bStay.setEnabled(false);
		
		txtOutcomeDealer = new JTextPane();
		txtOutcomeDealer.setEditable(false);
		txtOutcomeDealer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtOutcomeDealer.setBackground(new Color(46, 139, 87));
		
		label = new JLabel("Total :");
		label.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		totalDealer = new JTextPane();
		totalDealer.setEditable(false);
		totalDealer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		totalDealer.setBackground(new Color(46, 139, 87));
		
		cardlbl9 = new JLabel("");
		cardlbl9.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		cardlbl11 = new JLabel("");
		cardlbl11.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		cardlbl10 = new JLabel("");
		cardlbl10.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		cardlbl12 = new JLabel("");
		cardlbl12.setBorder(new LineBorder(new Color(0, 0, 0)));
		
	
		GroupLayout gl_DilerPanel = new GroupLayout(DilerPanel);
		gl_DilerPanel.setHorizontalGroup(
			gl_DilerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DilerPanel.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_DilerPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_DilerPanel.createSequentialGroup()
							.addComponent(cardlbl7, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(23)))
					.addGroup(gl_DilerPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DilerPanel.createSequentialGroup()
							.addGap(31)
							.addComponent(totalDealer, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_DilerPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(cardlbl8, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(cardlbl9, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
					.addGap(30)
					.addComponent(cardlbl10, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_DilerPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DilerPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
							.addComponent(txtOutcomeDealer, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_DilerPanel.createSequentialGroup()
							.addGap(27)
							.addComponent(cardlbl11, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(cardlbl12, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
							.addGap(5))))
		);
		gl_DilerPanel.setVerticalGroup(
			gl_DilerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DilerPanel.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_DilerPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_DilerPanel.createSequentialGroup()
							.addComponent(cardlbl10, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_DilerPanel.createSequentialGroup()
							.addGroup(gl_DilerPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_DilerPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_DilerPanel.createSequentialGroup()
										.addGroup(gl_DilerPanel.createParallelGroup(Alignment.TRAILING)
											.addComponent(cardlbl9, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
											.addComponent(cardlbl8, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
											.addComponent(cardlbl7, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
										.addGap(153))
									.addGroup(gl_DilerPanel.createSequentialGroup()
										.addComponent(cardlbl11, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(gl_DilerPanel.createSequentialGroup()
									.addComponent(cardlbl12, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(gl_DilerPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_DilerPanel.createSequentialGroup()
									.addComponent(txtOutcomeDealer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(32))
								.addGroup(gl_DilerPanel.createSequentialGroup()
									.addGroup(gl_DilerPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(totalDealer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
									.addGap(24))))))
		);
		DilerPanel.setLayout(gl_DilerPanel);
		
		JLabel total = new JLabel("Total :");
		total.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtOutcomePlayer = new JTextPane();
		txtOutcomePlayer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtOutcomePlayer.setBackground(new Color(46, 139, 87));
		txtOutcomePlayer.setSelectedTextColor(new Color(46, 139, 87));
		txtOutcomePlayer.setCaretColor(new Color(46, 139, 87));
		
		cardlbl6 = new JLabel();
		cardlbl6.setBorder(new LineBorder(new Color(0, 0, 0)));

		GroupLayout gl_PlayerPanel = new GroupLayout(PlayerPanel);
		gl_PlayerPanel.setHorizontalGroup(
			gl_PlayerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PlayerPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_PlayerPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(cardlbl1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(total, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGroup(gl_PlayerPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_PlayerPanel.createSequentialGroup()
							.addGap(18)
							.addComponent(cardlbl2, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_PlayerPanel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(totaltxtPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(cardlbl3, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(cardlbl4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_PlayerPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_PlayerPanel.createSequentialGroup()
							.addComponent(cardlbl5, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(cardlbl6, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
							.addGap(30))
						.addGroup(gl_PlayerPanel.createSequentialGroup()
							.addComponent(txtOutcomePlayer, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
							.addGap(23))))
		);
		gl_PlayerPanel.setVerticalGroup(
			gl_PlayerPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_PlayerPanel.createSequentialGroup()
					.addContainerGap(40, Short.MAX_VALUE)
					.addGroup(gl_PlayerPanel.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(cardlbl4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_PlayerPanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(cardlbl5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(cardlbl2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(cardlbl1, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
							.addComponent(cardlbl3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(cardlbl6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
					.addGap(169)
					.addGroup(gl_PlayerPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(totaltxtPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(total)
						.addComponent(txtOutcomePlayer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		PlayerPanel.setLayout(gl_PlayerPanel);
		
		contentPane.setLayout(gl_contentPane);
	}
	
	public void displayPlayer(Hand hand){
		Card c2=hand.getNextCard(1);
		Card c1=hand.getTopCard();
		cardlbl1.setIcon(new ImageIcon(c1.getCardImage()));
		cardlbl2.setIcon(new ImageIcon(c2.getCardImage()));
		 PlayerPanel.revalidate();
		 PlayerPanel.repaint();
	}
	
	public void displayPlayaerCards(Hand hand,int i){
		Card c3=hand.getNextCard(i);
		if(i==2) {cardlbl3.setIcon(new ImageIcon(c3.getCardImage()));}
		else if(i==3) {cardlbl4.setIcon(new ImageIcon(c3.getCardImage()));}
		else if(i==4) {cardlbl5.setIcon(new ImageIcon(c3.getCardImage()));}
		else if(i==5) {cardlbl6.setIcon(new ImageIcon(c3.getCardImage()));}
		PlayerPanel.revalidate();
		PlayerPanel.repaint();
	}

	public void displayDealer(Hand hand){
		Card c7= hand.getTopCard();
		cardlbl7.setIcon(new ImageIcon(c7.getCardImage()));
		DilerPanel.revalidate();
		DilerPanel.repaint();
	}

	public void displayDealerCard(Card card){
		cardlbl8.setIcon(new ImageIcon(card.getCardImage()));
	}
	public void displayDealerCards(Hand hand,int i){
		Card c9=hand.getNextCard(i);
		if(i==2) {cardlbl9.setIcon(new ImageIcon(c9.getCardImage()));}
		else if(i==3) {cardlbl10.setIcon(new ImageIcon(c9.getCardImage()));}
		else if(i==4) {cardlbl11.setIcon(new ImageIcon(c9.getCardImage()));}
		else if(i==5) {cardlbl12.setIcon(new ImageIcon(c9.getCardImage()));}
		DilerPanel.revalidate();
		DilerPanel.repaint();
	}
	
	public void displayTotal(String outcome){
	  totaltxtPane.setText(outcome);
	}
	public void displayTotalDealer(String outcome){
		  totalDealer.setText(outcome);
	}
	
	public void displayOutcomePlayer(String outcome){
		  txtOutcomePlayer.setText(outcome);
		}
	public void displayOutcomeDealer(String outcome){
		  txtOutcomeDealer.setText(outcome);
		}

	public void enableHitAndStandButtons(){
	    bPlay.setEnabled(false);
	    bHit.setEnabled(true);
	    bStay.setEnabled(true);
	}

	public void enablePlayButton(){
		bPlay.setEnabled(true);
		bHit.setEnabled(false);
		bStay.setEnabled(false);
	}
	
	private void finishGame() throws SQLException{
		 displayDealerCard(dealer.getNextCard(1));
		 sumD=dealer.valueOf();
		 String sd=Integer.toString(sumD);
		 displayTotalDealer(sd);
		 count=2;
	 	 while (dealer.valueOf()<17 || (dealer.valueOf()<=player.valueOf() && !player.isBusted())) {
			 dealer.add(deck.nextCard());
			 sleep(1000);
			 displayDealerCards(dealer, count);
			 count++;
		 }
	 	 sumD=dealer.valueOf();
		 sd=Integer.toString(sumD);
		 displayTotalDealer(sd);
		if(player.hasBlackJack() && !dealer.hasBlackJack()){
			displayOutcomePlayer("Win");
			displayOutcomeDealer("Lose");
			balance+=menu.witchTable()*2;
			menu.setBalance(balance);
			txtBalance.setText(Double.toString(balance));
			}
		else if (dealer.hasBlackJack() && player.hasBlackJack()){
			displayOutcomePlayer("Tie");
			displayOutcomeDealer("Tie");
			balance+=menu.witchTable();
			menu.setBalance(balance);
			txtBalance.setText(Double.toString(balance));
		}
		else if(dealer.hasBlackJack()){
			displayOutcomePlayer("Lose");
			displayOutcomeDealer("Win");}
		else if (player.isBusted() && !(dealer.isBusted())){
			displayOutcomePlayer("Lose");
			displayOutcomeDealer("Win");}
		else if(dealer.isBusted() && !player.isBusted()) {
			displayOutcomePlayer("Win");
			displayOutcomeDealer("Lose");
			balance+=menu.witchTable()*2;
			menu.setBalance(balance);
			txtBalance.setText(Double.toString(balance));
		}
	   else if (dealer.valueOf() == player.valueOf()){
		   displayOutcomePlayer("Tie");
	   		displayOutcomeDealer("Tie");
	   		balance+=menu.witchTable();
			menu.setBalance(balance);
			txtBalance.setText(Double.toString(balance));}
	   else if (dealer.valueOf() > player.valueOf()){
                displayOutcomePlayer("Lose");
                displayOutcomeDealer("Win");}
	   else if (player.valueOf() > dealer.valueOf()){
		   		displayOutcomePlayer("Win");
		   		displayOutcomeDealer("Lose");
		   		balance+=menu.witchTable()*2;
				menu.setBalance(balance);
				txtBalance.setText(Double.toString(balance));
	   }
		
			 enablePlayButton();
		}
	
	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void restor() {
		cardlbl1.setIcon(null);
		cardlbl2.setIcon(null);
		cardlbl3.setIcon(null);
		cardlbl4.setIcon(null);
		cardlbl5.setIcon(null);
		cardlbl6.setIcon(null);
		cardlbl7.setIcon(null);
		cardlbl8.setIcon(null);
		cardlbl9.setIcon(null);
		cardlbl10.setIcon(null);
		cardlbl11.setIcon(null);
		cardlbl12.setIcon(null);
		txtOutcomeDealer.setText(null);
		txtOutcomePlayer.setText(null);
		totalDealer.setText(null);
		totaltxtPane.setText(null);
	}
	
}
	

