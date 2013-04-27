import java.util.Random;
/**
 * @author Amit Sengupta
 *
 */
public class Question {
	static final int EASY=1;
	static final int MEDIUM=2;
	static final int DIFFICULT=3;
	static final int RANDOM=4;
	
	int size;
	int[] q;
	int marks;
	String explanation;
	
	/**
	 * @param size The number of Elements in the sequence. It cannot be more than 10
	 * 
	 */
	Question (int size)
	{
		if (size>10) size =10;
		this.size = size;
		q= new int[size];
	}

	/**
	 * @return A number associated with the difficulty level of the question with respect to other questions.
	 */
	int getMarks()
	{
		return marks;
	}
	
	/**
	 * @return A String containing detailed explanation about the series
	 */
	String getExplanation()
	{
		return explanation;
	}
	
	/**
	 * @param difficulty Difficulty level of the question. It can be one among Question.EASY, Question.MEDIUM, Question.DIFFICULT or Question.RANDOM
	 * @return an integer array of size 'size' which will contain the question.
	 */
	int[] generateQuestion (int difficulty)
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
	
	/**
	 * @return Integer array of size "size" containing an easy question.
	 */
	int[] easy()
	{
				/* ===================================
	  			 * Easy		(a+ n*b) * c ^k + d
	  			 * ===================================
	  			 * question type					Marks
	  			 * 1) AP							1
	  			 * 2) GP							1
	  			 * 3) square series / cube series	1
	  			 * 4) alternate AP's				1
	  			 * 5) odd/even series				1 
	  	*/
		
		marks = 1;
		int type =new Random().nextInt(5)+1;  // Types 1 to 5
		Random r = new Random();	
		int a=0,b=0,c=0,d=0,e=0;
		switch(type)
		{
			case 1: // AP
					a = r.nextInt(10)+1;
					b = r.nextInt(10)+1;
					c = r.nextInt(2);
					for (int i = 0; i < size; i++)
						if(c==0) 
						{
							q[i] = a + i*b;
							explanation = "AP: Common difference is "+b;
						}
						else 
						{
							q[size-i-1]=a + i*b; 
							explanation = "AP: Common difference is -"+b;
						}
						break;
			case 2: // GP
					a = r.nextInt(5)+1;
					b = r.nextInt(3)+2;
					c = r.nextInt(2);
					for (int i = 0; i < size; i++)
						if(c==0)	q[i] = a*(int)Math.pow(b,i);
						else 		q[size-1-i]=a*(int)Math.pow(b,i);
					explanation= "GP: Common factor is " +b;
					break;
			case 3: // square series / cube series
					a = r.nextInt(2);
					b = r.nextInt(2)+2;
					if(a==0){
						for (int i = 0; i < size; i++)
							q[i] = (int)Math.pow(b,i);
						explanation=b+"^0 , "+b+"^1 , "+b+"^2 , "+b+"^3 ...";
					}
					else{
						for (int i = 0; i < size; i++)
							q[i] = (int)Math.pow(i,b);
						explanation="0^"+b+" + 1^"+b+" + 2^"+b+" ...";
					}
					break;
			case 4: //alternate ap's
					a = r.nextInt(10)+1;
					b = r.nextInt(10)+1;
					c = r.nextInt(10)+1;
					d = r.nextInt(10)+1;
					
					for (int i = 0; i < size; i=i+2)
							q[i] = a + i*c;
					for (int i = 1; i < size; i=i+2)
							q[i] = b + i*d;
					explanation = "Alternate AP Common Difference of even terms = "+b*2 +", Odd terms = " + d*2;
			break;
			
			case 5: // odd/even series
					a = r.nextInt(2); // odd / even
					b = r.nextInt(2); // ap/gp
					e = r.nextInt(10)+1;
					c = r.nextInt(10)+1;
					d = r.nextInt(2)+2;
					if(a==0)
					{
						for (int i = 0; i < size*2; i=i+2){
							if(b==0) 	
								{
									q[i/2] = e + i*c;
								}
							else 
								{
								q[i/2] = e * (int)Math.pow(d,i);
								}
						}
						if (b==0) explanation=e +" + even *"+ c + ", where even = 0,2,4,6...";
						else
						explanation=e + " * "+ d + "^ even, where even =  0,2,4,6...";
						
					}
					else
					{
						for (int i = 1; i < size*2; i=i+2)
							if(b==0) 
								{
									q[(i-1)/2] = e + i*c;
								}
								
							else 
								{
									q[(i-1)/2] = e * (int)Math.pow(d,i);
								}
					if (b==0) explanation=e +" + odd *"+ c + ", where odd = 1,3,5,7...";
					else
					explanation=e + " * "+ d + "^ odd, where odd =  1,3,5,7...";
					}
					break;
		}
		return q;
	}

