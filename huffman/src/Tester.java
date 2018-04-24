import java.io.File;
import java.io.FileNotFoundException;

public class Tester {

	public static void main(String[] args) {
		HuffmanEncoder tester = new HuffmanEncoder();
		
		File file = new File("files//text");
		
		try {
			String key = "! 1\nA 1\na 2\nb 1";
			System.out.print(tester.getFrequencies(file).equals(key));
		} catch (FileNotFoundException e) {
			System.out.print("File not found");
		}
		

	}

}
