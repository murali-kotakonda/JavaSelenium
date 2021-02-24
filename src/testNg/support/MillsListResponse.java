package support;

import java.util.List;

public class MillsListResponse {
	private int totalCount;
	List<MillListEntity> millListEntities;
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<MillListEntity> getMillListEntities() {
		return millListEntities;
	}
	public void setMillListEntities(List<MillListEntity> millListEntities) {
		this.millListEntities = millListEntities;
	}
	
}





