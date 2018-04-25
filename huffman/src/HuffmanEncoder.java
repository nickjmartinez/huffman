import java.io.*;
public class HuffmanEncoder implements HuffmanCoding{
	private ArrayItem table[];
	private MinHeap heap;

	public String getFrequencies(File inputFile) throws FileNotFoundException {
		makeTable(inputFile);
		String thing = "";
		int counter = 0;
		for (int i = 0; i < table.length; i++) {
			if (table[i] != null) {
				if (counter > 0) {
					thing += "\n";
				}
				String element;
				if (table[i].getElelment() == ' ') {
					element = "Space";
				}else {
					element = table[i].getElelment()+"";
				}
				thing += element + " " + table[i].getCount();
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
		
		HuffTree tmp1,tmp2,tmp3 = null;
		while(heap.getHeapSize() > 1) {
			tmp1 = heap.popMin();
			tmp2 = heap.popMin();
			tmp3 = new HuffTree(tmp1.root(), tmp2.root(), tmp1.weight() + tmp2.weight());
			heap.insert(tmp3);
		}
		return tmp3;

	}

	public String encodeFile(File inputFile, HuffTree huffTree) throws FileNotFoundException {

		return null;
	}

	public String decodeFile(String code, HuffTree huffTree) throws Exception {

		return null;
	}

	public String traverseHuffmanTree(HuffTree huffTree) throws Exception {

		return null;
	}

	private ArrayItem[] makeTable(File inputFile) throws FileNotFoundException{
		int size = 128;

		table = new ArrayItem[size];

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
				HuffTree temp = new HuffTree(table[i].getElelment(), table[i].getCount());
				heap.insert(temp);
			}
		}
	}
}
