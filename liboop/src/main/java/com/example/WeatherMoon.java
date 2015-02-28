package com.example;

//4. Построить программу для работы с классом для хранения данных о погоде
//(направление, скорость ветра, температура, облачность, осадки). Программа должна
// обеспечивать простейшие функции: ввод значений, вывод значений.

public class WeatherMoon {

    private final static String WEATHER_PERFECT = "the weather is perfect :-)";
    private final static String WEATHER_GOOD = "the weather is good";
    private final static String WEATHER_BAD = "the weather is bad :-(";

    private final static String DESCRIPTION_CLOUD = "There are clouds.";
    private final static String DESCRIPTION_WET = "Rain is expected. ";

    private String destination;
    private int speed;
    private double temperature;
    private boolean cloud;
    private boolean wet;

    //Constructor
    public WeatherMoon(String destination, int speed, double temperature, boolean cloud, boolean wet) {
        this.destination = destination;
        this.speed = speed;
        this.temperature = temperature;
        this.cloud = cloud;
        this.wet = wet;
    }

    //Method return a string state of Weather like perfect, good and bad
    public String whatIsWeather() {

        if ((this.getTemperature() > 0) && (!this.isWet()) && (!this.isCloud())) {
            return WEATHER_PERFECT;
        } else if ((this.getTemperature() > 0) && (!this.isWet())) {
            return WEATHER_GOOD;
        } else {
            return WEATHER_BAD;
        }
    }


    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setCloud(boolean cloud) {
        this.cloud = cloud;
    }

    public void setWet(boolean wet) {
        this.wet = wet;
    }

    public String getDestination() {
        return destination;
    }

    public int getSpeed() {
        return speed;
    }

    public double getTemperature() {
        return temperature;
    }

    public boolean isCloud() {
        return cloud;
    }

    public boolean isWet() {
        return wet;
    }


    @Override
    public String toString() {

        String weatherTemp = " ";

        if (this.isCloud()) {
            weatherTemp = weatherTemp + DESCRIPTION_CLOUD;
        }
        if (this.isWet()) {
            weatherTemp = weatherTemp + DESCRIPTION_WET;
        }
        weatherTemp = "Wind: " + this.getDestination() + " " + Integer.toString(this.getSpeed()) +
                "km\\h, Temperature: " + Double.toString(this.getTemperature()) + "°C" + weatherTemp;
        weatherTemp = weatherTemp + "Result: " + whatIsWeather();
        return weatherTemp;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        WeatherMoon other = (WeatherMoon) obj;
        if (this.getDestination() != other.getDestination())
            return false;
        if (this.getTemperature() != other.getTemperature())
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 10;
        hash = (int) (Math.round(this.getTemperature() - this.getSpeed()) * hash);
        return hash;
    }
}
