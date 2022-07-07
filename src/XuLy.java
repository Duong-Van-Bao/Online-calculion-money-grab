import java.util.Scanner;

public class XuLy {
    static final int GRAP_CAR_1KM = 8000;
    static final int GRAP_SUV_1KM = 9000;
    static final int GRAP_BLACK_1KM = 10000;
    
    static final int GRAP_CAR_1TO_19 = 7500;
    static final int GRAP_SUV_1TO_19 = 8500;
    static final int GRAP_BLACK_1TO_19= 9500;
    
    static final int GRAP_CAR_UPPER_19 = 7000;
    static final int GRAP_SUV_UPPER_19 = 8000;
    static final int GRAP_BLACK_UPPER_19= 9000;
	
    static final int GRAP_CAR_WAIT = 2000;
    static final int GRAP_SUV_WAIT = 3000;
    static final int GRAP_BLACK_WAIT = 3500;
    
    
    
	public XuLy() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int loaiGrap = chonLoaiGrap(scan);
        float soKM = nhapSoKM(scan);
        int thoiGianCho = nhapThoiGianCho(scan);
        float tienTra = tinhTienTra(loaiGrap, soKM, thoiGianCho);
        System.out.println("Tiền trả: " + tienTra);
	}
	
	
	public static float nhapSoKM(Scanner scan) {
		float soKM;
		System.out.println("Vui lòng nhập vào số KM");
		soKM = Float.parseFloat(scan.nextLine());
		return soKM;
	}
	
	
	public static int nhapThoiGianCho (Scanner scan) {
	  int thoiGianCho;
	  System.out.println("Vui lòng nhập vào thời gian chờ");
	  thoiGianCho = Integer.parseInt(scan.nextLine());
	  return thoiGianCho;
	}
	
	public static int chonLoaiGrap(Scanner scan) {
		int loai;
		System.out.println("Vui lòng chọn lịa Grab");
		System.out.println("1. Grab Car");
		System.out.println("2. Grab SUV");
		System.out.println("3. Grab Black");
		loai = Integer.parseInt(scan.nextLine());
		return loai; 
	}
	
	public static float tinhTienKMDauTien(int loaiGrab) {
		float tien = 0;
		if(loaiGrab == 1) {
			tien = GRAP_CAR_1KM;
		} else if(loaiGrab == 2) {
			tien = GRAP_SUV_1KM;
		} else {
			tien = GRAP_BLACK_1KM;
		}
		return tien;
	}
	
	public static float tinhTienKM1Den19(float soKM, int loaiGrab) {
		float tien = 0;
		if( loaiGrab == 1 ) {
			tien = GRAP_CAR_1KM + (soKM - 1) * GRAP_CAR_1TO_19;
		} else if( loaiGrab == 2 ) {
			tien = GRAP_SUV_1KM + (soKM - 1) * GRAP_SUV_1TO_19;
		} else {
			tien = GRAP_BLACK_1KM + (soKM - 1) * GRAP_BLACK_1TO_19;
		}
		return tien;
	}
	
	public static float tinhTienKMTren19(float soKM, int loaiGrab) {
		float tien = 0;
		if( loaiGrab == 1 ) {
			tien = GRAP_CAR_1KM + 18 * GRAP_CAR_1TO_19 + (soKM - 19) * GRAP_CAR_UPPER_19;
		} else if( loaiGrab == 2 ) {
			tien = GRAP_SUV_1KM + 18 * GRAP_SUV_1TO_19 + (soKM - 19) * GRAP_SUV_UPPER_19;
		} else {
			tien = GRAP_BLACK_1KM + 18 * GRAP_BLACK_1TO_19 + (soKM - 19) * GRAP_BLACK_UPPER_19;
		}
		return tien;
	}
	
	
	public static float tinhTienCho(int loaiGrap, int thoiGianCho) {
	    	float tien = 0;
	    	if(thoiGianCho >= 3) {
	    	    int soLanTinh = Math.round((thoiGianCho*1.0f)/3);
	    	    if(loaiGrap == 1) {
	               tien = soLanTinh * GRAP_CAR_WAIT;  	    	
	    	    } else if(loaiGrap == 2) {
	    	    	tien = soLanTinh * GRAP_SUV_WAIT;
	    	    } else {
	    	    	tien = soLanTinh * GRAP_BLACK_WAIT;
	    	    }
	    	}
	    	return tien;
	}
	
	public static float tinhTienTra(int loaiGrap, float soKM, int thoiGianCho) {
		 float tienTra = 0;
		 if(soKM <= 1) {
			 tienTra = tinhTienKMDauTien(loaiGrap) + tinhTienCho(loaiGrap, thoiGianCho);
		 } else if(soKM > 1 && soKM <= 19) {
			 tienTra = tinhTienKM1Den19(soKM, loaiGrap) + tinhTienCho(loaiGrap, thoiGianCho);
		 } else {
			 tienTra = tinhTienKMTren19(soKM, loaiGrap) + tinhTienCho(loaiGrap, thoiGianCho);
		 }
		 return tienTra;
	}
}
