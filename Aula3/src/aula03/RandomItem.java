package aula03;

public class RandomItem {

	private String name;
	private int counter;
	private double price;

	public RandomItem() {
		this.name = randomString(5);
		this.counter = randomInt(-5, 5);
		this.price = randomDouble(0.01, 100.00);
	}

	public String toString() {
		return String.format("%s, %3d, %6.2f", name, counter, price);
	}

	//// PRIVATE METHODS //////////////////////////////////

	private String randomString(int len) {
		char[] rc = new char[len];
		for (int i = 0; i < rc.length; i++)
			rc[i] = randomAZ();
		return new String(rc);
	}

	private final int AZ_RANGE = ('Z' - 'A' + 1);

	private char randomAZ() {
		return (char) ('A' + Math.random() * AZ_RANGE);
	}

	private int randomInt(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}

	private double randomDouble(double min, double max) {
		return min + Math.random() * (max - min + 1.0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}