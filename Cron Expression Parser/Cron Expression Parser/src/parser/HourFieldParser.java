package parser;

import java.util.HashSet;
import java.util.Set;

public class HourFieldParser extends FieldParser {
	
	private static  final int MIN = 0, MAX = 23;
	
	@Override
	Set<Integer> parseRangeSeperatedValues(String expr){
		
		String[] a = expr.split(RANGE_SEPERATOR);
		int l = getIntegerValue(a[0]);
		int r = getIntegerValue(a[1]);
		
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
		int l = getIntegerValue(a[0]);
		int r = getIntegerValue(a[1]);
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i = l; i<=MAX ; i = i+r)
			set.add(i);
		
		return set;
	}
	
	
}
