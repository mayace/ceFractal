package com.github.ceFractal.compiler.pj;

import java_cup.runtime.Symbol;


%%

%public
%class Scanner
%cup
%line
%column

%{
  StringBuffer string = new StringBuffer();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn,yytext());
  }
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }

  private void process_error(){
    throw new Error("Illegal character <" + yytext() + ">");
  }
%}

NEWLINE = \n|\r|\r\n
SPACE   = [ \t]|{NEWLINE}
ID      = [:jletter:] [:jletterdigit:]*
TAGi    = "<"{ID}
TAGf    = "</"{ID}">"


%state STRING

%%

<YYINITIAL>
{
    {SPACE}     {}

    "="         {return symbol(Sym.EQUAL);}
    "/>"        {return symbol(Sym.TAGe);}
    ">"         {return symbol(Sym.TAGi2);}
    {TAGi}      {return symbol(Sym.TAGi);}
    {TAGf}      {return symbol(Sym.TAGf);}
    {ID}        {return symbol(Sym.ID,yytext());}

    \"          {string.setLength(0); yybegin(STRING); }
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