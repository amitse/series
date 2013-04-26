//	(a+ n*b) * c ^ k + d
import java.io.*;
import java.util.Random;
public class Question {
	static final int EASY=1;
	static final int MEDIUM=2;
	static final int DIFFICULT=3;
	static final int RANDOM=4;
	static int[] q = new int [11];
	static int marks;
	static String explaination;
	
	static int[] generate (int difficulty)
	{
		if (difficulty == RANDOM)
		{
			difficulty = new Random().nextInt(3)+1;
		}
		switch(difficulty)
		{
			case EASY:		return easy();
			case MEDIUM:	return medium();
			case DIFFICULT:	return difficult();
		}
		return q;
	}
	
	static int[] easy()
	{
	/**
	 * Easy		(a+ n*b) * c ^k + d
	 * ===================================
	 * question type					Marks
	 * 1) AP							1
	 * 2) GP							1
	 * 3) sqauare series / cube series	1
	 * 4) prime							1
	 * 5) odd/even series				1 
	 */ 
		marks = 1;
		int type =new Random().nextInt(5)+1;  // Types 1 to 5
		Random r = new Random();	
		int a=0,b=0,c=0,d=0,e=0,n=0;
		q[10]=type;
		switch(type)
		{
			case 1: // AP
					a = r.nextInt(10)+1;
					b = r.nextInt(10)+1;
					c = r.nextInt(2);
					for (int i = 0; i < 10; i++)
						if(c==0) 
						{
							q[i] = a + i*b;
							explaination = "AP: Common difference is "+b;
						}
						else 
						{
							q[9-i]=a + i*b; 
							explaination = "AP: Common difference is -"+b;
						}
						break;
			case 2: // GP
					a = r.nextInt(5)+1;
					b = r.nextInt(3)+2;
					c = r.nextInt(2);
					for (int i = 0; i < 10; i++)
						if(c==0)	q[i] = a*(int)Math.pow(b,i);
						else 		q[9-i]=a*(int)Math.pow(b,i);
					explaination= "GP: Common factor is " +b;
					break;
			case 3: // sqauare series / cube series
					a = r.nextInt(2);
					b = r.nextInt(2)+2;
					if(a==0){
						for (int i = 0; i < 10; i++)
							q[i] = (int)Math.pow(b,i);
						explaination=b+"^0 , "+b+"^1 , "+b+"^2 , "+b+"^3 ...";
					}
					else{
						for (int i = 0; i < 10; i++)
							q[i] = (int)Math.pow(i,b);
						explaination="0^"+b+" + 1^"+b+" + 2^"+b+" ...";
					}
					break;
			case 4:
			case 5: // odd/even series
					a = r.nextInt(2); // odd / even
					b = r.nextInt(2); // ap/gp
					e = r.nextInt(10)+1;
					c = r.nextInt(10)+1;
					d = r.nextInt(2)+2;
					if(a==0)
					{
						for (int i = 0; i < 20; i=i+2){
							if(b==0) 	
								{
									q[i/2] = e + i*c;
								}
							else 
								{
								q[i/2] = e * (int)Math.pow(d,i);
								}
						}
						if (b==0) explaination=e +" + even *"+ c + ", where even = 0,2,4,6...";
						else
						explaination=e + " * "+ d + "^ even, where even =  0,2,4,6...";
						
					}
					else
					{
						for (int i = 1; i < 20; i=i+2)
							if(b==0) 
								{
									q[(i-1)/2] = e + i*c;
								}
								
							else 
								{
									q[(i-1)/2] = e * (int)Math.pow(d,i);
								}
					if (b==0) explaination=e +" + odd *"+ c + ", where odd = 1,3,5,7...";
					else
					explaination=e + " * "+ d + "^ odd, where odd =  1,3,5,7...";
					}
					break;
		}
		return q;
	}
	static int[] medium()
	{
	/**
	 * MEDIUM
	 * ===================================
	 * 1) Easy							1
	 * 2) Diffrence in AP				2
	 * 3) Diffrence in GP				2
	 * 4) n is in AP/GP					3
	 * 5) n is PRIME					3
	 * 6) fibonacci						3
	 * 7) introducing d (only GP)		2
	 * 8) AP + Power					2
	*/
		marks = 1;
		int type =new Random().nextInt(8)+1;  // Types 1 to 8
		Random r = new Random();	
		int a=0,b=0,c=0,d=0,e=0,n=0;
		q[10]=type;
		switch(type)
		{
			case 1: 
				return easy();
			case 2: //difference in AP
			marks=2;
					a = r.nextInt(5)+1;
					b = r.nextInt(3)+2;
					c = r.nextInt(2);
					for (int i = 0; i < 10; i++)
						if(c==0)	q[i] = a+b*i;
						else 		q[9-i]=a+b*i;
					d = r.nextInt(10)+1;
					for (int i = 0; i < 10; i++)
						q[i]+=d;
					
					explaination = "The difference of consicutive terms are in AP";
					return q;				
			case 3: //Difference in gp
			marks=2;
					a = r.nextInt(5)+1;
					b = r.nextInt(3)+2;
					c = r.nextInt(2);
					for (int i = 0; i < 10; i++)
						if(c==0)	q[i] = a*(int)Math.pow(b,i);
						else 		q[9-i]=a*(int)Math.pow(b,i);
					d = r.nextInt(10)+1;
					for (int i = 0; i < 10; i++)
						q[i]+=d;
					explaination = "The difference of consicutive terms are in AP";

					return q;
			case 4: // n is in ap/gp
			marks=3;
					a = r.nextInt(2); //ap gp
					if(a==0)//ap
						{
							a = r.nextInt(10)+1;
							b = r.nextInt(3)+1;
							for (int i = 0; i < 10; i++)
								q[i] = a*(int)Math.pow(b,i);
							a = r.nextInt(10)+1;
							b = r.nextInt(3)+1;
							for (int i = 0; i < 10; i++)
								q[i] = a + q[i]*b;
						explaination="Subtract each term with "+ a + " and then divide by "+ b + ", you'll get a GP";
						}
					else
						{
							a = r.nextInt(10)+1;
							b = r.nextInt(3)+1;
							for (int i = 0; i < 10; i++)
								q[i] = a + i*b;
							a = r.nextInt(10)+1;
							b = r.nextInt(3)+1;
							for (int i = 0; i < 10; i++)
								q[i] = a * (int)Math.pow(q[i],b);
						explaination="Divide each term by "+ a + " and then raise it to the power (1/"+ b + "), you'll get an AP";
						}
				return q;

			case 5:// Prime
			marks=3;
				int[] prime = {2,3,5,7,11,13,17,19,23,29};
				a = r.nextInt(2);
				b = r.nextInt(10)+1;
				c = r.nextInt(5)+1;
				if(a==0){
					for (int i = 0; i < 10; i++)
						q[i] = b + prime[i]*c;
				explaination = b +" prime * " + c + " where prime = 2,3,5,7,11...";
				}
				else{
					b = r.nextInt(5)+1;
					for (int i = 0; i < 10; i++)
						q[i] = b*(int)Math.pow(prime[i],c);
				explaination = b + " * prime ^ " + c + " where prime = 2,3,5,7,11...";

				}
				return q;
			case 6: // fibonacci
			marks=3;
				int[] fibbonacci = {0,1,1,2,3,5,8,13,21,34};
				a = r.nextInt(2);
				b = r.nextInt(10)+1;
				c = r.nextInt(5)+1;
								if(a==0){
					for (int i = 0; i < 10; i++)
						q[i] = b + fibbonacci[i]*c;
				explaination = b +" fibbonacci * " + c + " where fibbonacci = 0,1,1,2,3...";
				}
				else{
					b = r.nextInt(5)+1;
					for (int i = 0; i < 10; i++)
						q[i] = b*(int)Math.pow(fibbonacci[i],c);
				explaination = b + " * fibbonacci ^ " + c + " where fibbonacci = 0,1,1,2,3...";

				}
				return q;
			case 7: //introducing d (only GP)
			marks=2;
					a = r.nextInt(5)+1;
					b = r.nextInt(3)+2;
					c = r.nextInt(2);
					d = r.nextInt(10)+1;
					for (int i = 0; i < 10; i++)
						if(c==0)	q[i] = a*(int)Math.pow(b,i)+d;
						else 		q[9-i]=a*(int)Math.pow(b,i)+d;
					explaination = "Subtract every element by " + d + " to get a GP with ratio " + b;
				return q;
			case 8: //AP + Power
			marks=2;
					a = r.nextInt(5)+1;
					b = r.nextInt(5)+1;
					for (int i = 0; i < 10; i++)
						q[i] = (int)Math.pow(a + i*b,i);
					explaination = "Raise each element by the power (1/n) where n = 0,1,2,3... you'll get an AP";
				return q;
		}
		return q;
	}
	static int[] difficult()
	{
		return q;
	}
	
	public static void main (String args[]) throws IOException {
		
		for (int i = 0; i < 40; i++)
		{
			generate(MEDIUM);
			int hide =new Random().nextInt(6);			
			for (int j = 0; j < 6; j++)
			{	if(j!=hide)
					System.out.print(q[j] + "\t");
				else
					System.out.print("?\t");
			}
/** cli */
			System.out.println();
			int input = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
			
			if (q[hide]==input)
				System.out.println("bingo!!\n"+explaination);
			else
				System.out.println("Wrong :( Answer is " + q[hide]+"\n"+explaination);
// cli ends
			System.out.println();
			
		}
	}
}
