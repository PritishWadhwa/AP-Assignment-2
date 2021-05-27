/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Name:		Pritish Wadhwa													 *
 * RollNumber: 	2019440															 *
 * Section:		A																 *
 * Stream:		CSE																 *
 * Topic:		Assignment 2													 *
 * SubTopic:	Helper Classes for Assignment 2 								 *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

package AP_Assignment2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

enum RestaurantCategory {
	Authentic, FastFood, Normal
}

enum CustomerCategory {
	Elite, Special, Normal
}

class ItemQuantitiyPair {
	private FoodItems item;
	private int qty;

	public ItemQuantitiyPair(FoodItems item, int qty) {
		this.item = item;
		this.qty = qty;
	}

	public FoodItems getFoodItem() {
		return this.item;
	}

	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public void changeQty(int qty) {
		this.qty -= qty;
	}
}

class Zotato {
	private static Map<Integer, Restaurant> listOfRestaurants = new HashMap<Integer, Restaurant>();
	private Map<Integer, Customer> listOfCustomers = new HashMap<Integer, Customer>();
	private static double companyBalance;
	private static int deliveryChargesCollected;
	static Scanner input = new Scanner(System.in);

	public Map<Integer, Restaurant> getRestList() {
		return this.listOfRestaurants;
	}

	public Map<Integer, Customer> getCustList() {
		return this.listOfCustomers;
	}

	public double getCompanyBalance() {
		return this.companyBalance;
	}

	public int getDeliveryCharges() {
		return this.deliveryChargesCollected;
	}

	public static void setCompanyBalance(double amt) {
		companyBalance += amt;
	}

	public static void setDeliveryCharge(int amt) {
		deliveryChargesCollected += amt;
	}

	public void addRestaurant(Integer key, Restaurant r) {
		listOfRestaurants.put(key, r);
	}

	public void addCustomer(Integer key, Customer c) {
		listOfCustomers.put(key, c);
	}

	public static void showRestaurants() {
		System.out.println("Choose Restaurant");
		for (Map.Entry<Integer, Restaurant> entry : listOfRestaurants.entrySet()) {
			System.out.println("\t" + entry.getKey() + ") " + entry.getValue().getName());
		}
	}

	public void showCustomers() {
		for (Map.Entry<Integer, Customer> entry : listOfCustomers.entrySet()) {
			System.out.println("\t" + entry.getKey() + ") " + entry.getValue().getName());
		}
	}

	public void controlRestaurant(int key) {
		Restaurant currRest = listOfRestaurants.get(key);
		int choice = 0;
		do {
			System.out.println("Welcome " + currRest.getName());
			showRestaurantHomeScreen();
			choice = input.nextInt();
			if (choice == 1) {
				controlRestaurantQuery1(currRest);
			} else if (choice == 2) {
				controlRestaurantQuery2(currRest);
			} else if (choice == 3) {
				controlRestaurantQuery3(currRest);
			} else if (choice == 4) {
				controlRestaurantQuery4(currRest);
			}
		} while (choice != 5);
	}

	public static void controlRestaurantQuery1(Restaurant curr) {
		System.out.println("Food Name: ");
		// String x = input.nextLine();
		String foodName = input.next();
		foodName += input.nextLine();
		System.out.println("Item Price: ");
		int itemPrice = input.nextInt();
		System.out.println("Item Quantity: ");
		int itemQty = input.nextInt();
		System.out.println("Item Category: ");
		String itemCategory = input.next();
		itemCategory += input.nextLine();
		System.out.println("Offer: ");
		int offer = input.nextInt();
		FoodItems foodItem = new FoodItems(foodName, offer, itemPrice, itemCategory);
		curr.addFoodItem(foodItem, itemQty);
		curr.printFoodAndQtyByName(foodName);
	}

