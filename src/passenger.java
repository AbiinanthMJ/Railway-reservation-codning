public class passenger {
        //I will finish this with in 2 days or three days .I Swear\
        String name ;
        int age;
        String gender;
        String berthpreference;
        String allotedberth;
        String ticketid;

    public passenger(String name, int age, String gender, String berthpreference, String allotedberth, String ticketid) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berthpreference = berthpreference;
        this.allotedberth = allotedberth;
        this.ticketid = ticketid;
    }

    @Override
    public String toString() {
        return "passenger{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", berthpreference='" + berthpreference + '\'' +
                ", allotedberth='" + allotedberth + '\'' +
                ", ticketid='" + ticketid + '\'' +
                '}';
    }
}