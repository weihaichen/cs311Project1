import java.util.*;
import java.io.*;

public class anagram_driver {

	public static void main(String[] args) throws Exception{

		BSTNode anag=null; //creating a bst
    String fileName = "dict2";
    FileReader fileReader =
        new FileReader(fileName);


    BufferedReader bufferedReader =
        new BufferedReader(fileReader);


    String line;
		while((line = bufferedReader.readLine()) != null) {
			//String word="";
			MergeSort m=new MergeSort();
			String SortedWord=m.sort(line);			//sorting the word using MergeSort
      if(anag==null){
        anag=new BSTNode(SortedWord,new LLNode(line,null));		//if the tree is empty, initate a new tree
      }
      else{
      anag.add(SortedWord,line);				//add the SortedWord and word to the existing tree
      }
		}

		FileWriter fileWriter =
							 new FileWriter("anagram2");

					 // Always wrap FileWriter in BufferedWriter.
					 BufferedWriter bufferedWriter =
							 new BufferedWriter(fileWriter);

    helpWrite(anag,bufferedWriter);
        System.out.println(size(anag));
		bufferedWriter.close();
	}

  public static void helpWrite(BSTNode tree,BufferedWriter bufferedWriter) throws Exception{ //helper method to write the tree inOrder travesal to the output file
    if(tree==null){
      return;
    }
    LLNode temp=tree.getList();
    while(temp!=null){
      bufferedWriter.write(temp.getElement()+" ");
      temp=temp.getNext();
    }
    bufferedWriter.newLine();
    helpWrite(tree.getLeft(),bufferedWriter);
    helpWrite(tree.getRight(),bufferedWriter);
  }


}
