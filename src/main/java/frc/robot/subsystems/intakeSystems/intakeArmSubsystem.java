package frc.robot.subsystems.intakeSystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class intakeArmSubsystem extends SubsystemBase {
    private CANSparkMax motorArmLeft = new CANSparkMax(11, MotorType.kBrushless);
    private RelativeEncoder motorRelative = motorArmLeft.getEncoder();
    private SparkPIDController m_PidController = motorArmLeft.getPIDController();
    private double desiredPosition;
    public intakeArmSubsystem(){
        m_PidController.setP(0.0800);
        m_PidController.setI(0);
        m_PidController.setD(0.0060);
        motorRelative.setPosition(0);
    }
    public void setIntakeArmPosition(double desiredPosition){
        this.desiredPosition = desiredPosition;
        m_PidController.setReference(desiredPosition, ControlType.kPosition); 
        
    }
}
