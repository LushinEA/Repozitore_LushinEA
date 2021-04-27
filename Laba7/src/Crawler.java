import java.io.*;
import java.net.*;
import java.util.LinkedList;

public class Crawler 
{
	
	//Список найденных сайтов
    static LinkedList <URLDepthPair> findLink = new LinkedList <URLDepthPair>();
    
    //Список просмотренных сайтов
    static LinkedList <URLDepthPair> viewedLink = new LinkedList <URLDepthPair>();

    //Выводит ссылку и его глубину
    public static void showResult(LinkedList<URLDepthPair> viewedLink) 
    {
        for (URLDepthPair c : viewedLink)
        {
            System.out.println("Глубина: "+c.getDepth() + "\tСсылка: "+c.getURL());
        }
    }

    //Отправка http запроса
    public static void request(PrintWriter out,URLDepthPair pair) throws MalformedURLException 
    {
        out.println("GET " + pair.getPath() + " HTTP/1.1");
        out.println("Host: " + pair.getHost());
        out.println("Connection: close");
        out.println();
        out.flush();
    }
    
    public static void Process(String pair, int maxDepth) throws IOException 
    {
    	//Формируем введёный пользователь элемент как начальный с глубиной = 0
        findLink.add(new URLDepthPair(pair, 0));
        //Пока в найденном листе есть хоть один сайт
        while (!findLink.isEmpty()) 
        {
        	//Получаем параметры сайта, с которым будем работать
            URLDepthPair currentPair = findLink.removeFirst(); //Берём 1 ссылку из списка
            if (currentPair.depth < maxDepth) //Проверяем его глубину(подходит или нет)
            {
            	//Инициализируем сокет и отправляем запрос
                Socket my_socket = new Socket(currentPair.getHost(), 80);
                my_socket.setSoTimeout(1000);
                try 
                {
                	//Реализуем поток ввода (для чтения строк из сокета)
                    BufferedReader in = new BufferedReader(new InputStreamReader(my_socket.getInputStream()));
                  //Реализуем поток вывода (для отправки http запроса сокету)
                    PrintWriter out = new PrintWriter(my_socket.getOutputStream(), true);
                    request(out, currentPair);
                    String line;
                    //Пока сервер не завершил отправку веб-страницы
                    while ((line = in.readLine()) != null) 
                    {
                    	//Если строка содержит URL
                        if (line.indexOf(currentPair.URL_PREFIX) != -1 && line.indexOf('"') != -1) 
                        {
                        	//Посимвольно считываем ссылку пока не дойдём до её конца
                            StringBuilder currentLink = new StringBuilder();
                            int i = line.indexOf(currentPair.URL_PREFIX);
                            while (line.charAt(i) != '"' && line.charAt(i) != ' ') 
                            {
                                if (line.charAt(i) == '<') 
                                {
                                    currentLink.deleteCharAt(currentLink.length() - 1);
                                    break;
                                }
                                else 
                                {
                                    currentLink.append(line.charAt(i));
                                    i++;
                                }
                            }
                            //Нам подходит ссылка
                            URLDepthPair newPair = new URLDepthPair(currentLink.toString(), currentPair.depth + 1);
                            //Если найденная ссылка нам подходит и её нет в списках, то добавляем в список найденных ссылок
                            if (currentPair.check(findLink, newPair) && currentPair.check(viewedLink, newPair) && !currentPair.URL.equals(newPair.URL))
                            {
                                findLink.add(newPair);
                            }
                        }
                    }
                    //Закрываем сокет
                    my_socket.close();
                } 
                catch (SocketTimeoutException e) 
                {
                    my_socket.close();
                }
            }
            //Добавляем ссылку в список провереныых ссылок
            viewedLink.add(currentPair);
        }
        showResult(viewedLink);
    }
    
    //Вывод результата от метода Process, но в случае неверно URL вывод ошибки указанной в методичке
    public static void main(String[] args) 
    {
        String[] arg = new String[]{"http://ito.edu.ru/","1"};
        try 
        {
            Process(arg[0], Integer.parseInt(arg[1]));
        } 
        catch (NumberFormatException | IOException e) 
        {
            System.out.println("usage: java Crawler " + arg[0] + " " + arg[1]);
        }
    }
}