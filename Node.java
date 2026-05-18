package arbolesAVL;
class Node {
	int data;
	int bf; // factor de equilibrio
	Node left;
	Node right;
	public Node(int data) {
		this.data = data;
		this.bf = 0;


		this.left = null;
		this.right = null;
	}
	public String toString() {
		return data + "(bf=" + bf + ")";
	}
}
