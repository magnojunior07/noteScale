package notesScale;

public enum Note {
    C, C_SHARP, D, D_SHARP, E, F, F_SHARP, G, G_SHARP, A, A_SHARP, B;

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
