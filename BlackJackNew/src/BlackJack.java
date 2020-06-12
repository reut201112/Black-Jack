/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;



public class BlackJack {
	public Hand player;
	public Hand dealer;
	public Deck deck =new Deck();
	private int play = 0;
	private int hit = 0;
	private int sumP=0;
	private int sumD=0;
	public Display GUI;
	private int stand =0;
	
	public BlackJack() throws IOException{
		GUI =  new Display();
		GUI.setPlayAction(new PlayAction());
		GUI.setHitAction(new HitAction());
		GUI.setStandAction(new StandAction());
		GUI.enablePlayButton();
	}
	
	class PlayAction implements ActionListener {
		 public void actionPerformed (ActionEvent e) {
	
		 deck.shuffle();
		 player = new Hand();
		 dealer = new Hand();
		 player.add(deck.nextCard());
		 dealer.add(deck.nextCard());
		 player.add(deck.nextCard());
		 dealer.add(deck.nextCard());
		 sumP=player.valueOf();
		 String sp=Integer.toString(sumP);
		 GUI.displayPlayer(player);
		 GUI.displayTotal(sp);
		 GUI.displayDealerCard(dealer.getTopCard());
		
		 if(!player.hasBlackJack() && !dealer.hasBlackJack() && !player.isBusted()){
			 GUI.enableHitAndStandButtons();
		}
		 if(player.hasBlackJack() || dealer.hasBlackJack() || player.isBusted()){
			 finishGame();
		 }
	 }
}
	
	class HitAction implements ActionListener{ 
		 public void actionPerformed (ActionEvent e) {

			 if(!player.isBusted() && player.valueOf() !=21){
				 player.add(deck.nextCard());
				 GUI.displayPlayer(player);
			 }
			 if(player.isBusted() || player.valueOf()==21){
			 finishGame();
			 }
		 }
		}
	
		class StandAction implements ActionListener{
			public void actionPerformed (ActionEvent e) {
		
				finishGame();
			}
		
		}
		
		private void finishGame(){
			 sumD=dealer.valueOf();
			 String sd=Integer.toString(sumD);
			 GUI.displayTotalDealer(sd);
			if(player.hasBlackJack()){
			GUI.displayDealer(dealer);
			GUI.displayPlayer(player);
			GUI.displayOutcomePlayer("Win");}
			else if (dealer.hasBlackJack() && player.hasBlackJack()){
			GUI.displayDealer(dealer);
			GUI.displayPlayer(player);
			GUI.displayOutcomePlayer("Push");
			GUI.displayOutcomeDealer("Push");}
			else if(dealer.hasBlackJack()){
			GUI.displayDealer(dealer);
			GUI.displayPlayer(player);
			GUI.displayOutcomePlayer("Lose");}
			else if (player.isBusted()){
			GUI.displayDealer(dealer);
			GUI.displayPlayer(player);
			GUI.displayOutcomePlayer("Lose");}
			else {
				while( dealer.valueOf()<17 && !dealer.isBusted() ){
				 dealer.add(deck.nextCard());
				}
			   if(dealer.isBusted())
				   {GUI.displayDealer(dealer);
			           GUI.displayPlayer(player);
				   GUI.displayOutcomePlayer("Win");}
	                  else if (dealer.hasBlackJack()){
				   GUI.displayDealer(dealer);
			           GUI.displayPlayer(player);
			           GUI.displayOutcomePlayer("Lose");
				   } 
			   else if (dealer.valueOf() == player.valueOf())
				   {GUI.displayDealer(dealer);
				   GUI.displayPlayer(player);
				   GUI.displayOutcomeDealer("Push");}
			   else if (dealer.valueOf() > player.valueOf()){
				   GUI.displayDealer(dealer);
		                   GUI.displayPlayer(player);
			   	   GUI.displayOutcomePlayer("Lose");}
			   else if (player.valueOf() > dealer.valueOf()){
				   GUI.displayDealer(dealer);
			           GUI.displayPlayer(player);
			           GUI.displayOutcomePlayer("Win");}
				 
			}
			GUI.enablePlayButton();
		}
		
		public static void main(String[] args) throws IOException{
			new BlackJack();
			
			
		}
		
}
*/
