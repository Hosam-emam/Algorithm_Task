public class FindDominator {
  public static int findDominatorIndex(int[] A) {
    int candidate = -1;
    int count = 0;

    // Find the potential dominator candidate
    for (int num : A) {
      if (count == 0) {
        candidate = num;
      }
      count += (num == candidate) ? 1 : -1;
    }

    // Check for valid candidate and return -1 if none
    if (count <= 0) {
      return -1;
    }

    // Verify dominance by counting occurrences of candidate
    count = 0;
    for (int num : A) {
      if (num == candidate) {
        count++;
      }
    }

    // Return index of dominator if count is more than half the array length
    return count > A.length / 2 ? indexOf(A, candidate) : -1;
  }

  // Helper function to find the first index of a value in the array
  private static int indexOf(int[] A, int value) {
    for (int i = 0; i < A.length; i++) {
      if (A[i] == value) {
        System.out.println(i);
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] A = { 4, 3, 3, 2, 3, -1, 3, 3 };
    findDominatorIndex(A);
  }
}
