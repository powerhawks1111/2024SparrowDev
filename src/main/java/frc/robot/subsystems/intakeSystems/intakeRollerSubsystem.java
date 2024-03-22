package frc.robot.subsystems.intakeSystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class intakeRollerSubsystem extends SubsystemBase {
    private CANSparkMax rightRollerMotor = new CANSparkMax(15, MotorType.kBrushless);
    private CANSparkMax leftRollerMotor = new CANSparkMax(14, MotorType.kBrushless);
    private double speed = 1;
    private double ampLimited = 10; 
    public void setMotor(double speed){
        rightRollerMotor.set(speed);
        leftRollerMotor.set(speed);
    }
    public void activateRollers(boolean determiner){
        if (determiner){
            setMotor(speed);
        }else{
            setMotor(0);
        }
    }
    public CANSparkMax[] getMotors(){
        return new CANSparkMax[]{rightRollerMotor,leftRollerMotor};
    }
}
