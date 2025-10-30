import model.MonHoc;
import java.util.Scanner;
public class Diem{
    private HocSinh maHS;
    private MonHoc maMon;
    private double DiemMieng;
    private double Diem15P;
    private double Diem1T;
    private double DiemThi;
public Diem(){}
public Diem(HocSinh maHS,MonHoc maMon,double DiemMieng, double Diem15P, double Diem1T, double DiemThi){
    this.maHS=maHS;
    this.monHoc=maMon;
    this.DiemMieng=DiemMieng;
    this.Diem15P=Diem15P;
    this.Diem1T=Diem1T;
    this.DiemThi=DiemThi;
}
public void setmaHS(HocSinh maHS){
    this.maHS=maHS;
}
public HocSinh getmaHS(){
    return maHS;
}
public void setmonHoc(MonHoc maMon){
    this.maMon=maMon;
}
public MonHoc getmaMon(){
    return maMon;
}
public void setDiemMieng(double DiemMieng){
    this.DiemMieng=DiemMieng;
}
public double getDiemMieng(){
    return DiemMieng;
}
public void setDiem15P(double Diem15P){
    this.Diem15P=Diem15P;
}
public double getDiem15P(){
    return Diem15P;
}
public void setDiem1T(double Diem1T){
    this.Diem1T=Diem1T;
}
public double getDiem1T(){
    return Diem1T;
}
public void setDiemThi(double DiemThi){
    this.DiemThi=DiemThi;
}
public double getDiemThi(){
    return DiemThi;
}
public void nhap(){
    Scanner sc=Scanner(System.in);
    System.out.println("nhap ma so hoc sinh: ");
    setmaHS(sc.nextLine());
    System.out.println("nhap ma mon hoc cho hoc sinh: ");
    setmaMon(sc.nextLine());
    System.out.println("nhap diem mieng cho hoc sinh: ");
    setDiemMieng(sc.nextDouble());
    System.out.println("nhap diem 15p cho hoc sinh: ");
    setDiem15P(sc.nextDouble());
    System.out.println("nhap diem 1 tiet cho hoc sinh: ");
    setDiem1T(sc.nextDouble());
    System.out.println("nhap diem thi cho hoc sinh: ");
    setDiemThi(sc.nextDouble());
    
}
public void xuat(){
    System.out.println("ma so hoc sinh la: "+maHS);
    System.out.println("ma mon hoc cua hoc sinh la: "+maMon);
    System.out.println("diem mieng hoc sinh la: "+DiemMieng);
    System.out.println("diem 15p hoc sinh la: "+Diem15P);
    System.out.println("diem 1 tiet hoc sinh la: "+Diem1T);
    System.out.println("diem thi hoc sinh la: "+DiemThi);
}
}
