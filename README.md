# sdp-assgn2

## What did I added

### A new decorator class that sets description to choosen strategy
```java

//and new interface that extends Strategy pattern interface
public interface DcountCalcDecorator extends DcountCalculationStrategy {
    String getDescription();
}
```


```java
public class DescriptionDecorator implements DcountCalcDecorator {
    private DcountCalculationStrategy strategy;

    public DescriptionDecorator(DcountCalculationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public double calculateDcount(double totalBill) {
        return strategy.calculateDcount(totalBill);
    }

    @Override
    public String getDescription() {
        if (strategy instanceof FifteenPercentStrategy) {
            return "hey you got 15% discount";
        } else if (strategy instanceof TwentyPercentStrategy) {
            return "nice you got 20% discount";
        } else if (strategy instanceof CustomPercentageStrategy) {
            return "0_0 YOU GOT 50% discount";
        } else {
            return "Sorry, you don't have discount(";
        }
    }
}
```
