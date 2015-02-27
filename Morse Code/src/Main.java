import java.io.*;





public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		Tree t = new Tree("/Volumes/Mac HD/users/jgabbard/Documents/workspace/Morse Code/src/morsecode.txt");
		t.inOrder();
		System.out.println();
		t.preOrder();
		System.out.println();
		t.postOrder();
		System.out.println();
		t.translate("/Volumes/Mac HD/users/jgabbard/Documents/workspace/Morse Code/src/translation.txt");
}
}