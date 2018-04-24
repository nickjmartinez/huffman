
class HuffLeafNode implements HuffBaseNode{
	private char element;
	private int weight;
	
	HuffLeafNode(char e, int w) {
		element = e;
		weight = w;
	}
	
	char getElement() {
		return element;
	}
	
	public int weight() {
		return weight;
	}
	
	public boolean isLeaf() {
		return true;
	}

	
}
