
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;


public class DanhSachHocSinh {
    private ArrayList<HocSinh> dshs = new ArrayList<>();
    private Scanner sc;
    public DanhSachHocSinh(Scanner sc) {
        this.sc = sc;
    }
   

public void themHocSinh(){
    System.out.println("chọn loại học sinh muốn thêm: ");
    System.out.println("1. Nội Trú");
    System.out.println("2. Ngoại Trú");
    int chon = Integer.parseInt(sc.nextLine());

    HocSinh hs = null;
    switch (chon) {
        case 1:
            hs = new NoiTru();
            break;
        case 2:
            hs = new NgoaiTru();
            break;
    }
    String maMoi = HocSinh.getMaHSTiepTheo();
    hs.setmaHS(maMoi);
    hs.nhap();
    dshs.add(hs);
}
    
public void hienThiDanhSach() {
        if (dshs.isEmpty()) {
            System.out.println("Danh sách học sinh trống.");
        } else {
            for (HocSinh hs : dshs) {
                hs.hienThi();
            }
        }
    }


public HocSinh timHocSinh(String maHS) {
        for (HocSinh hs : dshs) {
            if (hs.getmaHS().equals(maHS)) {
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
            System.out.println("1. Sửa mã học sinh");
            System.out.println("2. Sửa tên học sinh");
            System.out.println("4. Sửa giới tính học sinh");
            System.out.println("5. Sửa năm sinh học sinh");
            System.out.println("3. Sửa mã lớp");
            System.out.println("6. Sửa hạnh kiểm học sinh");
            System.out.println("7. Sửa loại học sinh");
            System.out.println("8. Sửa khu nội trú/địa chỉ ");
            System.out.println("0. Thoát sửa");
            System.out.print("Chọn: ");
            luaChon = Integer.parseInt(sc.nextLine());

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập mã học sinh mới: ");
                    hs.setmaHS(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Nhập họ tên mới: ");
                    hs.sethoTen(sc.nextLine());
                    break;
                
                case 3:
                    System.out.print("Nhập giới tính mới: ");
                    hs.setgioiTinh(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Nhập năm sinh mới: ");
                    hs.setnamSinh(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Nhập mã lớp mới: ");
                    hs.setmaLop(sc.nextLine());
                    break;
                case 6:
                    System.out.println("nhập hạnh kiếm mới: ");
                    hs.sethanhKiem(sc.nextLine());
                    break;
                case 7: 
                    System.out.println("nhập loại học sinh mới: ");
                    hs.setloaihocsinh(sc.nextLine());
                    break;
                case 8:
                    if (hs instanceof NoiTru) {
                        System.out.print("Nhập khu nội trú mới: ");
                        ((NoiTru) hs).setKhuNoiTru(sc.nextLine());
                    } else if (hs instanceof NgoaiTru) {
                        System.out.print("Nhập địa chỉ mới: ");
                        ((NgoaiTru) hs).setDiaChiNha(sc.nextLine());
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
public void docTuFile(String TenFile ){
    try {

			BufferedReader input = new BufferedReader(new FileReader(TenFile));

			String line = input.readLine();

			while (line != null) {
				String[] arr = line.split(",");
            if (arr.length == 8) {
            String maHS = arr[0];
            String hoTen = arr[1];
            
            String gioiTinh = arr[2];
            int namSinh = Integer.parseInt(arr[3]);
            String maLop = arr[4];
            String hanhKiem = arr[5];
            String loaihocsinh = arr[6];
        
            HocSinh hs;

             if (loaihocsinh.equalsIgnoreCase("nội trú")) {
             hs = new NoiTru(hoTen,gioiTinh,namSinh, maHS,maLop, hanhKiem, loaihocsinh, arr[7]);
             } else {
             hs = new NgoaiTru(hoTen, gioiTinh,namSinh,maHS,maLop, hanhKiem, loaihocsinh, arr[7]);
             }

             dshs.add(hs);
               }

			}
            System.out.println("Doc file thanh cong HocSinh.txt!");
			input.close();
		}
		catch (Exception ex) {
            System.out.println("Loi khi đọc file HocSinh.txt: ");
			ex.printStackTrace();
		}
}


public void ghiRaFile(String tenFile) {
    try {
        FileWriter fw = new FileWriter("HocSinh.txt",false);
       for (HocSinh hs : dshs) {
            fw.write(hs.getmaHS() + "," + hs.gethoTen() + "," + hs.getnamSinh() + "," +
                    hs.getmaLop() + "," + hs.gethanhKiem() + "," + hs.getloaihocsinh() + "," +
                    (hs instanceof NoiTru ? ((NoiTru) hs).getKhuNoiTru() : ((NgoaiTru) hs).getDiaChiNha()) + "\n");
       }
        fw.close();
        System.out.println("Ghi file thành công!");
    } catch (Exception e) {
        e.printStackTrace();
    }
}}
