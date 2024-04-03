package validator;
import java.util.Scanner;

public class Validator {
	interface Callback {
		void run(Scanner scnr); 
	}
	public void validateString(String value, String errorMessage) {
		if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
	}
	
	public void validatePositiveDouble(double value, String errorMessage) {
		if (value < 0) {
			throw new IllegalArgumentException(errorMessage);
		}
	}
	
	public void validateYearFormat(int value, String errorMessage) {
		if (String.valueOf(value).length() != 4) {
			throw new IllegalArgumentException(errorMessage);
		}
	}
	
}
