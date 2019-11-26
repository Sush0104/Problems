package com.fx.service;

import com.fx.exception.FXSystemException;

public interface IFXCalculatorService {
	void getConvertedValues(String input) throws FXSystemException;
}