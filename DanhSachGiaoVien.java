import java.io.*;
import java.util.*;

class DanhSachGiaoVien implements IThaoTacFile {
    private ArrayList<GiaoVien> danhSach = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public DanhSachGiaoVien(Scanner sc) {
        this.sc = sc;
    }

    public void themNHieuGiaoVien(){
        System.out.print("Nhap so luong giao vien muon them vao:");
        int SL = Integer.parseInt(sc.nextLine());

        for(int i = 0; i<SL; i++){
            GiaoVien gv = new GiaoVien();
            System.out.println("\n→ Nhập thông tin giáo viên thứ " + (i + 1) + ":");
            themGV(gv);
        }
        System.out.println("\n Đã thêm " + SL+ " giáo viên vào danh sách!");
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
        boolean removed = danhSach.removeIf(gv -> gv.getMaGV().equalsIgnoreCase(maGV));
        if (removed)
            System.out.println("→ Đã xoá giáo viên có mã: " + maGV);
        else
            System.out.println("❌ Không tìm thấy giáo viên có mã: " + maGV);
    }

    public void suaGV(String maGV) {
        int chon = -1;
        for (GiaoVien gv : danhSach) {
            while (gv.getMaGV().equalsIgnoreCase(maGV)) {
                do{
                System.out.println("\n===== Sửa thông tin giáo viên =====");
                System.out.println("1. Sửa họ tên");
                System.out.println("2. Sửa năm sinh");
                System.out.println("3. Sửa môn dạy");
                System.out.println("4. Sửa chức vụ ");
                System.out.println("0.Thoat");
                System.out.print("→ Chọn mục muốn sửa: ");
                chon = sc.nextInt();
                sc.nextLine(); // bỏ ký tự Enter

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
                        gv.setMonDay(tenMon);
                        break;
                    case 4:
                        System.out.print("Nhập chức vụ mới (bộ môn hay chủ nhiệm): ");
                        gv.setChucVu(sc.nextLine());
                        break;
                    case 0:
                        System.out.print("Thoát sửa giáo viên!");
                        break;
                    default:
                        System.out.println("❌ Lựa chọn không hợp lệ!");
                }
                System.out.println("✅ Đã cập nhật thông tin cho giáo viên!");
                }while(chon != 0);
                return;
            }
        }
        System.out.println("❌ Không tìm thấy giáo viên có mã " + maGV);
    }

    public void hienThiTatCa() {
        if (danhSach.isEmpty()) {
            System.out.println("❌ Danh sách giáo viên trống!");
            return;
        }
        for (GiaoVien gv : danhSach)
            gv.hienThi();
    }

    // ===== TRIỂN KHAI interface ThaoTacFile =====
    @Override
    public void docTuFile(String tenFile) {
    try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            String[] arr = line.split(",");
            if (arr.length == 6) {
                String maGV = arr[0];
                String hoTen = arr[1];
                String gioiTinh = arr[2];
                int namSinh = Integer.parseInt(arr[3]);
                String tenMon = arr[4];
                String chucVu = arr[5];

                // Tạo giáo viên
                GiaoVien gv = new GiaoVien(maGV, hoTen, gioiTinh, namSinh, tenMon, chucVu);
                danhSach.add(gv);
            }
        }
    } catch (IOException e) {
        System.out.println("Lỗi đọc file: " + e.getMessage());
    }
}


    @Override
    public void ghiRaFile(String duongDan) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(duongDan))) {
            for (GiaoVien gv : danhSach) {
                bw.write(String.join(",",
                        gv.getMaGV(),
                        gv.gethoTen(),
                        gv.getgioiTinh(),
                        String.valueOf(gv.getnamSinh()),
                        gv.getMonDay(),
                        gv.getChucVu()));
                bw.newLine();
            }
            System.out.println("✅ Ghi file GiaoVien.txt thành công!");
        } catch (IOException e) {
            System.out.println("❌ Lỗi ghi file: " + e.getMessage());
        }
    }
}
