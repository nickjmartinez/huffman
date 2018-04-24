import java.io.*;
public class HuffmanEncoder implements HuffmanCoding{
	
	public String getFrequencies(File inputFile) throws FileNotFoundException {
		int size = 128;
		String thing = "";
		
		ArrayItem table[] = new ArrayItem[size];
		for (int i = 0; i < table.length; i++) {
			table[i] = new ArrayItem();
		}
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			
			String line;
			
			while ((line = reader.readLine()) != null) {
				for (int i = 0; i < line.length(); i++) {
					char letter = line.charAt(i);
					int num = letter;
					table[num].update(letter);
				}
			}
			int counter = 0;
			for (int i = 0; i < table.length; i++) {
				if (table[i].getCount() != 0) {
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
			reader.close();
		} catch (IOException e) {
			System.out.print("Something happened....");
		}
		return thing;
	}

	
	public HuffTree buildTree(File inputFile) throws FileNotFoundException, Exception {
		
		return null;
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
	
}
