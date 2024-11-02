package estacionamento;

import java.time.LocalTime;

public class HistoricoPermanencia {
	
	private String placaCarro;
	private LocalTime horaEntrada;
	private LocalTime horaSaida;
	private long tempoPermanencia; 
	private double valorPago;

	public HistoricoPermanencia(String placaCarro, LocalTime horaEntrada, LocalTime horaSaida, long tempoPermanencia, double valorPago) {
		this.placaCarro = placaCarro;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.tempoPermanencia = tempoPermanencia;
		this.valorPago = valorPago;
	}

	public String getPlacaCarro() {
		return placaCarro;
	}

	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
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

	public long getTempoPermanencia() {
		return tempoPermanencia;
	}

	public void setTempoPermanencia(long tempoPermanencia) {
		this.tempoPermanencia = tempoPermanencia;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
	
}