	public static void controlRestaurantQuery2(Restaurant curr) {
		System.out.println("Choose item by code");
		curr.printAllFoodItemsAndQtyOfRest();
		int itemChoice = input.nextInt();
		itemEditWindow();
		int editChoice = input.nextInt();
		if (editChoice == 1) {
			System.out.print("Enter the new Name: ");
			String newName = input.next();
			newName += input.nextLine();
			curr.editName(itemChoice, newName);
		} else if (editChoice == 2) {
			System.out.print("Enter the new Price: ");
			int newPrice = input.nextInt();
			curr.editPrice(itemChoice, newPrice);
		} else if (editChoice == 3) {
			System.out.print("Enter the new Quantity: ");
			int newQty = input.nextInt();
			curr.editQty(itemChoice, newQty);
		} else if (editChoice == 4) {
			System.out.print("Enter the new Category: ");
			String newCat = input.next();
			newCat += input.nextLine();
			curr.editCategory(itemChoice, newCat);
		} else if (editChoice == 5) {
			System.out.print("Enter the new Offer: ");
			int newDisc = input.nextInt();
			curr.editDiscount(itemChoice, newDisc);
		}
		curr.printFoodItemAndRestById(itemChoice);
	}

	public static void controlRestaurantQuery3(Restaurant curr) {
		curr.printRewards();
	}

	public static void controlRestaurantQuery4(Restaurant curr) {
		System.out.print("Enter offer on total bill value - ");
		int disc = input.nextInt();
		curr.setDiscOverallBillVal(disc);
	}

	public static void showRestaurantHomeScreen() {
		System.out.println("\t1) Add Item");
		System.out.println("\t2) Edit Item");
		System.out.println("\t3) Print Rewards");
		System.out.println("\t4) Discount on bill value");
		System.out.println("\t5) Exit");
	}

	public static void itemEditWindow() {
		System.out.println("Choose an attribute to edit:");
		System.out.println("\t1) Name");
		System.out.println("\t2) Price");
		System.out.println("\t3) Quantity");
		System.out.println("\t4) Category");
		System.out.println("\t5) Offer");
	}

	public void controlCustomer(int key) {
		Customer currCust = listOfCustomers.get(key);
		int choice = 0;
		do {
			System.out.println("Welcome " + currCust.getName());
			showCustomerHomeScreen();
			choice = input.nextInt();
			if (choice == 1) {
				controlCustomerQuery1(currCust);
			} else if (choice == 2) {
				controlCustomerQuery2(currCust);
			} else if (choice == 3) {
				controlCustomerQuery3(currCust);
			} else if (choice == 4) {
				controlCustomerQuery4(currCust);
			}
		} while (choice != 5);
	}

	public static void controlCustomerQuery1(Customer curr) {
		showRestaurants();
		int restChoice = input.nextInt();
		Restaurant rest = listOfRestaurants.get(restChoice);
		System.out.println("Choose item by code");
		rest.printAllFoodItemsAndQtyOfRest();
		int itemChoice = input.nextInt();
		System.out.println("Enter item quantity - ");
		int itemQty = input.nextInt();
		// add if required the condition to check the qty availaible with the rests
		curr.setRestName(rest.getName());
		curr.setRestaurant(rest);
		curr.addToCart(rest.getItemList().get(itemChoice).getFoodItem(), itemQty);
		System.out.println("Items added to the cart");
	}

