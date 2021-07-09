package me.kodysimpson;

public class Main {

    public static void main(String[] args) {

        String thing = "I enjoy eating cheese";
        Object obj = thing;

        //the typical way of doing things
        if (obj instanceof String){
            String string = (String) obj;
            System.out.println("String: " + string);
        }

        //the JDK 16 pattern matching approach
        //the variable named 'string' is the "pattern variable"
        if (obj instanceof String string){
            System.out.println("String: " + string);
        }

        //another example with different objects
        Shape shape = new Rectangle(2.0, 3.0);
        System.out.println(calculateShapeArea(shape));

        //How does the scope of the type variable work?
        //A good motto is "A pattern variable is in scope where it has definitely matched".
        //This means the variable will exist in whatever scope logically makes sense after doing the
        //pattern match.
        if (shape instanceof Rectangle r){
            //r will exist in this scope since the pattern matches and the if statement is true
        }else{
            //r will not exist here since the boolean with the pattern is false.
            //in accordance with our motto, it wouldnt make sense to exist here
        }

        //A tricky scope example that shows the intelligence of Java
        if (!(shape instanceof Rectangle r)){
            //r will NOT exist in this scope since even though the pattern matches,
            //the if statement evaluates to false
        }else{
            //r WILL be available here
        }

        //More complex conditions
        if (shape instanceof Triangle t && t.getHeight() > 2){
            //this is valid since the t variable will exist only if the pattern matches
            //and the second condition will only be evaluated if the first condition is true itself
        }

        //Doesn't work, since the second condition is evaluated no matter if the variable exists or not
        if (shape instanceof Triangle t || t.getHeight() > 2){
            //this is valid since the t variable will exist only if the pattern matches
            //and the second condition will only be evaluated if the first condition is true itself
        }

    }

    private static double calculateShapeArea(Shape shape){

        if (shape instanceof Rectangle r){
            return r.getWidth() * r.getHeight();
        }else if (shape instanceof Triangle t){
            return 0.5 * t.getBase() * t.getHeight();
        }else{
            return -1;
        }

    }
}
