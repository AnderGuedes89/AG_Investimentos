import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;

// Dívidas Técnicas:
// Retirar gambiarras
// Validação das Entradas de dados
// Validação dos valores de vendas
// Validação dos valores de compras
// Fazer ordem de venda
// Fazer carteira de investimento de cada usuário
// Fazer os dividendos

public class MyFundoImobiliario {
    public static void main ( String[] args) {
		CarteiraClientes corretoraAraras = new CarteiraClientes();
		Console console = System.console();
		Scanner input = new Scanner(System.in);
		int opcao = 10;
		String numeroCPF = "0";
		double movimentacao = 0;
		String novoNome = "";
		String novoBanco = "";
		int novaAgencia = 0;
		int novoNumeroConta = 0;
		ReadTextFile application = new ReadTextFile();
		int quantidadeCota = 0;

		do {
			System.out.println("\n=========================================");
			System.out.println("# Fundo Imobiliario || AG Investimentos #");
			System.out.println("=========================================");
			System.out.println("1 - Cadastrar Nova Conta");
			System.out.println("2 - Pesquisar Conta");
			System.out.println("3 - Editar Conta");
			System.out.println("4 - Transferir para Conta");
			System.out.println("5 - Sacar da Conta");
			System.out.println("6 - Ver Fundos Disponiveis");
			System.out.println("7 - Ordem de Compra");
			System.out.println("8 - Ordem de Venda");
			System.out.println("0 - Sair");
			System.out.println("=========================================\n");
			opcao = input.nextInt();

			if (opcao == 1) {
				System.out.println("# Cadastrar Nova Conta:");
				System.out.println("========================\n");
				System.out.println("Nome: ");
				String nomeCliente = console.readLine();
				System.out.println("CPF: ");
				String cpf = console.readLine();
				System.out.println("Nome do Banco: ");
				String nomeBanco = console.readLine();
				System.out.println("Numero da Agencia: ");
				int numeroAgencia = input.nextInt();
				System.out.println("Numero da Conta: ");
				int numeroConta = input.nextInt();
				System.out.println("Saldo Inicial (R$): ");
				double saldoInicial = input.nextDouble();

				if (saldoInicial > 0) {
					corretoraAraras.criarConta(nomeCliente, cpf, nomeBanco, numeroAgencia, numeroConta, saldoInicial);
				}
				else{
					System.out.println("\nO Saldo Inicial nao pode ser R$0,00. ");
					System.out.println("Por Favor tente novamente. ");
				}
			}

			if (opcao == 2) {
				System.out.println("# Pesquisar Contas:");
				System.out.println("======================================\n");
				System.out.println("Digite o CPF para encontrar uma Conta: ");
				String cpf = console.readLine();
				corretoraAraras.encontrarConta(cpf);
			}

			if (opcao == 3) {
				int opcaoEdicao = 5;

				do {
					System.out.println("\n====================================");
					System.out.println("# Editar Conta || AG Investimentos #");
					System.out.println("======================================");
					System.out.println("1 - Editar Nome do Cliente");
					System.out.println("2 - Editar Nome do Banco");
					System.out.println("3 - Editar Numero da Agencia");
					System.out.println("4 - Editar Numero Conta Cliente");
					System.out.println("0 - Sair");
					System.out.println("====================================\n");
					opcaoEdicao = input.nextInt();

					if (opcaoEdicao == 1) {
						System.out.println("# Editar Nome do Cliente:");
						System.out.println("=================================\n");
						System.out.println("Digite o CPF do titular da Conta: ");
						numeroCPF = console.readLine();
						System.out.println("Digite o Novo Nome: ");
						novoNome = console.readLine();
						corretoraAraras.editarNome(numeroCPF, novoNome);
					}

					if (opcaoEdicao == 2) {
						System.out.println("# Editar Nome do Banco:");
						System.out.println("=================================\n");
						System.out.println("Digite o CPF do titular da Conta: ");
						numeroCPF = console.readLine();
						System.out.println("Digite o Novo Nome do Banco: ");
						novoBanco = console.readLine();
						corretoraAraras.editarBanco(numeroCPF, novoBanco);
					}

					if (opcaoEdicao == 3) {
						System.out.println("# Editar Nome da Agencia:");
						System.out.println("=================================\n");
						System.out.println("Digite o CPF do titular da Conta: ");
						numeroCPF = console.readLine();
						System.out.println("Digite o Novo Nome da Agencia: ");
						novaAgencia = input.nextInt();
						corretoraAraras.editarAgencia(numeroCPF, novaAgencia);
					}

					if (opcaoEdicao == 4) {
						System.out.println("# Editar Numero Conta Cliente:");
						System.out.println("=================================\n");
						System.out.println("Digite o CPF do titular da Conta: ");
						numeroCPF = console.readLine();
						System.out.println("Digite o Novo Numero Conta Cliente: ");
						novoNumeroConta = input.nextInt();
						corretoraAraras.editarNumeroConta(numeroCPF, novoNumeroConta);
					}
				}
				while ( opcaoEdicao != 0 );
			}

			if (opcao == 4) {
				System.out.println("# Transferir para Conta:");
				System.out.println("=================================\n");
				System.out.println("Digite o CPF do titular da Conta: ");
				numeroCPF = console.readLine();
				System.out.println("Digite o valor para depositar: ");
				movimentacao = input.nextDouble();
				corretoraAraras.transferir(numeroCPF, movimentacao);
			}

			if (opcao == 5) {
				System.out.println("# Sacar da Conta:");
				System.out.println("=================================\n");
				System.out.println("Digite o CPF do titular da Conta: ");
				numeroCPF = console.readLine();
				System.out.println("Digite o valor que deseja sacar: ");
				movimentacao = input.nextDouble();
				corretoraAraras.resgatar(numeroCPF, movimentacao);
			}

			if (opcao == 6) {
      			application.openFile();
      			application.readRecords();
      			application.closeFile();
			}

			if (opcao == 7) {
				int opcaoCompra = 5;
				System.out.println("# Ordem de Compra:");
				System.out.println("=================================\n");
				System.out.println("Digite o CPF do titular da Conta: ");
				numeroCPF = console.readLine();

				do {
					System.out.println("\n====================================");
					System.out.println("# Fundos || AG Investimentos #");
					System.out.println("======================================");
					System.out.println("1 - ARARAS OFFICE PARK");
					System.out.println("2 - GUEDES TOWER");
					System.out.println("3 - ARARAS PLAZA SHOPPING");
					System.out.println("0 - Sair");
					System.out.println("=========================================\n");
					System.out.println("Escolha o Fundo a investir: ");
					opcaoCompra = input.nextInt();

					if (opcaoCompra == 1) {
						System.out.println("# ARARAS OFFICE PARK:");
						System.out.println("=================================\n");
						System.out.println("Digite o CPF do titular da Conta: ");
						numeroCPF = console.readLine();
						System.out.println("Quantidade de cota: ");
						quantidadeCota = input.nextInt();
						corretoraAraras.compraCota1(numeroCPF, quantidadeCota);
					}

					if (opcaoCompra == 2) {
						System.out.println("# GUEDES TOWER:");
						System.out.println("=================================\n");
						System.out.println("Digite o CPF do titular da Conta: ");
						numeroCPF = console.readLine();
						System.out.println("Quantidade de cota: ");
						quantidadeCota = input.nextInt();
						corretoraAraras.compraCota2(numeroCPF, quantidadeCota);
					}

					if (opcaoCompra == 3) {
						System.out.println("# ARARAS PLAZA SHOPPING:");
						System.out.println("=================================\n");
						System.out.println("Digite o CPF do titular da Conta: ");
						numeroCPF = console.readLine();
						System.out.println("Quantidade de cota: ");
						quantidadeCota = input.nextInt();
						corretoraAraras.compraCota3(numeroCPF, quantidadeCota);
					}
				}
				while ( opcaoCompra != 0 );
			}

		}
		while ( opcao != 0 );

		System.out.println("\n=================================");
		System.out.println("# AG Investimentos || Obrigado! #");
		System.out.println("=================================");
    }
}