package NumberOfIslandsII;

import java.util.*;

public class Solution {
	public static void main(String args[]){
		int m = 3;
		int n = 3;
//		int[][] positions = {{0, 0}, {0, 2}, {0, 1}, {2, 1}, {1, 1}};
		int[][] positions = {{1, 2}, {0, 2}, {0, 1}, {0, 0}, {1, 0}, {1, 1}, {2, 2}};
//		int[][] positions = {{0, 2}, {0, 1}, {0, 0}, {1, 0}, {1, 1}, {2, 2}};
		List<Integer> islands = getCount(m, n, positions);
		System.out.println(islands);
	}

	private static List<Integer> getCount(int m, int n, int[][] positions) {
		int[] rootArray = new int[m*n];
		Arrays.fill(rootArray, -1);
		List<Integer> result = new ArrayList<>();
		int count = 0;
		int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		for(int[] p : positions){
			count++;
			int index = p[0]*n + p[1];
			rootArray[index] = index;
			for(int r = 0; r < 4; r++){
				int i = p[0] + directions[r][0];
				int j = p[1] + directions[r][1];
				if(i >= 0 && j >= 0 && i < m && j < n && rootArray[i*n+j] != -1){
					int thisRoot = getRoot(rootArray, i*n+j);
					if(thisRoot != index){
						count--;
						rootArray[thisRoot] = index;
					}
				}
			}
			result.add(count);
		}
		return result;
	}

	private static int getRoot(int[] rootArray, int i) {
		while(i != rootArray[i]){
			i = rootArray[i];
		}
		return i;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	Solution with statements for debugging

//	private static List<Integer> getCount(int m, int n, int[][] positions) {
//		int[] rootArray = new int[m*n];
//	    Arrays.fill(rootArray,-1);
//	 
//	    ArrayList<Integer> result = new ArrayList<Integer>();
//	 
//	    int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
//	    int count=0;
//	 
//	    for(int k=0; k<positions.length; k++){
//	        count++;
//	 
//	        int[] p = positions[k];
//	        int index = p[0]*n+p[1];
//	        rootArray[index]=index;//set root to be itself for each node
//	        System.out.println("*****Indexes " + p[0] + " , " + p[1] + " count " + count + " root array*****");
//	        for(int i : rootArray){
//		    	System.out.print("    "+i + " ");
//		    }
//	        System.out.println();
//	        for(int r=0;r<4;r++){
//	            int i=p[0]+directions[r][0];
//	            int j=p[1]+directions[r][1];
//	            System.out.println("    directions");
//	            System.out.println("    (" + i + "," + j + ")");
//	            if(i>=0&&j>=0&&i<m&&j<n&&rootArray[i*n+j]!=-1){
//	                //get neighbor's root
//	            	System.out.println("    " + "calling getroot");
//	                int thisRoot = getRoot(rootArray, i*n+j);
//	                System.out.println("    thisRoot " + thisRoot + " index " + index);
//	                if(thisRoot!=index){
//	                	System.out.println("    thisRoot and index not same so changing rootArray and decreasing count as");
//	                    rootArray[thisRoot]=index;//set previous root's root
//	                    
//	                    for(int q : rootArray){
//	        		    	System.out.print("    "+q + " ");
//	        		    }
//	                    count--;
//	                    System.out.println("    count " + count);
//	                }
//	            }
//	        }
//	 
//	        result.add(count);
//	    }
//	    return result;
//	}
//
//	public static int getRoot(int[] arr, int i){
//		System.out.println("    in getRoot function and i is  " + i);
//	    while(i!=arr[i]){
//	    	System.out.println("    Inside while loop in getRoot");
//	        i=arr[i];
//	    }
//	    return i;
//	}
}
