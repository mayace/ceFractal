package com.github.ceFractal.compiler.fractal;

import java_cup.runtime.Symbol;


%%

%public
%class Scanner
%cup
%char
%line
%column
%type SSymbol

%{

  public static class SSymbol extends Symbol{
    public int offset;
    public int length;
    public SSymbol(int id, int l, int r, Object o) {
        super(id, l, r, o);
    }
  }

  StringBuffer string = new StringBuffer();
  int string_offset = 0;
  int string_length = 0;

  private SSymbol symbol(int type) {
    return symbol(type,yytext());
  }
  private SSymbol symbol(int type, Object value) {

    int offset = yychar;
    int length = yylength();

    if (type == Sym.STRING){
      offset = string_offset;
      length = value.toString().length() + 2;
    }

    final int o = offset;
    final int l = length;

    return new SSymbol(type, yyline, yycolumn, value){{
      this.offset = o;
      this.length = l;
    }};
  }

  private void process_error(){
    throw new Error("Illegal character <" + yytext() + ">");
  }
%}

NEWLINE = \n\r|\n|\r
SPACE   = [ \t]
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

    {NEWLINE}   {return symbol(Sym.NEWLINE);}

    "int"       {return symbol(Sym.KW_INT);}
    "float"     {return symbol(Sym.KW_FLOAT);}
    "char"      {return symbol(Sym.KW_CHAR);}
    "string"    {return symbol(Sym.KW_STRING);}
    "bool"      {return symbol(Sym.KW_BOOL);}

    // "Array"     {return symbol(Sym.KW_ARRAY);}
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
    "#import"   {return symbol(Sym.KW_IMPORT);}
    "return"    {return symbol(Sym.KW_RETURN);}
    "static"    {return symbol(Sym.KW_STATIC);}
    "void"      {return symbol(Sym.KW_VOID);}

    "="         {return symbol(Sym.EQUAL);}
    "+="        {return symbol(Sym.PEQUAL);}
    "-="        {return symbol(Sym.MIEQUAL);}
    "*="        {return symbol(Sym.MUEQUAL);}
    "/="        {return symbol(Sym.DIEQUAL);}
    "=="        {return symbol(Sym.DEQUAL);}
    ">"         {return symbol(Sym.BTHAN);}
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
    // ";"         {return symbol(Sym.PCOMA);}
    "?"         {return symbol(Sym.Q);}
    ":"         {return symbol(Sym.DPUNTOS);}
    "."         {return symbol(Sym.PUNTO);}
    "&"         {return symbol(Sym.REF);}
    //"#"         {return symbol(Sym.NUMERAL);}

    {INT}       {return symbol(Sym.INT,yytext());}
    {FLOAT}     {return symbol(Sym.FLOAT,yytext());}
    {CHAR}      {return symbol(Sym.CHAR,yytext());}
    {BOOL}      {return symbol(Sym.BOOL,yytext());}
    {ID}        {return symbol(Sym.ID,yytext());}

    \"          {string_offset=yychar; string.setLength(0); yybegin(STRING);}
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


// [^]             {process_error();}
[^]             {return symbol(Sym.ERROR,yytext());}

<<EOF>>         {return symbol(Sym.EOF);}