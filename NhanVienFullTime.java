public class NhanVienFullTime extends NhanVienDaoTao{
    public NhanVienFullTime(String ten, int tuoi, String gioi_tinh, String sdt, String email, double luong, String nganh) {
        super(ten, tuoi, gioi_tinh, sdt, email, luong, nganh);
    }

    @Override
    public double doanh_thu() {
        return super.doanh_thu();
    }

    @Override
    public String toString() {
        return "NVFullTime"+','+super.toString();
    }
}
