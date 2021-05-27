/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Name:		Pritish Wadhwa													 *
 * RollNumber: 	2019440															 *
 * Section:		A																 *
 * Stream:		CSE																 *
 * Topic:		Assignment 2													 *
 * SubTopic:	Main Class For Assignment 2										 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


package AP_Assignment2;

import java.util.Map;
import java.util.Scanner;

public class Assignment2_Main {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		Zotato handler = new Zotato();
		addRestaurants(handler);
		addCustomers(handler);
		int choice = 0;
		do {
			showHomeScreen();
			choice = input.nextInt();
			if (choice == 1) {
				addressQuery1(handler);
			} else if (choice == 2) {
				addressQuery2(handler);
			} else if (choice == 3) {
				addressQuery3(handler);
			} else if (choice == 4) {
				addressQuery4(handler);
			}
		} while (choice != 5);
		input.close();
	}

	public static void addRestaurants(Zotato handler) {
		Restaurant rest1 = new AuthenticRestaurants("Shah (Authentic)", "Rohini, Delhi");
		handler.addRestaurant(rest1.getId(), rest1);
		Restaurant rest2 = new NormalRestaurants("Ravi's", "IIITD, Delhi");
		handler.addRestaurant(rest2.getId(), rest2);
		Restaurant rest3 = new AuthenticRestaurants("The Chinese (Authentic)", "Chinatown, Delhi");
		handler.addRestaurant(rest3.getId(), rest3);
		Restaurant rest4 = new FastFoodRestaurants("Wang's (Fast Food)", "New York Sanctum, Delhi");
		handler.addRestaurant(rest4.getId(), rest4);
		Restaurant rest5 = new NormalRestaurants("Paradise", "Heaven, Delhi");
		handler.addRestaurant(rest5.getId(), rest5);
	}

	public static void addCustomers(Zotato handler) {
		Customer cust1 = new EliteCustomers("Ram (Elite)", "Ayodhya, Delhi");
		handler.addCustomer(cust1.getId(), cust1);
		Customer cust2 = new EliteCustomers("Sam (Elite)", "London, Delhi");
		handler.addCustomer(cust2.getId(), cust2);
		Customer cust3 = new SpecialCustomers("Tim (Special)", "Cape Town, Delhi");
		handler.addCustomer(cust3.getId(), cust3);
		Customer cust4 = new NormalCustomers("Kim", "North Korea, Delhi");
		handler.addCustomer(cust4.getId(), cust4);
		Customer cust5 = new NormalCustomers("Jim", "Scranton, Delhi");
		handler.addCustomer(cust5.getId(), cust5);
	}

	public static void showHomeScreen() {
		System.out.println("Welcome to Zotato:");
		System.out.println("\t1) Enter as Restaurant Owner");
		System.out.println("\t2) Enter as Customer");
		System.out.println("\t3) Check User Details");
		System.out.println("\t4) Company Account Details");
		System.out.println("\t5) Exit");
	}

	public static void showQuery3FirstScreen() {
		System.out.println("\t1) Customer List");
		System.out.println("\t2) Restaurant List");
	}

	public static void addressQuery1(Zotato handler) {
		handler.showRestaurants();
		int choice = input.nextInt();
		handler.controlRestaurant(choice);
	}

	public static void addressQuery2(Zotato handler) {
		handler.showCustomers();
		int choice = input.nextInt();
		handler.controlCustomer(choice);
	}

	public static void addressQuery3(Zotato handler) {
		showQuery3FirstScreen();
		int choice1 = input.nextInt();
		if (choice1 == 1) {
			handler.showCustomers();
			int choice2 = input.nextInt();
			Map<Integer, Customer> customers = handler.getCustList();
			Customer cust = customers.get(choice2);
			cust.printDetails();
		} else if (choice1 == 2) {
			handler.showRestaurants();
			int choice2 = input.nextInt();
			Map<Integer, Restaurant> rests = handler.getRestList();
			Restaurant rest = rests.get(choice2);
			rest.printDetails();
		}
	}

	public static void addressQuery4(Zotato handler) {
		System.out.println("Total Company Balance - INR " + handler.getCompanyBalance() + "/-");
		System.out.println("Total Delivery Charges Collected - INR " + handler.getDeliveryCharges() + "/-");
	}
}
