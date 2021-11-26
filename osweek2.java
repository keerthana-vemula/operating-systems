AIM:SIMULATE MULTI-LEVEL QUEUE SCHEDULING ALGORITHM BY CONSIDERING THE FOLLOWING SCENARIO.
ALL THE PROCESS IN THE SYSTEM ARE DIVIDED INTO TWO CATEGORIES-SYSTEM PROCESSES AND USER PROCESSES
SYSTEM PROCESS ARE TO BE GIVEN HIGHER PRORITY THAN USER PROCESSES.THE PRORITY OF EACH PROCESS RANGES FROM 1 TO 3.
USE FIXED PRIORITY SCHEDULING FOR ALL PROCESSES.

PROGRAM:
import java.util.Scanner;
class osweek2
{
	public static void main(String args[])
 	{
		Scanner sc=new Scanner(System.in);
		int i, k, n, temp;
		float wtavg, tatavg;
		System.out.println("Enter the number of processes --- ");
		n=sc.nextInt();
		int p[]=new int[n];
		int bt[]=new int[n];
		int su[]=new int[n];
		int wt[]=new int[n];
		int tat[]=new int[n];
		for(i=0;i<n;i++)
		{
			p[i] = i;
			System.out.println("Enter the Burst Time of Process "+i+":");
			bt[i]=sc.nextInt();
			System.out.println("System/User Process (0/1) ? --- ");
			su[i]=sc.nextInt();
		}
		for(i=0;i<n;i++)
			for(k=i+1;k<n;k++)
				if(su[i] > su[k])
				{
					temp=p[i];
					p[i]=p[k];
					p[k]=temp;
					temp=bt[i];
					bt[i]=bt[k];
					bt[k]=temp;
					temp=su[i];
					su[i]=su[k];
					su[k]=temp;
				}
		wtavg = wt[0] = 0;
		tatavg = tat[0] = bt[0];
		for(i=1;i<n;i++)
		{
			wt[i] = wt[i-1] + bt[i-1];
			tat[i] = tat[i-1] + bt[i];
			wtavg = wtavg + wt[i];
			tatavg = tatavg + tat[i];
		}
		System.out.println("\nPROCESS\tSYSTEM/USER PROCESS \tBURST TIME\tWAITING TIME\tTURNAROUND TIME");
		for(i=0;i<n;i++)
			System.out.println(p[i]+"\t"+su[i]+"\t\t"+bt[i]+"\t"+wt[i]+"\t\t"+tat[i]);
		System.out.println("\nAverage Waiting Time is --- "+ wtavg/n);
		System.out.println("\nAverage Turnaround Time is ---"+ tatavg/n);
	}
}
OUTPUT:
Enter the number of processes ---
2
Enter the Burst Time of Process 0:
12
System/User Process (0/1) ? ---
1
Enter the Burst Time of Process 1:
11
System/User Process (0/1) ? ---
1

PROCESS SYSTEM/USER PROCESS     BURST TIME      WAITING TIME    TURNAROUND TIME
0       1               12      0               12
1       1               11      12              23

Average Waiting Time is --- 6.0

Average Turnaround Time is ---17.5