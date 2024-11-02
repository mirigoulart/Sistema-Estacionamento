package estacionamento;

import java.time.LocalTime;
import java.util.Scanner;

public class SistemaPrincipal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gerenciamento estacionamento = new Gerenciamento();
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println();
			System.out.println("SISTEMA ESTACIONAMENTO");
			System.out.println("----------------------------");
			System.out.println("1. Cadastar Vaga");
			System.out.println("2. Entrada de Veículos");
			System.out.println("3. Saída de Veículos");
			System.out.println("4. Relatório de Ocupação");
			System.out.println("5. Histórico de Permanência");
			System.out.println("6. Sair");
			System.out.println();
			System.out.print("Digite uma opcao: ");
			int opcao = scan.nextInt();
			scan.nextLine();
			System.out.println();
			
			switch(opcao) {
			case 1: 
				System.out.print("Número da vaga: ");
				int numeroVaga = scan.nextInt();
				scan.nextLine();
				System.out.print("Tamanho da vaga(Pequeno, Médio e Grande): ");
				String tamanhoVaga = scan.nextLine();
				estacionamento.cadastrarVaga(numeroVaga, tamanhoVaga, true);
				break;
				
			case 2:
				System.out.print("Placa do carro: ");
				String placaCarro = scan.nextLine();
				System.out.print("Modelo de carro: ");
				String modeloCarro = scan.nextLine();
				System.out.print("Tamanho do carro(Pequeno, Médio e Grande): ");
				String tamanhoCarro = scan.nextLine();
				System.out.print("Número da Vaga: ");
                int numeroVagaCarro = scan.nextInt(); 
                scan.nextLine();
				System.out.print("Hora de entrada(HH:mm): ");
				String entrada = scan.nextLine();
				LocalTime horaEntrada = LocalTime.parse(entrada);
				estacionamento.cadastrarVeiculo(placaCarro, modeloCarro, tamanhoCarro, numeroVagaCarro, horaEntrada);
				break;
				
			case 3:
				System.out.print("Placa do Carro para Saída: ");
			    String placaSaida = scan.nextLine();
			    System.out.print("Hora de Saída (HH:MM): "); 
			    String saidaVeiculo = scan.nextLine();
			    LocalTime horaSaidaVeiculo = LocalTime.parse(saidaVeiculo); 
			    estacionamento.saidaVeiculos(placaSaida, horaSaidaVeiculo); 
			    break;
			
			case 4: 
				estacionamento.relatorioOcupacao();
				break;
			
			case 5:
				estacionamento.historicoPermanencia();
				break;
			
			case 6: 
				System.out.println("Encerrando o sistema...");
				scan.close();
				return;
				
			default: 
				System.out.println("Opção Inválida! Tente Novamente");
				break;
			}
		}
	}
}
