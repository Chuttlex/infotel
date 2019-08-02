package com.infotel.support;

/**
 * @author thbl
 *
 * @param <A>
 * @param <B>
 */
public class Paire<A,B> {
	
	private A first;
	private B second;
	
	/**
	 * @param a
	 * @param b
	 */
	public Paire(A a,B b) {
		this.first=a;this.second=b;
	}

	/**
	 * @return A ,le premier élément
	 */
	public A getFirst() {
		return first;
	}

	/**
	 * @param first
	 */
	public void setFirst(A first) {
		this.first = first;
	}

	/**
	 * @return B ,le deuxième élement
	 */
	public B getSecond() {
		return second;
	}

	/**
	 * @param second
	 */
	public void setSecond(B second) {
		this.second = second;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "("+first+","+second+")";
	}

}
