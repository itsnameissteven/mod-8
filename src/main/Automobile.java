package main;
import java.util.Scanner;


public class Automobile {
	private String vin;
	private String make;
	private String model;
	private String color;
	private int year;
	private double mileage;
	private double cost;
	// A type to allow callback as arguments.
	interface Callback {
		void run(Scanner scnr); 
	}
	// Class to validate inputs
	private Validator validator = new Validator();
	
	public Automobile() {
		this.vin = "";
		this.make = "";
		this.model = "";
		this.color = "";
		this.year = 0;
		this.mileage = 0.0;
		this.cost = 0.0;
	}
	
	public Automobile(String vin, String  make, String model, String color, int year, double mileage, double cost) {
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.mileage = mileage;
		this.cost = cost;
	}
	
	// Getters, return the requested value
	public String getVin() {
		return this.vin;
	}
	
	public String getMake() {
		return this.make;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public double getMileage() {
		return this.mileage;
	}
	
	public double cost() {
		return this.cost;
	}
	
	// Setters -- The following setters have validation built in and will throw
	// an error if incorrect argument is passed
	public void setVin(String vin) {
		validator.validateString(vin, "Vin cannot be null or empty.");
		this.vin = vin.trim();
	}
	
	public void setMake(String make) {
		validator.validateString(make,"Make cannot be null or empty.");
		this.make = make.trim();
	}
	
	public void setModel(String model ) {
		validator.validateString(model, "Model cannot be null or empty.");
		this.model =  model;
	}
	
	public void setColor(String color) {
		validator.validateString(color, "Color cannot be null or empty.");
		this.color = color.trim();
	}
	
	public void setYear(int year) {
		validator.validateYearFormat(year, "The year format is YYYY please enter a 4 digit number");
		this.year = year;
	}
	
	public void setMileage(double mileage) {
		validator.validatePositiveDouble(mileage, "Mileage must be a positive number");
		this.mileage = mileage;
	}
	
	public void setCost(double cost) {
		validator.validatePositiveDouble(cost, "Cost must be a positive number");
		this.cost = cost;
	}
	
	// Returns an array of user friendly strings.
	public String[] formatCarDetails() {
		String[] carList= {
				"Vin: " + this.vin,
				"Make: " + this.make, 
				"Model: " + this.model, 
				"Color: " + this.color, 
				"Year " + this.year, 
				"Mileage: " + this.mileage,
				"Cost: " + this.cost,
				};
		return carList;
	}
	
	// A user friendly display of all the car details
	public void displayCarDetails() {
		for(int i = 0; i < this.formatCarDetails().length; i++) {
			System.out.println(this.formatCarDetails()[i]);
		}
	}
	
	// functions to prompt user inputs, each goes through the validation process
	private void promptVinInput (Scanner scnr) {
		System.out.println("Enter the vin of the car: ");
		setVin(scnr.nextLine());
	}
	
	private void promptMakeInput(Scanner scnr) {
		System.out.println("Enter the make of the car: ");
		setMake(scnr.nextLine());
	}
	
	private void promptModelInput(Scanner scnr) {
		System.out.println("Enter the model of the car: ");
		setModel(scnr.nextLine());	
	}
	
	private void promptColorInput(Scanner scnr) {
		System.out.println("Enter the color of the car: ");
		setColor(scnr.nextLine());
	}
	
	private void promptYearInput(Scanner scnr) {
		System.out.println("Enter the year of the car: ");
		setYear(scnr.nextInt());	
	}
	
	private void promptMileageInput(Scanner scnr) {
		System.out.println("Enter the mileage of the car: ");
		setMileage(scnr.nextDouble());
	};
	
	private void promptCostInput(Scanner scnr) {
		System.out.println("Enter the cost of the car: ");
		setCost(scnr.nextDouble());
	}
	
	
	// Will validate a user input or loop if incorrect value provided. 
	// accepts a callback to setData
	private void validateInput(Scanner scnr, Callback callback) {
		while (true) {
			try{	
				callback.run(scnr);
				break;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	// Gets user inputs from scanner one at a time.
	public void inputCarDetails(Scanner scnr) {	
		this.validateInput(scnr, this::promptVinInput);
		this.validateInput(scnr, this::promptMakeInput);
		this.validateInput(scnr, this::promptModelInput);
		this.validateInput(scnr, this::promptColorInput);
		this.validateInput(scnr, this::promptYearInput);
		this.validateInput(scnr, this::promptMileageInput);
		this.validateInput(scnr, this::promptCostInput);	
	}
}
