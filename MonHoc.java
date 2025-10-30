import java.util.Scanner;

public class MonHoc {
    private String maMon;
    private String tenMon;
    private int soTiet;
    public Object getMaMon;
    private Scanner sc = new Scanner(System.in);

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
        System.out.println("Mã môn:" + maMon +"," + "Tên môn:" + ","+tenMon+"Số tiết:" +","+ soTiet);
    }

    public String toFileString() {
        return maMon + "," + tenMon + "," + soTiet;
    }
    public void nhap(){
        System.out.println("Nhập mã môn học:");
        maMon = sc.nextLine();
        System.out.println("Nhập tên môn học:");
        tenMon = sc.nextLine();
        System.out.println("Nhập số tiết của môn học:");
        soTiet = sc.nextInt();
    }
}
