package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports;

public class Intake extends SubsystemBase {
    private TalonSRX talonSRX;
    private Solenoid piston;
    private State state;

    /**
     * sets ports & sets talon inverted
     * sets talon's state
     */
    public Intake() {
        talonSRX = new TalonSRX(Ports.Intake.MOTOR);
        talonSRX.setInverted(Ports.Intake.IS_INVERTED);
        piston = new Solenoid(Ports.Intake.PISTON);
        state = State.CLOSE;
    }

    /**
     * @param power - power output (%)
     *              this function sets motor's power
     */
    public void setPower(double power) {
        talonSRX.set(ControlMode.PercentOutput, power);
    }

    /**
     * this function controls the piston
     */
    public void movePiston(State state) {
        piston.set(state == State.OPEN);
        this.state = state;
    }

    /**
     *
     * @return the state of the piston (CLOSED/OPENED)
     */
    public State getState() {
        return state;
    }

    /**
     * this function toggles the piston's state (opened --> closed || closed --> opened)
     */
    public void togglePiston() {
        movePiston(state == State.OPEN ? State.CLOSE : State.OPEN);
    }

    @Override
    public void periodic() {

    }


    /**
     * the piston's optional states
     */
    public enum State {
        OPEN,
        CLOSE;
    }
}
