public class FibonacciScript {
	private int[] precalculated=null;
	
	public void launch(int n) {
		// this script will test fibonacci calculator with and without memo-ization
		
		this.doOrdinaryFib(n);
		this.doDynoFib(n);
		
	}

	public void doDynoFib(int n) {
		long startTime = System.currentTimeMillis();
		int result = dynoFib(n);
		long endTime = System.currentTimeMillis();
		System.out.println("dynoFib(" + n + ")=" + result + " took " + (endTime - startTime) + " milliseconds to calculate");
	}
	
	public void doOrdinaryFib(int n) {
		long startTime = System.currentTimeMillis();
		int result = fib(n);
		long endTime = System.currentTimeMillis();
		System.out.println("fib(" + n + ")=" + result + " took " + (endTime - startTime) + " milliseconds to calculate");
	}
	
	public static void main(String[] args) {
		FibonacciScript myScript = new FibonacciScript();
		if (args.length>0) {
			myScript.launch(Integer.parseInt(args[0]));
		}
		else {
			System.out.println("Usage: java FibonacciScript n, where n is the number to use");
		}
	}
	
	public static int fib(int n) {
		if ((n==1) || (n==2)) {
			return 1;
		} else {
			int result = fib(n-1) + fib(n-2);
			return result;
		}
	}
	
	public int dynoFib(int n) {
		if (precalculated==null) {
			initPrecalculatedArray(n);
		}
		if (precalculated[n-1]!=-1) {
			return precalculated[n-1];
		} else {
			int result = dynoFib(n-1) + dynoFib(n-2);
			precalculated[n-1]=result;
			return result;
		}
	}
	
	private void initPrecalculatedArray(int size) {
		precalculated = new int[size];
		for (int i=0; i<precalculated.length;i++) {
			precalculated[i]=-1; // initialise all values to -1
		}
		precalculated[0]=1; // value of fib(1)
		precalculated[1]=1; // value of fib(2)
	}
}