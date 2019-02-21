import java.util.Scanner;
public class Combinations
{
	public static void main(String[] args)
	{
		int counter = 0;

		for(int personOne=1;personOne<=100;personOne++)//set personOne to 1 since they are the first person.
		{
			for(int personTwo=personOne+1;personTwo<=100;personTwo++)//adds one to person two to keep from repeating the first person.
			{
				for(int personThree=personTwo+1;personThree<=100;personThree++)
				{
					for(int personFour=personThree+1;personFour<=100;personFour++)
					{
						counter++;
					}
				}
			}
		}
		System.out.println("There are "+counter+" possible conversation groups of four at Jeff Bezos' party.");
	}
}