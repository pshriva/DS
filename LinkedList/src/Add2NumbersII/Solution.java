package Add2NumbersII;
//LCA
public class Solution {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(7);
		l2.next = new ListNode(3);
		ListNode result = addNumbers(l1, l2);
//		System.out.println(result.val);
	}

	private static ListNode addNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;
		int len1 = 0;
		int len2 = 0;
		int sum = 0;
		ListNode temp1 = l1;
		ListNode temp2 = l2;
		int carry = 0;
		//find lengths of lists
		while(temp1 != null){
			len1++;
			temp1 = temp1.next;
		}
		while(temp2 != null){
			len2++;
			temp2 = temp2.next;
		}
		temp1 = l1;
		temp2 = l2;
		while(len1 > 0 && len2 > 0){
			if(len1 > len2){
				sum = temp1.val;
				len1--;
				temp1 = temp1.next;
				}
			else if(len2 > len1){
				sum = temp2.val;
				len2--;
				temp2 = temp2.next;
				}
			else{
				sum = temp1.val + temp2.val;
				temp2 = temp2.next;
				temp1 = temp1.next;
				len1--;
				len2--;
			}
			ListNode l = new ListNode(sum);
			l.next = result;
			result = l;
		}
		ListNode curr = result;
		ListNode prev = null;
		while(curr != null){
			int s = (curr.val + carry)%10;
			carry = (curr.val + carry)/10;
			curr.val = s;
			prev = curr;
			curr = curr.next;
		}
		if(carry != 0){
			prev.next = new ListNode(carry);
		}
		//reverse the list
		prev = null;
		curr = result;
		while(curr != null){
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		result = prev;
        return result;
	}
}
