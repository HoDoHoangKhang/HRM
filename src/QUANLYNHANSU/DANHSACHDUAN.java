package QUANLYNHANSU;

import java.util.ArrayList;

public class DANHSACHDUAN {

    public static ArrayList<DUAN> listDuAn = new ArrayList<>();

    public static void menu() {
        boolean kt = true;
        while (kt) {
            MENU.menu_D();
            int chon = (int) CHECK.kiemTraSoNguyenDuong();
            switch (chon) {
                case 1:
                    MENU.xuatDuAn(listDuAn);
                    System.out.print("Enter de tiep tuc ");
                    String t = Main.st.nextLine();
                    break;
                case 2:
                    System.out.print("Nhap so luong du an muon them -> ");
                    int n = (int) CHECK.kiemTraSoNguyenDuong();
                    for (int i = 1; i <= n; i++) {
                        System.out.println("Nhap vao du an thu " + i + " -> ");
                        DUAN du = new DUAN();
                        du.nhapDuAn();
                        listDuAn.add(du);
                        File.ghiFileDuAn();
                    }
                    break;
                case 3:
                    boolean kt_3 = true;
                    while (kt_3) {
                        ArrayList<DUAN> dstk = new ArrayList<>();
                        MENU.menu_D_3();
                        int chon_D_3 = (int) CHECK.kiemTraSoNguyenDuong();
                        switch (chon_D_3) {
                            case 1:
                                System.out.print("Nhap vao ma du an can tim -> ");
                                String timKiemTheoMaDuAn = Main.st.nextLine();
                                timKiemTheoMaDuAn = CHECK.inHoaTatCaKyTu(timKiemTheoMaDuAn);
                                for (DUAN i : listDuAn) {
                                    if (i.getMaDuAn().contains(timKiemTheoMaDuAn)) {
                                        dstk.add(i);
                                    }
                                }
                                if (dstk.isEmpty()) {
                                    System.out.println("KHONG TIM THAY DU AN");
                                } else {
                                    System.out.println("DANH SACH DU AN CAN TIM");
                                    MENU.xuatDuAn(dstk);
                                }
                                break;
                            case 2:
                                System.out.print("Nhap vao ten du an can tim -> ");
                                String timKiemTheoTenDuAn = CHECK.kiemTraHoTen();
                                timKiemTheoTenDuAn = CHECK.inHoaTatCaKyTu(timKiemTheoTenDuAn);
                                for (DUAN i : listDuAn) {
                                    if (CHECK.inHoaTatCaKyTu(i.getTenDuAn()).contains(timKiemTheoTenDuAn)) {
                                        dstk.add(i);
                                    }
                                }
                                if (dstk.isEmpty()) {
                                    System.out.println("KHONG TIM THAY DU AN");
                                } else {
                                    System.out.println("DANH SACH DU AN CAN TIM");
                                    MENU.xuatDuAn(dstk);
                                }
                                break;
                            case 3:
                                System.out.print("Nhap ngay bat dau du can tim -> ");
                                int ngay = (int) CHECK.kiemTraSoNguyenDuong();
                                System.out.print("Nhap thang bat dau du an can tim -> ");
                                int thang = (int) CHECK.kiemTraSoNguyenDuong();
                                System.out.print("Nhap nam bat dau du an can tim -> ");
                                int nam = (int) CHECK.kiemTraSoNguyenDuong();
                                for (DUAN i : listDuAn) {
                                    if (i.getNgayBatDauDuAn().getNgay() == ngay && i.getNgayBatDauDuAn().getThang() == thang && i.getNgayBatDauDuAn().getNam() == nam) {
                                        dstk.add(i);
                                    }
                                }
                                if (dstk.isEmpty()) {
                                    System.out.println("KHONG TIM THAY DU AN");
                                } else {
                                    System.out.println("DANH SACH DU AN CAN TIM");
                                    MENU.xuatDuAn(dstk);
                                }
                                break;
                            case 4:
                                System.out.print("Nhap ngay ket thuc hop dong can tim -> ");
                                int ngay1 = (int) CHECK.kiemTraSoNguyenDuong();
                                System.out.print("Nhap thang ket thuc hop dong can tim -> ");
                                int thang1 = (int) CHECK.kiemTraSoNguyenDuong();
                                System.out.print("Nhap nam ket thuc hop dong can tim -> ");
                                int nam1 = (int) CHECK.kiemTraSoNguyenDuong();
                                for (DUAN i : listDuAn) {
                                    if (i.getNgayKetThucDuAn().getNgay() == ngay1 && i.getNgayKetThucDuAn().getThang() == thang1 && i.getNgayKetThucDuAn().getNam() == nam1) {
                                        dstk.add(i);
                                    }
                                }
                                if (dstk.isEmpty()) {
                                    System.out.println("KHONG TIM THAY DU AN");
                                } else {
                                    System.out.println("DANH SACH DU AN CAN TIM");
                                    MENU.xuatDuAn(dstk);
                                }
                                break;
                            case 5:
                                System.out.print("Nhap vao khoang thoi han can tim (Nhap vao 1 khoang)-> ");
                                int khoang1 = (int) CHECK.kiemTraSoNguyenDuong();
                                int khoang2 = (int) CHECK.kiemTraSoNguyenDuong();
                                for (DUAN i : listDuAn) {
                                    if (i.getThoiHanDuAn() >= khoang1 && i.getThoiHanDuAn() <= khoang2) {
                                        dstk.add(i);
                                    }
                                }
                                if (dstk.isEmpty()) {
                                    System.out.println("KHONG TIM THAY DU AN");
                                } else {
                                    System.out.println("DANH SACH DU AN CAN TIM");
                                    MENU.xuatDuAn(dstk);
                                }
                                break;
                            case 6:
                                kt_3 = false;
                                break;
                            case 7:
                                System.out.println("Thoat chuong trinh thanh cong!");
                                return;
                            default:
                                System.out.println("Nhap sai! Moi nhap lai");
                        }
                    }
                    break;
                case 4:
                    MENU.xuatDuAn(listDuAn);
                    boolean kt1 = true;
                    while (kt1) {
                        System.out.print("Ma du an can xoa -> ");
                        String xoaMaDuAn = Main.st.nextLine();
                        if (CHECK.kiemTraMaDuAnTonTai(xoaMaDuAn)) {
                            for (DUAN i : listDuAn) {
                                if (i.getMaDuAn().equalsIgnoreCase(xoaMaDuAn)) {
                                    listDuAn.remove(i);
                                    break;
                                }
                            }
                            kt1 = false;
                        } else {
                            System.out.println("Ma du an khong ton tai\nMoi nhap lai");
                        }
                    }
                    System.out.println("DANH SACH DU AN SAU KHI XOA");
                    MENU.xuatDuAn(listDuAn);
                    File.ghiFileDuAn();
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
