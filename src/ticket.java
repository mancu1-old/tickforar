import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ticket {

    public static void main(String[] args) {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        // число в строке
        String inputNumString, lineToSolv;
        // вводимое число
        Double inputNum;
        Double answer;
        // разложено на каждый символ
        Double i1, i2, i3, i4, i5, i6;
        // бесконечный цикл завершаеn программу только когда получим вкусный результат
        for (int loop = -1; loop < 0; ) {
            start:
            {
                System.out.println("Enter 6-digit number: ");
                //херата для считывания не по символьно а целыми стоками
                Scanner in = new Scanner(System.in);
                //так как мы приводим строку в число нужно быть уверенным что мы не приводим не цифру в число
                try {
                    // ввод числа в строке (для того чтоб померить длину? например 000001 в виде числа будет длиной 1)
                    inputNumString = in.nextLine();
                    inputNum = Double.valueOf(inputNumString);
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
                for (int op1 = 0; op1 < 3; op1++) {
                    for (int op2 = 0; op2 < 7; op2++) {
                        for (int op3 = 0; op3 < 7; op3++) {
                            for (int op4 = 0; op4 < 7; op4++) {
                                for (int op5 = 0; op5 < 7; op5++) {
                                    for (int op6 = 0; op6 < 7; op6++) {
                                        lineToSolv = oper(op1) + i1 + oper(op2) + i2 + oper(op3) + i3 + oper(op4) + i4 + oper(op5) + i5 + oper(op6) + i6;
                                        try {
                                            answer  = (Double) engine.eval(lineToSolv);
                                            if (answer == 100) {
                                                System.out.println(lineToSolv + " = " + answer);
                                            }

                                        } catch (ScriptException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                return;
            }
        }
    }

    public static String oper(int numOfOper) {
        switch (numOfOper) {
            case 0:
                return "";
            case 1:
                return "+";
            case 2:
                return "-";
            case 3:
                return "/";
            case 4:
                return "*";
            case 5:
                return "*-";
            case 6:
                return "/-";
            default:
                return "";
        }
    }

}
