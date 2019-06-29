import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;

class DadosDoCliente {
	protected String nomeCliente;
	protected String cpf;
	protected String nomeBanco;
	protected int numeroAgencia;
	protected int numeroConta;
	protected double saldoInicial;

	DadosDoCliente(){
		this.nomeCliente = "";
		this.cpf = "";
		this.nomeBanco = "";
		this.numeroAgencia = 0;
		this.numeroConta = 0;
		this.saldoInicial = 0.0;
	}

	DadosDoCliente(String nomeCliente, String cpf, String nomeBanco, int numeroAgencia, int numeroConta, double saldoInicial){
		this.nomeCliente = nomeCliente;
		this.cpf = cpf;
		this.nomeBanco = nomeBanco;
		this.numeroAgencia = numeroAgencia;
		this.numeroConta = numeroConta;
		this.saldoInicial = saldoInicial;
	}
	
	public String getNomeCliente() {
		return this.nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCPF() {
		return this.cpf;
	}

	public void setCPF(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeBanco() {
		return this.nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	public int getNumeroAgencia() {
		return this.numeroAgencia;
	}

	public void setNumeroAgencia(int numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public int getnumeroConta() {
		return this.numeroConta;
	}

	public void setnumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public double getSaldoInicial() {
		return this.saldoInicial;
	}

	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public void transferir(double valor) {
		this.saldoInicial = this.saldoInicial + valor;
	}

	public void transferir(String string_valor) {
		double valor = Double.parseDouble(string_valor);
		this.saldoInicial = this.saldoInicial + valor;
	}

	public void resgatar(double valor) {
		this.saldoInicial = this.saldoInicial - valor;
	}

	public void editarNome(String novoNome) {
		this.nomeCliente = novoNome;
	}

	public void editarBanco(String novoBanco) {
		this.nomeBanco = novoBanco;
	}

	public void editarAgencia(int novaAgencia) {
		this.numeroAgencia = novaAgencia;
	}

	public void editarNumeroConta(int novoNumeroConta) {
		this.numeroConta = novoNumeroConta;
	}

	public void compraCota1(int quantidadeCota) {
		this.saldoInicial = saldoInicial - (quantidadeCota * 109.50);
	}

	public void compraCota2(int quantidadeCota) {
		this.saldoInicial = saldoInicial - (quantidadeCota * 62.45);
	}

	public void compraCota3(int quantidadeCota) {
		this.saldoInicial = saldoInicial - (quantidadeCota * 3.58);
	}
}