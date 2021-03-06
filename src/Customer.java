

import java.util.Enumeration;
import java.util.Vector;

public class Customer {

	private String _name;
	   private Vector _rentals = new Vector();

	   public Customer (String name){
	       _name = name;
	   }

	   public void addRental(Rental arg) {
	     _rentals.addElement(arg);
	   }
	   
	   public String getName (){
	       return _name;
	   }

	   public String statement() 
	   {
	        double totalAmount = 0;
	        int frequentRenterPoints = 0;
	        Enumeration rentals = _rentals.elements();
	        
	        String result = "Rental Record for " + getName() + "\n";
	        
	        while (rentals.hasMoreElements()) 
	        {
	            double thisAmount = 0;
	            Rental each = (Rental) rentals.nextElement();
	            //determine amounts for each line
	          
	            thisAmount = each._movie.getCharged(each, thisAmount);

	            // add frequent renter points
	            frequentRenterPoints = frequentRenterPoints(frequentRenterPoints, each);

	            //show figures for this rental
	            result += "\t" + each.getMovie().getTitle()+ "\t" +
	String.valueOf(thisAmount) + "\n";
	            totalAmount += thisAmount;

	        }
	        //add footer lines
	        result +=  "Amount owed is " + String.valueOf(totalAmount) + "\n";
	        result += "You earned " + String.valueOf(frequentRenterPoints) +
	" frequent renter points";
	        return result;

	    }

	private int frequentRenterPoints(int frequentRenterPoints, Rental each) {
		frequentRenterPoints ++;
		// add bonus for a two day new release rental
		if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
each.getDaysRented() > 1) frequentRenterPoints ++;
		return frequentRenterPoints;
	}

}
