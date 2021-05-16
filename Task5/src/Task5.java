import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Task5 
{
	public static void main(String[] args) 
	{
		Scanner scn = new Scanner(System.in);
		
		String stroka1 = "FFFF";
		String stroka2 = "ABCD";
		int number = 121317;
		String[] str4 = {"cat", "create", "sat"};
		String str1 = "caster";
		int[] array = {1, 2, 3, 5, 6, 7, 8, 9};
		int[] array1 = {95, 83, 90, 87, 88, 93};
		String sentence = "Tesh3 th5e 1I lov2e way6 she7 j4ust i8s.";
		int number1 = 9132;
		int number2 = 5564;
		String townA = "New York";
		String date = "December 31, 1970 13:40";
		String townB = "Beijing";
		int new_number = 321;
		String start = "B2";
		String end = "H4";
		
		
		System.out.println("Задание №1");
		System.out.println("Результат проверки строк на одинаковый шаблон: " + comparison(stroka1, stroka2));
		
		System.out.println("");
		System.out.println("Задание №2");
		System.out.println("Result " + spiderVsFly(start, end));
		
		
		System.out.println("");
		System.out.println("Задание №3");
        System.out.println("В числе " + number + " количество цифр = " + recursion (number));
        
        System.out.println("");
		System.out.println("Задание №4");
		System.out.println(zadanie4(str4, str1));
		
		System.out.println("");
		System.out.println("Задание №5");
        System.out.println("Длина самой длинной последовательности в массиве = " + max_length(array));
        
        System.out.println("");
		System.out.println("Задание №6");
        System.out.println("Ваш результат за тест = " + result_test(array1) + "%");
        
        System.out.println("");
		System.out.println("Задание №7");
		System.out.println("Вы ввели: " + sort_sentence(sentence));
		
		System.out.println("");
		System.out.println("Задание №8");
		System.out.println("Результат: " + max_number(number1, number2));
		
		System.out.println("");
		System.out.println("Задание №9");
		System.out.println("Результат: " + city_time(townA, date, townB));
		
		System.out.println("");
		System.out.println("Задание №10");
		System.out.println("Результат: " + new_number(new_number));
		
		scn.close();
	}

	public static boolean comparison(String stroka1, String stroka2)
	{
		int index = 1;
		int[] array_char1 = new int[stroka1.length()];
		int[] array_char2 = new int[stroka2.length()];
		int[] flag1 = new int[stroka1.length()];
		int[] flag2 = new int[stroka2.length()];
		
		for (int i = 0;i < stroka1.length();i++)
		{
			if (flag1[i] == 1)
				continue;
			{
				for (int j = 0;j < stroka1.length();j++)
				{
					if (stroka1.charAt(i) == stroka1.charAt(j))
					{
						array_char1[j] = index;
						flag1[j] = 1;
					}
				}
				index = index + 1;
			}
		}
		index = 1;
		
		for (int i = 0;i < stroka2.length();i++)
		{
			if (flag2[i] == 1)
				continue;
			{
				for (int j = 0;j < stroka2.length();j++)
				{
					if (stroka2.charAt(i) == stroka2.charAt(j))
					{
						array_char2[j] = index;
						flag2[j] = 1;
					}
				}
				index = index + 1;
			}
		}
		return Arrays.equals(array_char1, array_char2);
	}
	public static ArrayList<Integer> dijkstra(double[][] weights, int start, int end) {
        double[] dist = new double[weights.length]; //массив расстояния
        Arrays.fill(dist, Double.POSITIVE_INFINITY); // устанаавливаем расстояние до всех вершин INF
        dist[start] = 0; // для начальной вершины положим 0
        boolean[] used = new boolean[weights.length]; // массив пометок
        Arrays.fill(used, false); // устанаавливаем метку до всех вершин false
        double min_dist = 0;
        int min_vertex = start;
        int[] p = new int[weights.length + 1];
        p[weights.length] = -1;
        p[start] = weights.length;
        while (min_dist < Double.POSITIVE_INFINITY)
        {
            int i = min_vertex;
            used[i] = true;
            for (int j = 0; j < dist.length; ++j)
                if (dist[i] + weights[i][j] < dist[j]) {
                    dist[j] = dist[i] + weights[i][j];
                    p[j] = i;
                }


            min_dist = Double.POSITIVE_INFINITY;
            for (int j = 0; j < dist.length; ++j)
                if (!used[j] && dist[j] < min_dist)
                {
                    min_dist = dist[j];
                    min_vertex = j;
                }
        }
        ArrayList<Integer> path = new ArrayList<>();
        while (end != -1)
        {
            path.add(end);
            end = p[end];
        }
        return path;
    }

    public static String spiderVsFly(String a, String v) {

        int startI = Character.digit(a.charAt(1), 10);
        int startJ = a.charAt(0) - 65; // 'A' - 65 = 0; 'B' - 65 = 1...
        int endI = Character.digit(v.charAt(1), 10);
        int endJ = v.charAt(0) - 65;
        double[][] web = new double[40][40];
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++){
                web[i][j] = Double.POSITIVE_INFINITY;
            }
        }
      //  double k = Math.sqrt(Math.sqrt(2) / (1 + Math.sqrt(2))); // a = R*k
        double k = Math.PI/4;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                if (j < 7) {
                    web[i * 8 + j][i * 8 + j + 1] = i * k;
                    web[i * 8 + j + 1][i * 8 + j] = i * k;
                }
                else{
                    web[i * 8][i * 8 + j] = i * k;
                    web[i * 8 + j][i * 8] = i * k;
                }
                if (i < 4) {
                    web[i * 8 + j][(i + 1) * 8 + j] = 1;
                    web[(i + 1) * 8 + j][i * 8 + j] = 1;
                }
            }
        }
        ArrayList<Integer> res = dijkstra(web, startI * 8 + startJ, endI * 8 + endJ);
        StringBuilder sb = new StringBuilder();
        for (int i = res.size() - 2; i >= 0; i--){
            sb.append((char) (res.get(i) % 8 + 65)).append(res.get(i) / 8).append('-');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString().replaceAll("[A-H]0.+[A-H]0", "A0");
    }
	
	public static int recursion (int number)
	{
		if (number < 10)
		{
			return 1;
		}
		else
		{
			return 1 + recursion(number/10);
		}
	}
	
	public static int zadanie4(String[] str4, String str1)
	{
		int[] flag = new int[6];
		int[] flagwords = new int[6];
		int answer = 0;
		int sum = 0;
		for (int i = 0; i < str4.length;i++)
		{
			for (int j = 0; j < 6;j++)
			{
				for (int z = 0; z < str4[i].length();z++)
				{
					if (flagwords[z] == 1)
						continue;
					{
						if (str1.charAt(j) == str4[i].charAt(z))
						{
							flag[j] = 1;
							flagwords[z] = 1;
						}
					}
				}
			}
			sum = Arrays.stream(flag).sum();
			Arrays.fill(flag, 0);
			Arrays.fill(flagwords, 0);
			if (sum == str4[i].length())
			{
				switch(sum)
				{
				case 3:
					answer += 1;
					break;
				case 4:
					answer += 2;
					break;
				case 5:
					answer +=3;
					break;
				case 6:
					answer += 54;
					break;
				default:
					answer += 0;
					break;
				}
			}
		}
		return answer;
	}
	
	public static int max_length(int [] array)
	{
		int max = -1;
		int count = 1;
		for (int i = 0;i < array.length - 2;i++)
		{
			if (array[i+1] - array[i] == 1)
			{
				count = count + 1;
			}
			else
			{
				count = 1;
			}
			if (count > max)
			{
				max = count;
			}
		}
		return max;
	}
	
	public static int result_test(int[] array1)
	{
		int size1 = array1.length;
		int summ = Arrays.stream(array1).sum();
		int size_me = size1+1;
		double sred_znach = (summ/size1);
		int answer = (int) Math.round(size_me * (sred_znach-5) - summ);
		return answer;
	}
	
	public static String sort_sentence(String sentence)
	{
		int count = 0;
		String[] sentence_array = sentence.split(" ");
		String[] new_sentence_array = new String[sentence_array.length];
		for (int i = 0;i <= sentence_array.length - 1;i++)
		{
			for (int j = 1;j <= sentence_array.length;j++)
			{
				String chislo = String.valueOf(j);
				int key = sentence_array[i].indexOf(chislo);
				if (key != -1)
				{
					count = count +1;
					new_sentence_array[Integer.parseInt(chislo) - 1] = sentence_array[i];
					new_sentence_array[Integer.parseInt(chislo) - 1] = sentence_array[i].replace(chislo, "");
				}
			}
		}
		if (count == 0)
			return "";
		else
			return String.join(" ",new_sentence_array);
	}
	
	public static String max_number(int number1, int number2)
	{
		String str1 = Integer.toString(number1);
        String[]numb1=str1.split("");
        String answer = "";
        int numArr1[] = new int[numb1.length];
           for (int i = 0; i < numb1.length; i++) 
           {
            numArr1[i] = Integer.parseInt(numb1[i]); 
           }
           
           String str2 = Integer.toString(number2);
           String[]numb2=str2.split("");
           int numArr2[] = new int[numb2.length];
              for (int i = 0; i < numb2.length; i++) 
              {
               numArr2[i] = Integer.parseInt(numb2[i]); 
              }
              
              for (int i = 0; i < numArr1.length; i++)
              {
            	  for (int j =0; j < numArr2.length; j++)
            	  {
            		  if (numArr1[i] < numArr2[j])
            		  {
            			  numArr1[i] = numArr2[j];
            			  numArr2[j] = 0;
            		  }
            	  }
              }
              
              for (int i=0; i <numArr1.length; i++)
              {
            	  answer = answer + numArr1[i];
              }
              return answer;
	}
	
	public static String city_time(String townA,String date,String townB)
	{
		String answer = "";
		date = date.replace(",", "");
		date = date.replace(":", " ");
		String[] dateS = date.split(" ");
		String monthS = dateS[0];
		int hour = Integer.parseInt(dateS[3]);
		int minutes = Integer.parseInt(dateS[4]);
		int dateNum = Integer.parseInt(dateS[1]);
		int year = Integer.parseInt(dateS[2]);
		int monthIndex = 0;
		String[] towns = {"Los Angeles","New York","Caracas","Buenos Aires","London","Rome","Moscow","Tehran","New Delhi","Beijing","Canberra"};
		String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		int[] townsTime = {-480,-300,-270,-180,0,60,180,210,330,480,600};
		int indexOne = 0, indexTwo = 0;
		for (int i = 0;i < towns.length;i++)
		{
			if (towns[i].equals(townA))
				indexOne = i;
			if (towns[i].equals(townB))
				indexTwo = i;
		}
		
		for (int i = 0;i < months.length;i++)
		{
			if (monthS.equals(months[i]))
				monthIndex = i;
		}
		
		Calendar calendar = new GregorianCalendar(year, monthIndex , dateNum);
		calendar.set(Calendar.HOUR,hour);
		calendar.set(Calendar.MINUTE,minutes);
		
		calendar.add(Calendar.MINUTE,Math.max(townsTime[indexOne],townsTime[indexTwo]) - Math.min(townsTime[indexOne],townsTime[indexTwo]));
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-M-d HH:mm");
		answer = formater.format(calendar.getTime());
		return answer;
	}
	
	public static boolean new_number(int new_number)
	{
		int count =0;
		String str = Integer.toString(new_number);
		str = str.replaceAll("0", "");
        String[]numb=str.split("");
        int numArr[] = new int[numb.length];
           for (int i = 0; i < numb.length; i++) 
           {
            numArr[i] = Integer.parseInt(numb[i]); 
           }
           for (int i =0; i < numArr.length-1; i++)
           {
        	   if (numArr[i] >numArr[i+1])
        	   {
        		   count = count +1;
        	   }
        	   else
        	   {
        		   count = count +0;
        	   }
           }
           if (count > 0)
           {
        	   return false;
           }
           else
           {
        	   return true;
           }
	}
}
