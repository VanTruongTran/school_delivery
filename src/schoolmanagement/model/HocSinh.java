/*
 * purpose: quản lý và xử lý nghiệp vụ liên quan đến học sinh
 * date created: 20/9/2022
 * author: Van Truong
 * version: 1.0
 */

package schoolmanagement.model;

import java.util.Scanner;

public class HocSinh extends NhanSu {
	/* ATTRIBUTES */
	private float diemToan;
	private float diemVan;
	private float diemNgoaiNgu;
	private float diemTrungBinh;
	private String xepLoai;

	/* GET, SET METHODS */
	// phương thức truy xuất giá trị thuộc tính điểm toán
	public float getDiemToan() {
		return this.diemToan;
	}

	// phương thức thiết lập giá trị thuộc tính điểm toán
	public void setDiemToan(float diemToan) {
		this.diemToan = diemToan;
	}

	// phương thức truy xuất giá trị thuộc tính điểm văn
	public float getDiemVan() {
		return this.diemVan;
	}

	// phương thức thiết lập giá trị thuộc tính điểm văn
	public void setDiemVan(float diemVan) {
		this.diemVan = diemVan;
	}

	// phương thức truy xuất giá trị thuộc tính điểm ngoại ngữ
	public float getDiemNgoaiNgu() {
		return this.diemNgoaiNgu;
	}

	// phương thức thiết lập giá trị thuộc tính điểm ngoại ngữ
	public void setDiemNgoaiNgu(float diemNgoaiNgu) {
		this.diemNgoaiNgu = diemNgoaiNgu;
	}

	// phương thức truy xuất giá trị thuộc tính điểm trung bình
	public float getDiemTrungBinh() {
		return this.diemTrungBinh;
	}

	// phương thức truy xuất giá trị thuộc tính xếp loại
	public String getXepLoai() {
		return this.xepLoai;
	}

	/* CONSTRUCTOR METHODS */
	// phương thức khởi tạo mặc định không tham số
	public HocSinh() {
		this.diemTrungBinh = -1;
		this.xepLoai = "-1";
	}

	// phương thức khởi tạo có sử dụng tham số để truyền giá trị cho thuộc tính
	public HocSinh(String hoTen, int namSinh, String noiSinh, String diaChi, float diemToan, float diemVan, float diemNgoaiNgu) {
		super(hoTen, namSinh, noiSinh, diaChi);// gọi phương thức khởi tạo có tham số lớp cha

		this.diemToan = diemToan;
		this.diemVan = diemVan;
		this.diemNgoaiNgu = diemNgoaiNgu;
		this.diemTrungBinh = -1;
		this.xepLoai = "-1";
	}

	/* INPUT, OUTPUT METHODS */
	// phương thức nhập dữ liệu
	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);// gọi phương thức nhập dữ liệu lớp cha

		System.out.print("Nhap diem toan: ");
		this.diemToan = Float.parseFloat(scan.nextLine());
		System.out.print("Nhap diem van: ");
		this.diemVan = Float.parseFloat(scan.nextLine());
		System.out.print("Nhap diem diem ngoai ngu: ");
		this.diemNgoaiNgu = Float.parseFloat(scan.nextLine());
	}

	// phương thức xuất dữ liệu
	@Override
	public void xuat() {
		System.out.print("HS | ");

		super.xuat();// gọi phương thức xuất dữ liệu lớp cha

		System.out.printf(" | Diem toan: %,.2f | Diem van: %,.2f | Diem ngoai ngu: %,.2f | Diem TB: %-4s | Xep loai: %s\n", this.diemToan, this.diemVan, this.diemNgoaiNgu,
				this.diemTrungBinh != -1 ? this.diemTrungBinh : "(?)", this.xepLoai.compareTo("-1") != 0 ? this.xepLoai : "(?)");
	}

	/* BUSINESS METHODS */
	// phương thức tính điểm trung bình
	public void tinhDiemTrungBinh() {
		this.diemTrungBinh = (this.diemToan + this.diemVan + this.diemNgoaiNgu) / 3;
		this.diemTrungBinh = (float) (Math.round(this.diemTrungBinh * 100) / 100.0);
	}

	// phương thức xếp loại học sinh
	public void xepLoai() {
		if (this.diemTrungBinh >= 0 && this.diemTrungBinh <= 10) {
			if (this.diemTrungBinh >= 9) {
				this.xepLoai = "Xuat sac";
			} else if (this.diemTrungBinh >= 8) {
				this.xepLoai = "Gioi";
			} else if (this.diemTrungBinh >= 7) {
				this.xepLoai = "Kha";
			} else if (this.diemTrungBinh >= 5) {
				this.xepLoai = "TB";
			} else {
				this.xepLoai = "Yeu";
			}
		}
	}
}
