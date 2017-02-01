import java.io.*;
import java.util.ArrayList;
import java.util.List;
import InsSort.*;
/**
 * Created by kszorin on 07.12.2016.
 * Класс, с помощью которого демонстрируется использование класса сортировки методом вставок InsSort.
 * На вход подаётся имя входного файла, выходного файла, тип данных (целые числа или строки) и порядок, в котором нужно производить сортиорвку.
 * На выходе программа создаёт файл с отсортироваными в нужном порядке значениями.
 */
public class InsSortFileTest {
    public static void main(String[] args) {

        //проверка параметров входной строки, при несоответствии вывод справки
        if ((args.length != 4)
                || ((args[2].compareTo("-i") != 0) && (args[2].compareTo("-s") != 0))
                || ((args[3].compareTo("-a") != 0) && (args[3].compareTo("-d") != 0)))
        {
            System.out.println("Integer and string array sorting by inserting method.");
            System.out.println("InsSortFileTest <in> <out> <type> <direction>");
            System.out.println("<in> \t\t\t Input file name.");
            System.out.println("<out> \t\t Output file name.");
            System.out.println("<type> \t\t\t Type of data in input file:");
            System.out.println("\t\t\t\t -i \t integer numbers");
            System.out.println("\t\t\t\t -s \t char strings");
            System.out.println("<direction> \t Sorting direction:");
            System.out.println("\t\t\t\t -a \t in ascending order");
            System.out.println("\t\t\t\t -d \t in descending order");
        }
        else {
            List<String> lineArray = new ArrayList<String>();

            try {
                //читаем данные из входного файла в ArrayList
                BufferedReader fileIn = new BufferedReader(new FileReader(args[0]));
                String lineFromFile;
                while ((lineFromFile = fileIn.readLine()) != null) {
                    lineArray.add(lineFromFile);
                }
                fileIn.close();

                //обработка целочисленного массива
                if (args[2].compareTo("-i") == 0) {
                    int[] numIn = new int[lineArray.size()], numOut;
                    for (int i=0; i < lineArray.size(); i++)                //преобразование из символьных строк в целые числа
                        numIn[i] = Integer.parseInt(lineArray.get(i));

                    System.out.print("\nBefore sorting: ");
                    for (int n:
                            numIn) {
                        System.out.printf("%d ", n);
                    }

                    InsSort massNum = new InsSort(numIn);
                    if (args[3].compareTo("-a") == 0)
                        numOut = massNum.IntSorting(true);
                    else
                        numOut = massNum.IntSorting(false);

                    //вывод результатов на консоль и запись в файл
                    PrintWriter fileOut = new PrintWriter(args[1]);
                    System.out.print("\nAfter sorting: ");
                    int i=0;
                    for (int n:
                            numOut) {
                        System.out.printf("%d ", n);
                        fileOut.printf("%d", n);
                        if (i < (numOut.length-1)) {
                            fileOut.print("\n");
                            i++;
                        }
                    }
                    fileOut.close();
                }

                //обработка строкового массива
                if (args[2].compareTo("-s") == 0) {
                    String[] strIn, strOut;

                    strIn = lineArray.toArray(new String[lineArray.size()]);

                    System.out.print("\nBefore sorting: ");
                    for (String s:
                            strIn) {
                        System.out.print(s + " ");
                    }

                    InsSort massStr = new InsSort(strIn);
                    if (args[3].compareTo("-a") == 0)
                        strOut = massStr.StringSorting(true);
                    else
                        strOut = massStr.StringSorting(false);

                    //вывод результатов на консоль и запись в файл
                    PrintWriter fileOut = new PrintWriter(args[1]);
                    System.out.print("\nAfter sorting: ");
                    int i=0;
                    for (String s:
                            strOut) {
                        System.out.print(s + " ");
                        fileOut.print(s);
                        if (i < (strOut.length-1)) {
                            fileOut.print("\n");
                            i++;
                        }
                    }
                    fileOut.close();
                }
            } catch (IOException ex) {                                      //проблемы с доступом к файлам
                System.out.println ("Problem with file opening: " + ex);
            } catch (NumberFormatException ex) {                            //проблемы с конвертацией String -> Int
                System.out.println ("Integer array processing error (check data in input file): " + ex);
            }
        }
    }
}