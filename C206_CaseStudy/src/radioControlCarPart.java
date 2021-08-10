
public class radioControlCarPart {
	private int assetTag;
	private String type;
	private String description;
	private boolean isAvailable;
	
	public radioControlCarPart(int assetTag,String type,String description) {
		this.assetTag = assetTag;
		this.type = type;
		this.description = description;
		this.isAvailable = true;
	}

	public int getAssetTag() {
		return assetTag;
	}

	public void setAssetTag(int assetTag) {
		this.assetTag = assetTag;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
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
		output += String.format("%-10d %-20s %-20s %s\n" , assetTag,type,description,showAvailability(isAvailable));
		
		return output;
	}
}
