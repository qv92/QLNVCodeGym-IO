public class NhanVienPartTime extends NhanVienDaoTao{
    private double gio_lam_viec;

    public double getGio_lam_viec() {
        return gio_lam_viec;
    }

    public void setGio_lam_viec(double gio_lam_viec) {
        this.gio_lam_viec = gio_lam_viec;
    }

    @Override
    public double doanh_thu() {
        double doanhthu=getLuong()*gio_lam_viec;
        return doanhthu;
    }

    @Override
    public String toString() {
        return  "NVPartTime"+','+super.toString()+ ','+gio_lam_viec ;
    }

    public NhanVienPartTime(String ten, int tuoi, String gioi_tinh, String sdt, String email, double luong, String nganh, double gio_lam_viec) {
        super(ten, tuoi, gioi_tinh, sdt, email, luong, nganh);
        this.gio_lam_viec = gio_lam_viec;

    }
}
