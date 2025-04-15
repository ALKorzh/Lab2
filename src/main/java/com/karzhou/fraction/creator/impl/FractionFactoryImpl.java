package com.karzhou.fraction.creator.impl;

import com.karzhou.fraction.creator.FractionFactory;
import com.karzhou.fraction.entity.Fraction;
import com.karzhou.fraction.exception.validation.InvalidFractionException;
import com.karzhou.fraction.validate.impl.FractionValidationImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FractionFactoryImpl implements FractionFactory {
    private static final Logger logger = LogManager.getLogger(FractionFactoryImpl.logger);
    private static final FractionValidationImpl fractionValidation = new FractionValidationImpl();

    @Override
    public Fraction createFraction(int numerator, int denominator) {
        Fraction fraction = null;

        try {
            fractionValidation.isValid(numerator, denominator);
            fraction = new Fraction(numerator, denominator);
            logger.info("Validation passed");
        } catch (InvalidFractionException e) {
            logger.error("Invalid fraction: {}", e.toString());
        }
        return fraction;
    }
}
