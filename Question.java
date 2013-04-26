import java.io.*;
import java.util.Random;
public class Question {
	
	static final int EASY=1,MEDIUM=2,DIFFICULT=3,RANDOM=4;
	//(a+ n*b) * c ^k + d
	static void generate (int difficulty)
	{
		switch(difficulty)
		{
			case EASY:
					break;
			case MEDIUM:
					break;
			case DIFFICULT:
					break;
			case RANDOM:
					break;
		}
		
		Random r = new Random();
		int a = r.nextInt(30);a-=15;
		int b = r.nextInt(20);b-=10;
		int c = r.nextInt(5);c-=2;
		if(c==0)c=1;
		int k = r.nextInt(4);
		for (int i = 0; i < 7; i++)
		{
			if(i!=5)
			System.out.print(((a + i*b)* (int)Math.pow(c,k)) + "\t");
			else
			System.out.print("?\t");

		}
		System.out.println();
		
	}
	
	public static void main (String args[]) throws IOException {
		
		for (int i = 0; i < 40; i++)
		{
			generate(1);
		}
	}
}
