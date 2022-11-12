package Lab3;

public class MyDate {
    protected int year;
    protected int month;
    protected int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }

    public void print() {
        System.out.print( " "+year + "/" + month + "/" + day+" ");
    }

    public String toString() {
        return year + "/" + month + "/" + day;
    }

    public boolean isExpired(MyDate expiryDate) {
        if (year < expiryDate.year) {
            return false;
        } else if (year == expiryDate.year && month < expiryDate.month) {
            return false;
        } else if (year == expiryDate.year && month < expiryDate.month) {
            return false;
        } else if (year == expiryDate.year && month == expiryDate.month && day < expiryDate.day) {
            return false;
        }
        return true;
    }
}
