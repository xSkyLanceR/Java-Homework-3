/* 1.Сохранить в файл строку и загрузить из файла строку с выводом в консоль используя классы FileWriter и FileReader.
// 2.Загрузить из файла многострочный текст формата ФИО возраст и пол через пробелы. 
//   Разбить по строкам и вывести в консоль в формате "Иванов И.И. 32 М"
// 3.Загруженный и разбитый по строкам текст загрузить в подготовленные списки. 
//   Фамилии, имена, отчества, возрас и пол в отдельных списках.
// 4.Отсортировать по возрасту используя дополнительный список индексов.*/

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
// import java.util.Comparator;
import java.util.LinkedList;

public class homework4 
{
    public static void main(String[] args) throws IOException
    {
        ArrayList<String> family = new ArrayList<>();
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> soname = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        LinkedList<Integer> index = new LinkedList<>();


        String text = " ";
        FileReader reader = new FileReader("db.sql");
        while (reader. ready ()) {
            text += (char) reader. read();
        }
        reader.close();
        String [] str = text.split("\r\n");
        for (int i = 1; i < str.length; i++){
            String [] sb = str[i].split(" ");

            family.add(sb[0] + " ");
            name.add(sb[1].substring(0, 1) + ".");
            soname.add(sb[2].substring(0, 1) + "." + " ");
            age.add(Integer.valueOf(sb[3]));
            gender.add(sb[4] == "M" ? true : false);
            index.add(i);
        }
        
        // new *
        //index. sort(new Comparator<Integer>() {
        //   new *
        //   @Override
        //   public int compare(Integer o1, Integer o2)  {
        //       return o2-o1;
        //   }        
        //});

        for (int i = 0; i < index.size(); i++){
            System.out.printf(family.get(i));
            System.out.printf(name.get(i));
            System.out.printf(soname.get(i));
            System.out.printf(age.get(i).toString());
            System.out.printf((gender.get(i) ? "M" : "Ж"));
            System.out.println();
        }

            // System.out.println(family); 

            // System.out.println(sb[0] + " " + sb[1].charAt(0) + "." + sb[2].charAt(0) + "." + " " + sb[3] + " " + sb[4]);
        
    }
    
}
