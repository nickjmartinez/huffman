import java.io.File;
import java.io.FileNotFoundException;

public class Tester {

	public static void main(String[] args) {
		HuffmanEncoder tester = new HuffmanEncoder();
		
		File file = new File("files//hufftest");
		HuffTree test = null;;
		try {
			test = tester.buildTree(file);
			tester.getFrequencies(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
	}

}
