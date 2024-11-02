package estacionamento;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Gerenciamento {
	
	private List<CadastroVagas> listaVagas = new ArrayList<>();
	private List<CadastroVeiculos> listaVeiculos = new ArrayList<>();
	private List<HistoricoPermanencia> historicoVeiculos = new ArrayList<>();
	
	public void cadastrarVaga(int numeroVaga, String tamanhoVaga, boolean disponivel) {
		CadastroVagas vaga = new CadastroVagas(numeroVaga, tamanhoVaga, disponivel);
		listaVagas.add(vaga);
		System.out.println("Vaga cadastrada com sucesso!");
	}
	
	  public void cadastrarVeiculo(String placaCarro, String modeloCarro, String tamanhoCarro, int numeroVaga, LocalTime horaEntrada) {
	        for (CadastroVagas vaga : listaVagas) {
	            if (vaga.getNumeroVaga() == numeroVaga) {
	                if (vaga.isDisponivel() && vaga.getTamanhoVaga().equalsIgnoreCase(tamanhoCarro)) {
	                    CadastroVeiculos veiculo = new CadastroVeiculos(placaCarro, modeloCarro, tamanhoCarro, horaEntrada, null);
	                    listaVeiculos.add(veiculo);
	                    vaga.setDisponivel(false); 
	                    System.out.println("Veículo cadastrado com sucesso!");
	                    return;
	                } else if (!vaga.isDisponivel()) {
	                    System.out.println("A vaga " + numeroVaga + " já está ocupada.");
	                    return;
	                } else {
	                    System.out.println("O veículo não corresponde ao tamanho da vaga " + numeroVaga);
	                    return;
	                }
	            }
	        }
	        System.out.println("Vaga " + numeroVaga + " não encontrada.");
	    }

	public void saidaVeiculos(String placaCarro, LocalTime horaSaida) {
	    for (CadastroVeiculos veiculos : listaVeiculos) {
	        if (veiculos.getPlacaCarro().equals(placaCarro)) {
	        	LocalTime horaEntrada = veiculos.getHoraEntrada();
	            Duration permanencia = Duration.between(horaEntrada, horaSaida);
	            long horasPermanencia = permanencia.toHours(); 
	            double valorPagar = 0;
	            
	            if (horasPermanencia <= 1) {
	                valorPagar = 5.00;
	            } else if (horasPermanencia > 1 && horasPermanencia <= 3) {
	                valorPagar = 10.00;
	            } else {
	                valorPagar = 15.00;
	            }

	            veiculos.setHoraSaida(horaSaida);
	            liberarVaga(placaCarro);
	            historicoVeiculos.add(new HistoricoPermanencia(placaCarro, veiculos.getHoraEntrada(), horaSaida, horasPermanencia, valorPagar));

	            System.out.println("O veículo com a placa " + placaCarro + " foi liberado.");
	            System.out.println("O tempo de permanência foi de " + horasPermanencia + " horas.");
	            System.out.println("O total a ser pago: R$" + valorPagar);
	            return;
	        }
	    }
	    System.out.println("Veículo com a placa " + placaCarro + " não encontrado.");
	}

	public void liberarVaga(String placaCarro) {
		for(CadastroVagas vaga : listaVagas) {
			for (CadastroVeiculos veiculos : listaVeiculos) {
				if(veiculos.getPlacaCarro().equals(placaCarro) && !vaga.isDisponivel()) {
					vaga.setDisponivel(true);
					System.out.println("A vaga "+ vaga.getNumeroVaga()+ "está liberada");
					return;
				}
			}
		}
	}
	
	public void relatorioOcupacao() {
		System.out.println("Relatório de Vagas Ocupadas");
		boolean vagasOcupadas = false;
		for(CadastroVagas vaga : listaVagas) {
			if (!vaga.isDisponivel()) {
				for (CadastroVeiculos veiculos : listaVeiculos) {
					if(vaga.getTamanhoVaga().equalsIgnoreCase(veiculos.getTamanhoCarro())) {
						System.out.println("Número da vaga: "+ vaga.getNumeroVaga());
						System.out.println("Tamanho da vaga: "+ vaga.getTamanhoVaga());
						System.out.println("Placa do veículo:"+ veiculos.getPlacaCarro());
						System.out.println("-----------------------------");
						vagasOcupadas = true;
					}
				}
			}
		}
		if(!vagasOcupadas) {
			System.out.println("Nenhuma vaga ocupada");
		}
	}
	
	public void historicoPermanencia() {
		System.out.println("Histórico de Permanência: ");
		for (HistoricoPermanencia historico : historicoVeiculos) {
			System.out.println("Placa do veículo: "+historico.getPlacaCarro());
			System.out.println("Hora de entrada: "+historico.getHoraEntrada());
			System.out.println("Hora de saida: "+historico.getHoraSaida());
			System.out.println("Tempo de permanência: "+historico.getTempoPermanencia()+ "horas");
			System.out.println("Valor Pago: "+historico.getValorPago());
			System.out.println("-----------------------------");
		}
	}
}