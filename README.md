# Java Backend Guide

<aside>

### Some Core Java Concepts

<aside>

- **Anonymous Inner Class** (Code)
    
    ```java
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
    
    ```
    
</aside>

<aside>

- **Threads** (Code)
    - By extending Thread class
        
        ```java
        import java.util.Scanner;
        
        class firstHalf extends Thread {
            private int n;
            void setN(int n) {
                this.n = n;
            }
            public void run() {
                    for (int i = 0; i < n; i++) {
                        System.out.println("1st Half: " + (i+1));
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        }
        
        class secondHalf extends Thread {
            private int n;
            void setN(int n) {
                this.n = n;
            }
            public void run() {
                for (int i = 0; i < n; i++) {
                    System.out.println("2nd Half: " + (i+1));
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        
        public class Threads {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the number of 1st/2nd half: ");
                int n = sc.nextInt();
                sc.close();
        
                firstHalf f = new firstHalf();
                secondHalf s = new secondHalf();
        
                f.setN(n);
                s.setN(n);
        
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                f.start();
                s.start();
            }
        }
        
        ```
        
    
    ---
    
    - By implementing Runnable interface
        
        ```java
        import java.util.Scanner;
        
        class firstHalf implements Runnable {
            private int n;
            void setN(int n) {
                this.n = n;
            }
            public void run() {
                    for (int i = 0; i < n; i++) {
                        System.out.println("1st Half: " + (i+1));
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        }
        
        class secondHalf implements Runnable {
            private int n;
            void setN(int n) {
                this.n = n;
            }
            public void run() {
                for (int i = 0; i < n; i++) {
                    System.out.println("2nd Half: " + (i+1));
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        
        public class ThreadsRunnable {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the number of 1st/2nd half: ");
                int n = sc.nextInt();
                sc.close();
        
                firstHalf f = new firstHalf();
                secondHalf s = new secondHalf();
        
                f.setN(n);
                s.setN(n);
        
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                Thread t1 = new Thread(f);
                Thread t2 = new Thread(s);
                t1.start();
                t2.start();
        
                // f.start();
                // s.start();
            }
        }
        
        ```
        
    
    ---
    
    - Syncing two Threads who are using same resources
        
        ```java
        // SYNCRONIZED THREADS
        import java.util.*;
        
        class SharedCounter {
            int count;
            public int getCount() {
                return count;
            }
            public synchronized void increases() {
                count++;
            }
        }
        
        public class ThreadSync {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the number of times to increase the counter (2x)So x: ");
                int n = sc.nextInt();
                sc.close();
        
                SharedCounter co = new SharedCounter();
        
                Runnable r1 = () -> {
                    for (int i = 0; i < n; i++)
                        co.increases();
                };
                Runnable r2 = () -> {
                    for (int i = 0; i < n; i++)
                        co.increases();
                };
        
                Thread t1 = new Thread(r1);
                Thread t2 = new Thread(r2);
                t1.start();
                t2.start();
        
                try {
                    t1.join();
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        
                System.out.println(co.getCount());
            }
        }
        
        ```
        
</aside>

<aside>

- **Exception Handling** (Code)
    - Throwing Exception
        
        ```java
        class errorDect {
        	void checkAge(int age) throws ArrayIndexOutOfBoundsException {
        		if (age < 18) {
        			int arr[] = new int[3];
        			arr[3] = 5;
        		} else {
        			System.out.println("Access granted - You are old enough!");
        		}
        	}
        }
        
        public class ThrowsExcep {
        	public static void main(String[] args) {
        		errorDect er = new errorDect();
        		try {
        			er.checkAge(15);
        			// er.checkAge(19);
        		} catch (Exception e) {
        			System.out.println("You are not old enough. Error is:\t" + e);
        			e.printStackTrace();
        		}
        		System.out.println("End of code.");
        	}
        }
        
        ```
        
    
    ---
    
    - Creating and Throwing Custom Exception
        
        ```java
        import java.util.Scanner;
        
        class zeroException extends Exception {
            public zeroException(String s) {
                super(s);
            }
        }
        
        public class ExceptionHandling {
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter two numbers for division : ");
                int num1=1, num2=1;
                try {
                    num1 = sc.nextInt();
                    num2 = sc.nextInt();
                    if (num2 > num1) {
                        throw new zeroException("2nd number shouldn't be greater than 1st number as the result is 'int' type.");
                    }
                    System.out.println(num1+"/"+num2+" = "+num1/num2);
                } catch (ArithmeticException e) {
                    System.out.println("["+num1+"/"+num2+"]\t"+"Division by zero is not allowed. "+e);
                } catch (zeroException e) {
                    System.out.println("["+num1+"/"+num2+"]\t"+e);
                } catch (Exception e) {
                    System.out.println("["+num1+"/"+num2+"]\t"+"Any other error has occurred. "+e);
                } finally {
                    sc.close();
                }
                System.out.println("Outside try-catch block.");
            }
        }
        
        ```
        
</aside>

<aside>

- **Enumeration or Enum** (Code)
    
    ```java
    import java.util.*;
    
    enum Fruit {
        APPLE(50), BANANA(20), ORANGE(30), MANGO(60), PINEAPPLE;
        private Fruit() {
            price = 40;
        }
    
        private Fruit(int price) {
            this.price = price;
        }
        
        private int price;
    
        public int getPrice() {
            return price;
        }
    
        public void setPrice(int price) {
            this.price = price;
        }
    }
    
    public class enumeration {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Choose your fruit to eat-\n\t Mango, Banana, Orange, Apple or Pineapple: ");
            String buyFruit = sc.next();
            switch (buyFruit.toUpperCase()) {
                case "MANGO":
                    System.out.println(buyFruit + " : " + Fruit.MANGO.getPrice());
                    break;
                case "BANANA":
                    System.out.println(buyFruit + " : " + Fruit.BANANA.getPrice());
                    break;
                case "APPLE":
                    System.out.println(buyFruit + " : " + Fruit.APPLE.getPrice());
                    break;
                case "ORANGE":
                    System.out.println(buyFruit + " : " + Fruit.ORANGE.getPrice());
                    break;
                case "PINEAPPLE":
                    System.out.println(buyFruit + " : " + Fruit.PINEAPPLE.getPrice());
                    break;
                default:
                    System.out.println("All fruits:");
                    for (Fruit fruit : Fruit.values()) {
                        System.out.println(fruit + " : " + fruit.getPrice());
                    }
            }
            sc.close();
        }
    }
    
    ```
    
