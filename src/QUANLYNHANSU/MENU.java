package QUANLYNHANSU;

import java.util.ArrayList;

public class MENU {

    public static void xuatToanBoNhanVien(ArrayList<NHANVIEN> list) {
        System.out.println();
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                                                                                                                    DANH SACH NHAN VIEN                                                                                                                                                   |");
        System.out.println("+--------------+--------------------------------+------------+-----------+---------------+-----------------------------------------------+-----------------+------------+------------+--------------------+------+-------------------------------------+---------------+-------+-----------------------+-------------------+");
        System.out.printf("| %-12s | %-30s | %10s | %-9s | %-13s | %-45s | %-15s | %10s | %10s | %-18s | %-4s | %-35s | %-13s | "
                + "%-5s | %-21s | %-17s |\n", "Ma nhan vien", "Ho va ten", "Ngay sinh", "Gioi tinh", "So dien thoai", "Dia chi", "Chuc vu", 
                "Ngay BDHD", "Ngay KTHD", "Luong co ban (VND)", "HSL", "Email", "Phu cap (VND)", "Ma PB", "So du an da thuc hien", "Ma du an dang lam");
        System.out.println("+--------------+--------------------------------+------------+-----------+---------------+-----------------------------------------------+-----------------+------------+------------+--------------------+------+-------------------------------------+---------------+-------+-----------------------+-------------------+");
        for (NHANVIEN i : list) {
            if (i instanceof NHANVIENCHINH nvc) {
                System.out.printf("| %-12s | %-30s | %10s | %-9s | %-13s | %-45s | %-15s | %10s | %10s | %18s | %-4s | %-35s | %13s | "
                        + "%-5s | %-21s | %-17s |\n", i.getMaNhanVien(), i.getHoTen(), i.getNgaySinh(), i.getGioiTinh(),
                        i.getSoDienThoai(), nvc.diaChi.toString(), i.getChucVu(), i.getHopDong().getNgayBatDauHopDong(),
                        i.getHopDong().getNgayKetThucHopDong(), CHECK.changeMoney(nvc.getLuongCoBan()), nvc.getHeSoLuong(),
                        nvc.getEmail(), "None", nvc.getMaPhongBan(), nvc.getSoDuAnDaThucHien(), nvc.getMaDuAnDangLam());
            } else if (i instanceof THUCTAPSINH tts) {
                System.out.printf("| %-12s | %-30s | %10s | %-9s | %-13s | %-45s | %-15s | %10s | %10s | %18s | %-4s | %-35s | %13s | "
                        + "%-5s | %-21s | %-17s |\n", i.getMaNhanVien(), i.getHoTen(), i.getNgaySinh(), i.getGioiTinh(), i.getSoDienThoai(),
                        tts.diaChi.toString(), i.getChucVu(), i.getHopDong().getNgayBatDauHopDong(), i.getHopDong().getNgayKetThucHopDong(),
                        "None", "None", tts.getEmail(), CHECK.changeMoney(tts.getPhuCap()), tts.getMaPhongBan(), "None", "None");
            } else {
                System.out.printf("| %-12s | %-30s | %10s | %-9s | %-13s | %-45s | %-15s | %10s | %10s | %18s | %-4s | %-35s | %13s | "
                        + "%-5s | %-21s | %-17s |\n", i.getMaNhanVien(), i.getHoTen(), i.getNgaySinh(), i.getGioiTinh(), i.getSoDienThoai(),
                        i.diaChi.toString(), i.getChucVu(), i.getHopDong().getNgayBatDauHopDong(), i.getHopDong().getNgayKetThucHopDong(),
                        CHECK.changeMoney(((NHANVIENPHU) i).getLuongCoBan()), ((NHANVIENPHU) i).getHeSoLuong(), "None", "None", "None", "None", "None");
            }
        }
        System.out.println("+--------------+--------------------------------+------------+-----------+---------------+-----------------------------------------------+-----------------+------------+------------+--------------------+------+-------------------------------------+---------------+-------+-----------------------+-------------------+");
    }

