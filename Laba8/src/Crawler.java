import java.net.MalformedURLException;
import java.util.LinkedList;

public class Crawler 
{
	//Выводит ссылку и его глубину
    public static void showResult(LinkedList<URLDepthPair> resultLink) 
    {
        for (URLDepthPair c : resultLink)
        {
            System.out.println("Глубина: " + c.getDepth()+"\tСсылка: "+c.getURL());
        }
    }
    
    //Проверяем введённый данные пользователя (являеется ли введённый символ числом)
    public static boolean checkDigit(String line) 
    {
        boolean isDigit = true;
        for (int i = 0; i < line.length() && isDigit; i++)
        {
            isDigit = Character.isDigit(line.charAt(i));
        }
        return isDigit;
    }

    public static void main(String[] args) throws MalformedURLException 
    {
    	//Вводим ссылку и проверяем данные
        args = new String[]{"http://kvant.mccme.ru/", "4", "100"};
        if (args.length == 3&&checkDigit(args[1])&&checkDigit(args[2])) 
        {
            String lineUrl = args[0];
            int numThreads = Integer.parseInt(args[2]);
            //Инициализируем пул адресов
            URLPool pool = new URLPool(Integer.parseInt(args[1]));
            //Формируем введёный пользователем элемент как начальный с глубиной = 0 и добавляем в пул
            pool.addPair(new URLDepthPair(lineUrl, 0));
            //Запускаем потоки. Количество может задаваться  пользователем. 1 - по умолчанию.
            for (int i = 0; i < numThreads; i++) 
            {
            	//передаём пул адресов в каждый созданный поток
                CrawlerTask c = new CrawlerTask(pool);
                Thread t = new Thread(c);
                t.start();
            }
            //Ожидаем завершения работы всех потоков
            while (pool.getWait() != numThreads) 
            {
                try 
                {
                    Thread.sleep(500);
                } 
                catch (InterruptedException e) 
                {
                    System.out.println("Игнорирование InterruptedException");
                }
            }
            try 
            {
            	//Выводим результат в консоль
                showResult(pool.getResult());;
            } 
            catch (NullPointerException e) 
            {
                System.out.println("Не ссылка");
            }
            System.exit(0);
        } 
        else 
        {
        	//Выводим ошибку неккоректно ведённого значения
            System.out.println("usage: java Crawler <URL> <maximum_depth> <num_threads> or second/third not digit");
        }
    }
}