	public static void controlCustomerQuery2(Customer curr) {
		System.out.println("Items in cart:");
		ArrayList<ItemQuantitiyPair> cart = curr.getCart();
		ArrayList<String> itemNameList = new ArrayList<String>();
		double billPrice = 0;
		int qtySold = 0;
		for (ItemQuantitiyPair pair : cart) {
			FoodItems f = pair.getFoodItem();
			System.out.println(f.getId() + " - " + curr.getRestName() + " - " + f.getName() + " - " + f.getPrice()
					+ " - " + pair.getQty() + " - " + f.getDisc() + "% off ");
			billPrice += ((pair.getQty() * f.getPrice()) * ((100 - f.getDisc()) / 100.0));
			qtySold += pair.getQty();
			itemNameList.add(f.getName());
		}
		billPrice = (billPrice * (100 - curr.getRestaurant().getDiscOverallBillVal()) / 100.0);
		if (curr.getRestaurant().getCategory() == RestaurantCategory.Authentic) {
			AuthenticRestaurants currRest = (AuthenticRestaurants) curr.getRestaurant();
			billPrice = currRest.calcRestaurantDisc(billPrice);
		}
		int deliveryCost = 0;
		if (curr.getCat() == CustomerCategory.Elite) {
			EliteCustomers cust = (EliteCustomers) curr;
			billPrice = cust.calcBill(billPrice);
			deliveryCost = cust.calcDeliveryFee();
		} else if (curr.getCat() == CustomerCategory.Special) {
			SpecialCustomers cust = (SpecialCustomers) curr;
			billPrice = cust.calcBill(billPrice);
			deliveryCost = cust.calcDeliveryFee();
		} else {
			NormalCustomers cust = (NormalCustomers) curr;
			billPrice = cust.calcBill(billPrice);
			deliveryCost = cust.calcDeliveryFee();
		}
		System.out.println("Delivery Charge: " + deliveryCost + "/-");
		System.out.println("Total Order Value: " + (billPrice + deliveryCost) + "/-");
		showCheckoutScreen();
		int choice = input.nextInt();
		if (choice == 1) {
			System.out.println(qtySold + " items successfully bought for " + (billPrice + deliveryCost) + "/-");
			setCompanyBalance(0.01 * billPrice);
			setDeliveryCharge(deliveryCost);
			double finalPrice = billPrice + deliveryCost;
			double amtCollected = 0;
			if (curr.getRewardPts() > 0) {
				if (curr.getRewardPts() >= finalPrice) {
					curr.useRewardPts(finalPrice);
				} else {
					amtCollected = curr.getRewardPts();
					curr.useRewardPts(curr.getRewardPts());
					curr.useWallet(finalPrice - amtCollected);
				}
			} else {
				curr.useWallet(finalPrice);
			}
			int rewardPts = 0;
			if (curr.getRestaurant().getCategory() == RestaurantCategory.Authentic) {
				AuthenticRestaurants temp = (AuthenticRestaurants) curr.getRestaurant();
				rewardPts = temp.calculateRewards(billPrice);
			} else if (curr.getRestaurant().getCategory() == RestaurantCategory.FastFood) {
				FastFoodRestaurants temp = (FastFoodRestaurants) curr.getRestaurant();
				rewardPts = temp.calculateRewards(billPrice);
			} else if (curr.getRestaurant().getCategory() == RestaurantCategory.Normal) {
				NormalRestaurants temp = (NormalRestaurants) curr.getRestaurant();
				rewardPts = temp.calculateRewards(billPrice);
			}
			for (ItemQuantitiyPair pair : cart) {
				int id = pair.getFoodItem().getId();
				curr.getRestaurant().getItemList().get(id).changeQty(pair.getQty());
			}
			curr.setRewardPts(rewardPts);
			curr.getRestaurant().setRewardPtsRest(rewardPts);
			Order order = new Order(itemNameList, qtySold, billPrice, curr.getRestaurant().getName(), deliveryCost);
			curr.addOrder(order);
			curr.getRestaurant().setNoOfOrders();
		}
	}

	public static void controlCustomerQuery3(Customer curr) {
		curr.printRewards();
	}

	public static void showCheckoutScreen() {
		System.out.println("\t1) Proceed to checkout");
	}

	public static void controlCustomerQuery4(Customer curr) {
		int ctr = 1;
		for (Order o : curr.getOrderList()) {
			System.out.println("Order Number: " + ctr);
			o.printOrderList();
			if (ctr == 10) {
				return;
			}
		}
	}

