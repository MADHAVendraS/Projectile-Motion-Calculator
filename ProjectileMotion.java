import java.math.MathContext;
import java.util.Scanner;
//import java.lang.Math;

public class ProjectileMotion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ProjectileMotion pm = new ProjectileMotion();

        System.out.println("Software for solving problems based on projectile motion");
        for(;;)
        {
            //SELECTION OF TYPE OF PROJECTILE MOTION USING THE ALLOCATED INDEX
            System.out.println("Select type of projection involved in the question");
            System.out.println("1: Inclined projection from ground.");
            System.out.println("2: Horizontal projection from some height 'H'.");
            System.out.println("3: Inclined projection from some height 'H'.");
            System.out.println("4: Inclined projection on inclined surface");
            System.out.println("0: Exit\n");
            System.out.println("Enter input: ");
            int start = scan.nextInt();
            if(start == 0)
            {
                break;
            }
            switch(start)
            {
                case 1 : pm.groundProjection();
                break;
                case 2 : pm.horizontalProjection();
                break;
                case 3 : pm.incHeightProjection();
                break;
                case 4 : pm.inclinedSurfaceProjection();
                break;
                default :
                    System.out.println("Enter valid input");
            }
        }
    }
    void groundProjection()
    {
        final double g = 9.8;  // ACCELERATION DUE TO GRAVITY
        double V = 0;         // VELOCITY
        double O = 0;        // ANGLE OF PROJECTION
        double R = 0;       // HORIZONTAL RANGE OF PROJECTION
        double T = 0;      // TIME OF FLIGHT
        double H = 0;     // MAXIMUM HEIGHT OF PROJECTION
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number to provide values of the any '2' quantities given: ");
        System.out.println("1: Velocity");
        System.out.println("2: Angle of projection");
        System.out.println("3: Horizontal range");
        System.out.println("4: Time of flight");
        System.out.println("5: Maximum height of projection ");
        System.out.println("0: Exit");
        int count = 0;
        for(;;)
        {
            System.out.println("Enter input: ");
            int input = scan.nextInt();
            if(input==0)
            {
                break;
            }
            // TAKING INPUT OF VALUES OF QUANTITIES GIVEN IN THE QUESTION
            switch(input)
            {
                case 1 :
                    System.out.print("Enter value of velocity in m/s: ");
                    V = scan.nextDouble();
                    count++;
                    break;
                case 2 :
                    System.out.print("Enter value of Angle of projection in degrees: ");
                    O = scan.nextDouble();
                    count++;
                    break;
                case 3 :
                    System.out.print("Enter value of horizontal range in metres: ");
                    R = scan.nextDouble();
                    count++;
                    break;
                case 4 :
                    System.out.print("Enter value of Time of flight in seconds");
                    T = scan.nextDouble();
                    count++;
                    break;
                case 5 :
                    System.out.print("Enter value of Maximum height of projection in metres");
                    H = scan.nextDouble();
                    count++;
                    break;
                default :
                    System.out.println("Enter valid input");
            }
            if(count == 2)
            {
                break;
            }
        }

                if (O != 0 && V != 0)
                {
                    double ORad = Math.toRadians(O);
                    H = (V * V * Math.sin(O) * Math.sin(ORad)) / (2 * g);
                    R = (V * V * Math.sin(2 * ORad)) / g;
                    T = (2 * V * Math.sin(ORad)) / g;
                    System.out.println("Enter serial no. to get the desired output: ");
                    System.out.println("1: Maximum height of projection");
                    System.out.println("2: Total time of flight");
                    System.out.println("3: Horizontal range of projection\n0: Exit");
                    for(;;)
                    {
                        System.out.println("Enter input");
                        int inp = scan.nextInt();
                        switch(inp)
                        {
                            case 1: System.out.println("Maximum height of projection is : " + (float) H + "m");
                                break;
                            case 2: System.out.println("Total time of flight is : " + (float)  T + "s");
                                break;
                            case 3: System.out.println("Horizontal range of projection is  : " + (float) R + "m");
                                break;
                            default: System.out.println("Invalid choice!!");
                        }
                        if(inp == 0)
                        {
                            System.out.println();
                            break;
                        }
                    }
                }
                else if(V != 0 && T != 0)
                {
                    double x = T*g/(2*V);
                    double angleR = Math.asin(x);
                    H = (V * V * Math.sin(angleR) * Math.sin(angleR)) / (2 * g);
                    R = (V * V * Math.sin(2 * angleR)) / g;
                    System.out.println("Enter serial no. to get the desired output: ");
                    System.out.println("1: Maximum height of projection");
                    System.out.println("2: Horizontal range of projection");
                    System.out.println("3: Angle of projection\n0:Exit");
                    for(;;)
                    {
                        System.out.println("Enter input");
                        int inp = scan.nextInt();
                        switch(inp)
                        {
                            case 1: System.out.println("Maximum height of projection is : " + (float) H + "m");
                                break;
                            case 2:System.out.println("Horizontal range of projection is  : " + (float) R + "m");
                                break;
                            case 3: System.out.println("Angle of projection is  : " + (float) Math.toDegrees(angleR) + " degree");
                                break;
                            default: System.out.println("Invalid choice!!");
                        }
                        if(inp == 0)
                        {
                            System.out.println();
                            break;
                        }
                    }
                }
                else if(V != 0 && H != 0)
                {
                    double angleR = Math.asin(Math.sqrt(H*2*g/(V*V)));
                    R = (V * V * Math.sin(2 * angleR)) / g;
                    T = (2 * V * Math.sin(angleR)) / g;
                    System.out.println("Enter serial no. to get the desired output: ");
                    System.out.println("1: Total time of flight");
                    System.out.println("2: Horizontal range of projection");
                    System.out.println("3: Angle of projection\n0:Exit");
                    for(;;)
                    {
                        System.out.println("Enter input");
                        int inp = scan.nextInt();
                        switch(inp)
                        {
                            case 1: System.out.println("Total time of flight is : " + (float) T + "s");
                                break;
                            case 2:System.out.println("Horizontal range of projection is  : " + (float) R + "m");
                                break;
                            case 3: System.out.println("Angle of projection is  : " + (float) Math.toDegrees(angleR) + " degree");
                                break;
                            default: System.out.println("Invalid choice!!");
                        }
                        if(inp == 0)
                        {
                            System.out.println();
                            break;
                        }
                    }
                }
                else if(V != 0 && R != 0)
                {
                    double angleR = Math.asin(R*g/(V*V))/2;
                    T = (2*V*Math.sin(angleR))/g;
                    H = (V * V * Math.sin(angleR) * Math.sin(angleR)) / (2 * g);
                    System.out.println("Enter serial no. to get the desired output: ");
                    System.out.println("1: Total time of flight");
                    System.out.println("2: Maximum height of projection of projection");
                    System.out.println("3: Angle of projection\n0:Exit");
                    for(;;)
                    {
                        System.out.println("Enter input");
                        int inp = scan.nextInt();
                        switch(inp)
                        {
                            case 1: System.out.println("Total time of flight is : " + (float) T + "s");
                                break;
                            case 2: System.out.println("Maximum height of projection is : " + (float) H + "m");
                                break;
                            case 3: System.out.println("Angle of projection is  : " + (float) Math.toDegrees(angleR) + " degree");
                                break;
                            default: System.out.println("Invalid choice!!");
                        }
                        if(inp == 0)
                        {
                            System.out.println();
                            break;
                        }
                    }
                }
                else if(H != 1 && R != 0)
                {
                    double angleR = Math.atan(4*H/R);
                    T = (2 * V * Math.sin(angleR)) / g;
                    V = Math.sqrt(R*g/Math.sin(2*angleR));
                    System.out.println("Enter serial no. to get the desired output: ");
                    System.out.println("1: Total time of flight");
                    System.out.println("2: Initial velocity of projection");
                    System.out.println("3: Angle of projection\n0:Exit");
                    for(;;)
                    {
                        System.out.println("Enter input");
                        int inp = scan.nextInt();
                        switch(inp)
                        {
                            case 1: System.out.println("Total time of flight is : " + (float) T + "s");
                                break;
                            case 2: System.out.println("Initial velocity of projection is : "+V+" m/s");
                                break;
                            case 3: System.out.println("Angle of projection is  : " + (float) Math.toDegrees(angleR) + " degree");
                                break;
                            default: System.out.println("Invalid choice!!");
                        }
                        if(inp == 0)
                        {
                            System.out.println();
                            break;
                        }
                    }
                }
            }

    void horizontalProjection()
    {
        Scanner scan = new Scanner(System.in);
        final double g = 9.8;  // ACCELERATION DUE TO GRAVITY
        double V = 0;      // VELOCITY
        double R = 0;      // HORIZONTAL RANGE OF PROJECTION
        double T = 0;      // TIME OF FLIGHT
        double H = 0;      // MAXIMUM HEIGHT OF PROJECTION
        int count = 0;
        System.out.println("Enter the number to provide values of the any '2' quantities given: \n");
        System.out.println("1: Velocity");
        System.out.println("2: Horizontal range");
        System.out.println("3: Time of flight");
        System.out.println("4: Height of projection");
        System.out.println("0: Exit");
        for(;;)
        {
            System.out.print("Enter serial number of variable to give input : ");
            int input = scan.nextInt();
            if(input==0)
            {
                break;
            }
            // TAKING INPUT OF VALUES OF QUANTITIES GIVEN IN THE QUESTION
            switch(input)
            {
            case 1 :
                System.out.print("Enter value of velocity in m/s: ");
                V = scan.nextDouble();
                count++;
                break;
            case 2 :
                System.out.print("Enter value of horizontal range in metres: ");
                R = scan.nextDouble();
                count++;
                break;
            case 3 :
                System.out.print("Enter value of Time of flight in seconds");
                T = scan.nextDouble();
                count++;
                break;
            case 4 :
                System.out.print("Enter value of Maximum height of projection in metres");
                H = scan.nextDouble();
                count++;
                break;
            default :
                System.out.println("Enter valid input");
            }
            if(count == 2)
            {
                break;
            }
        }
        if(V != 0 && H !=0)
        {
            T = Math.sqrt(2*H/g);
            R = V*T;
            System.out.println("Enter serial no. to get the desired output: ");
            System.out.println("1: Total time of flight");
            System.out.println("2: Horizontal range of projection\n0: Exit");
            for(;;)
            {
                System.out.println("Enter input");
                int inp = scan.nextInt();
                switch(inp)
                {
                    case 1: System.out.println("Total time of flight is : " + (float) T + "s");
                        break;
                    case 2: System.out.println("Horizontal range of projection is  : " + (float) R + "m");
                        break;
                    default: System.out.println("Invalid choice!!");
                }
                if(inp == 0)
                {
                    System.out.println();
                    break;
                }
            }
        }
        else if(V != 0 && R != 0)
        {
            T = R/V;
            H = T*T*g/2;
            System.out.println("Enter serial no. to get the desired output: ");
            System.out.println("1: Total time of flight");
            System.out.println("2: Maximum height of projection\n0: Exit");
            for(;;)
            {
                System.out.println("Enter input");
                int inp = scan.nextInt();
                switch(inp)
                {
                    case 1: System.out.println("Total time of flight is : " + (float) T + "s");
                        break;
                    case 2: System.out.println("Height of projection is : " + (float) H + "m");
                        break;
                    default: System.out.println("Invalid choice!!");
                }
                if(inp == 0)
                {
                    System.out.println();
                    break;
                }
            }
        }
        else if(V != 0 && T != 0)
        {
            H = T*T*g/2;
            R = V*T;
            System.out.println("Enter serial no. to get the desired output: ");
            System.out.println("1: Horizontal range of projection");
            System.out.println("2: Maximum height of projection\n0: Exit");
            for(;;)
            {
                System.out.println("Enter input");
                int inp = scan.nextInt();
                switch(inp)
                {
                    case 1: System.out.println("Horizontal range of projection is  : " + (float) R + "m");
                        break;
                    case 2: System.out.println("Height of projection is : " + (float) H + "m");
                        break;
                    default: System.out.println("Invalid choice!!");
                }
                if(inp == 0)
                {
                    System.out.println();
                    break;
                }
            }
        }
        else if(T != 0 && R != 0)
        {
            V = R/T;
            H = T*T*g/2;
            System.out.println("Enter serial no. to get the desired output: ");
            System.out.println("1: Initial velocity of projection");
            System.out.println("2: Maximum height of projection\n0: Exit");
            for(;;)
            {
                System.out.println("Enter input");
                int inp = scan.nextInt();
                switch(inp)
                {
                    case 1: System.out.println("Initial velocity of projection is : " + (float) V + "m");
                        break;
                    case 2: System.out.println("Height of projection is : " + (float) H + "m");
                        break;
                    default: System.out.println("Invalid choice!!");
                }
                if(inp == 0)
                {
                    System.out.println();
                    break;
                }
            }
        }
    }
    void incHeightProjection()
    {
        final double g = 9.8;
        double V = 0;
        double O = 0;
        double R = 0;
        double T = 0;
        double H = 0;
        double h = 0;
        int count = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number to provide values of the any '3' quantities given: \n");
        System.out.println("1: Velocity");
        System.out.println("2: Angle of projection");
        System.out.println("3: Horizontal range");
        System.out.println("4: Time of flight");
        System.out.println("5: Maximum height of projection");
        System.out.println("6: Height of projectile");
        System.out.println("0: Exit");
        for(;;)
        {
            System.out.print("Enter serial number of variable to give input : ");
            int input = scan.nextInt();
            if(input==0)
            {
                break;
            }
            // TAKING INPUT OF VALUES OF QUANTITIES GIVEN IN THE QUESTION
            switch(input)
            {
                case 1 :
                    System.out.print("Enter value of velocity in m/s: ");
                    V = scan.nextDouble();
                    count++;
                    break;
                case 2 :
                    System.out.print("Enter value of Angle of projection in degrees: ");
                    O = scan.nextDouble();
                    count++;
                    break;
                case 3 :
                    System.out.print("Enter value of horizontal range in metres: ");
                    R = scan.nextDouble();
                    count++;
                    break;
                case 4 :
                    System.out.print("Enter value of Time of flight in seconds");
                    T = scan.nextDouble();
                    count++;
                    break;
                case 5 :
                    System.out.print("Enter value of Maximum height of projection in metres");
                    H = scan.nextDouble();
                    count++;
                    break;
                case 6 :
                    System.out.print("Enter value of height of projection : ");
                    h = scan.nextDouble();
                    count++;
                default :
                    System.out.println("Enter valid input");
            }
            if(count == 3)
            {
                break;
            }
        }
        if(V!=0 && h!=0 && O!=0)
        {
            double ORad = Math.toRadians(O);
            H = h + (V * V * Math.sin(ORad) * Math.sin(ORad)) / (2 * g);
            T = (V * Math.sin(ORad)) / g +  Math.sqrt(2*H/g);
            R = (V * V * Math.sin(2 * ORad)) /(2*g) + V*Math.cos(ORad)*T;
            System.out.println("Enter serial no. to get the desired output: ");
            System.out.println("1: Horizontal range of projection");
            System.out.println("2: Total time of flight");
            System.out.println("3: Maximum height of projection from ground\n0: Exit");

            for(;;)
            {
                System.out.println("Enter input");
                int inp = scan.nextInt();
                switch(inp)
                {
                    case 1: System.out.println("Horizontal range of projection is  : " + (float) R + "m");
                        break;
                    case 2: System.out.println("Total time of flight is : " + (float) T + "s");
                        break;
                    case 3: System.out.println("Maximum height of projection from ground is : " + (float) H + "m");
                        break;
                    default: System.out.println("Invalid choice!!");
                }
                if(inp == 0)
                {
                    System.out.println();
                    break;
                }
            }
        }
        else if(V!=0 && h!=0 && H!=0)
        {
            O = Math.asin(Math.sqrt((H-h)*2*g/(V*V)));
            T = (V * Math.sin(O)) / g +  Math.sqrt(2*H/g);
            R = (V * V * Math.sin(2 * O)) /(2*g) + V*Math.cos(O)*T;
            System.out.println("Enter serial no. to get the desired output: ");
            System.out.println("1: Horizontal range of projection");
            System.out.println("2: Total time of flight");
            System.out.println("3: Angle of projection\n0: Exit");

            for(;;)
            {
                System.out.println("Enter input");
                int inp = scan.nextInt();
                switch(inp)
                {
                    case 1: System.out.println("Horizontal range of projection is  : " + (float) R + "m");
                        break;
                    case 2: System.out.println("Total time of flight is : " + (float) T + "s");
                        break;
                    case 3: System.out.println("Angle of projection is : "+ Math.toDegrees(O)+" degrees");
                        break;
                    default: System.out.println("Invalid choice!!");
                }
                if(inp == 0)
                {
                    System.out.println();
                    break;
                }
            }
        }
    }
    void inclinedSurfaceProjection()
    {
        final double g = 9.8;
        double V = 0;
        double O = 0;
        double H = 0;
        double T = 0;
        double R = 0;
        double X = 0;
        int count = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number to provide values of the quantities given: \n");
        System.out.println("1: Velocity");
        System.out.println("2: Angle of projection");
        System.out.println("3: Horizontal range");
        System.out.println("4: Time of flight");
        System.out.println("5: Maximum height of projection");
        System.out.println("6: Inclination of plane");
        System.out.println("0: Exit");
        for(;;)
        {
            System.out.print("Enter serial number of variable to give input : ");
            int input = scan.nextInt();
            if(input==0)
            {
                break;
            }
            // TAKING INPUT OF VALUES OF QUANTITIES GIVEN IN THE QUESTION
            switch(input)
            {
                case 1 :
                    System.out.print("Enter value of velocity in m/s: ");
                    V = scan.nextDouble();
                    count++;
                    break;
                case 2 :
                    System.out.print("Enter value of Angle of projection in degrees: ");
                    O = scan.nextDouble();
                    count++;
                    break;
                case 3 :
                    System.out.print("Enter value of horizontal range in metres: ");
                    R = scan.nextDouble();
                    count++;
                    break;
                case 4 :
                    System.out.print("Enter value of Time of flight in seconds");
                    T = scan.nextDouble();
                    count++;
                    break;
                case 5 :
                    System.out.print("Enter value of Maximum height of projection in metres");
                    H = scan.nextDouble();
                    count++;
                    break;
                default :
                    System.out.println("Enter valid input");
            }
            if(count == 3)
            {
                break;
            }
        }
        if(V!=0 && O!=0 && X!=0)
        {
            double ORad = Math.toRadians(O);
            double XRad = Math.toRadians(X);
            R = V*V*(1-Math.sin(XRad))/(g*Math.cos(XRad));
            H = V*V*Math.sin(ORad-XRad)*Math.sin(ORad-XRad)/(2*g);
            T = 2*V*Math.sin(ORad-XRad)/(g*Math.cos(XRad));
            System.out.println("Enter serial no. to get the desired output: ");
            System.out.println("1: Horizontal range of projection");
            System.out.println("2: Total time of flight");
            System.out.println("3: Maximum height of projection\n0: Exit");

            for(;;)
            {
                System.out.println("Enter input");
                int inp = scan.nextInt();
                switch(inp)
                {
                    case 1: System.out.println("Horizontal range of projection is  : " + (float) R + "m");
                        break;
                    case 2: System.out.println("Total time of flight is : " + (float) T + "s");
                        break;
                    case 3: System.out.println("Maximum height of projection is : " + (float) H + "m");
                        break;
                    default: System.out.println("Invalid choice!!");
                }
                if(inp == 0)
                {
                    System.out.println();
                    break;
                }
            }
        }
    }
}