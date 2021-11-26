AIM:FCFS
PROGRAM:
import java.io.*; 
import java.util.*;
public class FCFS 
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
		System.out.println("-----------------------------------------------------------"); 
		System.out.println("  PROCESS   BT      WT       TAT"); 
		for(int i=0;i<n;i++) 
		{
			System.out.println("    "+PID[ i] + "       "+BT[i]+"       "+WT[i]+"       "+TAT[i]);
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
Enter BT for process 2:12
Enter BT for process 3:13
-----------------------------------------------------------
  PROCESS   BT      WT       TAT
    1       23       0       23
    2       12       23       35
    3       13       35       48
-------------------------------------------------------------
Avg waiting time=19.333334
Avg turn around time=35.333332
