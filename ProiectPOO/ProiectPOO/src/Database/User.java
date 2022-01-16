package Database;

public class User {
    private int Id;
    private String Username;
    private String Password;
    private String Gender;
    private int Age;
    private String Type;

    private String Period; //subscription table
    private String Date;
    private String Trainer;
    private String Description;

    private String Feedback;
    private int Rateing;
    private String Category;

    private String Info;
    private String FullName;

    private String Equipment;
    private String Quantity;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        this.Age = age;
    }

    public String getType() { return Type;}

    public void setType(String type){
        this.Type = type;
    }




    public String getPeriod() {
        return Period;
    }

    public void setPeriod(String period) {
        Period = period;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTrainer() {
        return Trainer;
    }

    public void setTrainer(String trainer) {
        Trainer = trainer;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }



    public String getFeedback() { return Feedback; }

    public void setFeedback(String feedback) { Feedback = feedback; }

    public int getRateing() { return Rateing; }

    public void setRateing(int rateing) { Rateing = rateing; }

    public String getCategory() { return Category; }

    public void setCategory(String category) { Category = category; }



    public String getInfo() {
        return Info;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }


    public String getEquipment() {
        return Equipment;
    }

    public void setEquipment(String equipment) {
        Equipment = equipment;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }


    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Age=" + Age +
                ", Type='" + Type + '\'' +
                ", Period='" + Period + '\'' +
                ", Date='" + Date + '\'' +
                ", Trainer='" + Trainer + '\'' +
                ", Description='" + Description + '\'' +
                ", Feedback='" + Feedback + '\'' +
                ", Rateing=" + Rateing +
                ", Category='" + Category + '\'' +
                ", Info='" + Info + '\'' +
                ", FullName='" + FullName + '\'' +
                ", Equipment='" + Equipment + '\'' +
                ", Quantity='" + Quantity + '\'' +
                '}';
    }

    public User() {
    }
    public User(String equipment, String quantity) {
        super();
        this.Equipment = equipment;
        this.Quantity= quantity;
    }

    public User(int userId, String username, String password) {
        this.Id = userId;
        this.Username = username;
        this.Password = password;
    }
    public User(String username, String password, String gender, int age) {
        super();
        this.Username = username;
        this.Password = password;
        this.Gender = gender;
        this.Age = age;
    }
    public User(int userId, String username, String password, String gender, int age) {
        super();
        this.Id = userId;
        this.Username = username;
        this.Password = password;
        this.Gender = gender;
        this.Age = age;
    }
    public User(int userId, String username, String password, String gender, int age, String type) {
        super();
        this.Id = userId;
        this.Username = username;
        this.Password = password;
        this.Gender = gender;
        this.Age = age;
        this.Type =type;
    }
    public User(String username, String password, String gender, int age, String type) {
        super();
        this.Username = username;
        this.Password = password;
        this.Gender = gender;
        this.Age = age;
        this.Type =type;
    }



    public User(String period, String date, String trainer, String description) {   //subscription
        super();
        this.Period = period;
        this.Date = date;
        this.Trainer = trainer;
        this.Description = description;
    }



    public User(String category, String feedback, int rateing) {
        this.Category = category;
        this.Feedback = feedback;
        this.Rateing = rateing;
    }

    public User(String username, String fullName, String info){
        this.Username=username;
        this.FullName=fullName;
        this.Info=info;
    }

}