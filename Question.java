import java.io.*;
import java.util.Random;
public class Question {
	
	/**
	 * DIFFICULTY			MARKS
	 * ===================================
	 * EASY					1
	 * MEDIUM				2-3
	 * DIFFICULT			4-5
	 * RANDOM				?
	 * 
	 * Easy
	 * ===================================
	 * question type
	 * 1) AP							1
	 * 2) GP							1
	 * 3) sqauare series / cube series	1
	 * 4) prime							1
	 * 5) power series					1
	 * 
	 * MEDIUM
	 * ===================================
	 * 1) Easy							1
	 * 2) Diffrence in GP				2
	 * 3) n is in AP/GP					3
	 * 4) n is PRIME					3
	 * 5) fibonacchi					2
	 * 6) introducing d (only AP or GP)	3
	 * 7) AP + Power					2
	 * 8) GP + Power					3
	 * 
	 * HARD
	 * ===================================
	 * 1) Medium						2
	 * 2) Diffrence in medium			4
	 * 2) n is in fibonachi				4
	 * 3) AGP							4
	 * 4) d is also in AP/GP (main is only in AP or in GP)
	 * 									4
	 * 5) AP + GP +POWER				5
	 * 6) AP + GP + POWER + D			5
	*/
	
	static final int EASY=1,MEDIUM=2,DIFFICULT=3,RANDOM=4;
	
	static void generate (int difficulty)
	{
		//(a+ n*b) * c ^k + d
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
