class outter {
    public void outShow() {
        System.out.println("Outter class");
    }
    public void bothOver() {
        System.out.println("Both class");
    }
    class inner {
        public void inShow() {
            System.out.println("Inner class");
            bothOver();
        }
    }
    static class inner2 {
        public void inShow() {
            System.out.println("Static Inner class");
        }
    }
}

abstract class noAccess {
    abstract void output();
    public void show() {
        System.out.println("Showing from abstract class but public method");
    }
    void show1() {
        System.out.println("Showing from abstract class but package-private(default) method"); // can be accessed by all classes in the same package
    }
}

public class innerClass {
    public static void main(String args[]) {
        outter obj = new outter();
        obj.outShow();
        outter.inner obj2 = obj.new inner();
        obj2.inShow();
        obj.bothOver();
        outter.inner2 obj3 = new outter.inner2();   // This is in case of static inner class only because static 
                                                    // class doesn't need object to access its methods
        obj3.inShow();

        noAccess obj4 = new noAccess() {    // Not only abstract class but any classes can have anonymous inner class. 
            void output() {
                System.out.println("Anonymous inner class");
            }
            public void show() {
                System.out.println("Changed from anonymous inner class");
            }
        };
        obj4.output();
        obj4.show1();
        obj4.show();
    }
}
