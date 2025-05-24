class errorDect {
	void checkAge(int age) throws ArrayIndexOutOfBoundsException {
		if (age < 18) {
			int arr[] = new int[3];
			arr[3] = 5;
		} else {
			System.out.println("Access granted - You are old enough!");
		}
	}
}

public class ThrowsExcep {
	public static void main(String[] args) {
		errorDect er = new errorDect();
		try {
			er.checkAge(15);
			// er.checkAge(19);
		} catch (Exception e) {
			System.out.println("You are not old enough. Error is:\t" + e);
			e.printStackTrace();
		}
		System.out.println("End of code.");
	}
}
