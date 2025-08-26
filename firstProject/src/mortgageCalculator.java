import java.text.NumberFormat;
import java.util.Scanner;
import java.lang.Math;

public class mortgageCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: ");
        float principal = scanner.nextFloat();
        System.out.print("Annual Interest Rate: ");
        float interest = scanner.nextFloat() / 100 / 12;
        System.out.print("Period (Years): ");
        float period = scanner.nextFloat() * 12;
        double monthly_payment = (principal * (interest * Math.pow(1 + interest, period))) /
                (Math.pow(1 + interest, period) - 1);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String result = currency.format(monthly_payment);
        System.out.println("The monthly payment is " + result);
    }
}