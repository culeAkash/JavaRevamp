package reflection;

public class Eagle {
    public String breed;
    private boolean canSwim;

    private Eagle(){
        System.out.println("Constructor called for Eagle class");
    }

    public void fly(){
        System.out.println("fly");
    }

    private void eat(){
        System.out.println("eat");
    }
}
