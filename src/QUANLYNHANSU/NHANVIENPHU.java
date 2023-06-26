package QUANLYNHANSU;

public class NHANVIENPHU extends NHANVIEN {

    private long luongCoBan;
    private float heSoLuong;

    public NHANVIENPHU() {
        super();
        this.luongCoBan = 0;
        this.heSoLuong = 0;
    }

    public NHANVIENPHU(String maNhanVien, String hoTen, NGAY ngaySinh, String gioiTinh, String soDienThoai, DIACHI diaChi, String chucVu, HOPDONG hopDong, long luongCoBan, float heSoLuong) {
        super(maNhanVien, hoTen, ngaySinh, gioiTinh, soDienThoai, diaChi, chucVu, hopDong);
        this.luongCoBan = luongCoBan;
        this.heSoLuong = heSoLuong;
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

    @Override
    public void nhap() {
        super.nhap();
        System.out.print("Luong co ban: ");
        this.luongCoBan = CHECK.kiemTraSoNguyenDuong();
        System.out.print("He so luong: ");
        this.heSoLuong = CHECK.kiemTraFloat();
        System.out.println();
    }

    @Override
    public void xuat() {
        System.out.println("+-----+--------------------+---------------+----------+-----------+---------------------------------------------+---------------+---------------+---------------+---------------+-----+-----------------+");
        System.out.printf("|%-5s|%-20s|%-15s|%-10s|%-11s|%-45s|%-15s|%-15s|%-15s|%-15s|%-5s|\n", "Ma", "Ho Ten", "Ngay Sinh", "Gioi tinh", "SDT", "Dia chi", "Chuc vu", "Ngay BDHD", "Ngay KTHD", "Luong CB", "HSL");
        System.out.println("+-----+--------------------+---------------+----------+-----------+---------------------------------------------+---------------+---------------+---------------+---------------+-----+-----------------+");
        System.out.printf("|%-5s|%-20s|%-15s|%-10s|%-11s|%-45s|%-15s|%-15s|%-15s|%-15s|%-5s|\n", super.getMaNhanVien(), super.getHoTen(), super.getNgaySinh(), super.getGioiTinh(), super.getSoDienThoai(), super.getDiaChi(), super.getChucVu(), super.getHopDong().getNgayBatDauHopDong(), super.getHopDong().getNgayKetThucHopDong(), this.getLuongCoBan(), this.getHeSoLuong());
        System.out.println("+-----+--------------------+---------------+----------+-----------+---------------------------------------------+---------------+---------------+---------------+---------------+-----+-----------------+");
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
