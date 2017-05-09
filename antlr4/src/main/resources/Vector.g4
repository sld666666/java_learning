grammar Vector;

prog: '[' value ']';

value: (INT)*;

INT : [0-9]+;
STRING : '"'.*?'"'

