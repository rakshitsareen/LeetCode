package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

	public void util(String num, int target, List<String> result, String exprTillNow, long eval, int pos, long prenum) {
		if (pos == num.length()) {
			if (eval == target)
				result.add(exprTillNow);
			return;
		}
		for (int i = pos; i < num.length(); i++) { // for the remaining part of the number
			if (i != pos && num.charAt(pos) == '0')
				break;
			long currentNumber = Long.parseLong(num.substring(pos, i + 1)); // calculate the remaining number
			if (pos == 0)
				util(num, target, result, exprTillNow + currentNumber, currentNumber, i + 1, currentNumber);
			else {
				util(num, target, result, exprTillNow + "+" + currentNumber, eval + currentNumber, i + 1,
						currentNumber);
				util(num, target, result, exprTillNow + "-" + currentNumber, eval - currentNumber, i + 1,
						-currentNumber);
				util(num, target, result, exprTillNow + "*" + currentNumber, eval - prenum + prenum * currentNumber,
						i + 1, prenum * currentNumber);
			}
		}
		return;
	}

	public List<String> addOperators(String num, int target) {
		List<String> output = new ArrayList<>();
		if (num == null || num.length() == 0)
			return output;
		util(num, target, output, "", 0, 0, 0);
		return output;
	}

	public static void main(String[] args) {
//		System.out.println(new ExpressionAddOperators().addOperators("123", 6));
//		System.out.println(new ExpressionAddOperators().addOperators("00", 0));
//		System.out.println(new ExpressionAddOperators().addOperators("232", 8));
		System.out.println(new ExpressionAddOperators().addOperators("105", 5));
//		System.out.println(new ExpressionAddOperators().addOperators("3456237490", 9191));
	}

}
