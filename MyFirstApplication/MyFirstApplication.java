public class MyFirstApplication {

	public static void main(String[] args) {
		MyFirstApplication myFirstApp = new MyFirstApplication();

		myFirstApp.congratulateUser();
		int result = myFirstApp.someDifficultCalculation(1);

		myFirstApp.printHelloWorld();
	}

	/**
	 * Method that congratulates the user.
	 */
	public void congratulateUser() {
		System.out.println("Congratulations, you have succesfully run this application!");
	}

	/**
	 * Unused method to demonstrate how you can generate Javadoc from the command line
	 * @param argument1 The first argument
	 * @param argument2 The second argument
	 * @return The sentence "Congratulations!"
	 */
	public String unusedMethodWithArguments(int argument1, double argument2) {
		return "Congratulations!";
	}

	/**
	 * Very difficult calculation method that calculates the next logical natural
	 * sequential value within the limits of Integer domain.
	 * @param argument The input
	 * @return the next logical natural sequential number of the argument
	 */
	public int someDifficultCalculation(int argument) {
		return argument + 1;
	}

	/**
	 * Create an instance of HelloWorldPrinter.
	 */
	public void printHelloWorld() {
		new HelloWorldPrinter();
	}

	/**
	 * Simple inner class to show you what happens during compile time.
	 */
	public class HelloWorldPrinter {
		/**
		 * Simple constructor that just prints out a line!
		 */
		public HelloWorldPrinter() {
			System.out.println("Hello World from an inner class!");
		}

	}
}
