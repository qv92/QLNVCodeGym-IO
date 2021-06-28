import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;
public class QLNV {
    static ArrayList<NhanVien> list = new ArrayList<>();
    static File nhanVien = new File("qlnv.txt");
    static Scanner sc= new Scanner(System.in);
    public static String nhapTen(){
        System.out.println("Nhập tên nhân viên");
        String ten=sc.nextLine();
        return ten;
    }
    public static String nhapSDT(){
        System.out.println("Nhập số điện thoại");
        String sdt=sc.nextLine();
        return sdt;
    }
    public static int nhapTuoiNhanVien() {
        while (true) {
            System.out.print("Nhập tuổi nhân viên: ");
            try{int tuoi = Integer.parseInt(sc.nextLine());
                if (tuoi < 18) throw new InputMismatchException("tuổi không được nhỏ hơn 18");
                else return tuoi;
            }
            catch (InputMismatchException e){
                System.out.println("Tuổi phải là số lớn hơn 18");
            }
            catch (Exception e){
                System.out.println("Tuổi phải là số lớn hơn 18");
            }
        }
    }
    public static String nhapEmail() {
        while (true) {
            System.out.println("Nhập email nhân viên");
            try {String email = sc.nextLine();
                if (list.size()>0) {
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getEmail().equals(email))
                            throw new InputMismatchException();
                    }
                }
                return email;
            }
            catch (InputMismatchException e){
                System.out.println("Email này đã có rồi , mời nhập email khác");
            }
        }
    }
    public static double nhapLuong(){
        while (true) {
            try {System.out.println("Nhập lương");
                double luong = Double.parseDouble(sc.nextLine());
                return luong;}
            catch (Exception e){
                System.out.println("Lương phải là 1 số");
            }
        }
    }
    public static String nhapGioiTinh() {
        while (true) {
            try {System.out.println("Nhap gioi tinh(Nam/Nu): ");
                String gender = sc.nextLine();
                if (gender.equals("Nam") || gender.equals("Nu")) return gender;
                else throw new InputMismatchException();}
            catch (InputMismatchException e){
                System.out.println("Giới tình chỉ có thể là Nam hoặc Nu");
            }
        }
    }
    public static String nhapNganh(){
        System.out.println("Nhập ngành");
        String nganh = sc.nextLine();
        return nganh;
    }
    public static int nhapSoTuyenSinh(){
        System.out.println("Nhập số tuyển sinh được");
        int so_tuyen_sinh = Integer.parseInt(sc.nextLine());
        return so_tuyen_sinh;
    }
    public static double nhapGioLamViec(){
        System.out.println("Nhập giờ làm việc");
        double gio_lam_viec=Double.parseDouble(sc.nextLine());
        return gio_lam_viec;
    }
    public static void addNhanVienPartTime(){
        NhanVien nhanVien = new NhanVienPartTime( nhapTen(), nhapTuoiNhanVien(),  nhapGioiTinh(),  nhapSDT(),  nhapEmail(),  nhapLuong(),  nhapNganh(),  nhapGioLamViec());
        list.add(nhanVien);
    }
    public static void addNhanVienFullTime(){
        NhanVien nhanVien = new NhanVienFullTime( nhapTen(),  nhapTuoiNhanVien(),  nhapGioiTinh(),  nhapSDT(),  nhapEmail(),  nhapLuong(),  nhapNganh());
        list.add(nhanVien);
    }
    public static void addNhanVienTuyenSinh(){
        NhanVien nhanVien = new NhanVienTuyenSinh( nhapTen(),  nhapTuoiNhanVien(),  nhapGioiTinh(),  nhapSDT(),  nhapEmail(),  nhapLuong(),  nhapSoTuyenSinh());
        list.add(nhanVien);
    }
    public static void addNhanVienDaoTao(){
        while (true){
            System.out.println("1.Thêm nhân viên full time");
            System.out.println("2.Thêm nhân viên parttime");
            System.out.println("3.Thoát");
            int choice=Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    addNhanVienFullTime();
                    break;
                case 2:
                    addNhanVienPartTime();
                    break;
                case 3:
                    break;
            }if (choice==3) break;
        }
    }
    public static void addNhanVien(){
        while (true){
            System.out.println("1.Thêm nhân viên đào tạo");
            System.out.println("2.Thêm nhân viên tuyển sinh");
            System.out.println("3.Thoát");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    addNhanVienDaoTao();
                    break;
                case 2:
                    addNhanVienTuyenSinh();
                    break;
                case 3:
                    break;
            }if (choice==3) break;
        }
    }
    public static void removeNhanVienDaotao(){
        System.out.println("Nhập tên cần đuổi");
        String nameRemove=sc.nextLine();
        int check=0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTen().equals(nameRemove)&&list.get(i).toString().contains("NhanVienDaoTao")){
                list.remove(i);
                i--;
                check++;
            }
        }if (check==0) System.out.println("Không có tên này");
    }
    public static void removeNhanVienTuyenSinh(){
        System.out.println("Nhập tên cần đuổi");
        String nameRemove=sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTen().equals(nameRemove)&&list.get(i).toString().contains("NhanVienTuyenSinh")){
                list.remove(i);
                i--;
            }
        }
    }
    public static void showDoanhThu(){
        System.out.println("Nhập tên");
        String nameDoanhThu=sc.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTen().equals(nameDoanhThu)){
                System.out.println("Doanh thu của " + nameDoanhThu+" là "+ list.get(i).doanh_thu());
            }
        }
    }
    public static void findNhanVienByName(){
        System.out.println("Nhập tên nhân viên cần tìm");
        String nameFind=sc.nextLine();
        for (NhanVien nhanvien:list) {
            if (nhanvien.getTen().equals(nameFind)){
                System.out.println(nhanvien);
            }
        }
    }
    public static void sortByName(){
        list.sort(Comparator.comparing(o->((NhanVien)o).getTen()));
    }
    public static void sortByDoanhThu(){
        list.sort(Comparator.comparing(o->((NhanVien)o).doanh_thu()));
    }
    public static void showNhanVien(){
        for (NhanVien nhanvien:list) {
            System.out.println(nhanvien);
        }
    }
    public static void removeNhanVien(){
        while (true){System.out.println("1.Xóa nhân viên đào tạo");
            System.out.println("2.Xóa nhân viên tuyển sinh");
            System.out.println("3.Thoát");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    removeNhanVienDaotao();
                    break;
                case 2:
                    removeNhanVienTuyenSinh();
                    break;
                case 3:
                    break;
            }if (choice==3) break;
        }}
    public static void ghiFile() {
        try{
            File file = new File("D:\\QuanLyNhanVienCodegym\\src\\qlnv.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (NhanVien nhanvien:list) {
                bufferedWriter.write(nhanvien.toString());
            }
            bufferedWriter.close();
        }
        catch (Exception e){
            System.out.println("Lỗi");
        }


    }

    public static void docFile() throws IOException {
        BufferedReader bufferedReader = null;
        try {
            FileReader fileReader = new FileReader(nhanVien);
            bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(",");
                if (str.length >= 10 && str.toString().contains("NVFullTime")) {
                    list.add(new NhanVienFullTime(str[0], Integer.parseInt(str[1].trim()), str[2], str[3], str[4],Double.parseDouble(str[5].trim()),str[6]));
                }
                if(str.length>=10 && str.toString().contains("NVPartTime")){
                    list.add(new NhanVienPartTime(str[0],Integer.parseInt(str[1]),str[2],str[3],str[4],Double.parseDouble(str[5]),str[6],Double.parseDouble(str[7])));
                }
                if(str.length>=10 && str.toString().contains("NVTuyenSinh")){
                    list.add(new NhanVienTuyenSinh(str[0], Integer.parseInt(str[1].trim()), str[2], str[3], str[4],Double.parseDouble(str[5].trim()),Integer.parseInt(str[6])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
        }


    }

    public static void menu() throws IOException {
        while (true){
            System.out.println("1.Thêm nhân viên");
            System.out.println("2.Đuổi nhân viên");
            System.out.println("3.Hiển thị doanh thu nhân viên");
            System.out.println("4.Tìm kiếm nhân viên");
            System.out.println("5.Sắp xếp nhân viên theo tên");
            System.out.println("6.Sắp xếp nhân viên theo doanh thu");
            System.out.println("7.Hiển thị toàn bộ nhân viên");
            System.out.println("8.Ghi file");
            System.out.println("9.Đọc file");
            System.out.println("10.Thoát");
            int choice=Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    addNhanVien();
                    break;
                case 2:
                    removeNhanVien();
                    break;
                case 3:
                    showDoanhThu();
                    break;
                case 4:
                    findNhanVienByName();
                    break;
                case 5:
                    sortByName();
                    break;
                case 6:
                    sortByDoanhThu();
                    break;
                case 7:
                    showNhanVien();
                    break;
                case 8:
                    ghiFile();
                    break;
                case 9:
                    docFile();
                    break;
                case 10:
                    break;
            }
        }
    }
}
