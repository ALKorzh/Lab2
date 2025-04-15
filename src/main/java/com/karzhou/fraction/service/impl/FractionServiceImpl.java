package com.karzhou.fraction.service.impl;

import com.karzhou.fraction.entity.Fraction;
import com.karzhou.fraction.exception.validation.InvalidFractionException;
import com.karzhou.fraction.service.FractionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FractionServiceImpl implements FractionService {
    private static final Logger logger = LogManager.getLogger(FractionServiceImpl.class);

    private int gcd(int a, int b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }

    private Fraction simplify(Fraction fraction) {
        int num = fraction.getNumerator();
        int den = fraction.getDenominator();
        int gcd = gcd(num, den);
        return new Fraction(num / gcd, den / gcd);
    }

    @Override
    public Fraction add(Fraction a, Fraction b) {
        int numerator = a.getNumerator() * b.getDenominator() + b.getNumerator() * a.getDenominator();
        int denominator = a.getDenominator() * b.getDenominator();
        Fraction result = new Fraction(numerator, denominator);
        logger.info("Addition result: {}", result);
        return simplify(result);
    }

    @Override
    public Fraction subtract(Fraction a, Fraction b) {
        int numerator = a.getNumerator() * b.getDenominator() - b.getNumerator() * a.getDenominator();
        int denominator = a.getDenominator() * b.getDenominator();
        Fraction result = new Fraction(numerator, denominator);
        logger.info("Subtraction result: {}", result);
        return simplify(result);
    }

    @Override
    public Fraction multiply(Fraction a, Fraction b) {
        int numerator = a.getNumerator() * b.getNumerator();
        int denominator = a.getDenominator() * b.getDenominator();
        Fraction result = new Fraction(numerator, denominator);
        logger.info("Multiplication result: {}", result);
        return simplify(result);
    }

    @Override
    public Fraction divide(Fraction a, Fraction b) throws InvalidFractionException {
        if (b.getNumerator() == 0) {
            throw new InvalidFractionException("Cannot divide by zero fraction", b.getNumerator(), b.getDenominator());
        }
        int numerator = a.getNumerator() * b.getDenominator();
        int denominator = a.getDenominator() * b.getNumerator();
        Fraction result = new Fraction(numerator, denominator);
        logger.info("Division result: {}", result);
        return simplify(result);
    }
}
