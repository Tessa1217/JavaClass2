package co.edu.api;

import java.util.Random;

public class RandomEx {
	public static void main(String[] args) {

		// Random()
		// seed값에 따라 랜덤 값을 출력, 반환 되는 리턴 타입도 여러 종류
		// Seed => 데이터값을 직접 넣어서 시드값을 기준으로 랜덤값을 추출

		Random rd = new Random();

		rd.setSeed(0);
		System.out.println(rd.nextInt(100));
		System.out.println(rd.nextInt(100));
		System.out.println(rd.nextInt(100));

		// 시간을 통해 중복값 배제
		long time = System.currentTimeMillis();
		long time2 = System.nanoTime();

		rd.setSeed(time);
		System.out.println(rd.nextInt(50));
		System.out.println(rd.nextInt(50));
		System.out.println(rd.nextInt(50));

		rd.setSeed(time2);
		System.out.println(rd.nextInt(10));
		System.out.println(rd.nextInt(10));
		System.out.println(rd.nextInt(10));

		// 1~45 중 난수 6개
		for (int i = 0; i < 6; i++) {
			System.out.print(rd.nextInt(45) + 1 + " ");
		}
	}
}
