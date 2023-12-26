class Leap {

    boolean isLeapYear(int year) {
        //throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        if(year%4==0 && (!(year%100==0) || year%400==0))
            return true;
        return false;
    }

}
