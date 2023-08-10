
public class Data {
//    Instance variables amount, unit, and downloadSpeed
    private double data_amount;
    private String unit_type;
    private int download_speed;
    private double converted_data;
    private double download_time;
    private double time_minutes;
    private double time_seconds;

    public double getData_amount() {
        return data_amount;
    }

    public String getUnit_type() {
        return unit_type;
    }

    public int getDownload_speed() {
        return download_speed;
    }

    public double getConverted_data() {
        return converted_data;
    }

    public double getTime_minutes() {
        return time_minutes;
    }

    public double getTime_seconds() {
        return time_seconds;
    }

    public double getDownload_time() {
        return download_time;
    }
    // setters bellow

    public void setData_amount(double data_amount) {
        this.data_amount = data_amount;
    }

    public void setUnit_type(String unit_type) {
        this.unit_type = unit_type;
    }

    public void setDownload_speed(int download_speed) {
        this.download_speed = download_speed;
    }

    public void setConverted_data(double converted_data) {
        this.converted_data = converted_data;
    }

    public void setTime_minutes(int time_minutes) {
        this.time_minutes = time_minutes;
    }

    public void setTime_seconds(int time_seconds) {
        this.time_seconds = time_seconds;
    }

    public void setDownload_time(double download_time) {
        this.download_time = download_time;
    }

    //    Constructor
    Data(int data_amount, String unit_type, int download_speed){
        setData_amount(data_amount);
        setUnit_type(unit_type);
        setDownload_speed(download_speed);

    }

//    Class methods
    public double convertToMegabytes(){
        switch (getUnit_type()){
            case "bytes":
                setConverted_data(((double) getData_amount() / 1024) / 1024);
                break;
            case "kilobytes":
                setConverted_data((double) getData_amount() / 1024);
                break;
            case "megabytes":
                setConverted_data(getData_amount());
                break;
            case "gigabytes":
                setConverted_data(getData_amount() * 1024);
                break;
            default:
                throw new IllegalArgumentException();
        }
        return getConverted_data();
    }

    public double calculateDownloadTime(){
        double download_time = getConverted_data() / (getDownload_speed() / 8.0);
        setDownload_time(download_time);
//        System.out.println(getDownload_time());
        return download_time;

    }

    public String getFormattedDownloadTime(){
        double downloadConvert = getDownload_speed() / 8.0;
        double timeCalc =  (getConverted_data() / downloadConvert);
        setTime_minutes((int) timeCalc / 60);
        setTime_seconds((int) timeCalc % 60);
        int minutes_display = (int) timeCalc / 60;
        int seconds_display = (int) timeCalc % 60;

        return ( (int) getTime_minutes() + " minutes ") +
               ((int)  getTime_seconds() + " seconds");

    }

    @Override
    public String toString(){
        convertToMegabytes();
        calculateDownloadTime();

        return
                ("Data: " + (getData_amount()) + " " + getUnit_type()) +
                ("\nDownload Time: " + (getFormattedDownloadTime()));
    }


//    toString using Class methods
}
