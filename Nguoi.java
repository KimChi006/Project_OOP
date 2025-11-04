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
        System.out.println("Nhập họ tên: ");
        sethoTen(sc.nextLine());
    String gioiTinh;
     while(true){
         System.out.print("Nhập giới tính: ");
         gioiTinh=sc.nextLine().trim();//bỏ khoảng trắng phía trước trong hàm nhập để so sánh equal trong if
         if(gioiTinh.equalsIgnoreCase("Nam") || gioiTinh.equalsIgnoreCase("Nữ")) break;
         System.out.println("giới tính phải là nam hoặc nữ, vui lòng nhập lại!");
    }
        setgioiTinh(gioiTinh);
   int namSinh;
    while (true) {
        System.out.print("Nhập năm sinh: ");
        try {
            namSinh = Integer.parseInt(sc.nextLine());
            if (namSinh <= 2025) break;
            else System.out.println("năm sinh phải nhỏ hơn 2025, vui lòng nhập lại!.");
        } catch (NumberFormatException e) {
            System.out.println(" Năm sinh phải là số nguyên. Vui lòng nhập lại.");
        }
    }
        setnamSinh(namSinh);
}

    public void hienThi() {};
}


