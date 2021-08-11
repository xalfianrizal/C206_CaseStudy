public class radioControlCar {
	private int assetTag;
	private String name;
	private String material;
	private String motorType;
	private double height;
	private double length;
	private boolean isAvailable;
	
	
	public radioControlCar(int assetTag,String name,String material,String motorType,double height,double length) {
		this.assetTag = assetTag;
		this.name = name;
		this.material = material;
		this.motorType = motorType;
		this.height = height;
		this.length = length;
		this.isAvailable = true;
	}
	public int getAssetTag() {
		return assetTag;
	}
	public void setAssetTag(int assetTag) {
		this.assetTag = assetTag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getMotorType() {
		return motorType;
	}
	public void setMotorType(String motorType) {
		this.motorType = motorType;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public String showAvailability(boolean isAvailable) {
		String avail;

		if (isAvailable == true) {
			avail = "Yes";
		} else {
			avail = "No";
		}
		return avail;
	}
	public String display() {
		String output = "";
		output += String.format("%-10d %-20s %-20s %-10s %-10.2f %-10.2f %-10s \n", assetTag,name,material,motorType,height,length,showAvailability(isAvailable));
		
		return output;
	}
}
