/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {

	public Joystick driverGamepad = new Joystick(Constants.DRIVER_GAMEPAD);
	public Joystick manipGamepad = new Joystick(Constants.MANIP_GAMEPAD);

	public RobotContainer() {
		configureButtonBindings();
	}

	private void configureButtonBindings() {
	}

	public Command getAutonomousCommand() {
		return null;
	}

}
