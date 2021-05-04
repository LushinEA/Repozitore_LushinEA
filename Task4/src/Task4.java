import java.util.Scanner;
import java.util.*;

public class Task4 
{

	public static void main(String[] args) 
	{
		Scanner scn = new Scanner(System.in);
		int a1[] = {2, 55, 60, 97, 86};
		int a2[] = {5, 6, 7, 8, 9, 9};
		String stroka = "hTsii  s aimex dpus rtni.g";
		String sentence = "I just!!! can!!! not!!! believe!!! it!!!";
		String Xsentence = "OMG x box unboxing video x D";
		int a3[] = {9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5};
		int chislo3 = 7977;
		String Osentence = "Watch the characters dance!";
		int chislo1 = 1222;
		int chislo2 = 30277;
		String delete_sentence = "teshahset";
		
		System.out.println("Задание №1");
        System.out.println("Результат: " + find_seven(a1));
        
        System.out.println("");
        System.out.println("Задание №2");
        System.out.println("Результат проверки: " + exercise2(a2));
        
		System.out.println("");
        System.out.println("Задание №3");
        System.out.println(exercise3(stroka));
        
        System.out.println("");
        System.out.println("Задание №4");
        System.out.println(find_simvol(sentence));
        
        System.out.println("");
        System.out.println("Задание №5");
        System.out.println(swap_X(Xsentence));
        
        System.out.println("");
        System.out.println("Задание №6");
        System.out.println(max_difference(a3));
		
        System.out.println("");
        System.out.println("Задание №7");
        System.out.println(cod(chislo3));
        
		System.out.println("");
        System.out.println("Задание №8");
        System.out.println(exercise8(Osentence));
        
		System.out.println("");
        System.out.println("Задание №9");
        System.out.println(mem_sum(chislo1, chislo2));
        
        System.out.println("");
        System.out.println("Задание №10");
        System.out.println(delete_word(delete_sentence));
        
        scn.close();
	}
	
	public static String find_seven(int[] a1) 
	{
		int y = 0;
		int x = 0;
		int count = 0;
		String z = "";
		int size = a1.length;
		for (int i = 0; i < size; i++)
		{
			x = a1[i];
			while ((x > 0) && (y != 7))
			{
				count = count + 10;
				y = x%10;
				x = x/10;
				if (y == 7)
				{
					z = "7 содержится в числе  " + a1[i];
				}
				else
				{
					z = "В массиве нет 7";
				}
			}
		}
		return z;
	}
	
