package AddAndSearchWordDataStructure;
// LCA
public class WordDictionary {
	Node root;
	public WordDictionary(){
		root = new Node();
	}
	public void addWord(String word) {
		Node temp = root;
		for(int i = 0; i<word.length(); i++){
			 char ch = word.charAt(i);
			 if(temp.child[ch-'a'] == null){temp.child[ch-'a'] = new Node();}
			 temp = temp.child[ch - 'a'];
		}
		temp.isWord = true;
	}
	public boolean search(String word){
		return search(word, root);
	}
	public boolean search(String word, Node root) {
		Node temp = root;
		for(int i = 0; i<word.length() ; i++){
			char ch = word.charAt(i);
			if(ch == '.'){
				for(int j = 0; j<26;j++){
					if(temp.child[j] != null){
						boolean isWord = search(word.substring(i+1), temp.child[j]);
						if(isWord){return true;}
					}
				}
				return false;
			}
			if(temp.child[ch-'a'] == null){return false;}
			temp = temp.child[ch-'a'];
		}
		return temp.isWord;
	}
}
