AIM:SJF
PROGRAM:
import java.io.*; 
import java.util.*;
public class SJF
{ 
	public static void main(String args[]) throws Exception 
	{ 
		int n,BT[],WT[],TAT[],PID[]; 
		float AWT=0;
		float ATAT=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("enter no of process: ");
		n = sc.nextInt();
		BT=new int[n]; 
		WT=new int[n]; 
		TAT=new int[n]; 
		PID=new int[n];
		System.out.println("Enter Burst time for each process"); 
		for(int i=0;i<n;i++) 
		{ 
			System.out.print("Enter BT for process "+(i+1)+":"); 
			BT[i]= sc.nextInt();
			PID[i]=i+1;
		}
		System.out.println("The given input data"); 
		System.out.println("-----------------------------------------------------------"); 
		System.out.println("  PROCESS   BT     "); 
		for(int i=0;i<n;i++) 
		{
			System.out.println("    "+ PID[i] + "       "+BT[i]);
		} 
		System.out.println("-------------------------------------------------------------"); 
		for(int i = 0 ; i <n; i++)
		{
			for(int  j=0;  j < n-(i+1) ; j++)
			{
				if( BT[j] > BT[j+1] )
				{
					int temp = BT[j];
					BT[j] = BT[j+1];
					BT[j+1] = temp;
					temp = PID[j];
					PID[j] = PID[j+1];
					PID[j+1] = temp;
				}
			}
		}
		System.out.println("After sorting the given input data"); 
		System.out.println("-----------------------------------------------------------"); 
		System.out.println("  PROCESS   BT       "); 
		for(int i=0;i<n;i++) 
		{
			System.out.println("    "+ PID[i] + "       "+BT[i]);
		} 
		System.out.println("-------------------------------------------------------------"); 
		WT[0]=0;
		for(int i=1;i<n;i++) 
		{ 
			WT[i]=WT[i-1]+BT[i-1];
			AWT=AWT+WT[i];
		} 
		for(int i=0;i<n;i++)
		{ 
			TAT[i]=WT[i]+BT[i]; 
			 ATAT=ATAT+TAT[i]; 
		} 
		System.out.println("Calculated Waiting and turnaround time for the sorted order");
		System.out.println("-----------------------------------------------------------"); 
		System.out.println("  PROCESS   BT      WT       TAT"); 
		for(int i=0;i<n;i++) 
		{
			System.out.println("    "+ PID[i] + "       "+BT[i]+"       "+WT[i]+"       "+TAT[i]);
		} 
		System.out.println("-------------------------------------------------------------"); 
		AWT=AWT/n; 
		System.out.println("Avg waiting time="+AWT);
		ATAT=ATAT/n; 
		System.out.println("Avg turn around time="+ATAT); 
	} 
}
OUTPUT:
enter no of process: 3
Enter Burst time for each process
Enter BT for process 1:23
Enter BT for process 2:25
Enter BT for process 3:12
The given input data
-----------------------------------------------------------
  PROCESS   BT
    1       23
    2       25
    3       12
-------------------------------------------------------------
After sorting the given input data
-----------------------------------------------------------
  PROCESS   BT
    3       12
    1       23
    2       25
-------------------------------------------------------------
Calculated Waiting and turnaround time for the sorted order
-----------------------------------------------------------
  PROCESS   BT      WT       TAT
    3       12       0       12
    1       23       12       35
    2       25       35       60
-------------------------------------------------------------
Avg waiting time=15.666667
Avg turn around time=35.666668
