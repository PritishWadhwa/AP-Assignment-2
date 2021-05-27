/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Name:		Pritish Wadhwa													 *
 * RollNumber: 	2019440															 *
 * Section:		A																 *
 * Stream:		CSE																 *
 * Topic:		Assignment 2													 *
 * SubTopic:	Helper Classes for Assignment 2 								 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

package AP_Assignment2;

class AuthenticRestaurants extends Restaurant implements Assignmnet2_RestaurantInterface {

	public AuthenticRestaurants(String name, String address) {
		super(name, address, RestaurantCategory.Authentic);
	}

	public double calcRestaurantDisc(double price) {
		if (price > 200) {
			return (price - 50);
		}
		return price;
	}

	@Override
	public int calculateRewards(double price) {
		// TODO Auto-generated method stub
		return ((int)price / 200) * 25;
	}

}

class FastFoodRestaurants extends Restaurant implements Assignmnet2_RestaurantInterface {

	public FastFoodRestaurants(String name, String address) {
		super(name, address, RestaurantCategory.FastFood);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calculateRewards(double price) {
		// TODO Auto-generated method stub
		return ((int)price / 150) * 10;
	}
}

class NormalRestaurants extends Restaurant implements Assignmnet2_RestaurantInterface {

	private final int discOverAllBillVal = 0;

	public NormalRestaurants(String name, String address) {
		super(name, address, RestaurantCategory.Normal);
		// TODO Auto-generated constructor stub
	}

	public int getDiscOverallBillVal() {
		return this.discOverAllBillVal;
	}

	@Override
	public int calculateRewards(double price) {
		// TODO Auto-generated method stub
		return ((int)price / 100) * 5;
	}

}

class EliteCustomers extends Customer implements Assignment2_CustomerInterface {

	public EliteCustomers(String name, String address) {
		super(name, address, CustomerCategory.Elite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcBill(double price) {
		if (price > 200) {
			return (price - 50);
		}
		return price;
	}

	@Override
	public int calcDeliveryFee() {
		return 0;
	}

}

class SpecialCustomers extends Customer implements Assignment2_CustomerInterface {

	public SpecialCustomers(String name, String address) {
		super(name, address, CustomerCategory.Special);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcBill(double price) {
		if (price > 200) {
			return (price - 25);
		}
		return price;
	}

	@Override
	public int calcDeliveryFee() {
		return 20;
	}

}

class NormalCustomers extends Customer implements Assignment2_CustomerInterface {

	public NormalCustomers(String name, String address) {
		super(name, address, CustomerCategory.Normal);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double calcBill(double price) {
		return price;
	}

	@Override
	public int calcDeliveryFee() {
		return 40;
	}

}