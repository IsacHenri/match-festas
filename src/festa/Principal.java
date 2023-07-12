package festa;


public class Principal {

	public static void main(String[] args) {
		
		Pergunta[] perguntas = new Pergunta[5];
		perguntas[0] = new Pergunta("Gosta de chocolate?");
		perguntas[1] = new Pergunta("Gosta de ir à balada?");
		perguntas[2] = new Pergunta("Gosta de dormir?");
		perguntas[3] = new Pergunta("Gosta de rock?");
		perguntas[4] = new Pergunta("Gosta de pepino?");
		
		Participante[] participantes = new Participante[5];
		participantes[0] = new Participante("Alex");
		participantes[1] = new Participante("Bruna");
		participantes[2] = new Participante("Camila");
		participantes[3] = new Participante("Danilo");
		participantes[4] = new Participante("Elcenildo");
		
		for(Participante participante: participantes) {
			Resposta[] respostas = new Resposta[perguntas.length];
			int i = 0;
			for(Pergunta pergunta: perguntas) {
				respostas[i++] = new Resposta(pergunta, Math.random() > 0.5);
			}
			participante.setRespostas(respostas);
		}
		
		Festa festa = new Festa("Festa Junina do Prof Douglas");
		festa.setParticipantes(participantes);
		
		System.out.println("O match do participante " + participantes[0] + " é: ");
		System.out.println(festa
				.encontrarMatchParaParticipante(participantes[0]));
	
		String cabecalho = "";
		String dados = "";
		String rodape = "";
		for(Participante participante: participantes) {
			cabecalho += String.format("%10s", participante);
		}
		for(Pergunta pergunta: perguntas) {
			for(Participante participante: participantes) {
				for(Resposta resposta: participante.getRespostas()) {
					if(resposta.getPergunta() == pergunta) {
						dados += String.format("%10s", resposta.isVerdadeira() ? "Sim" : "Não");
						break;
					}
				}
			}
			dados += "\n";
		}
		
		for(Participante ciclano: participantes) {
			int similaridade = festa.calcularSimilaridadeEntre(participantes[0], ciclano);
			rodape += String.format("%10s", String.valueOf(similaridade));
		}
		System.out.println(cabecalho);
		System.out.println(dados);
		System.out.println(rodape);
		
	}
	
}
