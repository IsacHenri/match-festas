package festa;

public class Participante {

	private String nome;
	private Resposta[] respostas;
	
	public Participante(String parNome) {
		nome = parNome;
	}
	
	public void setRespostas(Resposta... respostas) {
		this.respostas = respostas;
	}
	
	public Resposta[] getRespostas() {
		return respostas;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String toString() {
		return nome;
	}
	
}
