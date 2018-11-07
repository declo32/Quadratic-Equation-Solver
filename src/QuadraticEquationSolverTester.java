public class QuadraticEquationSolverTester {
	public static void main(String[] args) {
		QuadraticEquationSolver[] quadraticEquationSolvers = {
				new QuadraticEquationSolver(1, 0, 0, 0),  // x^2 = 0           (one real solution)
				new QuadraticEquationSolver(1, 2, 3, 4),  // x^2 + 2x + 3 = 4  (two real solutions)
				new QuadraticEquationSolver(1, 0, 1, 0),  // x^2 + 1 = 0       (one imaginary solution) FAILS HERE
		};

		for (QuadraticEquationSolver quadraticEquationSolver : quadraticEquationSolvers) {
			System.out.println(quadraticEquationSolver);
			for (Radical radical : quadraticEquationSolver.getZeros()) {
				System.out.println("\t" + radical);
			}
			System.out.println();
		}
	}
}
