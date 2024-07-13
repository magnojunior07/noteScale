package notesScale;

public enum Note {
    C("C"), C_SHARP("C#"), D("D"), D_SHARP("D#"), E("E"), F("F"), F_SHARP("F#"), G("G"), G_SHARP(
            "G#"), A("A"), A_SHARP("A#"), B("B");

    private final String symbol;

    Note(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public static Note fromString(String note) {
        switch (note.toUpperCase()) {
            case "C#":
                return C_SHARP;
            case "D#":
                return D_SHARP;
            case "F#":
                return F_SHARP;
            case "G#":
                return G_SHARP;
            case "A#":
                return A_SHARP;
            default:
                return valueOf(note.toUpperCase());
        }
    }
}
