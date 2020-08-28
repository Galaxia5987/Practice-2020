package frc.robot.subsystems.Intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.Constants;
public class Intake {
    private TalonSRX talonSRX;
    private Solenoid piston;
    private State state;

    public Intake(){
        talonSRX = new TalonSRX(Constants.Intake.talonSRX);
        talonSRX.setInverted(Constants.Intake.isInverted);
        piston = new Solenoid(Constants.Intake.piston);
        state = State.CLOSED;
    }

    public void setPower(double power){
        talonSRX.set(ControlMode.PercentOutput,power);
    }

    public enum State{
        OPENED,
        CLOSED;
    }
}
