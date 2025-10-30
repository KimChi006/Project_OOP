import java.util.Scanner;
public abstract class Nguoi{
    private String hoTen;
    private String gioiTinh;
    private int namSinh;
public Nguoi(){}
public Nguoi(String hoTen, String gioiTinh, int namSinh){
    this.hoTen=hoTen;
    this.gioiTinh=gioiTinh;
    this.namSinh=namSinh;
}
public void sethoTen(String hoTen){
    this.hoTen=hoTen;
}
public String gethoTen(){
    return hoTen;
}
public void setgioiTinh(String gioiTinh){
    this.gioiTinh=gioiTinh;
}
public String getgioiTinh(){
    return gioiTinh;
}
public void setnamSinh(int namSinh){
    this.namSinh=namSinh;
}
public int getnamSinh(){
    return namSinh;
}
public void nhap(){
    Scanner sc=new Scanner(System.in);
    System.out.println("nhap ho ten nguoi: ");
    sethoTen( sc.nextLine());
    System.out.println("nhap gioi tinh nguoi: ");
    setgioiTinh(sc.nextLine());
    System.out.println("nhap nam sinh nguoi: ");
    setnamSinh(sc.nextInt());
}
public void hienThi(){};
}



