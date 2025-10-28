package Project_OOP;
public class MonHoc {
    private String maMon;
    private String tenMon;
    private int soTiet;
    public Object getMaMon;

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
}
