package com.karzhou.fraction.service.impl;

import com.karzhou.fraction.entity.Fraction;
import com.karzhou.fraction.exception.validation.InvalidFractionException;
import com.karzhou.fraction.service.FractionService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class FractionServiceImplTest {

    private FractionService service;

    @BeforeMethod
    public void setUp() {
        service = new FractionServiceImpl();
    }

    @Test
    public void testAdd_TwoPositiveFractions_ShouldReturnSimplifiedResult() {
        Fraction a = new Fraction(1, 4);
        Fraction b = new Fraction(1, 2);

        Fraction result = service.add(a, b);

        assertThat(result.getNumerator()).isEqualTo(3);
        assertThat(result.getDenominator()).isEqualTo(4);
    }

    @Test
    public void testSubtract_Fractions_ShouldReturnCorrectSimplifiedResult() {
        Fraction a = new Fraction(3, 4);
        Fraction b = new Fraction(1, 2);

        Fraction result = service.subtract(a, b);

        assertThat(result.getNumerator()).isEqualTo(1);
        assertThat(result.getDenominator()).isEqualTo(4);
    }

    @Test
    public void testMultiply_Fractions_ShouldReturnSimplifiedProduct() {
        Fraction a = new Fraction(2, 3);
        Fraction b = new Fraction(3, 4);

        Fraction result = service.multiply(a, b);

        assertThat(result.getNumerator()).isEqualTo(1);
        assertThat(result.getDenominator()).isEqualTo(2);
    }

    @Test
    public void testDivide_Fractions_ShouldReturnSimplifiedQuotient() throws InvalidFractionException {
        Fraction a = new Fraction(2, 3);
        Fraction b = new Fraction(4, 5);

        Fraction result = service.divide(a, b);

        assertThat(result.getNumerator()).isEqualTo(10);
        assertThat(result.getDenominator()).isEqualTo(12);
        assertThat(result.getNumerator()).isEqualTo(5);
        assertThat(result.getDenominator()).isEqualTo(6);
    }

    @Test
    public void testDivide_ByZeroNumerator_ShouldThrowInvalidFractionException() {
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(0, 3);

        assertThatThrownBy(() -> service.divide(a, b))
                .isInstanceOf(InvalidFractionException.class)
                .hasMessageContaining("Cannot divide by zero fraction");
    }

    @Test
    public void testAdd_ResultIsInteger_ShouldReturnFractionOne() {
        Fraction a = new Fraction(1, 2);
        Fraction b = new Fraction(1, 2);

        Fraction result = service.add(a, b);

        assertThat(result.getNumerator()).isEqualTo(1);
        assertThat(result.getDenominator()).isEqualTo(1);
    }

    @Test
    public void testSimplify_NegativeSigns_ShouldBeNormalized() {
        Fraction a = new Fraction(-2, -4); // logically equivalent to 1/2
        Fraction result = service.add(a, new Fraction(0, 1)); // simplify via dummy addition

        assertThat(result.getNumerator()).isEqualTo(1);
        assertThat(result.getDenominator()).isEqualTo(2);
    }

    @Test
    public void testSubtract_ResultIsNegativeFraction() {
        Fraction a = new Fraction(1, 4);
        Fraction b = new Fraction(3, 4);

        Fraction result = service.subtract(a, b);

        assertThat(result.getNumerator()).isEqualTo(-1);
        assertThat(result.getDenominator()).isEqualTo(2);
    }
}
