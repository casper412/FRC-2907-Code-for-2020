
package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
//import edu.wpi.first.wpilibj.TalonSRX;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.ArcadeDrive;
import java.lang.Object;

public class Robot extends TimedRobot {

  private WPI_TalonSRX hopperLeft;
  private WPI_TalonSRX hopperRight;

  private WPI_TalonSRX shooterMaster;
  private WPI_TalonSRX shooterSlave1;
  private WPI_TalonSRX shooterSlave2;
  private WPI_TalonSRX shooterHood;

  private WPI_TalonSRX intakeMaster;

  private WPI_TalonSRX climbMaster;

  private Command m_driveCommand = new DriveCommand();
//Hello Sarah just hacked Spencer. Twice.d
  static NetworkTable limelight = NetworkTableInstance.getDefault().getTable("limelight");
  public static NetworkTableEntry tx = limelight.getEntry("tx");//target x position in camera
  public static NetworkTableEntry ty = limelight.getEntry("ty");//target y position in camera
  public static NetworkTableEntry ta = limelight.getEntry("ta");
  
  public static ArcadeDrive m_arcadeDrive = new ArcadeDrive();
  public static Autonomous m_autonomous = new Autonomous();
  public static RobotContainer m_robotContainer = new RobotContainer();
  public static AHRS gyro;
//lets git this hub yah yeet -C
//heres another comment yah yeet
  @Override
  public void robotInit() {
    shooterSlave1.follow(shooterMaster);
    shooterSlave2.follow(shooterMaster);

    m_robotContainer = new RobotContainer();
    m_driveCommand.schedule();
    m_autonomous.scheduleAuto();
    m_autonomous.getAutonomous();
    try {
    gyro = new AHRS();
    } catch(RuntimeException ex ) {
      ex.printStackTrace();
    }
  
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    SmartDashboard.putNumber("LimelightX", tx.getDouble(0.0));
    SmartDashboard.putNumber("LimelightY", ty.getDouble(0.0));
    m_autonomous.getAutonomous();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {
    m_autonomous.choosePicked();
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    m_driveCommand.schedule();
  }

  @Override
  public void teleopPeriodic() {

  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }

  public WPI_TalonSRX getHopperLeft() {
    return hopperLeft;
  }

  public WPI_TalonSRX getHopperRight() {
    return hopperRight;
  }

  public WPI_TalonSRX getShooterMaster() {
    return shooterMaster;
  }

  public WPI_TalonSRX getShooterHood() {
    return shooterHood;
  }

  public WPI_TalonSRX getIntake() {
    return intakeMaster;
  }

  public WPI_TalonSRX getClimb() {
    return climbMaster;
  }
}