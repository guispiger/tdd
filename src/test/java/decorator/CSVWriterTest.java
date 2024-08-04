package decorator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class CSVWriterTest {

	@TempDir
	static File tempDirPath;

	File csvFile = null; 
	CSVWriter csvWriter = null;

	@BeforeAll
	static void shouldExistsTemporaryDirectory() {
		assertTrue(tempDirPath.isDirectory(), "Should be a directory");
	}

	@BeforeEach
	void instantiateNewCSVWriter() {
		csvWriter = assertDoesNotThrow(() -> new CSVWriter(new FileWriter(csvFile)));
	}
	
	@BeforeEach
	void instantiateNewCSVFile() {
		csvFile = assertDoesNotThrow(() -> new File(tempDirPath, "csvTest.csv"));
	}

	@AfterEach
	void closeCSVWriterAndDeletetheFile() {
		assertDoesNotThrow(() -> csvWriter.close());
		assertDoesNotThrow(() -> csvFile.delete());
	}

	private char[] readFileContent(File file) {
		return assertDoesNotThrow(() -> {
			char[] buffer = new char[(int) file.length()];
			FileReader fileReader = new FileReader(file);
			int contentSize = fileReader.read(buffer);
			fileReader.close();
			return Arrays.copyOf(buffer, contentSize);
		});
	}

	@Test
	void shouldSetSeparator() {
		Separator expected = Separator.PIPE;
		csvWriter.setSeparator(expected);
		Separator actual = csvWriter.getSeparator();
		assertEquals(expected, actual);
	}

	@Test
	void shouldWriteSeparatorInFile() {
		csvWriter.setSeparator(Separator.PIPE);
		char expected = Separator.PIPE.asChar();

		assertDoesNotThrow(() -> {
			csvWriter.writeSeparator();
			csvWriter.flush();
		});

		char[] actual = readFileContent(csvFile);
		assertTrue(actual.length == 1);
		assertEquals(expected, actual[0]);
	}

	@Test
	void shouldWriteAnUniqueToken() {
		String token = "Ameixa";

		assertDoesNotThrow(() -> {
			csvWriter.writeToken(token);
			csvWriter.flush();
		});

		char[] fileContent = readFileContent(csvFile);
		String actual = new String(fileContent);

		assertTrue(actual.equals(token));
	}

	@Test
	void shouldWriteTokenAndSeparator() {
		String token = "Ameixa";

		assertDoesNotThrow(() -> {
			csvWriter.writeTokenAndSeparator(token);
			csvWriter.flush();
		});

		String expected = token + csvWriter.getSeparator().asChar();

		char[] fileContent = readFileContent(csvFile);
		String actual = new String(fileContent);

		assertTrue(actual.equals(expected));
	}

	@Test
	void shouldWriteAnArrayOfTokensWithSeparatorBetween() {
		String expected = "Ameixa;Banana;Maça;Batata Doce;Pera;Uva";
		Separator separator = Separator.SEMICOLON;
		
		String[] tokens = expected.split(new String("\\" + separator.asString()));
		assertDoesNotThrow(() -> {
			csvWriter.setSeparator(separator);
			csvWriter.writeTokens(tokens);
			csvWriter.flush();
		});

		String actual = new String(readFileContent(csvFile));
		assertTrue(expected.equals(actual));
	}

	@Test
	void shouldWriteAnLineOfTokens() {
		String expected = "Ameixa|Banana|Maça|Laranja Lima|Pera|Uva\n" + 
	                      "Pêssego|Maracuja|Fruta do Conde|Graviola\n" +
				          "Acerola|Limão Rosa|Manga\n";
		Separator separator = Separator.PIPE;
		
		csvWriter.setSeparator(separator);
		assertDoesNotThrow(() -> {
			String[] lines = expected.split("\n");
			for (String line : lines) {
				String[] tokens = line.split(new String("\\" + separator.asString()));
				csvWriter.writeLine(tokens);
			}
			csvWriter.flush();
		});

		String actual = new String(readFileContent(csvFile));
		assertTrue(expected.equals(actual));
	}
}
