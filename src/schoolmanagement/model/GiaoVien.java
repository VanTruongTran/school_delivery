/*
 * purpose: quản lý và xử lý nghiệp vụ liên quan đến giáo viên
 * date created: 20/9/2022
 * author: Van Truong
 * version: 1.0
 */

package schoolmanagement.model;

import java.util.Calendar;
import java.util.Scanner;

public class GiaoVien extends NhanSu {
	/* ATTRIBUTES */
	private int namBatDauDay;
	private String chuyenMon;
	private int soNamGiangDay;

	/* GET, SET METHODS */
	// phương thức truy xuất giá trị thuộc tính năm bắt đầu dạy
	public int getNamBatDauDay() {
		return this.namBatDauDay;
	}

	// phương thức thiết lập giá trị thuộc tính năm bắt đầu dạy
	public void setNamBatDauDay(int namBatDauDay) {
		this.namBatDauDay = namBatDauDay;
	}

	// phương thức truy xuất giá trị thuộc tính chuyên môn
	public String getChuyenMon() {
		return this.chuyenMon;
	}

	// phương thức truy xuất giá trị thuộc tính số năm giảng dạy
	public int getSoNamGiangDay() {
		return this.soNamGiangDay;
	}

	// phương thức thiết lập giá trị thuộc tính chuyên môn
	public void setChuyenMon(String chuyenMon) {
		this.chuyenMon = chuyenMon;
	}

	/* CONSTRUCTOR METHODS */
	// phương thức khởi tạo mặc định không tham số
	public GiaoVien() {
		this.soNamGiangDay = -1;
	}

	// phương thức khởi tạo có sử dụng tham số để truyền giá trị cho thuộc tính
	public GiaoVien(String hoTen, int namSinh, String noiSinh, String diaChi, int namBatDauDay, String chuyenMon) {
		super(hoTen, namSinh, noiSinh, diaChi);// gọi phương thức khởi tạo có tham số lớp cha

		this.namBatDauDay = namBatDauDay;
		this.chuyenMon = chuyenMon;
		this.soNamGiangDay = -1;
	}

	/* INPUT, OUTPUT METHODS */
	// phương thức nhập dữ liệu
	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);// gọi phương thức nhập dữ liệu lớp cha

		System.out.print("Nhap nam bat dau day: ");
		this.namBatDauDay = Integer.parseInt(scan.nextLine());
		System.out.print("Nhap chuyen mon: ");
		this.chuyenMon = scan.nextLine();
	}

	// phương thức xuất dữ liệu
	@Override
	public void xuat() {
		System.out.print("GV | ");

		super.xuat();// gọi phương thức xuất dữ liệu lớp cha

		System.out.printf(" | Chuyen mon: %-8s | Nam bat dau day: %d | So nam giang day: %s\n", this.chuyenMon, this.namBatDauDay, this.soNamGiangDay != -1 ? this.soNamGiangDay : "(?)");
	}

	/* BUSINESS METHODS */
	// phương thức tính số năm giảng dạy
	public void tinhSoNamGiangDay() {
		// lấy năm hiện tại của hệ thống
		Calendar calendar = Calendar.getInstance();
		int namHienTai = calendar.get(Calendar.YEAR);

		this.soNamGiangDay = namHienTai - this.namBatDauDay;
	}
}
