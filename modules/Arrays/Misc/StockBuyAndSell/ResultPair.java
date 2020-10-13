package Arrays.Misc.StockBuyAndSell;

public class ResultPair {

    int buyOnDay;
    int sellOnDay;

    public ResultPair(int buyOnDay, int sellOnDay) {
        this.buyOnDay = buyOnDay;
        this.sellOnDay = sellOnDay;
    }

    @Override
    public String toString() {
        return "ResultPair{" +
                "buyOnDay=" + buyOnDay +
                ", sellOnDay=" + sellOnDay +
                '}';
    }
}
