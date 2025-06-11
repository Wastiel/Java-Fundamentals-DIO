package HerancaPolimorfismo;

public class Main {

    public static void main(String[] args){

        Employee manager = new Manager();

        printEmployee(new Manager());
        printEmployee(new Salesman());
    }

    public static void printEmployee(Employee employee){

        System.out.printf("-----%s-----\n", employee.getClass().getCanonicalName());
        if(employee instanceof Manager manager) {


        }

        switch (employee){
            case Manager manager ->{
                manager.setCode("123");
                manager.setName("João");
                manager.setSalary(5000);
                manager.setLogin("joao");
                manager.setPassword("123456");
                manager.setCommission(15);;

                System.out.println(manager.getCode());
                System.out.println(manager.getSalary());
                System.out.println(manager.getName());
                System.out.println(manager.getCommission());
                System.out.println(manager.getLogin());
                System.out.println(manager.getPassword());
            }
            case Salesman salesman ->{
                salesman.setCode("123");
                salesman.setName("Lucas");
                salesman.setSalary(2800);
                salesman.setPercentPerSold(10);
                salesman.setSouldAmount(1000);

                System.out.println(salesman.getCode());
                System.out.println(salesman.getSalary());
                System.out.println(salesman.getName());
                System.out.println(salesman.getPercentPerSold());
            }
        }
        System.out.println(employee.getFullSalary());
        System.out.println("----------");
    }
}
