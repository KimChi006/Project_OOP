import java.util.Scanner;

public class Diem {
    private String maHS;
    private String maMon;
    private double DiemMieng;
    private double Diem15P;
    private double Diem1T;
    private double DiemThi;
    private Scanner sc = new Scanner(System.in);

    public Diem() {}

    public Diem(String maHS, String maMon, double DiemMieng, double Diem15P, double Diem1T, double DiemThi) {
        this.maHS = maHS;
        this.maMon = maMon;
        this.DiemMieng = DiemMieng;
        this.Diem15P = Diem15P;
        this.Diem1T = Diem1T;
        this.DiemThi = DiemThi;
    }

    public void setmaHS(String maHS) { this.maHS = maHS; }
    public String getmaHS() { return maHS; }

    public void setmaMon(String maMon) { this.maMon = maMon; }
    public String getmaMon() { return maMon; }

    public void setDiemMieng(double DiemMieng) { this.DiemMieng = DiemMieng; }
    public double getDiemMieng() { return DiemMieng; }

    public void setDiem15P(double Diem15P) { this.Diem15P = Diem15P; }
    public double getDiem15P() { return Diem15P; }

    public void setDiem1T(double Diem1T) { this.Diem1T = Diem1T; }
    public double getDiem1T() { return Diem1T; }

    public void setDiemThi(double DiemThi) { this.DiemThi = DiemThi; }
    public double getDiemThi() { return DiemThi; }

    public void nhap() {
        System.out.print("Nhập mã số học sinh: ");
        setmaHS(sc.nextLine());

        System.out.print("Nhập mã môn học: ");
        setmaMon(sc.nextLine());

        System.out.print("Nhập điểm miệng: ");
        setDiemMieng(sc.nextDouble());

        System.out.print("Nhập điểm 15 phút: ");
        setDiem15P(sc.nextDouble());

        System.out.print("Nhập điểm 1 tiết: ");
        setDiem1T(sc.nextDouble());

        System.out.print("Nhập điểm thi: ");
        setDiemThi(sc.nextDouble());
    }

    public void xuat() {
        System.out.println("\n--- Thông tin điểm ---");
        System.out.println("Mã học sinh: " + maHS);
        System.out.println("Mã môn học: " + maMon);
        System.out.println("Điểm miệng: " + DiemMieng);
        System.out.println("Điểm 15 phút: " + Diem15P);
        System.out.println("Điểm 1 tiết: " + Diem1T);
        System.out.println("Điểm thi: " + DiemThi);
    }
}
