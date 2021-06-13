package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;

public class test {

	public static void main(String[] args) {

		LocalDate ld = LocalDate.parse("2021-05-24");
		LocalDate nextMonth = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).plusDays(1L);

		System.out.println(ld);
		System.out.println(nextMonth);
		int per = Period.between(ld, nextMonth).getDays();
		System.out.println(per);
	}

}
