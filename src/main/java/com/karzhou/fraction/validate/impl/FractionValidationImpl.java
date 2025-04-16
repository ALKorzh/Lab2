package com.karzhou.fraction.validate.impl;

import com.karzhou.fraction.exception.validation.InvalidFractionException;
import com.karzhou.fraction.validate.FractionValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FractionValidationImpl implements FractionValidation {
    private static final Logger logger = LogManager.getLogger(FractionValidationImpl.logger);

    @Override
    public boolean isValid(int numerator, int denominator) throws InvalidFractionException {
        if (denominator == 0) {
            logger.error("denominator is zero");
            throw new InvalidFractionException("Denominator cannot be zero"); // without exception
        }
        return true;

    }

}
