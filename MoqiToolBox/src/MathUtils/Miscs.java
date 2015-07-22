package MathUtils;

public class Miscs {
	public double sqrt(double x) {
		//牛顿迭代法开根
	    double eps = 10e-10;
	    double val = x;
	    double last;
	    do {
	    	last = val;
	    	val =(val + x/val) / 2;
	    } while(Math.abs(val-last) > eps);
	    return val;
	}
}
