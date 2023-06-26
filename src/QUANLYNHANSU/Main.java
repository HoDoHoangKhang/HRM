/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QUANLYNHANSU;

import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static Scanner st = new Scanner(System.in);
    public static Scanner fl = new Scanner(System.in);
    public static Scanner db = new Scanner(System.in);	
    public static void main(String[] agrs) {
        File.docFileNhanVien();
        File.docFilePhongBan();
        File.docFileDuAn();
        DANHSACHCHAMCONG ccManager = new DANHSACHCHAMCONG();
        DANHSACHLUONG luongManager = new DANHSACHLUONG();
        DANHSACHTHANNHAN tnManager = new DANHSACHTHANNHAN();
        DANHSACHHOPDONG.xoaNhanVienKhiHetHopDong();
        boolean kt = true;
        while (kt) {
            MENU.menu_QLNS();
            int chon = (int) CHECK.kiemTraSoNguyenDuong();
            switch (chon) {
                case 1:
                    DANHSACHNHANVIEN.menu();
                    break;
                case 2:
                    DANHSACHPHONGBAN.menu();
                    break;
                case 3:
                    DANHSACHHOPDONG.menu();
                    break;
                case 4:
                    DANHSACHDUAN.menu();
                    break;
                case 5:
                    ccManager.menu();
                    break;
                case 6:
                    luongManager.menu();
                    break;
                case 7: 
                    tnManager.menu(DANHSACHNHANVIEN.listNhanVien);
                    break;
                case 8:
                    System.out.println("THOAT CHUONG TRINH THANH CONG!");
                    return;
                default:
                    System.out.println("Nhap sai! Moi nhap lai");
            }
        }
        in.close();
        st.close();
        fl.close();
        db.close();

    }
}
