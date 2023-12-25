package LT8_20002029_NguyenDinhVietAnh;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;

@SuppressWarnings({ "unchecked", "deprecation" })
public class GraphDegree {

	private int[][] matrix;
	private String[] v;
	private int n;

	public void loadGraphFromFile(String fileName) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			n = Integer.parseInt(br.readLine());
			v = new String[n];
			for (int i = 0; i < n; i++) {
				v[i] = br.readLine();
			}

			matrix = new int[n][n];
			for (int i = 0; i < n; i++) {
				String[] values = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					matrix[i][j] = Integer.parseInt(values[j]);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int[] getDegree() {
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			int deg = 0;
			for (int j = 0; j < n; j++) {
				deg += matrix[i][j];
			}
			result[i] = deg;
		}

		return result;
	}

	public static void main(String[] args) {
		GraphDegree matrix = new GraphDegree();
		String fileName = AdjMatrix.class.getResource("data.txt").getPath();
		matrix.loadGraphFromFile(fileName);
		int[] result = matrix.getDegree();

		for (int i = 0; i < result.length; i++) {
			if (i == 0) {
				System.out.print("[" + result[i] + ", ");
			} else if (i == result.length - 1) {
				System.out.print(result[i] + "]");
			} else {
				System.out.print(result[i] + ", ");
			}
		}
		System.out.println();
	}
}
