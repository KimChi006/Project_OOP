import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DanhSachHocSinh dshs = new DanhSachHocSinh(sc);
        DanhSachGiaoVien dsgv = new DanhSachGiaoVien(sc);
        DanhSachMonHoc dsmh = new DanhSachMonHoc(sc);
        DanhSachDiem dsd = new DanhSachDiem(sc);
        DanhSachLop dsl = new DanhSachLop(sc);

        dshs.docTuFile("D:\\Project_OOP\\HocSinh.txt");
		dsgv.docTuFile("D:\\Project_OOP\\GiaoVien.txt");
		dsmh.docTuFile("D:\\Project_OOP\\MonHoc.txt");
		dsd.docTuFile("D:\\Project_OOP\\Diem.txt");
		dsl.docTuFile("D:\\Project_OOP\\LopHoc.txt");


        int chon = -1;
        do {
            System.out.println("\n=============================");
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ HỌC SINH THPT");
            System.out.println("=============================");
            System.out.println("1. Quản lý học sinh");
            System.out.println("2. Quản lý giáo viên");
            System.out.println("3. Quản lý điểm");
            System.out.println("4. Quản lý môn học");
            System.out.println("5. Quản lý lớp");
            System.out.println("0. Thoát");
            System.out.print("Vui lòng nhập lựa chọn: ");

            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    int chonhs = -1;
                    do {
                        System.out.println("\n----- MENU QUẢN LÝ HỌC SINH -----");
                        System.out.println("1. Thêm học sinh");
                        System.out.println("2. Xóa học sinh");
                        System.out.println("3. Sửa thông tin học sinh");
                        System.out.println("4. Tìm kiếm học sinh");
                        System.out.println("5. Hiển thị tất cả");
                        System.out.println("6. Lưu thông tin học sinh vào file");
                        System.out.println("0. Thoát");
                        System.out.print("Vui lòng nhập lựa chọn: ");

                        chonhs = sc.nextInt();
                        sc.nextLine();

                        switch (chonhs) {
                            case 1:
                                System.out.println("");
                                dshs.themHocSinh();
                                break;
                            case 2:
                                System.out.println("");
                                dshs.xoaHocSinh();
                                break;
                            case 3:
                                System.out.println("");
                                dshs.suaHocSinh();
                                break;
                            case 4:
                                System.out.println("");
                                System.out.print("Nhập mã học sinh cần tìm: ");
                                String mahs = sc.nextLine();
                                HocSinh hs = dshs.timHocSinh(mahs);
								if (hs != null)
        							hs.hienThi();
    							else
       								System.out.println("❌ Không tìm thấy học sinh có mã: " + mahs);
                                break;
                            case 5:
                                System.out.println("");
                                dshs.hienThiDanhSach();
                                break;
                            case 6:
                                System.out.println("");
                                dshs.ghiRaFile("D:\\Project_OOP\\HocSinh.txt");
                                break;
                            case 0:
                                System.out.println("");
                                System.out.println("Thoát quản lý học sinh.");
                                break;
                            default:
                                System.out.println("");
                                System.out.println("❌ Lựa chọn không hợp lệ!");
                        }
                    } while (chonhs != 0);
                    break;

                case 2:
                    int chongv = -1;
                    do {
                        System.out.println("\n----- MENU QUẢN LÝ GIÁO VIÊN -----");
                        System.out.println("1. Thêm giáo viên");
                        System.out.println("2. Xóa giáo viên");
                        System.out.println("3. Sửa thông tin giáo viên");
                        System.out.println("4. Hiển thị tất cả");
                        System.out.println("5. Lưu thông tin giáo viên vào file");
                        System.out.println("0. Thoát");
                        System.out.print("Vui lòng nhập lựa chọn: ");

                        chongv = sc.nextInt();
                        sc.nextLine();

                        switch (chongv) {
                            case 1:
                                System.out.println("");
                                dsgv.themNHieuGiaoVien();
                                break;
                            case 2:
                                System.out.println("");
                                while(true){
                                System.out.print("Nhập mã giáo viên cần xóa (nhập 0 để thoát): ");
                                String magv = sc.nextLine();
                                if(magv.equals("0")){
                                    System.out.println("→ Đã hủy thao tác xóa giáo viên.");
                                    break;
                                }
                                dsgv.xoaGV(magv);
                                }
                                break;
                            case 3:
                                System.out.println("");
                                dsgv.suaGV();
                                break;
                            case 4:
                                System.out.println("");
                                dsgv.hienThiTatCa();
                                break;
                            case 5:
                                System.out.println("");
                                dsgv.ghiRaFile("D:\\Project_OOP\\GiaoVien.txt");
                                break;
                            case 0:
                                System.out.println("");
                                System.out.println("Thoát quản lý giáo viên.");
                                break;
                            default:
                                System.out.println("");
                                System.out.println("❌ Lựa chọn không hợp lệ!");
                        }
                    } while (chongv != 0);
                    break;

                case 3:
                    int chond = -1;
                    do {
                        System.out.println("\n----- MENU QUẢN LÝ ĐIỂM -----");
                        System.out.println("1. Tính điểm trung bình");
                        System.out.println("2. Sửa điểm của học sinh");
                        System.out.println("3. Hiển thị tất cả");
                        System.out.println("4. Lưu thông tin điểm vào file");
                        System.out.println("0. Thoát");
                        System.out.print("Vui lòng nhập lựa chọn: ");

                        chond = sc.nextInt();
                        sc.nextLine();

                        switch (chond) {
                            case 1:
                                System.out.println("");
                                dsd.tinhDiemTrungBinh();
                                break;
                            case 2:
                                System.out.println("");
                                dsd.suaDiem();
                                break;
                            case 3:
                                System.out.println("");
                                dsd.hienThiTatCa();
                                break;
                            case 4:
                                System.out.println("");
                                dsd.ghiRaFile("D:\\Project_OOP\\Diem.txt");
                                break;
                            case 0:
                                System.out.println("");
                                System.out.println("Thoát quản lý điểm.");
                                break;
                            default:
                                System.out.println("");
                                System.out.println("❌ Lựa chọn không hợp lệ!");
                        }
                    } while (chond != 0);
                    break;

                case 4:
                    int chonmh = -1;
                    do {
                        System.out.println("\n----- MENU QUẢN LÝ MÔN HỌC -----");
                        System.out.println("1. Thêm môn học");
                        System.out.println("2. Xóa môn học");
                        System.out.println("3. Sửa môn học");
                        System.out.println("4. Hiển thị tất cả");
                        System.out.println("5. Lưu thông tin vào file");
                        System.out.println("0. Thoát");
                        System.out.print("Vui lòng nhập lựa chọn: ");

                        chonmh = sc.nextInt();
                        sc.nextLine();

                        MonHoc mh = new MonHoc();

                        switch (chonmh) {
                            case 1:
                                System.out.println("");
                                mh.nhap();
                                dsmh.themMon(mh);
                                break;
                            case 2:
                                System.out.println("");
                                System.out.print("Nhập mã môn học cần xóa: ");
                                String maMh = sc.nextLine();
                                dsmh.xoaMon(maMh);
                                break;
                            case 3:
                                System.out.println("");
                                dsmh.suaMonHoc();
                                break;
                            case 4:
                                System.out.println("");
                                dsmh.hienThiTatCa();
                                break;
                            case 5:
                                System.out.println("");
                                dsmh.ghiRaFile("D:\\Project_OOP\\Monhoc.txt");
                                break;
                            case 0:
                                System.out.println("");
                                System.out.println("Thoát quản lý môn học.");
                                break;
                            default:
                                System.out.println("");
                                System.out.println("❌ Lựa chọn không hợp lệ!");
                        }
                    } while (chonmh != 0);
                    break;

                case 5:
                    dsl.menu();
                    break;
                case 0:
                    System.out.println("");
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("");
                    System.out.println("❌ Lựa chọn không hợp lệ!");
            }
        } while (chon != 0);
    }
}
