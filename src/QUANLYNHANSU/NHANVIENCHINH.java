package QUANLYNHANSU;

public class NHANVIENCHINH extends NHANVIEN {

    private long luongCoBan;
    private float heSoLuong;
    private String email;
    private String maPhongBan;
    private int soDuAnDaThucHien;
    private String maDuAnDangLam;

    public NHANVIENCHINH() {
        luongCoBan = 0;
        heSoLuong = 0;
    }
    public NHANVIENCHINH(String maNhanVien, String hoTen, NGAY ngaySinh, String gioiTinh, 
            String soDienThoai, DIACHI diaChi, String chucVu, HOPDONG hopDong, long luongCoBan, 
            float heSoLuong, String email, String maPhongBan, int soDuAnDaThucHien, String maDuAnDangLam) {
        super(maNhanVien, hoTen, ngaySinh, gioiTinh, soDienThoai, diaChi, chucVu, hopDong);
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
        this.email = email;
        this.maPhongBan = maPhongBan;
        this.soDuAnDaThucHien = soDuAnDaThucHien;
        this.maDuAnDangLam = maDuAnDangLam;
    }

    public long getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(long luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public float getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(float heSoLuong) {
        this.heSoLuong = heSoLuong;
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

    public int getSoDuAnDaThucHien() {
        return soDuAnDaThucHien;
    }

    public void setSoDuAnDaThucHien(int soDuAnDaThucHien) {
        this.soDuAnDaThucHien = soDuAnDaThucHien;
    }

    public String getMaDuAnDangLam() {
        return maDuAnDangLam;
    }

    public void setMaDuAnDangLam(String maDuAnDangLam) {
        this.maDuAnDangLam = maDuAnDangLam;
    }

    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Luong co ban: ");
        this.luongCoBan = CHECK.kiemTraSoNguyenDuong();
        System.out.print("He so luong: ");
        this.heSoLuong = CHECK.kiemTraFloat();
        System.out.print("Email -> ");
        this.email = CHECK.kiemTraEmail();
        System.out.println("Ma phong ban: ");
        this.maPhongBan = CHECK.nhapMaPhongBan();
        this.soDuAnDaThucHien = 0;
        System.out.println("Ma du an -> ");
        this.maDuAnDangLam = CHECK.nhapMaDuAn();
        System.out.println();
    }

    @Override
    public void xuat() {
        System.out.println("+-----+--------------------+---------------+----------+-----------+---------------------------------------------+---------------+---------------+---------------+---------------+-----+-----------------+-----------------------------------+-----+-------------------------+--------------------+");
        System.out.printf("|%-5s|%-20s|%-15s|%-10s|%-11s|%-45s|%-15s|%-15s|%-15s|%-15s|%-5s|%-35s|%-5s|%-25s|%-20s|\n", "Ma", "Ho Ten", "Ngay Sinh", "Gioi tinh", 
                "SDT", "Dia chi", "Chuc vu", "Ngay BDHD", "Ngay KTHD", "Luong CB", "HSL", "Email", "Ma PB", "So du an da thuc hien", "Ma du an dang lam");
        System.out.println("+-----+--------------------+---------------+----------+-----------+---------------------------------------------+---------------+---------------+---------------+---------------+-----+-----------------+-----------------------------------+-----+-------------------------+--------------------+");
        System.out.printf("|%-5s|%-20s|%-15s|%-10s|%-11s|%-45s|%-15s|%-15s|%-15s|%-15s|%-5s|%-35s|%-5s|%-25s|%-20s|\n", 
                super.getMaNhanVien(), super.getHoTen(), super.getNgaySinh(), super.getGioiTinh(), super.getSoDienThoai(), 
                super.getDiaChi(), super.getChucVu(), super.getHopDong().getNgayBatDauHopDong(), 
                super.getHopDong().getNgayKetThucHopDong(), this.getLuongCoBan(), this.getHeSoLuong(), 
                this.email, this.maPhongBan, this.soDuAnDaThucHien, this.maDuAnDangLam);
        System.out.println("+-----+--------------------+---------------+----------+-----------+---------------------------------------------+---------------+---------------+---------------+---------------+-----+-----------------+-----------------------------------+-----+-------------------------+--------------------+");
    }

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
