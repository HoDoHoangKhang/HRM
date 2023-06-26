package QUANLYNHANSU;

import java.time.LocalDate;
import java.util.ArrayList;

public class DANHSACHNHANVIEN {

    public static ArrayList<NHANVIEN> listNhanVien = new ArrayList<>();

    public static void menu() {
        boolean kt = true;
        while (kt) {
            MENU.menu_A();
            int chon = (int) CHECK.kiemTraSoNguyenDuong();
            switch (chon) {
                // THÊM NHÂN VIÊN
                case 1:
                    boolean kt_1 = true;
                    while (kt_1) {
                        MENU.menu_A_1();
                        int chon_A_1 = (int) CHECK.kiemTraSoNguyenDuong();
                        switch (chon_A_1) {
                            //THÊM NHÂN VIÊN CHÍNH
                            case 1:
                                System.out.print("Nhap vao so luong nhan vien chinh muon them -> ");
                                int n = (int) CHECK.kiemTraSoNguyenDuong();
                                for (int i = 1; i <= n; i++) {
                                    System.out.println("Nhap vao nhan vien chinh thu " + i + " -> ");
                                    NHANVIEN nvc = new NHANVIENCHINH();
                                    nvc.nhap();
                                    listNhanVien.add(nvc);
                                    listNhanVien = sortByMaNV(listNhanVien);
                                    File.ghiFileNhanVien();
                                }
                                break;
                            //THÊM THỰC TẬP SINH
                            case 2:
                                System.out.print("Nhap vao so luong thuc tap sinh muon them -> ");
                                int n1 = (int) CHECK.kiemTraSoNguyenDuong();
                                for (int i = 1; i <= n1; i++) {
                                    System.out.println("Nhap vao thuc tap sinh thu " + i + " -> ");
                                    NHANVIEN tts = new THUCTAPSINH();
                                    tts.nhap();
                                    listNhanVien.add(tts);
                                    listNhanVien = sortByMaNV(listNhanVien);
                                    File.ghiFileNhanVien();
                                }
                                break;
                            //THÊM NHÂN VIÊN PHỤ
                            case 3:
                                System.out.print("Nhap vao so luong nhan vien phu muon them -> ");
                                int n2 = (int) CHECK.kiemTraSoNguyenDuong();
                                for (int i = 1; i <= n2; i++) {
                                    System.out.println("Nhap vao nhan vien chinh phu thu " + i + " -> ");
                                    NHANVIEN nvp = new NHANVIENPHU();
                                    nvp.nhap();
                                    listNhanVien.add(nvp);
                                    listNhanVien = sortByMaNV(listNhanVien);
                                    File.ghiFileNhanVien();
                                }
                                break;
                            //QUAY TRỞ VỀ
                            case 4:
                                kt_1 = false;
                                break;
                            //THOÁT CHƯƠNG TRÌNH
                            case 5:
                                System.out.println("Thoat chuong trinh thanh cong!");
                                return;
                            default:
                                System.out.println("Nhap sai! Moi nhap lai");
                        }
                    }
                    break;
                //XÓA NHÂN VIÊN
                case 2:
                    if (listNhanVien.isEmpty()) {
                        System.out.println("Danh sach nhan vien rong");
                    } else {
                        MENU.xuatToanBoNhanVien(listNhanVien);
                        System.out.print("Nhap vao ma nhan vien can xoa: ");
                        //kiểm tra mã nhập vào có tồn tại không
                        String maNV = CHECK.kiemTraMaNhanVien();
                        boolean isExist = false;
                        for (NHANVIEN i : listNhanVien) {
                            if (i.getMaNhanVien().equals(maNV)) {
                                isExist = true;
                                listNhanVien.remove(i);
                                break;
                            }
                        }
                        if (!isExist) {
                            System.out.println("Ma nhan vien khong ton tai.");
                        } else {
                            System.out.println("Da xoa nhan vien thanh cong.");
                            System.out.println("DANH SACH NHAN VIEN SAU KHI XOA");
                            MENU.xuatToanBoNhanVien(listNhanVien);
                            File.ghiFileNhanVien();
                        }
                    }
                    break;
                //SỬA NHÂN VIÊN
                case 3:
                    if (listNhanVien.isEmpty()) {
                        System.out.println("Danh sach nhan vien rong");
                    } else {
                        MENU.xuatToanBoNhanVien(listNhanVien);
                        System.out.print("Nhap ma nhan vien can sua: ");
                        String maNhanVien = CHECK.kiemTraNhapMaNhanVienKhongTonTai(DANHSACHNHANVIEN.listNhanVien);
                        int mode;
                        for (NHANVIEN i : listNhanVien) {
                            //nếu có nhân viên nào có mã trùng với mã nhân viên vừa nhập vào
                            if (i.getMaNhanVien().equalsIgnoreCase(maNhanVien)) {
                                if (i instanceof NHANVIENCHINH nvc) {
                                    mode = 1;
                                    boolean kt_A_3_1 = true;
                                    while (kt_A_3_1) {
                                        MENU.menu_A_3_1();
                                        int menu_A_3_1 = (int) CHECK.kiemTraSoNguyenDuong();
                                        switch (menu_A_3_1) {
                                            //sửa số điện thoại
                                            case 1:
                                                i.xuat();
                                                System.out.print("Nhap vao so dien thoai moi -> ");
                                                String newSDT = CHECK.kiemTraSoDienThoai();
                                                if (nvc.getSoDienThoai().equals(newSDT)) {
                                                    System.out.println("So dien thoai vua nhap trung voi so dien thoai cu.");
                                                } else {
                                                    System.out.println("Da doi thanh cong.");
                                                    i.setSoDienThoai(newSDT);
                                                    File.ghiFileNhanVien();
                                                }
                                                break;
                                            //sửa địa chỉ
                                            case 2:
                                                System.out.println("Nhap vao dia chi moi: ");
                                                DIACHI sdc = new DIACHI();
                                                sdc.nhapDiaChi();
                                                System.out.println("Da doi thanh cong.");
                                                i.setDiaChi(sdc);
                                                File.ghiFileNhanVien();
                                                break;
                                            case 3:
                                                // sửa email
                                                i.xuat();
                                                System.out.print("Nhap vao email moi -> ");
                                                String newEmail = CHECK.kiemTraEmail();
                                                if (nvc.getEmail().equals(newEmail)) {
                                                    System.out.println("Email vua nhap trung voi email cu.");
                                                } else {
                                                    System.out.println("Da doi thanh cong.");
                                                    nvc.setEmail(newEmail);
                                                    File.ghiFileNhanVien();
                                                }
                                                break;
                                            case 4:
                                                // sửa chức vụ
                                                i.xuat();
                                                System.out.print("Nhap vao chuc vu moi -> ");
                                                String newChucVu = CHECK.nhapChucVu(mode);
                                                if (nvc.getChucVu().equals(newChucVu)) {
                                                    System.out.println("Chuc vu vua nhap trung voi chuc vu cu.");
                                                } else {
                                                    System.out.println("Da doi thanh cong.");
                                                    nvc.setChucVu(newChucVu);
                                                    File.ghiFileNhanVien();
                                                }
                                                break;
                                            case 5:
                                                // Sửa lương cơ bản
                                                i.xuat();
                                                System.out.print("Nhap vao luong co ban moi: ");
                                                long newLuongCoBan = CHECK.kiemTraSoNguyenDuong();
                                                if (nvc.getLuongCoBan() == newLuongCoBan) {
                                                    System.out.println("So tien vua nhap trung voi so tien cu.");
                                                } else {
                                                    System.out.println("Da doi thanh cong.");
                                                    nvc.setLuongCoBan(newLuongCoBan);
                                                    File.ghiFileNhanVien();
                                                }
                                                break;
                                            case 6:
                                                // Sửa hệ số lương
                                                i.xuat();
                                                System.out.print("Nhap vao he so luong moi: ");
                                                float newHSL = CHECK.kiemTraFloat();
                                                if (nvc.getHeSoLuong() == newHSL) {
                                                    System.out.println("He so luong vua nhap trung voi he so luong cu.");
                                                } else {
                                                    System.out.println("Da doi thanh cong.");
                                                    System.out.println("Da doi thanh cong");
                                                    nvc.setHeSoLuong(newHSL);
                                                    File.ghiFileNhanVien();
                                                }
                                                break;
                                            case 7:
                                                // sửa mã phòng ban
                                                i.xuat();
                                                System.out.println("Nhap vao ma phong ban moi -> ");
                                                String newMaPhong = CHECK.nhapMaPhongBan();
                                                if (nvc.getMaPhongBan().equals(newMaPhong)) {
                                                    System.out.println("Da doi thanh cong.");
                                                } else {
                                                    System.out.println("Da doi thanh cong.");
                                                    nvc.setMaPhongBan(newMaPhong);
                                                    File.ghiFileNhanVien();
                                                }
                                                break;
                                            case 8:
                                                i.xuat();
                                                System.out.println("Nhap vao ma du an moi -> ");
                                                String newMaDuAn = CHECK.nhapMaDuAn();
                                                if (nvc.getMaDuAnDangLam().equals(newMaDuAn)) {
                                                    System.out.println("Du an vua nhap trung voi du an cu.");
                                                } else {
                                                    System.out.println("Da doi thanh cong.");
                                                    nvc.setMaPhongBan(newMaDuAn);
                                                    File.ghiFileNhanVien();
                                                }
                                                break;
                                            case 9:
                                                kt_A_3_1 = false;
                                                break;
                                            case 10:
                                                System.out.println("Thoat chuong trinh thanh cong!");
                                                return;
                                            default:
                                                System.out.println("Nhap sai! Moi nhap lai");
                                        }
                                    }
                                    break;
                                } //Kiểm tra nếu mã nhân viên nhập vào là thực tập sinh thì hiện ra thông tin cần sửa nhân viên chính
                                else if (i instanceof THUCTAPSINH tts) {
                                    mode = 2;
                                    boolean kt_3_2 = true;
                                    while (kt_3_2) {
                                        MENU.menu_A_3_2();
                                        int menu_A_3_2 = (int) CHECK.kiemTraSoNguyenDuong();
                                        switch (menu_A_3_2) {
                                            case 1:
                                                i.xuat();
                                                System.out.print("Nhap vao so dien thoai moi -> ");
                                                String newSDT = CHECK.kiemTraSoDienThoai();
                                                if (i.getSoDienThoai().equals(newSDT)) {
                                                    System.out.println("So dien thoai vua nhap vao trung voi so dien thoai cu.");
                                                } else {
                                                    System.out.println("Da doi thanh cong.");
                                                    i.setSoDienThoai(newSDT);
                                                    File.ghiFileNhanVien();
                                                }
                                                break;
                                            case 2:
                                                i.xuat();
                                                System.out.println("Nhap vao dia chi moi: ");
                                                DIACHI sdc = new DIACHI();
                                                sdc.nhapDiaChi();
                                                System.out.println("Da doi thanh cong.");
                                                i.setDiaChi(sdc);
                                                File.ghiFileNhanVien();
                                                break;
                                            case 3:
                                                i.xuat();
                                                System.out.print("Nhap vao email moi -> ");
                                                String newEmail = CHECK.kiemTraEmail();
                                                if (tts.getEmail().equals(newEmail)) {
                                                    System.out.println("Email vua nhap trung voi email cu.");
                                                } else {
                                                    System.out.println("Da doi thanh cong.");
                                                    tts.setEmail(newEmail);
                                                    File.ghiFileNhanVien();
                                                }
                                                break;
                                            case 4:
                                                i.xuat();
                                                System.out.println("Nhap vao chuc vu moi -> ");
                                                String newChucVu = CHECK.nhapChucVu(mode);
                                                if (tts.getChucVu().equals(newChucVu)) {
                                                    System.out.println("Chuc vu vua nhap trung voi chuc vu cu.");
                                                } else {
                                                    System.out.println("Da doi thanh cong.");
                                                    tts.setChucVu(newChucVu);
                                                    File.ghiFileNhanVien();
                                                }
                                                break;
                                            case 5:
                                                i.xuat();
                                                System.out.print("Nhap vao so tien phu cap moi -> ");
                                                long newPhuCap = CHECK.kiemTraSoNguyenDuong();
                                                if (tts.getPhuCap() == newPhuCap) {
                                                    System.out.println("So tien vua nhap trung voi so tien phu cap cu.");
                                                } else {
                                                    System.out.println("Da doi thanh cong.");
                                                    tts.setPhuCap(newPhuCap);
                                                    File.ghiFileNhanVien();
                                                }
                                                break;
                                            case 6:
                                                i.xuat();
                                                System.out.println("Nhap vao ma phong ban moi -> ");
                                                String newMaPhong = CHECK.nhapMaPhongBan();
                                                if (tts.getMaPhongBan().equals(newMaPhong)) {
                                                    System.out.println("Ma phong vua nhap trung voi ma phong ban cu.");
                                                } else {
                                                    System.out.println("Da doi thanh cong.");
                                                    tts.setMaPhongBan(newMaPhong);
                                                    File.ghiFileNhanVien();
                                                }
                                                break;
                                            case 7:
                                                kt_3_2 = false;
                                                break;
                                            case 8:
                                                System.out.println("Thoat chuong trinh thanh cong!");
                                                return;
                                            default:
                                                System.out.println("Nhap sai! Moi nhap lai");
                                        }
                                    }
                                    break;
                                } else {
                                    mode = 3;
                                    boolean kt_3_3 = true;
                                    while (kt_3_3) {
                                        MENU.menu_A_3_3();
                                        int menu_A_3_3 = (int) CHECK.kiemTraSoNguyenDuong();
                                        switch (menu_A_3_3) {
                                            case 1:
                                                i.xuat();
                                                System.out.print("Nhap vao so dien thoai moi -> ");
                                                String newSDT = CHECK.kiemTraSoDienThoai();
                                                if (i.getSoDienThoai().equals(newSDT)) {
                                                    System.out.println("So dien thoai vua nhap trung voi so dien thoai cu.");
                                                } else {
                                                    System.out.println("Da doi thanh cong.");
                                                    i.setSoDienThoai(newSDT);
                                                    File.ghiFileNhanVien();
                                                }
                                                break;
                                            case 2:
                                                i.xuat();
                                                System.out.println("Nhap vao dia chi moi: ");
                                                DIACHI sdc = new DIACHI();
                                                sdc.nhapDiaChi();
                                                System.out.println("Da doi thanh cong.");
                                                i.setDiaChi(sdc);
                                                File.ghiFileNhanVien();
                                                break;
                                            case 3:
                                                i.xuat();
                                                System.out.println("Nhap vao chuc vu moi -> ");
                                                String newChucVu = CHECK.nhapChucVu(mode);
                                                if (i.getChucVu().equals(newChucVu)) {
                                                    System.out.println("Chuc vu vua nhap trung voi chuc vu cu.");
                                                } else {
                                                    System.out.println("Da doi thanh cong.");
                                                    i.setChucVu(newChucVu);
                                                    File.ghiFileNhanVien();
                                                }
                                                break;
                                            case 4:
                                                // Sửa lương cơ bản
                                                i.xuat();
                                                System.out.print("Nhap vao luong co ban moi: ");
                                                long newLuongCoBan = CHECK.kiemTraSoNguyenDuong();
                                                if (((NHANVIENPHU) i).getLuongCoBan() == newLuongCoBan) {
                                                    System.out.println("So tien vua nhap trung voi so tien cu.");
                                                } else {
                                                    System.out.println("Da doi thanh cong");
                                                    ((NHANVIENPHU) i).setLuongCoBan(newLuongCoBan);
                                                    File.ghiFileNhanVien();
                                                }
                                                break;
                                            case 5:
                                                // Sửa hệ số lương
                                                i.xuat();
                                                System.out.print("Nhap vao he so luong moi: ");
                                                float newHSL = CHECK.kiemTraFloat();
                                                if (((NHANVIENPHU) i).getHeSoLuong() == newHSL) {
                                                    System.out.println("He so luong vua nhap trung voi he so luong cu.");
                                                } else {
                                                    System.out.println("Da doi thanh cong");
                                                    ((NHANVIENPHU) i).setHeSoLuong(newHSL);
                                                    File.ghiFileNhanVien();
                                                }
                                                break;
                                            case 6:
                                                kt_3_3 = false;
                                                break;
                                            case 7:
                                                System.out.println("Thoat chuong trinh thanh cong!");
                                                return;
                                            default:
                                                System.out.println("Nhap sai! Moi nhap lai");
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                    }
                    break;
                // TÌM KIẾM NHÂN VIÊN TƯƠNG ĐỐI VÀ TUYỆT ĐỐI
                case 4:
                    DANHSACHCHAMCONG ccManager = new DANHSACHCHAMCONG();
                    DANHSACHLUONG luongManager = new DANHSACHLUONG();
                    if (listNhanVien.isEmpty()) {
                        System.out.println("Danh sach nhan vien rong.");
                    } else {
                        boolean kt_4 = true;
                        while (kt_4) {
                            ArrayList<NHANVIEN> searchList = new ArrayList<>();
                            MENU.menu_A_4();
                            int chon_A_4 = (int) CHECK.kiemTraSoNguyenDuong();
                            switch (chon_A_4) {
                                case 1:
                                    System.out.print("Nhap vao ma nhan vien can tim -> ");
                                    String timKiemTheoMaNhanVien = CHECK.kiemTraMaNhanVien();
                                    for (NHANVIEN i : DANHSACHNHANVIEN.listNhanVien) {
                                        // nếu mã nhân viên bằng với mã cần tìm thì
                                        if (i.getMaNhanVien().contains(timKiemTheoMaNhanVien)) {
                                            // thêm i vào danh sách tìm kiếm
                                            searchList.add(i);
                                        }
                                    }
                                    if (searchList.isEmpty())// nếu danh sách tìm kiếm rỗng
                                    {
                                        System.out.println("KHONG TIM THAY NHAN VIEN");
                                    } else {// nếu danh sách tìm kiếm khác rỗng
                                        System.out.println("DANH SACH NHAN VIEN CAN TIM");
                                        MENU.xuatToanBoNhanVien(searchList);
                                    }
                                    break;
                                case 2:
                                    System.out.print("Nhap vao ten nhan vien can tim -> ");
                                    String timKiemTheoTenNhanVien = CHECK.kiemTraHoTen();
                                    for (NHANVIEN i : DANHSACHNHANVIEN.listNhanVien) {
                                        if (i.getHoTen().equals(timKiemTheoTenNhanVien)) {
                                            searchList.add(i);
                                        }
                                    }
                                    if (searchList.isEmpty()) {
                                        System.out.println("KHONG TIM THAY NHAN VIEN");
                                    } else {
                                        System.out.println("DANH SACH NHAN VIEN CAN TIM");
                                        MENU.xuatToanBoNhanVien(searchList);
                                    }
                                    break;
                                case 3:
                                    System.out.println("Nhap vao dia chi can tim -> ");
                                    String timKiemTheoDiaChi = CHECK.kiemTraChuoiKyTu();
                                    timKiemTheoDiaChi = timKiemTheoDiaChi.toLowerCase();
                                    for (NHANVIEN i : DANHSACHNHANVIEN.listNhanVien) {
                                        if (i.getDiaChi().getTenQuan().toLowerCase().contains(timKiemTheoDiaChi)
                                                || i.getDiaChi().getTenThanhPho().toLowerCase().contains(timKiemTheoDiaChi)) {
                                            searchList.add(i);
                                        }
                                    }
                                    if (searchList.isEmpty()) {
                                        System.out.println("KHONG TIM THAY NHAN VIEN");
                                    } else {
                                        System.out.println("DANH SACH NHAN VIEN CAN TIM");
                                        MENU.xuatToanBoNhanVien(searchList);
                                    }
                                    break;
                                case 4:
                                    System.out.print("Nhap vao tuoi can tim -> ");
                                    int timKiemTheoTuoi = (int) CHECK.kiemTraSoNguyenDuong();
                                    LocalDate n = LocalDate.now();
                                    for (NHANVIEN i : DANHSACHNHANVIEN.listNhanVien) {
                                        int tuoi = n.getYear() - i.getNgaySinh().getNam();
                                        if (tuoi == timKiemTheoTuoi) {
                                            searchList.add(i);
                                        }
                                    }
                                    if (searchList.isEmpty()) {
                                        System.out.println("KHONG TIM THAY NHAN VIEN");
                                    } else {
                                        System.out.println("DANH SACH NHAN VIEN CAN TIM");
                                        MENU.xuatToanBoNhanVien(searchList);
                                    }
                                    break;
                                case 5:
                                    System.out.println("Nhap vao ngay sinh nhan vien can tim : ");
                                    NGAY timKiemTheoNgaySinh = new NGAY();
                                    timKiemTheoNgaySinh.nhapNgay();
                                    for (NHANVIEN i : DANHSACHNHANVIEN.listNhanVien) {
                                        if (i.getNgaySinh().getNgay() == timKiemTheoNgaySinh.getNgay()
                                                && i.getNgaySinh().getThang() == timKiemTheoNgaySinh.getThang()
                                                && i.getNgaySinh().getNam() == timKiemTheoNgaySinh.getNam()) {
                                            searchList.add(i);
                                        }
                                    }
                                    if (searchList.isEmpty()) {
                                        System.out.println("KHONG TIM THAY NHAN VIEN");
                                    } else {
                                        System.out.println("DANH SACH NHAN VIEN CAN TIM");
                                        MENU.xuatToanBoNhanVien(searchList);
                                    }
                                    break;
                                case 6:
                                    System.out.print("Nhap vao nam can tim: ");
                                    int nam = (int) CHECK.kiemTraSoNguyenDuong();
                                    System.out.print("Nhap vao thang can tim: ");
                                    int thang = (int) CHECK.kiemTraSoNguyenDuong();
                                    while (!CHECK.kiemTraNgayThangNam(1, thang, nam)) {
                                        System.out.println("Thang nam khong ton tai. Moi nhap lai.");
                                        System.out.print("Nhap vao nam can tim: ");
                                        nam = (int) CHECK.kiemTraSoNguyenDuong();
                                        System.out.print("Nhap vao thang can tim: ");
                                        thang = (int) CHECK.kiemTraSoNguyenDuong();
                                    }
                                    System.out.println("Nhap vao khoang luong can tim (VND): ");
                                    System.out.print("Tu: ");
                                    long from = CHECK.kiemTraSoNguyenDuong();
                                    System.out.print("Toi: ");
                                    long to = CHECK.kiemTraSoNguyenDuong();
                                    int count = -1;
                                    for (NHANVIEN i : DANHSACHNHANVIEN.listNhanVien) {
                                        if (i instanceof NHANVIENCHINH nvc
                                                && DANHSACHLUONG.isInList(luongManager.getLuongList(), nvc.getMaNhanVien(), thang, nam) != -1
                                                && luongManager.getLuongList()[DANHSACHLUONG.isInList(luongManager.getLuongList(), nvc.getMaNhanVien(), thang, nam)].getLuong() >= from
                                                && luongManager.getLuongList()[DANHSACHLUONG.isInList(luongManager.getLuongList(), nvc.getMaNhanVien(), thang, nam)].getLuong() <= to) {
                                            ++count;
                                            if (count == 0) {
                                                System.out.println("\n+--------------------------------------------------------------------"
                                                        + "-----------------------------------------------------------------------------+");
                                                System.out.printf("| %-12s | %-30s | %-20s | %18s | %-10s | %-17s | %-17s |\n", "Ma nhan vien",
                                                        "Ho ten nhan vien", "Chuc vu", "Luong co ban (VND)", "He so luong", "Tong so ngay cong", "Luong thang (VND)");
                                                System.out.println("+--------------------------------------------------------------------"
                                                        + "-----------------------------------------------------------------------------+");
                                            }
                                            DANHSACHLUONG.printPersonal(DANHSACHNHANVIEN.listNhanVien, ccManager.getCcList(),
                                                    luongManager.getLuongList(),
                                                    luongManager.getLuongList()[DANHSACHLUONG.isInList(luongManager.getLuongList(), nvc.getMaNhanVien(), thang, nam)].getMaNV(), thang, nam);
                                        } else if (i instanceof NHANVIENPHU nvp
                                                && DANHSACHLUONG.isInList(luongManager.getLuongList(), nvp.getMaNhanVien(), thang, nam) != -1
                                                && luongManager.getLuongList()[DANHSACHLUONG.isInList(luongManager.getLuongList(), nvp.getMaNhanVien(), thang, nam)].getLuong() >= from
                                                && luongManager.getLuongList()[DANHSACHLUONG.isInList(luongManager.getLuongList(), nvp.getMaNhanVien(), thang, nam)].getLuong() <= to) {
                                            ++count;
                                            if (count == 0) {
                                                System.out.println("\n+--------------------------------------------------------------------"
                                                        + "-----------------------------------------------------------------------------+");
                                                System.out.printf("| %-12s | %-30s | %-20s | %18s | %-10s | %-17s | %-17s |\n", "Ma nhan vien",
                                                        "Ho ten nhan vien", "Chuc vu", "Luong co ban (VND)", "He so luong", "Tong so ngay cong", "Luong thang (VND)");
                                                System.out.println("+--------------------------------------------------------------------"
                                                        + "-----------------------------------------------------------------------------+");
                                            }
                                            DANHSACHLUONG.printPersonal(DANHSACHNHANVIEN.listNhanVien, ccManager.getCcList(),
                                                    luongManager.getLuongList(),
                                                    luongManager.getLuongList()[DANHSACHLUONG.isInList(luongManager.getLuongList(), nvp.getMaNhanVien(), thang, nam)].getMaNV(), thang, nam);
                                        }
                                    }
                                    if (count != -1) {
                                        System.out.println("+--------------------------------------------------------------------"
                                                + "-----------------------------------------------------------------------------+");
                                        System.out.print("Enter de tiep tuc ");
                                        Main.st.nextLine();
                                    } else {
                                        System.out.println("Khong co nhan vien nao co luong nam trong khoang nay.");
                                    }
                                    break;
                                case 7:
                                    System.out.println("Nhap vao ma phong ban can tim");
                                    String timKiemTheoMaPhongBan = CHECK.nhapMaPhongBan();
                                    for (NHANVIEN i : DANHSACHNHANVIEN.listNhanVien) {
                                        if (i instanceof NHANVIENCHINH && ((NHANVIENCHINH) i).getMaPhongBan().contains(timKiemTheoMaPhongBan)) {
                                            searchList.add(i);
                                        } else if (i instanceof THUCTAPSINH && ((THUCTAPSINH) i).getMaPhongBan().contains(timKiemTheoMaPhongBan)) {
                                            searchList.add(i);
                                        }
                                    }
                                    if (searchList.isEmpty()) {
                                        System.out.println("KHONG TIM THAY NHAN VIEN");
                                    } else {
                                        System.out.println("DANH SACH NHAN VIEN CAN TIM");
                                        MENU.xuatToanBoNhanVien(searchList);
                                    }
                                    break;
                                case 8:
                                    System.out.println("Nhap vao ma du an dang thuc hien can tim ");
                                    String timKiemTheoMaDuAnDangLam = CHECK.nhapMaDuAn();
                                    for (NHANVIEN i : DANHSACHNHANVIEN.listNhanVien) {
                                        if (i instanceof NHANVIENCHINH nvc && nvc.getMaDuAnDangLam().contains(timKiemTheoMaDuAnDangLam)) {
                                            searchList.add(i);
                                        }
                                    }
                                    if (searchList.isEmpty()) {
                                        System.out.println("KHONG TIM THAY NHAN VIEN");
                                    } else {
                                        System.out.println("DANH SACH NHAN VIEN CAN TIM");
                                        MENU.xuatToanBoNhanVien(searchList);
                                    }
                                    break;
                                case 9:
                                    kt_4 = false;
                                    break;
                                case 10:
                                    System.out.println("Thoat chuong trinh thanh cong!");
                                    return;
                                default:
                                    System.out.println("Nhap sai! Moi nhap lai");
                            }
                        }
                    }
                    break;
                // HIỂN THỊ DANH SÁCH NHÂN VIÊN
                case 5:
                    if (listNhanVien.isEmpty()) {
                        System.out.println("Danh sach nhan vien rong");
                    } else {
                        boolean kt_5 = true;
                        while (kt_5) {
                            MENU.menu_A_5();
                            int chon_A_5 = (int) CHECK.kiemTraSoNguyenDuong();
                            switch (chon_A_5) {
                                case 1:
                                    if (listNhanVien.isEmpty()) {
                                        System.out.println("Danh sach nhan vien rong.");
                                    } else {
                                        MENU.xuatToanBoNhanVien(listNhanVien);
                                        System.out.print("Enter de tiep tuc ");
                                        String nvc = Main.st.nextLine();
                                    }
                                    break;
                                case 2:
                                    if (listNhanVien.isEmpty()) {
                                        System.out.println("Danh sach nhan vien rong.");
                                    } else {
                                        boolean isExist = false;
                                        for (int i = 0; i < listNhanVien.size(); ++i) {
                                            if (listNhanVien.get(i) instanceof NHANVIENCHINH) {
                                                isExist = true;
                                                break;
                                            }
                                        }
                                        if (isExist) {
                                            MENU.xuatNhanVienChinh(listNhanVien);
                                            System.out.print("Enter de tiep tuc ");
                                            String t = Main.st.nextLine();
                                        } else {
                                            System.out.println("Khong co nhan vien chinh nao trong danh sach.");
                                        }
                                    }
                                    break;
                                case 3:
                                    if (listNhanVien.isEmpty()) {
                                        System.out.println("Danh sach nhan vien rong.");
                                    } else {
                                        boolean isExist = false;
                                        for (int i = 0; i < listNhanVien.size(); ++i) {
                                            if (listNhanVien.get(i) instanceof THUCTAPSINH) {
                                                isExist = true;
                                                break;
                                            }
                                        }
                                        if (isExist) {
                                            MENU.xuatThucTapSinh(listNhanVien);
                                            System.out.print("Enter de tiep tuc ");
                                            String nextLine = Main.st.nextLine();
                                        } else {
                                            System.out.println("Khong co thuc tap sinh nao trong danh sach.");
                                        }
                                    }
                                    break;
                                case 4:
                                    if (listNhanVien.isEmpty()) {
                                        System.out.println("Danh sach nhan vien rong.");
                                    } else {
                                        boolean isExist = false;
                                        for (int i = 0; i < listNhanVien.size(); ++i) {
                                            if (listNhanVien.get(i) instanceof NHANVIENPHU) {
                                                isExist = true;
                                                break;
                                            }
                                        }
                                        if (isExist) {
                                            MENU.xuatNhanVienPhu(listNhanVien);
                                            System.out.print("Enter de tiep tuc ");
                                            String nvp = Main.st.nextLine();
                                        } else {
                                            System.out.println("Khong co nhan vien phu nao trong danh sach.");
                                        }
                                    }
                                    break;
                                case 5:
                                    kt_5 = false;
                                    break;
                                case 6:
                                    System.out.println("Thoat chuong trinh thanh cong!");
                                    return;
                                default:
                                    System.out.print("Nhap sai! Moi nhap lai: ");
                            }
                        }
                    }
                    break;
                case 6:
                    kt = false;
                    break;
                case 7:
                    System.out.println("Thoat chuong trinh thanh cong!");
                    return;
                default:
                    System.out.println("Nhap sai! Moi nhap lai");
            }
        }
    }

    public static ArrayList<NHANVIEN> sort(ArrayList<NHANVIEN> list) {
        if (list.isEmpty()) {
            return list;
        } else {
            int min;
            for (int i = 0; i < list.size() - 1; ++i) {
                min = i;
                for (int j = i + 1; j < list.size(); ++j) {
                    if (CHECK.getNumberOfMaNV(list.get(min).getMaNhanVien()) > CHECK.getNumberOfMaNV(list.get(j).getMaNhanVien())) {
                        min = j;
                    }
                }
                if (min != i) {
                    NHANVIEN temp = list.get(i);
                    list.set(i, list.get(min));
                    list.set(min, temp);
                }
            }
            return list;
        }
    }

    public static ArrayList<NHANVIEN> sortByMaNV(ArrayList<NHANVIEN> list) {
        if (list.isEmpty()) {
            return list;
        } else {
            ArrayList<NHANVIEN> arrC = new ArrayList<>();
            for (int i = 0; i < list.size(); ++i) {
                if (CHECK.getFirstLetterOfMaNV(list.get(i).getMaNhanVien()).equals("C")) {
                    arrC.add(list.get(i));
                }
            }
            arrC = sort(arrC);
            ArrayList<NHANVIEN> arrP = new ArrayList<>();
            for (int i = 0; i < list.size(); ++i) {
                if (CHECK.getFirstLetterOfMaNV(list.get(i).getMaNhanVien()).equals("P")) {
                    arrP.add(list.get(i));
                }
            }
            arrP = sort(arrP);
            ArrayList<NHANVIEN> arrT = new ArrayList<>();
            for (int i = 0; i < list.size(); ++i) {
                if (CHECK.getFirstLetterOfMaNV(list.get(i).getMaNhanVien()).equals("T")) {
                    arrT.add(list.get(i));
                }
            }
            arrT = sort(arrT);

            arrC.addAll(arrP);
            arrC.addAll(arrT);
            return arrC;
        }
    }
}
