
class ArrayItem {
	private String element;
	private int count;
	
	public ArrayItem() {
		element = "";
		count = 0;
	}
	
	void incriment() {
		count++;
	}
	
	String getElement() {
		return element;
	}
	
	int getCount() {
		return count;
	}
}
