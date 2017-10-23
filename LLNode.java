public class LLNode{
	String element;
	LLNode next;
	public LLNode(String e,LLNode n) {
		element=e;
		next=n;
	}
	public void setElement(String e) {
		element=e;
	}
	public void setNext(LLNode n) {
		next=n;
	}
	public LLNode getNext() {
		return next;
	}
	public String getElement() {
		return element;
	}
}
