package SmallestRectangleEnclosingBlackPixelsBetter;
// https://evelynn.gitbooks.io/google-interview/smallest_rectangle_enclosing_black_pixels.html
// Refer for original above

// algorithm runs in O(m log n + n log m)
public class Solution {

//	
	private char[][] image;
	public static void main(String args[]){
		char[][] image = {{'0', '0', '0', '0', '0'},
						  {'1', '1', '0', '0', '0'},
						  {'1', '1', '1', '1', '0'},
						  {'0', '0', '1', '0', '0'},
						  {'0', '0', '1', '0', '0'},
						  {'0', '0', '0', '0', '0'}};
		
		int area = minArea(image, 2, 3);
		System.out.println(area);
	}
	private static int minArea(char[][] image, int x, int y) {
		int left = getColumn(image, 0, y, 0, image.length-1, true);
		int right = getColumn(image, y, image[0].length-1, 0, image.length - 1, false);
		int top = getRow(image, 0, x, left, right, true);
		int bottom = getRow(image, x, image.length - 1, left, right, false);
		return (right-left)* (bottom-top);
	}
	private static int getRow(char[][] image, int start, int end, int left, int right, boolean isTop) {
		while(start < end){
			int mid = start + (end-start)/2;
			int k = left;
			while(k <= right && image[mid][k] == '0'){k++;}
			if(k <= right == isTop){
				end = mid;
			}else{
				start = mid+1;
			}
		}
		return start;
	}
	private static int getColumn(char[][] image, int start, int end, int top, int bottom, boolean isLeft) {
		while(start < end){
			int mid = start + (end-start)/2;
			int k = top;
			while(k <= bottom && image[k][mid] == '0'){k++;}
			if(k <= bottom == isLeft){
				end = mid;
			}else{
				start = mid+1;
			}
		}
		return start;
	}	
	
//    public static int minArea(char[][] image, int x, int y) {
//        int m = image.length, n = image[0].length;
//        int left = searchColumns(image, 0, y, 0, m, true);
//        int right = searchColumns(image, y + 1, n, 0, m, false);
//        int top = searchRows(image, 0, x, left, right, true);
//        int bottom = searchRows(image, x + 1, m, left, right, false);
//        return (right - left) * (bottom - top);
//    }
//    private static int searchColumns(char[][]image, int i, int j, int top, int bottom, boolean opt) {
//        while (i != j) {
//            int k = top, mid = (i + j) / 2;
//            while (k < bottom && image[k][mid] == '0') ++k;
//            if (k < bottom == opt)
//                j = mid;
//            else
//                i = mid + 1;
//        }
//        return i;
//    }
//    private static int searchRows(char[][]image, int i, int j, int left, int right, boolean opt) {
//        while (i != j) {
//            int k = left, mid = (i + j) / 2;
//            while (k < right && image[mid][k] == '0') ++k;
//            if (k < right == opt)
//                j = mid;
//            else
//                i = mid + 1;
//        }
//        return i;
//    }

}
