//Class to be store in the frequency table, holds both the char and frequency
class ArrayItem {
	private char element;
	private int frequency;
	
	public ArrayItem(char e) {
		element = e;
		frequency = 1;
	}
	
	void incriment() {
		frequency++;
	}
	
	char getElelment() {
		return element;
	}
	
	int getFrequency() {
		return frequency;
	}
	
}
