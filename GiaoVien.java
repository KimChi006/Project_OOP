import java.util.Scanner;

class GiaoVien extends Nguoi {
    private Scanner sc = new Scanner(System.in);
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
        System.out.println("Họ tên của giáo viên là: " + hoTen);
        System.out.println("Giới tính của giáo viên là: " + gioiTinh);
        System.out.println("Năm sinh của giáo viên là: " + namSinh);
        System.out.printf("Môn dạy: %-15s Chức vụ: %-10s\n",
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
