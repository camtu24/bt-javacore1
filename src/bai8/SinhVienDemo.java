package bai8;

import java.util.ArrayList;
import java.util.Scanner;

public class SinhVienDemo {

	public static void main(String[] args) {
		SinhVienManager objSv = new SinhVienManager();
		Scanner input = new Scanner(System.in);
		objSv.menu();
		ArrayList<SinhVien> list = new ArrayList<SinhVien>();
		System.out.println("==========*** WELCOME ***==========");
		boolean condition = true;
		do {
			try {
				System.out.print("Mời chọn chức năng: ");
				int chon = Integer.parseInt(input.nextLine());
				switch (chon) {
				case 0:
					System.out.println("Tạm biệt!");
					condition=false;
					break;
				case 1:
					System.out.println("Bạn muốn thêm bao nhiêu sinh viên? ");
					int n = Integer.parseInt(input.nextLine());
					list = objSv.addData(list,n);
					break;
				case 2:
					objSv.edit(list);
					break;
				case 3:
					objSv.delete(list);
					break;
				case 4:
					objSv.sortByGpa(list);
					break;
				case 5:
					objSv.sortByName(list);
					break;
				case 6:
					objSv.show(list);
					break;
				default:
					System.out.println("Mời chọn chức năng từ 0 - 6!");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Lỗi!!!");
				System.out.println("-----NHẬP LẠI------");
			}
			
		} while (condition);
		

	}

}
