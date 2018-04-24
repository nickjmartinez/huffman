
class ArrayItem {
	private char element;
	private int count;
	
	public ArrayItem() {
		count = 0;
	}
	
	public void update(char c) {
		count++;
		element = c;
	}
	
	char getElelment() {
		return element;
	}
	
	int getCount() {
		return count;
	}
	
}
