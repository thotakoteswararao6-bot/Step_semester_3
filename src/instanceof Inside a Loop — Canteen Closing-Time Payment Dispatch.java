class Payment {
    public void pay(double amount) {
        System.out.println("Paid (cash): Rs " + amount);
    }
}

class CardPayment extends Payment {
    public void payWithProcessingFee(double amount) {
        double total = amount + (amount * 0.02);
        System.out.println("Charged (card, incl. fee): Rs " + total);
    }
}

public class CanteenPaymentDemo {
    public static void processTransaction(Payment payment, double amount) {
        if (payment instanceof CardPayment) {
            ((CardPayment) payment).payWithProcessingFee(amount);
        } else {
            payment.pay(amount);
        }
    }

    public static void main(String[] args) {
        Payment[] payments = {
                new CardPayment(),
                new Payment(),
                new CardPayment(),
                new Payment(),
                new CardPayment()
        };

        double[] amounts = {100, 50, 200, 75, 120};
        double totalCollected = 0;

        for (int i = 0; i < payments.length; i++) {
            if (payments[i] instanceof CardPayment) {
                double charged = amounts[i] + (amounts[i] * 0.02);
                ((CardPayment) payments[i]).payWithProcessingFee(amounts[i]);
                totalCollected += charged;
            } else {
                payments[i].pay(amounts[i]);
                totalCollected += amounts[i];
            }
        }

        System.out.println("Total Collected: Rs " + totalCollected);
    }
}
