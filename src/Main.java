import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DcountCalculatorSingleton DcountCalculator = DcountCalculatorSingleton.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your bill: ");
        double totalBill = scanner.nextDouble();
        DcountCalculator.setTotalBill(totalBill);

        System.out.print("Who are you? (student, pensioner, none, coupon(if you have)): ");
        String strategyChoice = scanner.next();

        DcountCalculationStrategy strategy;

        if (strategyChoice.equals("student")) {
            strategy = new FifteenPercentStrategy();
        } else if (strategyChoice.equals("pensioner")) {
            strategy = new TwentyPercentStrategy();
        }else if (strategyChoice.equals("none")) {
            strategy=new ZeroPercent();
        }else if (strategyChoice.equals("coupon")) {
            System.out.println("Enter coupon code: ");
            String coupon = scanner.next();
            strategy = new CustomPercentageStrategy(coupon);
        }else{
            System.out.println("Invalid strategy choice.");
            return;
        }

        DcountCalcDecorator decoratedStrategy = new DescriptionDecorator(strategy);

        DcountCalculator.setDcountStrategy(decoratedStrategy);

        double DcountAmount = DcountCalculator.calculateDcount();

        System.out.println("Total bill: $"+(totalBill-DcountAmount));
       System.out.println(decoratedStrategy.getDescription()+"\nDiscount amount: $" + DcountAmount);
    }
}