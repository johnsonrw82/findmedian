import java.util.Arrays;

/**
 * Created by johnsonrw82 on 3/19/15.
 */
public class FindMedian {

    /**
     * Find the median value of two sorted arrays A, B
     * @param A integer array that will be searched for the median
     * @param B integer array that will be used as reference for median
     * @return the median value
     */
    public static double findMedian(int[] A, int[] B) {
        int k = ( (A.length + B.length) % 2 == 0 ) ? (A.length + B.length) / 2 - 1: (A.length + B.length -1 ) / 2;
        return findMedian(A, B, k, 0, A.length, 0, B.length);
    }

    // helper function
    private static double findMedian(int[] A, int[] B, int k, int startA, int endA, int startB, int endB) {
        // compute starting index - default to halfway between start/end
        int i = startA + (endA - startA)/2;
        // index into reference array
        int j = k - i - 1;

        // if the indices are within range, and A[i] is exactly greater than i elements and j elements, return the median
        if ( j < endB - 1 && j >= startB && A[i] > B[j] && A[i] < B[j+1] ) {
            return (double) A[i];
        }
        // no median found in A, try B
        if ( endA - startA <= 1 || j >= endB || j < startB) {
            return findMedian(B, A);
        }
        // look to the right
        if ( A[i] < B[j] ) {
            return findMedian(A, B, k, i + 1, endA, startB, endB);
        }
        // look to the left
        else {
            return findMedian(A, B, k, startA, i, startB, endB);
        }
    }

}
