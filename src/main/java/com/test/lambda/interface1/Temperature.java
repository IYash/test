package com.test.lambda.interface1;

/**
 * @author huangchangling on 2017/7/14 0014
 */
public class Temperature {

    private Degree degree;

    public Temperature(Degree degree) {
        this.degree = degree;
    }

    public void describe(){

        switch(degree){

            case NOT:
                System.out.println("can accept"); break;
            case NORMAL:
                System.out.println("a little hot"); break;
            case HOT:
                System.out.println("boiling...");break;
            default:
                System.out.println("should be cool");
        }
    }

    public static void main(String[] args) {

        Temperature t = new Temperature(Degree.HOT);

        t.describe();

    }
}
