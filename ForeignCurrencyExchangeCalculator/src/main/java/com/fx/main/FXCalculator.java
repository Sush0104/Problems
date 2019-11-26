package com.fx.main;

import java.util.Scanner;

import com.fx.service.FXCalculatorServiceImpl;
import com.fx.service.IFXCalculatorService;


public class FXCalculator {

	public static void main(String args[]) throws Exception {
		IFXCalculatorService fxCalculatorService = new FXCalculatorServiceImpl();
		Scanner in = new Scanner(System.in);
		String input = in. nextLine();
		fxCalculatorService.getConvertedValues(input);
		in.close();
	}

}
