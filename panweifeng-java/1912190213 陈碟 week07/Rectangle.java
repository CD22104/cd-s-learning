package experiment;

public class Rectangle {

	private double chang;
	private double kuan;
	private double zhouchang;
	private double mianji;
	public double getChang() {
		return chang;
	}
	public void setChang(double chang) {
		this.chang = chang;
	}
	public double getKuan() {
		return kuan;
	}
	public void setKuan(double kuan) {
		this.kuan = kuan;
	}
	public double getZhouchang() {
		return zhouchang;
	}
	public void setZhouchang(double zhouchang) {
		this.zhouchang = zhouchang;
	}
	public double getMianji() {
		return mianji;
	}
	public void setMianji(double mianji) {
		this.mianji = mianji;
	}
	public double zhouchang(double chang,double kuan)
	{
		double zhou;
		zhou=(chang+kuan)*2;
		return zhou;
	}
	public double mianji(double chang,double kuan)
	{
		double mian;
		mian=chang*kuan;
		return mian;
	}

}
