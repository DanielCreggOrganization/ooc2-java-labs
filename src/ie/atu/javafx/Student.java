package ie.atu.javafx;

class Student {
    private int id;
    private String name;
    private int age;

    public Student(String name, int id, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() { 
        return age; 
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) { 
        this.name = name; 
    }

    public void setAge(int age) { 
        this.age = age; 
    }
    
    // toString method
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", age=" + age + '}';
    }
}
