package estacionamento;

public class CadastroVagas {
	
	private int numeroVaga;
	private String tamanhoVaga;
	private boolean disponivel;
	
	public CadastroVagas(int numeroVaga, String tamanhoVaga, boolean disponivel) {
		super();
		this.numeroVaga = numeroVaga;
		this.tamanhoVaga = tamanhoVaga;
		this.disponivel = true;
	}

	public int getNumeroVaga() {
		return numeroVaga;
	}

	public void setNumeroVaga(int numeroVaga) {
		this.numeroVaga = numeroVaga;
	}

	public String getTamanhoVaga() {
		return tamanhoVaga;
	}

	public void setTamanhoVaga(String tamanhoVaga) {
		this.tamanhoVaga = tamanhoVaga;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
}
