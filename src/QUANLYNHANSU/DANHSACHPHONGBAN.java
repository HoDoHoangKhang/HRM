package QUANLYNHANSU;

import java.util.ArrayList;

public class DANHSACHPHONGBAN {

    public static ArrayList<PHONGBAN> listPhongBan = new ArrayList<>();

    public static void menu() {
        boolean kt = true;
        while (kt) {
            // cập nhật số lượng nhân viên từng phòng và lương từng phòng
            for (PHONGBAN i : DANHSACHPHONGBAN.listPhongBan) {
                i.setLuongHangThang(0.0);
                i.setSoLuongNhanVien(0);
                for (NHANVIEN j : DANHSACHNHANVIEN.listNhanVien) {
                    if (j instanceof NHANVIENCHINH && ((NHANVIENCHINH) j).getMaPhongBan().equalsIgnoreCase(i.getMaPhongBan())) {
                        i.setSoLuongNhanVien(i.getSoLuongNhanVien() + 1);
//						i.setLuongHangThang(i.getLuongHangThang()+((NHANVIENCHINH) j).getLuong().getLuong());
                        File.ghiFilePhongBan();
                    }
                }
            }
            ArrayList<NHANVIEN> dstk = new ArrayList<>();
            MENU.menu_B();
            int chon = (int) CHECK.kiemTraSoNguyenDuong();
            switch (chon) {
                case 1:
                    MENU.xuatToanBoPhongBan(listPhongBan);
                    System.out.println("Enter de tiep tuc ");
                    String t = Main.st.nextLine();
                    break;
                case 2:
                    System.out.println("Nhap so luong phong ban muon them -> ");
                    int n = (int) CHECK.kiemTraSoNguyenDuong();
                    for (int i = 1; i <= n; i++) {
                        System.out.println("Nhap vao du an thu " + i + " -> ");
                        PHONGBAN pb = new PHONGBAN();
                        pb.nhapPhongBan();
                        listPhongBan.add(pb);
                        File.ghiFilePhongBan();
                    }
                    break;
                //SỬA TÊN PHÒNG BAN
                case 3:
                    System.out.println("Nhap ma phong ban muon doi ten -> ");
                    String maPhongBan = CHECK.nhapMaPhongBan();
                    for (PHONGBAN i : listPhongBan) {
                        if (i.getMaPhongBan().equalsIgnoreCase(maPhongBan)) {
                            System.out.println("THONG TIN PHONG BAN BAN CHON !");
                            i.xuatPhongBan();
                            System.out.println("Nhap vao ten moi cho phong ban -> ");
                            String suaTenPhongBan = CHECK.kiemTraChuoiKyTu();
                            i.setTenPhongBan(suaTenPhongBan);
                            System.out.println("SUA THANH CONG TEN PHONG BAN!");
                            i.xuatPhongBan();
                            File.ghiFilePhongBan();
                            break;
                        }
                    }
                    break;
                // BỔ NHIỆM TRƯỞNG PHÒNG CHO PHÒNG BAN (các nhân viên có chức vụ chuyên viên hoặc quản lý mới được bổ nhiệm)
                case 4:
                    MENU.xuatToanBoPhongBan(listPhongBan);
                    System.out.println("Nhap vao ma phong ban can bo nhiem lam truong phong -> ");
                    String maPb = CHECK.nhapMaPhongBan();
                    for (NHANVIEN i : DANHSACHNHANVIEN.listNhanVien) {
                        if ((i instanceof NHANVIENCHINH && i.getChucVu().equalsIgnoreCase("Chuyen Vien") || i.getChucVu().equalsIgnoreCase("Quan Ly")) && ((NHANVIENCHINH) i).getMaPhongBan().equalsIgnoreCase(maPb)) {
                            dstk.add(i);
                        }
                    }
                    if (dstk.isEmpty()) {
                        System.out.println("KHONG TIM THAY CHUYEN VIEN HAY QUAN LY NAO TRONG PHONG BAN " + maPb);
                        break;
                    } else {
                        MENU.xuatToanBoNhanVien(dstk);
                        System.out.println("Nhap vao ma nhan vien can bo nhiem truong phong -> ");
                        boolean kt_4 = true;
                        while (kt_4) {
                            String maNhanVien = CHECK.kiemTraMaNhanVien(1);
                            if (CHECK.kiemTraMaNhanVienTonTai(maNhanVien, dstk)) {
                                for (NHANVIEN i : DANHSACHNHANVIEN.listNhanVien) {
                                    if (i.getMaNhanVien().equalsIgnoreCase(maNhanVien)) {
                                        i.setChucVu("Truong Phong");
                                        for (PHONGBAN j : listPhongBan) {
                                            if (j.getMaPhongBan().equalsIgnoreCase(maPb)) {
                                                j.setMaTruongPhong(i.getMaNhanVien());
                                                j.setTenTruongPhong(i.getHoTen());
                                                MENU.xuatToanBoPhongBan(listPhongBan);
                                                File.ghiFilePhongBan();
                                                File.ghiFileNhanVien();
                                                break;
                                            }
                                        }
                                        break;
                                    } else if (i.getChucVu().equalsIgnoreCase("Truong Phong")) {
                                        i.setChucVu("Chuyen Vien");
                                    }
                                }
                                kt_4 = false;
                            } else {
                                System.out.println("Ma nhan vien da ton tai moi nhap lai -> ");
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("Nhap ma phong ban can hien thi danh sach nhan vien -> ");
                    String maPB = CHECK.nhapMaPhongBan();
                    for (NHANVIEN i : DANHSACHNHANVIEN.listNhanVien) {
                        if (i instanceof NHANVIENCHINH && ((NHANVIENCHINH) i).getMaPhongBan().equalsIgnoreCase(maPB)) {
                            dstk.add(i);
                        }
                    }
                    if (dstk.isEmpty()) {
                        System.out.println("KHONG TIM THAY NHAN VIEN NAO TRONG PHONG CO MA " + maPB);
                    } else {
                        MENU.xuatToanBoNhanVien(dstk);
                    }
                    break;
                case 6:
                    System.out.println("THONG TIN TOAN BO TRUONG PHONG");
                    for (NHANVIEN i : DANHSACHNHANVIEN.listNhanVien) {
                        if (i.getChucVu().equalsIgnoreCase("Truong Phong")) {
                            dstk.add(i);
                        }
                    }
                    if (dstk.isEmpty()) {
                        System.out.println("KHONG TIM TRUONG PHONG NAO");
                    } else {
                        MENU.xuatTruongPhong(dstk);
                    }
                    break;
                case 7:
                    System.out.println("Thoat chuong trinh thanh cong!");
                    return;
                default:
                    System.out.println("Nhap sai! Moi nhap lai");
            }
        }
    }
}
