import scalafx.application.JFXApp3
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
import scalafx.scene.Scene
import scalafx.Includes._
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.control._



object alert1 extends JFXApp3{
    override def start() : Unit = {
        stage = new JFXApp3.PrimaryStage{
            new Alert(AlertType.Information){
                initOwner(stage)
                headerText = "Je suis une alert de dialogue tmtc"
                contentText = "J'ai un grand message pour toi !"
            }.showAndWait()
        }
    }
}