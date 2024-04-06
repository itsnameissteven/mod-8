package main;
import java.util.ArrayList;
import java.util.Scanner;
public class Dealership {
  private String name;
  private ArrayList<Automobile> inventory;
  
  public Dealership(String name) {
	  this.name = name;
	  this.inventory = new ArrayList<>();
  }
  
  // Getters
  public String getName() {
	  return this.name;
  }
  
  public ArrayList<Automobile> getInventory() {
	  return this.inventory;
  }
  
  // Setters
  public void setName(String name) {
	  this.name = name;
  }
  
  // Prompts a user to input car details and adds to inventory list
  public void addCar(Scanner scnr) {
	  Automobile car = new Automobile();
	  car.inputCarDetails(scnr);
	  this.inventory.add(car);
	  System.out.println(car.getMake() + " " + car.getModel() + " has been added to the inventory.");
  }
  
  // Will iterate over 
  public void removeCar(Scanner scnr) {
	  // Print message if no array list size is 0
	  if(this.inventory.size() == 0) {
		  System.out.println("There are no cars in the inventory to remove.");
		  return;
	  }
	  Validator validator = new Validator();
	  String vin;
	  
	  // Get user input and validate input, loop if incorrect
	  while (true) {
		  System.out.println("Enter the vin of the car you wish to remove: ");
		  vin = scnr.nextLine().trim();
		  validator.validateString(vin, "Please enter a valid vin");
		  break;
	  }
	  
	  // Loop through the array and remove car if provided vin is found.
	  for(int i = 0; i < this.inventory.size(); i++) {
		  if(this.inventory.get(i).getVin().equals(vin)) {
			  Automobile removedCar = this.inventory.remove(i);
			  System.out.println("car removed from inventory; ");
			  removedCar.displayCarDetails();
			  return;
		  }
	  }
	  // Let user know the vin was not found.
	  System.out.println("No car found with that vin number please try again");
  }
  
  // Displays all inventory car details
  public void displayInventory() {
	  if(inventory.size() == 0) {
		  System.out.println("There are no cars in your inventory");
		  return;
	  }

	  for(int i = 0; i < this.inventory.size(); i++) {
		  System.out.println("running");
		  this.inventory.get(i).displayCarDetails();
	  }
  }
  
  
}
