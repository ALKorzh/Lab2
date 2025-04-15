package com.karzhou.fraction.creator;

import com.karzhou.fraction.entity.Fraction;


public interface FractionFactory {
    Fraction createFraction(int numerator, int denominator);
}