    public static void xuatNhanVienChinh(ArrayList<NHANVIEN> list) {
        System.out.println();
        System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                                                                                                         DANH SACH NHAN VIEN CHINH                                                                                                                                        |");
        System.out.println("+--------------+--------------------------------+------------+-----------+---------------+-----------------------------------------------+-----------------+------------+------------+--------------------+------+-------------------------------------+-------+-----------------------+-------------------+");
        System.out.printf("| %-12s | %-30s | %10s | %-9s | %-13s | %-45s | %-15s | %10s | %10s | %-18s | %-4s | %-35s | %-5s | %-21s | %-17s |\n",
                "Ma nhan vien", "Ho va ten", "Ngay sinh", "Gioi tinh", "So dien thoai", "Dia chi", "Chuc vu", "Ngay BDHD",
                "Ngay KTHD", "Luong co ban (VND)", "HSL", "Email", "Ma PB", "So du an da thuc hien", "Ma du an dang lam");
        System.out.println("+--------------+--------------------------------+------------+-----------+---------------+-----------------------------------------------+-----------------+------------+------------+--------------------+------+-------------------------------------+-------+-----------------------+-------------------+");
        for (NHANVIEN i : list) {
            if (i instanceof NHANVIENCHINH nvc) {
                System.out.printf("| %-12s | %-30s | %10s | %-9s | %-13s | %-45s | %-15s | %10s | %10s | %18s | %-4s | %-35s | %-5s | %-21s | %-17s |\n",
                        i.getMaNhanVien(), i.getHoTen(), i.getNgaySinh(), i.getGioiTinh(), i.getSoDienThoai(), i.diaChi.toString(),
                        i.getChucVu(), i.getHopDong().getNgayBatDauHopDong(), i.getHopDong().getNgayKetThucHopDong(),
                        CHECK.changeMoney(nvc.getLuongCoBan()), nvc.getHeSoLuong(), nvc.getEmail(),
                        nvc.getMaPhongBan(), nvc.getSoDuAnDaThucHien(), nvc.getMaDuAnDangLam());
            }
        }
        System.out.println("+--------------+--------------------------------+------------+-----------+---------------+-----------------------------------------------+-----------------+------------+------------+--------------------+------+-------------------------------------+-------+-----------------------+-------------------+");
    }

    public static void xuatThucTapSinh(ArrayList<NHANVIEN> list) {
        System.out.println();
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                                                                             DANH SACH THUC TAP SINH                                                                                                              |");
        System.out.println("+--------------+--------------------------------+------------+-----------+---------------+-----------------------------------------------+-----------------+------------+------------+-------------------------------------+---------------+-------+");
        System.out.printf("| %-12s | %-30s | %10s | %-9s | %-13s | %-45s | %-15s | %10s | %10s | %-35s | %-13s | %-5s |\n",
                "Ma nhan vien", "Ho va ten", "Ngay sinh", "Gioi tinh", "So dien thoai", "Dia chi", "Chuc vu", "Ngay BDHD", "Ngay KTHD",
                "Email", "Phu cap (VND)", "Ma PB");
        System.out.println("+--------------+--------------------------------+------------+-----------+---------------+-----------------------------------------------+-----------------+------------+------------+-------------------------------------+---------------+-------+");
        for (NHANVIEN i : list) {
            if (i instanceof THUCTAPSINH tts) {
                System.out.printf("| %-12s | %-30s | %-10s | %-9s | %-13s | %-45s | %-15s | %10s | %10s | %-35s | %13s | %-5s |\n",
                        i.getMaNhanVien(), i.getHoTen(), i.getNgaySinh(), i.getGioiTinh(), i.getSoDienThoai(), i.diaChi.toString(),
                        i.getChucVu(), i.getHopDong().getNgayBatDauHopDong(), i.getHopDong().getNgayKetThucHopDong(),
                        tts.getEmail(), CHECK.changeMoney(tts.getPhuCap()), tts.getMaPhongBan());
            }
        }
        System.out.println("+--------------+--------------------------------+------------+-----------+---------------+-----------------------------------------------+-----------------+------------+------------+-------------------------------------+---------------+-------+");
    }

