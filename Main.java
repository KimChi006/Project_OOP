import java.util.Scanner;
import model.*;
import java.util.*;

public class Main{
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	DanhSachHocSinh dshs = new DanhSachHocSinh();
	DanhSachGiaoVien dsgv = new DanhSachGiaoVien();
	DanhSachMonHoc dsmh = new DanhSachMonHoc();
	DanhSachDiem dsd = new DanhSachDiem();
	DanhSachLop dsl = new DanhSachLop();
	
	dshs.docTuFile("HocSinh.txt");
	dsgv.docTuFile("GiaoVien.txt");
	dsmh.docTuFile("MonHoc.txt");
	dsd.docTuFile("Diem.txt");
	dsl.docTuFile("Lop.txt");
	
	int chon = -1;
	do {
		System.out.println("Chuong trinh quan ly hoc sinh THPT");
		System.out.println("1. Quan ly hoc sinh");
		System.out.println("2. Quan ly giao vien");
		System.out.println("3. Quan ly diem");
		System.out.println("4. Quan ly mon hoc");
		System.out.println("5. Quan ly lop");
		System.out.println("0. Thoat");
		System.out.println("Vui long nhap lua chon:");	
		chon = sc.nextInt();
		
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
				dshs.timHocSinh();
				break;
			case 5:
				dshs.hienThiDanhSach();
			case 6:
				dshs.ghiRaFile("LuuHocSinh.txt");
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
				switch (chongv) {
				case 1:
					GiaoVien gv = new GiaoVien();
					gv.nhap();
					dsgv.themGV(gv);
					break;
				case 2:
					GiaoVien gv = new GiaoVien();
					gv.nhap();
					String magv = gv.getMaGv();
					dsgv.xoaGV(magv);
					break;
				case 3:
					GiaoVien gv = new GiaoVien();
					gv.nhap();
					String magv = gv.getMaGv();
					dsgv.suaGV(magv);
					break;
				case 4:
					dsgv.hienThiTatCa();
					break;
				case 5:
					dsgv.ghiRaFile("LuuGiaoVien.txt");
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
					dsd.ghiRaFile("LuuDiem.txt");
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
				switch (chonmh) {
				case 1:
					MonHoc mh = new MonHoc();
					mh.nhap();
					dsmh.themMon(mh);
					break;
				case 2:
					MonHoc mh = new MonHoc();
					mh.nhap();
					String maMh = mh.getMaMon();
					dsmh.xoaMon(maMh);
					break;
				case 3:
					dsmh.suaMonHoc();
					break;
				case 4:
					dsmh.hienThiTatCa();
					break;
				case 5:
					dsmh.ghiRafile("LuuMonhoc.txt");
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
			
	}while(chon != 0);
	}
}
