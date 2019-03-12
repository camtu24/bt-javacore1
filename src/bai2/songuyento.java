package bai2;

import java.util.Scanner;

import bai1.NumberException;

public class songuyento {

	public static void main(String[] args) {
		//liệt kê số nguyên tố nhỏ hơn n
		Scanner input = new Scanner(System.in);
		int n = 0;
		boolean cont = false;
		do {
			try {
				System.out.print("Mời nhập n:");
				n = Integer.parseInt(input.nextLine());
				if(n<0) {
					throw new NumberException("Mời nhập số dương!");
				}
				cont = false;
			} catch (NumberFormatException e) {
				cont = true;
				System.out.println("Lỗi!!!");
				System.out.println("-----NHẬP LẠI------");
			} catch (NumberException e) {
				cont = true;
				e.printStackTrace();
				System.out.println("-----NHẬP LẠI------");
			}
		} while (cont);
		if(n<=2) {
			System.out.println("Không có số nguyên tố nào nhỏ hơn "+n+"!");
			return;
		}
		String check = "p";
		System.out.println("Các số nguyên tố nhỏ hơn "+n+" là: ");
		for (int i = 2; i < n; i++) {
			for (int j = 2; j < i; j++) {
				if(i%j==0) {
					check = "p";
					break;
				}else {
					check="c";
				}
			}
			if(check.equals("c")|| i==2) {
				System.out.println(i);
			}
		}
	}

}
