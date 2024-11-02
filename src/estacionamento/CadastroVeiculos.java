package estacionamento;

import java.time.LocalTime;

public class CadastroVeiculos {
	
	private String placaCarro;
	private String modeloCarro; 
	private String tamanhoCarro;
	private LocalTime horaEntrada;
	private LocalTime horaSaida;
	
	public CadastroVeiculos(String placaCarro, String modeloCarro, String tamanhoCarro, LocalTime horaEntrada,
			LocalTime horaSaida) {
		super();
		this.placaCarro = placaCarro;
		this.modeloCarro = modeloCarro;
		this.tamanhoCarro = tamanhoCarro;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
	}

	public String getPlacaCarro() {
		return placaCarro;
	}

	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}

	public String getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public String getTamanhoCarro() {
		return tamanhoCarro;
	}

	public void setTamanhoCarro(String tamanhoCarro) {
		this.tamanhoCarro = tamanhoCarro;
	}

	public LocalTime getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(LocalTime horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public LocalTime getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(LocalTime horaSaida) {
		this.horaSaida = horaSaida;
	}
}
