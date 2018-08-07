import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentMain {

	public static void main(String[] args) {

		StudentDAO dao = new StudentDAO();
		List<StudentVO> list = dao.fetch();

		/*
		 * //System.out.println(list); for(StudentVO vo : list) { //����ϴ� �޼ҵ忡 �ν��Ͻ� �̸���
		 * �����ϸ� toString�� ��� System.out.println(vo); }
		 */

		// Stream ����
		Stream<StudentVO> stream = list.stream();
		// �����͸� 2�� �ǳʶٰ� 3�� ���
		// stream.skip(2).limit(3).forEach(data -> System.out.println(data));

		// // ������ ������ ���
		// stream.filter(data -> data.getGender().equals("����")).forEach(data ->
		// System.out.println(data));

		// ������ �����ϱ� - jumsu
		// stream.sorted((d1 ,d2) -> d2.getJumsu()- d1.getJumsu()).forEach(data ->
		// System.out.println(data));

		// jumsu�� 60�� �̻��� �������� ����
		// long cnt = stream.filter(data ->data.getJumsu() >= 60).count();
		// System.out.println(cnt);

		// Optional�� ���ϵǴ� �����ʹ� �� �� �� ������ �ؾ� �մϴ�.
		// StudentVO vo = stream.findFirst().get();
		// System.out.println(vo);

		// jumsu�� �հ� ���ϱ�
		// ���� �����Ͱ� �ƴϸ� �ٷ� �հ踦 ���� �� ���� ������
		// map �޼ҵ带 �̿��ؼ� ���� �����ͷ� ������ �� �հ踦 ���ؾ� ��.

		// int sum = stream.mapToInt(StudentVO::getJumsu).sum();
		// System.out.println(sum);
		//
		// //age�� ��ձ��ϱ�
		// double age = stream.mapToInt(StudentVO::getAge).average().getAsDouble();
		// System.out.println(age);
		// sname
		// stream.sorted((d1, d2) ->
		// d1.getSname().compareTo(d2.getSname())).forEach(data ->
		// System.out.println(data));

		// // ������ ������ �������� ��� ������ ���ϴµ� �Ҽ� ù° �ڸ����� �ݿø��ؼ� ���� �κи� ���
		// double manavg = stream.filter(data ->
		// data.getGender().equals("����")).mapToInt(StudentVO::getJumsu).average()
		// .getAsDouble();
		//
		// //System.out.println(manavg);
		//
		// int avg = (int) (manavg + 0.5);
		// System.out.println("���� ��� ���� : " + avg);

		// // ������ ������ �����͸� ������ List ����
		// List<StudentVO> result = stream.filter(data ->
		// data.getGender().equals("����")).collect(Collectors.toList());
		// for (StudentVO vo : result) {
		// System.out.println(vo);
		// }

		// // �̸��� �������� ���� Map���� ����
		// Map<String, Integer> map =
		// stream.collect(Collectors.toMap(StudentVO::getSname, StudentVO::getJumsu));
		// System.out.println(map);

		// // ������ �����̰� ������ 50�̻��� �������� list�� ����
		// List<StudentVO> man = stream.filter(data -> data.getGender().equals("����") &&
		// data.getJumsu() >= 50)
		// .collect(Collectors.toList());
		// for (StudentVO vo : man) {
		// System.out.println(vo);}

		// // groupingBy�� �ۼ��� �Լ��� ����� key�� �ϰ�
		// // ������ �������� List�� ������ �ؼ� Map���� �����մϴ�.
		// Map<String, List<StudentVO>> map =
		// stream.collect(Collectors.groupingBy(StudentVO::getGender));
		// System.out.println(map);

		// ����
		// Map<String, IntSummaryStatistics> map = stream
		// .collect(Collectors.groupingBy(StudentVO::getGender,
		// Collectors.summarizingInt(StudentVO::getJumsu)));
		// System.out.println(map);

		// gender���� jumsu�� �հ踦 ������ ���
		Map<String, Integer> map = stream
				.collect(Collectors.groupingBy(StudentVO::getGender, Collectors.summingInt(StudentVO::getJumsu)));
		//System.out.println(map);

		// Map�� ������ ���� ����ϱ�
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			System.out.println(key + ":" + map.get(key));
		}

	}

}
