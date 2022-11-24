/*
 * purpose: quản lý trường học và xử lý nghiệp vụ liên quan
 * date created: 20/9/2022
 * author: Van Truong
 * version: 1.0
 */

package schoolmanagement.model;

import java.util.Scanner;

public class TruongHoc {
	/* ATTRIBUTES */
	private DanhSachNhanSu objListNhanSu;

	/* GET, SET METHODS */
	// phương thức truy xuất giá trị thuộc tính objListNhanSu
	public DanhSachNhanSu getObjListNhanSu() {
		return this.objListNhanSu;
	}

	// phương thức thiết lập giá trị thuộc tính objListNhanSu
	public void setObjListNhanSu(DanhSachNhanSu objListNhanSu) {
		this.objListNhanSu = objListNhanSu;
	}

	/* CONSTRUCTOR METHODS */
	// phương thức khởi tạo mặc định không tham số
	public TruongHoc() {
		this.objListNhanSu = new DanhSachNhanSu();// khởi tạo DanhSachNhanSu
	}

	// phương thức khởi tạo có sử dụng tham số để truyền giá trị cho thuộc tính
	public TruongHoc(DanhSachNhanSu objListNhanSu) {
		this.objListNhanSu = objListNhanSu;
	}

	/* INPUT, OUTPUT METHODS */
	// phương thức nhập dữ liệu tất cả nhân sự trong danh sách
	public void nhapAll(Scanner scan) {
		this.objListNhanSu.nhapAll(scan);
	}

	// phương thức xuất dữ liệu tất cả nhân sự trong danh sách
	public void xuatAll() {
		System.out.println("Danh sach nhan su:");
		if (this.objListNhanSu.getListNhanSu().size() == 0) {
			System.out.println("<< Danh sach khong co nhan su! >>");
		} else {
			this.objListNhanSu.xuatAll();
		}
	}

	/* BUSINESS METHODS */
	// phương thức đọc dữ liệu từ file
	public void docDuLieuFile(String src) {
		this.objListNhanSu.docDuLieuFile(src);
	}

	// phương thức thêm nhân sự vào danh sách
	public void themNhanSu(NhanSu ns) {
		this.objListNhanSu.themNhanSu(ns);
	}

	// phương thức kiểm tra danh sách có giáo viên hay không
	private boolean kiemTraCoGiaoVienHayKhong() {
		for (NhanSu ns : this.objListNhanSu.getListNhanSu()) {
			if (ns instanceof GiaoVien) {
				return true;
			}
		}
		return false;
	}

	// phương thức tính số năm giảng dạy tất cả GV trong danh sách
	public void tinhSoNamGiangDayAll() {
		System.out.println("Tinh so nam giang day cua giao vien:");
		if (!kiemTraCoGiaoVienHayKhong()) {
			System.out.println("<< Danh sach khong co giao vien! >>");
		} else {
			this.objListNhanSu.tinhSoNamGiangDayAll();
			System.out.println("<< Tinh so nam giang day thanh cong! >>");
		}
	}

	// phương thức kiểm tra tính số năm giảng dạy hay chưa
	private boolean kiemTraTinhSoNamGiangDayHayChua() {
		for (NhanSu ns : this.objListNhanSu.getListNhanSu()) {
			if (ns instanceof GiaoVien) {
				if (((GiaoVien) ns).getSoNamGiangDay() == -1) {
					return false;
				}
			}
		}
		return true;
	}

	// phương thức tìm giáo viên có thâm niên cao nhất
	public void timGiaoVienThamNienCaoNhat() {
		System.out.println("Giao vien co tham nien cao nhat:");
		if (!kiemTraCoGiaoVienHayKhong()) {
			System.out.println("<< Danh sach khong co giao vien! >>");
		} else if (!kiemTraTinhSoNamGiangDayHayChua()) {
			System.out.println("<< Vui long tinh so nam giang day! >>");
		} else {
			this.objListNhanSu.timGiaoVienThamNienCaoNhat();
		}
	}

	// phương thức tìm giáo viên có thâm niên > 5 và chuyên môn thuộc khối tự nhiên
	public void timGVThamNienLonHon5ChuyenMonKhoiTuNhien() {
		System.out.println("giao vien co tham nien > 5 va chuyen mon thuoc khoi tu nhien:");
		if (!kiemTraCoGiaoVienHayKhong()) {
			System.out.println("<< Danh sach khong co giao vien! >>");
		} else if (!kiemTraTinhSoNamGiangDayHayChua()) {
			System.out.println("<< Vui long tinh so nam giang day! >>");
		} else {
			this.objListNhanSu.timGVThamNienLonHon5ChuyenMonKhoiTuNhien();
		}
	}

