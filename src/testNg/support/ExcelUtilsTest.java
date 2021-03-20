package support;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtilsTest {
	public static void main(String... strings) throws IOException {
		 
		List<MillListEntity> list = new ArrayList<>();
		for(int i=1;i<=500; i++) {
			MillListEntity entity = new MillListEntity();
			entity.setAllQuarter("quater"+i);
			entity.setCountry("testIn"+i);
			entity.setLatitude("testLanti"+i);
			entity.setLongitude("testLong"+i);
			entity.setMillClassification("testclass"+i);
			entity.setMillName("testMill"+i);
			entity.setParentCompany("testparent"+i);
			entity.setSeqNo("seqNo"+i);
			entity.setStateOrProvience("state"+i);
			entity.setSuspendedMill("testsus"+i);
			entity.setUmlId("testUma"+i);
			list.add(entity);
		}
		MillsListResponse response = new MillsListResponse();
		response.setTotalCount(500);
		response.setMillListEntities(list);
		File file = ExcelUtils.getFile(response);
		
	}

}
