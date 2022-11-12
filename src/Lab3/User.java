package Lab3;

import java.util.ArrayList;
public class User {
    private String name;
    private int userID;
    private Address address;
    ArrayList<InsurancePolicy> policies;

    public User(String name, int userID, Address address) {
        this.name = name;
        this.userID = userID;
        this.address = address;
        this.policies = new ArrayList<>();
    }


    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getUserID() {
        return userID;
    }
    
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
    public void setCity(String city) { 
    	address.setCity(city); 
    	}
    
    public String getCity() { 
    	return address.getCity(); 
    	}
    
    public ArrayList<InsurancePolicy> getPolicies() {
        return policies;
    }
    
    public void setPolicies(ArrayList<InsurancePolicy> policies) {
        this.policies = policies;
    }


        boolean addPolicy(InsurancePolicy policy) {
            for (InsurancePolicy AddPolicy : policies) {
                if (AddPolicy.getId() == policy.getId()) {
                    return false;
                }
            }
            policies.add(policy);
            return true;
        }

        public InsurancePolicy findPolicy(int policyID) {
        for (InsurancePolicy FindPolicy: policies) {
            if (FindPolicy.getId() == policyID)
                return FindPolicy;
        }
        return null;
    }
    public void print() {
            System.out.println("Name: " + name);
            System.out.println("User ID: " + userID);
            System.out.println("Address: ");
            System.out.println("- Street Nụmber: " + address.streetNum);
            System.out.println("- Street Name: " + address.street);
            System.out.println("- Suburb: " + address.suburb);
            System.out.println("- City: " + address.city);
            System.out.println("<----------------------------------->");
            InsurancePolicy.printPolicies(policies);
            System.out.println();

        }

    public String toString() {
         String PolicyUser = " |User ID: " + userID + " |Name:" + name + " |Address:" + address + "\n";
        for(InsurancePolicy user : policies) {
            PolicyUser = PolicyUser + user.toString()+ "\n";
            }
        return PolicyUser;
        }

    public void printPolicies ( int flatRate) {
        InsurancePolicy.printPolicies(policies);
    }

    public double calcTotalPremium(int flatRate) {
        return InsurancePolicy.calcTotalPayments(policies, flatRate);
    }

    public void carPriceRiseAll (double risePercent) {
        InsurancePolicy.carPriceRiseAll(policies, risePercent);
    }

    public ArrayList <InsurancePolicy> filterByCarModel (String carModel) {
        return InsurancePolicy.filterByCarModel(policies, carModel);
    }

    boolean createThirdPartyPolicy(String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments) {
    	return addPolicy(new ThirdPartyPolicy(policyHolderName, id, car, numberOfClaims, expiryDate,comments));
    	
    }
    
    public boolean createComprehensivePolicy( String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level)
    {
    	return addPolicy(new ComprehensivePolicy(policyHolderName,  id,  car,  numberOfClaims,  expiryDate,  driverAge,  level));        
    }
    
    public ArrayList<InsurancePolicy> filterByExpiryDate(MyDate date) {
    	return InsurancePolicy.filterByExpiryDate(policies,date);
    }
    	
    
}








