package bai6;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SapXepGiam {
	public Integer[] input(int n) {
		Integer[] arr = new Integer[n];
		Scanner input = new Scanner(System.in);
		boolean cont = false;
		do {
			try {
				cont= false;
				for (int i = 0; i < n; i++) {
					System.out.print("Mời nhập số thứ "+i+": ");
					arr[i] = Integer.parseInt(input.nextLine());
					cont= false;
				}
			} catch (NumberFormatException e) {
				cont = true;
				System.out.println("Lỗi!!!");
				System.out.println("-----NHẬP LẠI------");
			}
		} while (cont);
		
		return arr;		
	}

	public static void main(String[] args) {
		SapXepGiam sx = new SapXepGiam(); 
		Scanner input = new Scanner(System.in);
		int n = 0;
		boolean c = false;
		do {
			try {
				System.out.print("Bạn muốn nhập bao nhiêu phần tử [số nguyên]: ");
				n = Integer.parseInt(input.nextLine());
				c = false;
				if(n<=0) {
					c = true;
					System.out.println("Lỗi!!!");
					System.out.println("-----NHẬP LẠI------");
				}
			} catch (NumberFormatException e) {
				c = true;
				System.out.println("Lỗi!!!");
				System.out.println("-----NHẬP LẠI------");
			}
		} while (c);		
		Integer[] arrInt = sx.input(n);
		System.out.println("Sắp xếp mảng theo thứ tự giảm dần: ");
		Arrays.sort(arrInt,Collections.reverseOrder());
		for (Integer ar : arrInt) {
			System.out.println(ar + " ");
		}
	}
}
