package QUANLYNHANSU;

import java.time.LocalDate;
import java.util.ArrayList;

public class DANHSACHHOPDONG {

    public static void xoaNhanVienKhiHetHopDong() {
        for (NHANVIEN i : DANHSACHNHANVIEN.listNhanVien) {
            if (i.getHopDong().getNgayBatDauHopDong().getNgay() == i.getHopDong().getNgayKetThucHopDong().getNgay()
                    && i.getHopDong().getNgayBatDauHopDong().getThang() == i.getHopDong().getNgayKetThucHopDong().getThang()
                    && i.getHopDong().getNgayBatDauHopDong().getNam() == i.getHopDong().getNgayKetThucHopDong().getNam()) {
                DANHSACHNHANVIEN.listNhanVien.remove(i);
            }
        }
    }

    public static void menu() {
        boolean kt = true;
        while (kt) {
            MENU.menu_C();
            int chon = (int) CHECK.kiemTraSoNguyenDuong();
            switch (chon) {
                case 1:
                    MENU.xuatHopDong(DANHSACHNHANVIEN.listNhanVien);
                    break;
                case 2:
                    ArrayList<NHANVIEN> dstk1 = new ArrayList<>();
                    for (NHANVIEN i : DANHSACHNHANVIEN.listNhanVien) {
                        if (i.getHopDong().getThoiGianConLaiHopDong() == 1) {
                            dstk1.add(i);
                        }
                    }
                    if (dstk1.isEmpty()) {
                        System.out.println("KHONG TIM THAY HOP DONG NAO CON LAI 1 THANG");
                    } else {
                        MENU.xuatHopDong(dstk1);
                    }
                    break;
                case 3:
                    MENU.xuatHopDong(DANHSACHNHANVIEN.listNhanVien);
                    System.out.println("Nhap ma nhan vien can gia han -> ");
                    String maNhanVienGiaHanHopDong = CHECK.kiemTraNhapMaNhanVienKhongTonTai(DANHSACHNHANVIEN.listNhanVien);// kiểm tra mã nhập vào có tồn tại không
                    for (NHANVIEN i : DANHSACHNHANVIEN.listNhanVien) {
                        if (i.getMaNhanVien().equals(maNhanVienGiaHanHopDong)) {
                            System.out.println("NHAN VIEN TRUOC KHI GIA HAN");
                            i.xuatHopDong();
                            System.out.println("Nhap vao so thang can gia han -> ");
                            int thoiGianGiaHan = (int) CHECK.kiemTraSoNguyenDuong();
                            //thời gian gia hạn
                            i.getHopDong().setThoiHanHopDong(i.getHopDong().getThoiHanHopDong() + thoiGianGiaHan);
                            int thangGiaHan = thoiGianGiaHan % 12;// so thang gia han hop dong
                            int namGiaHan = thoiGianGiaHan / 12;//  so nam gia han hop dong
                            i.getHopDong().getNgayKetThucHopDong().setThang(i.getHopDong().getNgayKetThucHopDong().getThang() + thangGiaHan);
                            i.getHopDong().getNgayKetThucHopDong().setNam(i.getHopDong().getNgayKetThucHopDong().getNam() + namGiaHan);
                            LocalDate n = LocalDate.now();
                            //thời gian còn lại hợp đồng
                            i.getHopDong().setThoiGianConLaiHopDong(i.getHopDong().getThoiGianConLaiHopDong() + thoiGianGiaHan);
                            System.out.println("NHAN VIEN SAU KHI GIA HAN");
                            i.xuatHopDong();
                            File.ghiFileNhanVien();
                            break;
                        }
                    }
                    break;
                case 4:
                    boolean kt_4 = true;
                    while (kt_4) {
                        ArrayList<NHANVIEN> dstk = new ArrayList<>();
                        MENU.menu_C_4();
                        int chon_C_4 = (int) CHECK.kiemTraSoNguyenDuong();
                        switch (chon_C_4) {
                            case 1:
                                MENU.xuatHopDong(DANHSACHNHANVIEN.listNhanVien);
                                System.out.println("Nhap vao ma nhan vien can tim -> ");
                                String timKiemTheoMaNhanVien = Main.st.nextLine();
                                for (NHANVIEN i : DANHSACHNHANVIEN.listNhanVien) {
                                    if (i.getMaNhanVien().contains(timKiemTheoMaNhanVien)) {
                                        dstk.add(i);
                                    }
                                }
                                if (dstk.isEmpty()) {
                                    System.out.println("KHONG TIM THAY HOP DONG");
                                } else {
                                    System.out.println("DANH SACH HOP DONG CAN TIM");
                                    MENU.xuatHopDong(dstk);
                                }
                                break;
                            case 2:
                                MENU.xuatHopDong(DANHSACHNHANVIEN.listNhanVien);
                                System.out.println("Nhap vao ten nhan vien can tim -> ");
                                String timKiemTheoTenNhanVien = CHECK.kiemTraHoTen();
                                for (NHANVIEN i : DANHSACHNHANVIEN.listNhanVien) {
                                    if (i.getHoTen().contains(timKiemTheoTenNhanVien)) {
                                        dstk.add(i);
                                    }
                                }
                                if (dstk.isEmpty()) {
                                    System.out.println("KHONG TIM THAY HOP DONG");
                                } else {
                                    System.out.println("DANH SACH HOP DONG CAN TIM");
                                    MENU.xuatHopDong(dstk);
                                }
                                break;
                            case 3:
                                MENU.xuatHopDong(DANHSACHNHANVIEN.listNhanVien);
                                System.out.print("Nhap ngay bat dau hop dong can tim -> ");
                                int ngay = (int) CHECK.kiemTraSoNguyenDuong();
                                System.out.print("Nhap thang bat dau hop dong can tim -> ");
                                int thang = (int) CHECK.kiemTraSoNguyenDuong();
                                System.out.print("Nhap nam bat dau hop dong can tim -> ");
                                int nam = (int) CHECK.kiemTraSoNguyenDuong();
                                for (NHANVIEN i : DANHSACHNHANVIEN.listNhanVien) {
                                    if (i.getHopDong().getNgayBatDauHopDong().getNgay() == ngay && i.getHopDong().getNgayBatDauHopDong().getThang() == thang && i.getHopDong().getNgayBatDauHopDong().getNam() == nam) {
                                        dstk.add(i);
                                    }
                                }
                                if (dstk.isEmpty()) {
                                    System.out.println("KHONG TIM THAY HOP DONG");
                                } else {
                                    System.out.println("DANH SACH HOP DONG CAN TIM");
                                    MENU.xuatHopDong(dstk);
                                }
                                break;
                            case 4:
                                MENU.xuatHopDong(DANHSACHNHANVIEN.listNhanVien);
                                System.out.print("Nhap ngay ket thuc hop dong can tim -> ");
                                int ngay1 = (int) CHECK.kiemTraSoNguyenDuong();
                                System.out.print("Nhap thang ket thuc hop dong can tim -> ");
                                int thang1 = (int) CHECK.kiemTraSoNguyenDuong();
                                System.out.print("Nhap nam ket thuc hop dong can tim -> ");
                                int nam1 = (int) CHECK.kiemTraSoNguyenDuong();
                                for (NHANVIEN i : DANHSACHNHANVIEN.listNhanVien) {
                                    if (i.getHopDong().getNgayKetThucHopDong().getNgay() == ngay1 && i.getHopDong().getNgayKetThucHopDong().getThang() == thang1 && i.getHopDong().getNgayKetThucHopDong().getNam() == nam1) {
                                        dstk.add(i);
                                    }
                                }
                                if (dstk.isEmpty()) {
                                    System.out.println("KHONG TIM THAY HOP DONG");
                                } else {
                                    System.out.println("DANH SACH HOP DONG CAN TIM");
                                    MENU.xuatHopDong(dstk);
                                }
                                break;
                            case 5:
                                MENU.xuatHopDong(DANHSACHNHANVIEN.listNhanVien);
                                System.out.print("Nhap vao khoang thoi han can tim (Nhap vao 1 khoang)-> ");
                                int khoang1 = (int) CHECK.kiemTraSoNguyenDuong();
                                int khoang2 = (int) CHECK.kiemTraSoNguyenDuong();
                                for (NHANVIEN i : DANHSACHNHANVIEN.listNhanVien) {
                                    if (i.getHopDong().getThoiHanHopDong() >= khoang1 && i.getHopDong().getThoiHanHopDong() <= khoang2) {
                                        dstk.add(i);
                                    }
                                }
                                if (dstk.isEmpty()) {
                                    System.out.println("KHONG TIM THAY HOP DONG");
                                } else {
                                    System.out.println("DANH SACH HOP DONG CAN TIM");
                                    MENU.xuatHopDong(dstk);
                                }
                                break;
                            case 6:
                                kt_4 = false;
                                break;
                            case 7:
                                System.out.println("Thoat chuong trinh thanh cong!");
                                return;
                            default:
                                System.out.println("Nhap sai! Moi nhap lai");
                        }
                    }
                    break;
                case 5:
                    kt = false;
                    break;
                case 6:
                    System.out.println("Thoat chuong trinh thanh cong!");
                    return;
                default:
                    System.out.println("Nhap sai! Moi nhap lai");
            }
        }
    }
}
