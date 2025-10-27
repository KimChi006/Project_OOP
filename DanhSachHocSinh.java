import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import model.HocSinh;


public class DanhSachHocSinh {
    private ArrayList<HocSinh> dshs = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
   

public void themHocSinh(){
    System.out.println("chọn loại học sinh muốn thêm: ");
    System.out.println("1. Nội Trú");
    System.out.println("2. Ngoại Trú");
    int chon = Integer.parseInt(sc.nextLine());
    HocSinh = null;

    switch (chon) {
        case 1:
            hs=new NoiTru();
            break;
        case 2:
            hs=new NgoaiTru();
            break;
    }
    hs.nhap();
    dshs.add(hs);
}
    
public void hienThiDanhSach() {
        if (dshs.isEmpty()) {
            System.out.println("Danh sách học sinh trống.");
        } else {
            for (HocSinh hs : dshs) {
                System.out.println(hs);
            }
        }
    }


public HocSinh timHocSinh(String maHS) {
        for (HocSinh hs : dshs) {
            if (hs.getMaHS().equals(maHS)) {
                return hs;
            }
        }
        return null;
    }

 
public void suaHocSinh() {
        System.out.print("Nhập mã HS cần sửa: ");
        String maHS = sc.nextLine();
        HocSinh hs = timHocSinh(maHS);
        if (hs == null) {
            System.out.println("Không tìm thấy học sinh.");
            return;
        }

        int luaChon;
        do {
            System.out.println("\n--- Chọn thông tin cần sửa ---");
            System.out.println("1. Sửa họ tên");
            System.out.println("2. Sửa năm sinh");
            System.out.println("3. Sửa lớp");
            System.out.println("4. Sửa hạnh kiểm");
            System.out.println("5. Sửa loại học sinh");
            System.out.println("6. Sửa khu nội trú/địa chỉ ");
            System.out.println("0. Thoát sửa");
            System.out.print("Chọn: ");
            luaChon = Integer.parseInt(sc.nextLine());

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập họ tên mới: ");
                    hs.setHoTen(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nhập năm sinh mới: ");
                    hs.setnamSinh(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Nhập lớp mới: ");
                    hs.setLop(sc.nextLine());
                    break;
                case 4:
                    System.out.println("nhập hạnh kiếm mới: ");
                    hs.sethanhKiem(sc.nextLine());
                    break;
                case 5: 
                    System.out.println("nhập loại học sinh mới: ");
                    hs.setloaihocsinh(sc.nextLine());
                    break;
                case 6:
                    if (hs instanceof NoiTru) {
                        System.out.print("Nhập khu nội trú mới: ");
                        ((NoiTru) hs).setKhuNoiTru(sc.nextLine());
                    } else if (hs instanceof NgoaiTru) {
                        System.out.print("Nhập địa chỉ mới: ");
                        ((NgoaiTru) hs).setDiaChi(sc.nextLine());
                    }
                    break;
                case 0:
                    System.out.println("Đã thoát sửa.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (luaChon != 0);
    }

  
public void xoaHocSinh() {
        System.out.print("Nhập mã học sinh cần xóa: ");
        String maHS = sc.nextLine();
        HocSinh hs = timHocSinh(maHS);
        if (hs != null) {
            dshs.remove(hs);
            System.out.println("Đã xóa học sinh.");
        } else {
            System.out.println("Không tìm thấy học sinh.");
        }
    }
public void readFile(String TenFile ){
    try {

			BufferedReader input = new BufferedReader(new FileReader("HocSinh.txt"));

			String line = input.readLine();

			while (line != null) {
				String[] arr = line.split(",");
            if (arr.length == 8) {
            String maHS = arr[0];
            String hoTen = arr[1];
            int namSinh = arr[2];
            String gioiTinh = arr[3];
            String lop = arr[4];
            String hanhKiem = arr[5];
            String loaihocsinh = arr[6];
        
            HocSinh hs;

             if (loai.equalsIgnoreCase("nội trú")) {
             hs = new NoiTru(maHS, hoTen, tuoi, lop, hanhKiem, loai, arr[7]);
             } else {
             hs = new NgoaiTru(maHS, hoTen, tuoi, lop, hanhKiem, loai, arr[7]);
             }

             dshs.add(hs);
               }

			}
			input.close();
		}
		catch (Exception ex) {
				ex.printStackTrace();
		}
}


public void writeFile(String tenFile) {
    try {
        FileWriter fw = new FileWriter("HocSinh.txt",false);
       for (HocSinh hs : dshs) {
            fw.write(hs.getMaHS() + "," + hs.getHoTen() + "," + hs.getnamSinh() + "," +
                    hs.getLop() + "," + hs.gethanhKiem() + "," + hs.getloaihocsinh() + "," +
                    (hs instanceof NoiTru ? ((NoiTru) hs).getkhuNoiTru() : ((NgoaiTru) hs).getdiaChiNha()) + "\n");
       }
        fw.close();
        System.out.println("Ghi file thành công!");
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    DanhSachHocSinh dshs = new DanhSachHocSinh();
    dshs.themHocSinh();
    System.out.print("Nhập mã học sinh cần tìm: ");
    String maHS = sc.nextLine();
    dshs.timHocSinh(maHS);

    dshs.suaHocSinh();
    dshs.xoaHocSinh();
    dshs.hienThiDanhSach();
}
}

