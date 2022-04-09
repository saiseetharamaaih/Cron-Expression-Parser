package parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DayFieldParser extends FieldParser {
	
	private static  List<String> lis = Arrays.asList(
		"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"
	);
	
	private static  final int MIN = 0, MAX = 6;
	
	private int getValue(String val) {
		int idx = lis.indexOf(val);
		if(idx == -1) return Integer.valueOf(val);
		return idx+1;
	}
	
	@Override
	Set<Integer> parseRangeSeperatedValues(String expr){
		
		String[] a = expr.split(RANGE_SEPERATOR);
		int l = getValue(a[0]);
		int r = getValue(a[1]);
		
		Set<Integer> set = new HashSet<Integer>();
		for(; l<=r; l++)
			set.add(l);
		return set;
	}
	
	@Override
	Set<Integer> parseAllValues(){
		
		Set<Integer> set = new HashSet<Integer>();
		
		int  l = MIN, r = MAX;
		for(; l<=r; l++)
			set.add(l);
		
		return set;
	}

	@Override
	Set<Integer> parseStepSeperatedValues(String expr){
		
		String[] a = expr.split(STEP_SEPERATOR);
		int l = getValue(a[0]);
		int r = getValue(a[1]);
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i = l; i<=MAX ; i = i+r)
			set.add(i);
		
		return set;
	}
	
}
