public class ZeroPercent implements DcountCalculationStrategy {
    public double calculateDcount(double totalBill) {
        return totalBill * 0;
    }
}
