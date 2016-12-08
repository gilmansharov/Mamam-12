/**
 * @author Gil Mansharov
 * @ID 313260192
 */


/**
 * This class represents a Date object
 */
public class Date
{
	/**
	 * month Value as Constant integer
	 */
	private final int JANUARY = 1, FEBRUARY = 2, MARCH = 3, APRIL = 4, JUNE = 6,
			SEPTEMBER = 9, NOVEMBER = 11, DECEMBER = 12;
	//private final int MAY = 5, JULY = 7, AUGUST = 8, OCTOBER = 10		// these months aren't in use and that's the reason they were commented out 
	
	/**
	 * Limitations for the year variable
	 */
	private final int MAX_YEARS = 10000, MIN_YEARS = 1000;
	
	/**
	 * Default Date parameters
	 */
	private final int DEFAULT_YEAR = 2000, DEFAULT_MONTH = JANUARY, DEFAULT_DAY = 1;
		
	/**
	 * Different cases of months
	 */
	private final int LEAP_FEB = 29, NON_LEAP_FEB = 28, MONTH_WITH_30_DAYS = 30, MAX_DAYS_IN_MONTH = 31, MIN_DAYS_IN_MONTH = 1;
	
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
     * creates a new Date object if the date is valid, otherwise creates the date 1/1/2000
     * @param day the day in the month(1-31)
     * @param month the month in the year(1-12
     * @param year the year (4 digits)
    */
    public Date(int day, int month, int year)
    {
    	if (isValid(day, month, year))
    	{
    		this._day = day;
    		this._month = month;
    		this._year = year;
    	}
    	else
    	{
    		this._day = DEFAULT_DAY;
    		this._month = DEFAULT_MONTH;
    		this._year = DEFAULT_YEAR;
    	}
    }

    /**
     * copy constructor
     * @param other the date to be copied
     */
    public Date(Date other)
    {
        this._day = other._day;
        this._month = other._month;
        this._year = other._year;
    }
    
    /**
     * gets the Day
     * @return the day
     */
    public int getDay()
    {
        return this._day;
    }
    
    /**
     * gets the month
     * @return the month
     */
    public int getMonth()
    {
        return this._month;
    }
    
    /**
     * gets the year
     * @return the year
     */
    public int getYear()
    {
        return this._year;
    }
    
    /**
     * Sets the day (only if date remains valid)
     * @param dayToSet the day value to be set
     */
    public void setDay(int dayToSet)
    {
    	if (isValid(dayToSet, this._month, this._year))
    		this._day = dayToSet;
    }
    
    /**
     * set the month (only if date remains valid)
     * @param monthToSet the month value to be set
     */
    public void setMonth(int monthToSet)
    {
        if (isValid(this._day, monthToSet, this._year))
        	this._month = monthToSet;
    }
    
    /**
     * sets the year (only if date remains valid)
     * @param yearToSet the year value to be set
     */
    public void setYear(int yearToSet)
    {
        if (isValid(this._day, this._month, yearToSet))
        	this._year = yearToSet;
    }
    
    /**
     * check if 2 dates are the same
     * @param other The Date to compare
     * @return true if the Dates are the same, otherwise, returns false
     */
    public boolean equals(Date other) 
    {
        return (this._day == other._day && this._month == other._month && this._year == other._year);
    }
    
    /**
     * check if this date is before other date 
     * @param other The Date to compare
     * @return true if this date is before other date

     */
    public boolean before(Date other)
    {
        if (this._year == other._year)
        {
            if (this._month == other._month)
            {
                return this._day < other._day;
            }
            return (this._month < other._month);
        }
        return (this._year < other._year);
    }
    
    /**
     * check if this date is after other date
     * @param other The Date to compare
     * @return true if this date is after other date
     */
    public boolean after(Date other)
    {
        return (other.before(this));
    }
    
    /**
     * calculates the difference in days between two dates
     * @param other the date to calculate the difference between
     * @return the number of days between the dates
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
        if (month < MARCH)
        {
            year--;
            month += DECEMBER;
        }
        return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
    }
    
    /**
     * calculate the day of the week that this date occurs on 0-Saturday 1-Sunday 2-Monday etc.
     * @return the day of the week that this date occurs on
     */
    public int dayInWeek()
    {
        int year = this._year;
        int m = this._month;
        if (this._month == JANUARY || this._month == FEBRUARY)
        {
            year--;
            m += DECEMBER;
        }
        int y = year % 100;
        int c = year / 100;
        
        return ((this._day + (26 * (m+1))/10 + y + y/4 + c/4 - 2*c) % 7); //Formula for calculating day in week
    }
    
    /**
     * a method that checks if the year is leap
     * @param yearToCheck	The year to check if is leap
     * @return true if the year is leap, otherwise, returns false
     */
    
    private boolean isLeap(int yearToCheck)
    {
    	return (yearToCheck % 4 == 0 && yearToCheck % 100 != 0) || (yearToCheck % 400 == 0);
    }
    
    /**
     * a method that checks if a date is valid
     * @param day the day in the date
     * @param month the month in the date
     * @param year the year in the date
     * @return True if the date is valid, otherwise return false
     */
    private boolean isValid(int day, int month, int year)
    {
        if (year >= MAX_YEARS || year < MIN_YEARS || day < MIN_DAYS_IN_MONTH || day > MAX_DAYS_IN_MONTH || month < JANUARY || month > DECEMBER)
        	return false;
        else if (month == FEBRUARY && day > NON_LEAP_FEB && !isLeap(year))
        	return false;
        else if (isLeap(year) && month == FEBRUARY && day > LEAP_FEB)
        	return false;
        else if ((month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER) && day > MONTH_WITH_30_DAYS)
        	return false;
        else
        	return true;
    }
    
    
    /**
     * returns a String that represents this date
     * @return String that represents this date in the following format: day/month/year for example: 2/3/1998
     */
    public String toString()
    {
        return new String(this._day + "/" + this._month + "/" + this._year);
    }

}











