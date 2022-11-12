package Lab3;
import java.util.ArrayList;
public class InsuranceCompany {
    private String name;
    private ArrayList <User> users;
    private String adminUsername;
    private String adminPassword;
    private int flatRate;

    public InsuranceCompany (String name, String adminUsername, String adminPassword, int flatRate ) {
        this.name = name;
        this.users = new ArrayList <>();
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
        this.flatRate = flatRate;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public int getFlatRate() {
		return flatRate;
	}

	public void setFlatRate(int flatRate) {
		this.flatRate = flatRate;
	}

	public boolean validateAdmin(String username, String password) {
		if (adminUsername.equals(username) && adminPassword.equals(password)) {
			return true;
		} else {
		return false;
		}
	}
	
    public User findUser(int userID) {
        for(User user : users) {
            if(user.getUserID() == userID) {
                return user;
            }      
        }
		return null;
}
    public boolean addUser(User user) {
    	if(findUser(user.getUserID()) == null) {
            users.add(user);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean addUser(String name, int userID, Address address) {
    	User user = new User (name, userID, address);
    		return addUser(user);
    }
     


    public boolean addPolicy (int userID, InsurancePolicy policy) {
    	User user = findUser(userID);
    		if (user == null) {
    			return false;
    		}
    		return user.addPolicy(policy);   		
    }
    
    public InsurancePolicy findPolicy(int userID, int policyID) {
    	User user = findUser(userID);
        	if(user!= null) {
        		return user.findPolicy(policyID);
        	}
        return null;
    }
    
    public void printPolicies(int userID) {    	
        User user = findUser(userID);
            if(user != null) {
                user.printPolicies(userID);
            }
        }
    
    public void print() {
    	System.out.println("Company name: "+name+" Username: " + adminUsername+ " Password: "+ adminPassword + " Flat Rate: "+flatRate);
    	for (User user: users) {
    		user.printPolicies(flatRate);
    	}
    }
    
    public String toString() {
    	String printUser = "Company name: "+name+" Username: " + adminUsername+ " Password: "+ adminPassword + " Flat Rate: "+flatRate;
    		for (User StringUser: users) {
    			printUser = printUser + StringUser.toString();
    		}
    		return printUser;
    	}
    
    public boolean createThirdPartyPolicy(int userID, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, String comments) {
    	User user = findUser(userID);
    		if (user != null) {
    			return user.createThirdPartyPolicy(policyHolderName, id, car, numberOfClaims, expiryDate, comments);
    		}
    		return false;
    }
    
    public boolean createComprehensivePolicy(int userID, String policyHolderName, int id, Car car, int numberOfClaims, MyDate expiryDate, int driverAge, int level) {
    	User user = findUser(userID);
    		if(user != null) {
    			return user.createComprehensivePolicy(policyHolderName, id, car, numberOfClaims, expiryDate, driverAge, level);
    		}
    		return false;
    }
    
    public double calcTotalPayments(int userID) {
    	User user = findUser(userID);
    	if (user != null) {
    		return user.calcTotalPremium(userID);    		
    	}
    	return 0;    		
    }
    
   public double calcTotalPayments() {
	   double totalPayment = 0;
	   for (User user: users) {
		   totalPayment = totalPayment + user.calcTotalPremium(flatRate);
	   }
	   return totalPayment;
   }
   
   public boolean carPriceRise(int userID, double risePercent) {
	   User user = findUser(userID);
	   if (user != null) {
		   user.carPriceRiseAll(risePercent);
		   return true;
	   }
	   return false; 
   }
   
   public void carPriceRise (double risePercent) {
	   for (User user: users) {
		   user.carPriceRiseAll(risePercent);
	   }
   }
   
   public ArrayList<InsurancePolicy> allPolicies() {
	   ArrayList<InsurancePolicy> policiesAll = new ArrayList();
	   for(User user: users) {
           for(InsurancePolicy policy: user.getPolicies()) {
               policiesAll.add(policy);
           }
       }  
       return policiesAll;
   }
   
   public ArrayList<InsurancePolicy> filteredByCarModel(int userID, String carModel) {
	   User user = findUser(userID);
	   if (user !=null) {
		   return user.filterByCarModel(carModel);
		   
	   }
	   return new ArrayList<InsurancePolicy>();
   }
   
   public ArrayList<InsurancePolicy> filterByExpiryDate(int userID, MyDate date) {
	   User user = findUser(userID);
	   if (user != null) {
		   return user.filterByExpiryDate(date);
	   }
	   return new ArrayList<InsurancePolicy>();
   }
   
   public ArrayList<InsurancePolicy> filteredByCarModel (String carModel) {
	   ArrayList<InsurancePolicy> filteredModelPolicies = new ArrayList();
		   for (User user: users) {
		   for (InsurancePolicy filteredModel: user.filterByCarModel(carModel)) {
			   filteredModelPolicies.add(filteredModel);
		   }
	   }
	   return filteredModelPolicies;
   }
   
   public ArrayList<InsurancePolicy> filterByExpiryDate (MyDate date) {
	   ArrayList<InsurancePolicy> filteredByDate = new ArrayList();
	   	for (User user: users) {
	   		for(InsurancePolicy ByDate: user.filterByExpiryDate(date)) {
	   			filteredByDate.add(ByDate);
	   		}
	   	}  
	   return filteredByDate;
   }
}


