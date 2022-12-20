>> Bit Manipulation <<

Bit Manipulation is used in the variety of problems. Sometimes, the question explicitly calls for bit manipulation. Other times, it's simply useful technique to optimize your code.

> Bit Facts and Tricks
The following expressions are useful in bit manipulation:
1.  x ^ 0s = x, eg., 1010 ^ 0000 = 1010
2.  x ^ 1s = ~x, eg., 1010 ^ 1111 = 0101
3.  x ^ x = 0, eg., 1010 ^ 1010 = 0000
4.  x & 0s = 0
5.  x & 1s = x
6.  x & x = x
7.  x | 0s = x
8.  x | 1s = 1
9.  x | x = x

> Two's Complement and Negative Number
Computers typically store integers in two's complement representaion. A positive number is represented as itself while a negative number is represented as two's complement of its absolute value(with 1 in its sign bit to indicate that a negative value).

The two's complement of N-Bit number (where N is the number of bits used for the number,excluding the sign bit). is the complement of number with respect to 2^N.

Lets look at 4-bit integer -3 as an example. If it is a 4-bit number, we have 1 bit fot sign and 3 bits for the value. We want complement with respect to 2^3, which is 8. The complement of 3(the absolute value of -3) with respect to 8 is 5. 5 in binary is 10. Therefore, -3 in binary as a 4-Bit number is 1101.

In other words, the binary representaion of -K(negative K) as a N-Bit number is concat(1, 2^(N-1) - K).

Another way is look at this is that we invert the bits in positive representaion and then add 1.

4-Bit Integers example:

Positive Number	Negative Number
7 0111			        -1   1111
6 0110			        -2   1110
5 0101	        		-3   1101
4 0100	        		-4   1100
3 0011		        	-5   1011
2 0010      			-6   1010
1 0001		        	-7   1001
0 0000