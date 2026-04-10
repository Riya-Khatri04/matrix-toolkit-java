import java.util.Scanner;

public class MatrixToolkit {

    // Function to input matrix
    public static int[][] inputMatrix(Scanner sc, int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        return matrix;
    }

    // Display matrix
    public static void display(int[][] matrix) {
        if (matrix == null) return;
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    // Addition
    public static int[][] add(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    // Multiplication
    public static int[][] multiply(int[][] A, int[][] B) {
        int r1 = A.length, c1 = A[0].length;
        int r2 = B.length, c2 = B[0].length;

        if (c1 != r2) {
            System.out.println("Multiplication not possible");
            return null;
        }

        int[][] result = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    // Transpose
    public static int[][] transpose(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }

    // Determinant 2x2
    public static int det2x2(int[][] A) {
        return (A[0][0] * A[1][1]) - (A[0][1] * A[1][0]);
    }

    // Determinant 3x3
    public static int det3x3(int[][] A) {
        return A[0][0] * (A[1][1] * A[2][2] - A[1][2] * A[2][1])
                - A[0][1] * (A[1][0] * A[2][2] - A[1][2] * A[2][0])
                + A[0][2] * (A[1][0] * A[2][1] - A[1][1] * A[2][0]);
    }

    // Check symmetric
    public static boolean isSymmetric(int[][] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != A[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== MATRIX TOOLKIT =====");
            System.out.println("1. Addition");
            System.out.println("2. Multiplication");
            System.out.println("3. Transpose");
            System.out.println("4. Determinant");
            System.out.println("5. Check Symmetric");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("Enter rows and columns: ");
                    int r = sc.nextInt();
                    int c = sc.nextInt();

                    System.out.println("Enter Matrix A:");
                    int[][] A = inputMatrix(sc, r, c);
                    System.out.println("Enter Matrix B:");
                    int[][] B = inputMatrix(sc, r, c);

                    System.out.println("Result:");
                    display(add(A, B));
                    break;
                }
                case 2: {
                    System.out.print("Enter rows and columns of A: ");
                    int r1 = sc.nextInt();
                    int c1 = sc.nextInt();
                    System.out.println("Enter Matrix A:");
                    int[][] A = inputMatrix(sc, r1, c1);

                    System.out.print("Enter rows and columns of B: ");
                    int r2 = sc.nextInt();
                    int c2 = sc.nextInt();
                    System.out.println("Enter Matrix B:");
                    int[][] B = inputMatrix(sc, r2, c2);

                    System.out.println("Result:");
                    display(multiply(A, B));
                    break;
                }
                case 3: {
                    System.out.print("Enter rows and columns: ");
                    int r = sc.nextInt();
                    int c = sc.nextInt();

                    System.out.println("Enter Matrix:");
                    int[][] A = inputMatrix(sc, r, c);

                    System.out.println("Transpose:");
                    display(transpose(A));
                    break;
                }
                case 4: {
                    System.out.print("Enter size (2 or 3): ");
                    int n = sc.nextInt();

                    int[][] A = inputMatrix(sc, n, n);

                    if (n == 2)
                        System.out.println("Determinant: " + det2x2(A));
                    else if (n == 3)
                        System.out.println("Determinant: " + det3x3(A));
                    else
                        System.out.println("Only 2x2 or 3x3 supported");
                    break;
                }
                case 5: {
                    System.out.print("Enter size (n x n): ");
                    int n = sc.nextInt();

                    int[][] A = inputMatrix(sc, n, n);

                    System.out.println("Is Symmetric: " + isSymmetric(A));
                    break;
                }
                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}