</aside>

<aside>

- **Up and Down Casting in OOP** (Code)
    
    ```java
    class Animal {
        public String eat() {
            return "Animal is eating (Parent)";
        }
        public String sleep() {
            return "Animal is sleeping (Parent)";
        }
    }
    
    class Dog extends Animal {
        public String eat() {
            return "Dog is eating (Child)";
        }
        public String bark() {
            return "Dog is barking (Child)";
        }
    }
    
    public class upAnddownCasting {
        public static void main(String[] args) {
    
            Animal obj1 = new Dog();    // Upcasting
            obj1 = (Animal) new Dog();  // Same thing as above
            System.out.println(obj1.eat()+" , "+obj1.sleep());
    
            Dog obj2 = (Dog) obj1;      // Downcasting
            System.out.println(obj2.eat()+" , "+obj2.sleep()+" , "+obj2.bark());
    
            // Dog obj2 = (Dog) new Animal();   This will not work
        }
    }
    
    ```
    
</aside>

<aside>

- **StringBuffer and StringBuilder** (Concept & Code)
    
    
    | StringBuffer | StringBuilder |
    | --- | --- |
    | StringBuffer is present since early versions of Java. | StringBuilder was introduced in Java 5 (JDK 1.5). |
    | StringBuffer is synchronized. This means that multiple threads cannot call the methods of StringBuffer simultaneously. | StringBuilder is asynchronized. This means that multiple threads can call the methods of StringBuilder simultaneously. |
    | Due to synchronization, StringBuffer is called a thread safe class. | Due to its asynchronous nature, StringBuilder is not a thread safe class. |
    | Due to synchronization, StringBuffer is lot slower than StringBuilder. | Since there is no preliminary check for multiple threads, StringBuilder is a lot faster than StringBuffer. |
    | Use in multi-threaded environments. | Use in single-threaded or non-concurrent environments. |
    
    ```java
    public class test2 {
        public static void main(String args[]) {
            StringBuilder sb = new StringBuilder("Hello");
            sb.append(" World"); // Modifies the same object
            sb.delete(5, 6); // "Hello World"
            System.out.println(sb); // Output: Hell World [5][6]
            System.out.println(sb.reverse());
    
            StringBuffer sb2 = new StringBuffer();
            System.out.println(sb2.capacity());
            sb2.insert(0, "String");
            System.out.println(sb2);
            System.out.println(sb2.capacity());
        }
    }
    ```
    
</aside>

<aside>

- **Stream API** (Code)
    
    ```java
    import java.util.Arrays;
    import java.util.List;
    import java.util.stream.Stream;
    
    public class StreamAPI {
        public static void main(String[] args) {
            
            List<Integer> arr = Arrays.asList(43, 23, 11, 67, 42, 0);
    
            int result = arr.stream()
                                .filter(n -> n>30)
                                .map(n -> n/10)
                                .reduce(0, (c,e) -> c+e);
    
            System.out.println(result);
    
            Stream<Integer> values = arr.stream()
                                .filter(n -> n>30)
                                .sorted();
            
            values.forEach(n -> System.out.print(n+", "));
        }
    }
    ```
    
</aside>

<aside>
<img src="https://www.notion.so/icons/snippet_green.svg" alt="https://www.notion.so/icons/snippet_green.svg" width="40px" />

- **All Code Files** (.java)
    
    ---
    
    [CollectionCompare.java](Java%20Backend%20Guide%201b7819eb4d8480329e0acf25a9efb277/CollectionCompare.java)
    
    ---
    
    [enumeration.java](Java%20Backend%20Guide%201b7819eb4d8480329e0acf25a9efb277/enumeration.java)
    
    ---
    
    [ExceptionHandling.java](Java%20Backend%20Guide%201b7819eb4d8480329e0acf25a9efb277/ExceptionHandling.java)
    
    ---
    
    [innerClass.java](Java%20Backend%20Guide%201b7819eb4d8480329e0acf25a9efb277/innerClass.java)
    
    ---
    
    [interfaces.java](Java%20Backend%20Guide%201b7819eb4d8480329e0acf25a9efb277/interfaces.java)
    
    ---
    
    [Lambda.java](Java%20Backend%20Guide%201b7819eb4d8480329e0acf25a9efb277/Lambda.java)
    
    ---
    
    [StreamAPI.java](Java%20Backend%20Guide%201b7819eb4d8480329e0acf25a9efb277/StreamAPI.java)
    
    ---
    
    [tempCodeRunnerFile.java](Java%20Backend%20Guide%201b7819eb4d8480329e0acf25a9efb277/tempCodeRunnerFile.java)
    
    ---
    
    [test2.java](Java%20Backend%20Guide%201b7819eb4d8480329e0acf25a9efb277/test2.java)
    
    ---
    
    [Threads.java](Java%20Backend%20Guide%201b7819eb4d8480329e0acf25a9efb277/Threads.java)
    
    ---
    
    [ThreadsRunnable.java](Java%20Backend%20Guide%201b7819eb4d8480329e0acf25a9efb277/ThreadsRunnable.java)
    
    ---
    
    [ThreadSync.java](Java%20Backend%20Guide%201b7819eb4d8480329e0acf25a9efb277/ThreadSync.java)
    
    ---
    
    [ThrowsExcep.java](Java%20Backend%20Guide%201b7819eb4d8480329e0acf25a9efb277/ThrowsExcep.java)
    
    ---
    
    [upAnddownCasting.java](Java%20Backend%20Guide%201b7819eb4d8480329e0acf25a9efb277/upAnddownCasting.java)
    
    ---
    
