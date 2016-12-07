/*
 * @author: Gil Mansharov
 * @ID: 313260192
 */ 


/**
 * This class represents a Trip object
 */
public class Trip 
{
    /**
     * The name of the trip guide
     */
    private String _name;
    /**
     * Number of the countries visited in the trip (max: 10)
     */
    private int _noOfCountries;
    /**
     * Departure date of the trip, represented by a Date object
     */
    private Date _departureDate;
    /**
     * returning date of the trip, represented by a Date object
     */
    private Date _returningDate;
    /**
     * Number of travelers in the trip (max: 50)
     */
    private int _noOfTravellers;
    /**
     * Price per day trip
     */
    private final int PRICE_PER_DAY = 250;
    /**
     * Extra price per country
     */
    private final int PRICE_PER_COUNTRY = 100;
    
    /**
     * Extra price per weekend
     */
    private final int PRICE_PER_WEEKEND = 100;
    
    /**
     * Travelers and Countries constants assignment
     */
    private final int MIN_TRAVELLERS_NUMBER = 1, MAX_TRAVELLERS_NUMBER = 50, DEFAULT_TRAVELLERS_NUMBER = 10,
    		MIN_COUNTRIES_NUMBER = 1, MAX_COUNTRIES_NUMBER = 10;
    private final int DEFAULT_DAY = 1, DEFAULT_MONTH = 1, DEFAULT_YEAR = 2000;
    
    
    /**
     * creates a new Trip object
     * @param name of the guide of the trip
     * @param depDay the day of the departure date(1-31)
     * @param depMonth the month of the departure date(1-12)
     * @param depYear the year of the departure date (4 digits)
     * @param retDay the day of the return date(1-31)
     * @param retMonth the month of the return date(1-12)
     * @param retYear the year of the return date(4 digits)
     * @param noOfCountries the number of countries to be visited in the trip(1-10)
     * @param noOfTravellers the number of travellers(1-50)
     */
    public Trip(java.lang.String name, int depDay, int depMonth, int depYear,  int retDay, int retMonth, int retYear,int noOfCountries, int noOfTravellers)
    {
        this._name = new String(name);
        this._departureDate = new Date(depDay, depMonth, depYear);
        this._returningDate = new Date(retDay, retMonth, retYear);
        if (this._departureDate.after(this._returningDate))
        {
            this._departureDate = new Date(DEFAULT_DAY, DEFAULT_MONTH, DEFAULT_YEAR);
            this._returningDate = new Date(this._departureDate);
        } 
        this._noOfCountries = (noOfCountries >= MIN_COUNTRIES_NUMBER && noOfCountries <= MAX_COUNTRIES_NUMBER) ? noOfCountries : MIN_COUNTRIES_NUMBER;
        this._noOfTravellers = (noOfTravellers >= MIN_TRAVELLERS_NUMBER && noOfTravellers <= MAX_TRAVELLERS_NUMBER) ? noOfTravellers : DEFAULT_TRAVELLERS_NUMBER;
    }
    
    /**
     * creates a new Trip object
     * @param otherTrip trip to be copied
     */
    public Trip(Trip otherTrip)
    {
        this._name = new String(otherTrip._name);
        this._noOfCountries = otherTrip._noOfCountries;
        this._noOfTravellers = otherTrip._noOfTravellers;
        this._departureDate = new Date(otherTrip._departureDate);
        this._returningDate = new Date(otherTrip._returningDate);
        
    }
    
    /**
     * creates a new Trip object
     * @param name of the guide of the trip
     * @param depDate the departure date
     * @param retDate the return date
     * @param noOfCountries the number of countries to be visited in the trip(1-10)
     * @param noOfTravellers the number of travellers(1-50)
     */
    public Trip(java.lang.String name, Date depDate, Date retDate, int noOfCountries, int noOfTravellers)
    {
        this._name = new String(name);
        this._departureDate = new Date(depDate);
        this._returningDate = new Date(retDate);
        if (this._departureDate.after(this._returningDate))
        {
            this._departureDate = new Date(DEFAULT_DAY, DEFAULT_MONTH, DEFAULT_YEAR);
            this._returningDate = new Date(this._departureDate);
        } 
        this._noOfCountries = (noOfCountries >= MIN_COUNTRIES_NUMBER && noOfCountries <= MAX_COUNTRIES_NUMBER) ? noOfCountries : MIN_COUNTRIES_NUMBER;
        this._noOfTravellers = (noOfTravellers >= MIN_TRAVELLERS_NUMBER && noOfTravellers <= MAX_TRAVELLERS_NUMBER) ? noOfTravellers : DEFAULT_TRAVELLERS_NUMBER;
    }

    /**
     * gets the guide name
     * @return the guide name
     */
    public String getGuideName()
    {
        return this._name;
    }
    
