import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

	// StudentDAO 클래스에서 모든 데이터를 가져오는 메소드
	public List<StudentVO> fetch() {
		// 리턴할 리스트를 생성
		// List를 리턴해야 하는 경우에는 null을 리턴하지 않는 것이 좋다.
		// List는 특별한 경우가 아니면 빠른 열거를 이용해서 접근하는데
		// null 이면 NullPointException이 발생한다.
		// null을 안만들기 위해서 인스턴스를 생성해서 리턴합니다.
		List<StudentVO> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");

			pstmt = conn.prepareStatement("select sno,sname,subject,jumsu,age,gender "+ "from student");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				StudentVO vo = new StudentVO(rs.getString("sno"), rs.getString("sname"), rs.getString("subject"),
						rs.getInt("jumsu"), rs.getInt("age"), rs.getString("gender"));
				list.add(vo);
			}
			
		
		} catch (Exception e) {
			//예외 내용을 확인하기 위함
			System.out.println("읽기 오류 : " + e.getMessage());
			//예외의 위치를 알기 위해서 작성
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null)conn.close();
			}catch(Exception e) {}
		}

		return list;
	}
}
