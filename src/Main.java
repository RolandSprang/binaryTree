import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Roland Sprang
 *
 */
public class Main {
	public static void main(String[] args) {
		int option;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> arLs = new ArrayList<>();
		BinaryTree tree = new BinaryTree();
		
		do {
			System.out.println("Bitte geben sie den vollstaendigen Pfad zu Ihrer .csv Datei ein. ");
			System.out.print("Pfad: ");			
			arLs = DocumentParser.parseCsvFile(scanner.nextLine());
			if(arLs != null) {
				tree.insertArray(arLs);
			}
			System.out.println();
		}while(tree.getRoot() == null);
		
		do {
			System.out.println("Folgende Optionen gibt es. Bitte geben Sie die jeweilige Zahl ein.\r\n" + 
					"\r\n" + 
					"-------------------------------------------------\r\n" + 
					"| 1 | Binaeren Baum in der Console ausgeben.	|\n" + 
					"-------------------------------------------------\n" + 
					"| 2 | Summe und Mittelwert des Baums ausgeben.	|\n" + 
					"-------------------------------------------------\n" + 
					"| 3 | Kleinste Zahl des Baums ausgeben.		|\n" + 
					"-------------------------------------------------\n" + 
					"| 4 | Groeßte Zahl des Baums ausgeben.		|\n" + 
					"-------------------------------------------------\n" + 
					"| 5 | Alle Optionen aufeinmal ausgeben.		|\n" + 
					"-------------------------------------------------\n" + 
					"| 0 | Programm beenden.				|\n" + 
					"-------------------------------------------------");
			System.out.print("Ihre Option: ");
			option = scanner.nextInt();
			System.out.println("\n\n");
			switch (option) {
			case 1:
				tree.printTree();
				System.out.println("\n\n");
				break;
			case 2: 
				System.out.println("Summe aller Werte: " + tree.getSum() + 
						"\nMittelwert des Baums: " + tree.getAVG() + "\n\n");
				break;
			case 3: 
				System.out.println("Kleinster Wert  im Baum: " + tree.getMin() + "\n\n");
				break;
			case 4: 
				System.out.println("Groesster Wert im Baum: " + tree.getMax() + "\n\n");
				break;
			case 5: 
				tree.printTree();
				System.out.println("\nSum: " + tree.getSum() + "\nAVG: " + tree.getAVG() + "\nMin: " + tree.getMin() +
						"\nMax: " + tree.getMax() + "\n\n");
			default:
				break;
			}
			
		}while(option > 0);
		scanner.close();
		System.exit(0);
		
	}
}
