class UserDefined extends Exception{
    String msg;
    UserDefined(String msg){
        this.msg = msg;
    }

    String getMsg(){
        return this.msg;
    }
}

public class exceptionExample {
    static void check(int age){
        if (age<18) {
            throw new ArithmeticException("Invalid age");
        }
    }

    static void methodCheck(int x) throws UserDefined , ArithmeticException{
        if (x < 5) {
            throw new UserDefined("Invalid age");
        }
        else{
            throw new ArithmeticException("Valid age");
        }
    }
    public static void main(String[] args) {
        int a = 2;
        int b = 1;

        try {
            System.out.println(a/b);
        } catch (Exception e) {  // Exception - class , e - object
            System.out.println("Error is : "+ e);
        } 
        // catch (ArithmeticException E) {  // ArithmeticException - class , e - object
        //     System.out.println("Error is : "+ E);
        // }
        finally{
            System.out.println("Finally Block");
        }

        // create a customized exception 
        try {
            check(a);
        } catch (Exception e) {
            System.out.println(e); // used e.getMessage()
        }    
        
        // user defined exception 
        try {
            methodCheck(a);
        } catch (UserDefined e) {
           System.out.println(e.getMsg());
        }
        catch (ArithmeticException e) {
           System.out.println(e);
        }
    }
}
