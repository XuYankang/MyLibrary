package other;

import java.lang.*;
import java.io.*;
import java.math.*;
import java.util.*;

/**
 * 求逆矩阵
 * 
 * 
 * @version 1.0 21 July 2005
 * @author farewell
 */

public class cMatrix {

	public cMatrix() {

		double Vp[][] = new double[10][10];
		int i, j;
		i = j = 3;
		for (int k = 1; k < 10; k++) {
			for (int t = 1; t < 10; t++) {
				Vp[k][t] = 0.0;
			}
		}

		// input the data of the matrix
		Vp[1][1] = 1;
		Vp[1][2] = 2;
		Vp[1][3] = 3;
		Vp[2][1] = 2;
		Vp[2][2] = 2;
		Vp[2][3] = 1;
		Vp[3][1] = 3;
		Vp[3][2] = 4;
		Vp[3][3] = 3;

		System.out.println("Print out the array first.");
		for (int x = 1; x <= i; x++) {
			for (int y = 1; y <= j; y++) {
				System.out.print(Vp[x][y] + "  ");
			}
			System.out.println();
		}
		System.out.println("\nThen Try to change it.Use identity matrix.");
		// add the identity array at the end
		for (int k = 1; k <= i; k++) {
			for (int t = j + 1; t <= j * 2; t++) {
				if ((t - k) == j) {
					Vp[k][t] = 1.0;
				} else {
					Vp[k][t] = 0;
				}
			}
		}
		for (int x = 1; x <= i; x++) {
			for (int y = 1; y <= j * 2; y++) {
				System.out.print(Vp[x][y] + "  ");
			}
			System.out.println();
		}
		// get the change of the array
		for (int k = 1; k <= i; k++) {
			if (Vp[k][k] != 1) {
				double bs = Vp[k][k];
				Vp[k][k] = 1;
				for (int p = k + 1; p <= j * 2; p++) {
					Vp[k][p] /= bs;
					// System.out.println("Vp["+k+","+p+"]="+Vp[k][p]);
				}

			}

			for (int q = 1; q <= i; q++) {
				if (q != k) {
					double bs = Vp[q][k];
					for (int p = 1; p <= j * 2; p++) {
						// System.out.println(bs);
						Vp[q][p] -= bs * Vp[k][p];
						// System.out.println("Vp["+q+","+p+"]="+Vp[q][p]);
					}
				} else {
					continue;
				}
			}
		}
		// print out the result of the change
		System.out.println("\nThe result is:");
		for (int x = 1; x <= i; x++) {
			for (int y = j + 1; y <= j * 2; y++) {
				System.out.print(Vp[x][y] + "  ");
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		cMatrix cm = new cMatrix();
	}

}