    public static void xuatNhanVienPhu(ArrayList<NHANVIEN> list) {
        System.out.println("");
        System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                                                             DANH SACH NHAN VIEN PHU                                                                                            |");
        System.out.println("+--------------+--------------------------------+------------+-----------+---------------+-----------------------------------------------+-----------------+------------+------------+--------------------+------+");
        System.out.printf("| %-12s | %-30s | %10s | %-9s | %-13s | %-45s | %-15s | %10s | %10s | %-18s | %-4s |\n",
                "Ma nhan vien", "Ho va ten", "Ngay sinh", "Gioi tinh", "So dien thoai", "Dia chi", "Chuc vu",
                "Ngay BDHD", "Ngay KTHD", "Luong co ban (VND)", "HSL");
        System.out.println("+--------------+--------------------------------+------------+-----------+---------------+-----------------------------------------------+-----------------+------------+------------+--------------------+------+");
        for (NHANVIEN i : list) {
            if (i instanceof NHANVIENPHU nvp) {
                System.out.printf("| %-12s | %-30s | %10s | %-9s | %-13s | %-45s | %-15s | %10s | %10s | %18s | %-4s |\n",
                        i.getMaNhanVien(), i.getHoTen(), i.getNgaySinh(), i.getGioiTinh(), i.getSoDienThoai(),
                        i.diaChi.toString(), i.getChucVu(), i.getHopDong().getNgayBatDauHopDong(),
                        i.getHopDong().getNgayKetThucHopDong(), CHECK.changeMoney(nvp.getLuongCoBan()), nvp.getHeSoLuong());
            }
        }
        System.out.println("+--------------+--------------------------------+------------+-----------+---------------+-----------------------------------------------+-----------------+------------+------------+--------------------+------+");
    }

    public static void xuatToanBoPhongBan(ArrayList<PHONGBAN> list) {
        System.out.println();
        System.out.println("+----------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                      DANH SACH PHONG BAN                                                               |");
        System.out.println("+---------------+--------------------+--------------------+--------------------+--------------------+------------------------------------+");
        System.out.printf("|%-15s|%-20s|%-20s|%-20s|%-20s|%-36s|\n", "Ma phong ban", "Ma Truong Phong", "Ten Truong Phong", "So Luong Nhan Vien", "Ten Phong Ban", "Luong Toan Bo Phong Ban (Trieu dong)");
        System.out.println("+---------------+--------------------+--------------------+--------------------+--------------------+------------------------------------+");
        for (PHONGBAN i : list) {
            System.out.printf("|%-15s|%-20s|%-20s|%-20s|%-20s|%-36s|\n", i.getMaPhongBan(), i.getMaTruongPhong(), i.getTenTruongPhong(), i.getSoLuongNhanVien(), i.getTenPhongBan(), i.getLuongHangThang());
        }
        System.out.println("+---------------+--------------------+--------------------+--------------------+--------------------+------------------------------------+");
    }

    public static void xuatTruongPhong(ArrayList<NHANVIEN> list) {
        System.out.println();
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                                                                                      DANH SACH TRUONG PHONG                                                                                                                                                    |");
        System.out.println("+-----+-----+--------------------+---------------+----------+-----------+---------------------------------------------+---------------+---------------+---------------+---------------+-----+-----------------+-----------------------------------+-------------------------+--------------------+");
        System.out.printf("|%-5s|%-5s|%-20s|%-15s|%-10s|%-11s|%-45s|%-15s|%-15s|%-15s|%-15s|%-5s|%-17s|%-35s|%-25s|%-20s|\n", "Ma", "Ma PB", "Ho Ten", "Ngay Sinh", "Gioi tinh", "SDT", "Dia chi", "Chuc vu", "Ngay BDHD", "Ngay KTHD", "Luong CB", "HSL", "Luog chinh thuc", "Email", "So du an da thuc hien", "Ma du an dang lam");
        System.out.println("+-----+-----+--------------------+---------------+----------+-----------+---------------------------------------------+---------------+---------------+---------------+---------------+-----+-----------------+-----------------------------------+-------------------------+--------------------+");
        for (NHANVIEN i : list) {
            if (i instanceof NHANVIENCHINH) {
                System.out.printf("|%-5s|%-5s|%-20s|%-15s|%-10s|%-11s|%-45s|%-15s|%-15s|%-15s|%-15s|%-5s|%-35s|%-25s|%-20s|\n", i.getMaNhanVien(), ((NHANVIENCHINH) i).getMaPhongBan(), i.getHoTen(), i.getNgaySinh(), i.getGioiTinh(), i.getSoDienThoai(), i.getDiaChi(), i.getChucVu(), i.getHopDong().getNgayBatDauHopDong(), i.getHopDong().getNgayKetThucHopDong(), ((NHANVIENCHINH) i).getLuongCoBan(), ((NHANVIENCHINH) i).getHeSoLuong(), ((NHANVIENCHINH) i).getEmail(), ((NHANVIENCHINH) i).getSoDuAnDaThucHien(), ((NHANVIENCHINH) i).getMaDuAnDangLam());
            }
        }
        System.out.println("+-----+-----+--------------------+---------------+----------+-----------+---------------------------------------------+---------------+---------------+---------------+---------------+-----+-----------------+-----------------------------------+-------------------------+--------------------+");
    }

