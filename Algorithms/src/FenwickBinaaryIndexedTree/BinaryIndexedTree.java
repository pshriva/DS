package FenwickBinaaryIndexedTree;

public class BinaryIndexedTree {
	int[] tree;
	int n;
	public BinaryIndexedTree(int n){
		tree = new int[n+1];
		this.n = n;
	}
	public void createTree(int[] freq) {
//		the len of freq is n, that is already set in the constructor
		for(int i = 0; i< n ; i++){
			update(freq[i], i);
		}
		for(int i : tree){
			System.out.print(i + " ");
		}
	}
	public void update(int value, int index) {
		index = index+1;
		while(index <= n){
			tree[index] += value;
//			index = 2's compliment (-index), AND with original-> (index&(-index)), add to original-> (index + (index&(-index)))
//			to get the next effective element
			index += index&(-index);
		}
	}
	
	public int getSum(int index){
		index = index+1;
		int sum = 0;
		while(index > 0){
			sum += tree[index];
			index -= index&(-index);
		}
		return sum;
	}

}
