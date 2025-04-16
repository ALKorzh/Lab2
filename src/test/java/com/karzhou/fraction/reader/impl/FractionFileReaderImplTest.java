package com.karzhou.fraction.reader.impl;

import com.karzhou.fraction.reader.FractionFileReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class FractionFileReaderImplTest {

    private FractionFileReader reader;

    @BeforeClass
    public void setUp() {
        reader = new FractionFileReaderImpl();
    }

    @Test
    public void testReadLines_ValidFile_ShouldReturnLines() throws IOException {
        // Файл test_fractions.txt должен лежать в src/test/resources
        List<String> lines = reader.readLines("test_fractions.txt");

        assertThat(lines).isNotNull();
        assertThat(lines).isNotEmpty();
        assertThat(lines).contains("1 / 2", "3 / 4");
    }

    @Test
    public void testReadLines_FileNotFound_ShouldThrowIOException() {
        assertThatThrownBy(() -> reader.readLines("non_existent_file.txt"))
                .isInstanceOf(IOException.class)
                .hasMessageContaining("File not found");
    }
}