	// phương thức tính số giáo viên có trong danh sách
	private int tinhSoGiaoVienTrongDanhSach() {
		int soGiaoVienTrongDanhSach = 0;
		for (NhanSu ns : this.objListNhanSu.getListNhanSu()) {
			if (ns instanceof GiaoVien) {
				soGiaoVienTrongDanhSach++;
			}
		}
		return soGiaoVienTrongDanhSach;
	}

	// phương thức kiểm tra danh sách có học sinh hay không
	private boolean kiemTraCoHocSinhHayKhong() {
		for (NhanSu ns : this.objListNhanSu.getListNhanSu()) {
			if (ns instanceof HocSinh) {
				return true;
			}
		}
		return false;
	}

	// phương thức tính điểm TB tất cả HS trong danh sách
	public void tinhDiemTrungBinhAll() {
		System.out.println("Tinh diem trung binh cua hoc sinh:");
		if (!kiemTraCoHocSinhHayKhong()) {
			System.out.println("<< Danh sach khong co hoc sinh! >>");
		} else {
			this.objListNhanSu.tinhDiemTrungBinhAll();
			System.out.println("<< Tinh diem trung binh thanh cong! >>");
		}
	}

	// phương thức kiểm tra tính điểm trung bình hay chưa
	private boolean kiemTraTinhDiemTrungBinhHayChua() {
		for (NhanSu ns : this.objListNhanSu.getListNhanSu()) {
			if (ns instanceof HocSinh) {
				if (((HocSinh) ns).getDiemTrungBinh() == -1) {
					return false;
				}
			}
		}
		return true;
	}

	// phương thức tìm điểm trung bình cao nhất của học sinh
	public void timDiemTrungBinhCaoNhat() {
		System.out.print("Diem trung binh cao nhat cua hoc sinh:");
		if (!kiemTraCoHocSinhHayKhong()) {
			System.out.println("\n<< Danh sach khong co hoc sinh! >>");
		} else if (!kiemTraTinhDiemTrungBinhHayChua()) {
			System.out.println("\n<< Vui long tinh diem trung binh! >>");
		} else {
			float diemTrungBinhCaoNhat = this.objListNhanSu.timDiemTrungBinhCaoNhat();
			System.out.printf(" %s\n", diemTrungBinhCaoNhat);
		}
	}

	// phương thức tìm học sinh có điểm trung bình cao nhất
	public void timHocSinhCoDTBCaoNhat() {
		System.out.println("Hoc sinh co diem trung binh cao nhat:");
		if (!kiemTraCoHocSinhHayKhong()) {
			System.out.println("<< Danh sach khong co hoc sinh! >>");
		} else if (!kiemTraTinhDiemTrungBinhHayChua()) {
			System.out.println("<< Vui long tinh diem trung binh! >>");
		} else {
			this.objListNhanSu.timHocSinhCoDTBCaoNhat();
		}
	}

	// phương thức xếp loại học sinh dựa trên ĐTB
	public void xepLoaiHocSinhAll() {
		System.out.println("Xep loai hoc sinh:");
		if (!kiemTraCoHocSinhHayKhong()) {
			System.out.println("<< Danh sach khong co hoc sinh! >>");
		} else if (!kiemTraTinhDiemTrungBinhHayChua()) {
			System.out.println("<< Vui long tinh diem trung binh! >>");
		} else {
			this.objListNhanSu.xepLoaiHocSinhAll();
			System.out.println("<< Xep loai thanh cong! >>");
		}
	}

	// phương thức sắp xếp học sinh dựa trên ĐTB giảm dần
	public void sapXepHocSinhDuaTrenDTBGiamDan() {
		System.out.println("Sap xep hoc sinh dua tren DTB giam dan:");
		if (!kiemTraCoHocSinhHayKhong()) {
			System.out.println("<< Danh sach khong co hoc sinh! >>");
		} else if (!kiemTraTinhDiemTrungBinhHayChua()) {
			System.out.println("<< Vui long tinh diem trung binh! >>");
		} else {
			this.objListNhanSu.sapXepHocSinhDuaTrenDTBGiamDan(tinhSoGiaoVienTrongDanhSach(), this.objListNhanSu.getListNhanSu().size() - 1);
			System.out.println("<< Sap xep thanh cong! >>");
		}
	}

	// phương thức sắp xếp tên học sinh theo thứ tự ABC
	public void sapXepTenHocSinhTheoThuTuABC() {
		System.out.println("Sap xep ten hoc sinh theo thu tu ABC:");
		if (!kiemTraCoHocSinhHayKhong()) {
			System.out.println("<< Danh sach khong co hoc sinh! >>");
		} else {
			this.objListNhanSu.sapXepTenHocSinhTheoThuTuABC(tinhSoGiaoVienTrongDanhSach());
			System.out.println("<< Sap xep thanh cong! >>");
		}
	}
}
