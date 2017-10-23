public class BSTNode{
	String element;			//a sorted verson of a word acting as an index for comparing purpose
	LLNode analist;			//a list of anagram in linked list structure, it should contain 1 or more element in an existing BSTNode
	BSTNode left;				//left means less than the parent
	BSTNode right;			//right means greater than the parent
	public BSTNode(){
		element="";
		analist=null;
		left=null;
		right=null;
	}
	public BSTNode(String e,LLNode a){
		element=e;
		analist=a;
	  left=null;
		right=null;
	}
	public BSTNode(String e,LLNode a,BSTNode l,BSTNode r) {
		element=e;
		analist=a;
		left=l;
		right=r;
	}
	public void add(String sorted,String word){

		helpAdd(this,sorted,word);
	}
	private void helpAdd(BSTNode tree,String sorted,String word){

			if(tree.getElement().compareTo(sorted)==0){
				LLNode temp=new LLNode(word,tree.getList().getNext()); //adding the element after the head of the list
				tree.getList().setNext(temp);
			}
			else if(tree.getElement().compareTo(sorted)==-1){
				if(tree.getLeft()==null){
					tree.setLeft(new BSTNode(sorted,new LLNode(word,null))); //travel the tree to find if the element already exist
				}																													//create a new BSTNode if not
				else																											//it should take O(log n) on average
				helpAdd(tree.getLeft(),sorted,word);
			}
			else{
				if(tree.getRight()==null){
					tree.setRight(new BSTNode(sorted,new LLNode(word,null)));
				}
				else
				helpAdd(tree.getRight(),sorted,word);
			}

	}
	public LLNode getList(){
		return analist;
	}
	public void setElement(String e) {
		element=e;
	}
	public void setLeft(BSTNode l) {
		left=l;
	}
	public BSTNode getLeft() {
		return left;
	}
	public BSTNode getRight(){
		return right;
	}
	public void setRight(BSTNode r){
		right=r;
	}
	public String getElement() {
		return element;
	}
	public boolean isEmpty(){
		return element.isEmpty();
	}

}