    /**
     * gets the number of countries to be visit in the trip
     * @return the number of countries
     */
    public int getNoOfCountries()
    {
        return this._noOfCountries;
    }
    
    /**
     * gets the number of travellers in the trip
     * @return the number of travellers
     */
    public int getNoOfTravellers()
    {
        return this._noOfTravellers;
    }
    
    /**
     * gets the trip departure date
     * @return the departure date
     */
    public Date getDepartureDate()
    {
        return new Date(this._departureDate);
    }
    
    /**
     * gets the trip return date
     * @return the return date
     */
    public Date getReturningDate()
    {
        return new Date(this._returningDate);
    }

    /**
     * sets the guide name
     * @param otherName the value to be set
     */
    public void setGuideName(String otherName)
    {
        this._name = new String(otherName);
    }

    /**
     * sets the number of countries (only if valid)
     * @param otherNumberOfCountries the value to be set
     */
    public void setNoOfCountries(int otherNumberOfCountries )
    {
        this._noOfCountries = (otherNumberOfCountries >= MIN_COUNTRIES_NUMBER && otherNumberOfCountries  <= MAX_COUNTRIES_NUMBER) ? otherNumberOfCountries : this._noOfCountries;
    }
    
    /**
     * sets the number of travellers (only if valid)
     * @param otherNumberOfTravellers  the value to be set
     */
    public void setNoOfTravellers(int otherNumberOfTravellers)
    {
        this._noOfTravellers = (otherNumberOfTravellers > MIN_TRAVELLERS_NUMBER && otherNumberOfTravellers  <= MAX_TRAVELLERS_NUMBER) ? otherNumberOfTravellers : this._noOfTravellers;
    }
    
    /**
     * sets the trip departure day the date will change only if the new departure date is before the return date or equal to it.
     * @param newDepDate the value to be set
     */
    public void setDepartureDate(Date newDepDate)
    {
        this._departureDate = (!newDepDate.after(this._returningDate)) ? new Date(newDepDate) : this._departureDate;
    }
    
    /**
     * sets the trip return date the date will change only if the new return date is after the departure date or equal to it.
     * @param newRetDay the value to be set
     */
    public void setReturningDate(Date newRetDay)
    {
        this._returningDate = (!newRetDay.before(this._departureDate)) ? new Date(newRetDay) : this._returningDate;
    }

    
    /**
     * check if 2 trips are the same
     * @param other the trip to compare this trip to
     * @return true if the trips are the same
     */
    public boolean equals(Trip other)
    {
        return (this._name.equals(other._name) && this._departureDate.equals(other._departureDate) &&
                this._returningDate.equals(other._returningDate) && this._noOfCountries == other._noOfCountries &&
                this._noOfTravellers == other._noOfTravellers);
    }

    /**
     * check if two trips have the same departure date
     * @param otherTrip the trip to compare to
     * @return true if the two trips have the same departure date otherwise false
     */
    public boolean sameDepartureDate(Trip otherTrip)
    {
        return this._departureDate.equals(otherTrip._departureDate);
    }
    
    /**
     * check if two trips have the same return date
     * @param otherTrip the trip to compare this trip to
     * @return true if the two trips have the same return date otherwise false
     */
    public boolean sameReturningDate(Trip otherTrip)
    {
        return this._returningDate.equals(otherTrip._returningDate);
    }
    
    /**
     * check if two trips overlap with their dates
     * @param otherTrip the trip to check if overlaps with this trip
     * @return true if the two trip have overlapping dates otherwise false
     */
    public boolean overlap(Trip otherTrip)
    {
    	if (!this._departureDate.after(otherTrip._returningDate) && // // the current trip departure date is between
    			!this._departureDate.before(otherTrip._departureDate)) // the other trip departure and returning dates
    		return true;
    	
    	else if (!otherTrip._returningDate.before(this._departureDate) && // the other trip returning date is between
    			!otherTrip._returningDate.after(this._returningDate)) // the current trip returning and returning dates
    		return true;
    	else
    		return false;
    }

    /**
     * calculates the number of days of the trip
     * @return the number of days of the trip
     */
    public int tripDuration()
    {
        return (this._departureDate.equals(this._returningDate)) ? 1 : this._returningDate.difference(this._departureDate) + 1;
    }
    
    /**
     * check if trip is loaded
     * @return true if the number of countries to visit is greater than the trip duration - else return false
     */
    public boolean isLoaded()
    {
        return this._noOfCountries > this.tripDuration();
    }
    
    /**
     * calculates the minimum number of buses needed for the trip
     * @return the number of buses needed for the trip
     */
    public int howManyCars()
    {
        return (this._noOfTravellers % 10 == 0) ? this._noOfTravellers/10 : this._noOfTravellers/10 + 1;
    }
    
