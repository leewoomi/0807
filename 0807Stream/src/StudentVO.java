
public class StudentVO {
	// ���̺��� �� �÷��� ������ �����ϱ� ���ؼ� ����
	private String sno;
	private String sname;
	private String subject;
	private int jumsu;
	private int age;
	private String gender;

	//�ν��Ͻ� ������ �� �� �����͸� �ٷ� �����ؼ� �����ϸ�
	//�޼ҵ� ȣ�� Ƚ���� ���� �� �ֱ� ������ ����
	public StudentVO() {
		super();
	}

	public StudentVO(String sno, String sname, String subject, int jumsu, int age, String gender) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.subject = subject;
		this.jumsu = jumsu;
		this.age = age;
		this.gender = gender;
	}

	//�ν��Ͻ� ������ private�� �����߱� ������
	//�ν��Ͻ��� ����� �� ��� �ν��Ͻ� ������ ����ϱ� ���� �޼ҵ�
	public String getSno() {
		return sno;
	}

	public String getSname() {
		return sname;
	}

	public String getSubject() {
		return subject;
	}

	public int getJumsu() {
		return jumsu;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setJumsu(int jumsu) {
		this.jumsu = jumsu;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	//�����͸� ������ Ȯ���ϱ� ���ؼ� - ����� ���ؼ� 
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", subject=" + subject + ", jumsu=" + jumsu + ", age=" + age
				+ ", gender=" + gender + "]";
	}

}
