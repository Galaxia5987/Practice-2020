/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.drivetrain.Drivetrain;
import frc.robot.subsystems.drivetrain.commands.JoystickDrive;
import frc.robot.subsystems.turret.Turret;
import frc.robot.subsystems.turret.commands.JoystickTurret;
import frc.robot.subsystems.turret.commands.TurnTurret;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    public static XboxController Xbox = new XboxController(0);
    public JoystickButton a = new JoystickButton(Xbox, XboxController.Button.kA.value);
    public JoystickButton b = new JoystickButton(Xbox, XboxController.Button.kB.value);
    public static Joystick r = new Joystick(1);
    public static Joystick l = new Joystick(2);
    public JoystickButton c = new JoystickButton(r, 3);
    public JoystickButton d = new JoystickButton(r, 4);
    public JoystickButton f = new JoystickButton(r, 5);
    public JoystickButton s = new JoystickButton(r, 6);
    // The robot's subsystems and commands are defined here...


    public Drivetrain drivetrain = new Drivetrain();


    public Turret turret = new Turret();


    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        // Configure the button bindings
//        drivetrain.setDefaultCommand(new JoystickDrive(drivetrain));
      //  turret.setDefaultCommand(new JoystickTurret(turret));

        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings.  Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        c.whenPressed(new TurnTurret(turret, 20));
        d.whenPressed(new TurnTurret(turret, 0));
        f.whenPressed(new TurnTurret(turret, 30));
        s.whenPressed(new TurnTurret(turret, -30));
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
//    public Command getAutonomousCommand() {
//        return null;
//    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
//    public Command getAutonomousCommand() {
//        // An ExampleCommand will run in autonomous
//        return null;
//    }
    public static double getXboxLX() {
        return Xbox.getRawAxis(XboxController.Axis.kLeftX.value);
    }
}
