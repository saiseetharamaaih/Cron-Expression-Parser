package parser;

import java.util.Set;

public class CronExpressionParser{

	public static void main(String[] args) {
		
		String expn = args[0];
		String[] lis = expn.split(" ");
		
		if(lis.length < 6 ) {
			System.out.println("Invalid cron expression");
			return ;
		}
		
		MinuteFieldParser minuteParser = new MinuteFieldParser();
		HourFieldParser hourParser = new HourFieldParser();
		DateFieldParser dayOfMonthParser = new DateFieldParser();
		MonthFieldParser monthParser = new MonthFieldParser();
		DayFieldParser dayOfWeekParser = new DayFieldParser();
		
		Set<Integer> minutes = null;
		Set<Integer> hours = null;
		Set<Integer> daysOfMonth = null;
		Set<Integer> months = null;
		Set<Integer> daysOfWeek = null;
		
		try {
			minutes = minuteParser.parse(lis[0]);
			hours = hourParser.parse(lis[1]);
			daysOfMonth = dayOfMonthParser.parse(lis[2]);
			months = monthParser.parse(lis[3]);
			daysOfWeek = dayOfWeekParser.parse(lis[4]);
			
		} catch(ParseException e) {
			System.out.println("Error while parsing the input. Please recheck the cron expression");
			return;
		}
		
		System.out.println("minute        "+printSet(minutes));
		System.out.println("hour          "+printSet(hours));
		System.out.println("day of month  "+printSet(daysOfMonth));
		System.out.println("month         "+printSet(months));
		System.out.println("day of week   "+printSet(daysOfWeek));
		System.out.println("command       "+lis[5]);
	}
	
	public static String printSet(Set<Integer> set) {
		if(set == null || set.isEmpty()) return "";
		String str = "";
		for(int i : set) {
			str += i+" ";
		}
		
		int len = str.length();
		return str.substring(0, len-1);
	}

}
