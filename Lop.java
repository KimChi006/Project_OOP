import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Lop{
    String maLop;
    String tenLop;
    String giaoVienCN;
    private Scanner sc = new Scanner(System.in);;

    public Lop (){
        this.maLop = "";
        this.tenLop = "";
        this.giaoVienCN = "";
    }

    public Lop(String maLop, String tenLop, String giaoVienCN){
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.giaoVienCN = giaoVienCN;
    }

    public void nhap(){
        System.out.println("Nhập mã lớp:");
        this.maLop = sc.nextLine();
        System.out.println("Nhập tên lớp");
        this.tenLop = sc.nextLine();
        System.out.println("Nhập giáo viên chủ nhiệm");
        this.giaoVienCN = sc.nextLine();
    }

    public void xuat(){
        System.out.println("Mã lớp:"+maLop);
        System.out.println("Tên lớp:"+tenLop);
        System.out.println("Giáo viên chủ nhiệm:"+giaoVienCN);
    }
}
