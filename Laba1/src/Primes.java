public class Primes 
{
	public static void main(String[] args) 
	{
		for (int i=2; i<=100; i++)
		{
			if (isPrime(i) == true)
			System.out.println(i);
		}
	}
	
	public static boolean isPrime(int n)
	{
		int count =0;
		for (int i=2; i<n; i++)
		{
			if ((n%i) == 0)
				count++;
		}
		if (count<1)
			return true;
		else
			return false;
	}
}
