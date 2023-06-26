package QUANLYNHANSU;

public class THUCTAPSINH extends NHANVIEN {

    private long phuCap;
    private String email;
    private String maPhongBan;

    public THUCTAPSINH() {
    }

    public THUCTAPSINH(String maNhanVien, String hoTen, NGAY ngaySinh, String gioiTinh, String soDienThoai, DIACHI diaChi, String chucVu, HOPDONG hopDong, long phuCap, String email, String maPhongBan) {
        super(maNhanVien, hoTen, ngaySinh, gioiTinh, soDienThoai, diaChi, chucVu, hopDong);
        this.phuCap = phuCap;
        this.email = email;
        this.maPhongBan = maPhongBan;
    }

    public long getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(long phuCap) {
        this.phuCap = phuCap;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Phu cap -> ");
        this.phuCap = CHECK.kiemTraSoNguyenDuong();
        System.out.print("Email -> ");
        this.email = CHECK.kiemTraEmail();
        System.out.println("Ma phong ban: ");
        this.maPhongBan = CHECK.nhapMaPhongBan();
        System.out.println();
    }

    @Override
    public void xuat() {
        System.out.println("+-----+--------------------+---------------+----------+-----------+---------------------------------------------+---------------+---------------+---------------+-----------------------------------+---------------+-----+");
        System.out.printf("|%-5s|%-20s|%-15s|%-10s|%-11s|%-45s|%-15s|%-15s|%-15s|%-35s|%-15s|%-5s|\n", "Ma", "Ho Ten", "Ngay Sinh", "Gioi tinh", "SDT", "Dia chi", "Chuc vu", "Ngay BDHD", "Ngay KTHD", "Email", "Phu cap", "Ma PB");
        System.out.println("+-----+--------------------+---------------+----------+-----------+---------------------------------------------+---------------+---------------+---------------+-----------------------------------+---------------+-----+");
        System.out.printf("|%-5s|%-20s|%-15s|%-10s|%-11s|%-45s|%-15s|%-15s|%-15s|%-35s|%-15s|%-5s|\n", super.getMaNhanVien(), super.getHoTen(), super.getNgaySinh(), super.getGioiTinh(), super.getSoDienThoai(), super.getDiaChi(), super.getChucVu(), super.getHopDong().getNgayBatDauHopDong(), super.getHopDong().getNgayKetThucHopDong(), this.email, this.phuCap, this.maPhongBan);
        System.out.println("+-----+--------------------+---------------+----------+-----------+---------------------------------------------+---------------+---------------+---------------+-----------------------------------+---------------+-----+");
    }

    @Override
    public void xuatHopDong() {
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                              HOP DONG                                                        |");
        System.out.println("+-----+--------------------+---------------+---------------+-------------------------+---------------+-------------------------+");
        System.out.printf("|%-5s|%-20s|%-15s|%-15s|%-25s|%-15s|%-25s|\n", "Ma", "Ho Ten", "Chuc Vu", "Ngay BDHD", "Thoi Han Hop Dong(Thang)", "Ngay KTHD", "Thoi Gian Con Lai(Thang)");
        System.out.println("+-----+--------------------+---------------+---------------+-------------------------+---------------+-------------------------+");
        System.out.printf("|%-5s|%-20s|%-15s|%-15s|%-25s|%-15s|%-25s|\n", super.getMaNhanVien(), super.getHoTen(), super.getChucVu(), super.getHopDong().getNgayBatDauHopDong(), super.getHopDong().getThoiHanHopDong(), super.getHopDong().getNgayKetThucHopDong(), super.getHopDong().getThoiGianConLaiHopDong());
        System.out.println("+-----+--------------------+---------------+---------------+-------------------------+---------------+-------------------------+");
    }
}
