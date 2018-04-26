//Internal Node for Huff Tree
//Code in following block was used from OpenDSA
/*------------------------------------------*/
public class HuffInternalNode implements HuffBaseNode{
	private int weight;
	private HuffBaseNode left;
	private HuffBaseNode right;

	HuffInternalNode(HuffBaseNode l,HuffBaseNode r, int wt){ 
		left = l; 
		right = r; 
		weight = wt; 
	}

	HuffBaseNode left() { 
		return left; 
	}

	HuffBaseNode right() { 
		return right; 
	}

	public boolean isLeaf() {
		return false;
	}

	public int weight() {
		return weight;
	}

}
/*------------------------------------------*/
