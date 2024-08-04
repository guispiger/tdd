package decorator;

public enum Separator {
	COMMA(','), SEMICOLON(';'), COLON(':'), TAB('\t'), SPACE(' '), PIPE('|');

	private char value = ',';
	
	Separator(char c) {
		this.value = c;
	}
	
	public char asChar() {
		return this.value;
	}
	
	public String asString() {
		return ""+this.value;
	}
}
