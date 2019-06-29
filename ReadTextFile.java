import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;

class ReadTextFile{
	private Scanner input;

	public void openFile()
	{
		try
		{
		 input = new Scanner( new File( "fii.txt" ) );
		}
		catch ( FileNotFoundException fileNotFoundException )
		{
		 System.err.println( "Error opening file." );
		 System.exit( 1 );
		}
	}

public void readRecords(){
  FII record = new FII();

	try
	{
	  	System.out.println("\n==========================================");
	    System.out.println("Cota: \t Valor: \t Nome:");
	    System.out.println("==========================================");
		
		while ( input.hasNext() )
	    {
			record.setCodigo( input.next() );
			record.setCota( input.nextDouble() );
			record.setNome( input.next() );

	        System.out.printf( "%s \t %4.2f \t %s\n",
				record.getCodigo(), record.getValorCota(), record.getNome() );
	        
	    }
	     	System.out.println("==========================================\n");
  	}
  	catch ( NoSuchElementException elementException )
		{
			System.err.println( "File improperly formed." );
			input.close();
			System.exit( 1 );
		}
	catch ( IllegalStateException stateException )
	{
	    System.err.println( "Error reading from file." );
	    System.exit( 1 );
  	}
}

	public void closeFile()
	{
	  	if ( input != null )
	    	input.close();
	}
}