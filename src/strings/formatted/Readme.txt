System.out.printf("Formatting_String",Value);
Formatting String:
%d : Integer
%f : Float - Default Precision is 6. Print till 6 decimal places
%c : Character
%C : Convert to UpperCase character
%s : String
%S : UpperCase String
%b : Boolean (Possible Values - true/false)
%B : UpperCase Boolean (Possible Values - TRUE/FALSE)
Note that if null is passed for boolean value it will return false or other value is passed like string value it will return true
%e : Value in form of Exponent
%E : Value in form of UpperCase Exponent
%g : It either returns decimal value or exponent value
%G : It either returns decimal value or exponent value
How %g/%G chooses between decimal value or exponent value?
The result is formatted using computerized scientific notation or decimal format, depending on the precision and the value after rounding.
If magnitude is greater than or equal tom 10^-4 but less than 10^precision then it represented in decimal format.
If magnitude is less than 10^-4 or greater than or equal to 10^precision, then it represented in computerized scientific notation.
The total number of significant digits in the magnitude is equals to the precision. If the precision is not specified, then default value is 6. If the precision is 0, then it is taken to be 1.

%o : Convert to Octal Number
%x : Convert to HexaDecimal value
%X : Convert to UpperCase HexaDecimal value
%h : HashCode
%H : UpperCase HashCode
%a : HexaDecimal floating Point Value
%A : UpperCase HexaDecimal floating Point Value
%n : NewLine - \n
%% : Return % Sign

%[argument_index$][flags][width][.precision] f
%.0f : No decimal
%.1f : 1 Decimal Point
Note that rounding also work
Flags : '-','+',' ','0','(','#'