    public static void xuatHopDong(ArrayList<NHANVIEN> list) {
        System.out.println();
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                          DANH SACH HOP DONG                                                  |");
        System.out.println("+-----+--------------------+---------------+---------------+-------------------------+---------------+-------------------------+");
        System.out.printf("|%-5s|%-20s|%-15s|%-15s|%-25s|%-15s|%-25s|\n", "Ma", "Ho Ten", "Chuc Vu", "Ngay BDHD", "Thoi Han Hop Dong(Thang)", "Ngay KTHD", "Thoi Gian Con Lai(Thang)");
        System.out.println("+-----+--------------------+---------------+---------------+-------------------------+---------------+-------------------------+");
        for (NHANVIEN i : list) {
            System.out.printf("|%-5s|%-20s|%-15s|%-15s|%-25s|%-15s|%-25s|\n", i.getMaNhanVien(), i.getHoTen(), i.getChucVu(), i.getHopDong().getNgayBatDauHopDong(), i.getHopDong().getThoiHanHopDong(), i.getHopDong().getNgayKetThucHopDong(), i.getHopDong().getThoiGianConLaiHopDong());
        }
        System.out.println("+-----+--------------------+---------------+---------------+-------------------------+---------------+-------------------------+");
    }

    public static void xuatHopDongConLai1Thang(ArrayList<NHANVIEN> list) {
        System.out.println();
        System.out.println("+------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                             DANH SACH HOP DONG CON LAI 1 THANG                                               |");
        System.out.println("+-----+--------------------+---------------+---------------+-------------------------+---------------+-------------------------+");
        System.out.printf("|%-5s|%-20s|%-15s|%-15s|%-25s|%-15s|%-25s|\n", "Ma", "Ho Ten", "Chuc Vu", "Ngay BDHD", "Thoi Han Hop Dong(Thang)", "Ngay KTHD", "Thoi Gian Con Lai(Thang)");
        System.out.println("+-----+--------------------+---------------+---------------+-------------------------+---------------+-------------------------+");
        for (NHANVIEN i : list) {
            if (i.getHopDong().getThoiGianConLaiHopDong() == 1) {
                System.out.printf("|%-5s|%-20s|%-15s|%-15s|%-25s|%-15s|%-25s|\n", i.getMaNhanVien(), i.getHoTen(), i.getChucVu(), i.getHopDong().getNgayBatDauHopDong(), i.getHopDong().getThoiHanHopDong(), i.getHopDong().getNgayKetThucHopDong(), i.getHopDong().getThoiGianConLaiHopDong());
            }
        }
        System.out.println("+-----+--------------------+---------------+---------------+-------------------------+---------------+-------------------------+");
    }

    public static void xuatDuAn(ArrayList<DUAN> list) {
        System.out.println();
        System.out.println("+-------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                           DANH SACH DU AN                                                     |");
        System.out.println("+----------+-------------------------+--------------------------------+---------------+-------------------------+---------------+");
        System.out.printf("|%-10s|%-25s|%-32s|%-15s|%-25s|%-15s|\n", "Ma Du An", "Ten Du An", "Kinh Phi Thuc Hien(Trieu dong)", "Ngay BDDA", "Thoi Han Du An(Thang)", "Ngay KTDA");
        System.out.println("+----------+-------------------------+--------------------------------+---------------+-------------------------+---------------+");
        for (DUAN i : list) {
            System.out.printf("|%-10s|%-25s|%-32s|%-15s|%-25s|%-15s|\n", i.getMaDuAn(), i.getTenDuAn(), i.getKinhPhiThucHien(), i.getNgayBatDauDuAn(), i.getThoiHanDuAn(), i.getNgayKetThucDuAn());
        }
        System.out.println("+----------+-------------------------+--------------------------------+---------------+-------------------------+---------------+");
    }

