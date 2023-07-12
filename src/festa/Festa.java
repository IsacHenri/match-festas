package festa;

public class Festa {

	private String nome;
	private String descricao;
	private Participante[] participantes;
	
	public Festa(String parNome) {
		nome = parNome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setParticipantes(Participante... participantes) {
		this.participantes = participantes;
	}
	
	public Participante[] getParticipantes() {
		return participantes;
	}
	
	public Participante
		encontrarMatchParaParticipante(
				Participante participante) {
		
		if(participantes == null ||
				participantes.length < 2) {
			return null;
		}
		
		Participante participanteComMaiorSimilaridade = 
				participantes[0] == participante ?
						participantes[1] : participantes[0];
		int maiorSimilaridade = 
				calcularSimilaridadeEntre(participante, participanteComMaiorSimilaridade);
						
		for(Participante outroParticipante: participantes) {
			if(participante == outroParticipante) {
				continue;
			}
			
			int similaridade = calcularSimilaridadeEntre(participante, outroParticipante);
			if(similaridade > maiorSimilaridade) {
				maiorSimilaridade = similaridade;
				participanteComMaiorSimilaridade = outroParticipante;
			}
		}
		
		return participanteComMaiorSimilaridade;
	}
	
	public int calcularSimilaridadeEntre(
			Participante ciclano, Participante fulano) {
		int similaridade = 0;
		for(Resposta respostaCiclano: ciclano.getRespostas()) {
			for (Resposta respostaFulano: fulano.getRespostas()) { 
				if(respostaCiclano.getPergunta() == respostaFulano.getPergunta() &&
						respostaCiclano.isVerdadeira() == respostaFulano.isVerdadeira()) {
					similaridade++;
				}
			}
		}
		return similaridade;
	}
	
	
}
