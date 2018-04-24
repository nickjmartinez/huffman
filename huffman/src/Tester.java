import java.io.File;

public class Tester {

	public static void main(String[] args) {
		Huff tester = new Huff();
		
		File file = new File("files\\text");
		
		try {
			tester.getFrequencies(file);
		} catch (Exception e) {
			
		}
		

	}

}