    public static void menu_QLNS() {
        System.out.println();
        System.out.println("+-----------------------------+");
        System.out.println("|       QUAN LY NHAN SU       |");
        System.out.println("+-----------------------------+");
        System.out.println("| 1. QUAN LY NHAN VIEN        |");
        System.out.println("| 2. QUAN LY PHONG BAN        |");
        System.out.println("| 3. QUAN LY HOP DONG         |");
        System.out.println("| 4. QUAN LY DU AN            |");
        System.out.println("| 5. QUAN LY CHAM CONG        |");
        System.out.println("| 6. QUAN LY LUONG            |");
        System.out.println("| 7. QUAN LY THAN NHAN        |");
        System.out.println("| 8. THOAT CHUONG TRINH       |");
        System.out.println("+-----------------------------+");
        System.out.print("- Moi ban nhap lua chon -> ");
    }

    public static void menu_B() {
        System.out.println();
        System.out.println("+--------------------------------------------------------+");
        System.out.println("|                    QUAN LY PHONG BAN                   |");
        System.out.println("+--------------------------------------------------------+");
        System.out.println("| 1. Hien thi toan bo phong ban                          |");
        System.out.println("| 2. Them phong ban                                      |");
        System.out.println("| 3. Sua ten phong ban                                   |");
        System.out.println("| 4. Bo nhiem truong phong cho phong ban                 |");
        System.out.println("| 5. Hien nhan vien cua phong ban                        |");
        System.out.println("| 6. Hien thi thong tin truong phong                     |");
        System.out.println("| 7. Quay ve menu chinh                                  |");
        System.out.println("| 8. Thoat quan ly phong ban                             |");
        System.out.println("+--------------------------------------------------------+");
        System.out.print("- Moi ban nhap lua chon -> ");
    }
//	public static void menu_B() {
//		System.out.println("+-------------------------------------------+");
//		System.out.println("|              QUAN LY PHONG BAN            |");
//		System.out.println("+-------------------------------------------+");
//		System.out.println("| 1. Hien thi toan bo phong ban             |");
//		System.out.println("| 2. Bo nhiem truong phong cho phong ban    |");
//		System.out.println("| 3. Hien nhan vien cua phong ban           |");
//		System.out.println("| 4. Hien thi thong tin truong phong        |");
//		System.out.println("| 5. Quay ve menu chinh                     |");
//		System.out.println("| 6. Thoat chuong trinh quan ly phong ban   |");
//		System.out.println("+-------------------------------------------+");
//		System.out.println("- Moi ban nhap lua chon -> ");
//	}

    public static void menu_C() {
        System.out.println("+--------------------------------------------------------+");
        System.out.println("|                      QUAN LY HOP DONG                  |");
        System.out.println("+--------------------------------------------------------+");
        System.out.println("| 1. Hien thi toan bo hop dong                           |");
        System.out.println("| 2. Hien thi cac hop dong sap het han(con lai 1 thang)  |");
        System.out.println("| 3. Gia han hop dong                                    |");
        System.out.println("| 4. Tim kiem hop dong                                   |");
        System.out.println("| 5. Quay ve menu chinh                                  |");
        System.out.println("| 6. Thoat quan ly hop dong                              |");
        System.out.println("+--------------------------------------------------------+");
        System.out.print("- Moi ban nhap lua chon -> ");
    }

    public static void menu_D() {
        System.out.println();
        System.out.println("+--------------------------------------------------------+");
        System.out.println("|                      QUAN LY DU AN                     |");
        System.out.println("+--------------------------------------------------------+");
        System.out.println("| 1. Hien thi toan bo du an                              |");
        System.out.println("| 2. Them du an                                          |");
        System.out.println("| 3. Tim kiem du an                                      |");
        System.out.println("| 4. Xoa du an                                           |");
        System.out.println("| 5. Quay ve menu chinh                                  |");
        System.out.println("| 6. Thoat quan ly du an                                 |");
        System.out.println("+--------------------------------------------------------+");
        System.out.print("- Moi ban nhap lua chon -> ");
    }

    public static void menu_E() {
        System.out.println();
        System.out.println("+--------------------------------------------------------+");
        System.out.println("|                    QUAN LY THAN NHAN                   |");
        System.out.println("+--------------------------------------------------------+");
        System.out.println("| 1. Hien thi toan bo du an                              |");
        System.out.println("| 2. Them du an                                          |");
        System.out.println("| 3. Tim kiem du an                                      |");
        System.out.println("| 4. Xoa du an                                           |");
        System.out.println("| 5. Quay ve menu chinh                                  |");
        System.out.println("| 6. Thoat quan ly du an                                 |");
        System.out.println("+--------------------------------------------------------+");
        System.out.print("- Moi ban nhap lua chon -> ");
    }

