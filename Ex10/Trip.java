package Ex10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Trip {

    private String tripNumber;
    private double distance;
    private double speed;
    private String startTime;

    public Trip(String tripNumber, double distance, double speed, String startTime) {
        this.tripNumber = tripNumber;
        this.distance = distance;
        this.speed = speed;
        this.startTime = startTime;
    }

    public static String formatTime(String time) throws ParseException {
        SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm");
        Date date = dataFormat.parse(time);
        return dataFormat.format(date);
    }

    public String getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(String tripNumber) {
        this.tripNumber = tripNumber;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

//====================================================================

    public double convertMinToHour(int min) {
        return min / 60;
    }

    public String calculateArrivalTime() {
        double sTime = convertTimeToDecimal(getStartTime());
        double arrive = (getDistance() / getSpeed()) + sTime;
        return convertDecimalToTime(arrive);
    }

    public String convertDecimalToTime(double t) {
        double buildTime = t;
        int hour = (int) t;
        int minute = (int) (t * 60) % 60;
//        int second = (int)(t*(60*60))%60;
        return hour + ":" + minute;
    }

    public double convertTimeToDecimal(String time) {
        String start = time;
        String[] sp = start.split(":");
        double h = Double.parseDouble(sp[0]);
        double m = Double.parseDouble(sp[1]);
        return h + (m * (1 / 60.0));
    }

    public abstract double calculateDuration();

}
