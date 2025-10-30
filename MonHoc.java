import java.util.Scanner;

public class MonHoc {
    private String maMon;
    private String tenMon;
    private int soTiet;
    public Object getMaMon;
    private Scanner sc;

    public MonHoc() {}

    public MonHoc(String maMon, String tenMon, int soTiet) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.soTiet = soTiet;
    }

    public String getMaMon() {
        return maMon;
    }

    public void setMaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getSoTiet() {
        return soTiet;
    }

    public void setSoTiet(int soTiet) {
        this.soTiet = soTiet;
    }

    public void hienThi() {
        System.out.println("Ma mon" + maMon +"," + "Ten Mon" + ","+tenMon+"So Tiet" +","+ soTiet);
    }

    public String toFileString() {
        return maMon + "," + tenMon + "," + soTiet;
    }
    public void nhap(){
        System.out.println("Nhap ma mon hoc:");
        maMon = sc.nextLine();
        System.out.println("Nhap ten mon hoc:");
        tenMon = sc.nextLine();
        System.out.println("Nhap so tiet cua mon hoc:");
        soTiet = sc.nextInt();
    }
}
