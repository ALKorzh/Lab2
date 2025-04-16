package com.karzhou.fraction.validate;

import com.karzhou.fraction.entity.Fraction;
import com.karzhou.fraction.exception.validation.InvalidFractionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface FractionValidation {
    boolean isValid(int numerator, int denominator) throws InvalidFractionException;
}
