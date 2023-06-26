package QUANLYNHANSU;

public abstract class NHANVIEN implements NhapXuat {

    protected String maNhanVien;
    protected String hoTen;
    protected NGAY ngaySinh;
    protected String gioiTinh;
    protected String soDienThoai;
    protected DIACHI diaChi;
    protected String chucVu;
    protected HOPDONG hopDong;

    public NHANVIEN() {
        hopDong = new HOPDONG();
        ngaySinh = new NGAY();
        diaChi = new DIACHI();
    }

    public NHANVIEN(String maNhanVien, String hoTen, NGAY ngaySinh, String gioiTinh, String soDienThoai, DIACHI diaChi, String chucVu, HOPDONG hopDong) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.chucVu = chucVu;
        this.hopDong = hopDong;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public NGAY getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(NGAY ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public DIACHI getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(DIACHI diaChi) {
        this.diaChi = diaChi;
    }

    public HOPDONG getHopDong() {
        return hopDong;
    }

    public void setHopDong(HOPDONG hopDong) {
        this.hopDong = hopDong;
    }

    @Override
    public void nhap() {
        int mode;
        if (this instanceof NHANVIENCHINH) {
            System.out.print("Ma nhan vien (VD: C0001)-> ");
            mode = 1;
        } else if (this instanceof THUCTAPSINH) {
            System.out.print("Ma nhan vien (VD: T0001)-> ");
            mode = 2;
        } else {
            System.out.print("Ma nhan vien (VD: P0001)-> ");
            mode = 3;
        }
        boolean kt = true;
        while (kt) {
            this.maNhanVien = CHECK.kiemTraMaNhanVien(mode);
            if (CHECK.kiemTraMaNhanVienTonTai(maNhanVien, DANHSACHNHANVIEN.listNhanVien)) {
                System.out.print("Ma nhan vien da ton tai.\nMoi nhap lai -> ");
            } else {
                kt = false;
            }
        }
        System.out.print("Ho ten nhan vien -> ");
        this.hoTen = CHECK.kiemTraHoTen();
        System.out.println("Ngay sinh: ");
        this.ngaySinh.nhapNgay();
        System.out.print("Gioi tinh -> ");
        this.gioiTinh = CHECK.kiemTraGioiTinh();
        System.out.print("So dien thoai -> ");
        this.soDienThoai = CHECK.kiemTraSoDienThoai();
        System.out.println("Dia chi: ");
        this.diaChi.nhapDiaChi();
        System.out.println("Chuc vu: ");
        this.chucVu = CHECK.nhapChucVu(mode);
        System.out.println("Hop dong: ");
        this.hopDong.nhapHopDong();
    }
    @Override
    public void xuat() {
        System.out.println("Ma nhan vien: " + this.maNhanVien);
        System.out.println("Ho ten: " + this.hoTen);
        System.out.println("Ngay sinh: " + ngaySinh);
        System.out.println("Gioi tinh: " + this.gioiTinh);
        System.out.println("So dien thoai: " + this.soDienThoai);
        System.out.println("Dia chi: " + diaChi);
        System.out.println("Chuc vu: " + this.chucVu);
        hopDong.xuatHopDong();
    }

    public void xuatHopDong() {
        // TODO Auto-generated method stub

    }
}
