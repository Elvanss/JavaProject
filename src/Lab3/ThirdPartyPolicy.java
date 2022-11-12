package Lab3;

public class ThirdPartyPolicy extends InsurancePolicy {
    protected String comment;

    ThirdPartyPolicy(String policyHolderName, int id, Car car, int numberOfClaim, MyDate expiryDate, String comment) {
        super(policyHolderName, id, car, numberOfClaim, expiryDate);
        this.comment = comment;
    }

    public void print() {
        super.print();
        System.out.println("Comments: "+this.comment);
    }
    public String toString() {
        return super.toString() + " |Comment: " + this.comment;
    }

    public double calcPremium (int flatRate) {
        return (car.price/100 + numberOfClaims * 200 + flatRate);
        }

    }



