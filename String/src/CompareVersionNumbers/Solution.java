package CompareVersionNumbers;

public class Solution {
//LCA
	public static void main(String[] args) {
		String s1 = "1";
		String s2 = "1.0.1";
		int result = compareVersions(s1, s2);
		System.out.println(result);
	}

//	private static int compareVersions(String version1, String version2) {
//		String[] v1 = version1.split("\\.");
//        String[] v2 = version2.split("\\.");
//        int i = 0; int j = 0;
//        while(i <v1.length && j < v2.length){
//            if(Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])){return -1;}
//            if(Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])){return 1;}
//            i++;
//            j++;
//        }
//        while(i < v1.length){
//        		if(Integer.parseInt(v1[i]) != 0){return 1;}
//        		i++;
//        }
//        while(j < v2.length){
//        		if(Integer.parseInt(v2[j]) != 0){return -1;}
//        		j++;
//        }
//        return 0;
//	}
	
//	LCA
	private static int compareVersions(String version1, String version2) {
		String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        double d1 = 0;
        double f1 = 1;
        for(String i : v1){
        	d1 = d1 + (Integer.parseInt(i)/f1);
        	f1 *= 10;
        }
        double d2 = 0;
        f1 = 1;
        for(String i : v2){
        	d2 = d2 + (Integer.parseInt(i)/f1);
        	f1 *= 10;
        }
        return d1 == d2 ? 0 : d1 > d2 ? 1 : -1;
	}

}
