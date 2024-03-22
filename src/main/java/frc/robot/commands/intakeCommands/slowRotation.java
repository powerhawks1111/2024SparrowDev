package frc.robot.commands.intakeCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.commands.shooterCommands.indexAmperage;


public class slowRotation extends Command {
    private Timer slowRotationTimer = new Timer();
    private boolean state;
    public void initialize(){
        slowRotationTimer.start();
    }
    public boolean isFinished(){
        return state;
    }
    public void execute(){

        if (slowRotationTimer.get() < 1){
            RobotContainer.m_IntakeRollerSubsystem.setMotor(.13);
        }else{
            state = true;
            RobotContainer.m_ShooterRollersSubsystem.setIndexMotors(.3);
            RobotContainer.m_IntakeRollerSubsystem.setMotor(0);
            RobotContainer.m_IntakeRollerSubsystem.setMotor(-1);
            new indexAmperage().schedule();
        }
    }
    public void end(){
        slowRotationTimer.stop();
        slowRotationTimer.reset();
    }
}
