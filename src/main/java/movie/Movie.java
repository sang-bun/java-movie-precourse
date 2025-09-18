package movie;


public class Movie {

    String title;
    int runtime;
    int price;
    int id;

    public Movie(String title, int runtime, int price, int id) {
        this.title = title;
        this.runtime = runtime;
        this.price = price;
        this.id = id;
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
    public int getId() {
        return id;
    }

}
