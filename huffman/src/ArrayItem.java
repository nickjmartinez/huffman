
class ArrayItem {
	private char element;
	private int count;
	
	public ArrayItem(char e) {
		element = e;
		count = 1;
	}
	
	void incriment() {
		count++;
	}
	
	char getElelment() {
		return element;
	}
	
	int getCount() {
		return count;
	}
	
}
