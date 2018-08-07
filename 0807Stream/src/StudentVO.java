
public class StudentVO {
	// 테이블의 각 컬럼의 값들을 저장하기 위해서 생성
	private String sno;
	private String sname;
	private String subject;
	private int jumsu;
	private int age;
	private String gender;

	//인스턴스 생성을 할 때 데이터를 바로 대입해서 생성하면
	//메소드 호출 횟수를 줄일 수 있기 때문에 생성
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

	//인스턴스 변수를 private로 생성했기 때문에
	//인스턴스가 사용할 수 없어서 인스턴스 변수를 사용하기 위한 메소드
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

	//데이터를 빠르게 확인하기 위해서 - 디버깅 위해서 
	@Override
	public String toString() {
		return "Student [sno=" + sno + ", sname=" + sname + ", subject=" + subject + ", jumsu=" + jumsu + ", age=" + age
				+ ", gender=" + gender + "]";
	}

}
