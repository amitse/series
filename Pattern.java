import java.io.*;
class Pattern
{
		public static void main(String args[])
		{
			double input[] = new double[args.length];
			
			for (int i = 0; i < input.length; i++)
			{
				input[i]=Double.parseDouble(args[i]);
			}
			
			AP(input,0);GP(input,0);
			AP(input,5);
			GP(input,1);
			
		}
		


		// AP = a+ (n-1) *d
		
		static void AP (double[] series,int type)
		{
			int length = series.length;
			double series2[];
			
			
			if (type>0)
			{
				series2 = new double[series.length];
				for (int i = 0; i <series.length ; i++)
				{
					series2[i]=series[i];
				}
				
				for (int i = 1; i < series.length; i++)
				{
					series[i]=series2[i+1]- series2[i];
				}
				
				AP(series2,type--);
			}
			
			
			double diff=series[1]-series[0];
			boolean isAP=true;
			for (int i = 1; i < length; i++)
			{
				if(series[i]-series[i-1]!=diff)
				{
					isAP=false;
					break;
				}
			}
			if(isAP)
			{
				System.out.print("\n\tAP\t");
				System.out.println("General Form\t" + series[0]+" +(n-1) * "+ diff);
				for (int i = 1; i < length+5; i++)
				{
					System.out.print(series[0] + (i-1) *diff + "\t");
				}
				System.out.println("\n==========================");
				
			}
			
		}

		static void GP (double[] series,int type)
		{
			int length = series.length;
			
			try{
			double diff=series[1]/series[0];
			boolean isGP=true;
			for (int i = 1; i < length; i++)
			{
				if(diff!=series[i]/series[i-1])
				{
					isGP=false;
					break;
				}
			}
			if(isGP)
			{
				System.out.print("\n\tGP\t");
				System.out.println("General Form\t" + series[0]+" * "+ diff + "^n");
				double op=series[0];
				for (int i = 1; i < length+5; i++)
				{	
					System.out.print(op + "\t");
					op=op*diff;
				}
				System.out.println("\n==========================");
				
			}
		}catch(Exception e){}
			
		}


		//a * X^n + b -- Power Series 
}
