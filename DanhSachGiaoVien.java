import java.io.*;
import java.util.*;

class DanhSachGiaoVien implements IThaoTacFile {
    private ArrayList<GiaoVien> danhSach = new ArrayList<>();
    private Scanner sc;
    public DanhSachGiaoVien(Scanner sc) {
        this.sc = sc;
    }
    public void themGV(GiaoVien gv) {
    	 String maMoi = GiaoVien.getMaGVTiepTheo();
    	    gv.setMaGV(maMoi);
    	    gv.nhap();
    	    
    	    // 🔹 Thêm vào danh sách
    	    danhSach.add(gv);
    	    
    	    System.out.println("→ Đã thêm giáo viên mới với mã: " + maMoi);
    }

    public void xoaGV(String maGV) {
        danhSach.removeIf(gv -> gv.getMaGV().equalsIgnoreCase(maGV));
    }

    public void suaGV(String maGV) {
        for (GiaoVien gv : danhSach) {
            if (gv.getMaGV().equalsIgnoreCase(maGV)) {
                System.out.println("1. Sửa họ tên\n2. Sửa năm sinh\n3. Sửa môn dạy\n4. Sửa chức vụ");
                System.out.print("Chọn mục muốn sửa: ");
                int chon = sc.nextInt();
                sc.nextLine();

                switch (chon) {
                    case 1:
                        System.out.print("Nhập họ tên mới: ");
                        gv.sethoTen(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Nhập năm sinh mới: ");
                        gv.setnamSinh(Integer.parseInt(sc.nextLine()));
                        break;
                    case 3:
                        System.out.print("Nhập tên môn mới: ");
                        String tenMon = sc.nextLine();
                        gv.setMonDay(new MonHoc(tenMon, "", 0));
                        break;
                    case 4:
                        System.out.print("Nhập chức vụ mới: ");
                        gv.setChucVu(sc.nextLine());
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }
                return;
            }
        }
        System.out.println("Không tìm thấy giáo viên có mã " + maGV);
    }

    public void hienThiTatCa() {
        System.out.printf("%-10s %-20s %-8s %-6s %-15s %-10s\n",
                "Mã GV", "Họ tên", "Giới tính", "Năm sinh", "Môn dạy", "Chức vụ");
        for (GiaoVien gv : danhSach) {
            gv.hienThi();
        }
    }

    // ===== TRIỂN KHAI interface ThaoTacFile =====
    @Override
    public void docTuFile(String duongDan) {
        try (BufferedReader br = new BufferedReader(new FileReader(duongDan))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] t = line.split(",");
                if (t.length >= 6) {
                    MonHoc mh = new MonHoc(t[4], "", 0);
                    GiaoVien gv = new GiaoVien(t[0], t[1], t[2], Integer.parseInt(t[3]), mh, t[5]);
                    danhSach.add(gv);
                }
            }
            System.out.println("Doc file thanh cong GiaoVien.txt!");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file GiaoVien.txt: " + e.getMessage());
        }
    }

    @Override
    public void ghiRaFile(String duongDan) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(duongDan))) {
            for (GiaoVien gv : danhSach) {
                bw.write(String.join(",",
                        gv.getMaGV(), gv.gethoTen(), gv.getgioiTinh(),
                        String.valueOf(gv.getnamSinh()),
                        gv.getMonDay().getTenMon(), gv.getChucVu()));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }
}
