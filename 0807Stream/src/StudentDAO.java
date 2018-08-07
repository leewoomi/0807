import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

	// StudentDAO Ŭ�������� ��� �����͸� �������� �޼ҵ�
	public List<StudentVO> fetch() {
		// ������ ����Ʈ�� ����
		// List�� �����ؾ� �ϴ� ��쿡�� null�� �������� �ʴ� ���� ����.
		// List�� Ư���� ��찡 �ƴϸ� ���� ���Ÿ� �̿��ؼ� �����ϴµ�
		// null �̸� NullPointException�� �߻��Ѵ�.
		// null�� �ȸ���� ���ؼ� �ν��Ͻ��� �����ؼ� �����մϴ�.
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
			//���� ������ Ȯ���ϱ� ����
			System.out.println("�б� ���� : " + e.getMessage());
			//������ ��ġ�� �˱� ���ؼ� �ۼ�
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
