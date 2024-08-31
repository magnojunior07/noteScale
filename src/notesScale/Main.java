package notesScale;

public class Main {
	public static void main(String[] args) {
		MajorScaleGraph graph = new MajorScaleGraph(); // instanciando nosso grafo
		graph.init(); // chamando o metodo init para iniciar o grafo e ja conectar os vertices entre si

		System.out.println(graph.getMajorScaleFromNote(Note.C)); // tras a escala maior de acordo com a nota passada como parametro
		// output: [D, E, F, G, A, B, C]

		System.out.println(graph.getMajorScaleFromNote(Note.D));
		// output: [E, F#, G, A, B, C#, D]
	}
}
