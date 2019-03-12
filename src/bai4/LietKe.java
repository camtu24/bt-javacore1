package bai4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class LietKe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);
		System.out.println(" Nhập vào chuỗi :");
		String str = input.nextLine();
		StringTokenizer s = new StringTokenizer(str, " ,\t,\n");
		Map<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<String> ar = new ArrayList<>();
		String st = ""; 		
		while (s.hasMoreElements())
		{
			st = s.nextToken();
			ar.add(st);
			map.put(st, 0);
		}
		
		for (int i = 0; i < ar.size(); i++) {
			String key = ar.get(i);
			if(map.containsKey(key)) {
				int value = map.get(key);
				map.remove(key);
				map.put(key, value+1);
			}	
		}
		
		Set<String> set = map.keySet();
		System.out.println("Số lần xuất hiên của mỗi từ trong xâu: ");
		for (String string : set) {
			System.out.println(string+"\t: "+map.get(string));
		}
		
	}

}
