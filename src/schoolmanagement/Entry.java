/*
 * purpose: quản lý trường học và xử lý nghiệp vụ liên quan
 * date created: 20/9/2022
 * author: Van Truong
 * version: 1.0
 */

package schoolmanagement;

import schoolmanagement.model.TruongHoc;

import java.util.Scanner;

public class Entry {
    // hàm nhập menu
    private static String nhapMenu(Scanner scan) {
        System.out.println("======================================================================");
        System.out.println("||  0. Thoat");
        System.out.println("||  1. Xuat danh sach nhan su");
        System.out.println("||  2. Tinh so nam giang day cua giao vien");
        System.out.println("||  3. Tim giao vien co tham nien cao nhat");
        System.out.println("||  4. Tim giao vien co tham nien > 5 va chuyen mon thuoc khoi tu nhien");
        System.out.println("||  5. Tinh diem trung binh cua hoc sinh");
        System.out.println("||  6. Tim diem trung binh cao nhat cua hoc sinh");
        System.out.println("||  7. Tim hoc sinh co diem trung binh cao nhat");
        System.out.println("||  8. Xep loai hoc sinh dua tren DTB");
        System.out.println("||  9. Sap xep hoc sinh theo DTB giam dan");
        System.out.println("|| 10. Sap xep ten hoc sinh theo thu tu ABC");

        System.out.print("|| Lua chon cua ban: ");
        String answer = scan.nextLine();
        System.out.println("======================================================================");
        return answer;
    }

    // hàm xử lý menu
    private static void xuLyMenu(Scanner scan, TruongHoc truongHoc) {
        boolean flag = true;

        do {
            String answer = nhapMenu(scan);
            switch (answer) {

                case "0":// thoát
                    flag = false;
                    break;

                case "1":// xuất DS nhân sự
                    truongHoc.xuatAll();
                    break;

                case "2":// tính số năm giảng dạy của giáo viên
                    truongHoc.tinhSoNamGiangDayAll();
                    break;

                case "3":// tìm giáo viên có thâm niên cao nhất
                    truongHoc.timGiaoVienThamNienCaoNhat();
                    break;

                case "4":// tìm giáo viên có thâm niên > 5 và chuyên môn thuộc khối tự nhiên
                    truongHoc.timGVThamNienLonHon5ChuyenMonKhoiTuNhien();
                    break;

                case "5":// tính điểm trung bình của học sinh
                    truongHoc.tinhDiemTrungBinhAll();
                    break;

                case "6": // tìm điểm trung bình cao nhất của học sinh
                    truongHoc.timDiemTrungBinhCaoNhat();
                    break;

                case "7":// tìm học sinh có ĐTB cao nhất
                    truongHoc.timHocSinhCoDTBCaoNhat();
                    break;

                case "8":// xếp loại học sinh dựa trên ĐTB
                    truongHoc.xepLoaiHocSinhAll();
                    break;

                case "9":// sắp xếp học sinh dựa trên ĐTB giảm dần
                    truongHoc.sapXepHocSinhDuaTrenDTBGiamDan();
                    break;

                case "10":// sắp xếp tên học sinh theo thứ tự ABC
                    truongHoc.sapXepTenHocSinhTheoThuTuABC();
                    break;

                default:
                    System.out.println("<< Vui long nhap so tu 0 den 10! >>");
                    break;
            }
        } while (flag);
    }

    // hàm main
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TruongHoc truongHoc = new TruongHoc();

        // đọc dữ liệu từ file và ghi vào danh sách
        truongHoc.docDuLieuFile("src/schoolmanagement/textfile/NhanSu.txt");

        // xử lý menu
        xuLyMenu(scan, truongHoc);
    }
}
