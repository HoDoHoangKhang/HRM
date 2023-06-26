package QUANLYNHANSU;

public class PHONGBAN {

    private String tenTruongPhong;
    private String maTruongPhong;
    private String maPhongBan;
    private String tenPhongBan;
    private int soLuongNhanVien;
    private Double luongHangThang;

    public PHONGBAN() {
        this.tenTruongPhong = "None";
        this.maTruongPhong = "None";
        this.maPhongBan = "";
        this.tenPhongBan = "";
        this.soLuongNhanVien = 0;
        this.luongHangThang = 0.0;
    }

    public PHONGBAN(String tenTruongPhong, String maTruongPhong, String maPhongBan, String tenPhongBan, int soLuongNhanVien, Double luongHangThang) {
        this.tenTruongPhong = tenTruongPhong;
        this.maTruongPhong = maTruongPhong;
        this.maPhongBan = maPhongBan;
        this.tenPhongBan = tenPhongBan;
        this.soLuongNhanVien = soLuongNhanVien;
        this.luongHangThang = luongHangThang;
    }

    public String getTenTruongPhong() {
        return tenTruongPhong;
    }

    public void setTenTruongPhong(String tenTruongPhong) {
        this.tenTruongPhong = tenTruongPhong;
    }

    public String getMaTruongPhong() {
        return maTruongPhong;
    }

    public void setMaTruongPhong(String maTruongPhong) {
        this.maTruongPhong = maTruongPhong;
    }

    public String getMaPhongBan() {
        return maPhongBan;
    }

    public void setMaPhongBan(String maPhongBan) {
        this.maPhongBan = maPhongBan;
    }

    public int getSoLuongNhanVien() {
        return soLuongNhanVien;
    }

    public void setSoLuongNhanVien(int soLuongNhanVien) {
        this.soLuongNhanVien = soLuongNhanVien;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public Double getLuongHangThang() {
        return luongHangThang;
    }

    public void setLuongHangThang(Double luongHangThang) {
        this.luongHangThang = luongHangThang;
    }

    public void nhapPhongBan() {
        boolean kt = true;
        while (kt) {
            System.out.println("Ma phong ban -> ");
            this.maPhongBan = Main.st.nextLine();
            if (CHECK.kiemTraMaDuAnTonTai(maPhongBan)) {
                System.out.println("Ma phong ban da ton tai moi nhap lai -> ");
            } else {
                kt = false;
            }
        }
        this.maPhongBan = CHECK.inHoaTatCaKyTu(maPhongBan);
        this.maTruongPhong = "Chua co";
        this.tenTruongPhong = "Chua co";
        int demNhanVien = 0;
        System.out.println("Ten phong ban -> ");
        this.tenPhongBan = CHECK.kiemTraChuoiKyTu();
        this.tenPhongBan = CHECK.inHoaChuCaiDauMoiTu(tenPhongBan);
        this.luongHangThang = 0.0;
    }

    public void xuatPhongBan() {
        System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                      DANH SACH PHONG BAN                                                               |");
        System.out.println("+---------------+--------------------+--------------------+--------------------+--------------------+------------------------------------+");
        System.out.printf("|%-15s|%-20s|%-20s|%-20s|%-20s|%-36s|\n", "Ma phong ban", "Ma Truong Phong", "Ten Truong Phong", "So Luong Nhan Vien", "Ten Phong Ban", "Luong Toan Bo Phong Ban (Trieu dong)");
        System.out.println("+---------------+--------------------+--------------------+--------------------+--------------------+------------------------------------+");
        System.out.printf("|%-15s|%-20s|%-20s|%-20s|%-20s|%-36s|\n", this.maPhongBan, this.maTruongPhong, this.tenTruongPhong, this.soLuongNhanVien, this.tenPhongBan, this.luongHangThang);
        System.out.println("+---------------+--------------------+--------------------+--------------------+--------------------+------------------------------------+");

    }
}