    public static void menu_D_3() {
        System.out.println();
        System.out.println("+--------------------------------------------------------+");
        System.out.println("|                   TIM KIEM DU AN                       |");
        System.out.println("+--------------------------------------------------------+");
        System.out.println("| 1. Tim theo ma du an                                   |");
        System.out.println("| 2. Tim theo ten du an                                  |");
        System.out.println("| 3. Tim theo ngay bat dau du an                         |");
        System.out.println("| 4. Tim theo ngay ket thuc du an                        |");
        System.out.println("| 5. Tim theo thoi han du an                             |");
        System.out.println("| 6. Quay tro ve                                         |");
        System.out.println("| 7. Thoat quan ly du an                                 |");
        System.out.println("+--------------------------------------------------------+");
        System.out.print("- Moi ban nhap lua chon -> ");
    }

    public static void menu_C_4() {
        System.out.println();
        System.out.println("+--------------------------------------------------------+");
        System.out.println("|                   TIM KIEM HOP DONG                    |");
        System.out.println("+--------------------------------------------------------+");
        System.out.println("| 1. Tim theo ma nhan vien                               |");
        System.out.println("| 2. Tim theo ten nhan vien                              |");
        System.out.println("| 3. Tim theo ngay bat dau hop dong                      |");
        System.out.println("| 4. Tim theo ngay ket thuc hop dong                     |");
        System.out.println("| 5. Tim theo thoi han hop dong                          |");
        System.out.println("| 6. Quay tro ve                                         |");
        System.out.println("| 7. Thoat quan ly hop dong                              |");
        System.out.println("+--------------------------------------------------------+");
        System.out.print("- Moi ban nhap lua chon -> ");
    }

    public static void menu_A() {
        System.out.println();
        System.out.println("+-----------------------------+");
        System.out.println("|      QUAN LY NHAN VIEN      |");
        System.out.println("+-----------------------------+");
        System.out.println("| 1. Them nhan vien           |");
        System.out.println("| 2. Xoa nhan vien            |");
        System.out.println("| 3. Sua nhan vien            |");
        System.out.println("| 4. Tim kiem nhan vien       |");
        System.out.println("| 5. Hien danh sach nhan vien |");
        System.out.println("| 6. Quay tro ve menu chinh   |");
        System.out.println("| 7. Thoat quan ly nhan vien  |");
        System.out.println("+-----------------------------+");
        System.out.print("- Moi ban nhap lua chon -> ");
    }

    public static void menu_A_1() {
        System.out.println();
        System.out.println("+----------------------------+");
        System.out.println("|       THEM NHAN VIEN       |");
        System.out.println("+----------------------------+");
        System.out.println("| 1. Them nhan vien chinh    |");
        System.out.println("| 2. Them nhan vien thuc tap |");
        System.out.println("| 3. Them nhan vien phu      |");
        System.out.println("| 4. Quay tro ve             |");
        System.out.println("| 5. Thoat quan ly nhan vien |");
        System.out.println("+----------------------------+");
        System.out.print("- Moi ban nhap lua chon -> ");
    }

    public static void menu_A_3_1() {
        System.out.println();
        System.out.println("+----------------------------+");
        System.out.println("|    SUA NHAN VIEN CHINH     |");
        System.out.println("+----------------------------+");
        System.out.println("| 1. Sua so dien thoai       |");
        System.out.println("| 2. Sua dia chi             |");
        System.out.println("| 3. Sua Email               |");
        System.out.println("| 4. Sua chuc vu             |");
        System.out.println("| 5. Sua luong co ban        |");
        System.out.println("| 6. Sua he so luong         |");
        System.out.println("| 7. Sua phong ban           |");
        System.out.println("| 8. Sua du an               |");
        System.out.println("| 9. Quay tro ve             |");
        System.out.println("| 10. Thoat quan ly nhan vien |");
        System.out.println("+----------------------------+");
        System.out.print("- Moi ban nhap lua chon -> ");
    }

