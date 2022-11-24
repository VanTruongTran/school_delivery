/*
 * purpose: quản lý danh sách nhân sự và xử lý nghiệp vụ liên quan
 * date created: 20/9/2022
 * author: Van Truong
 * version: 1.0
 */

package schoolmanagement.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DanhSachNhanSu {
	/* ATTRIBUTES */
	private ArrayList<NhanSu> listNhanSu;

	/* GET, SET METHODS */
	// phương thức truy xuất giá trị thuộc tính listNhanSu
	public ArrayList<NhanSu> getListNhanSu() {
		return this.listNhanSu;
	}

	// phương thức thiết lập giá trị thuộc tính listNhanSu
	public void setListNhanSu(ArrayList<NhanSu> listNhanSu) {
		this.listNhanSu = listNhanSu;
	}

	/* CONSTRUCTOR METHODS */
	// phương thức khởi tạo mặc định không tham số
	public DanhSachNhanSu() {
		this.listNhanSu = new ArrayList<NhanSu>();// khởi tạo ArrayList
	}

	// phương thức khởi tạo có sử dụng tham số để truyền giá trị cho thuộc tính
	public DanhSachNhanSu(ArrayList<NhanSu> listNhanSu) {
		this.listNhanSu = listNhanSu;
	}

	/* INPUT, OUTPUT METHODS */
	// phương thức nhập dữ liệu tất cả nhân sự trong danh sách
	public void nhapAll(Scanner scan) {
		for (NhanSu ns : this.listNhanSu) {
			ns.nhap(scan);
		}
	}

	// phương thức xuất dữ liệu tất cả nhân sự trong danh sách
	public void xuatAll() {
		for (NhanSu ns : this.listNhanSu) {
			ns.xuat();
		}
	}

	/* BUSINESS METHODS */
	// phương thức đọc dữ liệu từ file
	public void docDuLieuFile(String src) {
		try {
			FileReader reader = new FileReader(src);
			BufferedReader bufferedReader = new BufferedReader(reader);

			String line;

			while ((line = bufferedReader.readLine()) != null) {
				String[] array = line.split(" # ");

				NhanSu ns;
				if (array[array.length - 1].compareTo("true") == 0) {
					// khởi tạo giáo viên
					ns = new GiaoVien(array[0], Integer.parseInt(array[1]), array[2], array[3], Integer.parseInt(array[4]), array[5]);
				} else {
					// khởi tạo học sinh
					ns = new HocSinh(array[0], Integer.parseInt(array[1]), array[2], array[3], Float.parseFloat(array[4]), Float.parseFloat(array[5]), Float.parseFloat(array[6]));
				}
				// thêm nhân sự vào danh sách
				this.listNhanSu.add(ns);
			}
			reader.close();
		} catch (Exception error) {
			error.printStackTrace();
		}
	}

	// phương thức thêm nhân sự vào danh sách
	public void themNhanSu(NhanSu ns) {
		this.listNhanSu.add(ns);
	}

	// phương thức tính số năm giảng dạy tất cả GV trong danh sách
	public void tinhSoNamGiangDayAll() {
		for (NhanSu ns : this.listNhanSu) {
			if (ns instanceof GiaoVien) {
				((GiaoVien) ns).tinhSoNamGiangDay();
			}
		}
	}

	// phương thức tìm giáo viên có thâm niên cao nhất
	public void timGiaoVienThamNienCaoNhat() {
		NhanSu ns = null;// đối tượng giáo viên có thâm niên cao nhất
		int index = -1;

		// tìm giáo viên đầu tiên trong danh sách
		for (int i = 0; i < this.listNhanSu.size(); i++) {
			if (this.listNhanSu.get(i) instanceof GiaoVien) {
				ns = this.listNhanSu.get(i);
				index = i;
				break;
			}
		}

		// tìm giáo viên thâm niên cao nhất
		for (int i = index + 1; i < this.listNhanSu.size(); i++) {
			if (this.listNhanSu.get(i) instanceof GiaoVien) {
				if (((GiaoVien) this.listNhanSu.get(i)).getSoNamGiangDay() > ((GiaoVien) ns).getSoNamGiangDay()) {
					ns = this.listNhanSu.get(i);
					index = i;
				}
			}
		}

		// xuất giáo viên thâm niên cao nhất
		for (int i = index; i < this.listNhanSu.size(); i++) {
			if (this.listNhanSu.get(i) instanceof GiaoVien) {
				if (((GiaoVien) this.listNhanSu.get(i)).getSoNamGiangDay() == ((GiaoVien) ns).getSoNamGiangDay()) {
					this.listNhanSu.get(i).xuat();
				}
			}
		}
	}

	// phương thức tìm giáo viên có thâm niên > 5 và chuyên môn thuộc khối tự nhiên
	public void timGVThamNienLonHon5ChuyenMonKhoiTuNhien() {
		boolean flag = false;
		for (NhanSu ns : this.listNhanSu) {
			if (ns instanceof GiaoVien) {
				if (((GiaoVien) ns).getSoNamGiangDay() > 5 && ((GiaoVien) ns).getChuyenMon().compareTo("Tu nhien") == 0) {
					ns.xuat();
					flag = true;
				}
			}
		}
		if (!flag) {
			System.out.println("<< Khong tim thay giao vien thoa dieu kien! >>");
		}
	}

	// phương thức tính điểm TB tất cả HS trong danh sách
	public void tinhDiemTrungBinhAll() {
		for (NhanSu ns : this.listNhanSu) {
			if (ns instanceof HocSinh) {
				((HocSinh) ns).tinhDiemTrungBinh();
			}
		}
	}

	// phương thức tìm điểm trung bình cao nhất của học sinh
	public float timDiemTrungBinhCaoNhat() {
		NhanSu ns = null;// đối tượng học sinh có ĐTB cao nhất
		int index = -1;

		// tìm học sinh đầu tiên trong danh sách
		for (int i = 0; i < this.listNhanSu.size(); i++) {
			if (this.listNhanSu.get(i) instanceof HocSinh) {
				ns = this.listNhanSu.get(i);
				index = i;
				break;
			}
		}

		// tìm điểm trung bình cao nhất
		for (int i = index + 1; i < this.listNhanSu.size(); i++) {
			if (this.listNhanSu.get(i) instanceof HocSinh) {
				if (((HocSinh) this.listNhanSu.get(i)).getDiemTrungBinh() > ((HocSinh) ns).getDiemTrungBinh()) {
					ns = this.listNhanSu.get(i);
				}
			}
		}

		float diemTrungBinhCaoNhat = ((HocSinh) ns).getDiemTrungBinh();
		diemTrungBinhCaoNhat = (float) (Math.round(diemTrungBinhCaoNhat * 100) / 100.0);
		return diemTrungBinhCaoNhat;
	}

	// phương thức tìm học sinh có điểm trung bình cao nhất
	public void timHocSinhCoDTBCaoNhat() {
		// tìm điểm trung bình cao nhất
		float diemTrungBinhCaoNhat = timDiemTrungBinhCaoNhat();

		// xuất học sinh có điểm trung bình cao nhất
		for (NhanSu ns : this.listNhanSu) {
			if (ns instanceof HocSinh) {
				if (((HocSinh) ns).getDiemTrungBinh() == diemTrungBinhCaoNhat) {
					ns.xuat();
				}
			}
		}
	}

	// phương thức xếp loại tất cả học sinh trong danh sách
	public void xepLoaiHocSinhAll() {
		for (NhanSu ns : this.listNhanSu) {
			if (ns instanceof HocSinh) {
				((HocSinh) ns).xepLoai();
			}
		}
	}

	// phương thức sắp xếp học sinh dựa trên ĐTB giảm dần (using quick sort)
	public void sapXepHocSinhDuaTrenDTBGiamDan(int left, int right) {
		int i = left;
		int j = right;
		float midValue = ((HocSinh) this.listNhanSu.get((left + right) / 2)).getDiemTrungBinh();

		do {// phân hoạch
			while (((HocSinh) this.listNhanSu.get(i)).getDiemTrungBinh() > midValue) {// xét đoạn bên trái
				i++;
			}

			while (((HocSinh) this.listNhanSu.get(j)).getDiemTrungBinh() < midValue) {// xét đoạn bên phải
				j--;
			}

			if (i <= j) {// hoán vị nếu sai vị trí
				Collections.swap(this.listNhanSu, i, j);
				i++;
				j--;
			}
		} while (i < j);

		if (left < j) {
			sapXepHocSinhDuaTrenDTBGiamDan(left, j);// đệ quy các đoạn bên trái
		}

		if (i < right) {
			sapXepHocSinhDuaTrenDTBGiamDan(i, right);// đệ quy các đoạn bên phải
		}
	}

	// phương thức sắp xếp tên học sinh theo thứ tự ABC (using bubble sort)
	public void sapXepTenHocSinhTheoThuTuABC(int left) {
		for (int i = left; i < this.listNhanSu.size() - 1; i++) {
			for (int j = this.listNhanSu.size() - 1; j > i; j--) {
				if (this.listNhanSu.get(j - 1).getHoTen().compareTo(this.listNhanSu.get(j).getHoTen()) > 0) {
					Collections.swap(this.listNhanSu, j - 1, j);
				}
			}
		}
	}
}
