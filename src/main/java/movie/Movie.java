package movie;


public class Movie {

    String title;
    int runtime;
    int price;

    public Movie(String title, int runtime, int price) {
        this.title = title;
        this.runtime = runtime;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }
    public int getRuntime() {
        return runtime;
    }
    public int getPrice() {
        return price;
    }

}
