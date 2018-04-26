import java.io.*;

public class Tester {

	public static void main(String[] args) {
		HuffmanEncoder tester = new HuffmanEncoder();
		
		File file = new File("files//rand");
		HuffTree test = null;;
		try {
			test = tester.buildTree(file);
			String frequency = tester.getFrequencies(file);
			String traverse = tester.traverseHuffmanTree(test);
			String encode = tester.encodeFile(file, test);
			String decode = tester.decodeFile(encode, test);
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
	}

}
