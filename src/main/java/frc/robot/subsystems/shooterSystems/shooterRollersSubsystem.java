package frc.robot.subsystems.shooterSystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class shooterRollersSubsystem extends SubsystemBase {
    CANSparkMax upwardMotorRight = new CANSparkMax(10, MotorType.kBrushless); 
    CANSparkMax upwardMotorRightAbove = new CANSparkMax(36, MotorType.kBrushless);
    CANSparkMax upwardMotorLeft = new CANSparkMax(45, MotorType.kBrushless);
    CANSparkMax shooterMotorLeft = new CANSparkMax(25, MotorType.kBrushless);
    CANSparkMax shooterMotorRight = new CANSparkMax(16, MotorType.kBrushless);
    private double shooterSpeed = 1;
    private double ampLimit = 5; // ideal 5 for perfect nodes
    public void setShooterMotors(double speed){
        shooterMotorLeft.set(speed);
        shooterMotorRight.set(-speed);
    }
    public void activateShooter(boolean determiner){
        if (determiner){
            setShooterMotors(shooterSpeed);
        }else{
            setShooterMotors(0);
        }
    }
    public void setIndexMotors(double indexMotorSpeed){
        upwardMotorRight.set(indexMotorSpeed);
        upwardMotorRightAbove.set(indexMotorSpeed);
        upwardMotorLeft.set(-indexMotorSpeed);
    }
    public CANSparkMax[] getMotors(){
        return new CANSparkMax[]{upwardMotorLeft, upwardMotorRight};
    }
}
