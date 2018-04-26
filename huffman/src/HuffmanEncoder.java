import java.io.*;

public class HuffmanEncoder implements HuffmanCoding{
	private ArrayItem table[];
	private String codeTable[];
	private MinHeap heap;
	private String codeString = "";
	private int size = 128;
	
	public String getFrequencies(File inputFile) throws FileNotFoundException {
		makeTable(inputFile);										//make frequency table
		String thing = "";
		int counter = 0;
		for (int i = 0; i < table.length; i++) {					//go through frequency table
			if (table[i] != null) {									//if we have a frequency for this char
				if (counter > 0) {
					thing += "\n";
				}
				String element;
				
				element = table[i].getElelment()+"";
				
				thing += element + " " + table[i].getFrequency();
				counter++;
			}
		}
		System.out.println(thing);
		System.out.println();
		return thing;
	}


	public HuffTree buildTree(File inputFile) throws FileNotFoundException, Exception {
		makeTable(inputFile);
		buildHeap();
		
		//Code in following block was used from OpenDSA
		/*------------------------------------------*/
		HuffTree tmp1,tmp2,tmp3 = null;
		while(heap.getHeapSize() > 1) {
			tmp1 = heap.popMin();
			tmp2 = heap.popMin();
			tmp3 = new HuffTree(tmp1.root(), tmp2.root(), tmp1.weight() + tmp2.weight());
			heap.insert(tmp3);
		}
		return tmp3;
		/*------------------------------------------*/
	}

	public String encodeFile(File inputFile, HuffTree huffTree) throws FileNotFoundException {
		makeTable(inputFile);
		dig(huffTree.root(), "");
		
		String code = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));

			String line;
			
			while ((line = reader.readLine()) != null) {
				for (int i = 0; i < line.length(); i++) {
					char letter = line.charAt(i);
					int num = letter;
					code += codeTable[num];
				}
			}
			reader.close();
		} catch (IOException e) {
			System.out.print("File not found");
		}
		return code;
	}

	public String decodeFile(String code, HuffTree huffTree) throws Exception {
		codeTable = new String[size];
		dig(huffTree.root(), "");
		
		
		HuffBaseNode curr = huffTree.root();
		HuffInternalNode currInt = null;
		HuffLeafNode currLeaf = null;
		
		String key = "";
		
		for (int i = 0; i < code.length(); i++) {
			currInt = (HuffInternalNode) curr;
			
			if (code.charAt(i) == '0') {
				curr = currInt.left();
			}else {
				curr = currInt.right();
			}
			
			if (curr.isLeaf()) {
				currLeaf = (HuffLeafNode) curr;
				key += currLeaf.getElement();
				curr = huffTree.root();
			}
		}
		
		return key;
	}

	public String traverseHuffmanTree(HuffTree huffTree) throws Exception {
		
		dig(huffTree.root(),"");
		
		for (int i = 0; i < codeTable.length; i++) {
			if (codeTable[i] != null) {
				codeString += Character.toString((char) i) + " " + codeTable[i] + "\n";
			}
		}
		System.out.print(codeString);
		return codeString;
	}
		
	void dig(HuffBaseNode node, String code) {					//recursive function to traverse Huff tree
		if (node.isLeaf()) {									//if at a leaf, take note of the code to get here and return to previous node
			HuffLeafNode leaf = (HuffLeafNode) node;	
			int num = leaf.getElement();
			codeTable[num] = code;
			//System.out.println(leaf.getElement()+ " " + code);
			return;
		}
		HuffInternalNode temp = (HuffInternalNode) node;
		dig(temp.left(), code +"0");							//recursive call down left subtree
		dig(temp.right(), code + "1");							//recursive call down right subtree
	}
	
	private ArrayItem[] makeTable(File inputFile) throws FileNotFoundException{
		table = new ArrayItem[size];
		codeTable = new String[size];
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));

			String line;

			while ((line = reader.readLine()) != null) {
				for (int i = 0; i < line.length(); i++) {
					char letter = line.charAt(i);
					int num = letter;
					if (table[num] == null) {
						table[num] = new ArrayItem(letter);
					}else {
						table[num].incriment();
					}
				}
			}
			reader.close();
			return table;
		} catch (IOException e) {
			System.out.print("File not found");
		}
		return null;
	}

	private void buildHeap() {
		heap = new MinHeap();

		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				HuffTree temp = new HuffTree(table[i].getElelment(), table[i].getFrequency()); //for every value in frequency table, make a huff tree for it and add to heap (it will be a single root)
				heap.insert(temp);
			}
		}
	}
}
