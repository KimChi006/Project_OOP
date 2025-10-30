import model.LopHoc;
import model.Nguoi;
import java.util.Scanner;
public class HocSinh extends Nguoi{
    private static int maHSTiepTheo=1000; 
    private String maHS;
    private LopHoc maLop;
    private String hanhKiem;
    private String loaihocsinh;
public static String getMaHSTiepTheo() {
        return "HS" + maHSTiepTheo++;
    }
public HocSinh(String hoTen, String gioiTinh, int namSinh, String maHS, LopHoc maLop, String hanhKiem, String loaihocsinh ){
    super(hoTen, gioiTinh, namSinh);
    this.maHS=maHS;
    this.maLop=maLop;
    this.hanhKiem=hanhKiem;
    this.loaihocsinh=loaihocsinh;
}
public void setmaHS(String maHS){
    this.maHS=maHS;
}
public String getmaHS(){
    return maHS;
}
public void setmaLop(LopHoc maLop){
    this.lop=lop;
}
public LopHoc getmaLop(){
    return maLop;
}
public void sethanhKiem(String hanhKiem){
    this.hanhKiem=hanhKiem;
}
public String gethanhKiem(){
    return hanhKiem;
}
public setloaihocsinh(String loaihocsinh){
    this.loaihocsinh=loaihocsinh;
}
public String getloaihocsinh(){
    return loaihocsinh;
}

public void nhap(){
    super.nhap();
    Scanner sc=new Scanner(System.in);
    System.out.println("nhap ma lop cho hoc sinh: ");
    setmaLop(sc.nextLine());
    System.out.println("nhap hanh kiem cho hoc sinh: ");
    sethanhKiem(sc.nextLine());
    System.out.println("nhap loai hoc sinh: ");
    setloaihocsinh(sc.nextLine());
}
public void xuat(){
    super.xuat();
    System.out.println("ma hoc sinh vua nhap la: "+maHS);
    System.out.println("lop cua hoc sinh vua nhap la: "+lop);
    System.out.println("hanh liem cua hoc sinh vua nhap la: "+hanhKiem);
    System.out.println("loai hoc sinh: "+loaihocsinh);
}
public void hienthi(){
    System.out.println("")
}

}
public class NoiTru extends HocSinh {
    private String khuNoiTru;

    public NoiTru(String hoTen, String gioiTinh, int namSinh, String maHS, LopHoc maLop, String hanhKiem,String loaihocsinh, String khuNoiTru) {
        super(hoTen, gioiTinh, namSinh, maHS, maLop, hanhKiem, loaihocsinh);
        this.khuNoiTru = khuNoiTru;
    }

    public void setKhuNoiTru(String khuNoiTru) {
        this.khuNoiTru = khuNoiTru;
    }

    public String getKhuNoiTru() {
        return khuNoiTru;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập khu nội trú: ");
        setKhuNoiTru(sc.nextLine());
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Khu nội trú: " + khuNoiTru);
    }
}
public class NgoaiTru extends HocSinh {
    private String diaChiNha;

    public NgoaiTru(String hoTen, String gioiTinh, int namSinh, String maHS, LopHoc maLop, String hanhKiem,String loaihocsinh, String diaChiNha) {
        super(hoTen, gioiTinh, namSinh, maHS, maLop, hanhKiem, loaihocsinh);
        this.diaChiNha = diaChiNha;
    }

    public void setDiaChiNha(String diaChiNha) {
        this.diaChiNha = diaChiNha;
    }

    public String getDiaChiNha() {
        return diaChiNha;
    }

    @Override
    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập địa chỉ nhà: ");
        setDiaChiNha(sc.nextLine());
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.println("Địa chỉ nhà: " + diaChiNha);
    }
}



