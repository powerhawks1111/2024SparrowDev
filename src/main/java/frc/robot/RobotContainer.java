package frc.robot;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.commands.PathPlannerAuto;
import com.pathplanner.lib.path.PathPlannerPath;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.drive.Drive;
import frc.robot.commands.drive.resetNavx;
import frc.robot.commands.intakeCommands.intake;
import frc.robot.commands.shooterCommands.shoot;
import frc.robot.commands.shooterCommands.spoolShooter;
import frc.robot.subsystems.SwerveModule;
import frc.robot.subsystems.intakeSystems.intakeArmSubsystem;
import frc.robot.subsystems.intakeSystems.intakeRollerSubsystem;
import frc.robot.subsystems.shooterSystems.shooterArmSubsystem;
import frc.robot.subsystems.shooterSystems.shooterRollersSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
public class RobotContainer {
    //public final  AHRS navx = new AHRS();
    
    //public final Scheduler scheduler = new Scheduler();
    /**
     * ---------------------------------------------------------------------------------------
     * Subsystems
     * ---------------------------------------------------------------------------------------
     */
   // public final Drivetrain drivetrain = new Drivetrain();
    public final Drivetrain drivetrain = new Drivetrain();
    public DigitalInput m_condeDetector = new DigitalInput(9);
    public Joystick driveJoystick = new Joystick(0);
    
    public Joystick operatorJoystick = new Joystick(1);

    public static intakeArmSubsystem m_IntakeArmSubsystem = new intakeArmSubsystem();
     public static intakeRollerSubsystem m_IntakeRollerSubsystem = new intakeRollerSubsystem();
    public static shooterArmSubsystem m_ShooterArmSubsystem = new shooterArmSubsystem();
    public static shooterRollersSubsystem m_ShooterRollersSubsystem = new shooterRollersSubsystem();
  
    //public Joystick operatorJoystick = new Joystick(1);

  
  
    

    //XboxController exampleXbox = new XboxController(0); // 0 is the USB Port to be used as indicated on the Driver Station


    //public final IntakeSubsystem intakeSubsystem = new IntakeSubsystem(m_condeDetector);
    //public final DriveSubsystem driveSubsystem = new DriveSubsystem();
    

    
    
    //public Joystick operateJoystick = new Joystick(1);

    // public Trigger left = new JoystickButton(operateJoystick, 7);
    // public Trigger right = new JoystickButton(operateJoystick, 8);
    //public Trigger  intakeTrigger = new Trigger(new BooleanEvent(null, left));
        
    //public Trigger rightTrigger = new RightTrigger();

    //private final SendableChooser<Command> autoChooser;
   
    
            
   
    public RobotContainer () {
        configureButtonBindings();
       
        NamedCommands.registerCommand("ResetNavxFieldHeading", drivetrain.resetNavxMark(0));//if this offsets by 90, like forward is left or right, go into drivetrain and delete the part about initial angle, that may be the issue. 
       
        
        var alliance = DriverStation.getAlliance();

        new JoystickButton(operatorJoystick, 1).whileTrue(new intake(true));
        new JoystickButton(operatorJoystick, 1).whileFalse(new intake(false));
        new JoystickButton(operatorJoystick, 2).onTrue(new spoolShooter());
        new JoystickButton(operatorJoystick, 3).onTrue(new shoot());
  
                    
                        
                    

        

    }
    
    public void macGuyverDrive () {
        drivetrain.drive(0, 0.1, 0, true, false);
    }

    public void configureButtonBindings () { 
        drivetrain.drive(driveJoystick.getRawAxis(1), -driveJoystick.getRawAxis(0), -driveJoystick.getRawAxis(4), true, false);
        if (driveJoystick.getRawButton(4) == false) {
            drivetrain.drive(-driveJoystick.getRawAxis(1), driveJoystick.getRawAxis(0), driveJoystick.getRawAxis(4), true, false);
        
        } else {           
        
        }



        
        var alliance = DriverStation.getAlliance();
        

        }
        //shooter commands
        // new Shoot(m_shooterSubsystem, 0);
        // new JoystickButton(driveJoystick, 6).onFalse(new Shoot(m_shooterSubsystem, 0)); //runs the shoot motors, for the operator
        // new JoystickButton(driveJoystick, 7).onFalse(new Shoot(m_shooterSubsystem, 1)); //stops all three of the motors
        // new JoystickButton(driveJoystick, 4).onTrue(new Shoot(m_shooterSubsystem, 2)); //runs the index to feed the donut to the shooter


        // so far all of these are set up for a single controller
        

    // Set default/passive commands for each subsystem
    public void setDefaultCommands () {
        
        //drivetrain.setDefaultCommand(new Drive(drivetrain, driveJoystick));
        //ShooterSubsystem.setDefaultCommand(new Shoot(m_shooterSubsystem, 0));

    }

    // public Command driveAutoPath() {
        
    // return new PathPlannerAuto("autoOne");
     

        
    // }
}