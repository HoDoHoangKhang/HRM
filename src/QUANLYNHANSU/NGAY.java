package QUANLYNHANSU;

import java.io.Serializable;

public class NGAY implements Serializable {

    private int ngay;
    private int thang;
    private int nam;

    public NGAY() {
    }

    public NGAY(int ngay, int thang, int nam) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }

    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }
    
    public boolean compareDate(NGAY date) {
        return (this.ngay == date.getNgay() && this.thang == date.getThang() && this.nam == date.getNam());
    }

    public void nhapNgay() {
        System.out.print("\tNgay -> ");
        this.ngay = (int) CHECK.kiemTraSoNguyenDuong();
        System.out.print("\tThang -> ");
        this.thang = (int) CHECK.kiemTraSoNguyenDuong();
        System.out.print("\tNam -> ");
        this.nam = (int) CHECK.kiemTraSoNguyenDuong();
        while (CHECK.kiemTraNgayThangNam(this.ngay, this.thang, this.nam) == false) {
            System.out.println("Ngay khong ton tai\nMoi ban nhap lai");
            System.out.print("\tNgay -> ");
            this.ngay = (int) CHECK.kiemTraSoNguyenDuong();
            System.out.print("\tThang -> ");
            this.thang = (int) CHECK.kiemTraSoNguyenDuong();
            System.out.print("\tNam -> ");
            this.nam = (int) CHECK.kiemTraSoNguyenDuong();
        }
    }

    @Override
    public String toString() {
        return this.ngay + "/" + this.thang + "/" + this.nam;
    }

    public void taoNgay(String n) {
        String arr[] = n.split("/");
        this.ngay = Integer.parseInt(arr[0]);
        this.thang = Integer.parseInt(arr[1]);
        this.nam = Integer.parseInt(arr[2]);
    }
}
