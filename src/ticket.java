import java.util.Scanner;

public class ticket {

    public static void main(String[] args) {

        String inpint;
        int i1, i2, i3, i4, i5;

        System.out.println("Введи 5 значное число ");
        Scanner in = new Scanner(System.in);
        inpint = in.nextLine();
        if (inpint.length() != 5) {
            System.out.print("Длина числа не поддерживается");
            return;
        }
        i5 = Integer.parseInt(inpint) % 10;
        System.out.print(i5);
    }
}