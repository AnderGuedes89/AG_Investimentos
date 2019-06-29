import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;

class CarteiraClientes {
	ArrayList<DadosDoCliente> contasCorretora = new ArrayList<>();

	public CarteiraClientes() {

	}

	public void criarConta(String nomeCliente, String cpf, String nomeBanco, int numeroAgencia, int numeroConta, double saldoInicial) {
		DadosDoCliente novaConta = new DadosDoCliente(nomeCliente, cpf, nomeBanco, numeroAgencia, numeroConta, saldoInicial);
		this.contasCorretora.add(novaConta);
	}

	public void transferir(String numero_conta, double valor) {
		DadosDoCliente contaEncontrada = this.encontrarConta(numero_conta);
		contaEncontrada.transferir(valor);
	}

	public void resgatar(String numero_conta, double valor) {
		DadosDoCliente contaEncontrada = this.encontrarConta(numero_conta);
		contaEncontrada.resgatar(valor);
	}

	public void editarNome(String numeroCPF, String novoNome) {
		DadosDoCliente contaEncontrada = this.encontrarConta(numeroCPF);
		contaEncontrada.editarNome(novoNome);
	}

	public void editarBanco(String numeroCPF, String novoBanco) {
		DadosDoCliente contaEncontrada = this.encontrarConta(numeroCPF);
		contaEncontrada.editarBanco(novoBanco);
	}

	public void editarAgencia(String numeroCPF, int novaAgencia) {
		DadosDoCliente contaEncontrada = this.encontrarConta(numeroCPF);
		contaEncontrada.editarAgencia(novaAgencia);
	}

	public void editarNumeroConta(String numeroCPF, int novoNumeroConta) {
		DadosDoCliente contaEncontrada = this.encontrarConta(numeroCPF);
		contaEncontrada.editarNumeroConta(novoNumeroConta);
	}

	public void compraCota1(String numeroCPF, int quantidadeCota) {
		DadosDoCliente contaEncontrada = this.encontrarConta(numeroCPF);
		contaEncontrada.compraCota1(quantidadeCota);
	}

	public void compraCota2(String numeroCPF, int quantidadeCota) {
		DadosDoCliente contaEncontrada = this.encontrarConta(numeroCPF);
		contaEncontrada.compraCota2(quantidadeCota);
	}

	public void compraCota3(String numeroCPF, int quantidadeCota) {
		DadosDoCliente contaEncontrada = this.encontrarConta(numeroCPF);
		contaEncontrada.compraCota3(quantidadeCota);
	}

	public DadosDoCliente encontrarConta(String cpf) {
		DadosDoCliente contaEncontrada = null;
		for ( int x = 0; x < this.contasCorretora.size(); x++ ) {
			if (Objects.equals(contasCorretora.get(x).getCPF(), cpf)) {
				contaEncontrada = contasCorretora.get(x);
				System.out.println("\n==========================================");
				System.out.println("# Dados Encontrados || AG Investimentos #");
				System.out.println("==========================================");
				System.out.println("Nome: " + contaEncontrada.getNomeCliente());
				System.out.println("CPF: " + contaEncontrada.getCPF());
				System.out.println("Banco: " + contaEncontrada.getNomeBanco());
				System.out.println("Agencia: " + contaEncontrada.getNumeroAgencia());
				System.out.println("Conta Corrente: " + contaEncontrada.getnumeroConta());
				System.out.println("Saldo: R$ " + contaEncontrada.getSaldoInicial());
				System.out.println("=========================================\n");
			}
		}
		return contaEncontrada;
	}
}