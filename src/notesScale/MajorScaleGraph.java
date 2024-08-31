package notesScale;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class MajorScaleGraph {

	private static final int[] MAJOR_SCALE_PATTERN = {2, 2, 1, 2, 2, 2, 1}; // iniciando um array com os passos de tom e semitom
	private final Map<Note, Set<Note>> nodes = new HashMap<>();

	private void addNode(Note note) {
		nodes.put(note, new LinkedHashSet<>()); // adicionando uma vertice no grafo
	}

	private void addEdge(Note note, Note value) {
		Set<Note> edges = nodes.get(note);
		edges.add(value); // adicinando uma aresta em um vertice, para conecta-lo em outro vertice.
		nodes.put(note, edges);
	}

	public void init() {
		Note[] notes = Note.values();
		// percorre a lista de notas e gera a escala maior de cada uma
		for (int i = 0; i < notes.length; i++) {
			Note note = notes[i];
			addNode(note);
			int nextNoteIndex = i;

			// executa o padrao e conecta nota encontrada na vertice da nota tonica da escala
			for (int step : MAJOR_SCALE_PATTERN) {
				nextNoteIndex = (nextNoteIndex + step) % notes.length;
				Note nextNote = notes[nextNoteIndex];
				addEdge(note, nextNote);
			}
		}
	}

	// retorna a escala de acordo com a n
	public Set<Note> getMajorScaleFromNote(Note note) {
		return nodes.getOrDefault(note, new LinkedHashSet<>());
	}
}
