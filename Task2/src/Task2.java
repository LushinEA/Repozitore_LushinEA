import java.util.Scanner;
public class Task2 {

	public static void main(String[] args)
	{
		Scanner scn = new Scanner(System.in);
		/*
		System.out.println("Задание №1");
		System.out.println("Введите номера дома");
		int number = scn.nextInt();
		System.out.println("Введите длину улицы");
		int length = scn.nextInt();
		System.out.println("Номер противоположного дома = " + find_house(number, length));
		
		System.out.println(" ");
		System.out.println("Задание №2");
		System.out.println("Введите пожалуйста Имя и Фамилию");
		String name = scn.nextLine();
		System.out.println(split_word(name));
		
		System.out.println(" ");
		System.out.println("Задание №3");
		System.out.println("Введите цену");
		int cell = scn.nextInt();
		System.out.println("Введите процент скидки");
		double discount = scn.nextInt();
		System.out.println("Цена после скидки = " + sale_price(cell, discount));
		
		System.out.println(" ");
		System.out.println("Задание №4");
		System.out.println("Введите размер массива ");
	    int size = scn.nextInt();
	    int[] array = new int[size];
	    System.out.println("Введите элементы массива ");
	    for (int i = 0; i < size; i++) 
		{
			array[i] = scn.nextInt();
		}
	    System.out.println("Разница между максимальным и минимальным элементом = " + find_min_max(array));
	    
	    System.out.println(" ");
		System.out.println("Задание №5");
		System.out.println("Введите число a ");
	    int a = scn.nextInt();
	    System.out.println("Введите число b ");
	    int b = scn.nextInt();
	    System.out.println("Введите число c ");
	    int c = scn.nextInt();
	    System.out.println("Количество одинаковых чисел = " + find_number(a, b, c));
	    
	    System.out.println(" ");
		System.out.println("Задание №6");
		System.out.println("Введите слово или фразу: ");
	    String s = scn.next();
		System.out.println(reverseString(s));
		*/
		System.out.println(" ");
		System.out.println("Задание №7");
		System.out.println("Введите зарплату 1 программиста ");
	    int prog1 = scn.nextInt();
	    System.out.println("Введите зарплату 2 программиста ");
	    int prog2 = scn.nextInt();
	    System.out.println("Введите зарплату 3 программиста ");
	    int prog3 = scn.nextInt();
	    System.out.println("Разница между наибольшей и наименьшей зарплатой = " + count_salary(prog1, prog2, prog3));
	    
	    System.out.println(" ");
		System.out.println("Задание №8");
		System.out.println("Введите набор символов");
		String words = scn.nextLine();
		System.out.println("Результат " + find(words));
		
		System.out.println(" ");
		System.out.println("Задание №9");
		System.out.println("Введите предложение ");
		String line = scn.nextLine();
		System.out.println(line_bomb(line));
		
		System.out.println(" ");
		System.out.println("Задание №10");
		System.out.println("Введите первое предложение");
		String first_line = scn.nextLine();
		System.out.println("Введите второе предложение");
		String second_line = scn.nextLine();
		System.out.println("Результат: " + func(first_line,second_line));
		
		scn.close();
	}
	
	public static int max_house(int number, int length) 
	{
		int chislo;
		if (number % 2 ==0)
		{
			chislo = 2;
		}
		else
		{
			chislo = 1;
		}
		for (int i=1; i<length; i++)
		{
			chislo = chislo +2;
		}
		return chislo;
	}
	
	public static int find_house(int number, int length) 
	{
		int house;
		if (number % 2 ==0)
		{
			house = max_house(number, length) - number +1;
		}
		else
		{
			house = max_house(number, length) - number +2;
		}
		return house;
	}
	
	public static String split_word(String name) 
	{
		String[] arr2_1 = name.split(" ",2);
		String arr2_2 = (arr2_1[1]+" "+arr2_1[0]);
        return arr2_2;
	}
	
	public static double sale_price(int cell, double discount) 
	{
		discount = discount*0.01;
		double result3 = cell*(1-discount);
		return result3;
	}
	
	public static int find_min_max(int[] array) 
	{
			int max = -999;
			int min = 999;
			for(int i=0; i<array.length; i++) 
			{
				if (max < array[i]) 
					max = array[i];
				if (min > array[i]) 
					min = array[i];
			}
			int result4 = max - min;
			return result4;
	}
	
	public static int find_number(int a, int b, int c) 
	{
		int count;
		if((a == b) && (a == c) && (b == c))
	    {
	    	count =3;
	    }
	    else
	    	if (((a == b) && (a!=c) && (b!=c)) || ((a != b) && (a!=c) && (b==c)) || ((a != b) && (a==c) && (b!=c)))
	    	{
	    		count =2;
	    	}
	    		else
	    		{
	    			count =0;
	    		}
		return count;
	}
	
	public static String reverseString(String s)
	{
		String r = "";
		for (int i = s.length() - 1; i >= 0; --i)
            r += s.charAt(i);
        return r;
	}
	
	public static int count_salary(int prog1, int prog2, int prog3) 
	{
		int max = -999;
		int min = 999;
			if (prog1 > prog2)
		    {
		    		max = prog1;
		    }
		    else
		    {
		    	max = prog2;
		    }
		    if (prog3 > max)
		    	max = prog3;
		    if (prog1 < prog2)
		    {
		    		min = prog1;
		    }
		    else
		    {
		    	min = prog2;
		    }
		    if (prog3 < min)
		    	min = prog3;
		    int answer = max - min;
		    return answer;
	}
	
	public static boolean find(String words)
	{
		int countO = 0;
		int countX = 0;
		char[] array = words.toCharArray();
		for (int i = 0;i <= words.length()-1;i++)
		{
			if ((array[i] == 'o') || (array[i] == 'O'))
				countO +=1;
			else if ((array[i] == 'x') || (array[i] == 'X'))
				countX +=1;	
		}
		
		if ((countO != 0) && (countX != 0))
			return countO == countX;
		else 
			return false;
	}
	
	public static String line_bomb(String line)
	{
		String bomb4 ="";
		String bomb1 = "бомба";
		String bomb2 = "БОМБА";
		String bomb3 = "Бомба";
		if (line.contains(bomb1)|| line.contains(bomb2) || line.contains(bomb3))
			bomb4 = "ЛОЖИСЬ!";
		else 
			bomb4 = "Расслабься, это не бомба";
		return bomb4;
	}
	
	public static boolean func(String first_line,String second_line)
	{
		int Askii1 = 0;
		char[] array1 = first_line.toCharArray();
		for (int i = 0;i <= first_line.length()-1;i++)
		{
			Askii1 = Askii1 + (int) array1[i];
		}
		
		int Askii2 = 0;
		char[] array2 = second_line.toCharArray();
		for (int i = 0;i <= second_line.length()-1;i++)
		{
			Askii2 = Askii2 + (int) array2[i];
		}
		return Askii1 == Askii2;
	}
}
