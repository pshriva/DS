package LN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution2 {
	public static void main(String args[]){
//		Capital or small letters
		List<String> result = new ArrayList<>();
		List<String> names = new ArrayList<>(Arrays.asList("alex", "xylos", "alex", "alan", "alex"));
		System.out.println(names);
		Collections.sort(names);
		System.out.println(names);
		result.add(names.get(0));
		for(int i = 1; i< names.size(); i++){
			String name = names.get(i);
			if(name == names.get(i-1)){
				name = name + i;
			}
			result.add(name);
		}
		System.out.println(result);
	}
}
