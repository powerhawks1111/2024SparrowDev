package frc.robot.commands.intakeCommands;



import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.Variables;

public class intakeAmperage extends Command {
    private boolean finished = false;
    private Timer intakeTimer = new Timer();
    public void initialize(){
        finished = false;
        intakeTimer.start();
    }
    public void execute(){
        double totalAmperage = RobotContainer.m_IntakeRollerSubsystem.getMotors()[0].getOutputCurrent() + RobotContainer.m_IntakeRollerSubsystem.getMotors()[1].getOutputCurrent();
        if (totalAmperage > 10 && intakeTimer.get() > .5 && !Variables.intakeHasNode){
            Variables.intakeHasNode = true;
            RobotContainer.m_IntakeArmSubsystem.setIntakeArmPosition(0);
            RobotContainer.m_ShooterArmSubsystem.positionArmShooter(0.988694418639788);
            new slowRotation().schedule();
            finished = true;
        }
    }
    public boolean isFinished(){
        if (finished){
            intakeTimer.stop();
            intakeTimer.reset();
        }
        return finished;
    }
    public void end(){
        intakeTimer.stop();
        intakeTimer.reset();
    }
}
