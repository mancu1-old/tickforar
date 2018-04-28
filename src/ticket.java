import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

public class ticket {

    public static void main(String[] args) {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        // число в строке
        String inputNumString, lineToSolv;
        // вводимое число
        int inputNum;
        int answerInt;
        double answerDouble;
        // разложено на каждый символ
        int i1, i2, i3, i4, i5, i6;
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
                    inputNum = Integer.parseInt(inputNumString);
                    // проверяем длину
                    if (inputNumString.length() != 6) {
                        System.out.println("Number's length doesn't support");
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

                System.out.println(i1 + " " + i2 + " " + i3 + " " + i4 + " " + i5 + " " + i6);

                for (int op1 = 0; op1 < 2; op1++) {
                    for (int op2 = 0; op2 < 5; op2++) {
                        for (int op3 = 0; op3 < 5; op3++) {
                            for (int op4 = 0; op4 < 5; op4++) {
                                for (int op5 = 0; op5 < 5; op5++) {
                                    for (int op6 = 0; op6 < 5; op6++) {
                                        lineToSolv = oper(op1) + i1 + oper(op2) + i2 + oper(op3) + i3 + oper(op4) + i4 + oper(op5) + i5 + oper(op6) + i6;
                                        try {
                                            try {
                                                answerInt = (Integer) engine.eval(lineToSolv);

                                                if (answerInt == 100) {
                                                    System.out.println(lineToSolv + " = " + answerInt);
                                                }
                                            } catch (ClassCastException e) {
                                                answerDouble = (double) engine.eval(lineToSolv);

                                                if (answerDouble == 100.0) {
                                                    System.out.println(lineToSolv + " = " + answerDouble);
                                                }
                                            }


                                        } catch (ScriptException e) {
                                            e.printStackTrace();
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                break start;
            }
        }
    }

    public static String oper(int numOfOper) {
        switch (numOfOper) {
            case 0:
                return "+";
            case 1:
                return "-";
            case 2:
                return "";
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
