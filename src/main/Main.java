package main;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import dealership.Dealership;
import automobile.Automobile;

public class Main {
	public static void main(String[] args) {
		Dealership dealership = new Dealership("Great dealership");
		getUserInputs(dealership);
	}
	
	public static void writeToFile(Dealership dealership) {	
		try {
			String fileName = "Dealer_Inventory.txt";
			FileOutputStream fileStream = new FileOutputStream(fileName);
			PrintWriter outFS = new PrintWriter(fileStream);
			ArrayList<Automobile> inventory = dealership.getInventory();
			
			// loop through the inventory
			for(int i = 0; i < inventory.size(); i++) {
				outFS.println("Car " + 1);
				String[] carDetails = inventory.get(i).formatCarDetails();
				
				// Print car details to file
				for(int j = 0; j< carDetails.length; j++) {
					outFS.println(" - " + carDetails[j]);
				}
			}
			
			System.out.println("Inventory saved to " + fileName);
			outFS.close();
		} catch (FileNotFoundException e) {
			System.out.println("An issue occured while writing to file.");
		}
	}
	
	public static  void getUserInputs(Dealership dealership) {
		try (Scanner scnr = new Scanner(System.in)) {
		while (true) {
				System.out.println("What woud you like to do? Select a number.");
				System.out.println("1) Add car to inventory");
				System.out.println("2) Remove car from inventory");
				System.out.println("3) Save inventory to file");
				System.out.println("4) Exit the program");
			
				int choice = scnr.nextInt();
				scnr.nextLine();
				
				switch (choice) {
					case 1:
						dealership.addCar(scnr);
						break;
					case 2:
						dealership.removeCar(scnr);
						break;
					case 3: 
						writeToFile(dealership);
						break;
					case 4:
						System.out.println("Exiting the program");
						return;
				}
				
			}
		}
	}

}
