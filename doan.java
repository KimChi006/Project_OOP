package OOP;

import java.util.Scanner;
import java.util.*;
import java.io.*;

interface IThaoTacFile {
    void docTuFile(String tenFile);
    void ghiRaFile(String tenFile);
}
class Nguoi {
    protected String hoTen;
    protected String gioiTinh;
    protected int namSinh;

    public Nguoi() {}

    public Nguoi(String hoTen, String gioiTinh, int namSinh) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
    }

    public void hienThi() {
        System.out.printf("%-20s %-8s %-6d", hoTen, gioiTinh, namSinh);
    }

    // Getter – Setter
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }
}
class GiaoVien extends Nguoi {
	static int magvtieptheo;
    private String maGV;
    private MonHoc monDay;
    private String chucVu;

    public GiaoVien() {
        super();
    }

    public GiaoVien(String maGV, String hoTen, String gioiTinh, int namSinh, MonHoc monDay, String chucVu) {
        super(hoTen, gioiTinh, namSinh);
        this.maGV = maGV;
        this.monDay = monDay;
        this.chucVu = chucVu;
    }
    public static String getMaGVTiepTheo() {
        String ma = "GV" + String.format("%03d", magvtieptheo);
        magvtieptheo++;
        return ma;
    }

    // --------------------------
    // 🟢 Cập nhật mã lớn nhất sau khi đọc file
    // --------------------------
    public static void capNhatMaLonNhat(String maHienCo) {
        // maHienCo dạng "GV005" → tách lấy số
        int so = Integer.parseInt(maHienCo.substring(2));
        if (so >= magvtieptheo)
        	magvtieptheo = so + 1; // tăng để không bị trùng
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã giáo viên: ");
        maGV = sc.nextLine();
        System.out.print("Nhập họ tên: ");
        hoTen = sc.nextLine();
        System.out.print("Nhập giới tính: ");
        gioiTinh = sc.nextLine();
        System.out.print("Nhập năm sinh: ");
        namSinh = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập môn dạy: ");
        String tenMon = sc.nextLine();
        monDay = new MonHoc(tenMon, "", 0);
        System.out.print("Nhập chức vụ: ");
        chucVu = sc.nextLine();
    }

    public void hienThi() {
        System.out.printf("%-10s ", maGV);
        super.hienThi();
        System.out.printf(" %-15s %-10s\n", 
            monDay != null ? monDay.getTenMon() : "Chưa có", chucVu);
    }

    // Getter - Setter
    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public MonHoc getMonDay() {
        return monDay;
    }

    public void setMonDay(MonHoc monDay) {
        this.monDay = monDay;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

}
class DanhSachGiaoVien implements IThaoTacFile {
    private ArrayList<GiaoVien> danhSach = new ArrayList<>();

    public void themGV(GiaoVien gv) {
    	 String maMoi = GiaoVien.getMaGVTiepTheo();
    	    gv.setMaGV(maMoi);
    	    
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
                Scanner sc = new Scanner(System.in);
                System.out.println("1. Sửa họ tên\n2. Sửa năm sinh\n3. Sửa môn dạy\n4. Sửa chức vụ");
                System.out.print("Chọn mục muốn sửa: ");
                int chon = sc.nextInt();
                sc.nextLine();

                switch (chon) {
                    case 1:
                        System.out.print("Nhập họ tên mới: ");
                        gv.setHoTen(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Nhập năm sinh mới: ");
                        gv.setNamSinh(Integer.parseInt(sc.nextLine()));
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
        try (BufferedReader br = new BufferedReader(new FileReader(GiaoVien.txt))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] t = line.split(",");
                if (t.length >= 6) {
                    MonHoc mh = new MonHoc(t[4], "", 0);
                    GiaoVien gv = new GiaoVien(t[0], t[1], t[2], Integer.parseInt(t[3]), mh, t[5]);
                    danhSach.add(gv);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
        }
    }

    @Override
    public void ghiRaFile(String duongDan) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(GiaoVien.txt))) {
            for (GiaoVien gv : danhSach) {
                bw.write(String.join(",",
                        gv.getMaGV(), gv.getHoTen(), gv.getGioiTinh(),
                        String.valueOf(gv.getNamSinh()),
                        gv.getMonDay().getTenMon(), gv.getChucVu()));
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        }
    }
}
