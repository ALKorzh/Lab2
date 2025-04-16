package com.karzhou.fraction.parser.impl;

import com.karzhou.fraction.entity.Fraction;
import com.karzhou.fraction.exception.validation.InvalidFractionException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class FractionParserImplTest {

    private FractionParserImpl parser;

    @BeforeClass
    public void setUp() {
        parser = new FractionParserImpl();
    }

    @Test
    public void testParse_ValidFraction_ShouldReturnFraction() throws InvalidFractionException {
        Fraction fraction = parser.parse("3 / 4");

        assertThat(fraction).isNotNull();
        assertThat(fraction.getNumerator()).isEqualTo(3);
        assertThat(fraction.getDenominator()).isEqualTo(4);
    }

    @Test
    public void testParse_ValidFractionWithNegativeDenominator_ShouldReturnFraction() throws InvalidFractionException {
        Fraction fraction = parser.parse("5 / -2");

        assertThat(fraction).isNotNull();
        assertThat(fraction.getNumerator()).isEqualTo(5);
        assertThat(fraction.getDenominator()).isEqualTo(-2);
    }

    @Test
    public void testParse_NullInput_ShouldThrowException() {
        assertThatThrownBy(() -> parser.parse(null))
                .isInstanceOf(InvalidFractionException.class)
                .hasMessageContaining("Input does not contain a valid fraction");
    }

    @Test
    public void testParse_MissingSlash_ShouldThrowException() {
        assertThatThrownBy(() -> parser.parse("12 7"))
                .isInstanceOf(InvalidFractionException.class)
                .hasMessageContaining("does not contain a valid fraction");
    }

    @Test
    public void testParse_MultipleSlashes_ShouldThrowException() {
        assertThatThrownBy(() -> parser.parse("1/2/3"))
                .isInstanceOf(InvalidFractionException.class)
                .hasMessageContaining("Invalid fraction format");
    }

    @Test
    public void testParse_NonNumericInput_ShouldThrowException() {
        assertThatThrownBy(() -> parser.parse("a / b"))
                .isInstanceOf(InvalidFractionException.class)
                .hasMessageContaining("Invalid number format");
    }

    @Test
    public void testParse_ZeroDenominator_ShouldThrowException() {
        assertThatThrownBy(() -> parser.parse("5 / 0"))
                .isInstanceOf(InvalidFractionException.class)
                .hasMessageContaining("Denominator cannot be zero");
    }
}
