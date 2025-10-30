import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachLop{
    ArrayList<Lop> dsLop = new ArrayList<>();
    private Scanner sc;
    public DanhSachLop(Scanner sc) {
        this.sc = sc;
    }

    // --- Đọc danh sách lớp từ file ---
    public void docTuFile(String tenFile) {
        try {
            File file = new File(tenFile);
            if (!file.exists()) {
                System.out.println("File khong ton tai " + tenFile);
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
                    System.out.println("Dong khong hop le " + line);
                }
            }
            br.close();
            System.out.println("Doc file LopHoc.txt thanh cong! (" + dsLop.size() + " lớp)");

        } catch (IOException e) {
            System.out.println("Loi khi doc file LopHoc.txt" + e.getMessage());
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
            System.out.println("Ghi file thanh cong");
        } catch (IOException e) {
            System.out.println("Loi ghi file " + e.getMessage());
        }
    }

    // --- Hiển thị danh sách lớp ---
    public void hienThi() {
        if (dsLop.isEmpty()) {
            System.out.println("Danh sach lop trong!");
            return;
        }
        System.out.println("\n=== DANH SACH LOP HOC ===");
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
        Lop lop = new Lop();
        System.out.println("\n--- Nhap thong tin lop moi ---");

        // Nhập và kiểm tra trùng mã trước khi thêm
        do {
            System.out.print("Nhap ma lop: ");
            String ma = sc.nextLine();
            if (!tonTaiMa(ma)) {
                lop.maLop = ma;
                break;
            } else {
                System.out.println("Ma lop khong ton tai. Nhap lai!");
            }
        } while (true);

        // Nhập các thông tin còn lại
        System.out.print("Nhap ten lop: ");
        lop.tenLop = sc.nextLine();

        System.out.print("Nhap giao vien chu nhiem: ");
        lop.giaoVienCN = sc.nextLine();

        // Thêm vào danh sách
        dsLop.add(lop);
        System.out.println("Them lop thanh cong!");
    }

    // --- Xóa lớp theo mã ---
    public void xoaLop() {
        System.out.print("Nhap ma lop can xoa: ");
        String ma = sc.nextLine();
        boolean found = false;

        for (int i = 0; i < dsLop.size(); i++) {
            if (dsLop.get(i).maLop.equalsIgnoreCase(ma)) {
                dsLop.remove(i);
                found = true;
                System.out.println("Da xoa lop co ma: " + ma);
                break;
            }
        }
        if (!found) System.out.println("Khong tim thay lop co ma: " + ma);
    }

    // --- Sửa lớp theo mã ---
    public void suaLop() {
        System.out.print("Nhap ma lop can sua: ");
        String ma = sc.nextLine();
        boolean found = false;

        for (Lop lop : dsLop) {
            if (lop.maLop.equalsIgnoreCase(ma)) {
                System.out.println("Nhap thong tin cho lop moi " + ma);
                //lop.nhap();
                found = true;

                //---menu sửa lớp---
                int chon;
                do {
                    System.out.println("\n---Menu sua lop---" + ma + "---");
                    System.out.println("1.Sua ma lop");
                    System.out.println("2.Sua ten lop");
                    System.out.println("3.Sua giao vien chu nhiem");
                    System.out.println("0.Luu va thoat");
                    System.out.println("Chon thanh phan can sua (0-3):");

                    chon = Integer.parseInt(sc.nextLine());
                    switch (chon) {
                        case 1:
                            System.out.println("Nhap ma lop moi");
                            String maLop = sc.nextLine();
                            lop.maLop = maLop;
                            System.out.println("=>Sua ma lop thanh cong");
                            break;

                        case 2:
                            System.out.println("Nhap ten lop moi");
                            String tenLop = sc.nextLine();
                            lop.tenLop = tenLop;
                            System.out.println("=>Sua ten lop thanh cong");
                            break;

                        case 3:
                            System.out.println("Nhap giao vien chu nhiem moi");
                            String giaoVienCN = sc.nextLine();
                            lop.giaoVienCN = giaoVienCN;
                            System.out.println("=>Sua giao vien chu nhiem thanh cong");
                            break;

                        case 0:
                            System.out.println("Da luu cac thay doi.");
                            break;

                        default:
                            System.out.println("Lua chon khong hop le. Vui long nhap lai");
                    }
                }

                while (chon != 0);


                System.out.println("Sua lop thanh cong!");
                break;
            }
        }

                if (!found) System.out.println("Khong tim thay lop co ma: " + ma);

    }

    // --- Menu điều khiển ---
    public void menu() {
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
                    ghiRaFile("Data/LuuLopHoc.txt");
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
}



