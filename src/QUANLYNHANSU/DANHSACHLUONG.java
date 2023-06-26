/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QUANLYNHANSU;

import java.util.ArrayList;

public class DANHSACHLUONG {

    private LUONG[] luongList = null;
    private final FileLuong fl;

    CHECK check = new CHECK();

    public DANHSACHLUONG() {
        fl = new FileLuong();
        luongList = fl.read();
    }

    public LUONG[] getLuongList() {
        return luongList;
    }

    public void setLuongList(LUONG[] luongList) {
        this.luongList = luongList;
    }

    public LUONG[] add(LUONG[] list, LUONG luong) {
        if (isEmpty(list)) {
            LUONG[] newList = new LUONG[1];
            newList[0] = luong;
            return newList;
        } else {
            LUONG[] newList = new LUONG[list.length + 1];
            for (int i = 0; i < list.length; ++i) {
                newList[i] = list[i];
            }
            newList[list.length] = luong;
            return newList;
        }
    }

    public LUONG[] add(LUONG[] head, LUONG[] tail) {
        if (isEmpty(head) && isEmpty(tail)) {
            return null;
        } else if (isEmpty(head) && !isEmpty(tail)) {
            return tail;
        } else if (!isEmpty(head) && isEmpty(tail)) {
            return head;
        } else {
            LUONG[] list = new LUONG[head.length + tail.length];
            int count = 0;
            for (int i = 0; i < head.length; ++i) {
                list[count] = head[i];
                ++count;
            }
            for (int i = 0; i < tail.length; ++i) {
                list[count] = tail[i];
                ++count;
            }
            return list;
        }
    }

    public LUONG[] remove(LUONG[] list, int index) {
        if (index >= 0 && index < list.length) {
            for (int i = index; i < list.length - 1; ++i) {
                list[i] = list[i + 1];
            }
            LUONG[] newList = new LUONG[list.length - 1];
            for (int i = 0; i < newList.length; ++i) {
                newList[i] = list[i];
            }
            return newList;
        } else {
            return list;
        }
    }

    public static boolean isEmpty(LUONG[] list) {
        if (list == null) {
            return true;
        }
        return (list.length == 0);
    }

    public boolean isExistInList(int thang, int nam) {
        if (isEmpty(luongList)) {
            return false;
        }
        for (int i = 0; i < luongList.length; ++i) {
            if (luongList[i].getThang() == thang && luongList[i].getNam() == nam) {
                return true;
            }
        }
        return false;
    }

