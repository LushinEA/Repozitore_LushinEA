import java.util.Scanner;

public class Task1 
{

	public static void main(String[] args) 
	{

		Scanner scn = new Scanner(System.in);
		/*
		System.out.println("������� �1");
		System.out.println("������� ���������� �����");
		int minute = scn.nextInt();
		System.out.println("� " + minute + " ������� " + convert_secund(minute) + " ������");
		
		System.out.println(" ");
		System.out.println("������� �2");
		System.out.println("������� ���������� 2-� �������");
		int score2 = scn.nextInt();
		System.out.println("������� ���������� 3-� �������");
		int score3 = scn.nextInt();
		System.out.println("����� ���������� ����� = " + result_score(score2, score3));
		
		System.out.println(" ");
		System.out.println("������� �3");
		System.out.println("������� ���������� �����");
		int win = scn.nextInt();
		System.out.println("������� ���������� ���������");
		int lose = scn.nextInt();
		System.out.println("������� ���������� ������");
		int draw = scn.nextInt();
		System.out.println("����� ���������� ����� ������� = " + result_score_match(win, lose, draw));
		
		System.out.println(" ");
		System.out.println("������� �4");
		System.out.println("������� �����");
		int number = scn.nextInt();
		System.out.println("��������� " + devided_by_5(number));
		*/
		System.out.println(" ");
		System.out.println("������� �5");
		/*
		System.out.println("������� ����� a");
		int a = scn.nextInt();
		System.out.println("������� ����� b");
		int b = scn.nextInt();
		*/
		System.out.println("��������� " + func_check(true, false));
		/*
		System.out.println(" ");
		System.out.println("������� �6");
		System.out.println("������� ���������� ���������� ������, ������� �� ������ ���������");
		int n = scn.nextInt();
		System.out.println("������� ������ ����� ����� � ������");
		int w = scn.nextInt();
		System.out.println("������� ������ ����� ����� � ������");
		int h = scn.nextInt();
		System.out.println("������ ������ �� " + wall_repair(n, w, h) + " ����");
		
		System.out.println(" ");
		System.out.println("������� �7");
		System.out.println("������� �����");
		int n7 = scn.nextInt();
		System.out.println("������� ����� = " + sqaude(n7));
		
		System.out.println(" ");
		System.out.println("������� �8");
		System.out.println("������� prob");
		double prob = scn.nextDouble();
		System.out.println("������� prize");
		int prize = scn.nextInt();
		System.out.println("������� pay");
		int pay = scn.nextInt();
		System.out.println("���������: " + profit(prob, prize, pay));
		
		System.out.println(" ");
		System.out.println("������� �9");
		System.out.println("������� FPS");
		int FPS = scn.nextInt();
		System.out.println("������� ���������� �����");
		int minute8 = scn.nextInt();
		System.out.println("���������: " + cadr_FPS(FPS, minute8));
		
		System.out.println(" ");
		System.out.println("������� �10");
		System.out.println("������� �����");
		int number10 = scn.nextInt();
		System.out.println("������� ��������");
		int divisor = scn.nextInt();
		System.out.println("������� = " + func_div(number10, divisor));
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