</aside>

</aside>

<aside>
<img src="https://www.notion.so/icons/document_green.svg" alt="https://www.notion.so/icons/document_green.svg" width="40px" />

### **Official Java Documentation**

- **Collection Framework**
    
    [https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/doc-files/coll-overview.html](https://docs.oracle.com/en/java/javase/23/docs/api/java.base/java/util/doc-files/coll-overview.html)
    
- **Spring Framework**
    
    [https://docs.spring.io/spring-framework/reference/index.html](https://docs.spring.io/spring-framework/reference/index.html)
    
- **Spring Security**
    
    [https://docs.spring.io/spring-security/reference/index.html](https://docs.spring.io/spring-security/reference/index.html)
    
</aside>

<aside>
<img src="https://www.notion.so/icons/error_green.svg" alt="https://www.notion.so/icons/error_green.svg" width="40px" />

### **Important Note**:

- **Proceed after knowing Core Java and SQL.**
- **Need to follow the codes alongside during revision.**

---

[](https://www.udemy.com/home/my-courses/learning/)

</aside>

<aside>

<aside>
<img src="https://www.notion.so/icons/arrow-right_gray.svg" alt="https://www.notion.so/icons/arrow-right_gray.svg" width="40px" />

**1. Networking-HTTP, TCP, TCP vs UDP, Client server model**

</aside>

<aside>
<img src="https://www.notion.so/icons/arrow-right_gray.svg" alt="https://www.notion.so/icons/arrow-right_gray.svg" width="40px" />

**2. Caching-what it is, why, and where exactly it is used**

</aside>

<aside>
<img src="https://www.notion.so/icons/arrow-right_gray.svg" alt="https://www.notion.so/icons/arrow-right_gray.svg" width="40px" />

**3. Databases(MySQL recommended)**

</aside>

<aside>
<img src="https://www.notion.so/icons/arrow-right_gray.svg" alt="https://www.notion.so/icons/arrow-right_gray.svg" width="40px" />

- **4. Build tools like maven(recommended), Gradle... its functionalities**
    
    <aside>
    
    [Apache Maven - GeeksforGeeks](https://www.geeksforgeeks.org/apache-maven/)
    
    [Maven in 5 Minutes – Maven](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)
    
    </aside>
    
</aside>

<aside>
<img src="https://www.notion.so/icons/arrow-right_gray.svg" alt="https://www.notion.so/icons/arrow-right_gray.svg" width="40px" />

**5. Install tomcat, postman**

</aside>

<aside>
<img src="https://www.notion.so/icons/arrow-right_gray.svg" alt="https://www.notion.so/icons/arrow-right_gray.svg" width="40px" />

**6. For beginners: IDE - IntelliJ or Eclipse**

</aside>

<aside>
<img src="https://www.notion.so/icons/arrow-right_gray.svg" alt="https://www.notion.so/icons/arrow-right_gray.svg" width="40px" />

- **7. Optional: Start from JSP and servlets(to understand spring-boot later well)**
    
    <aside>
    
    [Introduction to Java Servlets - GeeksforGeeks](https://www.geeksforgeeks.org/introduction-java-servlets/)
    
    [What is Java Servlet?](https://stackoverflow.com/questions/7213541/what-is-java-servlet)
    
    </aside>
    
</aside>

<aside>
<img src="https://www.notion.so/icons/arrow-right_gray.svg" alt="https://www.notion.so/icons/arrow-right_gray.svg" width="40px" />

- **8. MVC architecture and JDBC**
    
    <aside>
    
    [MVC Framework Introduction - GeeksforGeeks](https://www.geeksforgeeks.org/mvc-framework-introduction/)
    
    </aside>
    
    [https://docs.spring.io/spring-framework/reference/web/webmvc.html](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
    
    <aside>
    
    [JDBC Tutorial](https://www.tutorialspoint.com/jdbc/index.htm)
    
    [JDBC (Java Database Connectivity) - GeeksforGeeks](https://www.geeksforgeeks.org/introduction-to-jdbc/)
    
    </aside>
    
</aside>

<aside>
<img src="https://www.notion.so/icons/arrow-right_gray.svg" alt="https://www.notion.so/icons/arrow-right_gray.svg" width="40px" />

- **9. Start with spring, spring core(dependency injection, inversion of control, Beans and bean scope, spring configurations-xml annotations, java code)**
    - **Spring Starter & Properties**
        
        ![image.png](Java%20Backend%20Guide%201b7819eb4d8480329e0acf25a9efb277/image.png)
        
        ![image.png](Java%20Backend%20Guide%201b7819eb4d8480329e0acf25a9efb277/image%201.png)
        
    
    ---
    
    - **About `<artifact_name>application.java` file created by Spring Initializr**
        1. The `@SpringBootApplication` consists of the following annotations:
            1. `@EnableAutoConfiguration` : Automatically configure the spring boot app according to the dependencies present in it.
            2. `@ComponentScan` : Enable component scanning of current package as well as sub-packages.
                
                ![image.png](Java%20Backend%20Guide%201b7819eb4d8480329e0acf25a9efb277/image%202.png)
                
            3. `@Configuration` : Able to register beans with `@Bean` annotation or import other `@Configuration` classes.
        2. `SpringApplication.run()` actually starts the spring boot application (create application context, register all beans, starts the embedded tomcat server, etc)
    
    ---
    
    - **Inversion of Control (IoC) & DI**
        1. IoC means that the control of object creation and management is transferred from your code to spring framework.
        2. It named as IoC because it inverts or takes the control from user and give it to the framework.
        3. Dependencies are managed by ApplicationContext. Spring boot creates ApplicationContext which is like a bean manager or IoC container.
        4. This container have 2 functions: create & manage objects (IoC), inject object dependencies (DI).
        5. Dependencies = external classes + functions (wrapped inside JARs)
        6. Beans = class objects managed by spring IoC container or classes which have annotations like `@Component` or `@Configuration @Bean`
        7. `@Autowired` is used whenever there is a need to inject dependency into another class.
        8. `@Autowired` can be used on fields, constructors or setters.
        9. Constructor injection is used when the object cannot function properly without the dependency. Or, dependency is required by the object. 
        10. Setter injection is used when the dependency is optional or changable after object creation.
        11. Field injection is not recommended as it makes the unit testing harder. 
        12. If there are many dependencies then to choose which one will get injected there are 2 way for that:
            1. `@Qualifier` is used in rest controller to specifically choose which bean (using bean id) I want to inject. The bean id is same as the class name but the first character need to be in lower case.
            2. `@Primary` is used above the class name to make the class primary. You don't need qualifier annotation in RestController for this. (`@Qualifier` has higher priority than `@Primary`)
    
    ---
    
    - **Lazy Initialization**
        1. `getClass().getSimpleName()` is use to get the name of the current/working class.
        2. By adding `@Lazy` annotation to a class, bean will only be created when it is required, not at the time of application setup.
        3. For Global Lazy initialization, we need to add `spring.main.lazy-initialization = true` in application.properties .
    
    ---
    
    - **Bean Scopes**
        1. Scope refers to the lifecycle of the bean.
        2. It depends on how long the bean will live, how many instances of the bean are created.
        3. Types of Scope and its applications: 
            
            
            | **Scope Name** | **Meaning** | **Where it is commonly used** | Spring Boot application |
            | --- | --- | --- | --- |
            | **`singleton`**
            (Default) | Only one instance of the bean exist in the whole container. | Service classes like User Service , Order Service (because only one shared intance is required). | `@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)`
            or
            `@Scope("singleton")` |
            | **`prototype`** | Everytime a bean being injected (when using `@Autowired` ), a new instance is created. | Example: Creating new Document objects for each request. | `@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)`
            or
            `@Scope(”prototype”)` |
            | **`request`**
            (Web only) | One bean instance per single HTTP request. | Handling web form. | `@Scope(WebApplicationContext.SCOPE_REQUEST)`
            or
            `@Scope(”request”)` |
            | **`session`**
            (Web only) | One bean instance per single HTTP session. | Shopping cart object. | `@Scope(WebApplicationContext.SCOPE_SESSION)`
            or
            `@Scope(”session”)` |
            | **`application`**
            (Web only) | One bean for an entire web application (Servlet Context) | Tracking total site visitors. | `@Scope(WebApplicationContext.SCOPE_APPLICATION)`
            or
            `@Scope(”application”)` |
            | **`websocket`**
            (Web only) | One bean instance per websocket connection (real-time communication) | Chat applications. | `@Scope(WebApplicationContext.SCOPE_WEBSOCKET)`
            or
            `@Scope(”websocket”)` |
            - **Difference between `@Component`, `@Bean`, and `@Configuration`, `@Bean` in case of Singletone scope of the bean (For understanding purposes)** ⤵️
                - Using `@Component` & `@Bean` will not ensure singleton preservation fully but using `@Configuration` and `@Bean` does. (Using `@Bean` inside the component class is **NOT recommended**).
                
                **Example**:
                
                ```java
                @Component
                public class AppConfig {
                
                    @Bean
                    public Foo foo() {
                        return new Foo(); // NOT intercepted by Spring when called internally
                    }
                
                    @Bean
                    public Bar bar() {
                        return new Bar(foo()); // this creates a NEW Foo instance!
                    }
                }
                ```
                
                ```java
                @Configuration
                public class AppConfig {
                
                    @Bean
                    public Foo foo() {
                        return new Foo(); // managed by Spring, singleton by default
                    }
                
                    @Bean
                    public Bar bar() {
                        return new Bar(foo()); // this foo() call is intercepted and goes through Spring
                    }
                }
                ```
                
        4. Bean Lifecycle: The full journey of a bean — from creation to destruction — inside the Spring container.
        5. **Bean lifecycle phases** as:
            1. Instantiation: Spring creates an object of the class (using constructor).
            2. Populate Properties: Spring injects values like `@Autowired` fields.
            3. Initialization: Spring calls special initialization methods.
            4. Ready to Use: Spring calls special initialization methods.
            5. Destruction: When app shuts down, destroy methods are called.
        6. Adding custom methods in bean lifecycle
            1. `@PostConstruct`  marks a method to run after all beans are created and all dependencies are injected.
            2. `@PreDestroy` marks the method to run before the Spring container destroys the beans.
            - `@PostConstruct` and `@PreDestroy` annotation (Java Code) ⤵️
                
                ```java
                @Component
                public class MyBean {
                	
                	@PostConstruct
                	public void init() {
                	    System.out.println("Bean is initialized!");
                	}
                
                	@PreDestroy
                	public void destroy() {
                	    System.out.println("Bean is about to be destroyed!");
                	}
                }
                ```
                
        7. `@Bean` use case: Take existing third-party class and expose it as a Spring bean.
        8. NOTE: For `prototype` beans, **Spring creates** the bean but **does not manage** its full lifecycle (destroy you have to handle yourself!).
    
    ---
    
    - **Hibernate & JPA (Jakarta Persistence API)**
        1. **Hibernate**: An ORM (Object Relational Mapping) tool that maps Java objects to database tables.
        2. **JPA**: It is a specification that:
            1. Defines what annotation to use (`@Entity`, `@Id`, etc.).
            2. Define a set of interfaces.
            3. Requires an implementation to use like **Hibernate** (one of the JPA vendor implementation) which is default.
        3. **Benefit of using JPA** is by having a standard API, you are not locked in to vendor implementation & can switch vendor implementations when required.
        4. **DAO (Data Access Object)**: refers to a pattern for data access, sometime used as a term to indicate a class that uses this pattern. Or a class/component that is responsible for interacting with the database.
        5. DAO needs a **Entity Manager** for saving and/or retrieving entities from the database table.
        6. **Entity Manager vs JPA Repository**:
            1. Entity Manger is **low level** which needs more manual coding, but JPA Repository is **high level** where Spring handles the boilerplate.
            2. Entity manager is **more flexible** as we can write custom logic easily, but JPA repository is **limited to what Spring Data JPA provides** or the declarative way of writing custom queries.
        7. **Entity Class**: Its is the java class mapped to a DB table. It must have :
            1. `@Entity` annotation.
            2. Atleast one public or protected constructor with no argument.
        8. `@Id` is use to mark the field as the primary key in a `@Entity` class, & `@Column(name=”user_name”, nullable=false, length=45)` or `@Column(name=”user_name”)` to mark the fields as column.
        9. `@Column` annotation is **not mandetory but recommended** as if not included the field name must be same as the column name. But when its not the same (can be caused by mistake) can create a new column with same name as of the field name. Same for `@Table`.
        10. **ID generation strategies in JPA:** 
            
            
            | Strategy | Description | Annotations & Implementations |
            | --- | --- | --- |
            | i.  IDENTITY | Uses **auto-incremented column** in the DB (like MySQL’s `AUTO_INCREMENT`). ID is generated **by the database** when the row is inserted. | `@GeneratedValue(strategy = GenerationType.IDENTITY)` |
            | ii.  SEQUENCE | Uses database sequence object. Can be configured using `@SequenceGenerator`. | `@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
            @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)` |
            | iii.  AUTO | JPA provider (Hibernate) will choose a strategy based on the database. | `@GeneratedValue(strategy = GenerationType.AUTO)` |
            | iv.  UUID | Assign primary key using globally unique identifier for uniqueness. | `@GeneratedValue(strategy = GenerationType.UUID)` |
        11. `Student student = enityManager.find(Student.class, 1);` this will find the object of a student who’s ID(primary key) is 1 from the DB and will return an object. If it didn’t find the object, it will return null. 
        12. **JPQL (Jakarta Persistence Query Language or JPA Query Language):**
            1. JPQL does not use DB table name instead it **uses JPA entity class name**.
            2. In JPQL `FROM Student` is same as `SELECT s FROM Student s` where ‘s’ is just an alias. This is also known as strict JPQL. And, `SELECT * FROM Student` is not valid.
            3. **TypedQuery** ensure a type-safe return means no casting needed.
            - **Code of `.createQuery()` and `.getResultList()` :** ⤵️
                
                ```java
                TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
                List<Student> students = theQuery.getResultList();
                
                TypedQuery<Student> theQuery2 =enityManager.createQuery("FROM Student WHERE lastName = :theValue", Student.class);
                theQuery2.setParameter("theValue", lastValue);
                List<Student> students2 = theQuery2.getResultList();
                ```
                
        13. **Difference between `TypedQuery<T>` and `Query`:**
            
            
            | Feature | **`TypedQuery<T>`** | **`Query`** |
            | --- | --- | --- |
            | **Used for** | **SELECT** queries that return objects of type `T` | Non-SELECT queries (like `UPDATE`, `DELETE`) |
            | **Returns** | Typed results (e.g. `List<StudentData>`) | Void / Integer (for update count) |
            | **Can use in** | `getResultList()`, `getSingleResult()` | `executeUpdate()` |
        14. Following are the **PROPERTY-VALUE** for the property `spring.jpa.hibernate.ddl-auto = PROPERTY-VALUE` in application.properties file:
            
            
            | Value | Description |
            | --- | --- |
            | `none` | No schema management. Hibernate won’t do anything to the schema. |
            | `create` | Drops the schema (if it exists) and recreates it **every time** the application starts. |
            | `create-drop` | Same as `create`, but also **drops the schema** when the application shuts down. |
            | `update` | Modifies the existing schema to match the entity mappings, **without dropping data**. |
            | `validate` | Verifies that the schema matches the entity mappings, but **does not make any changes**. |
        15. ⚠️ Spring manages `@Transactional` through AOP proxies, so it is recommended to add `@Transactional` annotation in the service layer where the business logic resides rather than in DAO classes.
    
    ---
    
    - **MySQL in Spring Boot**
        1. **#1 Line**: Delete existing user if any of name springstudent from MySQL server for connecting from [localhost](http://localhost) (127.0.0.1).
            
            **#2 Line**: Create a new user that can connect from [localhost](http://localhost) and set the password as springstudent.
            
            **#3 Line**: Grant all permissions to all databases and tables to this newly created user.
            
            ```sql
            DROP USER IF EXISTS 'springstudent'@'localhost';
            CREATE USER 'springstudent'@'localhost' IDENTIFIED BY 'springstudent';
            GRANT ALL PRIVILEGES ON *.* TO 'springstudent'@'localhost';
            ```
            
        
        ---
        
        1. **#1 Line**: Can provide fewer permissions to a user on a selected database or table.
            
            **#2 Line**: Also can revoke specific privileges (SELECT, INSERT, etc).
            
            ```sql
            GRANT SELECT, INSERT ON mydatabase.mytable TO 'springstudent'@'localhost';
            REVOKE privilege_name ON db.table FROM 'user'@'host';
            ```
            
        
        ---
        
        1. Created a DB of name "student_tracker". Inside it, created a table named as "student". The table have:
            1. id(Not null, primary) which increment automatically,
            2. first_name,
            3. last_name,
            4. email
            
            **InnoDB**: It is a storage engines to manage how data is stored, retrieved, and modified on disk.
            
            **Key features of InnoDB**: Transactions, foreign keys, row-level locking, crash recovery.
            
            `DEFAULT CHARSET=utf8mb4` : This means all text columns in this table (like name) will use the `utf8mb4` character set.
            
            It determine how the text data(like VARCHAR) are encoded (it means how those characters are mapped to bytes) and stored.
            
            ```sql
            create database if not exists `student_tracker`;
            use `student_tracker`;
            
            drop table if exists `student`;
            create table `student` (
            	`id` INT NOT NULL AUTO_INCREMENT,
                `first_name` VARCHAR(45) DEFAULT NULL,
                `last_name` VARCHAR(45), -- MySQL will automatically assume DEFAULT NULL unless NOT NULL is mentioned.
                `email` VARCHAR(45),
                PRIMARY KEY (`id`)
            ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
            ```
            
        
        ---
        
        1. **#1 Line**: To change the auto increment to 3000 or any other number.
            
            **#2 Line**: Delete all data from the table and reset the auto increment to 1.
            
            ```sql
            ALTER TABLE student_tracker.student AUTO_INCREMENT = 3000;
            TRUNCATE student_tracker.student;
            ```
            
        
        ---
        
    
    ---
    
    - **REST API in Spring Boot**
        1. **REST (Representational State Transfer)** is an architecture style to design networked applications (APIs).
        2. **RESTful API** use: **GET**(read operation), **POST**(create operation), **PUT**(update operation), **DELETE**(delete operation). 
        3. REST API is stateless which means:
            1. **Each request** from the client must **contain all data** needed by the server.
            2. The server **doesn’t remember** previous requests.
        4. HTTP request message:
            1. **Request Line**: Contains HTTP method, URL, version.
            2. **Headers**: key-value pairs with metadata([MIME](https://www.geeksforgeeks.org/multipurpose-internet-mail-extension-mime-protocol/) content type: `type/sub-type` like `text/html`).
            3. **Body(optional)**: Contains data (for POST, PUT, PATCH). 
        5. HTTP response message:
            1. **Response Line**: HTTP version, status code, reason
            2. **Headers**: Metadata about the response
            3. **Body**: the data returned (in HTML, JSON, etc.)
        6. **Jackson** is a popular, high-performance JSON processing library for Java. It's widely used for:
            1. Parsing and generating JSON
            2. Data binding between JSON and Java objects (**JSON data ↔ Java objects** (POJOs→ Plain Old Java Objects))
            3. Spring Boot handles the JSON data binding with Jackson **automatically** behind the scenes.
                - **Details on JSON data binding:** ⤵️
                    1. **Spring uses Jackson internally**
                    2. **Converts incoming JSON to the Java POJO** (deserialization)
                    3. **Converts the Java POJO to JSON** when returning a response (serialization)
                    
                    ![image.png](Java%20Backend%20Guide%201b7819eb4d8480329e0acf25a9efb277/image%203.png)
                    
        7. `@PathVariable` :
            1. It binds the method parameter with the path variable placeholder.
            2. `public Student getMethodName(@PathVariable int studentId) {…}` Placeholder name should be equal to the parameter name.
            3. Alternate approach: `(@PathVariable("studentId") int id)`
        8. When to use `@ExceptionHandler` to a method:
            1. To **catch and process exceptions** thrown in your controller methods.
            2. **Customize the response** sent to the client when an exception occurs.
            3. `@ControllerAdvice` is a special annotation that makes the class a **global exception handler**.
        9. How the REST API Design should look like (Not a hard-and-fast rule):
            
            
            | HTTP Method | Endpoint | CRUD Action |
            | --- | --- | --- |
            | POST | api/employees | **C**reate a new employee |
            | GET | api/employees/{employeeId} | **R**ead a single employee |
            | GET | api/employees | **R**ead a list of employee |
            | PUT/PATCH | api/employees | **U**pdate an existing employee |
            | DELETE | api/employees/{employeeId} | **D**elete an existing employee |
            - ⚠️ Do not include the action you are performing in the name of the endpoints. ⤵️
                
                ![image.png](Java%20Backend%20Guide%201b7819eb4d8480329e0acf25a9efb277/image%204.png)
                
        10. Purpose of Service Layer:
            1. It is used for **custom business logic**.
            2. Integrate data from multiple sources (DAOs/repositories).
            3. It resides between controller and repository classes.
        11. Handling a **PATCH request**:
            1. In the controller, the method should be annotated by `@PatchMapping`.
            2. `public User updateUserPartially(Long id, Map<String, Object> updates) {…}`
            3. **ObjectMapper** needed to be injected into the **service layer**.
                1. Object mapper is a helper class in the Jackson library.
                2. It helps to convert JSON to Java objects and vice versa.
                3. For merging the patch payload with existing object: `objectMapper.updateValue(tempEmployee, patchPayload);`
            - Raw manual JSON merge (OUTDATED)
                
                ```java
                private Employee apply(Map<String, Object> patchPayload, Employee tempEmployee) { 
                	// Convert employee object to a JSON object node
                	ObjectNode employeeNode = objectMapper.convertValue(tempEmployee, ObjectNode.class);
                	// Convert the patchPayload map to a JSON object node
                	ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);
                	// Merge the patch updates into the employee node
                	employeeNode.setAll(patchNode);
                	// Return after converting JSON ojbect node to Employee object
                	return objectMapper.convertValue(employeeNode, Employee.class);
                }
                ```
                
        12. **Spring Data JPA:**
            1. **JPA repository** is the high-level abstraction over the Entity manager of Jakarta Persistence API(JPA).
            2. By extending `JpaRepository`, CRUD operations can be used without implementing their DAOs.
            3.  The interface will be like this: 
                
                `public interface RepositoryClass extends JpaRepository<Entity_type, Primary_key_type>`
                
            4. **CRUD operation using JpaRepository**: 
                1. `jpaRepository.save(EntityClass)`: To save/update the data; it returns **EntityClass** object.
                2. `jpaRepository.findById(id)` and `jpaRepository.findAll()`: To fetch data; it returns **Optional<EntityClass>**.
                3. `jpaRepository.deleteById(id)` or `jpaRepository.delete(EntityClass)`: To delete data; returns **void**.
        13. **Spring Data REST:**
            1. **Spring Data Rest** automatically exports the JPA repositories as REST endpoints.
            2. It generates the endpoint’s paths based on the plural form of the **Entity class name**. So, if the name of the entity class is `EmployeeEntity` then the endpoint path will be [http://localhost:8082/employeeEntities](http://localhost:8082/employees).
            3. The default naming convention of the path in Spring Data Rest can be changed by adding this: `@RepositoryRestResource(path = "employees")` in the **repository interface**.
            4. To set a **global prefix** to all REST API endpoints, add this in the properties file, `spring.data.rest.base-path = /employees`.
            5. **Pagination:** Each response is divided into pages, and by default, each page is of size 20. For **navigation** through pages: [http://localhost:8082/api/employees?page=0&size=10](http://localhost:8082/api/employees?page=0&size=10) (**pages start from 0, and page size can be changed**)
            6. Default and maximum page size can be changed by `spring.data.rest.default-page-size = 10` and `spring.data.rest.max-page-size = 10`.
            7. **Sorting** can be done by putting the following in the URL:
                1. [http://localhost:8082/api/employees?sort=lastName](http://localhost:8082/api/employees?page=0&size=10) : Sorts by last name(asc order by default).
                2. [http://localhost:8082/api/employees?sort=firstName,desc](http://localhost:8082/api/employees?page=0&size=10) : Sorts by first name(in desc order).
                3. [http://localhost:8082/api/employees?sort=firstName,lastName,desc](http://localhost:8082/api/employees?page=0&size=10) : Sorts by first name then last name in descending order.
        14. **Springdoc-OpenAPI and Swagger UI (Separate open-source project)**:
            1. Springdoc OpenAPI automatically generates OpenAPI **documentation** from the existing codes and annotations, and generate Swagger UI for accessing **endpoints in browser**.
            2. Dependency needed to be added from here: https://springdoc.org/#getting-started (Official Doc).
            3. Can access the Swagger UI from here here: [http://localhost:8082/swagger-ui/index.html](http://localhost:8082/swagger-ui/index.html). And  for custom path for the UI in properties file: `springdoc.swagger-ui.path=/employee.html` .
            4. API documentation can be accessed from: [http://localhost:8082/v3/api-docs](http://localhost:8082/v3/api-docs). And for custom path: `springdoc.api-docs.path=/documentation` URL will be like: [http://localhost:8082/documentation](http://localhost:8082/documentation).
    
    ---
    
    - **Spring Boot REST API Security** [(Spring Security official doc)](https://docs.spring.io/spring-security/reference/index.html)
        1. By adding **Spring Security dependency**, the endpoints will get secured with a **default** username(user) and password(gets generated in the console).
        2. The default username and password can be overridden by adding `spring.security.user.name=abc` and `spring.security.user.password=xyz` in the properties file.
        3. `InMemoryUserDetailsManager` is an implimentation of `UserDetailsManager` that keep all the user information about usernames, passwords, roles in the **memory** during the application lifetime. **(NOT used for production. In production `UserDetailsService` is used).**
        4. **After mentioning users** in the security configuration class, the username and password from the properties file will **NOT** be considered.
        5. **CSRF(Cross-Site Request Forgery) attack** took advantage of how browser handles token automatically:
            1. A **malicious site** sends a request on the user’s behalf to another site where the user is **logged in**.
            2. The request will be send without the consent of the user.
            3. The request will be treated as if you made it because the browser adds session cookie automatically.
        6. **Spring Security** by default uses **CSRF token mechanism**:
            1. When loding the form page it sends a **unique and random** token stored in the session.
            2. The token needs to be **manually included** with any request that changes data.
            3. Malicious site can’t know the token as it is **stored in the server-side session**.
        7. CSRF protection is **disable in case of REST API** as no session stored on the server (**stateless**).
        8. **BCrypt in** Spring Boot:
            1. It adds **salt** to the password. **Salt** is a random value added to each password before hashing.
            2. Then is repeatedly hashes the **combination(password+salt)**. The number of hashes are 2^10=**1024 times(default)**.
    
    ---
    
    - **Spring MVC with Thymeleaf** [(Thymeleaf offical doc)](https://www.thymeleaf.org/doc/tutorials/3.1/usingthymeleaf.html)
        1. **Thymeleaf** is a modern server-side Java **template engine** for web. It allows to bind data from Spring backend directly to the HTML.
        2. To see the **Request method** and **Request body** in the developers tool:
            
            **Developers Tool → Network Tab → Headers Section**(For request method & more) **↔ Payload Section**(For request body)
            
        3. Validation annotations for **Spring Bean Validation API:** (For more annotations click [here(gfg)](https://www.geeksforgeeks.org/spring-bean-validation-jsr-303-annotations/) or [here(baeldung)](https://www.baeldung.com/spring-boot-bean-validation))
            
            
            | **Annotations** | **Description** |
            | --- | --- |
            | `@NotNull` | Check if the annotated value is null |
            | `@Min` | Number must be ≥ value |
            | `@Max` | Number must be ≤ value |
            | `@Size` | Size must match the given size |
            | `@Pattern` | Must match a regular expression pattern |
            | `@Future`/ `@Past`  | Date must be future/past of given date |
            - Practical implimentations of majorly used validation annotations in Entity/DTO(Model) class: ⤵️
                
                ```java
                import jakarta.validation.constraints.*;
                import java.time.LocalDate;
                import java.util.List;
                
                public class UserDTO {
                
                    @NotNull(message = "Id is required")
                    private Long id;
                
                    @NotBlank(message = "Name must not be blank")
                    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
                    private String name;
                
                    @Email(message = "Invalid email format")
                    @NotEmpty(message = "Email must not be empty")
                    private String email;
                
                    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
                    private String phone;
                
                    @Min(value = 18, message = "Age must be at least 18")
                    @Max(value = 60, message = "Age must be no more than 60")
                    private Integer age;
                
                    @AssertTrue(message = "Terms must be accepted")
                    private Boolean acceptedTerms;
                
                    @Past(message = "Date of birth must be in the past")
                    private LocalDate dob;
                
                    @Future(message = "Subscription end date must be in the future")
                    private LocalDate subscriptionEndDate;
                
                    @NotNull
                    @Size(min = 1, message = "At least one role must be specified")
                    private List<@NotBlank String> roles;
                
                    @Digits(integer = 5, fraction = 2, message = "Balance must be a number with up to 5 digits and 2 decimal places")
                    private Double balance;
                
                    @Positive(message = "Score must be a positive number")
                    private Integer score;
                
                    @PositiveOrZero(message = "Discount must be zero or positive")
                    private Double discount;
                
                    @Negative(message = "Loss must be a negative value")
                    private Double loss;
                
                    @NegativeOrZero(message = "Debt must be zero or less")
                    private Double debt;
                    
                    @Size(min = 8, message = "Password must be at least 8 characters")
                    private String password;
                
                    // Getters and Setters
                }
                ```
                
        4. Difference between `@NotNull`, `@NotEmpty`, `@NotBlank` :
            
            
            | Annotation | Disallows `null` | Disallows `""` | Disallows `" "` | Disallows empty Collections | Use Case |
            | --- | --- | --- | --- | --- | --- |
            | `@NotNull` | ✅ Yes | ❌ No | ❌ No | ❌ No | Field must not be null. |
            | `@NotEmpty` | ✅ Yes | ✅ Yes | ❌ No | ✅ Yes | Collection must not be empty. |
            | `@NotBlank` | ✅ Yes | ✅ Yes | ✅ Yes | ❌ N/A (only Strings) | String must contain characters. |
        5. `@Valid` tells Spring MVC to perform **validation** and **bind** the validation result using `BindingResult`.
        6. Custom error messages in validation:
            1. What type of error is occured during validation can be seen in the console by printing binding result. E.g., `System.out.println("\n\n\nBinding Result: "+bindingResult+"\n\n");`.
            2. That error codes can be overriden using custom message in the messages.properties file inside resources folder. E.g., `typeMismatch.customer.empID=Invalid number`.
        7. 
    
    ---
    
</aside>

<aside>
<img src="https://www.notion.so/icons/arrow-right_gray.svg" alt="https://www.notion.so/icons/arrow-right_gray.svg" width="40px" />

**10. Spring MVC-request params, request mappings, path variable**

</aside>

<aside>
<img src="https://www.notion.so/icons/arrow-right_gray.svg" alt="https://www.notion.so/icons/arrow-right_gray.svg" width="40px" />

**11. Spring rest-JSON data binding, spring rest control, retrieve POJOs, using path variables for rest endpoints, exception handling)**

</aside>

<aside>
<img src="https://www.notion.so/icons/arrow-right_gray.svg" alt="https://www.notion.so/icons/arrow-right_gray.svg" width="40px" />

**12. Hibernate - crud operations, eager vs lazy loading, hibernate mappings**

</aside>

<aside>
<img src="https://www.notion.so/icons/arrow-right_gray.svg" alt="https://www.notion.so/icons/arrow-right_gray.svg" width="40px" />

**13. Spring data JPA and spring data rest - configurations, pagination, sorting**

</aside>

<aside>
<img src="https://www.notion.so/icons/arrow-right_gray.svg" alt="https://www.notion.so/icons/arrow-right_gray.svg" width="40px" />

**14. Spring AOP - before read advice type. Pointcut expressions, pointcut declarations, ordering aspects, join points, advice types**

</aside>

<aside>
<img src="https://www.notion.so/icons/arrow-right_gray.svg" alt="https://www.notion.so/icons/arrow-right_gray.svg" width="40px" />

**15. Spring security- authentication and authorization, auth 2.0, JWT token, CORS, CSRF, user roles**

</aside>

<aside>
<img src="https://www.notion.so/icons/arrow-right_gray.svg" alt="https://www.notion.so/icons/arrow-right_gray.svg" width="40px" />

**16. Learn unit testing - test driven development**

</aside>

<aside>
<img src="https://www.notion.so/icons/arrow-right_gray.svg" alt="https://www.notion.so/icons/arrow-right_gray.svg" width="40px" />

**17. JUNIT and Mockito**

</aside>

<aside>
<img src="https://www.notion.so/icons/arrow-right_gray.svg" alt="https://www.notion.so/icons/arrow-right_gray.svg" width="40px" />

**18. Springboot - spring boot dev tools, spring boot actuator, Redis with spring boot, Kafka with spring boot**

</aside>

</aside>

<aside>
<img src="https://www.notion.so/icons/error_green.svg" alt="https://www.notion.so/icons/error_green.svg" width="40px" />

**19. This is enough.. but there is spring cloud, microservices and HLD are also might be important. These can be learned as I go.**

</aside>