import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.print.attribute.standard.PresentationDirection;

public class CreditCard {

	public CreditCard() {
		
	}
	
	public boolean isNumber(String input) {
		try {
			Integer.parseInt(input);
			return true;
			} 
		catch (Exception e) {
			return false;
		}
	}
	
	public boolean isValidNumber(String CardNumber) {
		
		int[] CardInt=new int[CardNumber.length()];
		
		for(int i=0;i<CardNumber.length();i++) {
			CardInt[i]= Integer.parseInt(CardNumber.substring(i,i+1));
		}
		
		for(int i=CardNumber.length()-2;i>=0;i=i-2) {
			int temp=CardInt[i];
			temp+=2;
			if(temp>9) {
				temp=temp%10+1;
			}
			CardInt[i]=temp;
		}
		
		int total=0;
		for(int i=0;i<CardInt.length;i++) {
			total+=CardInt[i];
		}
		
		if(total%10==0) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	
	
}
