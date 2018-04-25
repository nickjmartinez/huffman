import java.io.*;

public class Tester {

	public static void main(String[] args) {
		HuffmanEncoder tester = new HuffmanEncoder();
		
		File file = new File("files//illiad");
		HuffTree test = null;;
		try {
			test = tester.buildTree(file);
			tester.getFrequencies(file);
			tester.traverseHuffmanTree(test);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
	}

}
