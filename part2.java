//Kevin Funkhouser & Vishnu Murthy 11/7/18
import java.io.*;      //the File 
import java.util.*;    //the Scanner 
public class Projectile_Motion
{
   public static void main(String[] args) throws Exception
   {  
      double TIME_STEP = 0.0001;
      double c1 = -0.23919192;  //values of c1, c2, and g
      double c2 = 0.92292951;
      double g = 9.81;
      //Scanner sc = new Scanner(System.in);
      //System.out.print("Enter the height in meters: ");     //prompts user to input intial conditions
      double height = 0.43; //43 cm //sc.nextDouble();
      //System.out.print("Enter the speed in m/s: ");
      double speed = 6.85;//sc.nextDouble();
      //System.out.print("Enter the angle in radians: ");
      double angle = 0.733038;    //42 degrees //sc.nextDouble();
      
      double Vx = speed * Math.cos(angle);                  //calculates initial component velocities and initializes position & acceleration components
      double Vy = speed * Math.sin(angle);
      double Ay = 0;
      double Ax = 0;
      double x = 0;
      
      while(height > 0)                                     //while the ball is above the ground, iterate
      {
         System.out.println(x + "," + height);
         angle = Math.atan(Vy/Vx);
         speed = Math.sqrt(Math.pow(Vx,2)+Math.pow(Vy,2));
        
         height += Vy*TIME_STEP + .5*Ay*Math.pow(TIME_STEP, 2);
         x += Vx*TIME_STEP + .5*Ax*Math.pow(TIME_STEP, 2);
        
         Ax = -(c1*speed + c2*Math.pow(speed, 2)) * Math.cos(angle);
         Ay = -(c1*speed + c2*Math.pow(speed, 2)) * Math.sin(angle) - g;
         
         Vx += Ax * TIME_STEP;
         Vy += Ay * TIME_STEP;

         
        
      }
      System.out.print("The projectile will land " + x + " m in the x direction");

   }