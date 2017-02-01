/**
 * Created by kszorin on 08.12.2016.
 * Класс, реализующий сортировку методом вставок в целочисленном массиве и массиве строк.
 */
package InsSort;

public class InsSort {
    private int num[];       //массив целых чисел
    private String str[];    //массив символьных строк

    //Конструктор для целых чисел.
    public InsSort(int[] num) {
        this.num = new int[num.length];
        System.arraycopy(num,0,this.num,0,num.length);
    }

    //Конструктор для строк.
    public InsSort(String[] str) {
        this.str = new String[str.length];
        System.arraycopy(str,0,this.str,0,str.length);
    }

    /*
    * Метод производит сортировку массива целых чисел.
    * direction - направление сортировки. Если  true, то сортровка производится в порядке возрастания,
    * если false, то в порядке убывания.
    */
    public int[] IntSorting(boolean direction) {
        int temp=0;

        if (num.length > 1) {
            for (int i = 1, j; i< num.length; i++) {
                j=i;
                if (direction) {
                    while ((j>=1) && (num[j-1] > num[j])) {
                        temp = num[j];
                        num[j]= num[j-1];
                        num[j-1] = temp;
                        j--;
                    }
                }
                else {
                    while ((j>=1) && (num[j-1] < num[j])) {
                        temp = num[j];
                        num[j]= num[j-1];
                        num[j-1] = temp;
                        j--;
                    }
                }
            }
        }
        return num;
    }

    /*
    * Метод производит сортировку массива строк.
    * direction - направление сортировки. Если  true, то сортровка производится в порядке лексикографического возрастания,
    * если false, то в порядке лексикографического убывания.
    */
    public String[] StringSorting(boolean direction) {
        String temp="";

        if (str.length > 1) {
            for (int i = 1, j; i< str.length; i++) {
                j=i;
                if (direction) {
                    while ((j>=1) && (str[j].compareTo(str[j-1])<0)) {
                        temp = str[j];
                        str[j]= str[j-1];
                        str[j-1] = temp;
                        j--;
                    }
                }
                else {
                    while ((j>=1) && (str[j].compareTo(str[j-1])>0)) {
                        temp = str[j];
                        str[j]= str[j-1];
                        str[j-1] = temp;
                        j--;
                    }
                }
            }
        }
        return str;
    }
}
