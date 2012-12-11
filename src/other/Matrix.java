package other;

import java.text.DecimalFormat;
import java.util.*;

public class Matrix {

	/**
	 * 使用增加单位矩阵初等变换法求逆矩阵
	 * 
	 * @param args
	 */

	List<ArrayList<Double>> data = null;
	List<ArrayList<Double>> unit = null;
	int size = 0;

	public Matrix(List<ArrayList<Double>> data) {
		this.data = data;
		this.size = data.size();
		if (!isMatrix(data))
			return;
	}

	public List<ArrayList<Double>> minus(List<ArrayList<Double>> toMinus) {
		if (!isMatrix(toMinus))
			return null;
		List<ArrayList<Double>> result = new ArrayList<ArrayList<Double>>();
		for (int i = 0; i < size; i++) {
			ArrayList<Double> line = new ArrayList<Double>();
			for (int j = 0; j < size; j++) {
				line.add(data.get(i).get(j) - toMinus.get(i).get(j));
			}
			result.add(line);
		}
		return result;
	}

	public List<ArrayList<Double>> mul(List<ArrayList<Double>> toMul) {
		if (!isMatrix(toMul))
			return null;
		List<ArrayList<Double>> result = new ArrayList<ArrayList<Double>>();
		for (int i = 0; i < size; i++) {
			ArrayList<Double> line = new ArrayList<Double>();
			for (int j = 0; j < size; j++) {
				double r = 0;
				for (int k = 0; k < size; k++) {
					r += data.get(i).get(k) * toMul.get(k).get(j);
				}
				line.add(r);
			}
			result.add(line);
		}
		return result;
	}

	public List<ArrayList<Double>> add(List<ArrayList<Double>> toAdd) {

		if (!isMatrix(toAdd))
			return null;
		List<ArrayList<Double>> result = new ArrayList<ArrayList<Double>>();
		for (int i = 0; i < size; i++) {
			ArrayList<Double> line = new ArrayList<Double>();
			for (int j = 0; j < size; j++) {
				line.add(data.get(i).get(j) + toAdd.get(i).get(j));
			}
			result.add(line);
		}
		return result;
	}

	public List<ArrayList<Double>> getData() {
		return data;
	}

	public List<ArrayList<Double>> inverse() {
		unit = new ArrayList<ArrayList<Double>>();
		initUnit();
		List<ArrayList<Double>> copyData = new ArrayList<ArrayList<Double>>();
		for (int i = 0; i < size; i++) {
			ArrayList<Double> line = new ArrayList<Double>();
			for (int j = 0; j < size; j++) {
				line.add(data.get(i).get(j));
			}
			copyData.add(line);
		}
		doMatrixChanges(copyData);
		return unit;
	}

	private void doMatrixChanges(List<ArrayList<Double>> data) {
		//
		for (int i = 0; i < size; i++) {
			double times = data.get(i).get(i);
			if (!isEqual(times, new Double(1.0))) {
				for (int j = 0; j < size; j++) {
					data.get(i).set(j, data.get(i).get(j) / times);
					unit.get(i).set(j, unit.get(i).get(j) / times);
				}
			}

			// showData();

			for (int ii = i + 1; ii < size; ii++) {
				double tempTimes = data.get(ii).get(i);
				// System.out.println("tempTimes" + tempTimes);
				for (int j = 0; j < size; j++) {
					data.get(ii).set(
							j,
							data.get(ii).get(j) - data.get(i).get(j)
									* tempTimes);
					unit.get(ii).set(
							j,
							unit.get(ii).get(j) - unit.get(i).get(j)
									* tempTimes);
				}
			}
			// showData();

		}
		// showData(unit);

		for (int j = size - 1; j >= 1; j--) {

			for (int k = j - 1; k >= 0; k--) {
				double tempTimes = data.get(k).get(j);
				data.get(k).set(j, 0.0);
				for (int t = 0; t < size; t++) {
					unit.get(k)
							.set(t,
									unit.get(k).get(t) - unit.get(j).get(t)
											* tempTimes);
				}
			}
		}

		for (int k = size - 2; k >= 0; k--) {

			for (int j = k; j >= 0; j--) {
				double temp = data.get(j).get(k + 1);
				// System.out.println(temp);
			}
		}

	}

	private boolean isEqual(Double x, Double y) {
		if (Math.abs(x - y) < 0.0001)
			return true;
		return false;
	}

	private void initUnit() {
		for (int i = 0; i < size; i++) {
			ArrayList<Double> temp = new ArrayList<Double>();
			for (int j = 0; j < size; j++) {
				temp.add(0.0);
			}
			temp.set(i, 1.0);
			unit.add(temp);
		}
	}

	private boolean isMatrix(List<ArrayList<Double>> data) {
		if (size == 0) {
			System.out.println("The size of Matrix is zero!");
			return false;
		} else if (data.get(0).size() == size)
			return true;
		return false;
	}

	public void showData() {
		DecimalFormat df = new DecimalFormat("#.###");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(String.format("%01.3f\t", data.get(i).get(j)));
			}
			System.out.println();
		}
		System.out.println();
	}

	public void showData(List<ArrayList<Double>> tobeShow) {
		DecimalFormat df = new DecimalFormat("#.###");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(String.format("%01.3f\t",
						tobeShow.get(i).get(j)));
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}

	public static List<ArrayList<Double>> getRandomData(int size) {
		ArrayList<ArrayList<Double>> data = new ArrayList<ArrayList<Double>>();
		// Random rand = new Random(Calendar.getInstance().getTimeInMillis());
		Random rand = new Random(47);
		DecimalFormat df = new DecimalFormat("#.###");
		for (int i = 0; i < size; i++) {
			ArrayList<Double> temp = new ArrayList<Double>();
			for (int j = 0; j < size; j++) {
				temp.add(Double.parseDouble(df.format(rand.nextDouble() * 10)));
			}
			data.add(temp);
		}
		return data;
	}

	public static void main(String[] args) {
		ArrayList<ArrayList<Double>> data = new ArrayList<ArrayList<Double>>();
		// Random rand = new Random(Calendar.getInstance().getTimeInMillis());
		ArrayList<Double> a1 = new ArrayList<Double>();
		a1.add((double) 1);
		a1.add((double) 2);
		ArrayList<Double> a2 = new ArrayList<Double>();
		a2.add((double) 3);
		a2.add((double) 4);
		data.add(a1);
		data.add(a2);

		ArrayList<ArrayList<Double>> data1 = new ArrayList<ArrayList<Double>>();
		ArrayList<Double> b1 = new ArrayList<Double>();
		b1.add((double) 1);
		b1.add((double) 2);
		b1.add((double) 3);
		ArrayList<Double> b2 = new ArrayList<Double>();
		b2.add((double) 2);
		b2.add((double) 2);
		b2.add((double) 1);
		ArrayList<Double> b3 = new ArrayList<Double>();
		b3.add((double) 3);
		b3.add((double) 4);
		b3.add((double) 3);
		data1.add(b1);
		data1.add(b2);
		data1.add(b3);

		// Matrix m = new Matrix(getRandomData(10));
		Matrix m = new Matrix(data1);
		m.showData(m.getData());
		m.showData(m.inverse());
		m.showData(m.mul(data1));
	}
}
