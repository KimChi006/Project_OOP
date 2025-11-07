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
        
        Double DiemMieng;
        while (true) {
            System.out.print("Nhập điểm miệng: ");
            try {
                DiemMieng=sc.nextDouble();
                 if (DiemMieng <=10.0 && DiemMieng>=0) break;
                      else System.out.println("điểm phải lớn hơn hoặc bằng 0 và nhỏ hơn hoặc bằng 10, vui lòng nhập lại!");
            } catch (NumberFormatException e) {
               
                    } 
              }
        setDiemMieng(DiemMieng);

        Double Diem15P;
        while (true) {
            System.out.print("Nhập điểm 15 phút: ");
            try {
                Diem15P=sc.nextDouble();
                 if (Diem15P <=10.0 && Diem15P>=0) break;
                     else System.out.println("điểm phải lớn hơn hoặc bằng 0 và nhỏ hơn hoặc bằng 10, vui lòng nhập lại!");
            } catch (NumberFormatException e) {
               
                   } 
                }
        setDiem15P(Diem15P);

        Double Diem1T;
        while (true) {
            System.out.print("Nhập điểm 1 tiết: ");
            try {
                Diem1T=sc.nextDouble();
                 if (Diem1T <=10.0 && Diem1T>=0) break;
                     else System.out.println("điểm phải lớn hơn hoặc bằng 0 và nhỏ hơn hoặc bằng 10, vui lòng nhập lại!");
            } catch (NumberFormatException e) {
               
                   } 
               }
        setDiem1T(Diem1T);

        Double DiemThi;
        while (true) {
            System.out.print("Nhập điểm thi: ");
            try {
                DiemThi=sc.nextDouble();
                 if (DiemThi <=10.0 && DiemThi>=0) break;
                     else System.out.println("điểm phải lớn hơn hoặc bằng 0 và nhỏ hơn hoặc bằng 10, vui lòng nhập lại!");
            } catch (NumberFormatException e) {
               
                    } 
               }
        setDiemThi(DiemThi);
    }

 public void xuat() {
        System.out.println(maHS + " ; " + maMon + " ; " + DiemMieng + " ; " + Diem15P + " ; " + Diem1T + " ; " + DiemThi);
     
}
}


