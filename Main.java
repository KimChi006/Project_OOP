import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		DanhSachHocSinh dshs = new DanhSachHocSinh(sc);
		DanhSachGiaoVien dsgv = new DanhSachGiaoVien(sc);
		DanhSachMonHoc dsmh = new DanhSachMonHoc(sc);
		DanhSachDiem dsd = new DanhSachDiem(sc);
		DanhSachLop dsl = new DanhSachLop(sc);
	
		dshs.docTuFile("Data\\HocSinh.txt");
		dsgv.docTuFile("Data\\GiaoVien.txt");
		dsmh.docTuFile("Data\\MonHoc.txt");
		dsd.docTuFile("Data\\Diem.txt");
		dsl.docTuFile("Data\\LopHoc.txt");
	
		int chon = -1;
		do {
			System.out.println("\n=============================");
			System.out.println("CHUONG TRINH QUAN LY HOC SINH THPT");
			System.out.println("=============================");
			System.out.println("1. Quan ly hoc sinh");
			System.out.println("2. Quan ly giao vien");
			System.out.println("3. Quan ly diem");
			System.out.println("4. Quan ly mon hoc");
			System.out.println("5. Quan ly lop");
			System.out.println("0. Thoat");
			System.out.println("Vui long nhap lua chon:");	

			chon = sc.nextInt();
			sc.nextLine();
		
			switch(chon) {
			case 1:
				int chonhs =-1;
				do {
				System.out.println("Menu Quan ly hoc sinh");
				System.out.println("1. Them hoc sinh");
				System.out.println("2. Xoa hoc sinh");
				System.out.println("3. Sua thong tin hoc sinh");
				System.out.println("4. Tim kiem hoc sinh");
				System.out.println("5. Hien thi tat ca");
				System.out.println("6. Luu thong tin hoc sinh vao file");
				System.out.println("0. Thoat");
				System.out.println("Vui long nhap lua chon:");
			
				chonhs = sc.nextInt();
				sc.nextLine();

				switch (chonhs) {
				case 1:
					dshs.themHocSinh();
					break;
				case 2:
					dshs.xoaHocSinh();
					break;
				case 3:
					dshs.suaHocSinh();
					break;
				case 4:
					System.out.println("Nhap ma hoc sinh can tim:");
					String mahs = sc.nextLine();
					dshs.timHocSinh(mahs);
					break;
				case 5:
					dshs.hienThiDanhSach();
					break;
				case 6:
					dshs.ghiRaFile("Data/LuuHocSinh.txt");
					break;
				case 0:
					System.out.println("Thoat quan ly hoc sinh");
					break;
				}
				}while(chonhs != 0);
				break;
			
			case 2:
				int chongv = -1;
				do {
					System.out.println("Menu Quan ly giao vien");
					System.out.println("1. Them giao vien");
					System.out.println("2. Xoa giao vien");
					System.out.println("3. Sua thong tin giao vien");
					System.out.println("4. Hien thi tat ca");
					System.out.println("5. Luu thong tin giao vien vao file");
					System.out.println("0. Thoat");
					System.out.println("Vui long nhap lua chon:");
				
					chongv = sc.nextInt();
					sc.nextLine();

					GiaoVien gv = new GiaoVien();

					switch (chongv) {
					case 1:
						gv.nhap();
						dsgv.themGV(gv);
						break;
					case 2:
						System.out.println("Nhap ma giao vien can xoa:");
						String magv = sc.nextLine();
						dsgv.xoaGV(magv);
						break;
					case 3:
						System.out.println("Nhap ma giao vien can xoa:");
						String mgv = sc.nextLine();
						dsgv.suaGV(mgv);
						break;
					case 4:
						dsgv.hienThiTatCa();
						break;
					case 5:
						dsgv.ghiRaFile("Data/LuuGiaoVien.txt");
						break;
					case 0:
						System.out.println("Thoat quan ly giao vien");
						break;
				}
				}while(chongv != 0);
				break;
				
			case 3:
				int chond = -1;
				do {
					System.out.println("Menu Quan ly diem cua hoc sinh");
					System.out.println("1. Tinh diem trung binh");
					System.out.println("2. Sua diem cua hoc sinh");
					System.out.println("3. Hien thi tat ca");
					System.out.println("4. Luu thong tin giao vien vao file");
					System.out.println("0. Thoat");
					System.out.println("Vui long nhap lua chon:");
				
					chond = sc.nextInt();
					sc.nextLine();
		
					switch (chond) {
					case 1:
						dsd.tinhDiemTrungBinh();
						break;
					case 2:
						dsd.suaDiem();
						break;
					case 3:
						dsd.hienThiTatCa();
						break;
					case 4:
						dsd.ghiRaFile("Data/LuuDiem.txt");
						break;
					case 0:
						System.out.println("Thoat quan ly diem");
						break;
					}
				}while(chond != 0);
				break;
			
			case 4:
				int chonmh = -1;
				do {
					System.out.println("Menu Quan ly mon hoc ");
					System.out.println("1. Them mon hoc");
					System.out.println("2. Xoa mon hoc");
					System.out.println("3. Sua mon hoc");
					System.out.println("4. Hien thi tat ca");
					System.out.println("5. Luu thong tin vao file");
					System.out.println("0. Thoat");
					System.out.println("Vui long nhap lua chon:");
				
					chonmh = sc.nextInt();
					sc.nextLine();

					MonHoc mh = new MonHoc();
					
					switch (chonmh) {
					case 1:
						mh.nhap();
						dsmh.themMon(mh);
						break;
					case 2:
						System.out.println("Nhap ma mon hoc can xoa:");
						String maMh = sc.nextLine();
						dsmh.xoaMon(maMh);
						break;
					case 3:
						dsmh.suaMonHoc();
						break;
					case 4:
						dsmh.hienThiTatCa();
						break;
					case 5:
						dsmh.ghiRaFile("Data/LuuMonhoc.txt");
						break;
					case 0:
						System.out.println("Thoat quan ly diem");
						break;
					}
				}while(chonmh != 0);
				break;
				
			case 5:
				dsl.menu();
				break;
			case 0:
				System.out.println("Thoat chuong trinh!");
				break;
			}	
		}while(chon != 0);
	}
}
