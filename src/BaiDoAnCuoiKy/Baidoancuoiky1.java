package BaiDoAnCuoiKy;

import java.util.*;

public class Baidoancuoiky1{
    static Scanner sc=new Scanner(System.in);
    static ArrayList<SanPham> danhSachSanPham = new ArrayList<SanPham>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("-------MENU-------");
            System.out.println("1. Nhập thông tin sản phẩm");
            System.out.println("2. Tính giá trị thành tiền cho các sản phẩm đã bán");
            System.out.println("3. Sắp xếp danh sách sản phẩm theo chiều giảm dần của thành tiền");
            System.out.println("4. Sắp xếp danh sách sản phẩm theo chiều tăng dần của giá bán");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("Q. Thoát chương trình");
            System.out.println("-------------------");

            System.out.print("Nhập lựa chọn của bạn: ");
            String luaChon = sc.nextLine();

            switch (luaChon) {
                case "1":
                    nhapThongTinSanPham();
                    break;
                case "2":
                    tinhGiaTriThanhTien();
                    break;
                case "3":
                    sapXepTheoThanhTienGiamDan();
                    break;
                case "4":
                    sapXepTheoGiaBanTangDan();
                    break;
                case "5":
                    timKiemTheoTen();
                    break;
                case "Q":
                case "q":
                    System.out.println("Chương trình đã thoát.");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
            }
        }
    }

    public static void nhapThongTinSanPham() {
        System.out.print("Nhập tên sản phẩm: ");
        String tenSanPham = sc.nextLine();

        System.out.print("Nhập đơn vị tính: ");
        String donViTinh = sc.nextLine();

        System.out.print("Nhập số lượng: ");
        int soLuong = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhập giá bán: ");
        double giaBan = sc.nextDouble();
        sc.nextLine();

        SanPham sanPham = new SanPham(tenSanPham, donViTinh, soLuong, giaBan);
        danhSachSanPham.add(sanPham);
        System.out.println("Thông tin sản phẩm đã được thêm vào danh sách.");
    }

    public static void tinhGiaTriThanhTien() {
        if (danhSachSanPham.isEmpty()) {
            System.out.println("Danh sách sản phẩm hiện đang trống.");
            return;
        }

        for (SanPham sanPham : danhSachSanPham) {
            double thanhTien = sanPham.getSoLuong() * sanPham.getGiaBan();
            sanPham.setThanhTien(thanhTien);
            System.out.println("Thành tiền của sản phẩm " + sanPham.getTenSanPham() + " là " + thanhTien);

}
    }

    public static void sapXepTheoThanhTienGiamDan() {
        if (danhSachSanPham.isEmpty()) {
            System.out.println("Danh sách sản phẩm hiện đang trống.");
            return;
        }

        Collections.sort(danhSachSanPham, new Comparator<SanPham>() {
            
            public int compare(SanPham sp1, SanPham sp2) {
                return Double.compare(sp2.getThanhTien(), sp1.getThanhTien());
            }
        });

        System.out.println("Danh sách sản phẩm sau khi sắp xếp theo chiều giảm dần của thành tiền:");
        for (SanPham sanPham : danhSachSanPham) {
            System.out.println(sanPham.toString());
        }
    }

    public static void sapXepTheoGiaBanTangDan() {
        if (danhSachSanPham.isEmpty()) {
            System.out.println("Danh sách sản phẩm hiện đang trống.");
            return;
        }

        Collections.sort(danhSachSanPham, new Comparator<SanPham>() {
            @Override
            public int compare(SanPham sp1, SanPham sp2) {
                return Double.compare(sp1.getGiaBan(), sp2.getGiaBan());
            }
        });

        System.out.println("Danh sách sản phẩm sau khi sắp xếp theo chiều tăng dần của giá bán:");
        for (SanPham sanPham : danhSachSanPham) {
            System.out.println(sanPham.toString());
        }
    }

    public static void timKiemTheoTen() {
        if (danhSachSanPham.isEmpty()) {
            System.out.println("Danh sách sản phẩm hiện đang trống.");
            return;
        }

        System.out.print("Nhập tên sản phẩm cần tìm kiếm: ");
        String tuKhoa = sc.nextLine();

        boolean timThay = false;
        for (SanPham sanPham : danhSachSanPham) {
            if (sanPham.getTenSanPham().contains(tuKhoa)) {
                System.out.println(sanPham.toString());
                timThay = true;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy sản phẩm nào phù hợp với từ khóa.");
        }
    }
}

class SanPham {
    private String tenSanPham;
    private String donViTinh;
    private int soLuong;
    private double giaBan;
    private double thanhTien;

    public SanPham(String tenSanPham, String donViTinh, int soLuong, double giaBan) {
        this.tenSanPham = tenSanPham;
        this.donViTinh = donViTinh;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
        @Override
        public String toString() {
            return "Tên sản phẩm: " + tenSanPham + ", Đơn vị tính: " + donViTinh + ", Số lượng: " + soLuong + ", Giá bán: " + giaBan + ", Thành tiền: " + thanhTien;
        }
    }