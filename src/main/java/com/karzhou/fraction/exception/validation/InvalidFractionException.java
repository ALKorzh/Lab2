package com.karzhou.fraction.exception.validation;

public class InvalidFractionException extends Exception {
    private final Integer numerator;
    private final Integer denominator;


    public InvalidFractionException() {
        super("Invalid fraction input.");
        this.numerator = null;
        this.denominator = null;
    }


    public InvalidFractionException(String message) {
        super(message);
        this.numerator = null;
        this.denominator = null;
    }


    public InvalidFractionException(String message, Throwable cause) {
        super(message, cause);
        this.numerator = null;
        this.denominator = null;
    }


    public InvalidFractionException(Throwable cause) {
        super(cause);
        this.numerator = null;
        this.denominator = null;
    }


    public InvalidFractionException(String message, int numerator, int denominator) {
        super(message);
        this.numerator = numerator;
        this.denominator = denominator;
    }


    public Integer getNumerator() {
        return numerator;
    }

    public Integer getDenominator() {
        return denominator;
    }


    @Override
    public String toString() {
        if (numerator != null && denominator != null) {
            return super.toString() + String.format(" [numerator=%d, denominator=%d]", numerator, denominator);
        } else {
            return super.toString();
        }
    }
}
