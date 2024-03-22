package frc.robot.subsystems.shooterSystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DutyCycle;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class shooterArmSubsystem extends SubsystemBase {
    private CANSparkMax armMotor = new CANSparkMax(12, MotorType.kBrushless);
    private DutyCycle absoluteShooterEncoder = new DutyCycle(new DigitalInput(19));
    private PIDController m_ControllerArm = new PIDController(0.3000,0,0.0008); // 0.8000, 0, 0.0900
    private double desiredPosition  = 0.342916;
    public void positionArmShooter(double desiredPosition){
         this.desiredPosition = desiredPosition;
         m_ControllerArm.setTolerance(1);
    }
    @Override
    public void periodic() {
        double voltage = m_ControllerArm.calculate(absoluteShooterEncoder.getOutput()*(2*Math.PI), desiredPosition);
        armMotor.set(voltage);
        SmartDashboard.putNumber("shooterArmPosition", absoluteShooterEncoder.getOutput()*(2*Math.PI));
    }
}