	public static void showCustomerHomeScreen() {
		System.out.println("Customer Menu");
		System.out.println("1) Select Restaurant");
		System.out.println("2) Checkout Cart");
		System.out.println("3) Reward Won");
		System.out.println("4) Print the recent Orders");
		System.out.println("5) Exit");
	}
}

class Restaurant implements Assignment2_UserInterface {
	private final int id;
	private static int ctr = 1;
	private final String name;
	private final String address;
	private int noOfOrders;
	private double rewardPoints;
	private int discOverAllBillVal = 0;
	private RestaurantCategory Category;
	private Map<Integer, ItemQuantitiyPair> foodItems = new HashMap<Integer, ItemQuantitiyPair>();

	public Restaurant(String name, String address, RestaurantCategory cat) {
		this.name = name;
		this.address = address;
		this.id = ctr;
		ctr++;
		this.noOfOrders = 0;
		this.rewardPoints = 0;
		this.Category = cat;
	}

	public Map<Integer, ItemQuantitiyPair> getItemList() {
		return foodItems;
	}

	public RestaurantCategory getCategory() {
		return this.Category;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public double getRewards() {
		return this.rewardPoints;
	}

	public String getAddress() {
		return this.address;
	}

	public int getNoOfOrders() {
		return this.noOfOrders;
	}

	public void setRewardPtsRest(double amt) {
		this.rewardPoints += amt;
	}

	public void setNoOfOrders() {
		this.noOfOrders++;
	}

	public void addFoodItem(FoodItems item, int qty) {
		foodItems.put(item.getId(), new ItemQuantitiyPair(item, qty));
	}

	public void printFoodAndQtyByName(String name) {
		for (Map.Entry<Integer, ItemQuantitiyPair> entry : foodItems.entrySet()) {
			if (entry.getValue().getFoodItem().getName().equalsIgnoreCase(name)) {
				FoodItems f = entry.getValue().getFoodItem();
				System.out.println(f.getId() + " " + f.getName() + " " + f.getPrice() + " " + entry.getValue().getQty()
						+ " " + f.getDisc() + "% off " + f.getCategory());
				return;
			}
		}
	}

	public void printAllFoodItemsAndQtyOfRest() {
		for (Map.Entry<Integer, ItemQuantitiyPair> entry : foodItems.entrySet()) {
			FoodItems f = entry.getValue().getFoodItem();
			System.out.println(f.getId() + " " + this.getName() + " - " + f.getName() + " " + f.getPrice() + " "
					+ entry.getValue().getQty() + " " + f.getDisc() + "% off " + f.getCategory());
		}
	}

	public void printFoodItemAndRestById(int id) {
		FoodItems f = foodItems.get(id).getFoodItem();
		System.out.println(f.getId() + " " + this.getName() + " - " + f.getName() + " " + f.getPrice() + " "
				+ foodItems.get(id).getQty() + " " + f.getDisc() + "% off " + f.getCategory());
	}

	public void editName(int id, String name) {
		foodItems.get(id).getFoodItem().setName(name);
	}

	public void editDiscount(int id, int disc) {
		foodItems.get(id).getFoodItem().setDiscount(disc);
	}

	public void editPrice(int id, int price) {
		foodItems.get(id).getFoodItem().setPrice(price);
	}

	public void editCategory(int id, String category) {
		foodItems.get(id).getFoodItem().setCategory(category);
	}

	public void editQty(int id, int qty) {
		foodItems.get(id).setQty(qty);
	}

	@Override
	public void printRewards() {
		// TODO Auto-generated method stub
		System.out.println("Reward Points: " + this.getRewards());
	}

	public int getDiscOverallBillVal() {
		return this.discOverAllBillVal;
	}

	public void setDiscOverallBillVal(int d) {
		this.discOverAllBillVal = d;
	}

	@Override
	public void printDetails() {
		// TODO Auto-generated method stub
		System.out.println("\t" + this.getName() + " " + this.getAddress() + " " + this.getNoOfOrders());
	}
}

class FoodItems {
	private final int id;
	private static int ctr = 1;
	private String name;
	private int discount;
	private int price;
	private String category;

