package bai7;

import java.util.Arrays;
import java.util.Scanner;

public class SapXepTang {
	public int[] input(int n) {
		int[] arr = new int[n];
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
		SapXepTang sx = new SapXepTang(); 
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
		int[] arrInt = sx.input(n);
		System.out.println("Sắp xếp mảng theo thứ tự tăng dần: ");
		Arrays.sort(arrInt);
		for (Integer ar : arrInt) {
			System.out.print(ar + "  ");
		}
		System.out.print("Mời nhập thêm phần tử x: ");
		int x = Integer.parseInt(input.nextLine());
		int[] arN= sx.insert(arrInt, x);
		Arrays.sort(arN);
		System.out.println("Mảng sau khi thêm phần tử x:");
		for (Integer ar : arN) {
			System.out.print(ar + "  ");
		}
	}
	public int[] insert(int[] arrInt, int x) {
		int[] arN = new int[arrInt.length+1];
		for (int i = 0; i < arrInt.length; i++) {
			arN[i] = arrInt[i];
		}
		arN[arrInt.length] = x;
		return arN;
	}

}
