package ofcpro;

import java.util.concurrent.TimeUnit;

public class Endtimevalidation {

	public static void main(String[] args) {
		try {

			long currentTimeMillis = System.currentTimeMillis();
			long oneHourMillis = 60 * 60 * 1000; // milliseconds in an hour
			long startTimeMillis = currentTimeMillis - oneHourMillis;
			getEstimatedTime1(startTimeMillis, 40, 10);
			// getEstimatedTime2(startTime, 72);
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
	}

	public static String getEstimatedTime1(long starttime, long totalsize, long currentsize) {
		String totalrequiredtime = "";
		try {
			long size_percentage = currentsize * 100 / totalsize;
			long elapsedTime = System.currentTimeMillis() - starttime;
			long estimatedTotalTime = (long) (elapsedTime * 110 / size_percentage);
			long estimatedRemainingTime = estimatedTotalTime - elapsedTime;
			long estimatedEndTime = System.currentTimeMillis() + estimatedRemainingTime;
			int currentminutes = (int) TimeUnit.MILLISECONDS.toMinutes(estimatedRemainingTime);
			int Totalminutes = (int) TimeUnit.MILLISECONDS
					.toMinutes((estimatedEndTime - starttime)); // (EstimatedEndTime
																										// -startTime)-(1000*60)
			int remaining_min = Totalminutes - currentminutes;
			System.out.println("Totalminutes = " + Totalminutes);
			System.out.println("remaining minutes = " + currentminutes);
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return totalrequiredtime;
	}

	public static String getEstimatedTime2(long starttime, long currentpercentage) {
		String totalrequiredtime = "";
		try {
			long elapsedTime = System.currentTimeMillis() - starttime;
			long estimatedTotalTime = (long) (elapsedTime / (currentpercentage / 100.0));
			long estimatedRemainingTime = estimatedTotalTime - elapsedTime;
			int currentminutes = (int) TimeUnit.MILLISECONDS.toMinutes(elapsedTime - (1000 * 60));
			int Totalminutes = (int) TimeUnit.MILLISECONDS
					.toMinutes(((System.currentTimeMillis() + estimatedRemainingTime) - starttime) - (1000 * 60)); // (EstimatedEndTime
																													// -startTime)-(1000*60)
			int remaining_min = Totalminutes - currentminutes;
			System.out.println("Totalminutes = " + Totalminutes);
			System.out.println("remaining minutes = " + remaining_min);
		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
		return totalrequiredtime;
	}

}