	public static boolean exercise2(int[] a2)
	{
		int size1 = a2.length;
		Arrays.sort(a2);
		int count = 0;
		for (int i = 1; i < a2.length; i++)
        {
            int x = a2[i] - a2[i-1];
            if (x == 1)
            	count = count +1;
        }
		if (count == (size1 - 1))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static String exercise3(String stroka)
	{
		String otvet = "";
		char[] array = stroka.toCharArray();
		for (int i = 0;i <= array.length - 2;i+=2)
		{
			otvet = otvet + array[i + 1] + array[i];
		}
		
		if ( array.length % 2 == 1)
			otvet = otvet + array[array.length-1];
		return otvet;
	}
	
	public static String find_simvol(String sentence)
	{
		String r = "";
		String answer = "";
		for (int i = sentence.length() - 1; i >= 0; --i)
        r += sentence.charAt(i);
		String s = "" + r;
		s = s.replaceFirst("^\\?+" , "?");
		s = s.replaceFirst("^\\!+" , "!");
		for (int i = s.length() - 1; i >= 0; --i)
			answer += s.charAt(i);
		return answer;
	}
	
	public static String swap_X(String Xsentence)
	{
		String s = "";
		String result = "";
		result = Xsentence.replaceAll("\sx{1}\s" , " ecks ");
		s = "" + result;
		result = s.replaceAll("x{1}\s" , "cks ");
		s ="" + result;
		result = s.replaceAll("\sx{1}" , " z");
		s ="" + result;
		result = s.replaceAll("x{1}" , "cks");
		s ="" + result;
		return s;
	}
	
	public static String max_difference(int[] a3)
	{
		int size2 = a3.length;
		int a = 0;
		int b = 0;
		int chislo = 0;
		int max = -999;
		Arrays.sort(a3);
		for (int i =1; i < size2; i++)
		{
			chislo = a3[i]-a3[i-1];
			if (chislo > max)
			{
				max = chislo;
				a = a3[i];
				b = a3[i-1];
			}
		}
		String str = "Наибольшая разница между " + b + " и " + a + ", которая равняется: " + max;
		return str;
	}
	
	public static int cod (int chislo3)
	{
		int number = chislo3;
		int sorted = 0;
		int digits = 10;
		int sortedDigits = 1;
		int result = 0;
		boolean first = true;
		while (chislo3 > 0) 
		{
		    int digit = chislo3 % 10;
		    if (!first) 
		    {

		        int tmp = sorted;
		        int toDivide = 1;
		        for (int i = 0; i < sortedDigits; i++) 
		        {
		            int tmpDigit = tmp % 10;
		            if (digit >= tmpDigit) 
		            {
		                sorted = sorted/toDivide*toDivide*10 + digit*toDivide + sorted % toDivide;
		                break;
		            } 
		            else if (i == sortedDigits-1) 
		            {
		                sorted = digit * digits + sorted;
		            }
		            tmp /= 10;
		            toDivide *= 10;
		        }
		        digits *= 10;
		        sortedDigits += 1;
		    } 
		    else 
		    {
		        sorted = digit;
		    }
		    first = false;
		    chislo3 = chislo3 / 10;
		}
		result = number - sorted;
		if (result > 0)
		{
			return result;
		}
		else
		{
			return 0;
		}
	}
	
	public static char exercise8(String Osentence)
	{
		Osentence = Osentence.toLowerCase();
		char[] word_array = Osentence.toCharArray();
		char[] word = {'a','e','i','o','u','y'};
		int countA = 0,countE = 0,countI = 0,countO = 0,countU = 0,countY = 0;
		for (int i = 0;i <= word_array.length - 2;i++)
		{
			if ((word_array[i] != ' ') && (word_array[i + 1] == ' '))
			{
				switch (word_array[i])
				{
				case 'a':
					countA += 1;
					break;
				case 'e':
					countE += 1;
					break;
				case 'i':
					countI += 1;
					break;
				case 'o':
					countO += 1;
					break;
				case 'u':
					countU += 1;
					break;
				case 'y':
					countY += 1;
					break;
				}
			}
		}
		int[] count_answer = {countA,countE,countI,countO,countU,countY};
		int max = count_answer[0];
		int index_word = -1;
		for (int i = 0;i <= 5;i++)
		{
			if (max < count_answer[i])
			{
				max = count_answer[i];
				index_word = i; 
			}
		}
		 return word[index_word];
	}
	
	public static String mem_sum(int chislo1, int chislo2)
	{
		String answer = "";
		int a = 0;
		int b = 0;
		int sum = 0;
		int remainder1 = 0;
		int remainder2 = 0;;
		if (chislo1 > chislo2)
		{
			a = chislo1;
			b = chislo2;
		}
		else
		{
			a = chislo2;
			b = chislo1;
		}
		while (a > 0)
		{
			remainder1 = a % 10;
			remainder2 = b % 10;
			sum = remainder1 + remainder2;
			answer = sum + answer;
			a = a / 10;
			b = b / 10;
		}
		return answer;
	}
	
	public static String delete_word(String delete_sentence)
	{
		String result = "";
		delete_sentence = new StringBuilder(delete_sentence).reverse().toString();
		delete_sentence = delete_sentence.replaceAll("(.)(?=.*\\1)", "");
		result = new StringBuilder(delete_sentence).reverse().toString();
		return result;
	}
}
