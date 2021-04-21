public class Point3d extends Point2d 
{
	
	private double xCoord;
	private double yCoord;
	private double z2Coord;
	Point2d a = new Point2d(xCoord,yCoord);
	double x = a.getX();
	double y = a.getY();
	
	public Point3d(double x, double y, double z)
	{
		xCoord = x;
		yCoord = y;
		z2Coord = z;
	}
	
	public Point3d()
	{
		this(0.0,0.0,0.0);
	}
	
	public void setZ2(double val)
	{
		z2Coord = val;
	}
	
	public double getZ2()
	{
		return z2Coord;
	}
	
	public static boolean comparison2(Point3d a,Point3d b)
	{
		if ((a.getX() == b.getX()) && (a.getY() == b.getY()) && (a.getZ2() == b.getZ2()))
			return true;
		else 
			return false;
	}
	
	public static double distanseTo(Point3d a,Point3d b)
	{
		double ABx = b.getX() - a.getX();
		double ABy = b.getY() - a.getY();
		double ABz = b.getZ2() - a.getZ2();
		double answer = Math.sqrt(Math.pow(ABx, 2) + Math.pow(ABy, 2) + Math.pow(ABz, 2));
		return answer;
	}
}