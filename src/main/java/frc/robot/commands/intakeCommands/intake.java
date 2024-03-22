package frc.robot.commands.intakeCommands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.RobotContainer;
import frc.robot.Variables;

public class intake extends Command {
    private boolean isHolding;
    private intakeAmperage checkAMP = new intakeAmperage();
    public intake(boolean isHolding){
        this.isHolding = isHolding;
    }
    public void initialize(){
        if (isHolding && !Variables.intakeHasNode){
            RobotContainer.m_IntakeArmSubsystem.setIntakeArmPosition(-9.9);
            RobotContainer.m_IntakeRollerSubsystem.activateRollers(true);
            checkAMP.schedule();
        }else if (!isHolding && !Variables.intakeHasNode){
            checkAMP.cancel();
            RobotContainer.m_IntakeArmSubsystem.setIntakeArmPosition(0);
            RobotContainer.m_IntakeRollerSubsystem.activateRollers(false);
        }
    }
    public boolean isFinished(){
        return true;
    }
}
