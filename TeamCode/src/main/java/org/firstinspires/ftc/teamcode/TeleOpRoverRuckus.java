package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

import java.util.Locale;

/**
 * Created by ashley.peake on 8/30/2018.
 * Modified by Julia Zhou
 */



@TeleOp (name= "TeleOpRoverRuckus", group= "Linear Opmode")
public class TeleOpRoverRuckus extends LinearOpMode {

    HardwareRoverRuckus Rover = new HardwareRoverRuckus();

    ElapsedTime runtime = new ElapsedTime();

    @Override

    public void runOpMode() {

        telemetry.addData("init pressed", "about to initialize");
        telemetry.update();

        Rover.initializeRobot(hardwareMap);


        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        waitForStart();


        while (opModeIsActive()) {


            double fwdBack = gamepad1.right_stick_y;
            double strafe = -gamepad1.right_stick_x;
            double turn = -gamepad1.left_stick_x;


            if (gamepad1.start) { // drive robot at slower speed for fine adjustments while carrying gold

                Rover.leftFront.setPower(-(fwdBack + strafe + turn) * 0.25);
                Rover.leftBack.setPower(-(fwdBack - strafe + turn) * 0.25);
                Rover.rightFront.setPower((fwdBack - strafe - turn) * 0.2);
                Rover.rightBack.setPower((-fwdBack + strafe - turn) * 0.2);


            }else{
                Rover.leftFront.setPower((fwdBack + strafe + turn)*.8);
                Rover.leftBack.setPower(-(fwdBack - strafe + turn) * .8);
                Rover.rightFront.setPower((fwdBack - strafe - turn) * 1);
                Rover.rightBack.setPower((fwdBack + strafe - turn)*1);
            }

            telemetry.addData("fwBack", "|%.3f|", fwdBack);
            telemetry.addData("strafe",  strafe);
            telemetry.addData("turn", turn);
            telemetry.update();



            /**Julia - try this, likely needs modification.
             * I have declared and initialized scissorLiftB in HardwareRoverRucks
             * The two lifts will move in the same direction together
             */

            if (gamepad2.dpad_down) {
                Rover.liftA(1.0);
                Rover.liftB(1.0);
            } else if (gamepad2.dpad_up) {
                Rover.liftA(-1.0);
                Rover.liftB(-1.0);
            } else {
                Rover.liftA(0);
                Rover.liftB(0);
            }


            if (gamepad1.right_bumper) {
                Rover.pinion(1);
            } else if (gamepad1.left_bumper) {
                Rover.pinion(-1);
            } else {
                Rover.pinion(0);
            }

            if (gamepad2.a) {
                Rover.clawA.setPosition(0.9);
                Rover.clawB.setPosition(0.9);
            } else if (gamepad2.b) {
                Rover.clawA.setPosition(0.5);
                Rover.clawB.setPosition(0.5);
            } else if (gamepad2.y) {
                Rover.clawA.setPosition(0);
                Rover.clawB.setPosition(0);
                }




}
    }
}











