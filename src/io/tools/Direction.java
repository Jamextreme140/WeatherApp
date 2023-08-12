package io.tools;

enum Headings
	{
		NORTH,
		NORTHEAST,
		EAST,
		SOUTHEAST,
		SOUTH,
		SOUTHWEST,
		WEST,
		NORTHWEST
	}

public class Direction {
	private int degrees;
	private Headings dir;
	
	public Direction(int degrees) {
		this.degrees = degrees;
	}

	/**
	 * Returns the direction in a range of degrees
	 * @return Direction (NORTH, EAST, SOUTH, WEST, ...)
	 */
	public String getDir() {
		if(Range(degrees, 338, 359) || Range(degrees, 0, 22)) dir = Headings.NORTH;
		if(Range(degrees, 23, 67)) dir = Headings.NORTHEAST;
		if(Range(degrees, 68, 112)) dir = Headings.EAST;
		if(Range(degrees, 113, 157)) dir = Headings.SOUTHEAST;
		if(Range(degrees, 158, 202)) dir = Headings.SOUTH;
		if(Range(degrees, 203, 247)) dir = Headings.SOUTHWEST;
		if(Range(degrees, 248, 292)) dir = Headings.WEST;
		if(Range(degrees, 293, 337)) dir = Headings.NORTHWEST;
		return dir.toString();
	}
	
	private boolean Range(int var, int a, int b)
	{
		return (var >= a && var <= b) ? true : false;
	}
}
