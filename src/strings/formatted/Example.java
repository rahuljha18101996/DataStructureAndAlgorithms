package strings.formatted;

import java.util.Calendar;

public class Example {
    public static void main(String[] args) {
//        Error
//        System.out.printf("%d",10.2);
//        System.out.printf("%d","10");

//        System.out.printf("%g",0.00550);//0.00550000
//        System.out.printf("%g",0.00005);//0.005500005.00000e-05

        //System.out.printf("%3$s %<s %s %<s %s %s %s","first","second","third","fourth");//third third first first second third

//        String formatted = String.format("%.4f",1.2345);
//        String formatted = String.format("%.000005s","HelloWord");

//        System.out.println(formatted);

        //Calender
        Calendar cal = Calendar.getInstance();
        System.out.printf("%tB%n",cal);//November
        System.out.printf("%TB%n",cal);//NOVEMBER

        //Precision
        double d = 12.3456789;
        System.out.printf("%.0f%n",d); //12
        System.out.printf("%.1f%n",d);//12.3
        System.out.printf("%.2f%n",d);//12.35
        System.out.printf("%.3f%n",d);//12.346
        System.out.printf("%.4f%n",d);//12.3457
        System.out.printf("%.5f%n",d);//12.34568
        System.out.printf("%.6f%n",d);//12.345679
        System.out.printf("%.7f%n",d);//12.3456789
        System.out.printf("%.8f%n",d);//12.34567890

        String str = "hello";
        int num = 15;
        char let = 'A';
        System.out.printf("%.2s%n",str);//He
        System.out.printf("%.2b%n",true);//tr
        System.out.printf("%.2h%n",str);//5e
//        System.out.printf("%.2d%n",num);//error
//        System.out.printf("%.2c%n",let);//error
//        System.out.printf("%.3n%n",num);//error

        //Width
        System.out.printf("%8d%n",123);//     123
        System.out.printf("%4d%5d%n",123,456);// 123  456
        System.out.printf("%6f%n",123.45);//123.450000
        System.out.printf("%6.2f%n",123.45);//123.45
        System.out.printf("%10.1f%n",123.45);//     123.5
        System.out.printf("%-10.1f%n",123.45);//123.5
        System.out.printf("%-10d%n",123);//123
//        System.out.printf("%10n",123);//Error

        //# - Pound Flag
        //Works with -> %0 %x %e %f %a
        // A 0 is appended to the front of octal number when the flag isused.A 0x is appended to the front of hexadecimal number when # flag is used.
        System.out.printf("%#o%n",123);//0173
        System.out.printf("%#x%n",1234);//0x4d2
        System.out.printf("%#08x%n",1234);//0x0004d2

        System.out.printf("%.1f%n",12.34);//12.3
        System.out.printf("%#.0f%n",12.34);//12.
        System.out.printf("%#.0e%n",12.34);//1.e+01
        System.out.printf("%#08.0f%n",12.34);//0000012.
        System.out.printf("%#08.0e%n",12.34);//001.e+01
        System.out.printf("%#a%n",12.34);//0x1.8ae147ae147aep3

        //( flag for negative number
        //work with %d %x %f %o %g
        System.out.printf("%(8d%n",-123);//   (123)
        System.out.printf("%(8.1f%n",-123.45);// (123.5)

        //0 flag
        //0 flag must have a width associated with it. If there is not a width specified, the result will be an error
        //work with %d %x %f %o %g%a
//        System.out.printf("%0d%n",123);//Error
        System.out.printf("%06d%n",-123);//-00123
        System.out.printf("%07.2f%n",123.12);//0123.12
//        System.out.printf("%-07d%n",123);//Error

        //Space ' ' flag
        //work with %d %x %f %o %g%a
        //Add padding of one space before positive number and negative number are ignored
        System.out.printf("% d%n",123);// 123
        System.out.printf("% d%n",-123);//-123
        //System.out.printf("% +d%n",-123);//Error

        //+ Flag
        //work with %d %x %f %o %g%a
        //+ Flag Guarantee the Sign
        System.out.printf("%+d%n",123);//+123
        System.out.printf("%+d%n",-123);//+123

        //- Flag
        //Work with everything except %n
        //Only used with width
        //By Default the value shift to right if there are extra width
        //It's for left oriented
        System.out.printf("%8d%n",123);//     123
        System.out.printf("%-8d%n",123);//123
    }
}
