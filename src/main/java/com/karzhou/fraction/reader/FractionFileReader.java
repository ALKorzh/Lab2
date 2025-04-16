package com.karzhou.fraction.reader;

import java.io.IOException;
import java.util.List;

public interface FractionFileReader {
    List<String> readLines(String fileName) throws IOException;
}
