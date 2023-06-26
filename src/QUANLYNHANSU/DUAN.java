package QUANLYNHANSU;

public class DUAN {

    private String tenDuAn;
    private String maDuAn;
    private int kinhPhiThucHien;
    private NGAY ngayBatDauDuAn;
    private int thoiHanDuAn;
    private NGAY ngayKetThucDuAn;

    public DUAN(String tenDuAn, String maDuAn, int kinhPhiThucHien, NGAY ngayBatDauDuAn, NGAY ngayKetThucDuAn, int thoiHanDuAn) {
        this.tenDuAn = tenDuAn;
        this.maDuAn = maDuAn;
        this.kinhPhiThucHien = kinhPhiThucHien;
        this.ngayBatDauDuAn = ngayBatDauDuAn;
        this.thoiHanDuAn = thoiHanDuAn;
        this.ngayKetThucDuAn = ngayKetThucDuAn;
    }

    public DUAN() {
        ngayBatDauDuAn = new NGAY();
        ngayKetThucDuAn = new NGAY();
    }

    public String getTenDuAn() {
        return tenDuAn;
    }

    public void setTenDuAn(String tenDuAn) {
        this.tenDuAn = tenDuAn;
    }

    public String getMaDuAn() {
        return maDuAn;
    }

    public void setMaDuAn(String maDuAn) {
        this.maDuAn = maDuAn;
    }

    public int getKinhPhiThucHien() {
        return kinhPhiThucHien;
    }

    public void setKinhPhiThucHien(int kinhPhiThucHien) {
        this.kinhPhiThucHien = kinhPhiThucHien;
    }

    public NGAY getNgayBatDauDuAn() {
        return ngayBatDauDuAn;
    }

    public void setNgayBatDauDuAn(NGAY ngayBatDauDuAn) {
        this.ngayBatDauDuAn = ngayBatDauDuAn;
    }

    public NGAY getNgayKetThucDuAn() {
        return ngayKetThucDuAn;
    }

    public void setNgayKetThucDuAn(NGAY ngayKetThucDuAn) {
        this.ngayKetThucDuAn = ngayKetThucDuAn;
    }

    public int getThoiHanDuAn() {
        return thoiHanDuAn;
    }

    public void setThoiHanDuAn(int thoiHanDuAn) {
        this.thoiHanDuAn = thoiHanDuAn;
    }

    public void nhapDuAn() {
        boolean kt = true;
        while (kt) {
            System.out.println("Ma du an -> ");
            this.maDuAn = Main.st.nextLine();
            if (CHECK.kiemTraMaDuAnTonTai(maDuAn)) {
                System.out.println("Ma du an da ton tai moi nhap lai -> ");
            } else {
                kt = false;
            }
        }
        System.out.print("Ten du an -> ");
        this.tenDuAn = Main.st.nextLine();
        this.tenDuAn = CHECK.inHoaChuCaiDauMoiTu(tenDuAn);
        this.maDuAn = CHECK.inHoaTatCaKyTu(maDuAn);
        System.out.print("Kinh phi thuc hien du an (Don vi: trieu dong) -> ");
        this.kinhPhiThucHien = (int) CHECK.kiemTraSoNguyenDuong();
        System.out.println("Ngay bat dau du an: ");
        this.ngayBatDauDuAn.nhapNgay();
        System.out.println("Thoi han du an: ");
        this.thoiHanDuAn = (int) CHECK.kiemTraSoNguyenDuong();
        int thangDuAn = this.thoiHanDuAn % 12;// so thang theo hop dong
        int namDuAn = this.thoiHanDuAn / 12;// so nam theo hop dong
        getNgayKetThucDuAn().setNgay(this.getNgayBatDauDuAn().getNgay());
        getNgayKetThucDuAn().setThang(this.ngayBatDauDuAn.getThang() + thangDuAn);
        getNgayKetThucDuAn().setNam(this.ngayBatDauDuAn.getNam() + namDuAn);
    }

    public void xuatDuAn() {
        System.out.println("Ten du an: " + this.tenDuAn);
        System.out.println("Ma du an: " + this.maDuAn);
        System.out.println("Kinh phi thuc hien du an: " + this.kinhPhiThucHien + " trieu dong");
        System.out.println("Ngay bat dau du an: " + this.ngayBatDauDuAn);
        System.out.println("Thoi han du an: " + this.ngayBatDauDuAn);
        System.out.println("Ngay ket thuc du an: " + this.ngayKetThucDuAn);
    }
}
