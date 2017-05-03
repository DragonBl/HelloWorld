

public class CineMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Movie mov1 = new Movie("Passengers",2);
		Movie mov2 = new Movie("I am Number Four",8);
		Movie mov3 = new Movie("Logan",4);
		Movie mov4 = new Movie("Dr. Strange",6);
		
		Rental rent1 = new Rental(mov1,5);
		Customer cust1 = new Customer("Prasad");
		cust1.addRental(rent1);
        
        
        System.out.println(cust1.statement());
	}

}
