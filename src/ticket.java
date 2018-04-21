import java.util.InputMismatchException;
import java.util.Scanner;

public class ticket {

    public static void main(String[] args) {

        // число в строке
        String inputNumString;
        // вводимое число
        int inputNum;
        // разложено на каждый символ
        int i1, i2, i3, i4, i5, i6;
        int op1, op2, op3, op4, op5, op6;
        // бесконечный цикл завершаеn программу только когда получим вкусный результат
        for (int loop= -1; loop < 0;) {
            start:
            {
                System.out.println("Enter 6-digit number: ");
                //херата для считывания не по символьно а целыми стоками
                Scanner in = new Scanner(System.in);
                //так как мы приводим строку в число нужно быть уверенным что мы не приводим не цифру в число
                try {
                    // ввод числа в строке (для того чтоб померить длину? например 000001 в виде числа будет длиной 1)
                    inputNumString = in.nextLine();
                    inputNum = Integer.parseInt(inputNumString);
                    // проверяем длину
                    if (inputNumString.length() != 6) {
                        System.out.println("Number length doesn't support");
                        // если не подходит то завершаем программу
                        break start;
                    }

                } catch (NumberFormatException ex) { // суда мы поподем только тогда когда введем не подходящий символ
                    System.out.println("Enter proper number");
                    break start;
                }
                i6 = inputNum % 10;
                i5 = inputNum / 10 % 10;
                i4 = inputNum / 100 % 10;
                i3 = inputNum / 1000 % 10;
                i2 = inputNum / 10000 % 10;
                i1 = inputNum / 100000 % 10;
                //выводим на экран
                System.out.println(i1 + " " + i2 + " " + i3 + " " + i4 + " " + i5 + " " + i6);
                //ну что? мы все сделали? выходим!

                return;
            }
        }
    }
}
