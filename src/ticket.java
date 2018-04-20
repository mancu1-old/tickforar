import java.util.InputMismatchException;
import java.util.Scanner;

public class ticket {

    public static void main(String[] args) {


        String inputNumString;// число в строке
        int inputNum; //вводимое число
        int i1, i2, i3, i4, i5, i6; //разложенно на каждый символ
        for (int loop= -1; loop < 0;) {//бесконечный цикл завершаем программу только когда получим вкусный результат
            start:
            {
                System.out.println("Введи 6 значное число ");
                Scanner in = new Scanner(System.in); //херата для считывания не по символьно а целыми стоками
                try { //так как мы приводим строку в число нужно быть уверенным что мы не приводим не цифру в число
                    inputNumString = in.nextLine(); /*ввод числа в строке (для того чтоб
                                            померить длинну например
                                            000001 в виде числа будет длинной 1)*/
                    inputNum = Integer.parseInt(inputNumString);
                    if (inputNumString.length() != 6) { // проверяем длину
                        System.out.println("Длина числа не поддерживается");
                        break start; // если не подходит то завершаем программу
                    }

                } catch (NumberFormatException e) { // суда мы поподем только тогда когда введем не подходящий символ
                    System.out.println("Дурак зачем не число ввел?");
                    break start;
                }
                i6 = inputNum % 10; //разбиваем на цифры хз наверника можно симпотичнее лень думать
                i5 = inputNum / 10 % 10;
                i4 = inputNum / 100 % 10;
                i3 = inputNum / 1000 % 10;
                i2 = inputNum / 10000 % 10;
                i1 = inputNum / 100000 % 10;
                System.out.println(i1 + " " + i2 + " " + i3 + " " + i4 + " " + i5 + " " + i6);//выводим на экран
                return;//ну что? мы все сделали? выходим!
            }
        }
    }
}