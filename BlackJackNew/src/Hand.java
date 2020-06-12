import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.*;

import javax.imageio.ImageIO;

public class Hand{
	public int count = 0;
	private Card[] Hand;
	
	public Hand() throws IOException {
		
		Hand = new Card[52];
		
	}
	public void add(Card card){
		Hand[count++] = card;
	}
	public Card getTopCard(){
		return Hand[0];
	}
	
	public Card getNextCard(int i){
		return Hand[i];
	}

	public int valueOf(){
		int sum=0;
		int rank=0;
		int count2= count;
		int aces = 0;
		for(int i=0;i<count2;i++) {
			if(Hand[i].getFace()=="Jack" || Hand[i].getFace()=="Queen" || Hand[i].getFace()=="King") {
				Hand[i].setFaceValue(10);
			}
			else if(Hand[i].getFace()=="Ace") {
				Hand[i].setFaceValue(11);
				aces++;
			}
		}
		for(int i=0; i< count2; i++){
			rank = Hand[i].getFaceValue();
			sum += rank;
		}
		while (aces > 0 && sum >21){
			sum -= 10;
			aces--;
		}		
		return sum;
	}
	public boolean hasBlackJack(){
		int total = Hand[0].getFaceValue() + Hand[1].getFaceValue();
		return (total==21);
	}

	public boolean isBusted(){
		return valueOf() > 21;
	}
	
	public String toString(){
		String string ="";
		int count3 = count;
		for(int i=0; i< count3; i++){
			string += Hand[i].toString();
			string += "\n";
		}
		if(isBusted()){
			string += "\n\n";
			string += "Bust";
		}
		if(hasBlackJack()){
			string += "\n\n";
			string += "Blackjack";
		}
		return string;
	}
	public static void main(String[] args) throws IOException{
		
	}
}

