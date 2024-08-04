package decorator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader extends Reader {
	private BufferedReader bufferedReader = null;
	private Separator separator = Separator.COMMA;

	public CSVReader(Reader reader) {
		super(reader);

		this.bufferedReader = new BufferedReader(reader);

	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		return bufferedReader.read(cbuf, off, len);
	}

	@Override
	public void close() throws IOException {
		bufferedReader.close();
	}

	public List<String[]> readAllLines() throws IOException {
		List<String[]> data = new ArrayList<>();
		String[] line = this.readLine();

		while (line != null) {
			data.add(line);
			line = this.readLine();
		}

		return data;
	}

	public String[] readLine() throws IOException {
		String line = null;
		String[] lineTokens = null;

		line = this.bufferedReader.readLine();
		if (line != null) {
			lineTokens = line.split(new String("\\" + getSeparator().asString()));
		}
		return lineTokens;
	}

	public Separator getSeparator() {
		return separator;
	}

	public void setSeparator(Separator separator) {
		this.separator = separator;
	}

}