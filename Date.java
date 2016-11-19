public class Date
{
	/**
	 * Day of the Date object
	 */
	private int _day;
	/**
	 * Month of the Date object
	 */
	private int _month;
	/**
	 * Year of the Date object
	 */
	private int _year;
	
	/**
	 * Constructor of a Date object
	 * @param day The day of the Date
	 * @param month The month of the Date
	 * @param year The year of the Date
	*/
	public Date(int day, int month, int year)
	{
		if (year < 10000 || year >= 1000 || day < 0 || day > 31 || month < 1 || month > 12)
		{
			this._day = 1;
			this._month = 1;
			this._year = 2000;
		}
		else if (((year%4!=0 || year%100==0) && month==2 && day > 28))
		{
			this._day = 1;
			this._month = 1;
			this._year = 2000;
		}
		else if (((year%4==0 && year%100!=0) || year%400==0) && month==2 && day > 29)
		{
			this._day = 1;
			this._month = 1;
			this._year = 2000;
		}
		else if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30)
		{
			this._day = 1;
			this._month = 1;
			this._year = 2000;
		}
		else
		{
			this._day = day;
			this._month = month;
			this._year = year;
		}
	}

	/**
	 * A constructor that copies a given Date object to this object
	 * @param other A Date to copy from
	 */
	public Date(Date other)
	{
		this._day = other._day;
		this._month = other._month;
		this._year = other._year;
	}
	
	/**
	 * @return The day of the Date
	 */
	public int getDay()
	{
		return this._day;
	}
	
	/**
	 * @return The month of the Date
	 */
	public int getMonth()
	{
		return this._month;
	}
	
	/**
	 * @return The Year of the Date
	 */
	public int getYear()
	{
		return this._year;
	}
	
	/**
	 * Sets a day to the Date object
	 * @param dayToSet The day to set in the Date object
	 */
	public void setDay(int dayToSet)
	{
		if (dayToSet > 0 && dayToSet <= 31)
		{
			if (_month == 2)
			{
				if ((_year % 4 == 0 && _year % 100 != 0) || (_year % 400 == 0))
					this._day = (dayToSet <= 29) ? dayToSet : this._day;
				else
					this._day = (dayToSet <= 28) ? dayToSet : this._day;
			}
		
			else if (_month == 4 || _month == 6 || _month == 9 || _month == 11)
				this._day = (dayToSet <= 30) ? dayToSet : this._day;
		
			else
				this._day = (dayToSet <= 31) ? dayToSet : this._day;
		}
	}
	
	/**
	 * Sets a month to the object
	 * @param monthToSet The month to set in the Date object
	 */
	public void setMonth(int monthToSet)
	{
		if (monthToSet <= 31 && monthToSet > 0)
		{
			if (monthToSet == 2)
			{
				if ((_year % 4 == 0 && _year % 100 != 0) || (_year % 400 == 0))
					this._month = (_day <= 29) ? monthToSet : this._month;
				else
					this._month = (_day <= 28) ? monthToSet : this._month;
			}
		
			else if (monthToSet == 4 || monthToSet == 6 || monthToSet == 9 || monthToSet == 11)
				this._month = (_day <= 30) ? monthToSet : this._month;
		
			else
				this._month = monthToSet;
		}
	}
	
	/**
	 * Sets a year to the Date object
	 * @param yearToSet The year to set in the Date object
	 */
	public void setYear(int yearToSet)
	{
		if (yearToSet >= 1000 && yearToSet < 10000)
		{
			if (_month == 2)
			{
				if ((yearToSet % 4 == 0 && yearToSet % 100 != 0) || (yearToSet % 400 == 0))
					this._year = yearToSet;
				else
					this._year = (_day <= 28) ? yearToSet : this._year;
			}
		
			else
				this._year = yearToSet;
		}
	}
	
	/**
	 * Checks whether a given Date is equal to the Date the method represents
	 * @param other The Date to compare
	 * @return true if the Dates are equals, otherwise, returns false
	 */
	public boolean equals(Date other) 
	{
		return (this._day == other._day && this._month == other._month && this._year == other._year);
	}
	
	/**
	 * Checks whether the Date object the method represents is before a given Date object 
	 * @param other The Date to compare
	 * @return true if the Date object that the method represents is before the given Date object (other), otherwise, returns false
	 */
	public boolean before(Date other)
	{
		if (this._year == other._year)
		{
			if (this._month == other._month)
			{
				return (this._day < other._day);
			}
			return (this._month < other._month);
		}
		return (this._year < other._year);
	}
	
	/**
	 * Checks whether the Date object the method represents is after a given Date object
	 * @param other The Date to compare
	 * @return true if the Date object the method represents is after the given Date object (other), otherwise, returns false
	 */
	public boolean after(Date other)
	{
		return (other.before(this));
	}
	
	/**
	 * Computes the difference between the object the method represents and a given Date object
	 * @param other The Date to compute with
	 * @return The difference between the object the method represents and a given Date object
	 */
	public int difference(Date other)
	{
		return Math.abs(calculateDay(this._day, this._month, this._year) - calculateDay(other._day, other._month, other._year));
	}
	
	/** computes the day number since 0 January 0 CE (Gregorian)
	 * 
	 * @param day The day of the Date
	 * @param month The month of the Date
	 * @param year The year of the Date
	 * @return The days since 0 January 0 CE (Gregorian)
	 */
	private int calculateDay(int day, int month, int year)
	{
		if (month < 3)
		{
			year--;
			month += 12;
		}
		return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
	}
	
	/**
	 * @return A String that represents the description of the Date object
	 */
	public String toString()
	{
		return this._day + " / " + this._month + " / " + this._year;
	}

}