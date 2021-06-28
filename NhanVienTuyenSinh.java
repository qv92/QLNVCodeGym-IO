public class NhanVienTuyenSinh extends NhanVien{
   private int so_tuyen_sinh;

    public NhanVienTuyenSinh(String ten, int tuoi, String gioi_tinh, String sdt, String email, double luong, int so_tuyen_sinh) {
        super(ten, tuoi, gioi_tinh, sdt, email, luong);
        this.so_tuyen_sinh = so_tuyen_sinh;
    }

    public int getSo_tuyen_sinh() {
        return so_tuyen_sinh;
    }

    public void setSo_tuyen_sinh(int so_tuyen_sinh) {
        this.so_tuyen_sinh = so_tuyen_sinh;
    }

    @Override
    public double doanh_thu() {
        double doanhthu=getLuong()*8+(so_tuyen_sinh*10);
        return doanhthu;
    }

    @Override
    public String toString() {
        return "NVTuyenSinh"+','+ super.toString()+ ','+ so_tuyen_sinh ;
    }
}
