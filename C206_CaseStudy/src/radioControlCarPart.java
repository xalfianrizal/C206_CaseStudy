
public class radioControlCarPart {
	private int assetTag;
	private String type;
	private String description;
	private String status;
	
	public radioControlCarPart(int assetTag,String type,String description) {
		this.assetTag = assetTag;
		this.type = type;
		this.description = description;
		this.status = "Available";
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String display() {
		String output = "";
		output += String.format("%-10d %-10s %-20s %-10s \n" , assetTag,type,description,status);
		
		return output;
	}
}
