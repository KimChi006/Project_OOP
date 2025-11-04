import java.util.Scanner;
public abstract class Nguoi {
    protected String hoTen;
    protected String gioiTinh;
    protected int namSinh;
    private Scanner sc = new Scanner(System.in);

    public Nguoi() {}

    public Nguoi(String hoTen, String gioiTinh, int namSinh) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
    }

    public void sethoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String gethoTen() {
        return hoTen;
    }

    public void setgioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getgioiTinh() {
        return gioiTinh;
    }

    public void setnamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public int getnamSinh() {
        return namSinh;
    }

    public void nhap() {
        System.out.println("Nhập họ tên người: ");
        sethoTen(sc.nextLine());
        System.out.println("Nhập giới tính người: ");
        setgioiTinh(sc.nextLine());
        System.out.println("Nhập năm sinh người: ");
        setnamSinh(sc.nextInt());
    }

    public abstract void hienThi();
}
