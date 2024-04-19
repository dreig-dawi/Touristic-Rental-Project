package features.utils;

abstract class Date {
    public boolean checkExistentDay(int day, int month, int year)  {
        if (longMonth(month) && day <= 31)
        {
            return true;
        } else if (day < 29) {
            return true;
        } else if (shortMonth(month) && day < 31 && month != 2) {
            return true;
        } else if (month == 2 && day <= 29) {
            if (day < 29) {
                return true;
            }else if (year == 2028 || year == 2032) {
                return true;
            }
        }
        return false;
    }  
    public String dateRegulator(int year, int month, int day) {
        if (!checkExistentDay(day, month, year)) {
            if (day > 31)
            {
                return "next_month";
            }
            if (month > 12)
            {
                return "next_year";
            }
        }
        return "" + year + "-" + month + "-" + day;
    }
    public boolean longMonth(int month) {
        return ((month <= 7 && month % 2 == 1) || (month >=8 && month % 2 == 0));
    }
    public boolean shortMonth(int month) {
        return !longMonth(month);
    }
    public int updateCorrectDate(int year, int month, int day) {
        return 0;
    }
}
