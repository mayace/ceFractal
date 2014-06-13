package com.github.ceFractal.compiler.fractal;

import java_cup.runtime.Symbol;


%%

%public
%class Scanner
%cup
%line
%column
%type ESymbol

%{

  public static class ESymbol extends Symbol{
    public int offset;
    public int length;
    public ESymbol(int id, int l, int r, Object o) {
        super(id, l, r, o);
    }
  }

  StringBuffer string = new StringBuffer();

  private ESymbol symbol(int type) {
    return new ESymbol(type, yyline, yycolumn,yytext()){{this.offset = yychar;this.length = yylength();}};
  }
  private ESymbol symbol(int type, Object value) {
    return new ESymbol(type, yyline, yycolumn, value){{this.offset = yychar;this.length = yylength();}};
  }

  private void process_error(){
    throw new Error("Illegal character <" + yytext() + ">");
  }
%}

NEWLINE = \n|\r|\r\n
SPACE   = [ \t]|{NEWLINE}
ID      = [:jletter:] [:jletterdigit:]*
INT     = [0-9]+
FLOAT   = {INT}"."{INT}
CHAR    = "'"[^\n\r\t\\]"'"
BOOL    = "true"|"false"


%state STRING

%%

<YYINITIAL>
{
    {SPACE}     {}

    "int"       {return symbol(Sym.KW_INT);}
    "float"     {return symbol(Sym.KW_FLOAT);}
    "char"      {return symbol(Sym.KW_CHAR);}
    "string"    {return symbol(Sym.KW_STRING);}
    "bool"      {return symbol(Sym.KW_BOOL);}

    "array"     {return symbol(Sym.KW_ARRAY);}
    "new"       {return symbol(Sym.KW_NEW);}
    "while"     {return symbol(Sym.KW_WHILE);}
    "do"        {return symbol(Sym.KW_DO);}
    "for"       {return symbol(Sym.KW_FOR);}
    "continue"  {return symbol(Sym.KW_CONTINUE);}
    "break"     {return symbol(Sym.KW_BREAK);}
    "if"        {return symbol(Sym.KW_IF);}
    "else"      {return symbol(Sym.KW_ELSE);}
    "switch"    {return symbol(Sym.KW_SWITCH);}
    "case"      {return symbol(Sym.KW_CASE);}
    "default"   {return symbol(Sym.KW_DEFAULT);}
    "class"     {return symbol(Sym.KW_CLASS);}
    "public"    {return symbol(Sym.KW_PUBLIC);}
    "private"   {return symbol(Sym.KW_PRIVATE);}
    "extends"   {return symbol(Sym.KW_EXTENDS);}
    "import"    {return symbol(Sym.KW_IMPORT);}

    "="         {return symbol(Sym.EQUAL);}
    "+="        {return symbol(Sym.PEQUAL);}
    "-="        {return symbol(Sym.MIEQUAL);}
    "*="        {return symbol(Sym.MUEQUAL);}
    "/="        {return symbol(Sym.DIEQUAL);}
    "=="        {return symbol(Sym.DEQUAL);}
    ">"         {return symbol(Sym.BTAH);}
    ">="        {return symbol(Sym.BETHAN);}
    "<"         {return symbol(Sym.LTHAN);}
    "<="        {return symbol(Sym.LETHAN);}
    "!="        {return symbol(Sym.NEQUAL);}
    "&&"        {return symbol(Sym.AND);}
    "||"        {return symbol(Sym.OR);}
    "!"         {return symbol(Sym.NOT);}
    
    "++"        {return symbol(Sym.DPLUS);}
    "+"         {return symbol(Sym.PLUS);}
    "--"        {return symbol(Sym.DMINUS);}
    "-"         {return symbol(Sym.MINUS);}
    "*"         {return symbol(Sym.MULT);}
    "/"         {return symbol(Sym.DIV);}
    "^"         {return symbol(Sym.EXP);}
    "["         {return symbol(Sym.QL);}
    "]"         {return symbol(Sym.QR);}
    "("         {return symbol(Sym.PL);}
    ")"         {return symbol(Sym.PR);}
    "{"         {return symbol(Sym.LL);}
    "}"         {return symbol(Sym.LR);}
    ","         {return symbol(Sym.COMA);}
    ";"         {return symbol(Sym.PCOMA);}
    ":"         {return symbol(Sym.DPUNTOS);}
    "."         {return symbol(Sym.PUNTO);}
    "&"         {return symbol(Sym.REF);}
    "#"         {return symbol(Sym.NUMERAL);}

    {INT}       {return symbol(Sym.INT,yytext());}
    {FLOAT}     {return symbol(Sym.FLOAT,yytext());}
    {CHAR}      {return symbol(Sym.CHAR,yytext());}
    {BOOL}      {return symbol(Sym.BOOL,yytext());}
    {ID}        {return symbol(Sym.ID,yytext());}

    \"          {string.setLength(0); yybegin(STRING);}
}

<STRING> {
  \"            {yybegin(YYINITIAL);return symbol(Sym.STRING, string.toString());}
  [^\n\r\"\\]+  { string.append( yytext() ); }
  \\t           { string.append('\t'); }
  \\n           { string.append('\n'); }
  \\r           { string.append('\r'); }
  \\\"          { string.append('\"'); }
  \\            { string.append('\\'); }
}


[^]             {process_error();}

<<EOF>>         {return symbol(Sym.EOF);}