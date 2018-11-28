package SmallestRectangleEnclosingBlackPixels;
//LL
public class Solution {
	static int top;
	static int bottom;
	static int left;
	static int right;
	static int area;
	public static void main(String[] args) {
		char[][] image = {{'0','0','1','0'},
						  {'0','1','1','0'},
						  {'0','1','0','0'}};
		int x = 0;
		int y = 2;
		int minArea = getMinAreaEnclosingOnes(image, x, y);
		System.out.println(minArea);
	}

	private static int getMinAreaEnclosingOnes(char[][] image, int x, int y) {
		top = x;
		bottom = x;
		left = y;
		right = y;
		boolean visited[][] = new boolean[image.length][image[0].length];
		getDimensions(image, x, y, visited);
		return (right-left + 1) * (bottom - top + 1);
	}

	private static void getDimensions(char[][] image, int x, int y, boolean[][] visited) {
		if(x < 0 || y < 0
				 || x >= image.length 
				 || y >= image[0].length 
				 || image[x][y] == '0' 
				 || visited[x][y]){
			return;
		}
		visited[x][y] = true;
		top = Math.min(top, x);
		bottom = Math.max(top, x);
		left = Math.min(left, y);
		right = Math.max(right, y);
		getDimensions(image, x-1, y, visited);
		getDimensions(image, x+1, y, visited);
		getDimensions(image, x, y-1, visited);
		getDimensions(image, x, y+1, visited);
	}

}
