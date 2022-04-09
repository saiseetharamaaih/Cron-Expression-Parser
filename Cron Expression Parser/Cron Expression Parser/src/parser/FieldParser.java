package parser;

import java.util.Set;
import java.util.TreeSet;

public class FieldParser {

	protected static String RANGE_SEPERATOR = "-";
	private static String ALLOW_ALL = "*";
	private static String LIST_SEPERATOR = ",";
	protected static String STEP_SEPERATOR = "/";

	public Set<Integer> parse(String expr) {
		
		TreeSet<Integer> set = new TreeSet<Integer>();
		try {
			
			if(expr.contains(LIST_SEPERATOR)) {
				for(String st : expr.split(LIST_SEPERATOR))
					set.addAll(parse(st));
			}else if(expr.contains(RANGE_SEPERATOR)) {
				set.addAll(parseRangeSeperatedValues(expr));
			}else if(expr.contains(STEP_SEPERATOR)) {
				set.addAll(parseStepSeperatedValues(expr));
			}else if(expr.equals(ALLOW_ALL)) {
				set.addAll(parseAllValues());
			}else {
				set.add(Integer.valueOf(expr));
			}
			
		}catch(Exception e) {
			if(e instanceof ParseException) throw e;
			throw new ParseException();
		}
		
		return set;
	}

	protected static int getIntegerValue(String val) {
		if(val.equals("*")) val = "0";
		int intValue = Integer.valueOf(val);
		return intValue;
	}

	public FieldParser() {
		super();
	}
	
	Set<Integer> parseRangeSeperatedValues(String expr) {
		// TODO Auto-generated method stub
		return null;
	}
	Set<Integer> parseStepSeperatedValues(String expr) {
		// TODO Auto-generated method stub
		return null;
	}
	Set<Integer> parseAllValues() {
		// TODO Auto-generated method stub
		return null;
	}

}