    /**
     * calculates total price of the trip according to days of the trip and number of countries visited (20% extra price at the summer; July and August)
     * @return the total price of the trip
     */
    public int calculatePrice()
    {
    	final int JULY = 7, AUGUST = 8;
    	final double SUMMER_EXTRA_PRICE = 1.2;
    	
        return (this._departureDate.getMonth() == JULY || this._departureDate.getMonth() == AUGUST) ?
            (int)(SUMMER_EXTRA_PRICE * (this.tripDuration() * this.PRICE_PER_DAY + this._noOfCountries * this.PRICE_PER_COUNTRY + this.howManyWeekends() * this.PRICE_PER_WEEKEND)) :
                (this.tripDuration() * this.PRICE_PER_DAY) + (this._noOfCountries * this.PRICE_PER_COUNTRY + this.howManyWeekends() * this.PRICE_PER_WEEKEND);
    }

    /**
     * calculates how many weekends occur during the trip
     * @return the number of weekends occurring during the trip
     */
    public int howManyWeekends()
    {
        int dayOfDep = _departureDate.dayInWeek();
        int diff = _returningDate.difference(_departureDate);
        int count = diff / 7;
        if ((diff % 7) + dayOfDep > 6 || dayOfDep == 0)
            count++;
        return count;     
    }
    
    /**
     * calculates the date of first weekend of the trip
     * @return the date of the first weekend of the trip or null if there is no weekend on the trip
     */
    public Date firstWeekend()
    {
        int depDay = this._departureDate.dayInWeek();
        if (depDay == 0)
            return new Date(_departureDate);
        else if (tripDuration() + depDay > 7)
        {
            depDay = 7 - depDay;
            return new Date(addDays(this._departureDate, depDay));
        }
        else
            return null;
    }
    
    /**
     * this method adds days to a date object (1-28 days), by the dates rules (leap year, months with different days etc.)
     * @param date the date to add days to
     * @param num the number of days we want to add to our date object
     * @return a date object with the days added to it
     */
    private Date addDays(Date date, int num)
    {
    	final int JANUARY = 1, FEBRUARY = 2, APRIL = 4, JUNE = 6,
    			SEPTEMBER = 9, NOVEMBER = 11, DECEMBER = 12;
    	final int LEAP_FEB = 29, NON_LEAP_FEB = 28, MONTH_WITH_30_DAYS = 30, MAX_DAYS_IN_MONTH = 31, MIN_DAYS_IN_MONTH = 1;
    	int day = date.getDay() + num;
		int month = date.getMonth();
		int year = date.getYear();
    	if (num >= MIN_DAYS_IN_MONTH && num <= NON_LEAP_FEB) //if the user didn't stood our contract (num isn't between 1-28), there will be no change in the days
    	{
    		if (day > NON_LEAP_FEB)
    		{
    			if (month == FEBRUARY) //February is separated to 2 cases: leap year and not a leap year
    			{
    				if (this.isLeap(year)) //leap year
    				{
    					if (day > LEAP_FEB)
    					{
	    					month++;
	    					day -= LEAP_FEB;
    					}
    				}
    				
    				else //not a leap year
    				{
    					if (day > NON_LEAP_FEB)
    					{
    						month++;
    						day -= NON_LEAP_FEB;
    					}
    				}
    			}
    		}
    			
    		else if (month == APRIL || month == JUNE || month == SEPTEMBER || month == NOVEMBER) //The months with only 30 days
    		{
    			if (day > MONTH_WITH_30_DAYS)
    			{
    				month++;
    				day -= MONTH_WITH_30_DAYS;
    			}
    		}
    		
   			else //rest of the months
   			{
   				if (day > MAX_DAYS_IN_MONTH)
   				{
   					month++;
    				day -= MAX_DAYS_IN_MONTH;
    			}
    			if (month > DECEMBER) //if December became January
    			{
   					year++;
   					month = JANUARY;
   				}
   			}
    		return new Date(day, month, year);
    	}		
    	return new Date(date);
   	}
    
    /**
     * a method that check if the year is leaped
     * @param yearToCheck the year to check if leaped
     * @return true if the year is leaped, otherwise returns false
     */
    private boolean isLeap(int yearToCheck)
    {
    	return (yearToCheck % 4 == 0 && yearToCheck % 100 != 0) || (yearToCheck % 400 == 0);
    }
    
    /**
     * return a string representation of this trip.
     * @return representation of the trip in the following format: Trip:guide name|departure date-return date|number of countries|number of travellers for example: Trip:Yossi Chen|2/3/1998|10/3/1998|5|25
     */
    public String toString()
    {
        return "TRIP:" + this._name + "|" + this._departureDate.toString() + "|" + 
        this._returningDate.toString() + "|" + this._noOfCountries + "|" + this._noOfTravellers;
    }
    
}
