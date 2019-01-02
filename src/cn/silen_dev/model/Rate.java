package cn.silen_dev.model;

public class Rate {
    private int id;
    private int movieId;
    private float ratingValue;
    private int ratingCount;
    private float fivePercent;
    private float fourPercent;
    private float threePercent;
    private float twoPercent;
    private float onePercent;

    @Override
    public String toString() {
        return "id="+id+"" +
                "\nmovieId="+movieId+"" +
                "\nratingValue="+ratingValue+"" +
                "\nratingCount="+ratingCount+"" +
                "\nfivePercent="+fivePercent+"" +
                "\nfourPercent="+fourPercent+"" +
                "\nthreePercent="+threePercent+"" +
                "\ntwoPercent="+twoPercent+"" +
                "\nonePercent="+onePercent;
    }

    private long dataTime;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(float ratingValue) {
        this.ratingValue = ratingValue;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public float getFivePercent() {
        return fivePercent;
    }

    public void setFivePercent(float fivePercent) {
        this.fivePercent = fivePercent;
    }

    public float getFourPercent() {
        return fourPercent;
    }

    public void setFourPercent(float fourPercent) {
        this.fourPercent = fourPercent;
    }

    public float getThreePercent() {
        return threePercent;
    }

    public void setThreePercent(float threePercent) {
        this.threePercent = threePercent;
    }

    public float getTwoPercent() {
        return twoPercent;
    }

    public void setTwoPercent(float twoPercent) {
        this.twoPercent = twoPercent;
    }

    public float getOnePercent() {
        return onePercent;
    }

    public void setOnePercent(float onePercent) {
        this.onePercent = onePercent;
    }

    public long getDataTime() {
        return dataTime;
    }

    public void setDataTime(long dataTime) {
        this.dataTime = dataTime;
    }


}
