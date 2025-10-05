class grandFather{       //  multi level inheritence 
    char gender = 'M';
    static void print(){
        System.out.println("Parent class");
    }
}

class father extends grandFather{  // single inheritence
    
}

class son extends father{

}

class mother extends grandFather{   // hierarical inheritence 
    static char gender = 'F';    // overrided
}

class daughter extends mother{

}

public class levelinheritence {
    public static void main(String[] args) {
        son obj = new son();
        obj.print();
        System.out.println(obj.gender);

        daughter obj2 = new daughter();
        obj2.print();
        grandFather.print();  // static method can be accessed without object creation
        System.out.println(obj2.gender);

        // here we are using static variable both parent and child use same variable no explicit memory
        daughter.gender = 'M';
        System.out.println(obj2.gender);

        System.out.println(mother.gender);
        
    }
}