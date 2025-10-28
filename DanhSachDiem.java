import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import model.HocSinh;
import model.MonHoc;

public class DanhSachDiem implements IThaoTacFile {
    private ArrayList<Diem> dsd = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public double tinhDiemTrungBinh() {
        double tong = 0;
        int dem = 0;
        System.out.print("Nhập mã học sinh cần tính điểm: ");
        String maHS = sc.nextLine();
        System.out.print("Nhập mã môn học: ");
        String maMon = sc.nextLine();

        for (Diem d : dsd) {
            if (d.getmaHS().equals(maHS) && d.getmaMon().equals(maMon)) {
                tong += d.getgiaTri();
                dem++;
            }
        }

        return dem == 0 ? 0 : tong / dem;
    }

    public void suaDiem() {
        System.out.print("Nhập mã học sinh cần sửa điểm: ");
        String maHS = sc.nextLine();

        System.out.print("Nhập mã môn học: ");
        String maMon = sc.nextLine();

        System.out.println("Chọn loại điểm cần sửa:");
        System.out.println("1. Điểm miệng");
        System.out.println("2. Điểm 15 phút");
        System.out.println("3. Điểm 1 tiết");
        System.out.println("4. Điểm thi");
        System.out.print("Lựa chọn: ");
        int chon = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập điểm mới: ");
        double diemMoi = Double.parseDouble(sc.nextLine());

        boolean daSua = false;
        for (Diem d : dsd) {
            if (d.getmaHS().equals(maHS) && d.getmaMon().equals(maMon)) {
                switch (chon) {
                    case 1:
                        if (d instanceof DiemMieng) {
                            d.setgiaTri(diemMoi);
                            daSua = true;
                        }
                        break;
                    case 2:
                        if (d instanceof Diem15Phut) {
                            d.setgiaTri(diemMoi);
                            daSua = true;
                        }
                        break;
                    case 3:
                        if (d instanceof Diem1Tiet) {
                            d.setgiaTri(diemMoi);
                            daSua = true;
                        }
                        break;
                    case 4:
                        if (d instanceof DiemThi) {
                            d.setgiaTri(diemMoi);
                            daSua = true;
                        }
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                }
            }
        }

        if (daSua) {
            System.out.println("Đã sửa điểm thành công.");
        } else {
            System.out.println("Không tìm thấy điểm cần sửa.");
        }
    }

    public void hienThiTatCa() {
        for (Diem d : dsd) {
            d.xuat();
        }
    }

    @Override
    public void doctuFile(String tenFile) {
        try {
            BufferedReader input = new BufferedReader(new FileReader(tenFile));
            String line;
            while ((line = input.readLine()) != null) {
                String[] arr = line.split(",");
                if (arr.length == 6) {
                    String maHS = arr[0];
                    String maMon = arr[1];
                    double diemMieng = Double.parseDouble(arr[2]);
                    double diem15Phut = Double.parseDouble(arr[3]);
                    double diem1Tiet = Double.parseDouble(arr[4]);
                    double diemThi = Double.parseDouble(arr[5]);

                    
                    dsd.add(new Diem(maHS, maMon, diemMieng, diem15Phut, diem1Tiet, diemThi));
                }
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void ghiraFile(String tenFile) {
        try {
            FileWriter fw = new FileWriter(tenFile, false);
            for (Diem d : dsd) {
                fw.write(d.getmaHS() + "," + d.getmaMon() + "," +
                        d.getDiemMieng() + "," + d.getDiem15Phut() + "," +
                        d.getDiem1Tiet() + "," + d.getDiemThi() + "\n");
            }
            fw.close();
            System.out.println("Ghi file thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DanhSachDiem dsd = new DanhSachDiem();
        dsd.doctuFile("Diem.txt");

        System.out.println("Điểm trung bình: " + dsd.tinhDiemTrungBinh());
        dsd.suaDiem();
        dsd.hienThiTatCa();
        dsd.ghiraFile("Diem.txt");
    }
}
