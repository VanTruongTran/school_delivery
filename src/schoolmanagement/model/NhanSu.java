/*
 * purpose: quản lý và xử lý nghiệp vụ liên quan đến nhân sự chung
 * date created: 20/9/2022
 * author: Van Truong
 * version: 1.0
 */

package schoolmanagement.model;

import java.util.Scanner;

public class NhanSu {
	/* ATTRIBUTES */
	protected String hoTen;
	protected int namSinh;
	protected String noiSinh;
	protected String diaChi;

	/* GET, SET METHODS */
	// phương thức truy xuất giá trị thuộc tính họ tên
	public String getHoTen() {
		return this.hoTen;
	}

	// phương thức thiết lập giá trị thuộc tính họ tên
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	// phương thức truy xuất giá trị thuộc tính năm sinh
	public int getNamSinh() {
		return this.namSinh;
	}

	// phương thức thiết lập giá trị thuộc tính năm sinh
	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	// phương thức truy xuất giá trị thuộc tính nơi sinh
	public String getNoiSinh() {
		return this.noiSinh;
	}

	// phương thức thiết lập giá trị thuộc tính nơi sinh
	public void setNoiSinh(String noiSinh) {
		this.noiSinh = noiSinh;
	}

	// phương thức truy xuất giá trị thuộc tính địa chỉ
	public String getDiaChi() {
		return this.diaChi;
	}

	// phương thức thiết lập giá trị thuộc tính địa chỉ
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	/* CONSTRUCTOR METHODS */
	// phương thức khởi tạo mặc định không tham số
	public NhanSu() {

	}

	// phương thức khởi tạo có sử dụng tham số để truyền giá trị cho thuộc tính
	public NhanSu(String hoTen, int namSinh, String noiSinh, String diaChi) {
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.noiSinh = noiSinh;
		this.diaChi = diaChi;
	}

	/* INPUT, OUTPUT METHODS */
	// phương thức nhập dữ liệu
	public void nhap(Scanner scan) {
		System.out.print("Nhap ho ten: ");
		this.hoTen = scan.nextLine();
		System.out.print("Nhap nam sinh: ");
		this.namSinh = Integer.parseInt(scan.nextLine());
		System.out.print("Nhap noi sinh: ");
		this.noiSinh = scan.nextLine();
		System.out.print("Nhap dia chi: ");
		this.diaChi = scan.nextLine();
	}

	// phương thức xuất dữ liệu
	public void xuat() {
		System.out.printf("Ten: %-5s | Nam sinh: %d | Noi sinh: %s | Dia chi: %s", this.hoTen, this.namSinh, this.noiSinh, this.diaChi);
	}

	/* BUSINESS METHODS */
}
