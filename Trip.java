 
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
        this._name = (name != null) ? name : "";
        this._departureDate = new Date(depDay, depMonth, depYear);
        this._returningDate = new Date(retDay, retMonth, retYear);
        if (this._departureDate.after(this._returningDate))
        {
            this._departureDate = new Date(1, 1, 2000);
            this._returningDate = new Date(this._departureDate);
        } 
        this._noOfCountries = (noOfCountries > 0 && noOfCountries <= 10) ? noOfCountries : 1;
        this._noOfTravellers = (noOfTravellers > 0 && noOfTravellers <= 50) ? noOfTravellers : 10;
    }
    
    /**
     * creates a new Trip object
     * @param otherTrip trip to be copied
     */
    public Trip(Trip otherTrip)
    {
        this._name = otherTrip._name;
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
        this._name = (name != null) ? name : "";
        this._departureDate = new Date(depDate);
        this._returningDate = new Date(retDate);
        if (this._departureDate.after(this._returningDate))
        {
            this._departureDate = new Date(1, 1, 2000);
            this._returningDate = new Date(this._departureDate);
        } 
        this._noOfCountries = (noOfCountries > 0 && noOfCountries <= 10) ? noOfCountries : 1;
        this._noOfTravellers = (noOfTravellers > 0 && noOfTravellers <= 50) ? noOfTravellers : 10;
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
        return this._departureDate;
    }
    
    /**
     * gets the trip return date
     * @return the return date
     */
    public Date getReturningDate()
    {
        return this._returningDate;
    }

    /**
     * sets the guide name
     * @param otherName the value to be set
     */
    public void setGuideName(String otherName)
    {
        this._name = (otherName != null) ? otherName : this._name;
    }

    /**
     * sets the number of countries (only if valid)
     * @param otherNumberOfCountries the value to be set
     */
    public void setNoOfCountries(int otherNumberOfCountries )
    {
        this._noOfCountries = (otherNumberOfCountries  > 0 && otherNumberOfCountries  <= 10) ? otherNumberOfCountries : this._noOfCountries;
    }
    
    /**
     * sets the number of travellers (only if valid)
     * @param otherNumberOfTravellers  the value to be set
     */
    public void setNoOfTravellers(int otherNumberOfTravellers)
    {
        this._noOfTravellers = (otherNumberOfTravellers  > 0 && otherNumberOfTravellers  <= 50) ? otherNumberOfTravellers : this._noOfTravellers;
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
        if (this.sameDepartureDate(otherTrip) || this.sameReturningDate(otherTrip) || 
                this._departureDate.equals(otherTrip._returningDate) || 
                this._returningDate.equals(otherTrip._departureDate))
            return true;
        else if (this._returningDate.before(otherTrip._departureDate) || 
                this._departureDate.before(otherTrip._returningDate))
            return true;
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
     * calculates total price of the trip according to days of the trip and number of countries visited
     * @return the total price of the trip
     */
    public int calculatePrice()
    {
        return (this._departureDate.getMonth() == 7 || this._departureDate.getMonth() == 8) ?
            (int)(1.20 * (this.tripDuration() * this.PRICE_PER_DAY + this._noOfCountries * this.PRICE_PER_COUNTRY + this.howManyWeekends() * this.PRICE_PER_WEEKEND)) :
                (this.tripDuration() * this.PRICE_PER_DAY) + (this._noOfCountries * this.PRICE_PER_COUNTRY + this.howManyWeekends() * this.PRICE_PER_WEEKEND);
    }

    /**
     * calculates how many weekends occur during the trip
     * @return the number of weekends occurring during the trip
     */
    public int howManyWeekends()
    {
        int count = 0;
        int dayOfDep = _departureDate.dayInWeek();
        int dayOfRet = _returningDate.dayInWeek();
        int diff = _returningDate.difference(_departureDate);
        count += diff / 7;
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
            return new Date(this._departureDate.getDay() + depDay, this._departureDate.getMonth(), this._departureDate.getYear());
        }
        else
            return null;
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
