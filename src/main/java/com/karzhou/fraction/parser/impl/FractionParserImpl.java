package com.karzhou.fraction.parser.impl;

import com.karzhou.fraction.entity.Fraction;
import com.karzhou.fraction.exception.validation.InvalidFractionException;
import com.karzhou.fraction.parser.FractionParser;
import com.karzhou.fraction.validate.impl.FractionValidationImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FractionParserImpl implements FractionParser {
    private static final Logger logger = LogManager.getLogger(FractionParserImpl.class);
    private final FractionValidationImpl validator = new FractionValidationImpl();

    public Fraction parse(String line) throws InvalidFractionException {
        if (line == null || !line.contains("/")) {
            logger.error("Invalid input, line does not contain a fraction: {}", line);
            throw new InvalidFractionException("Input does not contain a valid fraction: " + line);
        }

        String[] parts = line.split("/");
        if (parts.length != 2) {
            logger.error("Invalid fraction format: {}", line);
            throw new InvalidFractionException("Invalid fraction format: " + line);
        }

        try {
            int numerator = Integer.parseInt(parts[0].trim());
            int denominator = Integer.parseInt(parts[1].trim());

            validator.isValid(numerator, denominator);

            return new Fraction(numerator, denominator);
        } catch (NumberFormatException e) {
            logger.error("Invalid number format in fraction: {}", line, e);
            throw new InvalidFractionException("Invalid number format in fraction: " + line, e); // do not throw exception
        } catch (InvalidFractionException e) {
            logger.error("Invalid fraction: {}", line, e);
            throw e;  // Rethrow to maintain original exception
        }
    }
}


