import java.util.Scanner;

public class Lab1 extends Point3d {
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		Point3d a = new Point3d();
		Point3d b = new Point3d();
		Point3d c = new Point3d();
		System.out.println("Введите значение X первого объекта");
		a.setX(scn.nextDouble());
		System.out.println("Введите значение Y первого объекта");
		a.setY(scn.nextDouble());
		System.out.println("Введите значение Z первого объекта");
		a.setZ2(scn.nextDouble());
		System.out.println("Введите значение X второго объекта");
		b.setX(scn.nextDouble());
		System.out.println("Введите значение Y второго объекта");
		b.setY(scn.nextDouble());
		System.out.println("Введите значение Z второго объекта");
		b.setZ2(scn.nextDouble());
		System.out.println("Введите значение X третьего объекта");
		c.setX(scn.nextDouble());
		System.out.println("Введите значение Y третьего объекта");
		c.setY(scn.nextDouble());
		System.out.println("Введите значение Z третьего объекта");
		c.setZ2(scn.nextDouble());
		scn.close();
		System.out.println(String.format("%.2f", distanseTo(a,b)));
		if (comparison2(a,b) == false)
			System.out.println(computeArea(a,b,c));
		else
			System.out.println("Вы ввели две одинаковые точки");


	}
	
	public static double computeArea(Point3d a,Point3d b,Point3d c)
	{
		double ABx = b.getX() - a.getX();
		double ABy = b.getY() - a.getY();
		double ABz = b.getZ2() - a.getZ2();
		double ACx = c.getX() - a.getX();
		double ACy = c.getY() - a.getY();
		double ACz = c.getZ2() - a.getZ2();
		double forDeti = ABy * ACz - ABz * ACy;
		double forDetj = ABz * ACx - ABx * ACz; 
		double forDetk = ABx * ACy - ACx * ABy;
		double modulC = Math.sqrt(Math.pow(forDeti,2) + Math.pow(forDetj,2) + Math.pow(forDetk,2));
		double answer = 1.0/2 * modulC;
		return answer;
	}
}