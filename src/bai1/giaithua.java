package bai1;

import java.util.Scanner;

public class giaithua {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//tính giai thừa của n
		Scanner input = new Scanner(System.in);
		boolean cont = false;
		int n = 0;
		int giaithua = 1;
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
		
		for(int i=1; i<=n; i++) {
			giaithua *= i;
		}
		System.out.println(n+"! = " + giaithua);
	}

}
