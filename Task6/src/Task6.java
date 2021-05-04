import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Task6 
{
	public static void main(String[] args) 
	{
		String stroka1 = "My world evolves in a beautiful space called Tesh.";
		String stroka2 = "sworn love lived";
		String str = "intercontinentalisationalism";
		int razrez = 6;
		String message = "myworldevolvesinhers";
		String key = "tesh";
		int[] array = {1, 2, 3, 9, 4, 5, 15, 3};
		int n = 45;
		int number = 6;
		String chislo = "0.(6)";
		String s = "HOWINEEDADRINKALCOHOLICINNATUREAFTERTHEHEAVYLECTURESINVOLVINGQUANTUMMECHANICSANDALLTHESECRETSOFTHEUNIVERSE";
		int binary_chislo = 2;
		String s1 = "aabbcd";
		int[] arr = {1, 6, 5, 4, 8, 2, 3, 7};
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Задание №1");
		System.out.println("Результат " + hiddenAnagram(stroka1, stroka2));
		
		System.out.println("");
		System.out.println("Задание №2");
		System.out.println("Результат " + Arrays.toString(collect(str, razrez)));
		
		System.out.println("");
		System.out.println("Задание №3");
		System.out.println("Результат " + Nico(message, key));
		
		System.out.println("");
		System.out.println("Задание №4");
        System.out.println("Результат " + twoProduct(array, n));
        
        System.out.println("");
		System.out.println("Задание №5");
		System.out.println("Результат " + Arrays.toString(isExact(number)));
		
		System.out.println("");
		System.out.println("Задание №6");
		System.out.println("Результат " + fractions(chislo));
		
		System.out.println("");
		System.out.println("Задание №7");
		System.out.println("Результат " + pilish_string(s));
		
		System.out.println("");
		System.out.println("Задание №8");
		System.out.println("Результат " + generateNonconsecutive(binary_chislo));
		
		System.out.println("");
		System.out.println("Задание №9");
		System.out.println("Результат " + isValid(s1));
		
		System.out.println("");
		System.out.println("Задание №10");
		System.out.println("Результат " + sumUp(arr));
		
		scn.close();
	}
	
	public static String hiddenAnagram(String stroka1, String stroka2)
	{
        String noFound = "noutfond";
        String alphavit = "qwertyuiopasdfghjklzxcvbnm";
        String clStr = "";
        String clAnagram = "";
        stroka1 = stroka1.toLowerCase();
        stroka2 = stroka2.toLowerCase();
        int maxLen = Math.max(stroka1.length(), stroka2.length());
        for (int i=0; i < maxLen; i++)
        {
            if (stroka1.length() > i)
            {
                if (alphavit.contains(stroka1.substring(i, i+1)))
                {
                    clStr += stroka1.substring(i, i+1);
                }
            }
            if (stroka2.length() > i)
            {
                if (alphavit.contains(stroka2.substring(i, i+1)))
                {
                    clAnagram += stroka2.substring(i, i+1);
                }
            }
        }

        for (int startPosition = 0; startPosition < clStr.length(); startPosition++)
        {
            if (!clAnagram.contains(clStr.substring(startPosition, startPosition+1)))
            {
                continue;
            }
            String anagramCopy = clAnagram;
            int letterIndex = startPosition;
            String ans = "";

            while (letterIndex < clStr.length())
            {
                String letter = clStr.substring(letterIndex, letterIndex + 1);
                if (anagramCopy.contains(letter))
                {
                    ans += letter;
                    anagramCopy = anagramCopy.replaceFirst(letter, "");
                }
                else
                {
                    break;
                }
                if (anagramCopy.length() == 0)
                {
                    return ans;
                }
                letterIndex++;
            }
        }
        return noFound;
    }
	
	public static String[] collect(String str, int razrez)
	{
        String[] arr;
        if (str.length() < razrez)
        {
            arr = new String[1];
        }
        else
        {
            arr = new String[str.length() / razrez];
            arr[0] = str.substring(0, razrez);
            String[] otherArr = collect(str.substring(razrez), razrez);
            for (int i=1; i< arr.length; i++)
            {
                if (otherArr.length > i-1)
                {
                    arr[i] = otherArr[i-1];
                }
            }
            Arrays.sort(arr);
        }
        return arr;
    }
	
    public static String Nico(String message, String key)
    {
        key = key.toLowerCase();
        int[] keyArr = new int[key.length()];


        String [] keyStrArr = new String[key.length()];
        for (int i=0; i < key.length(); i++)
        {
            keyStrArr[i] = key.substring(i, i+1);
        }
        Arrays.sort(keyStrArr); // amtt from matt - 1234 to 2134
        String keyStr = "";
        for (int i=0; i < keyStrArr.length; i++)
        {
            keyStr += keyStrArr[i];
        }
        for (int i=0; i < key.length(); i++)
        {
            String s = key.substring(i, i+1);
            int ind = keyStr.indexOf(key.substring(i, i+1));
            keyStr = keyStr.replaceFirst(s, " ");
            keyArr[ind] = i; 
        }

        Map<Integer, String> encodeMessage = new HashMap<Integer, String>();
        int steps = 0;
        if ( message.length() % key.length() == 0)
        {
            steps = message.length() / key.length();
        }
        else
        {
            steps= message.length() / key.length() + 1;
        }
        steps *= key.length();
            
        for (int i=0; i <steps; i++)
        {
            String letter = " ";
            if (i < message.length())
            {
                letter = message.substring(i, i+1); 
            }
            int index = i % keyArr.length;
            if (encodeMessage.get(index) != null)
            {
                encodeMessage.put(index, encodeMessage.get(index) + letter);
            }
            else
            {
                encodeMessage.put(index, letter);
            }
        }
        String ans = "";
        steps /=  key.length();
        for (int j=0; j < steps; j++)
        {
            for (int i=0; i < keyArr.length; i++)
            {
                String symbol = encodeMessage.get(keyArr[i]);
                ans += symbol.substring(j, j+1);
            }
        }
        return ans;
    }
    
    public static String twoProduct(int[] array, int n) 
    {
    	String result ="[]";
		int first=0, second=0;
		int[] answer = new int[2];
		for(int i=array.length-1;i>0;--i) 
		{
			second=array[i];
			for(int j=i-1;j>=0;--j) 
			{
				first=array[j];
				if(first*second==n) 
				{
					answer[0]=first;
					answer[1]=second;
				}
			}
		}
		if ((answer[0] == 0) && (answer[1]==0))
		{
			return result;
		}
		else
		{
			return Arrays.toString(answer);
		}
	}

    public static int[] isExact(int number) 
    {
		int[] answer = new int[0];
		int val = isFact(number,2);
		if(val!=-1)
		{
			answer=new int[] {number,val};
		}
		return answer;
	}
    
	public static int isFact(int val, int k) 
	{
		if(val==1) 
		{
			return k-1;
		}
		if(val%k!=0)
		{
			return -1;
		}
		return isFact(val/k,k+1);
	}
    
    public static String fractions(String chislo)
    {
        int dotIndex = chislo.indexOf(".");
        int bracketIndex = chislo.indexOf("(");
        int wholePart = Integer.parseInt(chislo.substring(0, dotIndex));
        String unrepeatPart = chislo.substring(dotIndex + 1, bracketIndex);
        String repeatPart = chislo.substring(bracketIndex + 1, chislo.length() - 1); 
        int firstBit = 0;
        if (unrepeatPart.length() > 0)
        {
            firstBit = Integer.parseInt(unrepeatPart);
        } 
        int chisl = Integer.parseInt(unrepeatPart+repeatPart) - firstBit;
        String znam_str = "";
        for (int i=0; i < repeatPart.length(); i++)
        {
            znam_str += "9";
        }
        for (int i=0; i < unrepeatPart.length(); i++)
        {
            znam_str += "0";
        }
        int znam = Integer.parseInt(znam_str);
        int k = 2;
		int t = Math.max(chisl, znam);
		while (k < t) 
		{
			if (chisl % k == 0 && znam % k == 0) 
			{
				chisl /= k;
				znam /= k;
			}
            else
            {
                k++;
            }
			    
		}
        return Integer.toString(wholePart*znam + chisl) + "/" + Integer.toString(znam);
    }

    public static String pilish_string(String s)
    {
        String  Pi = "314159265358979";
        String ans = "";
        if (s.length() == 0)
        {
            return ans;
        }
        int currentIndex = 0;
        for(int i=0; i<Pi.length(); i++)
        {
            int bitSize = Integer.parseInt(Pi.substring(i, i+1));
            int sLostLen = s.substring(currentIndex, s.length()).length();
            if (sLostLen == 0)
            {
                break;
            }
            if (sLostLen < bitSize)
            {
                String repeat = s.substring(s.length()-1);
                String dop = repeat;
                ans += s.substring(currentIndex, s.length());
                for (int j=1; j < bitSize - sLostLen ; j++ )
                {
                    dop += repeat;
                }
                ans += dop;
                break;
            }
            else
            {
                ans += s.substring(currentIndex, currentIndex + bitSize) + " ";
            }
            currentIndex += bitSize;
        }
        return ans;
    }
    
    public static String generateNonconsecutive(int binary_chislo) 
    {		
		return recurse(binary_chislo,false,"");
	}
    
	public static String recurse(int binary_chislo, boolean isOne,String s) 
	{
		if(binary_chislo == 1) 
		{
			if(isOne)
			{
                return s + "0 ";
            }
			else
			{
                return s + "0" + " " + s + "1 ";
            }
		}
		if (isOne) 
		{
			return recurse(binary_chislo - 1, false, s + "0");
		}
        else 
        {
			return recurse(binary_chislo - 1, false, s + "0") + recurse(binary_chislo - 1, true, s + "1");
		}	
	}

    public static String isValid(String s1)
    {
        Map<String, Integer> dictionary = new HashMap<String, Integer>();
        for (int i=0; i< s1.length(); i++)
        {
            String sym = s1.substring(i, i+1);
            if (dictionary.keySet().contains(sym))
            {
                int old = dictionary.get(sym);
                dictionary.replace(sym, old, old+1);
            }
            else
            {
                dictionary.put(sym, 1);
            }
        }
        int count = 0;
        int sum = 0;
        int mis = 0;
        String ans = "YES";
        for (int value: dictionary.values())
        {
            if (count != 0 && Math.abs(sum / count - value) > 1 )
            {
                ans = "NO";
                    break;
            }
            sum+= value;
            count++;
            if ( (double) sum/ count != sum / count)
            {
                mis++;
                sum -= value;
                count--;
                if (mis > 1)
                {
                    ans = "NO";
                    break;
                }
            }
        }
        return ans;
    }
    
    public static String sumUp(int[] arr)
    {
    	String ans = "[";
        List<int[]> newA = new ArrayList<int[]>();
        for (int i=0;i<arr.length-1;i++) 
        {
			for(int j=i+1;j<arr.length;j++) 
			{
				if(arr[i]+arr[j]==8) 
				{
                    int[] pair = {Math.min(arr[i], arr[j]), Math.max(arr[i], arr[j])};
					newA.add(pair);
                }         
			}
		}
        for(int[] el: newA)
        {
            ans += Arrays.toString(el) + " ";
        }
        ans += "]";
        return ans;
    }
}
