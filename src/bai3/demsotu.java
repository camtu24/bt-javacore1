package bai3;

import java.util.Scanner;

public class demsotu {

	public static void main(String[] args) {
		//đếm số từ trong xâu ký tự
		Scanner input = new Scanner(System.in);
		System.out.println("Mời nhập sâu ký tự: ");
		String chuoi = input.nextLine();
		int dem=0;

		boolean cont = true;
		for (int i = 0; i < chuoi.length(); i++) {
			if(chuoi.charAt(i) != ' ' && chuoi.charAt(i) != '\t' && chuoi.charAt(i) != '\n') {
				if(cont) {
					dem++;
					cont=false;
				}
			}else {
				cont=true;
			}
		}
		System.out.println("Số từ có trong chuỗi: " + dem);
	}

}