	public FoodItems(String name, int disc, int price, String cat) {
		this.id = ctr;
		ctr++;
		this.name = name;
		this.discount = disc;
		this.price = price;
		this.category = cat;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

	public int getDisc() {
		return this.discount;
	}

	public String getCategory() {
		return this.category;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDiscount(int disc) {
		this.discount = disc;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setCategory(String cat) {
		this.category = cat;
	}
}

class Customer implements Assignment2_UserInterface {
	private final int id;
	private static int ctr = 1;
	private final String name;
	private final String address;
	private double accountBalance;
	private final CustomerCategory category;
	private double rewardPoints;
	private String restName;
	private Restaurant currRestaurant;
	private ArrayList<ItemQuantitiyPair> cart = new ArrayList<ItemQuantitiyPair>();
	private ArrayList<Order> orderList = new ArrayList<Order>();

	public Customer(String name, String address, CustomerCategory cat) {
		this.name = name;
		this.address = address;
		this.category = cat;
		this.id = ctr;
		ctr++;
		this.accountBalance = 1000;
		this.rewardPoints = 0;
	}

	public CustomerCategory getCat() {
		return this.category;
	}

	public String getRestName() {
		return this.restName;
	}

	public Restaurant getRestaurant() {
		return this.currRestaurant;
	}

	public void setRestaurant(Restaurant r) {
		this.currRestaurant = r;
	}

	public void addOrder(Order o) {
		this.orderList.add(o);
	}

	public ArrayList<Order> getOrderList() {
		return this.orderList;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public double getRewardPts() {
		return this.rewardPoints;
	}

	public String getAddress() {
		return this.address;
	}

	public double getWallet() {
		return this.accountBalance;
	}

	public ArrayList<ItemQuantitiyPair> getCart() {
		return this.cart;
	}

	public void setRestName(String name) {
		this.restName = name;
	}

	public void useRewardPts(double amt) {
		this.rewardPoints -= amt;
	}

	public void useWallet(double amt) {
		this.accountBalance -= amt;
	}

	public void setRewardPts(double amt) {
		this.rewardPoints += amt;
	}

	public void addToCart(FoodItems item, int qty) {
		cart.add(new ItemQuantitiyPair(item, qty));
	}

	@Override
	public void printRewards() {
		// TODO Auto-generated method stub
		System.out.println("Reward points: " + this.getRewardPts());
	}

	@Override
	public void printDetails() {
		// TODO Auto-generated method stub
		System.out.println("\t" + this.getName() + " " + this.getAddress() + " " + this.getWallet());
	}
}

class Order {
	private final ArrayList<String> itemNames;
	private final int qty;
	private final double price;
	private final String restName;
	private final int deliveryCharge;

	public Order(ArrayList<String> itemNames, int qty, double price, String rest, int deliveryCharge) {
		this.itemNames = itemNames;
		this.deliveryCharge = deliveryCharge;
		this.price = price;
		this.qty = qty;
		this.restName = rest;
	}

	public ArrayList<String> getItemNames() {
		return this.itemNames;
	}

	public int getQty() {
		return this.qty;
	}

	public double getPrice() {
		return this.price;
	}

	public String getRestName() {
		return this.restName;
	}

	public int getDeliveryCharge() {
		return this.deliveryCharge;
	}

	public void printOrderList() {

		ArrayList<String> names = this.getItemNames();
		System.out.println("The order contains the items bought: ");
		for (String string : names) {
			System.out.println("\t" + string);
		}
		System.out.println("The quantity purchased: " + this.getQty());
		System.out.println("The Price being: " + this.getPrice());
		System.out.println("The Restaurant: " + this.getRestName());
		System.out.println("The delivery charge being: " + this.getDeliveryCharge());
		System.out.println();

	}
}