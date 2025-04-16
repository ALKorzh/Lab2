package com.karzhou.fraction.parser;

import com.karzhou.fraction.entity.Fraction;
import com.karzhou.fraction.exception.validation.InvalidFractionException;

public interface FractionParser {
    Fraction parse(String line) throws InvalidFractionException;
}
