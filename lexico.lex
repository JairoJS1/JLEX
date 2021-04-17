import java.lang.System;

class Analex {
      public static void main(String argv[])
	throws java.io.IOException {
	Yylex yy = new Yylex(System.in);
	while (yy.yylex() != null) {}	
    }
}

class Yytoken {
  Yytoken () {}
}
 
%%

%eofval{
  { System.exit(0); }
%eofval}

%line    
%char  

NUMBER = [0-9]*
LETTER = [a-zA-Z]
COMILLA = [\"]
LINEA = [\n]
TAB = [\t]

%state COMENTARIO


%%
 
 
 
 
 

<YYINITIAL> {NUMBER} 	{ System.out.println ("NUMERO ");} 
<YYINITIAL> {LETTER} 	{ System.out.println ("LETRA ");} 
<YYINITIAL> \#{LETTER} 	{ System.out.println ("COMENTARIO ");}
<YYINITIAL> {COMILLA} 	{ System.out.println ("COMILLAS");}
<YYINITIAL> {LINEA} 	{ System.out.println ("SALTO DE LINEA");}
<YYINITIAL> {TAB} 	{ System.out.println ("TABULACION");}


<YYINITIAL> "(" 		{ System.out.println ("PAR ABIERTO ");}
<YYINITIAL> ")" 		{ System.out.println ("PAR CERRADO ");}
<YYINITIAL> "[" 		{ System.out.println ("CORCH ABIERTO ");}
<YYINITIAL> "]" 		{ System.out.println ("CORCH CERRADO ");}
<YYINITIAL> "{" 		{ System.out.println ("LLAVE ABIERTA ");}
<YYINITIAL> "}" 		{ System.out.println ("LLAVE CERRADA ");}
<YYINITIAL> ";" 		{ System.out.println ("PUNTO Y COMA ");}
<YYINITIAL> ":" 		{ System.out.println ("DOS PUNTOS ");}
<YYINITIAL> "$" 		{ System.out.println ("IDENTIFICADOR DE VARIABLES ");}

<YYINITIAL> "and"    	{ System.out.println ("AND ");}
<YYINITIAL> "args"    	{ System.out.println ("ARGS ");}
<YYINITIAL> "abstract" 	{ System.out.println ("ABSTRACT ");}
<YYINITIAL> "assert" 	{ System.out.println ("ASSERT ");}
<YYINITIAL> "absolute" 	{ System.out.println ("ABSOLUTE ");}
<YYINITIAL> "array" 	{ System.out.println ("ARRAY ");}
<YYINITIAL> "await" 	{ System.out.println ("AWAIT ");}
<YYINITIAL> "asm" 		{ System.out.println ("SWITCH ");}
<YYINITIAL> "auto" 		{ System.out.println ("SYNCHRONIZED ");}


<YYINITIAL> "bool" 		{ System.out.println ("THIS ");}
<YYINITIAL> "begin" 	{ System.out.println ("BEGIN ");}
<YYINITIAL> "boolean" 	{ System.out.println ("BOOLEAN ");}
<YYINITIAL> "break" 	{ System.out.println ("BREAK ");}
<YYINITIAL> "byte" 		{ System.out.println ("BYTE ");}

<YYINITIAL> "case" 		{ System.out.println ("CASE ");}
<YYINITIAL> "cath" 		{ System.out.println ("CATCH ");}
<YYINITIAL> "char" 		{ System.out.println ("CHAR");}
<YYINITIAL> "class" 	{ System.out.println ("CLASS ");}
<YYINITIAL> "const" 	{ System.out.println ("CONST ");}
<YYINITIAL> "continue" 	{ System.out.println ("ABSTRACT ");}


<YYINITIAL> "default" 	{ System.out.println ("DEFAULT ");}
<YYINITIAL> "debugger" 	{ System.out.println ("DEBUGGER ");}
<YYINITIAL> "delete" 	{ System.out.println ("DELETE ");}
<YYINITIAL> "destructor" 	{ System.out.println ("DESTRUCTOR ");}
<YYINITIAL> "do" 		{ System.out.println ("DO ");}
<YYINITIAL> "div" 		{ System.out.println ("DIV ");}
<YYINITIAL> "downto" 	{ System.out.println ("DOWNTO ");}
<YYINITIAL> "double" 	{ System.out.println ("DOUBLE ");}

<YYINITIAL> "else" 		{ System.out.println ("ELSE ");}
<YYINITIAL> "enum" 		{ System.out.println ("ENUM ");}
<YYINITIAL> "extends" 	{ System.out.println ("EXTENDS ");}
<YYINITIAL> "export" 	{ System.out.println ("EXPORT ");}
<YYINITIAL> "extends" 	{ System.out.println ("EXTENDS ");}
<YYINITIAL> "end" 		{ System.out.println ("END ");}

<YYINITIAL> "false"    	{ System.out.println ("FALSE ");}
<YYINITIAL> "final" 	{ System.out.println ("FINAL ");}
<YYINITIAL> "Finally" 	{ System.out.println ("FINALLY ");}
<YYINITIAL> "float" 	{ System.out.println ("FLOAT ");}
<YYINITIAL> "for" 		{ System.out.println ("FOR ");}
<YYINITIAL> "function" 	{ System.out.println ("FUNCTION ");}

<YYINITIAL> "goto" 		{ System.out.println ("GOTO ");}

<YYINITIAL> "if" 		{ System.out.println ("IF ");}
<YYINITIAL> "import" 	{ System.out.println ("IMPORT ");}
<YYINITIAL> "instanceof"	{ System.out.println ("INSTANCEOF ");}
<YYINITIAL> "int" 		{ System.out.println ("INT ");}
<YYINITIAL> "in" 		{ System.out.println ("IN ");}
<YYINITIAL> "interface" { System.out.println ("INTERFACE ");}

<YYINITIAL> "long" 		{ System.out.println ("LONG ");}
<YYINITIAL> "label" 	{ System.out.println ("LABEL ");}

<YYINITIAL> "null"    	{ System.out.println ("NULL ");}
<YYINITIAL> "native" 	{ System.out.println ("NATIVE ");}
<YYINITIAL> "nil" 		{ System.out.println ("NIL ");}
<YYINITIAL> "new" 		{ System.out.println ("NEW ");}
<YYINITIAL> "not"    { System.out.println ("NOT ");}

<YYINITIAL> "or"		{ System.out.println ("OR ");}


<YYINITIAL> "program" 	{ System.out.println ("PROGRAM ");}
<YYINITIAL> "package" 	{ System.out.println ("PACKAGE ");}
<YYINITIAL> "private" 	{ System.out.println ("PRIVATE ");}
<YYINITIAL> "protected"	{ System.out.println ("PROTECTED ");}
<YYINITIAL> "public" 	{ System.out.println ("PUBLIC ");}

<YYINITIAL> "return"	{ System.out.println ("RETURN ");}
<YYINITIAL> "read" 		{ System.out.println ("READ ");}

<YYINITIAL> "sizeof"    { System.out.println ("SIZEOF ");}
<YYINITIAL> "short" 	{ System.out.println ("SHORT ");}
<YYINITIAL> "static" 	{ System.out.println ("STATIC ");}
<YYINITIAL> "strictfp" 	{ System.out.println ("STRICTFP ");}
<YYINITIAL> "super" 	{ System.out.println ("SUPER ");}
<YYINITIAL> "switch" 	{ System.out.println ("SWITCH ");}
<YYINITIAL> "synchronized" 	{ System.out.println ("SYNCHRONIZED ");}
<YYINITIAL> "shil" 		{ System.out.println ("SHIL ");}
<YYINITIAL> "switch" 	{ System.out.println ("SWITCH ");}
<YYINITIAL> "struct"    { System.out.println ("STRUCT ");}
<YYINITIAL> "String" 	{ System.out.println ("STRING ");}
<YYINITIAL> "string" 	{ System.out.println ("STRING ");}

<YYINITIAL> "true"    	{ System.out.println ("TRUE ");}
<YYINITIAL> "to" 		{ System.out.println ("TO ");}
<YYINITIAL> "this" 		{ System.out.println ("THIS ");}
<YYINITIAL> "throw"		{ System.out.println ("THROW ");}
<YYINITIAL> "throws" 	{ System.out.println ("THROWS ");}
<YYINITIAL> "transient"	{ System.out.println ("TRANSIENT ");}
<YYINITIAL> "try" 		{ System.out.println ("TRY ");}
<YYINITIAL> "typeof"    { System.out.println ("TYPEOF ");}

<YYINITIAL> "unit" 		{ System.out.println ("UNIT ");}
<YYINITIAL> "uses" 		{ System.out.println ("USES ");}
<YYINITIAL> "union"    { System.out.println ("UNION ");}

<YYINITIAL> "var"    	{ System.out.println ("VAR ");}
<YYINITIAL> "virtual" 	{ System.out.println ("VIRTUAL ");}
<YYINITIAL> "void" 		{ System.out.println ("VOID ");}
<YYINITIAL> "volatile" 	{ System.out.println ("VOLATILE ");}

<YYINITIAL> "with" 		{ System.out.println ("WITH ");}
<YYINITIAL> "while"     { System.out.println ("WHILE ");}
<YYINITIAL> "writeln"   { System.out.println ("WRITELN ");}

<YYINITIAL> "yield"   	{ System.out.println ("YIELD ");}


<YYINITIAL> "incr" 		{ System.out.println ("INCR ");}
<YYINITIAL> "set" 		{ System.out.println ("SET ");}
<YYINITIAL> "puts" 		{ System.out.println ("PUTS ");}
<YYINITIAL> "expr" 		{ System.out.println ("EXPR ");}

<YYINITIAL> ">" 		{ System.out.println ("MAYOR ");}
<YYINITIAL> "<" 		{ System.out.println ("MENOR");}
<YYINITIAL> "=" 		{ System.out.println ("IGUAL ");}
<YYINITIAL> "!" 		{ System.out.println ("DIFERENCIA ");}
<YYINITIAL> "/" 		{ System.out.println ("DIVISION ");}
<YYINITIAL> "," 		{ System.out.println ("COMA ");}
<YYINITIAL> "." 		{ System.out.println ("PUNTO ");}
<YYINITIAL> "+" 		{ System.out.println ("SIGNO MAS ");}
<YYINITIAL> "-" 		{ System.out.println ("SIGNO MENOS ");}
<YYINITIAL> "*" 		{ System.out.println ("SIGNO POR ");}
<YYINITIAL> "/" 		{ System.out.println ("SIGNO DE DIVISION ");}
<YYINITIAL> "//" 		{ System.out.println ("COMENTARIOS ");}
<YYINITIAL> "%"			{ System.out.println ("SIGNO DE PORCENTAJE ");} 
<YYINITIAL> "&&"		{ System.out.println ("AND ");} 
<YYINITIAL> "||"		{ System.out.println ("OR ");} 
<YYINITIAL> "_"			{ System.out.println ("GUION BAJO ");} 
<YYINITIAL> "'"			{ System.out.println ("COMILLA SIMPLE ");} 
<YYINITIAL> "System.out.println"			{ System.out.println ("IMPRIMIR ");} 
<YYINITIAL> "#include"		{ System.out.println ("INCLUDE ");} 
<YYINITIAL> "<iostream>"	{ System.out.println ("IOSTREAM ");} 
 <YYINITIAL> "std"			{ System.out.println ("STD ");} 
 <YYINITIAL> "cout"			{ System.out.println ("COUT ");} 
 
 
 
<YYINITIAL> [\n] 		{yychar=0;}
<YYINITIAL>  (" "|\r|\t)+	{ }

<YYINITIAL> "/*"		{yybegin(COMENTARIO);
						 System.out.println("Aqui inicia el esado con /*");
						}
<COMENTARIO> [\n]		{System.out.println ("Una linea de comentario");}
<COMENTARIO> "*"		{}
<COMENTARIO> [^"*/"]	{}
<COMENTARIO> "*/"		{yybegin(YYINITIAL);
						System.out.println ("Aqui Termina el comentario con */");
						}
.
  { 
    System.out.println("error lexico en "  + yyline + "," + yychar + " No se reconoce " + yytext());
    yychar=0;
  }
  
  
 
  
  