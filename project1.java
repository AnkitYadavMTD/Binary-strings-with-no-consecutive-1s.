import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public static void generateStringHelper(int k, char str[], int n, ArrayList<String> ans) {

		// Terminate binary string and push in answer.
		if (n == k) {
			ans.add(new String(str));

			return;
		}

		/*
			If previous character is '1' then we put 
			only 0 at end of string.
			Example str = "01" then new string will be "010".
		*/
		if (str[n - 1] == '1') {
			str[n] = '0';
			generateStringHelper(k, str, n + 1, ans);
		}

		/*
			If previous character is '0' then we put 
			both '1' and '0' at end of string.
			Example str = "00" then new string is "001" and "000".
		*/
		if (str[n - 1] == '0') {
			str[n] = '0';
			generateStringHelper(k, str, n + 1, ans);
			str[n] = '1';
			generateStringHelper(k, str, n + 1, ans);
		}
	}

	public static ArrayList<String> generateString(int k) {
		
		ArrayList<String> ans = new ArrayList<>();
		
		if (k == 0) {
			return ans;
		}
		// A string with K elements.
		char str[] = new char[k];
		
		// First character 0.
		str[0] = '0';
		generateStringHelper(k, str, 1, ans);
		
		// First character 1.
		str[0] = '1';
		generateStringHelper(k, str, 1, ans);
		
		Arrays.sort(str);

		return ans;
	}
}
