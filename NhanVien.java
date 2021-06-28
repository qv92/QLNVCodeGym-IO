public class NhanVien {
    private String ten;
    private int tuoi;
    private String gioi_tinh;
    private String sdt;
    private String email;
    private double luong;

    public NhanVien(String ten, int tuoi, String gioi_tinh, String sdt, String email, double luong) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioi_tinh = gioi_tinh;
        this.sdt = sdt;
        this.email = email;
        this.luong = luong;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioi_tinh() {
        return gioi_tinh;
    }

    public void setGioi_tinh(String gioi_tinh) {
        this.gioi_tinh = gioi_tinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }
    public double doanh_thu(){
        double doanhThu=getLuong()*8;
        return doanhThu;
    }

    @Override
    public String toString() {
        return ten + ',' + tuoi +','+ gioi_tinh + ',' + sdt + ',' + email + ',' + luong ;
    }
}
