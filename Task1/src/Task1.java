import java.util.Scanner;

public class Task1 
{

	public static void main(String[] args) 
	{

		Scanner scn = new Scanner(System.in);
		/*
		System.out.println("Задание №1");
		System.out.println("Введите количество минут");
		int minute = scn.nextInt();
		System.out.println("В " + minute + " минутах " + convert_secund(minute) + " секунд");
		
		System.out.println(" ");
		System.out.println("Задание №2");
		System.out.println("Введите количество 2-х очковых");
		int score2 = scn.nextInt();
		System.out.println("Введите количество 3-х очковых");
		int score3 = scn.nextInt();
		System.out.println("Общее количество очков = " + result_score(score2, score3));
		
		System.out.println(" ");
		System.out.println("Задание №3");
		System.out.println("Введите количество побед");
		int win = scn.nextInt();
		System.out.println("Введите количество поражений");
		int lose = scn.nextInt();
		System.out.println("Введите количество ничьих");
		int draw = scn.nextInt();
		System.out.println("Общее количество очков команды = " + result_score_match(win, lose, draw));
		
		System.out.println(" ");
		System.out.println("Задание №4");
		System.out.println("Введите число");
		int number = scn.nextInt();
		System.out.println("Результат " + devided_by_5(number));
		*/
		System.out.println(" ");
		System.out.println("Задание №5");
		/*
		System.out.println("Введите число a");
		int a = scn.nextInt();
		System.out.println("Введите число b");
		int b = scn.nextInt();
		*/
		System.out.println("Результат " + func_check(true, false));
		/*
		System.out.println(" ");
		System.out.println("Задание №6");
		System.out.println("Введите количество квадратных метров, которые вы можете закрасить");
		int n = scn.nextInt();
		System.out.println("Введите ширину одной стены в метрах");
		int w = scn.nextInt();
		System.out.println("Введите высоту одной стены в метрах");
		int h = scn.nextInt();
		System.out.println("Краски хватит на " + wall_repair(n, w, h) + " стен");
		
		System.out.println(" ");
		System.out.println("Задание №7");
		System.out.println("Введите число");
		int n7 = scn.nextInt();
		System.out.println("Квадрат числа = " + sqaude(n7));
		
		System.out.println(" ");
		System.out.println("Задание №8");
		System.out.println("Введите prob");
		double prob = scn.nextDouble();
		System.out.println("Введите prize");
		int prize = scn.nextInt();
		System.out.println("Введите pay");
		int pay = scn.nextInt();
		System.out.println("Результат: " + profit(prob, prize, pay));
		
		System.out.println(" ");
		System.out.println("Задание №9");
		System.out.println("Введите FPS");
		int FPS = scn.nextInt();
		System.out.println("Введите количество минут");
		int minute8 = scn.nextInt();
		System.out.println("Результат: " + cadr_FPS(FPS, minute8));
		
		System.out.println(" ");
		System.out.println("Задание №10");
		System.out.println("Введите число");
		int number10 = scn.nextInt();
		System.out.println("Введите делитель");
		int divisor = scn.nextInt();
		System.out.println("Остаток = " + func_div(number10, divisor));
		*/
		scn.close();
	}
	
	public static int convert_secund(int minute)
	{
		int secund = minute*60;
		return secund;
	}
	
	public static int result_score(int score2, int score3)
	{
		int score = score2*2+score3*3;
		return score;
	}
	
	public static int result_score_match(int win, int lose, int draw)
	{
		int result = win*3+lose*0+draw;
		return result;
	}
	
	public static boolean devided_by_5(int number)
	{
		if (number % 5 == 0)
			return true;
		else
		    return false;
	}
	
	public static boolean func_check(boolean a, boolean b)
	{
		return (a && b);
	}
	
	public static int wall_repair(int n, int w, int h)
	{
		int result_6 = n/(w*h);
		return result_6;
	}
	
	public static int sqaude(int n7)
	{
		return n7*n7;
	}
	
	public static boolean profit(double prob, int prize , int pay)
	{
		if (prob * prize - pay > 0)
			return true;
		else 
			return false;
	}
	
	public static int cadr_FPS(int FPS, int minute8)
	{
		int answer = FPS*(minute8*60);
		return answer;
	}
	
	public static int func_div(int number10, int divisor)
	{
		int chislo10 = number10/divisor;
		int chislo10_1 = chislo10 * divisor;
		int result10 = number10-chislo10_1;
		return result10;
	}
}
