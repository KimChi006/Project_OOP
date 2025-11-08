import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachLop {
    ArrayList<Lop> dsLop = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    //private String tenFile="LopHoc.txt";

    public DanhSachLop(Scanner sc) {
        this.sc = sc;
    }

    // --- Đọc danh sách lớp từ file ---
    public void docTuFile() {
        String tenFile = "LopHoc.txt"; // Tự động dùng file LopHoc.txt

        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            dsLop.clear(); // Xóa danh sách cũ
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue; // Bỏ qua dòng trống

                String[] parts = line.split(",");
                if (parts.length == 3) {
                    Lop lop = new Lop(parts[0].trim(), parts[1].trim(), parts[2].trim());
                    dsLop.add(lop);
                } else {
                    System.out.println("⚠️ Dòng không hợp lệ: " + line);
                }
            }

            if (dsLop.isEmpty()) {
                System.out.println("⚠️ File LopHoc.txt trống hoặc không có dữ liệu hợp lệ.");
            } else {
                System.out.println("✅ Đọc file LopHoc.txt thành công! (" + dsLop.size() + " lớp)");
            }

        } catch (FileNotFoundException e) {
            System.out.println("❌ Không tìm thấy file LopHoc.txt. Vui lòng kiểm tra đường dẫn.");
        } catch (IOException e) {
            System.out.println("❌ Lỗi khi đọc file LopHoc.txt: " + e.getMessage());
        }
    }

    // --- Ghi danh sách lớp ra file ---
    public void ghiRaFile() {
        if (dsLop.isEmpty()) {
            System.out.println("⚠️ Danh sách lớp trống, không có gì để ghi!");
            return;
        }

        String tenFile = "LopHoc.txt"; // chỉ tên file, không có đường dẫn

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile))) {
            for (Lop lop : dsLop) {
                bw.write(lop.maLop + "," + lop.tenLop + "," + lop.giaoVienCN);
                bw.newLine();
            }
            System.out.println("✅ Ghi file thành công: " + tenFile);
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
            System.out.println(i + ".");
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
        Lop lop = new Lop();

        System.out.println("\n--- Nhập thông tin lớp mới ---");

        // Nhập và kiểm tra trùng mã trước khi thêm
        while (true) {
            System.out.print("Nhập mã lớp (nhập 0 để thoát): ");
            String maLop = sc.nextLine().trim();

            if (maLop.equals("0")) {
                System.out.println("Đã hủy thêm lớp mới.");
                return; // Thoát khỏi hàm
            }

            if (!tonTaiMa(maLop)) {
                lop.maLop = maLop;
                break; // Thoát khỏi vòng lặp khi mã hợp lệ
            } else {
                System.out.println("Mã lớp đã tồn tại!");
                System.out.print("Bạn có muốn sửa lớp này không? (y/n): ");
                String chon = sc.nextLine().trim();

                if (chon.equalsIgnoreCase("y")) {
                    suaLop(); // Gọi hàm sửa lớp (bạn cần định nghĩa sẵn)
                    return; // Kết thúc hàm thêm
                } else {
                    System.out.println("Vui lòng nhập lại mã khác!");
                }
            }
        }

        // Nhập các thông tin còn lại
        System.out.print("Nhập tên lớp: ");
        lop.tenLop = sc.nextLine();

        System.out.print("Nhập giáo viên chủ nhiệm: ");
        lop.giaoVienCN = sc.nextLine();

        // Thêm vào danh sách
        dsLop.add(lop);
        System.out.println("✅ Thêm lớp thành công!");

        // Hỏi người dùng có muốn thêm lớp khác không
        System.out.print("\nNhập mã lớp (0 = Thoát): ");
        String tiepTuc = sc.nextLine().trim();

        if (tiepTuc.equals("0")) {
            System.out.println("Đã thoát khỏi chức năng thêm lớp.");
            return; // Dừng thêm lớp
        }
        // Nếu nhập 1 hoặc bất kỳ phím nào khác → tiếp tục vòng while bên ngoài
        System.out.println();
    }


    // --- Xóa lớp theo mã ---
    public void xoaLop() {
        while (true) {
            System.out.print("Nhập mã lớp cần xóa (hoặc nhập 0 để thoát): ");
            String ma = sc.nextLine().trim();

            // Nếu người dùng muốn thoát
            if (ma.equals("0")) {
                System.out.println("🔙 Đã thoát khỏi chức năng xóa lớp.");
                break;
            }

            boolean found = false;

            // Tìm lớp có mã phù hợp
            for (int i = 0; i < dsLop.size(); i++) {
                if (dsLop.get(i).maLop.equalsIgnoreCase(ma)) {
                    found = true;

                    // Xác nhận xóa
                    System.out.print("Bạn có chắc muốn xóa lớp " + ma + " không? (có/không): ");
                    String confirm = sc.nextLine().trim();

                    if (confirm.equalsIgnoreCase("có")) {
                        dsLop.remove(i);
                        System.out.println("✅ Đã xóa lớp có mã: " + ma);
                        ghiRaFile(); // Tự động lưu thay đổi vào file
                    } else {
                        System.out.println("❎ Hủy thao tác xóa.");
                    }
                    break;
                }
            }

            // Nếu không tìm thấy, yêu cầu nhập lại
            if (!found) {
                System.out.println("⚠️ Không tìm thấy lớp có mã: " + ma + ". Vui lòng nhập lại!");
            }
        }

    }

    // --- Sửa lớp theo mã ---
    public void suaLop() {
        System.out.print("Nhập mã lớp cần sửa: ");
        String ma = sc.nextLine();

        boolean found = false;

        for (Lop lop : dsLop) {
            if (lop.maLop.equalsIgnoreCase(ma)) {
                System.out.println("Nhập thông tin mới cho lớp " + ma);
                found = true;

                // --- Menu sửa lớp ---
                int chon;
                do {
                    System.out.println("\n--- MENU SỬA LỚP --- " + ma + " ---");
                    System.out.println("1. Sửa mã lớp");
                    System.out.println("2. Sửa tên lớp");
                    System.out.println("3. Sửa giáo viên chủ nhiệm");
                    System.out.println("0. Lưu và thoát");
                    System.out.print("→ Chọn thành phần cần sửa (0-3): ");

                    chon = Integer.parseInt(sc.nextLine());
                    switch (chon) {
                        case 1:
                            System.out.print("Nhập mã lớp mới: ");
                            String maLop = sc.nextLine();
                            lop.maLop = maLop;
                            System.out.println("=> Sửa mã lớp thành công!");
                            break;

                        case 2:
                            System.out.print("Nhập tên lớp mới: ");
                            String tenLop = sc.nextLine();
                            lop.tenLop = tenLop;
                            System.out.println("=> Sửa tên lớp thành công!");
                            break;

                        case 3:
                            System.out.print("Nhập giáo viên chủ nhiệm mới: ");
                            String giaoVienCN = sc.nextLine();
                            lop.giaoVienCN = giaoVienCN;
                            System.out.println("=> Sửa giáo viên chủ nhiệm thành công!");
                            break;

                        case 0:
                            System.out.println("Đã lưu các thay đổi!");
                            break;

                        default:
                            System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
                    }
                } while (chon != 0);

                System.out.println("Sửa lớp thành công!");
                break;
            }
        }

        if (!found) System.out.println("Không tìm thấy lớp có mã: " + ma);
    }

    // --- Menu điều khiển ---
    public void menu() {
        int chon;
        do {
            System.out.println("\n========== QUẢN LÝ LỚP HỌC ==========");
            System.out.println("1. Ghi danh sách lớp ra file");
            System.out.println("2. Hiển thị danh sách lớp");
            System.out.println("3. Thêm lớp");
            System.out.println("4. Xóa lớp");
            System.out.println("5. Sửa lớp");
            System.out.println("0. Thoát");
            System.out.print("→ Chọn: ");
            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1 -> ghiRaFile();
                case 2 -> hienThi();
                case 3 -> themLop();
                case 4 -> xoaLop();
                case 5 -> suaLop();
                case 0 -> System.out.println("Thoát chương trình...");
                default -> System.out.println("⚠ Lựa chọn không hợp lệ!");
            }
        } while (chon != 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DanhSachLop ds= new DanhSachLop(sc);
        ds.docTuFile();
        ds.ghiRaFile();
        ds.menu();
    }
}
