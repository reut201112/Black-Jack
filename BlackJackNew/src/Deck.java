
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.*;

import javax.imageio.ImageIO;

public class Deck{
	private Card[] deck ;
	private int index = 0;
	
	public Deck() throws IOException {
		
		String[] faces= {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		String[] suits= {"Diamonds","Clubs","Hearts","Spades"};
		
		deck =new Card[52];
		index=0;
		
		final int width= 47;
		final int hight= 68;
		
		BufferedImage bigImage=ImageIO.read(new File("BlackDeck.png"));
		BufferedImage tempImage;
		
		for(int suit=0;suit<4;suit++) {
			for(int faceNum=0;faceNum<13;faceNum++) {
				tempImage = bigImage.getSubimage(
						faceNum*width+(faceNum*9),
						suit*hight+(suit*10),
						width,
						hight);
				deck[(faceNum + (suit*13))]= new Card(suits[suit], faces[faceNum], faceNum+2, tempImage);
			}
		}
	}
	
	public void shuffle(){
		index = 0;
		SecureRandom rand = new SecureRandom();
		for(int first=0; first<deck.length;first++) {
		
			int second=rand.nextInt(52);
			Card stored = deck[first];
			deck[first] = deck[second];
			deck[second] = stored;
		}
	}
	
	public boolean hasNextCard(){
		return index<52;
	}
	
	public Card nextCard(){
		
		if(index<52){
		index++;
		return deck[index-1];
		
		}
		else{
		return null;
		}
	}
	
	
	public static void main(String[] args) throws IOException{
	
	}
}