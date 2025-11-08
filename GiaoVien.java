import java.util.Scanner;

class GiaoVien extends Nguoi {
    private Scanner sc = new Scanner(System.in);
    static int magvtieptheo;
    private String maGV;
    private String monDay;
    private String chucVu;

    public GiaoVien() {
        super();
    }

    public GiaoVien(String maGV, String hoTen, String gioiTinh, int namSinh, String monDay, String chucVu) {
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
        int so = Integer.parseInt(maHienCo.substring(2));
        if (so >= magvtieptheo)
            magvtieptheo = so + 1; // tăng để không bị trùng
    }

    public void nhap() {

        super.nhap();

        System.out.print("Nhập môn dạy: ");
        monDay = sc.nextLine();

        System.out.print("Nhập chức vụ (bộ môn hoặc chủ nhiệm): ");
        chucVu = sc.nextLine();
    }

    public void hienThi() {
        System.out.printf("%s, %s, %s, %d, %s, %s\n", maGV, hoTen, gioiTinh, namSinh,monDay,chucVu);
    }

    // Getter - Setter
    public String getMaGV() {
        return maGV;
    }

    public void setMaGV(String maGV) {
        this.maGV = maGV;
    }

    public String getMonDay() {
        return monDay;
    }

    public void setMonDay(String monDay) {
        this.monDay = monDay;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }
}
