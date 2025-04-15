package com.karzhou.fraction.service;

import com.karzhou.fraction.entity.Fraction;
import com.karzhou.fraction.exception.validation.InvalidFractionException;


public interface FractionService {
    Fraction add(Fraction a, Fraction b);

    Fraction subtract(Fraction a, Fraction b);

    Fraction multiply(Fraction a, Fraction b);

    Fraction divide(Fraction a, Fraction b) throws InvalidFractionException;
}


