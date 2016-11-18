 
/**
 * This class represents a Date object
 */
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
     * creates a new Date object if the date is valid, otherwise creates the date 1/1/2000
     * @param day the day in the month(1-31)
     * @param month the month in the year(1-12
     * @param year the year (4 digits)
    */
    public Date(int day, int month, int year)
    {
        if (year >= 10000 || year < 1000 || day < 0 || day > 31 || month < 1 || month > 12)
        {
            this._day = 1;
            this._month = 1;
            this._year = 2000;
        }
        else if (month == 2 && day > 28 && (year%4!=0 || year%100==0))
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
     * Ssets the day (only if date remains valid)
     * @param dayToSet the day value to be set
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
     * set the month (only if date remains valid)
     * @param monthToSet the month value to be set
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
     * sets the year (only if date remains valid)
     * @param yearToSet the year value to be set
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
     * check if 2 dates are the same
     * @param other The Date to compare
     * @return true if the Dates are equals, otherwise, returns false
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
        return (this    ._year < other._year);
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
        if (month < 3)
        {
            year--;
            month += 12;
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
        if (this._month == 1 || this._month == 2)
        {
            year--;
            m += 12;
        }
        int y = year % 100;
        int c = year / 100;
        
        return ((this._day + (26 * (m+1))/10 + y + y/4 + c/4 - 2*c) % 7);
    }
    
    /**
     * returns a String that represents this date
     * @return String that represents this date in the following format: day/month/year for example: 2/3/1998
     */
    public String toString()
    {
        return this._day + "/" + this._month + "/" + this._year;
    }

}











