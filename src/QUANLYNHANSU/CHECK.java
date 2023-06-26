package QUANLYNHANSU;

import java.io.Serializable;
import java.util.ArrayList;

public class CHECK implements Serializable {

    private static final long serialVersionUID = 1L;

    public static String inHoaChuCaiDauMoiTu(String s) {
        char[] charArray = s.toCharArray();
        boolean foundSpace = true;
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isLetter(charArray[i])) {
                charArray[i] = Character.toLowerCase(charArray[i]);
                if (foundSpace) {
                    charArray[i] = Character.toUpperCase(charArray[i]);
                    foundSpace = false;
                }
            } else {
                foundSpace = true;
            }
        }
        s = String.valueOf(charArray);
        return s.trim();
    }

    public static String inHoaChuCaiDauTienCuaChuoi(String s) {
        s = s.trim();
        String firstLetter = s.substring(0, 1);
        firstLetter = firstLetter.toUpperCase();
        String remainingLetter = s.substring(1, s.length());
        char[] charArray = remainingLetter.toCharArray();
        for (int i = 0; i < remainingLetter.length(); ++i) {
            if (Character.isLetter(charArray[i])) {
                charArray[i] = Character.toLowerCase(charArray[i]);
            }
        }
        remainingLetter = String.valueOf(charArray);
        s = firstLetter + remainingLetter;
        return s;
    }

    public static String inHoaTatCaKyTu(String s) {
        s = s.trim();
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isLetter(charArray[i])) {
                charArray[i] = Character.toUpperCase(charArray[i]);
            }
        }
        s = String.valueOf(charArray);
        return s;
    }

    public static String kiemTraMaNhanVien1() {
        String input;
        while (true) {
            input = Main.st.nextLine();
            input = input.trim();
            if (input.matches("[CcTtPt][0-9]{4}")) {
                return input;
            } else {
                System.out.println("Ma nhan vien khong phu hop. Vui long nhap lai theo dinh dang VD: C0001, T0001, P0001");
                System.out.print("Moi nhap lai: ");
            }
        }
    }

    public static String kiemTraMaNhanVienChinh() {
        String input;
        while (true) {
            input = Main.st.nextLine();
            input = input.trim();
            if (input.matches("[Cc][0-9]{4}")) {
                return input;
            } else {
                System.out.println("Ma nhan vien chinh khong phu hop. Vui long nhap lai theo dinh dang VD: C0001");
                System.out.print("Moi nhap lai: ");
            }
        }
    }

    public static String kiemTraMaNhanVien(int mode) {
        if (mode == 1) {
            String input;
            while (true) {
                input = Main.st.nextLine();
                input = input.trim();
                if (input.matches("[Cc][0-9]{4}")) {
                    return input;
                } else {
                    System.out.println("Ma nhan vien khong phu hop. Vui long nhap lai theo dinh dang VD: C0001");
                    System.out.print("Moi nhap lai: ");
                }
            }
        } else if (mode == 2) {
            String input;
            while (true) {
                input = Main.st.nextLine();
                input = input.trim();
                if (input.matches("[Tt][0-9]{4}")) {
                    return input;
                } else {
                    System.out.println("Ma nhan vien khong phu hop. Vui long nhap lai theo dinh dang VD: T0001");
                    System.out.print("Moi nhap lai: ");
                }
            }
        } else {
            String input;
            while (true) {
                input = Main.st.nextLine();
                input = input.trim();
                if (input.matches("[Pp][0-9]{4}")) {
                    return input;
                } else {
                    System.out.println("Ma nhan vien khong phu hop. Vui long nhap lai theo dinh dang VD: P0001");
                    System.out.print("Moi nhap lai: ");
                }
            }
        }
    }

    public static String kiemTraHoTen() {
        String input;
        while (true) {
            input = Main.st.nextLine();
            input = input.trim();
            if (input.matches("[a-zA-Z\\s]+")) {
                return inHoaChuCaiDauMoiTu(input);
            } else {
                System.out.print("Khong hop le! Moi nhap lai: ");
            }
        }
    }

    public static boolean kiemTraNgayThangNam(int day, int month, int year) {
        if (day < 1 || day > 31 || month < 1 || month > 12 || year > 2022) {
            return false;
        }
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            switch (month) {
                case 2: {
                    if (day > 29) {
                        return false;
                    }
                }
                ;
                break;
                case 1, 3, 5, 7, 8, 10, 12: {
                    if (day > 31) {
                        return false;
                    }
                }
                ;
                break;
                case 4, 6, 9, 11: {
                    if (day > 30) {
                        return false;
                    }
                }
                ;
                break;
            }
        } else {
            switch (month) {
                case 2: {
                    if (day > 28) {
                        return false;
                    }
                }
                ;
                break;
                case 1, 3, 5, 7, 8, 10, 12: {
                    if (day > 31) {
                        return false;
                    }
                }
                ;
                break;
                case 4, 6, 9, 11: {
                    if (day > 30) {
                        return false;
                    }
                }
                ;
                break;
            }
        }
        return true;
    }

    public static String kiemTraSoDienThoai() {
        String input;
        while (true) {
            input = Main.st.nextLine();
            input = input.trim();
            if (input.matches("0" + "[1-9]{2}" + "[0-9]{7}")) {
                return input;
            } else {
                System.out.println("Khong hop le! Moi nhap lai theo dinh dang 10 so \"0395382257\" ");
            }
            System.out.print("Moi nhap lai: ");
        }
    }

    public static String kiemTraGioiTinh() {
        String input;
        while (true) {
            input = Main.st.nextLine();
            input = input.trim();
            if (input.matches("Nam|nam|Nu|nu|NAM|NU")) {
                return inHoaChuCaiDauTienCuaChuoi(input);
            } else {
                System.out.print("Khong hop le! Moi nhap lai theo dinh dang (nam / nu): ");
            }
        }
    }

    public static String kiemTra() {
        String input;
        while (true) {
            input = Main.st.nextLine();
            input = input.trim();
            if (input.matches("Nam|nam|Nu|nu|NAM|NU")) {
                return inHoaChuCaiDauTienCuaChuoi(input);
            } else {
                System.out.print("Khong hop le! Moi nhap lai theo dinh dang (nam / nu): ");
            }
        }
    }

    public static boolean kiemTraStartEndDay(NGAY start, NGAY end) {
        if (start.getNam() == end.getNam()) {
            if (start.getThang() == end.getThang()) {
                return start.getNgay() < end.getNgay();
            }
            return start.getThang() <= end.getThang();
        } else {
            return start.getNam() <= end.getNam();
        }
    }

    /**
     * @return Kiểm tra chuỗi nhập vào có phải là chuỗi ký tự không và trả về
     * chuỗi viết hoa chữ cái đầu
     */
    public static String kiemTraChuoiKyTu() {
        String input;
        while (true) {
            input = Main.st.nextLine();
            input = input.trim();
            if (input.matches("[a-zA-Z\\s]+")) {
                return inHoaChuCaiDauMoiTu(input);
            } else {
                System.out.print("Khong hop le! Moi nhap lai: ");
            }
        }
    }

    public static Double kiemTraDouble() {
        Double input;
        while (true) {
            try {
                input = Double.parseDouble(Main.st.nextLine());
                return input;
            } catch (Exception e) {
                System.out.print("So khong hop le! Moi nhap lai: ");
            }
        }
    }

    public static Float kiemTraFloat() {
        Float input;
        while (true) {
            try {
                input = Float.parseFloat(Main.st.nextLine());
                return input;
            } catch (Exception e) {
                System.out.print("So khong hop le! Moi nhap lai: ");
            }
        }
    }

    public static String kiemTraEmail() {
        String input;
        while (true) {
            input = Main.st.nextLine();
            input = input.trim();
            if (input.matches("^(.+)@(\\S+)$")) {
                return input;
            } else {
                System.out.println("Email khong hop le! Moi nhap theo dinh dang: user@gmail.com");
            }
            System.out.print("Email -> ");
        }
    }

    public static String kiemTraMaPhongBan() {
        String input;
        while (true) {
            input = Main.st.nextLine();
            input = input.trim();
            if (input.matches("IT|KD|NS|MK|it|kd|ns|mk|It|Kd|Ns|Mk")) {
                return inHoaTatCaKyTu(input);
            } else {
                System.out.println("Ma phong khong hop le! Ma phong phai thuoc (IT | KD | NS | MK)");
            }
            System.out.print("Moi nhap ma phong ban -> ");
        }
    }

    public static String nhapMaPhongBan() {
        String input = "";
        boolean kt = true;
        while (kt) {
            System.out.println("+---------------------------------------+");
            System.out.println("|             BANG MA PHONG BAN         |");
            System.out.println("+---------------------------------------+");
            int stt = 1;
            for (PHONGBAN i : DANHSACHPHONGBAN.listPhongBan) {
                System.out.printf("| %-1s. Ma: %-5s Ten: %-20s|\n", stt, i.getMaPhongBan(), i.getTenPhongBan());
                stt++;
            }
            System.out.println("+---------------------------------------+");
            System.out.print("- Moi ban nhap lua chon ma phong ban -> ");
            int chonMaPhongBan = (int) CHECK.kiemTraSoNguyenDuong();
            int dem = 0;
            for (PHONGBAN i : DANHSACHPHONGBAN.listPhongBan) {
                if (chonMaPhongBan - 1 == dem) {
                    input = i.getMaPhongBan();
                    break;
                }
                dem++;
            }
            if (input != "") {
                kt = false;
            } else {
                System.out.println("Khong ton tai ma phong ban!\nMoi nhap lai");
            }
        }
        return input;
    }

    public static String nhapMaDuAn() {
        String input = "";
        boolean kt = true;
        while (kt) {
            System.out.println("+-------------------------------------+");
            System.out.println("|            BANG MA DU AN            |");
            System.out.println("+-------------------------------------+");
            int stt = 1;
            for (DUAN i : DANHSACHDUAN.listDuAn) {
                System.out.printf("| %-1s. Ma:%-5s Ten:%-20s|\n", stt, i.getMaDuAn(), i.getTenDuAn());
                stt++;
            }
            System.out.println("+-------------------------------------+");
            System.out.print("- Moi ban nhap lua chon ma du an -> ");
            int chonMaDuAn = (int) CHECK.kiemTraSoNguyenDuong();
            int dem = 0;
            for (DUAN i : DANHSACHDUAN.listDuAn) {
                if (chonMaDuAn - 1 == dem) {
                    input = i.getMaDuAn();
                    break;
                }
                dem++;
            }
            if (input != "") {
                kt = false;
            } else {
                System.out.println("Khong ton tai ma de an!\nMoi nhap lai");
            }
        }
        return input;
    }

    public static boolean kiemTraDiaChi(String soNha, String duong, String phuong, String quan, String thanhPho) {
        return duong.matches("[a-zA-Z0-9\\s/]+") && phuong.matches("[a-zA-Z0-9\\s/]+") && quan.matches("[a-zA-Z0-9\\s/]+") && thanhPho.matches("[a-zA-Z\\s]+");
    }

    public static long kiemTraSoNguyenDuong() {
        long input;
        while (true) {
            try {
                input = Long.parseLong(Main.st.nextLine());
                if (input < 0) {
                    System.out.print("So khong duoc nho hon 0!\nMoi nhap lai: ");
                } else {
                    return input;
                }
            } catch (Exception e) {
                System.out.print("Du lieu nhap vao khong phai la so nguyen duong.\nMoi nhap lai: ");
            }
        }
    }

    public static String kiemTraNhapMaNhanVienKhongTonTai(ArrayList<NHANVIEN> a) {
        String input;
        while (true) {
            input = Main.st.nextLine();
            input = input.trim();
            for (NHANVIEN i : DANHSACHNHANVIEN.listNhanVien) {
                if (i.getMaNhanVien().equalsIgnoreCase(input)) {
                    return input;
                }
            }
            System.out.print("Ma nhan vien khong ton tai \nMoi nhap lai: ");
        }
    }

    public static boolean kiemTraMaNhanVienTonTai(String input, ArrayList<NHANVIEN> list) {
        while (true) {
            for (NHANVIEN i : list) {
                if (i.getMaNhanVien().equalsIgnoreCase(input)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static boolean kiemTraMaDuAnTonTai(String input) {
        while (true) {
            for (DUAN i : DANHSACHDUAN.listDuAn) {
                if (i.getMaDuAn().equalsIgnoreCase(input)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static String nhapQuanHeThanNhan() {
        String input = "";
        boolean kt = true;
        while (kt) {
            System.out.println("+------------------------+");
            System.out.println("| BANG QUAN HE THAN NHAN |");
            System.out.println("+------------------------+");
            System.out.println("| 1. Cha                 |");
            System.out.println("| 2. Me                  |");
            System.out.println("| 3. Vo                  |");
            System.out.println("| 4. Chong               |");
            System.out.println("| 5. Con                 |");
            System.out.println("| 6. Anh                 |");
            System.out.println("| 7. Chi                 |");
            System.out.println("| 8. Em trai             |");
            System.out.println("| 9. Em gai              |");
            System.out.println("| 10. Khac               |");
            System.out.println("+------------------------+");
            System.out.print("- Moi ban nhap lua chon quan he than nhan -> ");
            int chonChuCVu = (int) CHECK.kiemTraSoNguyenDuong();
            switch (chonChuCVu) {
                case 1:
                    input = "Cha";
                    kt = false;
                    break;
                case 2:
                    input = "Me";
                    kt = false;
                    break;
                case 3:
                    input = "Vo";
                    kt = false;
                    break;
                case 4:
                    input = "Chong";
                    kt = false;
                    break;
                case 5:
                    input = "Con";
                    kt = false;
                    break;
                case 6:
                    input = "Anh";
                    kt = false;
                    break;
                case 7:
                    input = "Chi";
                    kt = false;
                    break;
                case 8:
                    input = "Em Trai";
                    kt = false;
                    break;
                case 9:
                    input = "Em Gai";
                    kt = false;
                    break;
                case 10:
                    System.out.print("Moi ban nhap vao quan he than nhan -> ");
                    input = CHECK.kiemTraChuoiKyTu();
                    kt = false;
                    break;
                default:
                    System.out.println("Moi chon lai");
                    break;
            }
        }
        return CHECK.inHoaChuCaiDauMoiTu(input);
    }

    public static String nhapChucVu(int mode) {
        if (mode == 1) {
            String input = "";
            boolean kt = true;
            while (kt) {
                System.out.println("+------------------------------+");
                System.out.println("| BANG CHUC VU NHAN VIEN CHINH |");
                System.out.println("+------------------------------+");
                System.out.println("| 1. Chuyen vien               |");
                System.out.println("| 2. Nhan vien                 |");
                System.out.println("| 3. Tro ly                    |");
                System.out.println("| 4. Thu ki                    |");
                System.out.println("| 5. Ke toan                   |");
                System.out.println("| 6. Quan ly                   |");
                System.out.println("| 7. Khac                      |");
                System.out.println("+------------------------------+");
                System.out.print("- Moi ban nhap lua chon chuc vu -> ");
                int chonChuCVu = (int) CHECK.kiemTraSoNguyenDuong();
                switch (chonChuCVu) {
                    case 1:
                        input = "Chuyen vien";
                        kt = false;
                        break;
                    case 2:
                        input = "Nhan vien";
                        kt = false;
                        break;
                    case 3:
                        input = "Tro ly";
                        kt = false;
                        break;
                    case 4:
                        input = "Thu ki";
                        kt = false;
                        break;
                    case 5:
                        input = "Ke toan";
                        kt = false;
                        break;
                    case 6:
                        input = "Quan ly";
                        kt = false;
                        break;
                    case 7:
                        System.out.print("Moi ban nhap vao chuc vu cua nhan vien -> ");
                        input = kiemTraChuoiKyTu();
                        kt = false;
                        break;
                    default:
                        System.out.println("Moi chon lai");
                        break;
                }
            }
            return input;
        } else if (mode == 2) {
            String input = "";
            boolean kt = true;
            while (kt) {
                System.out.println("+----------------------------+");
                System.out.println("| BANG CHUC VU THUC TAP SINH |");
                System.out.println("+----------------------------+");
                System.out.println("| 1. Nhan vien               |");
                System.out.println("| 2. Tro ly                  |");
                System.out.println("| 3. Thu ki                  |");
                System.out.println("| 4. Ke toan                 |");
                System.out.println("| 5. Khac                    |");
                System.out.println("+----------------------------+");
                System.out.print("- Moi ban nhap lua chon chuc vu -> ");
                int chonChuCVu = (int) CHECK.kiemTraSoNguyenDuong();
                switch (chonChuCVu) {
                    case 1:
                        input = "Nhan vien";
                        kt = false;
                        break;
                    case 2:
                        input = "Tro ly";
                        kt = false;
                        break;
                    case 3:
                        input = "Thu ki";
                        kt = false;
                        break;
                    case 4:
                        input = "Ke toan";
                        kt = false;
                        break;
                    case 5:
                        System.out.print("Moi ban nhap vao chuc vu cua thuc tap sinh-> ");
                        input = inHoaChuCaiDauTienCuaChuoi(kiemTraChuoiKyTu());
                        kt = false;
                        break;
                    default:
                        System.out.println("Moi chon lai");
                        break;
                }
            }
            return input;
        } else {
            String input = "";
            boolean kt = true;
            while (kt) {
                System.out.println("+----------------------------+");
                System.out.println("| BANG CHUC VU NHAN VIEN PHU |");
                System.out.println("+----------------------------+");
                System.out.println("| 1. Bao ve                  |");
                System.out.println("| 2. Lao cong                |");
                System.out.println("| 3. Khac                    |");
                System.out.println("+----------------------------+");
                System.out.print("- Moi ban nhap lua chon chuc vu -> ");
                int chonChuCVu = (int) CHECK.kiemTraSoNguyenDuong();
                switch (chonChuCVu) {
                    case 1:
                        input = "Bao ve";
                        kt = false;
                        break;
                    case 2:
                        input = "Lao cong";
                        kt = false;
                        break;
                    case 3:
                        System.out.print("Moi ban nhap vao chuc vu cua nhan vien -> ");
                        input = inHoaChuCaiDauTienCuaChuoi(kiemTraChuoiKyTu());
                        kt = false;
                        break;
                    default:
                        System.out.println("Moi chon lai");
                        break;
                }
            }
            return input;
        }
    }

//    ----------------------------- NEW --------------------------------------------------
    public int lastDayOfMonth(int month, int year) {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12: {
                return 31;
            }
            case 4, 6, 9, 11:
                return 30;
            case 2: {
                if (year % 4 == 0) {
                    return 29;
                } else {
                    return 28;
                }
            }
            default:
                return -1;
        }
    }

    public static String kiemTraMaNhanVien() {
        String input;
        while (true) {
            input = Main.st.nextLine();
            input = input.trim();
            if (input.matches("[TPC][0-9]{4}")) {
                return input;
            } else {
                System.out.println("Ma nhan vien khong phu hop. Vui long nhap lai theo dinh dang {(C0001) | (P0001) | (T0001)}");
            }
            System.out.print("Moi nhap lai: ");
        }
    }

    public static int isInList(ArrayList<NHANVIEN> list, String maNV) {
        if (isEmpty(list)) {
            return -1;
        }
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).maNhanVien.equals(maNV)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isEmpty(ArrayList<NHANVIEN> list) {
        if (list == null) {
            return true;
        }
        return (list.size() == 0);
    }

    public static String yesNoChoice() {
        String input;
        while (true) {
            input = Main.st.nextLine();
            input = input.trim();
            if (input.matches("[y|n]{1}")) {
                return input;
            } else {
                System.out.println("Sai lua chon.");
            }
            System.out.print("Moi nhap lua chon ( y | n ): ");
        }
    }

    public static int compareDate(int month1, int year1, int month2, int year2) {
        // return 1 la month1/year1 after month2/year2
        // return 0 la month1/year1 = month2/year2
        // return -1 la month1/year1 before month2/year2
        if (year1 == year2) {
            if (month1 > month2) {
                return 1;
            } else if (month1 < month2) {
                return -1;
            } else {
                return 0;
            }
        } else if (year1 > year2) {
            return 1;
        } else {
            return -1;
        }
    }

    public static int getNumberOfMaNV(String maNV) {
        return Integer.parseInt(maNV.substring(1));
    }

    public static String getFirstLetterOfMaNV(String maNV) {
        return maNV.substring(0, 1);
    }

    public static NHANVIEN getNhanVien(ArrayList<NHANVIEN> list, String maNV) {
        for (int i = 0; i < list.size(); ++i) {
            if (list.get(i).getMaNhanVien().equals(maNV)) {
                return list.get(i);
            }
        }
        return null;
    }

    public static String changeMoney(Long moneyIn) {
        char[] moneyArr = moneyIn.toString().toCharArray();
        int count = 0;
        String temp = "";
        // Them dau phay vao chuoi so
        for (int i = moneyArr.length - 1; i >= 0; i--) {
            ++count;
            if (count % 3 == 0 && i > 0) {
                temp += moneyArr[i];
                temp += ",";
                continue;
            }
            temp += moneyArr[i];
        }
        // Dao nguoc chuoi
        String moneyOut = "";
        count = 0;
        moneyArr = temp.toCharArray();
        for (int i = moneyArr.length - 1; i >= 0; --i) {
            moneyOut += moneyArr[i];
            count++;
        }
        return moneyOut;
    }

    public static boolean kiemTraDiaChi(String quan, String thanhPho) {
        return quan.matches("[a-zA-Z0-9\\s/]+") && thanhPho.matches("[a-zA-Z\\s]+");
    }

}
