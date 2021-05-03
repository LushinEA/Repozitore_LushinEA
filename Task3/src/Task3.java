import java.util.Arrays;
import java.util.Scanner;

public class Task3 
{
	
    public static void main(String[] args) 
    {
    	Scanner scn = new Scanner(System.in);
    	
    	System.out.println("Задание №1");
        String[][] resArray1 = millionsRounding(new String[][] {{"Nice", "942208"},
                                                               {"Abu Dhabi", "1482816"},
                                                               {"Naples", "2186853"},
                                                               {"Vatican City", "572"}});
        for (String[] strArray : resArray1) 
        {
            System.out.println(Arrays.toString(strArray));
        }
        
        System.out.println("");
        System.out.println("Задание №2");
        System.out.println("Введите длину самой короткой стороны: ");
        double side = scn.nextInt();
        System.out.println(Arrays.toString(otherSides(side)));

        System.out.println("");
        System.out.println("Задание №3");
        System.out.println("Ход 1 игрока: ");
        String player1 = scn.next();
        System.out.println("Ход 2 игрока: ");
        String player2 = scn.next();
        System.out.println(rps(player1, player2));
        
        System.out.println("");
        System.out.println("Задание №4");
        System.out.println("Введите длину массива: ");
        int size = scn.nextInt();
        int[] array = new int[size];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) 
        {
            array[i] = scn.nextInt();
        }
        System.out.println("Разница = " + warOfNumbers(array, size));

        System.out.println("");
        System.out.println("Задание №5");
        System.out.println("Введите слово: ");
        String word = scn.next();
        System.out.println(reverseCase(word));
        
        System.out.println("");
        System.out.println("Задание №6");
        System.out.println("Введите слово: ");
        String inator = scn.next();
        System.out.println(inatorInator(inator));
        
        System.out.println("");
        System.out.println("Задание №7");
        System.out.println("Введите высоту кирпича ");
        int a = scn.nextInt();
        System.out.println("Введите ширину кирпича ");
        int b = scn.nextInt();
        System.out.println("Введите глубину кирпича ");
        int c = scn.nextInt();
        System.out.println("Введите ширину отверстия ");
        int w = scn.nextInt();
        System.out.println("Введите высоту отверстия ");
        int h = scn.nextInt();
        System.out.println("Результат: " + doesBrickFit(a, b, c, w, h));
        
        System.out.println("");
        System.out.println("Задание №8");
        System.out.println("Введите количество топлива (в литрах) ");
        float fuel = scn.nextInt();
        System.out.println("Введите расход топлива на 100км ");
        float basicConsumption = scn.nextInt();
        System.out.println("Введите количество пассажиров ");
        int passengers = scn.nextInt();
        System.out.println("Кондиционер работает? (Введите да или нет) ");
        String conditioner = scn.next();
        System.out.println(totalDistance(fuel, basicConsumption, passengers, conditioner));
        
        System.out.println("");
        System.out.println("Задание №9");
        System.out.println("Введите длину массива: ");
        int size1 = scn.nextInt();
        int[] array1 = new int[size1];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size1; i++) 
        {
            array1[i] = scn.nextInt();
        }
        System.out.println(mean(array1, size1));
        
        System.out.println("");
        System.out.println("Задание №10");
        System.out.println("Введите число: ");
        int chislo = scn.nextInt();
        System.out.println("Результат = " + parityAnalysis(chislo));
        
        scn.close();
    }
    
    
    public static String[][] millionsRounding(String[][] array) 
    {
        for (int i = 0; i < array.length; i++) 
        {
            int population = Integer.parseInt(array[i][1]);
            array[i][1] = String.valueOf(1000000 * Math.round(population / 1000000f));
        }
        return array;
    }

    public static String[] otherSides(double side) 
    {
       String[] answer = new String[2];
       double gip = side*2;
       double sr = side* Math.sqrt(3);
       answer[0] = String.format("%.2f", gip);
       answer[1] = String.format("%.2f", sr);
       return answer;
    }

    public static String rps(String player1, String player2) 
    {
        if (player1.equals(player2))
            return "НИЧЬЯ";
        if ((player1.equals("камень") && player2.equals("ножницы")) ||
            (player1.equals("ножницы") && player2.equals("бумага")) ||
            (player1.equals("бумага") && player2.equals("камень")))
            return "Игрок №1 победил";
        if ((player1.equals("ножницы") && player2.equals("камень")) ||
            (player1.equals("бумага") && player2.equals("ножницы")) ||
            (player1.equals("камень") && player2.equals("бумага")))
            return "Игрок №2 победил";
        return "неправильный ввод";
    }
    
    public static int warOfNumbers(int[] array, int size) 
    {
        int even_sum = 0;
        int odd_sum = 0;
        for (int i =0; i < size; i++)
        {
            if (array[i] % 2 == 0)
                even_sum += array[i];
            else
                odd_sum += array[i];
        }
        return even_sum - odd_sum;
    }

    public static String reverseCase(String word) 
    {
    	
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) 
        {
            if (c >= 65 && c <= 90)
                sb.append((char) (c + 32));
            else
                sb.append((char) (c - 32));
        }
        return sb.toString();
    }

    public static String inatorInator(String inator) 
    {
        int len = inator.length();
        StringBuilder sb = new StringBuilder(inator);
        if ("aeiouy".contains(String.valueOf(inator.toLowerCase().charAt(len - 1))))
            sb.append("-inator ").append(len).append("000");
        else
            sb.append("inator ").append(len).append("000");
        return sb.toString();
    }

    public static boolean doesBrickFit(int a, int b, int c, int w, int h) 
    {
    	int x1 = a*b;
    	int x2 = a*c;
    	int x3 = w*h;
    	if ((x1<=x3)||(x2<=x3))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }

    public static float totalDistance(float fuel, float basicConsumption, int passengers, String conditioner) 
    {
        float consumption = basicConsumption;
        consumption += passengers * basicConsumption * 0.05f;
        if (conditioner == "да")
        consumption += consumption * 0.1f;
        return Math.round(10000 * fuel / consumption) / 100f;
    }

    public static float mean(int[] array1, int size1) 
    {
        int sum = 0;
        for (int i=0; i < size1; i++)
            sum += array1[i];
        return Math.round(100f * sum / size1) /100f;
    }

    public static boolean parityAnalysis(int number)
    {
        int s = 0;
        boolean isNumberEven = number % 2 == 0;
        while (number > 0) 
        {
            s += number % 10;
            number /= 10;
        }
        return isNumberEven == (s % 2 == 0);
    }
}