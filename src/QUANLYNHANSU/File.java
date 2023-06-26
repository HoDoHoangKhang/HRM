package QUANLYNHANSU;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class File {

    public static void docFileNhanVien() {
        try {
            FileInputStream f = new FileInputStream("FileNhanVien.txt");
            InputStreamReader rf = new InputStreamReader(f, "UTF-8");
            BufferedReader br = new BufferedReader(rf);
            String lineList[];
            String line = br.readLine();
            line = br.readLine();
            NHANVIEN a = null;
            NGAY n = null;
            DIACHI d = null;
            while (line != null) {
                lineList = line.split("#");
                if (lineList[0].charAt(0) == 'C') {
                    a = new NHANVIENCHINH();
                } else if (lineList[0].charAt(0) == 'T') {
                    a = new THUCTAPSINH();
                } else {
                    a = new NHANVIENPHU();
                }
                a.setMaNhanVien(lineList[0]);
                a.setHoTen(lineList[1]);
                n = new NGAY();
                n.taoNgay(lineList[2]);
                a.setNgaySinh(n);
                a.setGioiTinh(lineList[3]);
                a.setSoDienThoai(lineList[4]);
                d = new DIACHI();
                d.taoDiaChi(lineList[5]);
                a.setDiaChi(d);
                a.setChucVu(lineList[6]);
                n = new NGAY();
                n.taoNgay(lineList[7]);
                a.getHopDong().setNgayBatDauHopDong(n);
                n = new NGAY();
                n.taoNgay(lineList[8]);
                a.getHopDong().setNgayKetThucHopDong(n);

                if (a instanceof NHANVIENCHINH nvc) {
                    nvc.setLuongCoBan(Long.parseLong(lineList[9]));
                    nvc.setHeSoLuong(Float.parseFloat(lineList[10]));
                    nvc.setEmail(lineList[11]);
                    nvc.setMaPhongBan(lineList[13]);
                    nvc.setSoDuAnDaThucHien(Integer.parseInt(lineList[14]));
                    nvc.setMaDuAnDangLam(lineList[15]);
                } else if (a instanceof THUCTAPSINH tts) {
                    tts.setEmail(lineList[11]);
                    tts.setPhuCap(Long.parseLong(lineList[12]));
                    tts.setMaPhongBan(lineList[13]);
                } else {
                    ((NHANVIENPHU) a).setLuongCoBan(Long.parseLong(lineList[9]));
                    ((NHANVIENPHU) a).setHeSoLuong(Float.parseFloat(lineList[10]));
                }
                a.getHopDong().setThoiHanHopDong(Integer.parseInt(lineList[16]));
                a.getHopDong().setThoiGianConLaiHopDong(Integer.parseInt(lineList[17]));
                DANHSACHNHANVIEN.listNhanVien.add(a);
                line = br.readLine();
            }
            br.close();
            rf.close();
            f.close();
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("Da xay ra loi doc file Nhan Vien !");
        }
    }

    public static void ghiFileNhanVien() {
        try {
            FileOutputStream f = new FileOutputStream("FileNhanVien.txt");
            OutputStreamWriter wf = new OutputStreamWriter(f, "UTF-8");
            BufferedWriter bw = new BufferedWriter(wf);
            bw.write("Mã nhân viên|Tên nhân viên|Ngày sinh|Giới tính|Số điện thoại|Địa chỉ|Chức vụ|Ngày bắt đầu hợp đồng|Ngày kết thúc hợp đồng|Lương cơ bản|Hệ số lương|Email|Phụ Cấp|Mã phòng ban|Số dự án đã thực hiện|mã dự án đang làm|Thời hạn hợp đồng|Thời gian còn lại hợp đồng\n");
            for (NHANVIEN i : DANHSACHNHANVIEN.listNhanVien) {
                bw.write(i.getMaNhanVien() + "#");
                bw.write(i.getHoTen() + "#");
                bw.write(i.getNgaySinh() + "#");
                bw.write(i.getGioiTinh() + "#");
                bw.write(i.getSoDienThoai() + "#");
                bw.write(i.diaChi.toString().trim() + "#");
                bw.write(i.getChucVu() + "#");
                bw.write(i.getHopDong().getNgayBatDauHopDong() + "#");
                bw.write(i.getHopDong().getNgayKetThucHopDong() + "#");
                if (i instanceof NHANVIENCHINH) {
                    bw.write(((NHANVIENCHINH) i).getLuongCoBan() + "#");
                    bw.write(((NHANVIENCHINH) i).getHeSoLuong() + "#");
                    bw.write(((NHANVIENCHINH) i).getEmail() + "#");
                    bw.write("___#");
                    bw.write(((NHANVIENCHINH) i).getMaPhongBan() + "#");
                    bw.write(((NHANVIENCHINH) i).getSoDuAnDaThucHien() + "#");
                    bw.write(((NHANVIENCHINH) i).getMaDuAnDangLam() + "#");
                } else if (i instanceof THUCTAPSINH){
                    bw.write("___#");
                    bw.write("___#");
                    bw.write(((THUCTAPSINH) i).getEmail() + "#");
                    bw.write(((THUCTAPSINH) i).getPhuCap() + "#");
                    bw.write(((THUCTAPSINH) i).getMaPhongBan() + "#");
                    bw.write("___#");
                    bw.write("___#");
                } else {
                    bw.write(((NHANVIENPHU) i).getLuongCoBan() + "#");
                    bw.write(((NHANVIENPHU) i).getHeSoLuong() + "#");
                    bw.write("___#");
                    bw.write("___#");
                    bw.write("___#");
                    bw.write("___#");
                    bw.write("___#");
                }
                bw.write(i.getHopDong().getThoiHanHopDong() + "#");
                bw.write(i.getHopDong().getThoiGianConLaiHopDong() + "\n");
            }
            bw.close();
            wf.close();
            f.close();
        } catch (Exception e) {
            System.out.println("Da xay ra loi ghi file Nhan vien!");
        }
        return;
    }
//	public static void ghiFilePhongBan1() {
//	    try{
//	        FileOutputStream f = new FileOutputStream("FilePhongBan.txt");
//	        OutputStreamWriter wf = new OutputStreamWriter(f,"UTF-8");
//	        BufferedWriter bw = new BufferedWriter(wf);
//	        bw.write("Mã phòng ban#Mã trưởng phòng#Tên trưởng phòng#Số lượng nhân viên#Tên phòng ban#Lương toàn bộ phòng ban\n");
//	        for(NHANVIEN i : DANHSACHNHANVIEN.listNhanVien){
//	        	if(i instanceof NHANVIENCHINH && ((NHANVIENCHINH) i).getChucVu().equalsIgnoreCase("Truong Phong")) {// nếu nhân viên đó là trưởng phòng
//	        		// ghi ra mã phòng ban của trưởng phòng đó
//	            	bw.write(((NHANVIENCHINH) i).getMaPhongBan()+"#");
//	            	// ghi ra mã nhân viên của trưởng phòng
//	            	bw.write(((NHANVIENCHINH) i).getMaNhanVien()+"#");
//	            	//Ghi ra tên của trưởng phòng đó
//	            	bw.write(((NHANVIENCHINH) i).getHoTen()+"#");
//	            	// đếm nhân viên của phòng đó
//	            	int demNhanVien=0;
//	            	for(NHANVIEN j : DANHSACHNHANVIEN.listNhanVien) {
//	            		// nếu j là nhân viên chính và mã phòng ban của nhân viên j = mã phòng ban của trưởng phòng thì đếm
//	            		if(j instanceof NHANVIENCHINH && ((NHANVIENCHINH) j).getMaPhongBan().equalsIgnoreCase(((NHANVIENCHINH) i).getMaPhongBan())) 
//	            			demNhanVien++;
//	            		else if(j instanceof THUCTAPSINH && ((THUCTAPSINH) j).getMaPhongBan().equalsIgnoreCase(((NHANVIENCHINH) i).getMaPhongBan())) 
//	            			demNhanVien++;
//	            	}
//	            	bw.write(demNhanVien+"#");
//	            	// nếu mã của trưởng phòng là IT thì tên phòng là Phòng kĩ thuật
//	            	if(((NHANVIENCHINH) i).getMaPhongBan().equalsIgnoreCase("IT")) {
//	            		bw.write("Phong Ki Thuat"+"#");
//	            	}
//	            	// nếu mã của trưởng phòng là KD thì tên phòng là Phòng Kinh doanh
//	            	else if(((NHANVIENCHINH) i).getMaPhongBan().equalsIgnoreCase("KD")) {
//	            		bw.write("Phong Kinh Doanh"+"#");
//	            	}
//	            	// nếu mã của trưởng phòng là NS thì tên phòng là Phòng nhân sự
//	            	else if(((NHANVIENCHINH) i).getMaPhongBan().equalsIgnoreCase("NS")) {
//	            		bw.write("Phong Nhan Su"+"#");
//					}
//	            	// nếu mã của trưởng phòng là MK thì tên phòng là Phòng marketing
//	            	else if(((NHANVIENCHINH) i).getMaPhongBan().equalsIgnoreCase("MK")) {
//	            		bw.write("Phong Marketing"+"#");
//					}
//	            	else if(((NHANVIENCHINH) i).getMaPhongBan().equalsIgnoreCase("KT")) {
//	            		bw.write("Phong Ke Toan"+"#");
//					}
//	            	else if(((NHANVIENCHINH) i).getMaPhongBan().equalsIgnoreCase("CS")) {
//	            		bw.write("Phong CSKH"+"#");
//					}
//	            	else if(((NHANVIENCHINH) i).getMaPhongBan().equalsIgnoreCase("HC")) {
//	            		bw.write("Phong Hanh Chinh"+"#");
//					}
//	            	// đếm lương nhân viên của phòng ban
//	            	Double luongPhongBan=0.0;
//	            	for(NHANVIEN k : DANHSACHNHANVIEN.listNhanVien) {
//	            		if(k instanceof NHANVIENCHINH && ((NHANVIENCHINH) k).getMaPhongBan().equalsIgnoreCase(((NHANVIENCHINH) i).getMaPhongBan())) 
//	            			luongPhongBan=luongPhongBan+((NHANVIENCHINH) k).getLuong().getLuong();
//	            	}
//            		bw.write(luongPhongBan+"\n");
//
//	        	}
//	        }
//	        bw.close();
//	        wf.close();
//	        f.close();
//	    }catch(Exception e){
//	        System.out.println("Da xay ra loi!");
//	    }
//	    return;
//	}
    public static void ghiFilePhongBan() {
        try {
            FileOutputStream f = new FileOutputStream("FilePhongBan.txt");
            OutputStreamWriter wf = new OutputStreamWriter(f, "UTF-8");
            BufferedWriter bw = new BufferedWriter(wf);
            bw.write("Mã phòng ban#Mã trưởng phòng#Tên trưởng phòng#Số lượng nhân viên#Tên phòng ban#Lương toàn bộ phòng ban\n");
            for (PHONGBAN i : DANHSACHPHONGBAN.listPhongBan) {
                bw.write(i.getMaPhongBan() + "#");
                bw.write(i.getMaTruongPhong() + "#");
                bw.write(i.getTenTruongPhong() + "#");
                bw.write(i.getSoLuongNhanVien() + "#");
                bw.write(i.getTenPhongBan() + "#");
                bw.write(i.getLuongHangThang() + "\n");
            }
            bw.close();
            wf.close();
            f.close();
        } catch (Exception e) {
            System.out.println("Da xay ra loi ghi File phong ban!");
        }
        return;
    }

    public static void docFilePhongBan() {
        try {
            FileInputStream f = new FileInputStream("FilePhongBan.txt");
            InputStreamReader rf = new InputStreamReader(f, "UTF-8");
            BufferedReader br = new BufferedReader(rf);
            String lineList[];
            String line = br.readLine();
            line = br.readLine();
            PHONGBAN a = null;
            while (line != null) {
                lineList = line.split("#");
                a = new PHONGBAN();
                a.setMaPhongBan(lineList[0]);
                a.setMaTruongPhong(lineList[1]);
                a.setTenTruongPhong(lineList[2]);
                a.setSoLuongNhanVien(Integer.parseInt(lineList[3]));
                a.setTenPhongBan(lineList[4]);
                a.setLuongHangThang(Double.parseDouble(lineList[5]));
                DANHSACHPHONGBAN.listPhongBan.add(a);
                line = br.readLine();
            }
            br.close();
            rf.close();
            f.close();
        } catch (Exception e) {
            System.out.println("Da xay ra loi doc file phong ban!");
        }
    }

    public static void ghiFileDuAn() {
        try {
            FileOutputStream f = new FileOutputStream("FileDuAn.txt");
            OutputStreamWriter wf = new OutputStreamWriter(f, "UTF-8");
            BufferedWriter bw = new BufferedWriter(wf);
            bw.write("Mã dự án#Tên dự án#kinh phí thực hiện#ngày bắt đầu dự án#Thời hạn dự án#Ngày kết thúc dự án\n");
            for (DUAN i : DANHSACHDUAN.listDuAn) {
                bw.write(i.getMaDuAn() + "#");
                bw.write(i.getTenDuAn() + "#");
                bw.write(i.getKinhPhiThucHien() + "#");
                bw.write(i.getNgayBatDauDuAn() + "#");
                bw.write(i.getThoiHanDuAn() + "#");
                bw.write(i.getNgayKetThucDuAn() + "\n");
            }
            bw.close();
            wf.close();
            f.close();
        } catch (Exception e) {
            System.out.println("Da xay ra loi ghi file du an!");
        }
        return;
    }

    public static void docFileDuAn() {
        try {
            FileInputStream f = new FileInputStream("FileDuAn.txt");
            InputStreamReader rf = new InputStreamReader(f, "UTF-8");
            BufferedReader br = new BufferedReader(rf);
            String lineList[];
            String line = br.readLine();
            line = br.readLine();
            DUAN a = null;
            NGAY n = null;
            while (line != null) {
                lineList = line.split("#");
                a = new DUAN();
                a.setMaDuAn(lineList[0]);
                a.setTenDuAn(lineList[1]);
                a.setKinhPhiThucHien(Integer.parseInt(lineList[2]));
                n = new NGAY();
                n.taoNgay(lineList[3]);
                a.setNgayBatDauDuAn(n);
                a.setThoiHanDuAn(Integer.parseInt(lineList[4]));
                n = new NGAY();
                n.taoNgay(lineList[5]);
                a.setNgayKetThucDuAn(n);
                DANHSACHDUAN.listDuAn.add(a);
                line = br.readLine();
            }
            br.close();
            rf.close();
            f.close();
        } catch (Exception e) {
            System.out.println("Da xay ra loi doc file du an!");
        }
    }
    
//    private static final String CHAMCONG_FILE_NAME = "FileChamCong.txt";
//
//    public static void ghiFileChamCong(CHAMCONG[] ccList) {
//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        try {
//            fos = new FileOutputStream(new java.io.File(CHAMCONG_FILE_NAME));
//            oos = new ObjectOutputStream(fos);
//            oos.writeObject(ccList);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            closeStream(fos);
//            closeStream(oos);
//        }
//    }
//
//    public static CHAMCONG[] docFileChamCong() {
//        CHAMCONG[] ccList = null;
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
//        try {
//            fis = new FileInputStream(new java.io.File(CHAMCONG_FILE_NAME));
//            ois = new ObjectInputStream(fis);
//            ccList = (CHAMCONG[]) ois.readObject();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            closeStream(fis);
//            closeStream(ois);
//        }
//        return ccList;
//    }
//
//    private static void closeStream(InputStream inputStream) {
//        if (inputStream != null) {
//            try {
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private static void closeStream(OutputStream outputStream) {
//        if (outputStream != null) {
//            try {
//                outputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
