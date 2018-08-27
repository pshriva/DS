package SortColors;
//LCA
public class Solution {
	public static void main(String[] args) {
		int[] colors = {2,0,2,1,1,0};
		sortColors(colors);
		for(int i : colors) {System.out.print(i + " ");}
	}

	private static void sortColors(int[] colors) {
		int left = 0;
		int mid = 0;
		int right = colors.length - 1;
		while(mid <= right) {
			if(colors[mid] == 2) {
				colors[mid] = colors[right];
				colors[right] = 2;
				right--;
			}else if(colors[mid] == 0) {
				colors[mid] = colors[left];
				colors[left] = 0;
				left++;
				mid++;
			}else {
				mid++;
			}
		}
	}
}