    public static void menu_A_3_2() {
        System.out.println();
        System.out.println("+----------------------------+");
        System.out.println("|   SUA NHAN VIEN THUC TAP   |");
        System.out.println("+----------------------------+");
        System.out.println("| 1. Sua so dien thoai       |");
        System.out.println("| 2. Sua dia chi             |");
        System.out.println("| 3. Sua Email               |");
        System.out.println("| 4. Sua chuc vu             |");
        System.out.println("| 5. Sua phu cap             |");
        System.out.println("| 6. Sua phong ban           |");
        System.out.println("| 7. Quay tro ve             |");
        System.out.println("| 8. Thoat quan ly nhan vien |");
        System.out.println("+----------------------------+");
        System.out.print("- Moi ban nhap lua chon -> ");
    }

    public static void menu_A_3_3() {
        System.out.println();
        System.out.println("+----------------------------+");
        System.out.println("|      SUA NHAN VIEN PHU     |");
        System.out.println("+----------------------------+");
        System.out.println("| 1. Sua so dien thoai       |");
        System.out.println("| 2. Sua dia chi             |");
        System.out.println("| 3. Sua chuc vu             |");
        System.out.println("| 4. Sua luong co ban        |");
        System.out.println("| 5. Sua he so luong         |");
        System.out.println("| 6. Quay tro ve             |");
        System.out.println("| 7. Thoat quan ly nhan vien |");
        System.out.println("+----------------------------+");
        System.out.print("- Moi ban nhap lua chon -> ");
    }

    public static void menu_A_4() {
        System.out.println();
        System.out.println("+-------------------------------------+");
        System.out.println("|           TIM KIEM NHAN VIEN        |");
        System.out.println("+-------------------------------------+");
        System.out.println("| 1.  Tim theo ma nhan vien           |");
        System.out.println("| 2.  Tim theo ten nhan vien          |");
        System.out.println("| 3.  Tim theo dia chi                |");
        System.out.println("| 4.  Tim theo tuoi                   |");
        System.out.println("| 5.  Tim theo ngay sinh              |");
        System.out.println("| 6.  Tim theo luong (Phu cap)        |");
        System.out.println("| 7.  Tim theo phong ban              |");
        System.out.println("| 8.  Tim theo du an dang thuc hien   |");
        System.out.println("| 9.  Quay tro ve                     |");
        System.out.println("| 10. Thoat quan ly nhan vien         |");
        System.out.println("+-------------------------------------+");
        System.out.print("- Moi ban nhap lua chon -> ");
    }

    public static void menu_A_5() {
        System.out.println();
        System.out.println("+------------------------------------+");
        System.out.println("|         HIEN THI NHAN VIEN         |");
        System.out.println("+------------------------------------+");
        System.out.println("| 1. Hien thi toan bo nhan vien      |");
        System.out.println("| 2. Hien thi nhan vien chinh        |");
        System.out.println("| 3. Hien thi nhan vien thuc tap     |");
        System.out.println("| 4. Hien thi nhan vien phu          |");
        System.out.println("| 5. Quay tro ve                     |");
        System.out.println("| 6. Thoat quan ly nhan vien         |");
        System.out.println("+------------------------------------+");
        System.out.print("- Moi ban nhap lua chon -> ");
    }

    public static void thanNhanMenu() {
        System.out.println();
        System.out.println("+--------------------------------------+");
        System.out.println("|           QUAN LY THAN NHAN          |");
        System.out.println("+--------------------------------------+");
        System.out.println("| 1. Them than nhan.                   |");
        System.out.println("| 2. Chinh sua thong tin than nhan.    |");
        System.out.println("| 3. Xoa 1 than nhan.                  |");
        System.out.println("| 4. In danh sach than nhan.           |");
        System.out.println("| 5. In than nhan cua 1 nhan vien.     |");
        System.out.println("| 0. Thoat quan ly than nhan.          |");
        System.out.println("+--------------------------------------+");
    }

    public static void editThanNhanMenu() {
        System.out.println();
        System.out.println("+------- MENU CHINH SUA THAN NHAN -------+");
        System.out.println("| 1. Chinh sua ho ten than nhan.         |");
        System.out.println("| 2. Doi gioi tinh than nhan.            |");
        System.out.println("| 3. Chinh sua ngay sinh than nhan.      |");
        System.out.println("| 4. Chinh sua quan he than nhan.        |");
        System.out.println("| 0. Thoat.                              |");
        System.out.println("+----------------------------------------+");
    }
}
