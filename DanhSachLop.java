import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachLop{
    ArrayList<Lop> dsLop = new ArrayList<>();

    // --- Đọc danh sách lớp từ file ---
    public void docTuFile(String tenFile) {
        try {
            File file = new File(tenFile);
            if (!file.exists()) {
                System.out.println("⚠ File không tồn tại: " + tenFile);
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            dsLop.clear(); // xóa danh sách cũ trước khi đọc

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Lop lop = new Lop(parts[0].trim(), parts[1].trim(), parts[2].trim());
                    dsLop.add(lop);
                } else {
                    System.out.println("⚠ Dòng không hợp lệ: " + line);
                }
            }
            br.close();
            System.out.println("✅ Đọc file thành công! (" + dsLop.size() + " lớp)");

        } catch (IOException e) {
            System.out.println("❌ Lỗi khi đọc file: " + e.getMessage());
        }
    }

    // --- Ghi danh sách lớp ra file ---
    public void ghiRaFile(String tenFile) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile));
            for (Lop lop : dsLop) {
                bw.write(lop.maLop + "," + lop.tenLop + "," + lop.giaoVienCN);
                bw.newLine();
            }
            bw.close();
            System.out.println("✅ Ghi file thành công!");
        } catch (IOException e) {
            System.out.println("❌ Lỗi ghi file: " + e.getMessage());
        }
    }

    // --- Hiển thị danh sách lớp ---
    public void hienThi() {
        if (dsLop.isEmpty()) {
            System.out.println("Danh sách lớp trống!");
            return;
        }
        System.out.println("\n=== DANH SÁCH LỚP HỌC ===");
        int i = 1;
        for (Lop lop : dsLop) {
            System.out.println( i + ":"+lop);
            lop.xuat();
            i++;
        }
    }

    // --- Thêm lớp ---
    public boolean tonTaiMa(String ma) {
        for (Lop l : dsLop) {
            if (l.maLop.equalsIgnoreCase(ma)) {
                return true;
            }
        }
        return false;
    }

    public void themLop() {
        Scanner sc = new Scanner(System.in);
        Lop lop = new Lop();
        System.out.println("\n--- Nhập thông tin lớp mới ---");

        // Nhập và kiểm tra trùng mã trước khi thêm
        do {
            System.out.print("Nhập mã lớp: ");
            String ma = sc.nextLine();
            if (!tonTaiMa(ma)) {
                lop.maLop = ma;
                break;
            } else {
                System.out.println("⚠ Mã lớp đã tồn tại. Nhập lại!");
            }
        } while (true);

        // Nhập các thông tin còn lại
        System.out.print("Nhập tên lớp: ");
        lop.tenLop = sc.nextLine();

        System.out.print("Nhập giáo viên chủ nhiệm: ");
        lop.giaoVienCN = sc.nextLine();

        // Thêm vào danh sách
        dsLop.add(lop);
        System.out.println("✅ Thêm lớp thành công!");
    }

    // --- Xóa lớp theo mã ---
    public void xoaLop() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã lớp cần xóa: ");
        String ma = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < dsLop.size(); i++) {
            if (dsLop.get(i).maLop.equalsIgnoreCase(ma)) {
                dsLop.remove(i);
                found = true;
                System.out.println("✅ Đã xóa lớp có mã: " + ma);
                break;
            }
        }
        if (!found) System.out.println("⚠ Không tìm thấy lớp có mã: " + ma);
    }

    // --- Sửa lớp theo mã ---
    public void suaLop() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã lớp cần sửa: ");
        String ma = sc.nextLine();
        boolean found = false;

        for (Lop lop : dsLop) {
            if (lop.maLop.equalsIgnoreCase(ma)) {
                System.out.println("→ Nhập thông tin mới cho lớp " + ma);
                //lop.nhap();
                found = true;

                //---menu sửa lớp---
                int chon;
                do {
                    System.out.println("\n---Menu sửa lớp---" + ma + "---");
                    System.out.println("1.Sửa mã lớp");
                    System.out.println("2.Sửa tên lớp");
                    System.out.println("3.Sửa giáo viên chủ nhiệm");
                    System.out.println("0.Lưu và thoát");
                    System.out.println("Chọn thành phần cần sửa(0-3):");

                    chon = Integer.parseInt(sc.nextLine());
                    switch (chon) {
                        case 1:
                            System.out.println("Nhập mã lớp mới");
                            String maLop = sc.nextLine();
                            lop.maLop = maLop;
                            System.out.println("=>Sửa mã lớp thành công");
                            break;

                        case 2:
                            System.out.println("Nhập tên lớp mới");
                            String tenLop = sc.nextLine();
                            lop.tenLop = tenLop;
                            System.out.println("=>Sửa tên lớp thành công");
                            break;

                        case 3:
                            System.out.println("Nhập giáo viên chủ nhiệm mới");
                            String giaoVienCN = sc.nextLine();
                            lop.giaoVienCN = giaoVienCN;
                            System.out.println("=>Sửa giáo viên chủ nhiệm thành công");
                            break;

                        case 0:
                            System.out.println("Đã lưu các thay đổi.");
                            break;

                        default:
                            System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    }
                }

                while (chon != 0);


                System.out.println("✅ Sửa lớp thành công!");
                break;
            }
        }

                if (!found) System.out.println("⚠ Không tìm thấy lớp có mã: " + ma);

    }

    // --- Menu điều khiển ---
    public void menu() {
        Scanner sc = new Scanner(System.in);
        int chon;
        do {
            System.out.println("\n========== QUẢN LÝ LỚP HỌC ==========");
            System.out.println("1. Đọc danh sách lớp từ file");
            System.out.println("2. Ghi danh sách lớp ra file");
            System.out.println("3. Hiển thị danh sách lớp");
            System.out.println("4. Thêm lớp");
            System.out.println("5. Xóa lớp");
            System.out.println("6. Sửa lớp");
            System.out.println("0. Thoát");
            System.out.print("→ Chọn: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 -> {
                    System.out.print("Nhập tên file: ");
                    String f = sc.nextLine();
                    docTuFile(f);
                }
                case 2 -> {
                    System.out.print("Nhập tên file: ");
                    String f = sc.nextLine();
                    ghiRaFile(f);
                }
                case 3 -> hienThi();
                case 4 -> themLop();
                case 5 -> xoaLop();
                case 6 -> suaLop();
                case 0 -> System.out.println("Thoát chương trình...");
                default -> System.out.println("⚠ Lựa chọn không hợp lệ!");
            }
        } while (chon != 0);
    }

    // --- Main ---
    public static void main(String[] args) {
        DanhSachLop ds = new DanhSachLop();
        ds.menu();
    }
}


