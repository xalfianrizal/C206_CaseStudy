public class radioControlCar {
	private int assetTag;
	private String name;
	private String material;
	private String motorType;
	private double height;
	private double length;
	
	public radioControlCar(int assetTag,String name,String material,String motorType,double height,double length) {
		this.assetTag = assetTag;
		this.name = name;
		this.material = material;
		this.motorType = motorType;
		this.height = height;
		this.length = length;
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
	public String display() {
		String output = "";
		output += String.format("%-10d %-20s %-20s %-10s %-10.2f %-10.2f %", assetTag,name,material,motorType,height,length);
		
		return output;
	}
}
