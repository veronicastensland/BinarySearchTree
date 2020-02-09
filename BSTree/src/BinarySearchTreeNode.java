
/**
 * 
 * Detta är den enda av de tre klasserna ni ska göra några ändringar i. (Om ni
 * inte vill lägga till fler testfall.) Det är också den enda av klasserna ni
 * ska lämna in. Glöm inte att namn och användarnamn ska stå i en kommentar
 * högst upp, och att paketdeklarationen måste plockas bort vid inlämningen för
 * att koden ska gå igenom de automatiska testerna.
 * 
 * De ändringar som är tillåtna är begränsade av följande:
 * <ul>
 * <li>Ni får INTE byta namn på klassen.
 * <li>Ni får INTE lägga till några fler instansvariabler.
 * <li>Ni får INTE lägga till några statiska variabler.
 * <li>Ni får INTE använda några loopar någonstans. Detta gäller också alterntiv
 * till loopar, så som strömmar.
 * <li>Ni FÅR lägga till fler metoder, dessa ska då vara privata.
 * <li>Ni får INTE låta NÅGON metod ta en parameter av typen
 * BinarySearchTreeNode. Enbart den generiska typen (T eller vad ni väljer att
 * kalla den), String, StringBuilder, StringBuffer, samt primitiva typer är
 * tillåtna.
 * </ul>
 * 
 * @author henrikbe
 * 
 * @param <T>
 */
//@SuppressWarnings("unused") // Denna rad ska plockas bort. Den finns här
							// tillfälligt för att vi inte ska tro att det är
							// fel i koden. Varningar ska normalt inte döljas på
							// detta sätt, de är (oftast) fel som ska fixas.
public class BinarySearchTreeNode<T extends Comparable<T>> {

	private T data;
	private BinarySearchTreeNode<T> left;
	private BinarySearchTreeNode<T> right;


	public BinarySearchTreeNode(T data) {
		this.data = data;
		left = null;
		right = null;
	}

	/**
	 * Om add-datan är mindre än this.data ska den till vänster i trädet,
	 * om left-noden inte är tom - kolla om den som ska läggas till är mindre,
	 * annars ska den till höger osv
	 */
	public boolean add(T data) {

		if (data == null) return false;
		int compareResult = this.data.compareTo(data);

		/* Value is lower, add to left child node */
		if (compareResult > 0) {

			/* if no left child node, create one */
			if (this.left == null) {
				this.left = new BinarySearchTreeNode<T>(data);
				return true;
			}
			/* if left child node, pass on data */
			else {
				return this.left.add(data);
			}
		}
		
		/* Value is higher, add to right child node */
		if (compareResult < 0) {

			/* if no right child node, create one */
			if (this.right == null) {
				this.right = new BinarySearchTreeNode<T>(data);
				return true;
			}
			/* if right child node, pass on data */
			else {
				return this.right.add(data);
			}
		}

		/* Duplicate; do nothing */
		return false;

	}

	private T findMin() {
		// if (this.left == null) return this.data;
		
		return null;
	}

	public BinarySearchTreeNode<T> remove(T data) {
		int compareResult = data.compareTo(this.data);
		if (compareResult < 0) {
			this.left = remove(data);
		}
	}

	public boolean contains(T data) {
		if (data == null) return false;
		int compareResult = data.compareTo(this.data);

		if (compareResult < 0) {
			if (this.left == null) return false;
			else return this.left.contains(data);
		}
		else if (compareResult > 0) {
			if (this.right == null) return false;
			else return this.right.contains(data);
		}

		else return true;
	}

	public int size() {
		int leftSize = 0;
		int rightSize = 0;
		if (this.left != null) leftSize = this.left.size();
		if (this.right != null) rightSize = this.right.size();
		return leftSize + 1 + rightSize;
	}

	public int depth() {
		if (this.left == null && this.right == null) return 0;

		int leftDepth = 0;
		int rightDepth = 0;
		if (this.left != null) leftDepth = this.left.depth();
		if (this.right != null) rightDepth = this.right.depth();

		if (leftDepth > rightDepth) return leftDepth + 1;
		else return rightDepth + 1;
	}

	public String toString() {
		if (this.left == null && this.right == null) return this.data.toString();

		String leftString = "";
		String rightString = "";
		if (this.left != null) leftString = this.left.toString() + ", ";
		if (this.right != null) rightString = ", " + this.right.toString();
		
		return leftString + this.data + rightString;
	}
}
