import java.util.Scanner;

/* Product - Motor */
abstract class Motor {

    String model;
    long power;

    public Motor(String model, long power) {
        this.model = model;
        this.power = power;
    }

    @Override
    public String toString() {
        return "motor={model:" + model + ",power:" + power + "}";
    }
}

class PneumaticMotor extends Motor {

    public PneumaticMotor(String model, long power) {
        super(model, power);
    }

    public String toString() {
        return "Pneumatic " + super.toString();
    }
}

class HydraulicMotor extends Motor {

    public HydraulicMotor(String model, long power) {
        super(model, power);
    }

    public String toString() {
        return "Hydraulic " + super.toString();
    }
}

class ElectricMotor extends Motor {

    public ElectricMotor(String model, long power) {
        super(model, power);
    }

    public String toString() {
        return "Electric " + super.toString();
    }
}

class WarpDrive extends Motor {

    public  WarpDrive(String model, long power) {
        super(model, power);
    }

    public String toString() {
        return "WarpDrive " + super.toString();
    }
}

class MotorFactory {

    /**
     * It returns an initialized motor according to the specified type by the first character:
     * 'P' or 'p' - pneumatic, 'H' or 'h' - hydraulic, 'E' or 'e' - electric, 'W' or 'w' - warp.
     */
    public static Motor make(char type, String model, long power) {
        return orderMotor(type, model, power);
    }

    private static Motor orderMotor(char type, String model, long power) {
        Motor motor;
        char t = Character.toUpperCase(type);
        switch (t) {
            case 'P':
                motor = new PneumaticMotor(model, power);
                break;
            case 'H':
                motor = new HydraulicMotor(model, power);
                break;
            case 'E':
                motor = new ElectricMotor(model, power);
                break;
            case 'W':
                motor = new WarpDrive(model, power);
                break;
            default: {
                motor = null;
            }
        }
        return motor;
    }
}

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final char type = scanner.next().charAt(0);     
        final String model = scanner.next();
        final long power = scanner.nextLong();
        Motor motor = MotorFactory.make(type, model, power);
        scanner.close();
       System.out.println(motor);
    }
}