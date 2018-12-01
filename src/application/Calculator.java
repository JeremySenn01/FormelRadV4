package application;

/**
 * Berechnet das Formelrad
 * 
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
	private double leistung;
	private double spannung;
	private double strom;
	private double widerstand;

	public Calculator(double leistung, double spannung, double strom, double widerstand) {
		super();
		this.leistung = leistung;
		this.spannung = spannung;
		this.strom = strom;
		this.widerstand = widerstand;
	}

	public double getLeistung() {
		return leistung;
	}

	public double getSpannung() {
		return spannung;
	}

	public double getStrom() {
		return strom;
	}

	public double getWiderstand() {
		return widerstand;
	}

	@Override
	public String toString() {
		return "Calculator [leistung=" + leistung + ", spannung=" + spannung + ", strom=" + strom + ", widerstand="
				+ widerstand + "]";
	}

	public void calculate() {
		if (leistung == 0.0 && spannung == 0.0 && strom != 0.0 && widerstand != 0.0) {

			leistung = Math.round(calculatePwithRandI(widerstand, strom) * 100.0) / 100.0;

			spannung = Math.round(calculateUwithRandI(widerstand, strom) * 100.0) / 100.0;

		}

		if (leistung == 0.0 && spannung != 0.0 && strom == 0.0 && widerstand != 0.0) {

			leistung = Math.round(calculatePwithUandR(spannung, widerstand) * 100.0) / 100.0;

			strom = Math.round(getIwithUandR(spannung, widerstand) * 100.0) / 100.0;

		}

		if (leistung != 0.0 && spannung == 0.0 && strom == 0.0 && widerstand != 0.0) {

			spannung = Math.round(calculateUwithPandR(leistung, widerstand) * 100.0) / 100.0;

			strom = Math.round(getIwithPandR(leistung, widerstand) * 100.0) / 100.0;

		}

		if (leistung == 0.0 && spannung != 0.0 && strom != 0.0 && widerstand == 0.0) {

			leistung = Math.round(calculatePwithUandI(spannung, strom) * 100.0) / 100.0;

			widerstand = Math.round(getRwithPandI(spannung, strom) * 100.0) / 100.0;

		}
	}

	public double calculateUwithRandI(double r, double i) {
		return r * i;
	}

	public double calculateUwithPandI(double p, double i) {
		if (i == 0) {
			throw new IllegalArgumentException();
		}
		return p / i;
	}

	public double calculateUwithPandR(double p, double r) {
		if (p * r < 0) {
			throw new IllegalArgumentException();
		}
		return Math.sqrt(p * r);
	}

	public double calculatePwithUandR(double u, double r) {
		if (r == 0) {
			throw new IllegalArgumentException();
		}
		return (u * u) / r;
	}

	public double calculatePwithRandI(double r, double i) {
		return r * (i * i);

	}

	public double getRwithPandI(double leistung, double strom) {
		if (strom == 0) {
			throw new IllegalArgumentException();
		}
		return leistung / (strom * strom);
	}

	public double getRwithUandP(double spannung, double leistung) {
		if (leistung == 0.0) {
			throw new IllegalArgumentException();
		}
		return (spannung * spannung) / leistung;

	}

	public double getRwithUandI(double spannung, double strom) {
		if (strom == 0.0) {
			throw new IllegalArgumentException();
		}

		return spannung / strom;

	}

	public double getIwithUandR(double spannung, double wiederstand) {
		if (wiederstand == 0) {
			throw new IllegalArgumentException();
		}

		return spannung / wiederstand;

	}

	public double getIwithPandU(double leistung, double spannung) {
		if (spannung == 0) {
			throw new IllegalArgumentException();
		}
		return leistung / spannung;
	}

	public double getIwithPandR(double leistung, double wiederstand) {
		if (wiederstand == 0) {
			throw new IllegalArgumentException();
		}

		return Math.sqrt(leistung / wiederstand);
	}

	public double calculatePwithUandI(double u, double i) {
		return u * i;
	}
}
