import java.util.Arrays;
import java.util.stream.IntStream;

public class ParellelMain {

	// 1�� ����ϴ� �޼ҵ�
	public static void work(int a) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		int[] ar = { 30, 50, 30, 50, 70, 10, 80, 60, 20, 40 };

		// �Ϲ� ��Ʈ������ work �۾��� ����
		IntStream stream = Arrays.stream(ar);
		long start = System.currentTimeMillis();
		stream.forEach(su -> work(su));
		long end = System.currentTimeMillis();
		System.out.println(end-start);

		//���� ��Ʈ��
		stream=Arrays.stream(ar);
		start = System.currentTimeMillis();
		stream.parallel().forEach(su -> work(su));
		end = System.currentTimeMillis();
		System.out.println(end-start);
	}

}
