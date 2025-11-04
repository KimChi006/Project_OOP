import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class DanhSachHocSinh {
    private ArrayList<HocSinh> dshs = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public DanhSachHocSinh(Scanner sc) {
        this.sc = sc;
    }

    public void themHocSinh() {
        System.out.print("nhập số lượng học sinh muốn thêm: ");
        int n=Integer.parseInt(sc.nextLine());
        for(int i=0; i<n; i++){
            HocSinh hs=null;
            while(hs==null){
        
        System.out.println("\nChọn loại học sinh muốn thêm:");
        System.out.println("1. Nội trú");
        System.out.println("2. Ngoại trú");
        System.out.print("→ Nhập lựa chọn: ");
        int chon = Integer.parseInt(sc.nextLine());
            

        switch (chon) {
            case 1:
                hs = new NoiTru();
                break;
            case 2:
                hs = new NgoaiTru();
                break;
            default:
                System.out.println("❌ Lựa chọn không hợp lệ!");
                return;
        }
    }
        String maMoi = HocSinh.getMaHSTiepTheo();
        hs.setmaHS(maMoi);
        hs.nhap();
        dshs.add(hs);

        System.out.println("✅ Đã thêm học sinh mới với mã: " + maMoi);
}      
    }
    public void hienThiDanhSach() {
        if (dshs.isEmpty()) {
            System.out.println("❗ Danh sách học sinh trống.");
        } else {
            System.out.println("===== DANH SÁCH HỌC SINH =====");
            for (HocSinh hs : dshs) {
                hs.hienThi();
            }
        }
    }
    
    public HocSinh timHocSinh(String maHS) {
        for (HocSinh hs : dshs) {
            if (hs.getmaHS().equalsIgnoreCase(maHS)) {
                return hs;
            }
        }
        return null;
    }

    public void suaHocSinh() {
        System.out.print("Nhập mã học sinh cần sửa: ");
        String maHS = sc.nextLine();
        HocSinh hs = timHocSinh(maHS);

        if (hs == null) {
            System.out.println("❌ Không tìm thấy học sinh.");
            return;
        }

        int luaChon;
        do {
            System.out.println("\n--- Chọn thông tin cần sửa ---");
            System.out.println("1. Mã học sinh");
            System.out.println("2. Họ tên");
            System.out.println("3. Giới tính");
            System.out.println("4. Năm sinh");
            System.out.println("5. Mã lớp");
            System.out.println("6. Hạnh kiểm");
            System.out.println("7. Loại học sinh");
            System.out.println("8. Khu nội trú / Địa chỉ");
            System.out.println("0. Thoát");
            System.out.print("→ Chọn: ");
            luaChon = Integer.parseInt(sc.nextLine());

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập mã mới: ");
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
                    hs.setnamSinh(Integer.parseInt(sc.nextLine()));
                    break;
                case 5:
                    System.out.print("Nhập mã lớp mới: ");
                    hs.setmaLop(sc.nextLine());
                    break;
                case 6:
                    System.out.print("Nhập hạnh kiểm mới: ");
                    hs.sethanhKiem(sc.nextLine());
                    break;
                case 7:
                    System.out.print("Nhập loại học sinh mới (nội trú hoặc ngoại trú): ");
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
                    System.out.println("⬅️ Thoát sửa.");
                    break;
                default:
                    System.out.println("❌ Lựa chọn không hợp lệ.");
            }
        } while (luaChon != 0);
    }

    public void xoaHocSinh() {
        System.out.print("Nhập mã học sinh cần xóa: ");
        String maHS = sc.nextLine();
        HocSinh hs = timHocSinh(maHS);

        if (hs != null) {
            dshs.remove(hs);
            System.out.println("✅ Đã xóa học sinh có mã " + maHS);
        } else {
            System.out.println("❌ Không tìm thấy học sinh.");
        }
    }

    public void docTuFile(String tenFile) {
        try (BufferedReader input = new BufferedReader(new FileReader(tenFile))) {
            String line;
            while ((line = input.readLine()) != null) {
                String[] arr = line.split(",");
                if (arr.length == 8) {
                    String maHS = arr[0];
                    String hoTen = arr[1];
                    String gioiTinh = arr[2];
                    int namSinh = Integer.parseInt(arr[3]);
                    String maLop = arr[4];
                    String hanhKiem = arr[5];
                    String loaiHS = arr[6];
                    String extra = arr[7];

                    HocSinh hs;
                    if (loaiHS.equalsIgnoreCase("Nội trú")) {
                        hs = new NoiTru(hoTen, gioiTinh, namSinh, maHS, maLop, hanhKiem, loaiHS, extra);
                    } else {
                        hs = new NgoaiTru(hoTen, gioiTinh, namSinh, maHS, maLop, hanhKiem, loaiHS, extra);
                    }
                    dshs.add(hs);
                }
            }
            System.out.println("✅ Đọc file thành công: HocSinh.txt!");
        } catch (Exception ex) {
            System.out.println("❌ Lỗi khi đọc file HocSinh.txt:");
            ex.printStackTrace();
        }
    }
    
    public void ghiRaFile(String tenFile) {
        try (FileWriter fw = new FileWriter(tenFile, false)) {
            for (HocSinh hs : dshs) {
                fw.write(hs.getmaHS() + "," +
                        hs.gethoTen() + "," +
                        hs.getgioiTinh() + "," +
                        hs.getnamSinh() + "," +
                        hs.getmaLop() + "," +
                        hs.gethanhKiem() + "," +
                        hs.getloaihocsinh() + "," +
                        (hs instanceof NoiTru ? ((NoiTru) hs).getKhuNoiTru()
                                              : ((NgoaiTru) hs).getDiaChiNha()) + "\n");
            }
            System.out.println("✅ Ghi file HocSinh.txt thành công!");
        } catch (Exception e) {
            System.out.println("❌ Lỗi ghi file: " + e.getMessage());
        }
    }
}
