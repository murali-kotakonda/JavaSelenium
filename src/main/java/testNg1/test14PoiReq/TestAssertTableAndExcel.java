package testNg1.test14PoiReq;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestAssertTableAndExcel {

	private static final String EXCEL = "Inputdata.xlsx";
	private static final String PATH = "C:\\Project\\";

	public static void main(String[] args) throws SQLException, IOException {
		List<String> columns1 = ExcelUtils.getExcelColumns(PATH, EXCEL);
		ResultSet data2 = selectAll("select * from employee");
		List<String> columns2 = getColumns(data2);
		Map<String,List<String>> map = new HashMap<>();
			
		printDifference(map,"Excel", columns1, columns2);
		printDifference(map,"Table", columns2, columns1);
		ExcelUtils.writeExcel(PATH, EXCEL, "output", map);
	}

	private static ResultSet selectAll(String sql) {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "oracle");
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			return rs;
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException ");
		} catch (SQLException ex) {
			System.out.println("SQLException :" + ex.getMessage());
		} finally {
		}
		return null;
	}

	public static List<String> getColumns(ResultSet rs) throws SQLException {
		List<String> columns = new ArrayList<String>();
		ResultSetMetaData rsMetaData = rs.getMetaData();
		int numberOfColumns = rsMetaData.getColumnCount();

		for (int i = 1; i < numberOfColumns + 1; i++) {
			String columnName = rsMetaData.getColumnName(i).toUpperCase();
			columns.add(columnName);
		}
		return columns;
	}

	private static void printDifference(Map<String,List<String>> map,String from, 
			List<String> dbColumns, List<String> excelColumns) {
		List<String> missing = new ArrayList<>();
		excelColumns.forEach(data -> {
			if (!dbColumns.contains(data)) {
				missing.add(data);
			}
		});
		if (missing.isEmpty()) {
			System.out.println("No Missing Columns from " + from);
		} else {
			map.put(from, missing);
		}
	}
}
