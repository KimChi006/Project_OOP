import java.io.*;
import java.util.*;

public class DanhSachMonHoc implements IThaoTacFile {
    private ArrayList<MonHoc> danhSach = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public DanhSachMonHoc(Scanner sc) {
        this.sc = sc;
    }
}
public void themMon(MonHoc mhnew){
        boolean daTrungLap;    
    do {
        daTrungLap = false; 
        for (MonHoc mh : danhSach) {
            
            if (mh.getMaMon().equalsIgnoreCase(mhnew.getMaMon()) || mh.getTenMon().equalsIgnoreCase(mhnew.getTenMon())) {
                
                System.out.println("⚠️ Môn học đã tồn tại! Vui lòng nhập lại thông tin:");
                daTrungLap = true; 
                int out;         
               
                do {
                    System.out.println("1. Tiếp tục nhập lại");
                    System.out.println("0. Hủy thêm môn");
                    out = Integer.parseInt(sc.nextLine()); 
                    
                    if (out == 0) return; 
                    
                    if (out != 1) {
                         System.out.println("❌ Lựa chọn không hợp lệ. Vui lòng chọn 1 hoặc 0.");
                    }
                } while (out != 1);
                 if (mh.getMaMon().equalsIgnoreCase(mhnew.getMaMon())) {
                    System.out.println("Nhập mã môn mới: ");
                    mhnew.setMaMon(sc.nextLine());
                }
             if (mh.getTenMon().equalsIgnoreCase(mhnew.getTenMon())) {
                    System.out.println("Nhập tên môn mới: ");
                    mhnew.setTenMon(sc.nextLine());
                }
            break;
            }
        }
    } while (daTrungLap);
    danhSach.add(mhnew);
    System.out.println("✅ Đã thêm môn học mới!");
}

 public void xoaMon(String maMon) {
        int chon=-1;
        boolean tontai=false;
        boolean firts=false;
       do{
        if(firts){
         System.out.print("Nhập mã môn muốn xóa: ");
         maMon = sc.nextLine();
        }
         firts=true;
         for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaMon().equalsIgnoreCase(maMon)){
                tontai=true;
                danhSach.remove(i);
                System.out.println("\nĐã xóa môn học có mã: " + maMon);
                break;
                }
            }
        if(!tontai) {
            System.out.println("Mã Môn Không Tồn Tại");
        }
         tontai=false;
         System.out.println("1.Tiếp tục ");
              System.out.println("0.Thoát");
             chon = Integer.parseInt(sc.nextLine());
    }while (chon != 0); 
    }

    public void suaMonHoc() {
          System.out.print("Nhập mã môn muốn sửa: ");
        String ma = sc.nextLine();
        int chon=-1;
        boolean tontai=false;
        boolean firts=false;
       do{
        if(firts){
         System.out.print("Nhập mã môn muốn sửa: ");
         ma = sc.nextLine();
        }
         firts=true;
        for (MonHoc mh : danhSach) {
            if (mh.getMaMon().equalsIgnoreCase(ma)) {
                tontai=true;
                System.out.println("1. Sửa mã môn");
                System.out.println("2. Sửa tên môn");
                System.out.println("3. Sửa số tiết");
                System.out.println("0.Thoát");
                System.out.print("→ Chọn: ");
                 chon = Integer.parseInt(sc.nextLine());
                switch (chon) {
                    case 1 -> {
                        System.out.print("Nhập mã môn mới: ");
                        mh.setMaMon(sc.nextLine());
                         System.out.println("Đã cập nhật mã môn mới ");
                    }
                    case 2 -> {
                        System.out.print("Nhập tên môn mới: ");
                        mh.setTenMon(sc.nextLine());
                        System.out.println("Đã cập nhật tên môn mới ");
                    }
                    case 3 -> {
                        System.out.print("Nhập số tiết mới: ");
                        mh.setSoTiet(Integer.parseInt(sc.nextLine()));
                        System.out.println("Đã cập nhật số tiết mới ");
                    }
                    case 0 -> {
                        return;
                    }
                    default -> System.out.println("Lựa chọn không hợp lệ!");
                }
            }
        }
        if(!tontai) {
            System.out.println("Mã Môn Không Tồn Tại");
            tontai=false;
        }
         System.out.println("1.Tiếp tục ");
              System.out.println("0.Thoát");
             chon = Integer.parseInt(sc.nextLine());
    }while (chon != 0); 
    }
    public void hienThiTatCa() {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sách môn học trống!");
            return;
        }
        System.out.println("=== DANH SÁCH MÔN HỌC ===");
        for (MonHoc mh : danhSach) {
            mh.hienThi();
        }
    }

    @Override
    public void docTuFile(String tenFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            danhSach.clear();
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String ma = parts[0].trim();
                    String ten = parts[1].trim();
                    int soTiet = Integer.parseInt(parts[2].trim());
                    danhSach.add(new MonHoc(ma, ten, soTiet));
                }
            }
            System.out.println("✅ Đọc file MonHoc.txt thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file MonHoc.txt: " + e.getMessage());
        }
    }

    @Override
    public void ghiRaFile(String tenFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile))) {
            for (MonHoc mh : danhSach) {
                bw.write(mh.toFileString());
                bw.newLine();
            }
            System.out.println("Ghi file thành công!");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
}

