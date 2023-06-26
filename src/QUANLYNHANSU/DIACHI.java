package QUANLYNHANSU;

public class DIACHI {

    private String tenQuan;
    private String tenThanhPho;

    public DIACHI() {
    }

    public DIACHI(String tenQuan, String tenThanhPho) {
        this.tenQuan = tenQuan;
        this.tenThanhPho = tenThanhPho;
    }

    public String getTenQuan() {
        return tenQuan;
    }

    public void setTenQuan(String tenQuan) {
        this.tenQuan = tenQuan;
    }

    public String getTenThanhPho() {
        return tenThanhPho;
    }

    public void setTenThanhPho(String tenThanhPho) {
        this.tenThanhPho = tenThanhPho;
    }

    public void nhapDiaChi() {
        System.out.print("\tTen quan (Huyen) -> ");
        String quan = Main.st.nextLine();
        System.out.print("\tTen thanh pho (Tinh) -> ");
        String thanhPho = Main.st.nextLine();
        while (!CHECK.kiemTraDiaChi(quan, thanhPho)) {
            System.out.println("Khong hop le! Moi nhap lai:");
            System.out.print("Ten quan (Huyen) -> ");
            quan = Main.st.nextLine();
            System.out.print("Ten thanh pho (Tinh) -> ");
            thanhPho = Main.st.nextLine();
        }
        this.tenQuan = CHECK.inHoaChuCaiDauMoiTu(quan);
        this.tenThanhPho = CHECK.inHoaChuCaiDauMoiTu(thanhPho);
    }

    public void taoDiaChi(String d) {
        String a[] = d.split(",");
        this.tenQuan = a[0].trim();
        this.tenThanhPho = a[1].trim();
    }

    @Override
    public String toString() {
        return this.tenQuan.trim() + ", " + this.tenThanhPho.trim();
    }
}
