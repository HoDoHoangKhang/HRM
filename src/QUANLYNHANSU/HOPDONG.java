package QUANLYNHANSU;

import java.time.LocalDate;

public class HOPDONG {

    private NGAY ngayBatDauHopDong;
    private int thoiHanHopDong;
    private NGAY ngayKetThucHopDong;
    private int thoiGianConLaiHopDong;

    public HOPDONG(NGAY ngayBatDauHopDong, int thoiHanHopDong, NGAY ngayKetThucHopDong, int thoiGianConLaiHopDong) {
        this.ngayBatDauHopDong = ngayBatDauHopDong;
        this.thoiHanHopDong = thoiHanHopDong;
        this.ngayKetThucHopDong = ngayKetThucHopDong;
        this.thoiGianConLaiHopDong = thoiGianConLaiHopDong;
    }

    public HOPDONG() {
        ngayBatDauHopDong = new NGAY();
        ngayKetThucHopDong = new NGAY();
    }

    public NGAY getNgayBatDauHopDong() {
        return ngayBatDauHopDong;
    }

    public void setNgayBatDauHopDong(NGAY ngayBatDauHopDong) {
        this.ngayBatDauHopDong = ngayBatDauHopDong;
    }

    public int getThoiHanHopDong() {
        return thoiHanHopDong;
    }

    public void setThoiHanHopDong(int thoiHanHopDong) {
        this.thoiHanHopDong = thoiHanHopDong;
    }

    public NGAY getNgayKetThucHopDong() {
        return ngayKetThucHopDong;
    }

    public void setNgayKetThucHopDong(NGAY ngayKetThucHopDong) {
        this.ngayKetThucHopDong = ngayKetThucHopDong;
    }

    public int getThoiGianConLaiHopDong() {
        return thoiGianConLaiHopDong;
    }

    public void setThoiGianConLaiHopDong(int thoiGianConLaiHopDong) {
        this.thoiGianConLaiHopDong = thoiGianConLaiHopDong;
    }

    public void nhapHopDong() {
        System.out.println("Ngay bat dau hop dong: ");
        this.ngayBatDauHopDong.nhapNgay();
        System.out.print("Thoi han hop dong (theo thang): ");
        this.thoiHanHopDong = (int) CHECK.kiemTraSoNguyenDuong();
        int thangHopDong = this.thoiHanHopDong % 12;// so thang theo hop dong
        int namHopDong = this.thoiHanHopDong / 12;// so nam theo hop dong
        getNgayKetThucHopDong().setNgay(this.ngayBatDauHopDong.getNgay());
        getNgayKetThucHopDong().setThang(this.ngayBatDauHopDong.getThang() + thangHopDong);
        getNgayKetThucHopDong().setNam(this.ngayBatDauHopDong.getNam() + namHopDong);
        //nam=2026-2024
        //if tháng của a lớn hơn tháng n {
//			2/3/2023  a ngày ngày kết thúc hợp đồng
//			20/11/2022  n ngày hiện tại
//			thang= nam*12 + a.getThang()- n.getThang();
//			thang = 2*12+ 4-1=27
//		}
//		else if( tháng n và ngày kết thúc bằng nhau ){
//			12/4/2026  a ngày ngày kết thúc hợp đồng
//			12/4/2024  n ngày hiện tại
//			thang=nam*12;
//			thang=2*12
//		}
//		else{
//			12/1/2026  a ngày ngày kết thúc hợp đồng
//			12/4/2024  n ngày hiện tại
//			thang=nam*12-(n.getThang()- a.getThang())
//			thang=2*12-(4-1)
//		} 
        LocalDate n = LocalDate.now();
        int nam = this.getNgayKetThucHopDong().getNam() - n.getYear();
        if (this.ngayKetThucHopDong.getThang() > n.getMonthValue()) {
            this.thoiGianConLaiHopDong = nam * 12 + this.ngayKetThucHopDong.getThang() - n.getMonthValue();
        }
        if (this.ngayKetThucHopDong.getThang() < n.getMonthValue()) {
            this.thoiGianConLaiHopDong = nam * 12 - (n.getMonthValue() - this.ngayKetThucHopDong.getThang());
        } else {
            this.thoiGianConLaiHopDong = nam * 12;
        }
    }

    public void xuatHopDong() {
        System.out.println("Ngay bat dau hop dong: " + ngayBatDauHopDong);
        System.out.println("Ngay ket thuc hop dong: " + ngayKetThucHopDong);
        System.out.println("Thoi han hop dong: " + this.thoiHanHopDong);
        System.out.println("Thoi gian con lai cua hop dong: " + this.thoiGianConLaiHopDong);

    }
}
