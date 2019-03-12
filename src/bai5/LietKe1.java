package bai5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LietKe1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = 0;
		boolean cont = false;
		do {
			try {
				System.out.print("Bạn muốn nhập bao nhiêu phần tử [số nguyên]: ");
				n = Integer.parseInt(input.nextLine());
				cont = false;
				if(n<=0) {
					cont = true;
					System.out.println("Lỗi!!!");
					System.out.println("-----NHẬP LẠI------");
				}
			} catch (NumberFormatException e) {
				cont = true;
				System.out.println("Lỗi!!!");
				System.out.println("-----NHẬP LẠI------");
			}
		} while (cont);
		Integer[] arr = new Integer[n];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			int temp = 0;
			do {
				try {
					System.out.print("Mời nhập số thứ "+i+": ");
					temp = Integer.parseInt(input.nextLine());
					cont= false;
				} catch (NumberFormatException e) {
					cont = true;
					System.out.println("Lỗi!!!");
					System.out.println("-----NHẬP LẠI------");
				}
			} while (cont);
			arr[i] = temp;
			map.put(temp, 0);
		}
		for (int i = 0; i < arr.length; i++) {
			int k = arr[i];
			if(map.containsKey(k)) {
				int value = map.get(k);
				map.remove(k);
				map.put(k, value+1);
			}
		}
		Set<Integer> set = map.keySet();
		System.out.println("Các phần tử chỉ xuất hiện trong mảng đúng 1 lần: ");
		for (Integer key : set) {
			if(map.get(key) == 1) {
				System.out.println(key + "\t: "+map.get(key));
			}
		}
	}

}
