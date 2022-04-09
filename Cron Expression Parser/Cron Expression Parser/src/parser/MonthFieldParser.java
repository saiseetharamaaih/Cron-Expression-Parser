package parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MonthFieldParser extends FieldParser {

	private static  List<String> lis = Arrays.asList(
		"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"
	);
	
	private static final int MIN = 1, MAX = 12;
	
	private static Integer getValue(String val) {
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
