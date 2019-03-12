package bai8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SinhVienManager {

	public void menu() {
		System.out.println("==========*** QUẢN LÝ SINH VIÊN ***==========");
		System.out.println("  1. Add student.");
		System.out.println("  2. Edit student by id.");
		System.out.println("  3. Delete student by id.");
		System.out.println("  4. Sort student by gpa.");
		System.out.println("  5. Sort student by name.");
		System.out.println("  6. Show student.");
		System.out.println("  0. Exit.");
	}
	public ArrayList<SinhVien> addData(ArrayList<SinhVien> listSV, int n){
		Scanner input = new Scanner(System.in);
		boolean cont = true;
		for (int i = 1; i <= n; i++) {
			System.out.println("Mời nhập thông tin sinh viên thứ " + i+":");
			String id="";
			do {
				System.out.print("ID: ");
				id = input.nextLine();
				cont = false;
				if(checkID(listSV, id)) {
					System.out.println("Trùng ID! Mời nhập lại!");
					cont=true;
				}
			} while (cont);
			
			System.out.print("Name: ");
			String name = input.nextLine();
			
			int age = 0;
			do {
				try {
					System.out.print("Age: ");
					age = Integer.parseInt(input.nextLine());
					if(age <= 0) {
						throw new NumberException("Tuổi phải lớn hơn 0!");
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
			
			System.out.print("Address: ");
			String address = input.nextLine();
			
			float gpa = 0;
			do {
				try {
					System.out.println("Gpa: ");
					gpa = Float.parseFloat(input.nextLine());
					if(gpa < 0 || gpa > 10) {
						throw new NumberException("Điểm không hợp lệ!");
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
			SinhVien obj = new SinhVien(id, name, age, address, gpa);
			listSV.add(obj);
		}
		System.out.println("ĐÃ NHẬP XONG!!!");
		return listSV;
	}
	
	public boolean checkID(ArrayList<SinhVien> listSV,String cid) {
		boolean check = false;
		for (SinhVien sinhVien : listSV) {
			if(cid.equalsIgnoreCase(sinhVien.getId())) {
				check = true;
			}
		}
		return check;
	}
	
	public boolean checkEID(ArrayList<SinhVien> listSV,String cid, String eid) {
		boolean check = false;
		for (SinhVien sinhVien : listSV) {
			if((cid.equalsIgnoreCase(sinhVien.getId())) && (!cid.equalsIgnoreCase(eid))) {
				check = true;
			}
		}
		return check;
	}
	
	public void edit(ArrayList<SinhVien> listSV) {
		if(listSV.size() > 0) {
			Scanner input = new Scanner(System.in);
			boolean cont = true;
			String eid = "";
			do {
				System.out.print("Nhập mã sinh viên muốn sửa: ");
				eid = input.nextLine();
				cont = false;
				if(checkID(listSV, eid) == false) {
					System.out.println("Mã sinh viên này không tồn tại!");
					System.out.println("----------Vui lòng nhập lại!----------");
					cont=true;
				}
			} while (cont);
			
			for (int i = 0; i < listSV.size(); i++) {
				if(eid.equalsIgnoreCase(listSV.get(i).getId())) {
					String id="";
					do {
						System.out.print("ID: ");
						id = input.nextLine();
						cont = false;
						if(checkEID(listSV, id,eid)) {
							System.out.println("Trùng ID! Mời nhập lại!");
							cont=true;
						}
					} while (cont);
					
					System.out.print("Name: ");
					String name = input.nextLine();
					
					int age = 0;
					do {
						try {
							System.out.print("Age: ");
							age = Integer.parseInt(input.nextLine());
							if(age <= 0) {
								throw new NumberException("Tuổi phải lớn hơn 0!");
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
					
					System.out.print("Address: ");
					String address = input.nextLine();
					
					float gpa = 0;
					do {
						try {
							System.out.println("Gpa: ");
							gpa = Float.parseFloat(input.nextLine());
							if(gpa < 0 || gpa > 10) {
								throw new NumberException("Điểm không hợp lệ!");
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
					SinhVien obj = new SinhVien(id, name, age, address, gpa);
					listSV.set(i, obj);
				}
			}
		}else {
			System.out.println("Chưa có dữ liệu!");
		}
	}
	
	public void delete(ArrayList<SinhVien> listSV) {
		if(listSV.size() > 0) {
			Scanner input = new Scanner(System.in);
			boolean cont = true;
			String did = "";
			do {
				System.out.println("Nhập mã sinh viên muốn xóa: ");
				did = input.nextLine();
				cont = false;
				if(checkID(listSV, did) == false) {
					System.out.println("Mã sinh viên này không tồn tại!");
					System.out.println("----------Vui lòng nhập lại!----------");
					cont=true;
				}
			} while (cont);
			
			for (int i = 0; i < listSV.size(); i++) {
				if(did.equalsIgnoreCase(listSV.get(i).getId())) {
					listSV.remove(i);
					System.out.println("Đã xóa thông tin sinh viên có ID: "+did);
				}
			}
		}else {
			System.out.println("Chưa có dữ liệu!");
		}
	}
	
	public void sortByGpa(ArrayList<SinhVien> listSV) {
		if(listSV.size() > 0) {
			System.out.println("Sắp xếp sinh viên tăng dần theo điểm trung bình:");
			System.out.println("================================================");
			Collections.sort(listSV, new Comparator<SinhVien>() {
				@Override
				public int compare(SinhVien sv1, SinhVien sv2) {
					if(sv1.getGpa() > sv2.getGpa()) {
						return 1;
					}else {
						if(sv1.getGpa() == sv2.getGpa()) {
							return 0;
						}else {
							return -1;
						}
					}
				}
			});
			show(listSV);
			
			System.out.println("Sắp xếp sinh viên giảm dần theo điểm trung bình:");
			System.out.println("================================================");
			Collections.reverse(listSV);
			show(listSV);
		}else {
			
		}
	}
	
	public void sortByName(ArrayList<SinhVien> listSV) {
		if(listSV.size() > 0) {
			System.out.println("Sắp xếp sinh viên tăng dần theo tên:");
			System.out.println("================================================");
			Collections.sort(listSV, new Comparator<SinhVien>() {
				@Override
				public int compare(SinhVien sv1, SinhVien sv2) {
					return (sv1.getName().compareTo(sv2.getName()));
				}
			});
			show(listSV);
			
			System.out.println("Sắp xếp sinh viên giảm dần theo tên:");
			System.out.println("================================================");
			Collections.reverse(listSV);
			show(listSV);
		}else {
			System.out.println("Chưa có dữ liệu!");
		}
	}
	
	public void show(ArrayList<SinhVien> listSV) {
		if(listSV.size() > 0) {
			System.out.println("--------------->>>DANH SÁCH SINH VIÊN<<<---------------");
			System.out.println("");
			System.out.println("ID: \t\t| Name \t\t| Age \t\t| Address \t\t| Gpa");
			for (SinhVien sv : listSV) {
				System.out.println(sv.getId()+" \t\t| "+sv.getName()+" \t\t| "+sv.getAge()+" \t\t| "+sv.getAddress()+" \t\t| "+sv.getGpa());
			}
		}else {
			System.out.println("Chưa có dữ liệu!");
		}
	}
}
