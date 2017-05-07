package edu.ycp.cs320.jhofmann1.model;

public class Numbers {
	

	private double first, second, third, result;

	public Numbers()
	{
		
	}
	public Numbers(double one, double two, double result)
	{
		this.first = one;
		this.second = two;
		this.result = result;
	}
	public Numbers(double one, double two, double three, double result)
	{
		this.first = one;
		this.second = two;
		this.third = three;
		this.result = result;
	}
	/**
	 * @return the first
	 */
	public double getFirst() {
		return first;
	}
	/**
	 * @return the second
	 */
	public double getSecond() {
		return second;
	}
	/**
	 * @return the third
	 */
	public double getThird() {
		return third;
	}
	/**
	 * @return the result
	 */
	public double getResult() {
		return result;
	}
	/**
	 * @param first the first to set
	 */
	public void setFirst(double first) {
		this.first = first;
	}
	/**
	 * @param second the second to set
	 */
	public void setSecond(double second) {
		this.second = second;
	}
	/**
	 * @param third the third to set
	 */
	public void setThird(double third) {
		this.third = third;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(double result) {
		this.result = result;
	}
}
