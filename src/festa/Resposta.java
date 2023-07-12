package festa;

public class Resposta {

	private Pergunta pergunta;
	private boolean verdadeira;
	
	public Resposta(Pergunta parPergunta,
			boolean parVerdadeira) {
		pergunta = parPergunta;
		verdadeira = parVerdadeira;
	}
	
	public Pergunta getPergunta() {
		return pergunta;
	}
	
	public boolean isVerdadeira() {
		return verdadeira;
	}
	
}
