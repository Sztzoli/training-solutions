package ioreadwritebytes.temperatures;

public class Temperatures {
    private byte[] data;

    public Temperatures(byte[] data) {
        this.data = data;
    }


    public byte[] getData() {
        return data;
    }

    public double getYearAverage() {
        int sum = 0;
        for (byte oneData : data) {
            sum += oneData;
        }
        return sum/(double) data.length;
    }

    public double getMonthAverage() {
        int sum = 0;
        for (int i = data.length-30; i < data.length; i++) {
            sum += data[i];
        }
        return sum/30d;
    }


}
