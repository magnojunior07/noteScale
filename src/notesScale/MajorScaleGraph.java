package notesScale;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorScaleGraph {

	private int[] majorScalePattern = { 2, 2, 1, 2, 2, 2, 1 }; // iniciando um array com os passos de tom e semitom
	private String[] notes = { "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B" }; // inciando um array com as notas

	private Map<String, List<String>> nodes = new HashMap<String, List<String>>(); // iniciando um hashmap para representar as vertices e com quais estao conectadas

	private void addNode(String node) {
		nodes.put(node, new ArrayList<String>()); // adicionando uma vertice no grafo
	}

	private void addEdge(String node, String value) {
		List<String> edges = nodes.get(node);
		edges.add(value); // adicinando uma aresta em um vertice, para conecta-lo em outro vertice.

		nodes.put(node, edges); // atualizando as arestas do vertice
	}

	public void init() {
		// percorre a lista de notas de gera a escala maior de cada uma
		for (int i = 0; i < notes.length; i++) {
			String note = notes[i];

			addNode(note);

			int nextNoteFromScaleIndex = i;

			// executa o padrao e conecta nota encontrada na vertice da nota tonica da escala
			for (int tone : majorScalePattern) {
				nextNoteFromScaleIndex = (nextNoteFromScaleIndex + tone) % 12;

				String nextNoteFromScale = notes[nextNoteFromScaleIndex];

				addEdge(note, nextNoteFromScale);
			}
		}
	}

	// retorna a escala de acordo com a n
	public List<String> getMajorScaleFromNote(String note) {
		List<String> majorScale = nodes.get(note);

		return majorScale;
	}
}
