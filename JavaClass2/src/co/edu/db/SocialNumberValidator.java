package co.edu.db;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SocialNumberValidator {

	public static String checkSsn(String ssn) {
		String result = "";

		// 성별 판독
		int genderNum = 0;
		String gender = "";
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
		String today = ldt.format(dtf);

		// 생년월일 담는 배열 선언
		int[] birthday = new int[3];
		int idx = 0;
		for (int i = 0; i < birthday.length; i++) {
			String str = ssn.substring(idx, idx + 2);
			birthday[i] = Integer.parseInt(str);
			idx += 2;
		}

		int year = birthday[0];

		if (birthday[1] > 12 && birthday[2] > 31) {
			return "유효한 생년월일 형식이 아닙니다.";
		} else if (23 < year && year < 68) {
			return "유효한 생년월일 형식이 아닙니다.";
		}

		if (ssn.length() == 14 || ssn.length() == 13) {
			if (ssn.contains("-")) {
				genderNum = Integer.parseInt(ssn.substring(7, 8));

			} else {
				genderNum = Integer.parseInt(ssn.substring(7, 8));
			}

			boolean validGender = genderCode(year, genderNum);

			if (validGender == true) {
				gender = genderChk(genderNum);
				if (year < 23) {
					birthday[0] += 2000;
				} else if (68 <= year) {
					birthday[0] += 1900;
				}
				result = birthday[0] + "년 " + birthday[1] + "월 " + //
						birthday[2] + "일생, " + gender + "입니다.";
			} else if (validGender == false) {
				return "잘못된 성별코드가 사용되었습니다.\n68~99년생까지는 1, 2를 00년생부터는 3, 4를 사용합니다.";
			}

		} else {
			result = "잘못된 주민번호 형식입니다.";
		}
		return result;
	}

	public static boolean genderCode(int year, int genderNum) {
		boolean validCode = false;
		if (68 <= year && year <= 99) {
			if (genderNum == 1 || genderNum == 2) {
				validCode = true;
			} else {
				validCode = false;
			}
		} else if (0 <= year && year < 23) {
			if (genderNum == 3 || genderNum == 4) {
				validCode = true;
			} else {
				validCode = false;
			}

		} else {
			validCode = false;
		}
		return validCode;
	}

	public static String genderChk(int genderNum) {
		String gender = "";
		if (genderNum % 2 != 0) {
			gender = "남자";
		} else if (genderNum % 2 == 0) {
			gender = "여자";
		}
		return gender;
	}

}
