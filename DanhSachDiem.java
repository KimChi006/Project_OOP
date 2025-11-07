import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

class DanhSachDiem implements IThaoTacFile {
    private ArrayList<Diem> dsd = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public DanhSachDiem(Scanner sc) {
        this.sc = sc;
    }

    public double tinhDiemTrungBinh() {
        double tong = 0;
        int dem = 0;
        System.out.print("Nhập mã học sinh cần tính điểm: ");
        String maHS = sc.nextLine();
        System.out.print("Nhập mã môn học: ");
        String maMon = sc.nextLine();

        for (Diem d : dsd) {
            if (d.getmaHS().equals(maHS) && d.getmaMon().equals(maMon)) {
                tong += d.getDiemMieng() + d.getDiem15P() + d.getDiem1T() + d.getDiemThi();
                dem++;
            }
        }
        if (dem == 0) {
        System.out.println("❌ Không tìm thấy điểm cho học sinh và môn học đã nhập.");
        return 0;
    }

       double diemTB = tong / (dem * 4);
       System.out.printf("✅ Điểm trung bình của học sinh %s môn %s là: %.2f\n", maHS, maMon, diemTB);
       return diemTB;
       }

     public void suaDiem() {
       System.out.print("Nhập mã học sinh cần sửa điểm: ");
       String maHS = sc.nextLine().trim();

       System.out.print("Nhập mã môn học: ");
       String maMon = sc.nextLine().trim();

       while (true) {
          System.out.println("\nChọn loại điểm cần sửa:");
          System.out.println("1. Điểm miệng");
          System.out.println("2. Điểm 15 phút");
          System.out.println("3. Điểm 1 tiết");
          System.out.println("4. Điểm thi");
          System.out.println("0. Thoát sửa điểm");
          System.out.print("Lựa chọn: ");

        int chon;
          try {
              chon = Integer.parseInt(sc.nextLine());
          } catch (NumberFormatException e) {
              System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số từ 0 đến 4.");
              continue;
          }

          if (chon == 0) {
            System.out.println("Đã thoát khỏi chức năng sửa điểm.");
            break;
        }

          if (chon < 1 || chon > 4) {
            System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            continue;
        }

          double diemMoi;
          while (true) {
            System.out.print("Nhập điểm mới (0 - 10): ");
              try {
                  diemMoi = Double.parseDouble(sc.nextLine());
                   if (diemMoi >= 0 && diemMoi <= 10) break;
                  else System.out.println("Điểm phải nằm trong khoảng từ 0 đến 10.");
             } catch (NumberFormatException e) {
                  System.out.println("Định dạng không hợp lệ. Vui lòng nhập số.");
              }
          }
          boolean daSua = false;
          for (Diem d : dsd) {
              if (d.getmaHS().equals(maHS) && d.getmaMon().equals(maMon)) {
                switch (chon) {
                    case 1:
                        d.setDiemMieng(diemMoi);
                        daSua = true;
                        break;
                    case 2:
                        d.setDiem15P(diemMoi);
                        daSua = true;
                        break;
                    case 3:
                        d.setDiem1T(diemMoi);
                        daSua = true;
                        break;
                    case 4:
                        d.setDiemThi(diemMoi);
                        daSua = true;
                        break;
                    case 0:
                        System.out.println("Thoát sửa điểm");
                        return;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!.");
                }
            }
        }

        if (daSua) {
            System.out.println("Đã sửa điểm thành công.");
        } else {
            System.out.println("Không tìm thấy điểm cần sửa.");
        }
   
    }
  }

    public void hienThiTatCa() {
        for (Diem d : dsd) {
            d.xuat();
        }
    }

    @Override
    public void docTuFile(String tenFile) {
        dsd.clear();
        try {
            BufferedReader input = new BufferedReader(new FileReader(tenFile));
            String line;
            while ((line = input.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] arr = line.split(",");
                if (arr.length == 6) {
                    String maHS = arr[0];
                    String maMon = arr[1];
                    double DiemMieng = Double.parseDouble(arr[2]);
                    double Diem15P = Double.parseDouble(arr[3]);
                    double Diem1T = Double.parseDouble(arr[4]);
                    double DiemThi = Double.parseDouble(arr[5]);

                    dsd.add(new Diem(maHS, maMon, DiemMieng, Diem15P, Diem1T, DiemThi));
                }
            }
            input.close();
            System.out.println("✅ Đọc file Diem.txt thành công, có " + dsd.size() + " bản ghi.");
        } catch (Exception ex) {
            System.out.println("Lỗi khi đọc file Diem.txt: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    public void ghiRaFile(String tenFile) {
        try {
            FileWriter fw = new FileWriter(tenFile, false);
            for (Diem d : dsd) {
                fw.write(d.getmaHS() + "," + d.getmaMon() + "," +
                        d.getDiemMieng() + "," + d.getDiem15P() + "," +
                        d.getDiem1T() + "," + d.getDiemThi() + "\n");
            }
            fw.close();
            System.out.println("Ghi file thành công: Diem.txt!");
        } catch (Exception e) {
            System.out.println("Lỗi khi ghi file Diem.txt: " + e.getMessage());
            e.printStackTrace();
        }
    }
}



