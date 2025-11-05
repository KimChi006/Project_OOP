import java.util.Scanner;

public class HocSinh extends Nguoi{
    private static int maHSTiepTheo=1000; 
    private String maHS;
    private String maLop;
    private String hanhKiem;
    private String loaihocsinh;
    protected Scanner sc= new Scanner(System.in);

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
    System.out.println("Nhập mã lớp cho học sinh: ");
    setmaLop(sc.nextLine());
    String hanhKiem;
       while(true){
         System.out.print("nhập hạnh kiểm: ");
         hanhKiem=sc.nextLine().trim();
         if(hanhKiem.equalsIgnoreCase("Tốt")||hanhKiem.equalsIgnoreCase("Khá")||hanhKiem.equalsIgnoreCase("Trung Bình")||hanhKiem.equalsIgnoreCase("Yếu")||hanhKiem.equalsIgnoreCase("Kém")) break;
         System.out.println("hạnh kiểm phải là tốt hoặc khá hoặc trung bình hoặc yếu hoặc kém, vui lòng nhập lại!");
         }
       sethanhKiem(hanhKiem);
    System.out.println(getloaihocsinh());
 
}



public void hienThi(){
    System.out.println(maHS + "," + hoTen + "," + maLop + "," + gioiTinh + "," + namSinh + "," + hanhKiem + ","+ loaihocsinh);
   
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
        System.out.println("," + khuNoiTru);
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
        System.out.println("," + diaChiNha);
    }
}





