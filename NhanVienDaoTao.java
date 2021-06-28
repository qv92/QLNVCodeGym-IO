public class NhanVienDaoTao extends NhanVien{
    private String nganh;

    public NhanVienDaoTao(String ten, int tuoi, String gioi_tinh, String sdt, String email, double luong, String nganh) {
        super(ten, tuoi, gioi_tinh, sdt, email, luong);
        this.nganh = nganh;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    @Override
    public String toString() {
        return  super.toString()+','+ nganh ;
    }
}
