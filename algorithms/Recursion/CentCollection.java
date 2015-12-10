package algorithms.Recursion;

public class CentCollection {
	private int numPennies;
	public int getNumPennies() {
		return numPennies;
	}
	public void setNumPennies(int numPennies) {
		this.numPennies = numPennies;
	}
	public int getNumNickels() {
		return numNickels;
	}
	public void setNumNickels(int numNickels) {
		this.numNickels = numNickels;
	}
	public int getNumDimes() {
		return numDimes;
	}
	public void setNumDimes(int numDimes) {
		this.numDimes = numDimes;
	}
	public int getNumQuarters() {
		return numQuarters;
	}
	public void setNumQuarters(int numQuarters) {
		this.numQuarters = numQuarters;
	}
	private int numNickels;
	private int numDimes;
	private int numQuarters;
	public CentCollection(){
		numPennies = 0;
		numNickels = 0;
		numDimes = 0;
		numQuarters = 0;
	}
	public CentCollection(int numPennies, int numNickels, int numDimes, int numQuarters){
		this.numPennies = numPennies;
		this.numNickels = numNickels;
		this.numDimes = numDimes;
		this.numQuarters = numQuarters;
	}
}
