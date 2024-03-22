package frc.robot.commands.shooterCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class spoolShooter extends Command {
    public void initialize(){
        RobotContainer.m_ShooterArmSubsystem.positionArmShooter(0.662719615161288);
        RobotContainer.m_ShooterRollersSubsystem.setShooterMotors(1);
    }
    public boolean isFinished(){
        return true;
    }
}
