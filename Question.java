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
		explanation="";
		q = new int[size];
		
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
	  			 * Easy		
	  			 * ===================================
	  			 * question type					Marks
	  			 * 1) AP							1
	  			 * 2) GP							1
	  			 * 3) square series / cube series	1
	  			 * 4) alternate AP's				1
	  			 * 5) alternate GP's				1 
	  	*/
		marks = 1;
		
while(!isValidSequence()){
		explanation="";
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
						}
						else 
						{
							q[size-i-1]=a + i*b; 
						}

					explain();
					explanation = explanation + "\nAirithmatic Progression:\nThe difference of any two consicutive terms is ";					
						if (c==0) 
							explanation = explanation + b +"";
						else
							explanation = explanation +"-"+ b;							
						break;
			case 2: // GP
					a = r.nextInt(5)+1;
					b = r.nextInt(3)+2;
					c = r.nextInt(2);
					for (int i = 0; i < size; i++)
						if(c==0)	q[i] = a*(int)Math.pow(b,i);
						else 		q[size-1-i]=a*(int)Math.pow(b,i);

					explain();
					explanation = explanation + "\nGeometric Progression:\nThe ratio of any two consicutive terms is ";					
						if (c==0) 
							explanation = explanation + b +"";
						else
							explanation = explanation + "(1/" + b +")";							
					break;
			case 3: // square series / cube series
					a = r.nextInt(2);
					b = r.nextInt(2)+2;
					if(a==0){
						for (int i = 0; i < size; i++){
							q[i] = (int)Math.pow(b,i);
							if(i!=size-1)
								explanation += q[i] + ", ";
							else
								explanation += q[i] + ":";						
							
							}
						explanation+="\nPower series:\n" + b+"^0 , "+b+"^1 , "+b+"^2 , "+b+"^3, "+b+"^4 ...";
					}
					else{
						for (int i = 0; i < size; i++){
							q[i] = (int)Math.pow(i,b);
							if(i!=size-1)
								explanation += q[i] + ", ";
							else
								explanation += q[i] + ":";											
						}
						explanation+="\nPower series:\n" +"0^"+b+" , 1^"+b+" , 2^"+b+" , 3^"+b+" , 4^"+b+" ...";
					
					}
					break;
			case 4:
					//alternate ap's
					a = r.nextInt(10)+1;
					b = r.nextInt(10)+1;
					c = r.nextInt(10)+1;
					d = r.nextInt(10)+1;
					if(c==d)d++;
					
					for (int i = 0; i < size; i=i+2)
							q[i] = a + (i/2)*c;
					for (int i = 1; i < size; i=i+2)
							q[i] = b + ((i/2)+1)*d;
					explain();
					explanation += "\nAlternate terms are in Arithematic Progression:\nCommon Difference of Odd terms = "+c +", Even terms = " + d;
			break;
			case 5:
					//alternate gp's
					a = r.nextInt(10)+1;
					b = r.nextInt(3)+2;
					c = r.nextInt(10)+1;
					d = r.nextInt(3)+2;
					if(c==d)d++;
					
					for (int i = 0; i < size; i=i+2)
							q[i] = a * (int)Math.pow(c, (i/2));
					for (int i = 1; i < size; i=i+2)
							q[i] = b * (int)Math.pow(d,((i/2)+1));
					explain();
					explanation += "\nAlternate terms are in Geometric Progression:\nCommon Ratio of Odd terms = "+c +", Even terms = " + d;
			break;


		}
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
	 * 4) n is in AP/GP					2
	 * 5) introducing d (only GP)		2
	 * 6) Based on first element		2
	*/
		marks = 1;
	while(!isValidSequence()){
		explanation="";
		int type =new Random().nextInt(6)+1;  // Types 1 to 8
		Random r = new Random();	
		int a=0,b=0,c=0,d=0;
		switch(type)
		{
			case 1: 
				return easy();
			case 2: //difference in AP
			marks=2;
					a = r.nextInt(10)+1;
					b = r.nextInt(7)+2;
					c = r.nextInt(10)+1;
					q[0]=a;
					for (int i = 1; i < size; i++)
						q[i] = q[i-1] + c+b*i;

					explain();
					explanation += "\nThe difference of consecutive terms, i.e:\n(";
					for (int i = 1; i < size; i++)
					{
							if(i!=size-1)
								explanation += q[i]-q[i-1] + ", ";
							else
								explanation += q[i]-q[i-1] + ") \nis in Arithematic Progression where the difference of any two consicutive terms is " + b;						
					}					
					
					break;				
			case 3: //Difference in gp
					marks=2;
					a = r.nextInt(10)+1;
					b = r.nextInt(3)+2;
					c = r.nextInt(10)+1;
					q[0]=a;
					for (int i = 1; i < size; i++)
						q[i] = q[i-1] + c* (int)Math.pow(b,i);

					explain();
					explanation += "\nThe difference of consecutive terms, i.e:\n(";
					for (int i = 1; i < size; i++)
					{
							if(i!=size-1)
								explanation += q[i]-q[i-1] + ", ";
							else
								explanation += q[i]-q[i-1] + ") \nis in Geometric Progression where the ratio of any two consicutive terms is " + b;						
					}
					break;					
			case 4: // n is in gp
							marks=2;
							a = r.nextInt(10)+1;
							b = r.nextInt(3)+1;
							for (int i = 0; i < size; i++)
								q[i] = a*(int)Math.pow(b,i);
							a = r.nextInt(10)+1;
							for (int i = 0; i < size; i++)
								q[i] = a + q[i];
						
					explain();
						explanation+="\nSubtract each term by "+ a + ":\n(";
							for (int i = 0; i < size; i++)
							{
									if(i!=size-1)
										explanation += q[i]-a + ", ";
									else
										explanation += q[i]-a + ")";						
							}
						explanation+="\nis in a Geometric progression where the ratio of any two consicutive terms is " + b;				
				break;

			
			case 5: //introducing d (only GP)
			marks=2;
					a = r.nextInt(5)+1;
					b = r.nextInt(3)+2;
					d = r.nextInt(10)+1;
					for (int i = 0; i < size; i++)
						q[i] = (int)Math.pow(b,i)+d;
					
					explain();
					explanation += "\nSubtract every element by " + d +  ":\n";
					for (int i = 0; i < size; i++)
							{
									if(i!=size-1)
										explanation += q[i]-d + ", ";
									else
										explanation += q[i]-d + ")";						
							}
					
					explanation+= "\nWhich is  (" + b+ "^0) , (" + b+ "^1) , (" + b+ "^2) , (" + b+ "^3) ...";
					break;
			case 6: //Based on previous element;
			marks=2;
					a = r.nextInt(4);
					
					if(a==0)//square of prev no +/- something
					{
						a = r.nextInt(3)+1;
						b = r.nextInt(10)-5;if (b==0) b=2;
						q[1]=a;
						for (int i = 1; i < size; i++)
							q[i] = q[i-1]*q[i-1] + b;
						
						explain();
						String s = b>0?"+":"";
						explanation += "\nEvery number in this sequence is equal to (square of previous number)"+s+" "+b;
						

					}
					else if (a==1)// +/- something, square of that number 
					{
						a = r.nextInt(3)+1;
						b = r.nextInt(10)-5;if (b==0) b=2;
						q[1]=a;
						for (int i = 1; i < size; i++)
							q[i] = (q[i-1]+b)*(q[i-1] + b);
						
						explain();
						String s = b>0?"+":"";
						explanation += "\nEvery number in this sequence is equal to square of (previous number "+s+" "+b+")";
					}
					else if (a==2) // +/- prev no with something, multily something
					{
						a = r.nextInt(10)+1;
						b = r.nextInt(10)-5;if (b==0) b=2;
						c = r.nextInt(10)-5;if (c==0) c=2;
						q[1]=a;
						for (int i = 1; i < size; i++)
							q[i] = (q[i-1]+b)*c;
						
						explain();
						String s = b>0?"+":"";
						explanation += "\nEvery number in this sequence is equal to (previous number "+s+" "+b+") * "+c;			
					}
					else//multily prev number with something, +/- something
					{
						a = r.nextInt(10)+1;
						b = r.nextInt(10)-5;if (b==0) b=2;
						c = r.nextInt(10)-5;if (c==0) c=2;
						q[1]=a;
						for (int i = 1; i < size; i++)
							q[i] = q[i-1]*c+b;
						
						explain();
						String s = b>0?"+":"";
						explanation += "\nEvery number in this sequence is equal to (previous number * " + c + ")" + s + b;			
						
					}
						
					break;
		}
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
while(!isValidSequence()){
		explanation="";
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
				break;
				
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
				break;
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
					break;
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
					break;
			}
		}
		return q;
	}
	
	private boolean isValidSequence()
	{
		if (q[size-1]==q[0]) return false;
		if (q[size-1]>999999 || q[size-1]<-999999 ) return false;
 		return true;
	}
	
	private void explain()
	{
		for (int i = 0; i < size; i++)
		{
				if(i!=size-1)
					explanation += q[i] + ", ";
				else
					explanation += q[i] + ":";						
		}
	}
}

