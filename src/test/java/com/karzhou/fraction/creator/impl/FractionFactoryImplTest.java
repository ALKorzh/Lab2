package com.karzhou.fraction.creator.impl;

import com.karzhou.fraction.entity.Fraction;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class FractionFactoryImplTest {

    private FractionFactoryImpl factory;

    @BeforeClass
    public void setUp() {
        factory = new FractionFactoryImpl();
    }

    @Test
    public void testCreateFraction_ValidInput_ShouldReturnFraction() {
        Fraction fraction = factory.createFraction(3, 4);

        assertThat(fraction).isNotNull();
        assertThat(fraction.getNumerator()).isEqualTo(3);
        assertThat(fraction.getDenominator()).isEqualTo(4);
    }

    @Test
    public void testCreateFraction_ZeroDenominator_ShouldReturnNull() {
        Fraction fraction = factory.createFraction(1, 0);

        assertThat(fraction).isNull();
    }

    @Test
    public void testCreateFraction_NegativeDenominator_ShouldReturnFraction() {
        Fraction fraction = factory.createFraction(5, -2);

        assertThat(fraction).isNotNull();
        assertThat(fraction.getNumerator()).isEqualTo(5);
        assertThat(fraction.getDenominator()).isEqualTo(-2);
    }

    @Test
    public void testCreateFraction_ZeroNumerator_ShouldReturnFractionWithZeroNumerator() {
        Fraction fraction = factory.createFraction(0, 7);

        assertThat(fraction).isNotNull();
        assertThat(fraction.getNumerator()).isZero();
        assertThat(fraction.getDenominator()).isEqualTo(7);
    }
}