	/**
	 * @return Integer array of size "size" containing a moderately difficult question.
	 */
	int[] medium()
	{
	/**
	 * MEDIUM
	 * ===================================
	 * 1) Easy							1
	 * 2) Difference in AP				2
	 * 3) Difference in GP				2
	 * 4) n is in AP/GP					3
	 * 5) introducing d (only GP)		2
	 * 6) AP + Power					2
	*/
		marks = 1;
		int type =new Random().nextInt(6)+1;  // Types 1 to 8
		Random r = new Random();	
		int a=0,b=0,c=0,d=0;
		switch(type)
		{
			case 1: 
				return easy();
			case 2: //difference in AP
			marks=2;
					a = r.nextInt(5)+1;
					b = r.nextInt(3)+2;
					for (int i = 0; i < size; i++)
						q[i] = a+b*i;
					d = r.nextInt(10)+1;
					for (int i = 0; i < size; i++)
						q[i]+=d*i;
					
					explanation = "The difference of consecutive terms are in AP";
					return q;				
			case 3: //Difference in gp
			marks=2;
					a = r.nextInt(5)+1;
					b = r.nextInt(3)+2;
					c = r.nextInt(2);
					for (int i = 0; i < size; i++)
						if(c==0)	q[i] = a*(int)Math.pow(b,i);
						else 		q[size-1-i]=a*(int)Math.pow(b,i);
					d = r.nextInt(10)+1;
					for (int i = 0; i < size; i++)
						q[i]+=d;
					explanation = "The difference of consecutive terms are in AP";

					return q;
			case 4: // n is in ap/gp
			marks=3;
					a = r.nextInt(2); //ap gp
					if(a==0)//ap
						{
							a = r.nextInt(10)+1;
							b = r.nextInt(3)+1;
							for (int i = 0; i < size; i++)
								q[i] = a*(int)Math.pow(b,i);
							a = r.nextInt(10)+1;
							b = r.nextInt(3)+1;
							for (int i = 0; i < size; i++)
								q[i] = a + q[i]*b;
						explanation="Subtract each term with "+ a + " and then divide by "+ b + ", you'll get a GP";
						}
					else
						{
							a = r.nextInt(10)+1;
							b = r.nextInt(3)+1;
							for (int i = 0; i < size; i++)
								q[i] = a + i*b;
							a = r.nextInt(10)+1;
							b = r.nextInt(3)+1;
							for (int i = 0; i < size; i++)
								q[i] = a * (int)Math.pow(q[i],b);
						explanation="Divide each term by "+ a + " and then raise it to the power (1/"+ b + "), you'll get an AP";
						}
				return q;

			
			case 5: //introducing d (only GP)
			marks=2;
					a = r.nextInt(5)+1;
					b = r.nextInt(3)+2;
					d = r.nextInt(10)+1;
					for (int i = 0; i < size; i++)
						q[i] = (int)Math.pow(b,i)+d;
					//explanation = "Subtract every element by " + d +  "; " +a + "*(" + b+ "^0) ,"+a + "*(" + b+ "^1) ,"+a + "*(" + b+ "^2) ,"+a + "*(" + b+ "^3) ...";
					explanation = "Subtract every element by " + d +  ";  (" + b+ "^0) , (" + b+ "^1) , (" + b+ "^2) , (" + b+ "^3) ...";

					return q;
			case 6: //AP + Power
			marks=2;
					a = r.nextInt(5)+1;
					b = r.nextInt(5)+1;
					for (int i = 0; i < size; i++)
						q[i] = (int)Math.pow(a + i*b,i);
					explanation = (a) + "^0, "+(a+b)+"^1, "+ (a+2*b)+"^2, "+ (a+3*b)+"^3..... " ;
				return q;
		}
		return q;
	}
	
	/**
	 * @return Integer array of size "size" containing a difficult question.
	 */

	int[] difficult()
	{
	/**
	 * Difficult
	 * ===================================
	 * 1) Medium						2
	 * 2) AGP							4
	 * 5) AP + GP + POWER + D			4
	 * 4 5 6) n is PRIME				3
	 * 7 8 9) fibonacci					3
	 */ 
		marks = 2;
		int type =new Random().nextInt(9)+1;  // Types 1 to 9
		Random r = new Random();	
		int a=0,b=0,c=0,d=0;
		switch(type)
		{
			case 1: // medium
				return medium();
			
			case 2: //AGP
				marks=4;
				a = r.nextInt(10)+1;
				b = r.nextInt(10)+1;
				c = r.nextInt(3)+1;
				
				for (int i = 0; i < size; i++)
				{
					q[i]= (a+i*b) * (int)Math.pow(c,i);
				}
				explanation = "("+a+" + n * "+b+") * "+c+"^n where n = 0,1,2,3...";
				return q;
				
			case 3: //AGPD
				marks=4;
				a = r.nextInt(10)+1;
				b = r.nextInt(10)+1;
				d = r.nextInt(10)+1;
				c = r.nextInt(3)+1;
				
				for (int i = 0; i < size; i++)
				{
					q[i]= (a+i*b) * (int)Math.pow(c,i) +d;
				}
				explanation = "("+a+" + n * "+b+") * "+c+"^n  + "+d+" where n = 0,1,2,3...";
				return q;
			case 4:case 5:case 6:// Prime
				marks=3;
					int[] prime = {2,3,5,7,11,13,17,19,23,29};
					a = r.nextInt(2);
					b = r.nextInt(10)+1;
					c = r.nextInt(5)+1;
					if(a==0){
						for (int i = 0; i < size; i++)
							q[i] = b + prime[i]*c;
					explanation = b +" prime * " + c + " where prime = 2,3,5,7,11...";
					}
					else{
						b = r.nextInt(5)+1;
						for (int i = 0; i < size; i++)
							q[i] = b*(int)Math.pow(prime[i],c);
					explanation = b + " * prime ^ " + c + " where prime = 2,3,5,7,11...";

					}
					return q;
				case 7:case 8:case 9: // fibonacci
				marks=3;
					int[] fibonacci = {0,1,1,2,3,5,8,13,21,34};
					a = r.nextInt(2);
					b = r.nextInt(10)+1;
					c = r.nextInt(5)+1;
									if(a==0){
						for (int i = 0; i < size; i++)
							q[i] = b + fibonacci[i]*c;
					explanation = b +" fibonacci * " + c + " where fibonacci = 0,1,1,2,3...";
					}
					else{
						b = r.nextInt(5)+1;
						for (int i = 0; i < size; i++)
							q[i] = b*(int)Math.pow(fibonacci[i],c);
					explanation = b + " * fibonacci ^ " + c + " where fibonacci = 0,1,1,2,3...";
					}
					return q;
			}
		
		return q;
	}
}

