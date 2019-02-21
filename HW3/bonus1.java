import java.util.Scanner;
public class bonus1
{
	public static void main(String[] args)
	{
		int counter = 0;

		for(int personOne=1;personOne<=100;personOne++)
		{
			for(int personTwo=personOne+1;personTwo<=100;personTwo++)
			{
				for(int personThree=personTwo+1;personThree<=100;personThree++)
				{
					for(int personFour=personThree+1;personFour<=100;personFour++)
					{
						for(int personFive=personFour+1;personFive<=100;personFive++)
						{
							counter++;
						}
					}
				}
			}
		}
		System.out.println("There are "+counter+" possible conversation groups of five at Jeff Bezos' party.");
	}
}