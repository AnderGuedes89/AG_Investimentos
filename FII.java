import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;

class FII {
	private String codigo;
	private double valorCota;
	private String nome;

	public FII() {
	  	this.codigo = "";
		this.valorCota = 0.0;
		this.nome = "";
	} 

	public FII( String codigo, double cota, String nome ) {
	  	this.codigo = codigo;
		this.valorCota = cota;
		this.nome = nome;
	} 

	public void setCodigo( String codigo ) {
	  this.codigo = codigo;
	}

	public String getCodigo(){
	  return this.codigo;
	} 

	public void setCota ( double cota ) {
	  this.valorCota = cota;
	} 

	public double getValorCota() {
	  return this.valorCota;
	}

	public void setNome ( String nome ) {
	  this.nome = nome;
	} 

	public String getNome() {
	  return this.nome;
	}
}