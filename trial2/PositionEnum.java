package trial2;

public enum PositionEnum {
	LEFT(0,"左方"),
	UP(1,"上方"),
	LEFT_UP(2,"左上方")
	;
	private int index;
	private String description;
	
	private PositionEnum(int index, String description) {
		this.index = index;
		this.description = description;
	}
	
}
