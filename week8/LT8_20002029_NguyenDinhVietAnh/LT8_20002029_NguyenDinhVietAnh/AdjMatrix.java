package LT8_20002029_NguyenDinhVietAnh;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

@SuppressWarnings({ "unchecked", "deprecation" })
public class AdjMatrix {

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

	public List<String> getAdjList() {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			String temp = v[i];
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 1) {
					temp = temp + "->" + v[j];
				}
			}
			result.add(temp);
		}
		return result;
	}

	public void printMatrix() {
		for (int i = 0; i < this.matrix.length; i++) {
			for (int j = 0; j < this.matrix[0].length; j++) {
				System.out.print(this.matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void printV() {
		for (String item : this.v) {
			System.out.print(item + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		AdjMatrix matrix = new AdjMatrix();
		String fileName = AdjMatrix.class.getResource("data.txt").getPath();
		matrix.loadGraphFromFile(fileName);
		matrix.printMatrix();
		matrix.printV();

		List<String> result = matrix.getAdjList();
		System.out.println(result.toString());
	}
}
