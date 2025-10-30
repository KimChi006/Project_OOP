
import java.io.*;
import java.util.*;

public class DanhSachMonHoc implements IThaoTacFile {
    private ArrayList<MonHoc> danhSach = new ArrayList<>();
    private Scanner sc;
    public DanhSachMonHoc(Scanner sc) {
        this.sc = sc;
    }

    public void themMon(MonHoc mh) {
        danhSach.add(mh);
    }

    public void xoaMon(String maMon) {
    boolean found = false;
    for (int i = 0; i < danhSach.size(); i++) {
        if (danhSach.get(i).getMaMon().equalsIgnoreCase(maMon)) {
            danhSach.remove(i);
            found = true;
            System.out.println("Đã xóa môn học có mã: " + maMon);
            break; 
        }
    }
    if (!found) {
        System.out.println("Không tìm thấy môn học có mã: " + maMon);
    }
}

    public void suaMonHoc() {
        System.out.print("Nhập mã môn muốn sửa: ");
        String ma = sc.nextLine();

        for (MonHoc mh : danhSach) {
            if (mh.getMaMon().equalsIgnoreCase(ma)) {
                System.out.println("1. Sửa mã môn\n2. Sửa tên môn\n3. Sửa số tiết");
                int chon = Integer.parseInt(sc.nextLine());

                switch (chon) {
                    case 1:
                        System.out.println("NHập mã môn mới");
                        mh.setMaMon(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Nhập tên môn mới: ");
                        mh.setTenMon(sc.nextLine());
                        break;
                    case 3:
                        System.out.print("Nhập số tiết mới: ");
                        mh.setSoTiet(Integer.parseInt(sc.nextLine()));
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy mã môn này!");
    }


    public void hienThiTatCa() {
         if (danhSach.isEmpty()) {
            System.out.println("Danh sách môn học trống");
            return;
        }
        System.out.println("\n=== DANH SÁCH MÔN HỌC ===");
        for (MonHoc mh : danhSach) {
            mh.hienThi();;
          
        }
    }

    @Override
    public void docTuFile(String tenFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            danhSach.clear();
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String ma = parts[0].trim();
                    String ten = parts[1].trim();
                    int soTiet = Integer.parseInt(parts[2].trim());
                    danhSach.add(new MonHoc(ma, ten, soTiet));
                }
            }
            System.out.println("Doc file thanh cong MonHoc.txt!");
        } catch (IOException e) {
            System.out.println("Loi khi đọc file MonHoc.txt: " + e.getMessage());
        }
    }

    @Override
    public void ghiRaFile(String tenFile ) {
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

