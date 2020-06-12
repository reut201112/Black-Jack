import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Card {
	
	private String faceName,suit;
	private int value;
	private BufferedImage cardImage;
	
	public Card(String suit,String face,int value,BufferedImage card) {
		this.suit=suit;
		this.faceName=face;
		this.value=value;
		this.cardImage=card;
		
	}
	
	public void setFaceValue(int value) {
		this.value= value;
	}
	

	public int getFaceValue() {
		return value;
	}
	public String getFace() {
		return this.faceName;
	}
	
	public String toString() {
		return faceName+" of "+suit;
	}
	
	public BufferedImage getCardImage() {
		return cardImage;
	}
	
	public static void main(String[] args) throws IOException {
		Card ca =new Card("Spedes", "Ace", 14, ImageIO.read(new File("BlackDeck.png")));
		System.out.println(ca.toString());
	}
	
}
