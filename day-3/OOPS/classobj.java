
public class classobj {

    private String name;
    int rollno;

    public void display(){
        System.out.println(name+" "+rollno);
    }

    private void setValues(String name, int rollno){
        this.name = name;
        this.rollno=rollno;
    }
    
    public static void main(String[] args) {
        classobj object = new classobj();
        // object.name = "Dravid";
        // object.rollno = 123;
        // to reduce step need a setter method -> setvalue
        object.setValues("Dravid", 123);
        object.display();
        System.out.println(object.name); // if this is on another class we need getValue
                                        // function
        
    }
}
