package frc.robot.commands.shooterCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.Variables;

public class shoot extends Command{
    private Timer shooterTimer = new Timer();
    public void initialize(){
        shooterTimer.start();
        while (true){
            if (shooterTimer.get() < 2){
                RobotContainer.m_ShooterRollersSubsystem.setIndexMotors(1);
                RobotContainer.m_IntakeRollerSubsystem.setMotor(-1);
            }else{
                RobotContainer.m_ShooterRollersSubsystem.setIndexMotors(0);
                RobotContainer.m_ShooterRollersSubsystem.setShooterMotors(0);
                RobotContainer.m_IntakeRollerSubsystem.setMotor(0);
                shooterTimer.stop();
                shooterTimer.reset();
                Variables.intakeHasNode = false;
                break;
            }
        }

    }
    public boolean isFinished(){
        return true;
    }
}
