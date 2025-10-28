import model.MonHoc;
import java.util.Scanner;
public class Diem{
    private HocSinh maHS;
    private MonHoc maMon;
    private double giaTri;
public Diem(){}
public Diem(HocSinh maHS,MonHoc maMon, double giaTri){
    this.maHS=maHS;
    this.monHoc=maMon;
    this.giaTri=giaTri;
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
public void setgiaTri(double giaTri){
    this.giaTri=giaTri;
}
public double getgiaTri(){
    return giaTri;
}
public abstract void nhap();
public abstract void xuat();
}
class DiemMieng extends Diem{
    public DiemMieng(double giaTri){
         super(giaTri);
    }
    public void nhap(){
         Scanner sc=new Scanner(System.in);
         System.out.println("nhap diem mieng: ");
         setgiaTri(sc.nextDouble());
    }
    public void xuat(){
        System.out.println("diem mieng cua hoc sinh la: "+getgiaTri());
    }
}
class Diem15Phut extends Diem {
    public Diem15Phut(double giaTri) {
        super(giaTri);
    }

    @Override
    public void nhap(){
         Scanner sc=new Scanner(System.in);
         System.out.println("nhap diem 15p: ");
         setgiaTri(sc.nextDouble());
    }
     public void xuat(){
        System.out.println("diem 15p cua hoc sinh la: "+getgiaTri());
    }

}
class Diem1Tiet extends Diem {
    public Diem1Tiet(double giaTri) {
        super(giaTri);
    }

    @Override
    public void nhap(){
         Scanner sc=new Scanner(System.in);
         System.out.println("nhap diem 1 tiet: ");
         setgiaTri(sc.nextDouble());
    }
         public void xuat(){
        System.out.println("diem 1 tet cua hoc sinh la: "+getgiaTri());
    }
}
class DiemThi extends Diem{
    public DiemThi(double giaTri){
        super(giaTri);
    }
    @Override
    public void nhap(){
         Scanner sc=new Scanner(System.in);
         System.out.println("nhap diem thi: ");
         setgiaTri(sc.nextDouble());
    }
    public void xuat(){
        System.out.println("diem thi cua hoc sinh la: "+getgiaTri());
    }
}


