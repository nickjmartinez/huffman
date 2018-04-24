import java.io.*;
public class Huff implements HuffmanCoding{
	
	public String getFrequencies(File inputFile) throws FileNotFoundException {
		int size = 128;
		
		ArrayItem table[] = new ArrayItem[size];
		for (int i = 0; i < table.length; i++) {
			table[i] = new ArrayItem();
		}
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			
			String line;
			
			while ((line = reader.readLine()) != null) {
				for (int i = 0; i < line.length(); i++) {
					
				}
			}
			
			reader.close();
		} catch (IOException e) {
			
		}
		
		
		return null;
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