    public static int isInList(LUONG[] list, String maNV, int thang, int nam) {
        if (isEmpty(list)) {
            return -1;
        } else {
            for (int i = 0; i < list.length; ++i) {
                if (list[i].getMaNV().equals(maNV) && list[i].getThang() == thang && list[i].getNam() == nam) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void add(ArrayList<NHANVIEN> nvList, CHAMCONG[] ccList, int thang, int nam) {
        if (CHECK.isEmpty(nvList) && !DANHSACHCHAMCONG.isEmpty(ccList)) {
            System.out.println("Danh sach nhan vien rong.");
        } else if (!CHECK.isEmpty(nvList) && DANHSACHCHAMCONG.isEmpty(ccList)) {
            System.out.println("Danh sach cham cong rong.");
        } else if ((CHECK.isEmpty(nvList)) && (DANHSACHCHAMCONG.isEmpty(ccList))) {
            System.out.println("Danh sach nhan vien va danh sach cham cong rong.");
        } else {
            System.out.print("Moi nhap ma nhan vien: ");
            String maNV = CHECK.kiemTraMaNhanVien();
            boolean isExistNV = false;
            boolean isNotExistInLuongList = true;
            // Kiểm tra có tồn tại mã nhân viên trong file nhân viên và trong file chứa tất cả các bảng chấm công hay không
            if (CHECK.isInList(nvList, maNV) != -1 && DANHSACHCHAMCONG.isInList(ccList, maNV) != -1) {
                isExistNV = true;
                // Kiểm tra file lương có rỗng hay không
                if (isEmpty(luongList)) {
                    int pos = -1;
                    // Kiểm tra có tồn tại nhân viên trong bảng chấm công tại tháng và năm truyền vào không
                    for (int i = 0; i < ccList.length; ++i) {
                        if (ccList[i].getMaNV().equals(maNV) && ccList[i].getThang() == thang && ccList[i].getNam() == nam) {
                            pos = i;
                            break;
                        }
                    }
                    if (pos != -1) {
                        LUONG luong = new LUONG();
                        if (nvList.get(CHECK.isInList(nvList, maNV)) instanceof NHANVIENCHINH nvc) {
                            luong.nhap(maNV, thang, nam, ccList[pos].tongNgayCong(), nvc.getLuongCoBan(), nvc.getHeSoLuong());
                            this.luongList = add(luongList, luong);
                        } else if (nvList.get(CHECK.isInList(nvList, maNV)) instanceof NHANVIENPHU nvp) {
                            luong.nhap(maNV, thang, nam, ccList[pos].tongNgayCong(), nvp.getLuongCoBan(), nvp.getHeSoLuong());
                            this.luongList = add(luongList, luong);
                        }
                        System.out.println("Da them thanh cong");
                        fl.write(sortByMaNV());
                    } else {
                        System.out.println("Khong co nhan vien trong bang cham cong " + thang + "/" + nam);
                    }
                } else { // Trường hợp file lương không rỗng
                    // Kiểm tra có tồn tại nhân viên trong bảng chấm công tại tháng và năm truyền vào không
                    int pos = -1;
                    for (int i = 0; i < ccList.length; ++i) {
                        if (ccList[i].getMaNV().equals(maNV) && ccList[i].getThang() == thang && ccList[i].getNam() == nam) {
                            pos = i;
                            break;
                        }
                    }
                    // Kiểm tra có tồn tại nhân viên trong bảng lương tại thời tháng và năm truyền vào không
                    for (int i = 0; i < luongList.length; ++i) {
                        if (luongList[i].getMaNV().equals(maNV) && luongList[i].getThang() == thang && luongList[i].getNam() == nam) {
                            isNotExistInLuongList = false;
                            break;
                        }
                    }
                    if (isNotExistInLuongList && pos != -1) {
                        LUONG luong = new LUONG();
                        if (nvList.get(CHECK.isInList(nvList, maNV)) instanceof NHANVIENCHINH nvc) {
                            luong.nhap(maNV, thang, nam, ccList[pos].tongNgayCong(), nvc.getLuongCoBan(), nvc.getHeSoLuong());
                            this.luongList = add(luongList, luong);
                        } else if (nvList.get(CHECK.isInList(nvList, maNV)) instanceof NHANVIENPHU nvp) {
                            luong.nhap(maNV, thang, nam, ccList[pos].tongNgayCong(), nvp.getLuongCoBan(), nvp.getHeSoLuong());
                            this.luongList = add(luongList, luong);
                        }
                        System.out.println("Da them thanh cong");
                        fl.write(sortByMaNV());
                    } else if (pos == -1) {
                        System.out.println("Khong co nhan vien trong bang cham cong " + thang + "/" + nam);
                    } else {
                        System.out.println("Da ton tai nhan vien trong bang luong.");
                    }
                }
            }
            if (isExistNV == false) {
                System.out.println("Ma nhan vien khong ton tai.");
            }
        }
    }

    public void add(ArrayList<NHANVIEN> nvList, CHAMCONG[] ccList) {
        checkFirst(nvList);
        luongList = checkFirst(ccList);
        fl.write(luongList);
        String choice1 = "y", choice2 = "y";
        while (choice1.equals("y")) {
            System.out.println();
            System.out.print("Moi nhap nam: ");
            int nam = (int) CHECK.kiemTraSoNguyenDuong();
            System.out.print("Moi nhap thang: ");
            int thang = (int) CHECK.kiemTraSoNguyenDuong();
            if (thang > 0 && thang < 13) {
                choice2 = "y";
                while (choice2.equals("y")) {
                    add(nvList, ccList, thang, nam);
                    fl.write(sortByMaNV());
                    System.out.println();
                    System.out.print("Ban co muon tiep tuc nhap thong tin vao bang luong " + thang + "/" + nam + " ( y | n ): ");
                    choice2 = CHECK.yesNoChoice();
                }
                System.out.print("Ban co muon tiep tuc nhap thong tin ( y | n ): ");
                choice1 = CHECK.yesNoChoice();
            } else {
                System.out.println("Thang khong ton tai.");
                System.out.println();
                System.out.print("Ban co muon tiep tuc nhap thong tin ( y | n ): ");
                choice1 = CHECK.yesNoChoice();
            }
        }
    }

    public void delete(int thang, int nam) {
        System.out.print("Nhap ma nhan vien can xoa khoi bang luong: ");
        String maNV = CHECK.kiemTraMaNhanVien();
        boolean isExist = false;
        for (int i = 0; i < luongList.length; ++i) {
            if (luongList[i].getMaNV().equals(maNV) && luongList[i].getThang() == thang && luongList[i].getNam() == nam) {
                isExist = true;
                luongList = remove(luongList, i);
                break;
            }
        }
        if (!isExist) {
            System.out.println("Ma nhan vien " + maNV + " khong ton tai.");
        } else {
            fl.write(sortByMaNV());
        }
    }

    public void deleteBangLuongTheoThang(int thang, int nam) {
        boolean isExist = false;
        for (int i = 0; i < luongList.length; ++i) {
            if (luongList[i].getThang() == thang && luongList[i].getNam() == nam) {
                isExist = true;
                luongList = remove(luongList, i);
            }
        }
        if (!isExist) {
            System.out.println("Khong co bang luong " + thang + "/" + nam + " trong danh sach.");
        } else {
            fl.write(sortByMaNV());
        }
    }

    public void delete(ArrayList<NHANVIEN> nvList, CHAMCONG[] ccList) {
        if (isEmpty(luongList)) {
            System.out.println("Khong ton tai bang cham luong nao.");
        } else {
            checkFirst(nvList);
            luongList = checkFirst(ccList);
            fl.write(luongList);
            System.out.println("Nhap 1 de xoa luong tung ca nhan.");
            System.out.println("Nhap 2 de xoa 1 bang luong.");
            System.out.print("Moi lua chon: ");
            int choice = (int) CHECK.kiemTraSoNguyenDuong();
            switch (choice) {
                case 1: {
                    String choice1 = "y", choice2 = "y";
                    while (choice1.equals("y")) {
                        choice2 = "y";
                        System.out.print("Moi nhap nam: ");
                        int nam = (int) CHECK.kiemTraSoNguyenDuong();
                        System.out.print("Moi nhap thang: ");
                        int thang = (int) CHECK.kiemTraSoNguyenDuong();
                        if (thang > 0 && thang < 13) {
                            while (choice2.equals("y")) {
                                delete(thang, nam);
                                System.out.print("Ban co muon tiep tuc xoa thong tin cua bang luong " + thang + "/" + nam + " ( Y | N ): ");
                                choice2 = CHECK.yesNoChoice();
                            }
                            System.out.print("Ban co muon tiep tuc xoa thong tin ( y | n ): ");
                            choice1 = CHECK.yesNoChoice();
                        } else {
                            System.out.print("Thang khong ton tai.");
                            System.out.print("Ban co muon tiep tuc xoa thong tin ( y | n ): ");
                            choice1 = CHECK.yesNoChoice();
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.print("Nhap nam cua bang luong can xoa: ");
                    int nam = (int) CHECK.kiemTraSoNguyenDuong();
                    System.out.print("Nhap thang cua bang luong can xoa: ");
                    int thang = (int) CHECK.kiemTraSoNguyenDuong();
                    if (thang > 0 && thang < 13) {
                        deleteBangLuongTheoThang(thang, nam);
                    } else {
                        System.out.println("Thang khong ton tai.");
                    }
                    break;
                }
                default: {
                    System.out.println("Nhap sai lua chon.");
                    break;
                }
            }
        }
    }

    public LUONG[] sortByDate(LUONG[] list) {
        if (isEmpty(list)) {
            return null;
        } else {
            int min;
            for (int i = 0; i < list.length - 1; ++i) {
                min = i;
                for (int j = i + 1; j < list.length; ++j) {
                    if (CHECK.compareDate(list[j].getThang(), list[j].getNam(), list[min].getThang(), list[min].getNam()) == -1) {
                        min = j;
                    }
                }
                if (min != i) {
                    LUONG temp = list[i];
                    list[i] = list[min];
                    list[min] = temp;
                }
            }
            return list;
        }
    }

    public LUONG[] sort(LUONG[] list) {
        if (isEmpty(list)) {
            return null;
        } else {
            int min;
            for (int i = 0; i < list.length - 1; ++i) {
                min = i;
                for (int j = i + 1; j < list.length; ++j) {
                    if (CHECK.getNumberOfMaNV(list[j].getMaNV()) < CHECK.getNumberOfMaNV(list[min].getMaNV())) {
                        min = j;
                    }
                }
                if (min != i) {
                    LUONG temp = list[i];
                    list[i] = list[min];
                    list[min] = temp;
                }
            }
            return list;
        }
    }

    public LUONG[] sortByMaNV() {
        if (isEmpty(luongList)) {
            return null;
        } else {
            LUONG[] arrC = null;
            for (int i = 0; i < luongList.length; ++i) {
                if (CHECK.getFirstLetterOfMaNV(luongList[i].getMaNV()).equals("C")) {
                    arrC = add(arrC, luongList[i]);
                }
            }
            arrC = sort(arrC);
            LUONG[] arrP = null;
            for (int i = 0; i < luongList.length; ++i) {
                if (CHECK.getFirstLetterOfMaNV(luongList[i].getMaNV()).equals("P")) {
                    arrP = add(arrP, luongList[i]);
                }
            }
            arrP = sort(arrP);
            LUONG[] arrT = null;
            for (int i = 0; i < luongList.length; ++i) {
                if (CHECK.getFirstLetterOfMaNV(luongList[i].getMaNV()).equals("T")) {
                    arrT = add(arrT, luongList[i]);
                }
            }
            arrT = sort(arrT);

            arrC = add(arrC, arrP);
            arrC = add(arrC, arrT);
            return arrC;
        }
    }

    public void printList(ArrayList<NHANVIEN> nvList, CHAMCONG[] ccList, int thang, int nam) {
        if (isEmpty(luongList)) {
            System.out.println("Khong ton tai bang luong " + thang + "/" + nam);
        } else {
            checkFirst(nvList);
            luongList = checkFirst(ccList);
            fl.write(sortByMaNV());
            if (isExistInList(thang, nam) == true) {
                luongList = sortByMaNV();
                System.out.println("\n+--------------------------------------------------------------------"
                        + "-----------------------------------------------------------------------------+");
                System.out.println("|                                                                "
                        + "BANG LUONG " + thang + "/" + nam + "                                                               |");
                System.out.println("+--------------------------------------------------------------------"
                        + "-----------------------------------------------------------------------------+");
                System.out.printf("| %-12s | %-30s | %-20s | %18s | %-10s | %-17s | %-17s |\n", "Ma nhan vien",
                        "Ho ten nhan vien", "Chuc vu", "Luong co ban (VND)", "He so luong", "Tong so ngay cong", "Luong thang (VND)");
                System.out.println("+--------------------------------------------------------------------"
                        + "-----------------------------------------------------------------------------+");
                for (int i = 0; i < luongList.length; ++i) {
                    if (luongList[i].getThang() == thang && luongList[i].getNam() == nam) {
                        System.out.printf("| %-12s | %-30s | %-20s | %18s | %11s | %17s | %17s |\n",
                                luongList[i].getMaNV(), CHECK.getNhanVien(nvList, luongList[i].getMaNV()).getHoTen(),
                                CHECK.getNhanVien(nvList, luongList[i].getMaNV()).getChucVu(),
                                CHECK.changeMoney(luongList[i].getLuongCoBan()), luongList[i].getHeSoLuong(),
                                DANHSACHCHAMCONG.getChamCong(ccList, luongList[i].getMaNV(), thang, nam).tongNgayCong(),
                                CHECK.changeMoney(luongList[i].getLuong()));
                    }
                }
                System.out.println("+--------------------------------------------------------------------"
                        + "-----------------------------------------------------------------------------+");
                System.out.print("Enter de tiep tuc ");
                Main.st.nextLine();
            } else {
                System.out.println("Khong ton tai bang luong " + thang + "/" + nam);
            }
        }
    }

    public void printPersonal(ArrayList<NHANVIEN> nvList, CHAMCONG[] ccList) {
        if (isEmpty(luongList)) {
            System.out.println("Khong ton tai bang cham luong nao.");
        } else {
            // Kiểm tra lại bảng lương và bảng chấm công có khớp dữ liệu với nhau không
            // Ví dụ khi ta xóa dữ liệu bên bảng chấm công thì bảng lương cũng sẽ tự xóa dữ liệu
            luongList = checkFirst(ccList);
            fl.write(sortByMaNV());
            System.out.print("Moi nhap ma nhan vien: ");
            String maNV = CHECK.kiemTraMaNhanVien();
            if (CHECK.isInList(nvList, maNV) != -1 && DANHSACHCHAMCONG.isInList(ccList, maNV) != -1) {
                LUONG[] list = null;
                list = add(list, luongList);
                list = sortByDate(list);
                int count = 0;
                for (int i = 0; i < list.length; ++i) {
                    if (list[i].getMaNV().equals(maNV)) {
                        ++count;
                        if (count == 1) {
                            System.out.println("\n| Ma nhan vien: " + list[i].getMaNV() + " | Ho va ten: "
                                    + nvList.get(CHECK.isInList(nvList, maNV)).getHoTen() + " | Chuc vu: "
                                    + nvList.get(CHECK.isInList(nvList, maNV)).getChucVu() + " |");
                            System.out.println("+--------------------------------------------------------------------------------------+");
                            System.out.printf("| %-9s | %18s | %-10s | %-17s | %-17s |\n", "Thang/Nam", "Luong co ban (VND)", "He so luong",
                                    "Tong so ngay cong", "Luong thang (VND)");
                            System.out.println("+--------------------------------------------------------------------------------------+");
                        }
                        System.out.printf("| %2d/%-6d | %18s | %11s | %17s | %17s |\n", list[i].getThang(),
                                list[i].getNam(), CHECK.changeMoney(list[i].getLuongCoBan()),
                                list[i].getHeSoLuong(), DANHSACHCHAMCONG.getChamCong(ccList, list[i].getMaNV(),
                                list[i].getThang(), list[i].getNam()).tongNgayCong(), CHECK.changeMoney(list[i].getLuong()));
                    }
                }
                if (count != 0) {
                    System.out.println("+--------------------------------------------------------------------------------------+");
                    System.out.print("Enter de tiep tuc ");
                    Main.st.nextLine();
                } else {
                    System.out.println("Khong co nhan vien trong bang luong");
                }
            } else {
                System.out.println("Ma nhan vien khong ton tai.");
            }
        }
    }

    public static void printPersonal(ArrayList<NHANVIEN> nvList, CHAMCONG[] ccList, LUONG[] list, String maNV, int thang, int nam) {
        System.out.printf("| %-12s | %-30s | %-20s | %18s | %11s | %17s | %17s |\n",
                list[isInList(list, maNV, thang, nam)].getMaNV(), CHECK.getNhanVien(nvList, list[isInList(list, maNV, thang, nam)].getMaNV()).getHoTen(),
                CHECK.getNhanVien(nvList, list[isInList(list, maNV, thang, nam)].getMaNV()).getChucVu(),
                CHECK.changeMoney(list[isInList(list, maNV, thang, nam)].getLuongCoBan()), list[isInList(list, maNV, thang, nam)].getHeSoLuong(),
                DANHSACHCHAMCONG.getChamCong(ccList, list[isInList(list, maNV, thang, nam)].getMaNV(), thang, nam).tongNgayCong(),
                CHECK.changeMoney(list[isInList(list, maNV, thang, nam)].getLuong()));

    }

    public LUONG[] checkFirst(CHAMCONG[] ccList) {
        for (int i = 0; i < luongList.length; ++i) {
            if (DANHSACHCHAMCONG.getChamCong(ccList, luongList[i].getMaNV(), luongList[i].getThang(), luongList[i].getNam()) == null) {
                luongList = remove(luongList, i);
            }
        }
        return luongList;
    }

    public void checkFirst(ArrayList<NHANVIEN> nvList) {
        boolean flag = false;
        for (int i = 0; i < luongList.length; i++) {
            if (CHECK.isInList(nvList, luongList[i].getMaNV()) == -1) {
                flag = true;
                luongList = remove(luongList, i);
                i--;
            }
        }
        if (flag) {
            fl.write(sortByMaNV());
        }
    }

    public static void luongMenu() {
        System.out.println();
        System.out.println("#----------------- MENU LUONG ------------------#");
        System.out.println("|   Nhap 1 de them bang luong.                  |");
        System.out.println("|   Nhap 2 de xoa tinh luong.                   |");
        System.out.println("|   Nhap 3 de in bang tinh luong.               |");
        System.out.println("|   Nhap 4 de in bang tinh luong cua ca nhan.   |");
        System.out.println("|   Nhap 0 de thoat.                            |");
        System.out.println("#-----------------------------------------------#");
    }

    public void menu() {
        int input;
        DANHSACHCHAMCONG ccManager = new DANHSACHCHAMCONG();
        boolean flag = false;
        while (flag == false) {
            luongMenu();
            System.out.print("Moi lua chon: ");
            input = (int) CHECK.kiemTraSoNguyenDuong();
            switch (input) {
                case 0: {
                    System.out.println("Ban da thoat khoi quan ly luong.");
                    flag = true;
                    break;
                }
                case 1: {
                    add(DANHSACHNHANVIEN.listNhanVien, ccManager.getCcList());
                    break;
                }
                case 2: {
                    this.delete(DANHSACHNHANVIEN.listNhanVien, ccManager.getCcList());
                    break;
                }
                case 3: {
                    System.out.print("Nhap nam: ");
                    int nam = (int) CHECK.kiemTraSoNguyenDuong();
                    System.out.print("Nhap thang: ");
                    int thang = (int) CHECK.kiemTraSoNguyenDuong();
                    if (thang > 0 && thang < 13) {
                        this.printList(DANHSACHNHANVIEN.listNhanVien, ccManager.getCcList(), thang, nam);
                    } else {
                        System.out.println("Thang khong ton tai.");
                    }
                    break;
                }
                case 4: {
                    this.printPersonal(DANHSACHNHANVIEN.listNhanVien, ccManager.getCcList());
                    break;
                }
                default: {
                    System.out.println("Nhap sai lua chon.");
                    break;
                }
            }
        }
    }

}
