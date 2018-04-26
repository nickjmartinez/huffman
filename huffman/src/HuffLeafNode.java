//Leaf Node for Huff Tree
//Code in following block was used from OpenDSA
/*------------------------------------------*/
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
/*------------------------------------------*/
