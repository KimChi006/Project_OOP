import java.util.Scanner;

public class HocSinh extends Nguoi{
    private static int maHSTiepTheo=1000; 
    private String maHS;
    private String maLop;
    private String hanhKiem;
    private String loaihocsinh;
    protected Scanner sc;

public static String getMaHSTiepTheo() {
        return "HS" + maHSTiepTheo++;
    }
public HocSinh(){
    super();
}
public HocSinh(String hoTen, String gioiTinh, int namSinh, String maHS, String maLop, String hanhKiem, String loaihocsinh ){
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
public void setmaLop(String maLop){
    this.maLop = maLop;
}

    public String getmaLop(){
    return maLop;
}

public void sethanhKiem(String hanhKiem){
    this.hanhKiem=hanhKiem;
}
public String gethanhKiem(){
    return hanhKiem;
}
public void setloaihocsinh(String loaihocsinh){
    this.loaihocsinh=loaihocsinh;
}
public String getloaihocsinh(){
    return loaihocsinh;
}

public void nhap(){
    super.nhap();
    System.out.println("nhap ma lop cho hoc sinh: ");
    setmaLop(sc.nextLine());
    System.out.println("nhap hanh kiem cho hoc sinh: ");
    sethanhKiem(sc.nextLine());
    System.out.println("nhap loai hoc sinh: ");
    setloaihocsinh(sc.nextLine());
}

public void hienThi(){
    System.out.println(" ma hoc sinh: "+maHS);
    System.out.println("  ten hoc sinh "+hoTen);
    System.out.println("gioi tinh hoc sinh"+gioiTinh);
    System.out.println("  nam sinh hõ sinh "+namSinh);
    System.out.println(" lop hoc sinh"+maLop);
    System.out.println("  hanh kiem hoc sinh"+hanhKiem);
    System.out.println("  loai hoc sinh"+loaihocsinh);
}

}
class NoiTru extends HocSinh {
    private String khuNoiTru;

    public NoiTru(){
        super();
    }

    public NoiTru(String hoTen, String gioiTinh, int namSinh, String maHS, String maLop, String hanhKiem,String loaihocsinh, String khuNoiTru) {
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
        System.out.print("Nhập khu nội trú: ");
        setKhuNoiTru(sc.nextLine());
    }

    @Override
    public void hienThi() {
        super.hienThi();
        System.out.println("Khu nội trú: " + khuNoiTru);
    }
}
class NgoaiTru extends HocSinh {
    private String diaChiNha;

    public NgoaiTru(){
        super();
    }
    public NgoaiTru(String hoTen, String gioiTinh, int namSinh, String maHS, String maLop, String hanhKiem,String loaihocsinh, String diaChiNha) {
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
        System.out.print("Nhập địa chỉ nhà: ");
        setDiaChiNha(sc.nextLine());
    }

    @Override
    public void hienThi() {
        super.hienThi();
        System.out.println("Địa chỉ nhà: " + diaChiNha);
    }
}




