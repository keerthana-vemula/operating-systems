AIM:1.PRODUCER CONSUMER

PROGRAM:
import java.io.*;
import java.util.Scanner;
class ProducerConsumer
{
	static int mutex=1,full=0,empty=3,x=0;;
	public void producer()
	{
		mutex=wait(mutex);
		full=signal(full);
		empty=wait(empty);
		x++;
		System.out.println("\nProducer produces the item "+x);
		mutex=signal(mutex);
	}
	public void consumer()
	{
		mutex=wait(mutex);
		full=wait(full);
		empty=signal(empty);
		System.out.println("\nConsumer consumes item "+x);
		x--;
		mutex=signal(mutex);
	}
	int wait(int s)
	{
		return (--s);
	}
 
	int signal(int s)
	{
		return(++s);
	}
	public static void main(String args[])throws IOException
	{
		ProducerConsumer obj=new ProducerConsumer();
		int n;
		while(true)
		{
			System.out.print("\n1.produce\n2.consume\n3.exit\nEnter your choice:");
			Scanner sc=new Scanner(System.in);
			n=sc.nextInt();
			switch(n)
			{
				case 1: if((mutex==1)&&(empty!=0))
					obj.producer();
				             else
					System.out.print("Buffer is full!!");
				             break;
				case 2: if((mutex==1)&&(full!=0))
					obj.consumer();
				              else
					System.out.print("Buffer is empty!!");
				              break;
				case 3: System.exit(0);
				default: System.out.print("Enter your valid choice:\n");
			}
		}
	}
		
}
OUTPUT:
1.producer
2.consumer
3.exit
enter your choice:1
producer produces the item 1

1.producer
2.consumer
3.exit
enter your choice:2
consumer consumes item 1

