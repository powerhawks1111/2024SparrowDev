package frc.robot.commands.shooterCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;

public class indexAmperage extends Command {
    private Timer indexTimer = new Timer();
    private boolean state;
    public void initialize(){
        state = false;
        indexTimer.start();
    }
    public boolean isFinished(){
        if (state){
            indexTimer.stop();
            indexTimer.reset();
        }
        return state;
    }
    public void execute(){
        double totalAmperage = RobotContainer.m_ShooterRollersSubsystem.getMotors()[0].getOutputCurrent() + RobotContainer.m_ShooterRollersSubsystem.getMotors()[1].getOutputCurrent();
        if (totalAmperage > 5 && indexTimer.get() > .20){
            RobotContainer.m_ShooterRollersSubsystem.setIndexMotors(0);
            RobotContainer.m_IntakeRollerSubsystem.setMotor(0);
            state = true;
        }
    }
    public void end(){
        indexTimer.stop();
        indexTimer.reset();
    }
}
