package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.Alinhador;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Shooter.VelocidadeShooter;
import frc.robot.commands.Alinhador.PararAlinhador;
    

import frc.robot.commands.Shooter.*;

public class RobotContainer {

    /* ===== SUBSYSTEM ===== */
    private final Shooter shooter = new Shooter();
    private final Alinhador Alinhador = new Alinhador();

    /* ===== CONTROLE ===== */
    private final XboxController xbox = new XboxController(0);

    /* ===== BOTÕES ===== */
    private final JoystickButton rb =
            new JoystickButton(xbox, XboxController.Button.kRightBumper.value);

    private final JoystickButton lb =
            new JoystickButton(xbox, XboxController.Button.kLeftBumper.value);

    private final JoystickButton btnA =
            new JoystickButton(xbox, XboxController.Button.kA.value);

    private final JoystickButton btnX =
            new JoystickButton(xbox, XboxController.Button.kX.value);

    private final JoystickButton btnB =
            new JoystickButton(xbox, XboxController.Button.kB.value);

    private final JoystickButton btnY =
            new JoystickButton(xbox, XboxController.Button.kY.value);
    private final Trigger rt =
    new Trigger(() -> xbox.getRightTriggerAxis() > 0.2);

    public RobotContainer() {
        configureBindings();
    }

    private void configureBindings() {

        /* ===== DIREÇÃO ===== */
        rb.whileTrue(new AtivarFrenteShooter(shooter));
        rb.onFalse(new PararShooter(shooter));
        lb.whileTrue(new AtivarAtrasShooter(shooter));
        lb.onFalse(new PararShooter(shooter));

        /* ===== PARAR ===== */
        btnA.onTrue(new PararShooter(shooter));

        /* ===== VELOCIDADES ===== */
        btnX.onTrue(new ShooterVelocidade(shooter, VelocidadeShooter.MEDIA));
        btnB.onTrue(new ShooterVelocidade(shooter, VelocidadeShooter.ALTA));
        btnY.onTrue(new ShooterVelocidade(shooter, VelocidadeShooter.TURBO));
        rt.onTrue(new PararAlinhador(Alinhador));
    }

    public Command getAutonomousCommand() {
        return null;
    }
}
